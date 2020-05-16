package me.mvabo.enchantedmobs.mobs.types.water;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class WaterElemental extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    /**
     * Skeleton riding a guardian, blue chest and boots as well as a blue coral block, trident, shield.
     * @param e
     */
    public WaterElemental(Entity e) {
        if(e.getType() != EntityType.SKELETON) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.SKELETON);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Set Chestplate
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lcp = (LeatherArmorMeta) chestplate.getItemMeta();
        lcp.setColor(Color.BLUE);
        chestplate.setItemMeta(lcp);
        ee.setChestplate(chestplate);
        ee.setChestplateDropChance(0);

        //Set Boots
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lb = (LeatherArmorMeta) boots.getItemMeta();
        lb.setColor(Color.BLUE);
        chestplate.setItemMeta(lb);
        ee.setBoots(boots);
        ee.setBootsDropChance(0);

        //Equip mainHand
        ItemStack trident = new ItemStack(Material.TRIDENT, 1);
        ee.setItemInMainHand(trident);
        ee.setItemInMainHandDropChance(0);

        //Equip offHand
        ItemStack shield = new ItemStack(Material.SHIELD, 1);
        ee.setItemInOffHand(shield);
        ee.setItemInOffHandDropChance(0);

        //Make mount
        Entity mount = e.getWorld().spawnEntity(e.getLocation(), EntityType.GUARDIAN);
        mount.setPassenger(e);

        //Set custom name
        String name = plugin.getConfig().getString("waterElemental_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);

    }
}
