package fr.pumpmyconnect;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import fr.pumpmyconnect.config.ConfigUtils;
import fr.pumpmyconnect.forcedhost.ForcedHostModule;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class MainConnect extends Plugin{

	private ConfigUtils configUtils;
	
	@Override
	public void onEnable() {
		
		this.configUtils = new ConfigUtils(this);
		this.configUtils.initDataFolder();
		
		this.getProxy().getPluginManager().registerCommand(this, new ReloadCommand(this,"pmc-reload"));
		
		File confFile = this.configUtils.initAndGetFile("config.yml");
		try {
			Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(confFile);
			
			if(config.getBoolean("forcedhost")) {
				
				getLogger().log(Level.INFO, "Forced Host module actived");
				// load Forced Hosts module
				ForcedHostModule forcedHostModule = new ForcedHostModule(this.configUtils.initAndGetFile("forcedhost.yml"));
								
				
			}
			
			if(config.getBoolean("pmc")) {
				
				// load Forced Hosts module
				
			}
			
			
			
		} catch (IOException e) {
			getLogger().log(Level.SEVERE, "Can't loading plugin configuration file !");
			e.printStackTrace();
			
			this.getProxy().stop();
		}
		
	}
	
	public void onReload() {
		
		this.onDisable();
		this.onEnable();
		
	}
	
	@Override
	public void onDisable() {
		
		this.configUtils = null;
		
	}
	
}
