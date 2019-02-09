package fr.pmc.servers;

import java.util.HashMap;

public class ServersManager {

	private HashMap<String, Server> servers;

	public ServersManager() {
		
		this.servers = new HashMap<String, Server>();
		
	}
	
	public void addServer(Server server) {
		
		if(this.servers.containsKey(server.getName())) {
			return;
		}
		
		this.servers.put(server.getName(), server);
		
	}
	
	public HashMap<String, Server> getServers() {
		return servers;
	}
	
}
