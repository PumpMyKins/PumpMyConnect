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
		
		if(this.servers.containsKey(server.getName())) {
			return;
		}
		
		String serverPath = "servers." + server.getName();
		
		if(this.getConfig().contains(serverPath)) {
			
			try {
				
				server.setState(ServerState.State.fromString(this.config.getString(serverPath + ".state")));
				
			} catch (ParsingStateException e) {
				
				getLogger().log(Level.SEVERE, "PMC configuration: parsing state error when getting from server[" + server.getName() + "] config !");
				e.printStackTrace();
				
				server.setState(ServerState.State.OFF());
				
			}
			server.setDisplayName(this.config.getString(serverPath + ".displayname"));
			server.setAutoCheck(this.config.getBoolean(serverPath + ".autocheck"));
			
		}else {
			
			this.config.set(serverPath + ".state", server.getState().toString());
			this.config.set(serverPath + ".displayname", server.getDisplayName());
			this.config.set(serverPath + ".autocheck", server.isAutoCheck());
			
			try {
				
				this.saveConfig();
				getLogger().info("PMC configuration: " + server.getName() + " added in configuration file");
				
			} catch (IOException e) {
				
				getLogger().log(Level.SEVERE, "PMC configuration: saving error when adding server[" + server.getName() + "] !");
				e.printStackTrace();
				return;
				
			}
			
		}
		
		this.servers.put(server.getName(), server);
		getLogger().info("PMC: " + server.getName() + " added in ServerManager.");
		
	}
	
	private void saveConfig() throws IOException {
		
		YamlConfiguration.getProvider(YamlConfiguration.class).save(this.config, this.configFile);
				
	}

	public HashMap<String, Server> getServers() {
		return servers;
	}
	
	public Configuration getConfig() {		
		return this.config;		
	}
	
}
