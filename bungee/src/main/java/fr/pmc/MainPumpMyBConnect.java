package fr.pmc;

import java.io.IOException;
import java.util.logging.Logger;

import fr.pmc.connectors.ConnectorsManager;
import fr.pmc.servers.ServersManager;
import net.md_5.bungee.api.plugin.Plugin;

public class MainPumpMyBConnect extends Plugin {

	public static Logger LOGGER;
	public static ServersManager SERVERS_MANAGER;
	public static ConnectorsManager CONNECTORS_MANAGER;

	public static ConfigManager CONFIG_MANAGER;

	@Override
	public void onEnable() {

		LOGGER = this.getLogger();

		try {
			
			CONFIG_MANAGER = new ConfigManager(this);	
			LOGGER.info("Configurations manager successfully loaded !");
			
		} catch (IOException e) {
			e.printStackTrace();
			this.getProxy().stop();
			return;
		}

		try {

			SERVERS_MANAGER = new ServersManager(this);
			LOGGER.info("Servers manager successfully loaded !");
			
		} catch (IOException e) {
			e.printStackTrace();
			this.getProxy().stop();
			return;
		}

		try {

			CONNECTORS_MANAGER = new ConnectorsManager(this);
			LOGGER.info("Connectors manager successfully loaded !");

		} catch (IOException e) {
			e.printStackTrace();
			this.getProxy().stop();
			return;
		}

	}

}
