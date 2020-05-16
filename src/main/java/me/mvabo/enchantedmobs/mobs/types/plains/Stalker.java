package me.mvabo.enchantedmobs.mobs.types.plains;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Stalker extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    public Stalker(Entity e) {
        if(e.getType() != EntityType.CREEPER) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.CREEPER);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Set enchants
        ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 20, false, false));

        //Set custom name
        String name = plugin.getConfig().getString("stalker_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);
    }
}
