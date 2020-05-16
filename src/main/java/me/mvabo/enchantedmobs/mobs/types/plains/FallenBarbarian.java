package me.mvabo.enchantedmobs.mobs.types.plains;

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

public class FallenBarbarian extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    /**
     * Zombie with a golden axe, iron boots and iron chest, able to leap at enemies.
     * @param e
     */
    public FallenBarbarian(Entity e) {
        if(e.getType() != EntityType.ZOMBIE) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Set boots
        ItemStack boots = new ItemStack(Material.IRON_BOOTS,1);
        ee.setBoots(boots);
        ee.setBootsDropChance(0);

        //Set item in main hand
        ItemStack axe = new ItemStack(Material.GOLDEN_AXE, 1);
        ee.setItemInMainHand(axe);
        ee.setItemInMainHandDropChance(0);

        //Set chestplate
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ee.setChestplate(chestplate);
        ee.setChestplateDropChance(0);

        //Set custom name
        String name = plugin.getConfig().getString("fallenBarbarian_name");
        e.setCustomName(name);

        //Set meta data
        e.setMetadata(name, new FixedMetadataValue(plugin, 0));
        e.setMetadata("EnchantedMobs", new FixedMetadataValue(plugin, 0));

        //Decide if mob can pick up items
        ((LivingEntity) e).setCanPickupItems(false);
    }
}
