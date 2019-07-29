package fr.pmc.servers.reloader;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import fr.pmc.MainPumpMyBConnect;
import fr.pmc.servers.Server;
import net.md_5.bungee.api.scheduler.ScheduledTask;

public class ServersReloaderManager {

	private MainPumpMyBConnect mainPumpMyBConnect;
	private HashMap<String, ScheduledTask> pendingReloadingTask;

	public ServersReloaderManager(MainPumpMyBConnect mainPumpMyBConnect) {
		this.mainPumpMyBConnect = mainPumpMyBConnect;
		this.pendingReloadingTask = new HashMap<>();
	}
	
	public boolean hashStartedAutoReloader(Server server) {
		return this.pendingReloadingTask.containsKey(server.getName());
	}
	
	public void cancelAutoReloading(Server server) throws PendingReloaderNotFoundException {
		
		if(this.hashStartedAutoReloader(server)) {
			throw new PendingReloaderNotFoundException(server);
		}
		
		this.pendingReloadingTask.get(server.getName()).cancel();
		this.pendingReloadingTask.remove(server.getName());
		
	}
	
	public void appendReloader(Server server, TimeUnit timeunit, int i) throws ReloaderAlreadyStartedException {
		
		if(pendingReloadingTask.containsKey(server.getName())) {
			throw new ReloaderAlreadyStartedException(server);
		}
		
		MainPumpMyBConnect.LOGGER.info("ServerReloader[" + server.getName() + "] set in " + i + " " + timeunit.name());
		ScheduledTask task = this.mainPumpMyBConnect.getProxy().getScheduler().schedule(this.mainPumpMyBConnect, new Runnable() {
			
			@Override
			public void run() {
				
				pendingReloadingTask.remove(server.getName());
				server.reload();
				
				
			}
			
		}, i, timeunit);
		
		this.pendingReloadingTask.put(server.getName(), task);
		
	}

	public HashMap<String, ScheduledTask> getPendingReloadingTask() {
		return pendingReloadingTask;
	}
	
}
