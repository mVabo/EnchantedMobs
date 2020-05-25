package me.mvabo.enchantedmobs.mobs.types.sand;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.Mob;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Material.IRON_AXE;

public class ZombieThief extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    public ZombieThief(Entity e) {
        if(e.getType() != EntityType.ZOMBIE) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //Set skull
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer("Wallabee"));
        skull.setItemMeta(skullMeta);

        //Equip skull
        ee.setHelmet(skull);

        //Modify skull drop chance
        ee.setHelmetDropChance(0);

        //Equip leather armor
        ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lcp = (LeatherArmorMeta) chestPlate.getItemMeta();
        lcp.setColor(Color.GRAY);
        chestPlate.setItemMeta(lcp);
        ee.setChestplate(chestPlate);

        //Equip axe
        ItemStack ironAxe = new ItemStack(IRON_AXE, 1);
        ee.setItemInMainHand(ironAxe);

        //Set custom name
        String name = plugin.getConfig().getString("ZombieThief_name");
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
