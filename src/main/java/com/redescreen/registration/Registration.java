package com.redescreen.registration;

import com.redescreen.registration.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Registration extends JavaPlugin {

    public static Registration plugin;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
}
