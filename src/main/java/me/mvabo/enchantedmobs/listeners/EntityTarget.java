package me.mvabo.enchantedmobs.listeners;

import me.mvabo.enchantedmobs.mobs.types.plains.Stalker;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class EntityTarget implements Listener {

    public void effectLooper(EntityTargetEvent e) {
        Entity entity = e.getEntity();
        Entity target = e.getTarget();
        if (entity instanceof Stalker && target instanceof Player) {
            entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_GHAST_SCREAM, 1, 1);
            Block b = entity.getLocation().getBlock();
            b.setType(Material.GRASS_PATH);
        }
    }
}
