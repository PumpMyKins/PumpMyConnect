package fr.pmc;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.logging.Level;

import fr.pmc.core.utils.Logging;
import fr.pmc.servers.Server;
import fr.pmc.servers.ServersManager;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;

public class PumpMyConnectBungee extends Plugin {

	@Override
	public void onEnable() {
		
		Logging.setLogger(getLogger());
		
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
		
		ServersManager serverManager;
		try {
			serverManager = new ServersManager(this);
			
			for (ServerInfo server : getProxy().getServers().values()) {
				serverManager.addServer(new Server(server));			
			}
			
		} catch (IOException e) {			
			getLogger().log(Level.SEVERE, "PMC configuration: initializing servers.yml file error !");
			e.printStackTrace();			
			return;
		}	
		

		
	}
	
}
