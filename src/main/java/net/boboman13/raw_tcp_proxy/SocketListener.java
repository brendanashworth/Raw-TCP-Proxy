package net.boboman13.raw_tcp_proxy;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * @author boboman13
 */
public class SocketListener implements Runnable {

    private Registry registry;
    private boolean isRunning = true;

    /**
     * Create the SocketListener
     *
     * @param registry The Registry client.
     */
    public SocketListener(Registry registry) {
        this.registry = registry;
    }

    /**
     * Called as a different thread.
     */
    public void run() {
        try {
            String line = null;

            final byte[] request = new byte[1024];
            int bytesRead;

            while (isRunning && (bytesRead = registry.serverIn.read(request)) != -1) {
                registry.clientOut.write(request, 0, bytesRead);
                registry.clientOut.flush();

                // It may seem obscure to surround it by an if loop, but otherwise we are forced to create a new String object; the parsing to UTF-8 causes some speed issues.
                if(registry.getProxy().getDebug()) {
                    registry.getProxy().debug("S -> C: " + new String(request, "UTF-8"));
                }

            }

            // The server socket ended!
            registry.kill();

        } catch (IOException ex) {
            if(ex instanceof SocketTimeoutException) {
                // The socket simply timed out. Kill, then exit.
                registry.kill();
                return;
            }

            //ex.printStackTrace();
            this.kill();
        }
    }

    /**
     * Stops the processing.
     */
    public void kill() {
        isRunning = false;
    }

}
