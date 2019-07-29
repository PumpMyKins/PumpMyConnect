package fr.pmc.servers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import fr.pmc.MainPumpMyBConnect;
import fr.pmc.servers.reloader.ServersReloaderManager;
import net.md_5.bungee.api.config.ServerInfo;

public class ServersManager{
	
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
