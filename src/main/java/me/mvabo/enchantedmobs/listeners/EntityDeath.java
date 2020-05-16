package me.mvabo.enchantedmobs.listeners;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.FileManager;
import me.mvabo.enchantedmobs.loot.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class EntityDeath implements Listener {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    Random r = new Random();

    @EventHandler
    public void doDrop(EntityDeathEvent event) {

        FileManager f = new FileManager();

        Entity e = event.getEntity();
        if (!(e instanceof Player)) {
            if (r.nextInt(100) < f.getLootConfig().getInt("common_droprate")) {
                CommonDrops drop = new CommonDrops(e, event);
            }
            if (r.nextInt(100) < f.getLootConfig().getInt("uncommon_droprate")) {
                UncommonDrops drop = new UncommonDrops(e, event);
            }
            if (r.nextInt(100) < f.getLootConfig().getInt("rare_droprate")) {
                RareDrops drop = new RareDrops(e, event);
            }
            if (r.nextInt(100) < f.getLootConfig().getInt("legendary_droprate")) {
                LegendaryDrops drop = new LegendaryDrops(e, event);
            }
        }
    }
}
