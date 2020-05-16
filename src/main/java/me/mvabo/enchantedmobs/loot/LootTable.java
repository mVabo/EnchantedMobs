package me.mvabo.enchantedmobs.loot;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class LootTable {

    ArrayList<ItemStack> loot = new ArrayList<>();

    public LootTable() {

    }

    public ArrayList<ItemStack> getLoot(String mob) {
        if(mob.equalsIgnoreCase("cannibal")) {
            //for(String key : )
        } else if (mob.equalsIgnoreCase("illusioner")) {
            //ItemStack
        } else if (mob.equalsIgnoreCase("tribalhunter")) {

        } else if (mob.equalsIgnoreCase("fallenbarbarian")) {

        } else if (mob.equalsIgnoreCase("stalker")) {

        } else if (mob.equalsIgnoreCase("sandelemental")) {

        } else if (mob.equalsIgnoreCase("zombiethief")) {

        } else if (mob.equalsIgnoreCase("ghostofthetemplar")) {

        } else if (mob.equalsIgnoreCase("possessedlumberjack")) {

        } else if (mob.equalsIgnoreCase("sunkenpirate")) {

        } else if (mob.equalsIgnoreCase("waterelemental")) {

        }
        return loot;
    }
}
