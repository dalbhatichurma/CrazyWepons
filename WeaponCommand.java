package com.crazyweapons;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeaponCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.GOLD + "=== Crazy Weapons ===");
            player.sendMessage(ChatColor.YELLOW + "/cw explosive  - Explosive Sword");
            player.sendMessage(ChatColor.YELLOW + "/cw lightning  - Lightning Staff");
            player.sendMessage(ChatColor.YELLOW + "/cw freeze     - Freeze Ray");
            player.sendMessage(ChatColor.YELLOW + "/cw teleport   - Teleport Wand");
            player.sendMessage(ChatColor.YELLOW + "/cw vampire    - Vampire Blade");
            player.sendMessage(ChatColor.YELLOW + "/cw tornado    - Tornado Axe");
            player.sendMessage(ChatColor.YELLOW + "/cw poison     - Poison Dagger");
            player.sendMessage(ChatColor.YELLOW + "/cw fire       - Fire Hammer");
            player.sendMessage(ChatColor.YELLOW + "/cw gravity    - Gravity Mace");
            player.sendMessage(ChatColor.YELLOW + "/cw reaper     - Soul Reaper");
            return true;
        }

        String weaponType = args[0].toLowerCase();
        
        switch (weaponType) {
            case "explosive":
                player.getInventory().addItem(WeaponFactory.createExplosiveSword());
                player.sendMessage(ChatColor.GREEN + "You received the Explosive Sword!");
                break;
            case "lightning":
                player.getInventory().addItem(WeaponFactory.createLightningStaff());
                player.sendMessage(ChatColor.GREEN + "You received the Lightning Staff!");
                break;
            case "freeze":
                player.getInventory().addItem(WeaponFactory.createFreezeRay());
                player.sendMessage(ChatColor.GREEN + "You received the Freeze Ray!");
                break;
            case "teleport":
                player.getInventory().addItem(WeaponFactory.createTeleportWand());
                player.sendMessage(ChatColor.GREEN + "You received the Teleport Wand!");
                break;
            case "vampire":
                player.getInventory().addItem(WeaponFactory.createVampireBlade());
                player.sendMessage(ChatColor.GREEN + "You received the Vampire Blade!");
                break;
            case "tornado":
                player.getInventory().addItem(WeaponFactory.createTornadoAxe());
                player.sendMessage(ChatColor.GREEN + "You received the Tornado Axe!");
                break;
            case "poison":
                player.getInventory().addItem(WeaponFactory.createPoisonDagger());
                player.sendMessage(ChatColor.GREEN + "You received the Poison Dagger!");
                break;
            case "fire":
                player.getInventory().addItem(WeaponFactory.createFireHammer());
                player.sendMessage(ChatColor.GREEN + "You received the Fire Hammer!");
                break;
            case "gravity":
                player.getInventory().addItem(WeaponFactory.createGravityMace());
                player.sendMessage(ChatColor.GREEN + "You received the Gravity Mace!");
                break;
            case "reaper":
                player.getInventory().addItem(WeaponFactory.createSoulReaper());
                player.sendMessage(ChatColor.GREEN + "You received the Soul Reaper!");
                break;
            default:
                player.sendMessage(ChatColor.RED + "Unknown weapon! Use /cw for a list.");
                break;
        }

        return true;
    }
}
