/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Sony sony = new Sony();
    RCATv rcaTv = new RCATv();

    ConcreteRemote concreteRemoteForSony = new ConcreteRemote(sony);
    ConcreteRemote concreteRemoteForRcaTv = new ConcreteRemote(rcaTv);

    concreteRemoteForRcaTv.on();
    concreteRemoteForRcaTv.setChannel(1);

    concreteRemoteForRcaTv.setChannel(134);
    concreteRemoteForRcaTv.nextChannel();
    concreteRemoteForRcaTv.previousChannel();

    concreteRemoteForRcaTv.off();

    concreteRemoteForSony.on();
    concreteRemoteForSony.setChannel(20202);

    concreteRemoteForSony.setChannel(200);
    concreteRemoteForSony.nextChannel();
    concreteRemoteForSony.previousChannel();

    concreteRemoteForSony.off();
  }
}
