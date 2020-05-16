package me.mvabo.enchantedmobs.mobs.types.snow;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class PossessedLumberjack extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    /**
     * Pillager with a stone axe
     * @param e
     */
    public PossessedLumberjack(Entity e) {
        if(e.getType() != EntityType.PILLAGER) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.PILLAGER);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Equip axe
        ItemStack axe = new ItemStack(Material.STONE_AXE, 1);
        ee.setItemInMainHand(axe);
        ee.setItemInMainHandDropChance(0);

        //Set custom name
        String name = plugin.getConfig().getString("possessedLumberjack_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);

    }
}
