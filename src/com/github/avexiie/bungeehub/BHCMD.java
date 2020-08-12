package com.github.avexiie.bungeehub;

import net.md_5.bungee.api.ChatColor; 
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BHCMD extends Command {
	public BHCMD() {
		super("bh", "bungeehub.admin", new String[]{"bungeehub"});
	}

	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage> /bungeehub reload"));
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				Main.getInstance().saveConfig();
				Main.getInstance().loadConfig();
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&8[&cBungeeHub&8]&7: Successfully reloaded the config.yml file!"));
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage> /bungeehub reload"));
			}
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage> /bungeehub reload"));
		}

	}
}