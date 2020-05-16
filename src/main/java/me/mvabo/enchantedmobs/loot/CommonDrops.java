package me.mvabo.enchantedmobs.loot;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.FileManager;
import me.mvabo.enchantedmobs.items.ItemHandler;
import me.mvabo.enchantedmobs.mobs.types.jungle.Cannibal;
import me.mvabo.enchantedmobs.mobs.types.jungle.Illusioner;
import me.mvabo.enchantedmobs.mobs.types.jungle.TribalHunter;
import me.mvabo.enchantedmobs.mobs.types.plains.FallenBarbarian;
import me.mvabo.enchantedmobs.mobs.types.plains.Stalker;
import me.mvabo.enchantedmobs.mobs.types.sand.SandElemental;
import me.mvabo.enchantedmobs.mobs.types.snow.GhostOfTheTemplar;
import me.mvabo.enchantedmobs.mobs.types.snow.PossessedLumberjack;
import me.mvabo.enchantedmobs.mobs.types.water.SunkenPirate;
import me.mvabo.enchantedmobs.mobs.types.water.WaterElemental;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Random;

public class CommonDrops {

    FileManager loot = new FileManager();

    ItemHandler itemHandler;

    Random r = new Random();

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    public CommonDrops(Entity e, EntityDeathEvent event) {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        items.clear();
        event.getDrops().clear();
        if(e.getName().equals(plugin.getConfig().getString("cannibal_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_cannibal_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("illusioner_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_illusioner_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("tribalHunter_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_tribalHunter_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("fallenBarbarian_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_fallenBarbarian_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("stalker_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_stalker_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("sandElemental_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_sandElemental_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("ZombieThief_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_zombieThief_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("ghostOfTheTemplar_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_ghostOfTheTemplar_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("possessedLumberjack_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_possessedLumberjack_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("sunkenPirate_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_sunkenPirate_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        } else if (e.getName().equals(plugin.getConfig().getString("waterElemental_name"))) {
            for (String key : loot.getLootConfig().getStringList("common_waterElemental_drops")) {
                ItemStack item;
                if(key.startsWith("c")) {
                    item = new ItemHandler().getItem(key);
                } else {
                    item = new ItemStack(Material.getMaterial(key), 1);
                }
                items.add(item);
            }
            ItemStack i = items.get(r.nextInt(items.size()));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(i));
        }
    }
}
