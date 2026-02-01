#include <poll.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define INFTIM 10

#define MAX_NO_OF_HANDLES 100
typedef int Handle;

typedef Handle (*getHandleFunc)(void* instance);
typedef void (*handleEventFunc)(void* instance);

/**
 * @brief Event Handler.
 *
 * Pattern Role: Handler.
 * Encapsulates event handling logic.
 */
typedef struct EventHandler {
  void* instance;
  getHandleFunc getHandle;
  handleEventFunc handleEvent;
} EventHandler;

void Register(EventHandler* handler);

void Unregister(EventHandler* handler);

/**
 * @brief Diagnostics Server.
 *
 * Pattern Role: Concrete Handler.
 * Specific handler for diagnostic events.
 */
typedef struct DiagnosticsServer {
  Handle listeningSocket;
  EventHandler eventHandler;

} DiagnosticsServer;

static Handle getServerSocket(void* instance) {
  const DiagnosticsServer* server = instance;
  return server->listeningSocket;
}

static void handleConnectRequest(void* instance) {
  DiagnosticsServer* server = instance;
  printf(" Handling connecting request ...\n");
}

void DiagnosticsServer_ctor(DiagnosticsServer* const me, unsigned int port) {
  me->listeningSocket = 0; /* createServerSocket(tcpPort) */
  me->eventHandler.instance = me;
  me->eventHandler.getHandle = getServerSocket;
  me->eventHandler.handleEvent = handleConnectRequest;

  Register(&me->eventHandler);
}

/**
 * @brief Handler Registration.
 *
 * Pattern Role: Demultiplexer component.
 * Tracks registered handlers for event demultiplexing.
 */
typedef struct HandlerRegistration {
  EventHandler handler;
  struct pollfd fd;

} HandlerRegistration;

static HandlerRegistration registeredHandlers[MAX_NO_OF_HANDLES];

static void addToRegistry(EventHandler* handler);

static void removeFromRegistery(EventHandler* handler);

void Register(EventHandler* handler) { addToRegistry(handler); }
void Unregister(EventHandler* handler) { removeFromRegistery(handler); }

static size_t buildPollArray(struct pollfd* fds);

static EventHandler* findHandler(int fd);

static void dispatchSignalledHandles(const struct pollfd* fds,
                                     size_t noOfHandles) {
  size_t i = 0;
  for (i = 0; i < noOfHandles; i++) {
    if ((POLLRDNORM | POLLERR) & fds[i].revents) {
      EventHandler* signalledHandler = findHandler(fds[i].fd);

      if (NULL != signalledHandler) {
        signalledHandler->handleEvent(signalledHandler->instance);
      }
    }
  }
}

void HandleEvents(void) {
  struct pollfd fds[MAX_NO_OF_HANDLES] = {0};

  const size_t noOfHandles = buildPollArray(fds);

  if (0 < poll(fds, noOfHandles, INFTIM)) {
    dispatchSignalledHandles(fds, noOfHandles);

  } else {
    printf("error Poll failure\n");
  }
}

static void addToRegistry(EventHandler* handler) {
  // Stub
}

static void removeFromRegistery(EventHandler* handler) {
  // Stub
}

static size_t buildPollArray(struct pollfd* fds) {
  // Stub
  return 0;
}

static EventHandler* findHandler(int fd) {
  // Stub
  return NULL;
}

int main() {
  const unsigned int serverPort = 0xc001;
  DiagnosticsServer server;
  DiagnosticsServer_ctor(&server, serverPort);

  int i;
  for (i = 0; i < 10; i++) HandleEvents();
  return 0;
}
