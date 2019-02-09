package fr.pmc.servers;

import fr.pmc.core.servers.State;
import net.md_5.bungee.api.config.ServerInfo;

public class Server {

	private String name;
	private String displayName;
	
	private State state;
	private boolean autoCheck;
	
	private ServerInfo serverInfo;
	
	public Server(ServerInfo serverInfo) {
		
		this.serverInfo = serverInfo;
		
		this.name = this.serverInfo.getName();
		this.displayName = this.name;
		
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public ServerInfo getServerInfo() {
		return serverInfo;
	}

	public boolean isAutoCheck() {
		return autoCheck;
	}

	public void setAutoCheck(boolean autoCheck) {
		this.autoCheck = autoCheck;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
