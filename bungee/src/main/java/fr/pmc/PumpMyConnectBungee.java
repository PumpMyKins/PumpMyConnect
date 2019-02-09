package fr.pmc;

import fr.pmc.core.utils.Logging;
import net.md_5.bungee.api.plugin.Plugin;

public class PumpMyConnectBungee extends Plugin {

	@Override
	public void onEnable() {
		
		Logging.setLogger(getLogger());
		
	}
	
}
