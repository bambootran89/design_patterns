import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/** Reactor: event demultiplexer and dispatcher. */
public class Reactor implements Runnable {
  final Selector[] selectors;
  final ServerSocketChannel serverSocket;
  int next = 0;

  public Reactor(int port) throws IOException {
    selectors = new Selector[3];
    selectors[next] = Selector.open();

    serverSocket = ServerSocketChannel.open();
    serverSocket.socket().bind(new InetSocketAddress(port));
    serverSocket.configureBlocking(false);
    SelectionKey sk = serverSocket.register(selectors[0], SelectionKey.OP_ACCEPT);

    sk.attach(new Acceptor());
  }

  void dispatch(SelectionKey k) {
    Runnable r = (Runnable) k.attachment();
    if (r != null) {
      r.run();
    }
  }

  @Override
  public void run() {
    for (final Selector sels : selectors) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          while (!Thread.interrupted()) {
            try {
              sels.select();
              Set<SelectionKey> selected = sels.selectedKeys();

              Iterator<SelectionKey> it = selected.iterator();

              while (it.hasNext()) {
                dispatch((SelectionKey) (it.next()));
              }

              selected.clear();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      });

      thread.start();
    }
  }

  class Acceptor implements Runnable {
    @Override
    public synchronized void run() {
      SocketChannel c;
      try {
        c = serverSocket.accept();
        if (c != null) {
          new Handler(selectors[next], c);
          if (++next == selectors.length) {
            next = 0;
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
