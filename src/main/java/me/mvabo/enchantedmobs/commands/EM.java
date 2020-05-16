package me.mvabo.enchantedmobs.commands;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.FileManager;
import me.mvabo.enchantedmobs.ItemFileManager;
import me.mvabo.enchantedmobs.mobs.types.Mob;
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
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;

import java.awt.*;

public class EM implements CommandExecutor {

    Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);
    FileManager lootFile = new FileManager();
    ItemFileManager itemFile = new ItemFileManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length==0) {
            sender.sendMessage(ChatColor.YELLOW + "EnchantedMobs Info");
            sender.sendMessage(ChatColor.YELLOW + "/spawn to spawn an mob");
            sender.sendMessage(ChatColor.YELLOW + "Thats it");
            return true;
        } else if(args[0].equalsIgnoreCase("spawn")) {
            Location loc = ((Player) sender).getLocation();
            String mob = args[1];
            if (mob.equalsIgnoreCase("ZombieThief")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new ZombieThief(z);
            } else if (mob.equalsIgnoreCase("SandElemental")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new SandElemental(z);
            } else if (mob.equalsIgnoreCase("Cannibal")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Cannibal(z);
            } else if (mob.equalsIgnoreCase("illusioner")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Illusioner(z);
            } else if (mob.equalsIgnoreCase("TribalHunter")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new TribalHunter(z);
            } else if (mob.equalsIgnoreCase("FallenBarbarian")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new FallenBarbarian(z);
            } else if (mob.equalsIgnoreCase("Stalker")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new Stalker(z);
            } else if (mob.equalsIgnoreCase("ghostofthetemplar")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new GhostOfTheTemplar(z);
            } else if (mob.equalsIgnoreCase("possessedlumberjack")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new PossessedLumberjack(z);
            } else if (mob.equalsIgnoreCase("sunkenpirate")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new SunkenPirate(z);
            } else if (mob.equalsIgnoreCase("waterelemental")) {
                Zombie z = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Mob m = new WaterElemental(z);
            } else {
                sender.sendMessage(Color.RED + "Invalid mob name");
            }

            return true;
        } else if (args[0].equalsIgnoreCase("info") || args[0].length() < 2) {
            sender.sendMessage(ChatColor.YELLOW + "EnchantedMobs Info");
            sender.sendMessage(ChatColor.YELLOW + "/spawn to spawn an mob");
            sender.sendMessage(ChatColor.YELLOW + "Thats it");
            return true;
        } else if (args[0].equalsIgnoreCase("reload")) {
            plugin.getPluginLoader().disablePlugin(plugin);
            plugin.getPluginLoader().enablePlugin(plugin);
        }
        return false;
    }
}
