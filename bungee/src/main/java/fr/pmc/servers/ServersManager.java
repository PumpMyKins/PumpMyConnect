package fr.pmc.servers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import fr.pmc.core.servers.ServerState;
import fr.pmc.core.servers.ServerState.State.ParsingStateException;
import fr.pmc.core.utils.Logging;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

public class ServersManager extends Logging{
	
	private HashMap<String, Server> servers;
	
	private File configFile;
	private Configuration config;

	public ServersManager() {
		
		this.servers = new HashMap<String, Server>();	
		
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
