package fr.pmc.connectors;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import fr.pmc.MainPumpMyBConnect;

public class ConnectorsManager {

	private HashMap<String, Connector> connectors;
	private ConnectorsManagerConfig managerConfig;

	public ConnectorsManager(MainPumpMyBConnect pumpMyConnectBungee) throws IOException {
		
		this.connectors = new HashMap<>();
		this.managerConfig = new ConnectorsManagerConfig(pumpMyConnectBungee);
		
		List<String> connectorsFiles = this.managerConfig.getConnectorsFiles();
		MainPumpMyBConnect.LOGGER.info("[ServersManager] " + connectorsFiles.size() + " connectors configuration file(s) found.");
		
		
		/*new ArrayList<>(pumpMyConnectBungee.getProxy().getConfigurationAdapter().getListeners()).get(0).getForcedHosts()
		
		for (Entry<String, ServerInfo> entry : pumpMyConnectBungee.getProxy().getConfigurationAdapter().getListeners()) {
			
			Server server = new Server(entry.getValue());
			if(serverFiles.contains(server.getName())) {
				this.managerConfig.loadFileInConnector(server);
				MainPumpMyBConnect.LOGGER.info("[ConnectorsManager]=> Server[" + server.getName() + "] successfully loaded File");
			}else {
				this.managerConfig.exportConnectorInFile(server);
				MainPumpMyBConnect.LOGGER.info("[ConnectorsManager]=> Server[" + server.getName() + "] successfully created File");
			}			
			this.connectors.put(entry.getKey(), server);
			
		}
		
		for (String string : serverFiles) {
			
			if(this.connectors.containsKey(string)) {
				continue;
			}
			
			MainPumpMyBConnect.LOGGER.warning("[ServersManagerConfig]=> Server[" + string + "] unused file found.");
			
		}*/
		
	}

	public ConnectorsManagerConfig getManagerConfig() {
		return managerConfig;
	}

	public HashMap<String,Connector> getConnectors() {
		return connectors;
	}
	
}
