package fr.pumpmyconnect;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class ReloadCommand extends Command {

	private Plugin plugin;
	
	public ReloadCommand(Plugin plugin,String name) {
		super(name);
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		((MainConnect) plugin).onReload();
		sender.sendMessage(new TextComponent("PumpMyConnect reload"));

	}

}
