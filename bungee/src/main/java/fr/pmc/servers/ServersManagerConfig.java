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
	
	public File getConfigFile() {
		return configFile;
	}

	public Configuration getConfig() {
		return config;
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
