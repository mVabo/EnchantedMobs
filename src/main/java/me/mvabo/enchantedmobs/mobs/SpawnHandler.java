package me.mvabo.enchantedmobs.mobs;

import me.mvabo.enchantedmobs.EnchantedMobs;
import me.mvabo.enchantedmobs.mobs.types.TypeManager;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpawnHandler implements Listener {

    @EventHandler
    public void spawnMobs(CreatureSpawnEvent event) {
        Entity e = event.getEntity();
        Biome b = e.getLocation().getBlock().getBiome();

        Plugin plugin = EnchantedMobs.getPlugin(EnchantedMobs.class);

        TypeManager t;

        Random chance = new Random();

        List<String> worlds = plugin.getConfig().getStringList("worlds");

        try{
            for(int i = 0; i < worlds.size(); i++) {
                if(e.getWorld().getName().equals(worlds.get(i))){
                    if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)) {
                        if (!e.hasMetadata("EnchantedMobs")) {
                            if (b.equals(Biome.DESERT)
                                    || b.equals(Biome.BADLANDS)
                                    || b.equals(Biome.BADLANDS_PLATEAU)) {
                                if(chance.nextInt(3)==0) {
                                    t = new TypeManager(e, "Sand");
                                }
                            } else if (b.equals(Biome.JUNGLE)
                                    || b.equals(Biome.JUNGLE_EDGE)
                                    || b.equals(Biome.JUNGLE_HILLS)) {
                                if(chance.nextInt(3)==0) {
                                    t = new TypeManager(e, "Jungle");
                                }
                            } else if (b.equals(Biome.PLAINS)) {
                                if(chance.nextInt(3)==0) {
                                    t = new TypeManager(e, "Plains");
                                }
                            } else if (b.equals(Biome.SNOWY_BEACH)
                                    || b.equals(Biome.SNOWY_MOUNTAINS)
                                    || b.equals(Biome.SNOWY_TAIGA)
                                    || b.equals(Biome.SNOWY_TAIGA_HILLS)
                                    || b.equals(Biome.SNOWY_TAIGA_MOUNTAINS)
                                    || b.equals(Biome.SNOWY_TUNDRA)) {
                                if(chance.nextInt(3)==0) {
                                    t = new TypeManager(e, "Snow");
                                }
                            } else if (b.equals(Biome.OCEAN)
                                    || b.equals(Biome.COLD_OCEAN)
                                    || b.equals(Biome.DEEP_COLD_OCEAN)
                                    || b.equals(Biome.DEEP_FROZEN_OCEAN)
                                    || b.equals(Biome.DEEP_LUKEWARM_OCEAN)
                                    || b.equals(Biome.DEEP_OCEAN)
                                    || b.equals(Biome.DEEP_WARM_OCEAN)
                                    || b.equals(Biome.FROZEN_OCEAN)
                                    || b.equals(Biome.LUKEWARM_OCEAN)
                                    || b.equals(Biome.WARM_OCEAN)) {
                                if(chance.nextInt(3)==0) {
                                    t = new TypeManager(e, "Water");
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception err) {

        }
    }


}
