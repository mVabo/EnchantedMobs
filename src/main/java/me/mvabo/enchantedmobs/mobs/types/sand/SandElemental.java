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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SandElemental extends Mob {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    public SandElemental(Entity e) {
        if(e.getType() != EntityType.HUSK) {
            Entity e2 = e.getWorld().spawnEntity(e.getLocation(), EntityType.HUSK);
            e.remove();
            e = (LivingEntity) e2;
        }

        //Equipment
        EntityEquipment ee = ((LivingEntity) e).getEquipment();

        //add potion effects
        ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 20, false, false));

        //Set skull
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer("null"));
        skull.setItemMeta(skullMeta);

        //Equip leather armor
        ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lcp = (LeatherArmorMeta) chestPlate.getItemMeta();
        lcp.setColor(Color.YELLOW);
        chestPlate.setItemMeta(lcp);
        ee.setChestplate(chestPlate);

        //Set custom name
        String name = plugin.getConfig().getString("sandElemental_name");
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
