package com.crazyweapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class WeaponFactory {

    public static ItemStack createExplosiveSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Explosive Sword");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Creates explosions on hit!",
            ChatColor.DARK_RED + "Handle with care..."
        ));
        meta.addEnchant(Enchantment.SHARPNESS, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createLightningStaff() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Lightning Staff");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Right-click to summon lightning!",
            ChatColor.YELLOW + "⚡ Unlimited Power ⚡"
        ));
        meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createFreezeRay() {
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Freeze Ray");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Hit enemies to freeze them!",
            ChatColor.AQUA + "❄ Ice Cold ❄"
        ));
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createTeleportWand() {
        ItemStack item = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Teleport Wand");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Right-click to teleport!",
            ChatColor.DARK_PURPLE + "✦ Instant Travel ✦"
        ));
        meta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createVampireBlade() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Vampire Blade");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Steals health from enemies!",
            ChatColor.RED + "♥ Life Steal ♥"
        ));
        meta.addEnchant(Enchantment.SHARPNESS, 7, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createTornadoAxe() {
        ItemStack item = new ItemStack(Material.GOLDEN_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Tornado Axe");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Launches nearby enemies into the air!",
            ChatColor.WHITE + "🌪 Whirlwind Force 🌪"
        ));
        meta.addEnchant(Enchantment.KNOCKBACK, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createPoisonDagger() {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Poison Dagger");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Poisons enemies on hit!",
            ChatColor.GREEN + "☠ Toxic Venom ☠"
        ));
        meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS, 3, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createFireHammer() {
        ItemStack item = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Fire Hammer");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Sets enemies ablaze on hit!",
            ChatColor.GOLD + "🔥 Burning Rage 🔥"
        ));
        meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        meta.addEnchant(Enchantment.SHARPNESS, 3, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createGravityMace() {
        ItemStack item = new ItemStack(Material.MACE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Gravity Mace");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Right-click to pull all nearby enemies!",
            ChatColor.DARK_PURPLE + "✦ Gravitational Pull ✦"
        ));
        meta.addEnchant(Enchantment.DENSITY, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createSoulReaper() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Soul Reaper");
        meta.setLore(Arrays.asList(
            ChatColor.GRAY + "Applies Wither on hit!",
            ChatColor.DARK_GRAY + "💀 Reap Their Soul 💀"
        ));
        meta.addEnchant(Enchantment.SHARPNESS, 6, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
}
