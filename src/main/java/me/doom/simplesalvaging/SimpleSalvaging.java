package me.doom.simplesalvaging;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleSalvaging extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getConsoleSender().sendMessage("[Simple Salvaging] Config loaded");

        //Gets values from config

        Boolean irontools = getConfig().getBoolean("iron-tools");
        Boolean ironarmor = getConfig().getBoolean("iron-armor");

        Integer ironingotstools = getConfig().getInt("ironingots-tools");
        Integer ironingotsarmor = getConfig().getInt("ironingots-armor");

        Boolean diamondtools = getConfig().getBoolean("diamond-tools");
        Boolean diamondarmor = getConfig().getBoolean("diamond-armor");

        Integer diamondstools = getConfig().getInt("diamonds-tools");
        Integer diamondsarmor = getConfig().getInt("diamonds-armor");

        //Define the itemstacks

        ItemStack ironingottools = new ItemStack(Material.IRON_INGOT, ironingotstools);
        ItemStack ironingotarmor = new ItemStack(Material.IRON_INGOT, ironingotsarmor);

        ItemStack diamondsfortools = new ItemStack(Material.DIAMOND, diamondstools);
        ItemStack diamondsforarmor = new ItemStack(Material.DIAMOND, diamondsarmor);

        //Make an array list of materials
        Material[] ironTools = {Material.IRON_SWORD, Material.IRON_PICKAXE, Material.IRON_AXE, Material.IRON_HOE};
        Material[] ironArmor = {Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS};

        Material[] diamondArmor = {Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS};
        Material[] diamondTools = {Material.DIAMOND_SWORD, Material.DIAMOND_PICKAXE, Material.DIAMOND_AXE, Material.DIAMOND_HOE};

        //If the boolean is true, make the recipe
        if (diamondtools) {
            for (Material tool : diamondTools) {
                String diamtools = "diam" + tool.toString().toLowerCase();
                FurnaceRecipe diamtoolsrecipe = new FurnaceRecipe(new NamespacedKey(this, diamtools), diamondsfortools, tool, 1.0f, 100);
                Bukkit.addRecipe(diamtoolsrecipe);
            }
        }
        if (diamondarmor) {
            for (Material armor : diamondArmor) {
                String diamarmor = "diam" + armor.toString().toLowerCase();
                FurnaceRecipe diamarmorrecipe = new FurnaceRecipe(new NamespacedKey(this, diamarmor), diamondsforarmor, armor, 1.0f, 100);
                Bukkit.addRecipe(diamarmorrecipe);
            }
        }
        if (irontools) {
            for (Material tool : ironTools) {
                String ironToolsKey = "iron_" + tool.toString().toLowerCase();
                FurnaceRecipe ironToolsRecipe = new FurnaceRecipe(new NamespacedKey(this, ironToolsKey), ironingottools, tool, 1.0f, 100);
                Bukkit.addRecipe(ironToolsRecipe);
            }
        }
        if (ironarmor) {
            for (Material armor : ironArmor) {
                String ironArmorKey = "iron_" + armor.toString().toLowerCase();
                FurnaceRecipe ironArmorRecipe = new FurnaceRecipe(new NamespacedKey(this, ironArmorKey), ironingotarmor, armor, 1.0f, 100);
                Bukkit.addRecipe(ironArmorRecipe);
            }
        }
        getServer().getConsoleSender().sendMessage("[Simple Salvaging] Recipes Loaded");
    }
    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage("[Simple Salvaging] Disabled");
    }
}