package me.mvabo.enchantedmobs.mobs.types.jungle;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Material.*;

public class Cannibal extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    /**
     * Pigzombies with diamond axe
     * @param e
     */
    public Cannibal(Entity e) {
        if(e.getType() != EntityType.PIG_ZOMBIE) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.PIG_ZOMBIE);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Equip axe
        ItemStack dAxe = new ItemStack(DIAMOND_AXE, 1);
        ee.setItemInMainHand(dAxe);
        ee.setItemInMainHandDropChance(0);

        //Set custom name
        String name = plugin.getConfig().getString("cannibal_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);
    }
}
