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
			this.main.getLogger().info("[Servers] Default configuration directory created !");
		}

		File folder = getDirectory();
		if (!folder.exists()) {

			folder.mkdir();

		}

	}

	public boolean isServerFileExist(Server server) {

		return new File(this.getDirectory() + File.separator + server.getName() + ".yml").exists();

	}

	public List<String> getServerFiles(){

		List<String> l = new ArrayList<String>();
		
		File folder = getDirectory();
		List<File> listOfFiles = new ArrayList<>(Arrays.asList(folder.listFiles()));
		
		for (File file : listOfFiles) {
			
			if(file.isFile() & file.getName().endsWith(".yml")) {
				l.add(file.getName().split(".yml")[0]);
			}
			
		}
		
		return l;
	}

	public void exportServerInFile(Server server) throws IOException {

		File serverFile = new File(getDirectory(), server.getName() + ".yml");
		if(!serverFile.exists()) {
			serverFile.createNewFile();
		}
		Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(serverFile);
		
		server.writeConfiguration(configuration);
		
		ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, serverFile);		

	}

	public void loadFileInServer(Server server) throws IOException {

		File serverFile = new File(getDirectory(), server.getName() + ".yml");
		if(!serverFile.exists()) {
			throw new IOException("File not found !");
		}
		Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(serverFile);
		
		server.readConfiguration(configuration);

	}

}
