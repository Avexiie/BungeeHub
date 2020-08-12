package com.github.avexiie.bungeehub;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCMD extends Command {
	public HubCMD() {
		super("hub", (String) null, new String[]{"lobby"});
	}

	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		p.connect(ProxyServer.getInstance().getServerInfo(Main.getInstance().getConfig().getString("Hub")));
		if (Main.getInstance().getConfig().getBoolean("MSG-Enabled")) {
			p.sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Messages")));
		}

	}
}
