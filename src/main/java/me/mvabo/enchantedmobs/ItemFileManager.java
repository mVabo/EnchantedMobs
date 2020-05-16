package me.mvabo.enchantedmobs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ItemFileManager {
    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    private FileConfiguration itemConfig;
    private File itemFile;

    public ItemFileManager() {
        saveDefaultItemTable();
    }

    public void setup() {
        if (!itemFile.exists()) {
            itemFile = new File(plugin.getDataFolder(), "items.yml");
        }

        itemConfig = YamlConfiguration.loadConfiguration(itemFile);

        InputStream defaultStream = plugin.getResource("items.yml");
        if(defaultStream != null) {
            YamlConfiguration c = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            itemConfig.setDefaults(c);
        }
    }

    public FileConfiguration getItemConfig() {
        if (this.itemConfig == null) {
            setup();
        }
        return itemConfig;
    }

    public void saveLootConfig() {
        if (this.itemConfig == null || this.itemFile == null) {
            return;
        }
        try {
            this.getItemConfig().save(this.itemFile);
        } catch (IOException e) {
            System.out.println(Color.RED + "Could not save items.yml");
        }
    }

    public void saveDefaultItemTable() {
        if (this.itemFile == null) {
            this.itemFile = new File(plugin.getDataFolder(), "items.yml");
        }

        if (!itemFile.exists()) {
            plugin.saveResource("items.yml", false);
        }
    }
}
