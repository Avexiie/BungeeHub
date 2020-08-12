package com.github.avexiie.bungeehub;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {
	private Configuration config;
	static Main instance;

	public static Main getInstance() {
		return instance;
	}

	public void onEnable() {
		instance = this;
		this.loadCommands();

		try {
			if (!this.getDataFolder().exists()) {
				this.getDataFolder().mkdir();
			}

			File file = new File(this.getDataFolder(), "config.yml");
			if (!file.exists()) {
				Files.copy(this.getResourceAsStream("config.yml"), file.toPath(), new CopyOption[0]);
			}

			this.loadConfig();
		} catch (IOException var2) {
			;
		}

	}

	public void loadConfig() {
		try {
			this.config = ConfigurationProvider.getProvider(YamlConfiguration.class)
					.load(new File(this.getDataFolder(), "config.yml"));
		} catch (IOException var2) {
			;
		}

	}

	public void saveConfig() {
		try {
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.getConfig(),
					new File(this.getDataFolder(), "config.yml"));
		} catch (IOException var2) {
			var2.printStackTrace();
		}

	}

	void loadCommands() {
		this.getProxy().getPluginManager().registerCommand(this, new HubCMD());
		this.getProxy().getPluginManager().registerCommand(this, new BHCMD());
	}

	public Configuration getConfig() {
		return this.config;
	}
}
