package fr.pmc.servers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pmc.MainPumpMyBConnect;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class ServersManagerConfig {

	private MainPumpMyBConnect main;

	public ServersManagerConfig(MainPumpMyBConnect m) throws IOException {
		this.main = m;
		saveDefaultConfig();
	}

	private final File getDirectory() {
		return new File(this.main.getDataFolder(),"servers");
	}

	private void saveDefaultConfig() throws IOException	{

		if (!this.main.getDataFolder().exists()) {
			this.main.getDataFolder().mkdir();
			this.main.getLogger().info("Default configuration directory created !");
		}

		File folder = getDirectory();
		if (!folder.exists()) {

			folder.mkdir();

		}

	}

	public void writeServer(Server server) {
		
		
		
	}
	
	public Server readServer(String name) {
		
		return null;
		
	}
	
	public boolean containsServer(Server server) {
		
		return false;
		
	}
	
}
