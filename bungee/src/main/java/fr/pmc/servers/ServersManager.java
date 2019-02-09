package fr.pmc.servers;

import java.util.HashMap;

import fr.pmc.core.utils.Logging;

public class ServersManager extends Logging{
	
	private HashMap<String, Server> servers;

	public ServersManager() {
		
		this.servers = new HashMap<String, Server>();
		
	}
	
	public void addServer(Server server) {
		
		if(this.servers.containsKey(server.getName())) {
			return;
		}
		
		this.servers.put(server.getName(), server);
		getLogger().info("PMC: " + server.getName() + " added in ServerManager.");
		
		
	}
	
	public HashMap<String, Server> getServers() {
		return servers;
	}
	
}
