package net.boboman13.raw_tcp_proxy;

import java.util.HashSet;

/**
 * @author boboman13
 */
public class RegistryManager {
    private HashSet<Registry> clients = new HashSet<Registry>();
    private Proxy proxy;

    /**
     * Creates the RegistryManager instance.
     *
     * @param proxy
     */
    public RegistryManager(Proxy proxy) {
        this.proxy = proxy;
    }

    /**
     * Adds a Client to the Registry.
     *
     * @param client
     */
    public void addClient(Registry client) {
        clients.add(client);
    }

    /**
     * Removes a Client from the Registry.
     *
     * @param client
     */
    public void removeClient(Registry client) {
        clients.remove(client);
    }

}
