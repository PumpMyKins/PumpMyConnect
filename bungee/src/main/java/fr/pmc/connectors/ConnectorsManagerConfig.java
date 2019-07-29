package fr.pmc.connectors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pmc.MainPumpMyBConnect;
import fr.pmc.servers.Server;
import fr.pmc.utils.ManagerConfig;

public class ConnectorsManagerConfig extends ManagerConfig{

	private MainPumpMyBConnect main;

	public ConnectorsManagerConfig(MainPumpMyBConnect m) throws IOException {
		this.main = m;
		saveDefaultConfig();
	}

	public File getDirectory() {
		return new File(this.main.getDataFolder(),"connectors");
	}

	private void saveDefaultConfig() throws IOException	{

		if (!this.main.getDataFolder().exists()) {
			this.main.getDataFolder().mkdir();
			this.main.getLogger().info("[Connectors] Default configuration directory created !");
		}

		File folder = getDirectory();
		if (!folder.exists()) {

			folder.mkdir();

		}

	}

	public boolean isConnectorFileExist(Server server) {

		return new File(this.getDirectory() + File.separator + server.getName() + ".yml").exists();

	}

	public List<String> getConnectorsFiles(){

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

	public void exportConnectorInFile(Connector connector) throws IOException {
		this.exportInFile(connector);
	}

	public void loadFileInConnector(Connector connector) throws IOException {
		this.loadFileIn(connector);
	}
	
}
