package fr.pmc;

import java.io.IOException;
import java.util.logging.Logger;

import fr.pmc.servers.ServersManager;
import net.md_5.bungee.api.plugin.Plugin;

public class MainPumpMyBConnect extends Plugin {

	public static Logger LOGGER;
	public static ServersManager SERVERS_MANAGER;

	@Override
	public void onEnable() {
		
		LOGGER = this.getLogger();
		
		try {
			
			ServersManager manager = new ServersManager(this);
			manager.init();
			SERVERS_MANAGER = manager;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getProxy().stop();
			return;
		}
		
		
	}
	
}
