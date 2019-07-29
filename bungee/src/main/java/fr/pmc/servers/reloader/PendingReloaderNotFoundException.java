package fr.pmc.servers.reloader;

import fr.pmc.servers.Server;

public class PendingReloaderNotFoundException extends Exception {

	public PendingReloaderNotFoundException(Server server) {
		super("Can't find started reloader for " + server.getName() + " server !");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8298919562959255688L;

}
