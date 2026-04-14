package com.crazyweapons;

import org.bukkit.plugin.java.JavaPlugin;

public class CrazyWeapons extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("crazyweapons").setExecutor(new WeaponCommand());
        getServer().getPluginManager().registerEvents(new WeaponListener(), this);
        getLogger().info("CrazyWeapons has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CrazyWeapons has been disabled!");
    }
}
