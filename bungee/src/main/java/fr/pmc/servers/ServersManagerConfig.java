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

	private File configFile;
	private Configuration config;
	
	public ServersManagerConfig(PumpMyConnectBungee pumpMyConnectBungee) throws IOException {
		
		configFile = new File(pumpMyConnectBungee.getDataFolder(), "servers.yml");
        if (!configFile.exists()) {
            configFile.createNewFile();
        }
        
        this.config = YamlConfiguration.getProvider(YamlConfiguration.class).load(this.configFile);
        
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
