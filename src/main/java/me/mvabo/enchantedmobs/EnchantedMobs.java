package me.mvabo.enchantedmobs;

import me.mvabo.enchantedmobs.commands.*;
import me.mvabo.enchantedmobs.listeners.EntityDeath;
import me.mvabo.enchantedmobs.listeners.EntityTarget;
import me.mvabo.enchantedmobs.mobs.SpawnHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnchantedMobs extends JavaPlugin implements Listener {

    public FileManager file;
    public ItemFileManager item;

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Manages the lootTable
        this.file = new FileManager();

        //Manages the items file
        this.item = new ItemFileManager();

        //get config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //Read config
        boolean enabled = getConfig().getBoolean("enabled");

        //Register general events
        Bukkit.getPluginManager().registerEvents(this,this);

        //Register other events
        Bukkit.getPluginManager().registerEvents(new EntityDeath(), this);
        Bukkit.getPluginManager().registerEvents(new EntityTarget(), this);
        Bukkit.getPluginManager().registerEvents(new SpawnHandler(), this);

        //Register commands
        this.getCommand("em").setExecutor(new EM());
        this.getCommand("em").setTabCompleter(new TabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
