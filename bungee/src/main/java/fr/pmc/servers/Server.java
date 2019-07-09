package fr.pmc.servers;

import fr.pmc.core.servers.ServerState;
import fr.pmc.core.servers.ServerState.State;
import net.md_5.bungee.api.config.ServerInfo;

public class Server {

	private String name;
	private String displayName;
	
	private ServerInfo serverInfo;
	
	
	
	public Server(ServerInfo serverInfo) {
		
		this.serverInfo = serverInfo;
		
		this.name = this.serverInfo.getName();
		this.displayName = this.name;
		
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
