package fr.pmc.servers;

import java.io.IOException;
import java.util.HashMap;

import fr.pmc.PumpMyConnectBungee;
import fr.pmc.core.utils.Logging;

public class ServersManager extends Logging{
	
	private HashMap<String, Server> servers;
	private ServersManagerConfig config;


	public ServersManager(PumpMyConnectBungee pumpMyConnectBungee) throws IOException {
		
		this.servers = new HashMap<String, Server>();	
		this.config = new ServersManagerConfig(pumpMyConnectBungee);
		
	}
	
	public void addServer(Server server) {
		
		
		
	}

	public HashMap<String, Server> getServers() {
		return servers;
	}
	
	public ServersManagerConfig getConfig() {		
		return this.config;		
	}
	
}
