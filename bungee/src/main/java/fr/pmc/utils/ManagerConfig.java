package fr.pmc.utils;

import java.io.File;
import java.io.IOException;

import fr.pmc.servers.Server;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public abstract class ManagerConfig {

	public abstract File getDirectory();
	
	public void exportInFile(IConnectable connectable) throws IOException {

		File serverFile = new File(getDirectory(), connectable.getName() + ".yml");
		if(!serverFile.exists()) {
			serverFile.createNewFile();
		}
		Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(serverFile);
		
		connectable.writeConfiguration(configuration);
		
		ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, serverFile);		

	}

	public void loadFileIn(IConnectable connectable) throws IOException {

		File serverFile = new File(getDirectory(), connectable.getName() + ".yml");
		if(!serverFile.exists()) {
			throw new IOException("File not found !");
		}
		Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(serverFile);
		
		connectable.readConfiguration(configuration);

	}
	
}
