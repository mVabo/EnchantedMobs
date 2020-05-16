package me.mvabo.enchantedmobs.mobs.types;


import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.jungle.Cannibal;
import me.mvabo.enchantedmobs.mobs.types.jungle.Illusioner;
import me.mvabo.enchantedmobs.mobs.types.jungle.TribalHunter;
import me.mvabo.enchantedmobs.mobs.types.plains.FallenBarbarian;
import me.mvabo.enchantedmobs.mobs.types.plains.Stalker;
import me.mvabo.enchantedmobs.mobs.types.sand.SandElemental;
import me.mvabo.enchantedmobs.mobs.types.sand.ZombieThief;
import me.mvabo.enchantedmobs.mobs.types.snow.GhostOfTheTemplar;
import me.mvabo.enchantedmobs.mobs.types.snow.PossessedLumberjack;
import me.mvabo.enchantedmobs.mobs.types.water.SunkenPirate;
import me.mvabo.enchantedmobs.mobs.types.water.WaterElemental;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class TypeManager {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

    Random r = new Random();

    public TypeManager(Entity e, String type) {
        if (type.equals("Sand")) {
            int choice = r.nextInt(1);
            if (choice == 0) {
                if(r.nextInt(100) < plugin.getConfig().getInt("SandElemental_chance") && plugin.getConfig().getBoolean("SandElemental")) {
                    Mob m = new SandElemental(e);
                }
            } else {
                if(r.nextInt(100) < plugin.getConfig().getInt("ZombieThief_chance") && plugin.getConfig().getBoolean("ZombieThief")) {
                    Mob m = new ZombieThief(e);
                }
            }
        } else if (type.equals("Plains")) {
            int choice = r.nextInt(1);
            if (choice == 0) {
                if(r.nextInt(100) < plugin.getConfig().getInt("FallenBarbarian_chance") && plugin.getConfig().getBoolean("FallenBarbarian")) {
                    Mob m = new FallenBarbarian(e);
                }
            } else {
                if(r.nextInt(100) < plugin.getConfig().getInt("Stalker_chance") && plugin.getConfig().getBoolean("Stalker")) {
                    Mob m = new Stalker(e);
                }
            }
        } else if (type.equals("Jungle")) {
            int choice = r.nextInt(2);
            if (choice == 0) {
                if(r.nextInt(100) < plugin.getConfig().getInt("Cannibal_chance") && plugin.getConfig().getBoolean("Cannibal")) {
                    Mob m = new Cannibal(e);
                }
            } else if (choice == 1 ) {
                if(r.nextInt(100) < plugin.getConfig().getInt("Illusioner_chance") && plugin.getConfig().getBoolean("Illusioner")) {
                    Mob m = new Illusioner(e);
                }
            } else {
                if(r.nextInt(100) < plugin.getConfig().getInt("TribalHunter_chance") && plugin.getConfig().getBoolean("TribalHunter")) {
                    Mob m = new TribalHunter(e);
                }
            }

        } else if (type.equals("Snow")) {
            int choice = r.nextInt(1);
            if (choice == 0) {
                if(r.nextInt(100) < plugin.getConfig().getInt("GhostOfTheTemplar_chance") && plugin.getConfig().getBoolean("GhostOfTheTemplar")) {
                    Mob m = new GhostOfTheTemplar(e);
                }
            } else {
                if(r.nextInt(100) < plugin.getConfig().getInt("PossessedLumberjack_chance") && plugin.getConfig().getBoolean("PossessedLumberjack")) {
                    Mob m = new PossessedLumberjack(e);
                }
            }
        } else if(type.equals("Water")) {
            int choice = r.nextInt(1);
            if (choice == 0) {
                if(r.nextInt(100) < plugin.getConfig().getInt("SunkenPirate_chance") && plugin.getConfig().getBoolean("SunkenPirate")) {
                    Mob m = new SunkenPirate(e);
                }
            } else {
                if(r.nextInt(100) < plugin.getConfig().getInt("WaterElemental_chance") && plugin.getConfig().getBoolean("WaterElemental")) {
                    Mob m = new WaterElemental(e);
                }
            }
        }
    }
}
