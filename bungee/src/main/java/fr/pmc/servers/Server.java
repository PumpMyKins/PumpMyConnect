package fr.pmc.servers;

import java.util.concurrent.TimeUnit;

import fr.pmc.MainPumpMyBConnect;
import fr.pmc.servers.reloader.ReloaderAlreadyStartedException;
import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.ModInfo;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.config.Configuration;

public class Server {

	private String name;	
	private Server.State state;	
	private ServerInfo serverInfo;

	private Protocol version;
	private Players players;
	private ModInfo modInfo;

	public Server(ServerInfo serverInfo) {

		this.setServerInfo(serverInfo);	

	}

	public Server.State getState() {
		return state;
	}

	public String getName() {
		return name;
	}

	public ServerInfo getServerInfo() {
		return serverInfo;
	}

	public Protocol getVersion() {
		return version;
	}

	public Players getPlayers() {
		return players;
	}

	public ModInfo getModInfo() {
		return modInfo;
	}

	public void setServerInfo(ServerInfo serverInfo) {
		this.state = State.UNKNOWN;
		this.serverInfo = serverInfo;
		this.name = serverInfo.getName();
		this.reload();
	}	

	public enum State {
		UNKNOWN,
		UNREACHABLE,
		PENDING,
		REACHABLE		
	}

	private Server get() {
		return this;
	}

	public void reload() {

		this.state = State.PENDING;

		this.serverInfo.ping(new Callback<ServerPing>() {

			@Override
			public void done(ServerPing result, Throwable error) {

				MainPumpMyBConnect.LOGGER.info("Server[" + name + "] starting reload !");

				if(result == null || error != null) {					
					state = State.UNREACHABLE;
					try {
						MainPumpMyBConnect.SERVERS_MANAGER.getReloaderManager().appendReloader(get(),TimeUnit.MINUTES,5);
					} catch (ReloaderAlreadyStartedException e) {
						e.printStackTrace();
					}
					return;
				}else {
					state = State.REACHABLE;
					version = result.getVersion();
					players = result.getPlayers();
					modInfo = result.getModinfo();
				}
				
				MainPumpMyBConnect.LOGGER.info("Server[" + name + "] successfully reloaded : " + state.name());
				
			}

		});

	}

}
