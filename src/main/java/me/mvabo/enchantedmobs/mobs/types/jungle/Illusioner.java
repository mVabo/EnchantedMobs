package me.mvabo.enchantedmobs.mobs.types.jungle;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class Illusioner extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    public Illusioner(Entity e) {
        if(e.getType() != EntityType.ILLUSIONER) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ILLUSIONER);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Set custom name
        String name = plugin.getConfig().getString("illusioner_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);
    }
}
