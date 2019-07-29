package fr.pmc.servers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pmc.MainPumpMyBConnect;
import fr.pmc.utils.ManagerConfig;

public class ServersManagerConfig extends ManagerConfig{

	private MainPumpMyBConnect main;

	public ServersManagerConfig(MainPumpMyBConnect m) throws IOException {
		this.main = m;
		saveDefaultConfig();
	}

	public File getDirectory() {
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
		this.exportInFile(server);
	}

	public void loadFileInServer(Server server) throws IOException {
		this.loadFileIn(server);
	}

}
