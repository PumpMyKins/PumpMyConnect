package fr.pmc;

import fr.pmc.core.utils.Logging;
import fr.pmc.servers.Server;
import fr.pmc.servers.ServersManager;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;

public class PumpMyConnectBungee extends Plugin {

	@Override
	public void onEnable() {
		
		Logging.setLogger(getLogger());
		
		ServersManager serverManager = new ServersManager();		
		for (ServerInfo iterable_element : getProxy().getServers().values()) {
			serverManager.addServer(new Server(iterable_element));			
		}
		
	}
	
}
