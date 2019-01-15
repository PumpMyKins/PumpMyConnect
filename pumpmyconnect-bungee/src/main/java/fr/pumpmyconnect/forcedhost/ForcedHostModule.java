package fr.pumpmyconnect.forcedhost;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class ForcedHostModule {

	private File file;
	private Configuration config;
	
	private HashMap<String, String> forcedHosts;
	
	public ForcedHostModule(File file) throws IOException {
		
		this.file = file;
		this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
		
		for (String string : this.config.getKeys()) {
			
			System.out.println(string);
			
		}
		
	}

	
	
}
