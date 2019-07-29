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
	private ServersManagerConfig managerConfig;
	private ServersReloaderManager reloaderManager;

	public ServersManager(MainPumpMyBConnect pumpMyConnectBungee) throws IOException {
		
		this.servers = new HashMap<String, Server>();
		this.managerConfig = new ServersManagerConfig(pumpMyConnectBungee);
		this.reloaderManager = new ServersReloaderManager(pumpMyConnectBungee);
		
		List<String> serverFiles = this.managerConfig.getServerFiles();
		MainPumpMyBConnect.LOGGER.info("[ServersManager] " + serverFiles.size() + " server configuration file(s) found.");
		
		for (Entry<String, ServerInfo> entry : pumpMyConnectBungee.getProxy().getServers().entrySet()) {
			
			Server server = new Server(entry.getValue());
			if(serverFiles.contains(server.getName())) {
				this.managerConfig.loadFileInServer(server);
				MainPumpMyBConnect.LOGGER.info("[ServersManager]=> Server[" + server.getName() + "] successfully loaded File");
			}else {
				this.managerConfig.exportServerInFile(server);
				MainPumpMyBConnect.LOGGER.info("[ServersManager]=> Server[" + server.getName() + "] successfully created File");
			}			
			this.servers.put(entry.getKey(), new Server(entry.getValue()));
			
		}
		
		for (String string : serverFiles) {
			
			if(this.servers.containsKey(string)) {
				continue;
			}
			
			MainPumpMyBConnect.LOGGER.warning("[ServersManagerConfig]=> Server[" + string + "] unused file found.");
			
		}
		
	}

	public HashMap<String, Server> getServers() {
		return servers;
	}
	
	public ServersManagerConfig getConfig() {		
		return this.config;		
	}
	
}
