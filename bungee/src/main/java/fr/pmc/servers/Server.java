package fr.pmc.servers;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.ModInfo;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.config.ServerInfo;

public class Server {

	private String name;	
	private Server.State state;	
	private ServerInfo serverInfo;
	
	private Protocol version;
	private Players players;
	private ModInfo modInfo;
	
	public Server(ServerInfo serverInfo) {
		
		this.setServerInfo(serverInfo);	
		this.name = this.serverInfo.getName();
		
	}

	public Server.State getState() {
		return state;
	}

	public String getName() {
		return name;
	}
	
	public enum State {
		UNKNOWN,
		UNREACHABLE,
		PENDING,
		REACHABLE		
	}
	
	
	
}
