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

                String data = new String(request, "UTF-8");
                registry.getProxy().debug("S -> C: " + data);
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
