package me.mvabo.enchantedmobs.mobs.types.snow;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class GhostOfTheTemplar extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    /**
     * Stray with iron boots, chest, iron sword,and  shield.
     * A ghost that been cursed to live again as a damned soul.
     * @param e
     */
    public GhostOfTheTemplar(Entity e) {
        if(e.getType() != EntityType.STRAY) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.STRAY);
            e.remove();
            e = (LivingEntity)e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Equip armor
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ee.setChestplate(chestplate);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
        ee.setBoots(boots);
        ee.setBootsDropChance(0);
        ee.setChestplateDropChance(0);

        //Equip axe
        ItemStack isword = new ItemStack(Material.IRON_SWORD, 1);
        ee.setItemInMainHand(isword);
        ee.setItemInMainHandDropChance(0);

        //Equip shield
        ItemStack shield = new ItemStack(Material.SHIELD, 1);
        ee.setItemInOffHand(shield);
        ee.setItemInOffHandDropChance(0);

        //Set custom name
        String name = plugin.getConfig().getString("ghostOfTheTemplar_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);

        //To prevent lag
        ((LivingEntity) e).setRemoveWhenFarAway(true);

    }
}
