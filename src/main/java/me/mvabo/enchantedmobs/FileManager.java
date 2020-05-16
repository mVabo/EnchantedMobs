package me.mvabo.enchantedmobs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileManager {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    private FileConfiguration lootConfig;
    private File lootFile;

    public FileManager() {
        saveDefaultLootTable();
    }

    public void setup() {
        if (!lootFile.exists()) {
            lootFile = new File(plugin.getDataFolder(), "lootTable.yml");
        }

        lootConfig = YamlConfiguration.loadConfiguration(lootFile);

        InputStream defaultStream = plugin.getResource("lootTable.yml");
        if(defaultStream != null) {
            YamlConfiguration c = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            lootConfig.setDefaults(c);
        }
    }

    public FileConfiguration getLootConfig() {
        if (this.lootConfig == null) {
            setup();
        }
        return lootConfig;
    }

    public void saveLootConfig() {
        if (this.lootConfig == null || this.lootFile == null) {
            return;
        }
        try {
            this.getLootConfig().save(this.lootFile);
        } catch (IOException e) {
            System.out.println(Color.RED + "Could not save lootTable.yml");
        }
    }

    public void saveDefaultLootTable() {
        if (this.lootFile == null) {
            this.lootFile = new File(plugin.getDataFolder(), "lootTable.yml");
        }

        if (!lootFile.exists()) {
            plugin.saveResource("lootTable.yml", false);
        }
    }

}
