package me.mvabo.enchantedmobs.mobs.types.water;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class SunkenPirate extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    /**
     * Drowned with stone sword and blue boots with depth striders
     * @param e
     */
    public SunkenPirate(Entity e) {
        if(e.getType() != EntityType.DROWNED) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.DROWNED);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Set armor
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(Color.BLUE);
        boots.setItemMeta(bootsMeta);
        boots.addEnchantment(Enchantment.DEPTH_STRIDER, 2);
        ee.setBoots(boots);
        ee.setBootsDropChance(0);

        //Set sword
        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
        ee.setItemInMainHand(sword);
        ee.setItemInMainHandDropChance(0);

        //Set custom name
        String name = plugin.getConfig().getString("sunkenPirate_name");
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
