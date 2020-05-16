package me.mvabo.enchantedmobs.items;

import me.mvabo.enchantedmobs.ItemFileManager;
import me.mvabo.enchantedmobs.utils.Utilities;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemHandler {

    ItemFileManager item;

    public ItemHandler() {
        this.item = new ItemFileManager();
    }

    public ItemStack getItem(String itemName) {
        ItemStack i;
        ConfigurationSection itemSec = item.getItemConfig().getConfigurationSection(itemName);

        //Get material
        String material = itemSec.getString("material");

        //Get name
        String name = itemSec.getString("name");

        //Get Lore
        ArrayList<String> lore = new ArrayList<>();
        lore.add(itemSec.getString("lore"));

        //Get item meta and define item
        String coloredname = Utilities.colorize(name);
        i = new ItemStack(Material.getMaterial(material), 1);
        ItemMeta im = i.getItemMeta();

        try {
            //get Enchants
            List<String> enchants = itemSec.getStringList("enchantments");
            int enchantlvl = 1;
            for (int j = 0; j < enchants.size(); j++) {
                if (enchants.get(j).endsWith("1")) {
                    enchantlvl = 1;
                } else if (enchants.get(j).endsWith("2")) {
                    enchantlvl = 2;
                } else if (enchants.get(j).endsWith("3")) {
                    enchantlvl = 3;
                } else if (enchants.get(j).endsWith("4")) {
                    enchantlvl = 4;
                } else if (enchants.get(j).endsWith("5")) {
                    enchantlvl = 5;
                }

                String enchantAndLevel = enchants.get(j);
                String arr[] = enchantAndLevel.split(" ", 1);

                Enchantment enchant = Enchantment.getByName(arr[1]);

                //Add enchants to item meta
                i.addEnchantment(enchant, enchantlvl);
            }
        } catch (Exception e) {
            System.out.println("Error in add enchant to item");
        }

        im.setDisplayName(coloredname);
        im.setLore(lore);
        i.setItemMeta(im);

        return i;
    }
}
