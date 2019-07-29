package fr.pmc.servers.reloader;

import fr.pmc.servers.Server;

public class ReloaderAlreadyStartedException extends Exception {

	public ReloaderAlreadyStartedException(Server server) {
		super("Reloader already started for " + server.getName() + " server !");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -584347376981610438L;

}
