package com.redescreen.registration;

import com.redescreen.registration.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Registration extends JavaPlugin {

    public static Registration plugin;

//    public LanguageConfiguration messagesConfig = new LanguageConfiguration(this, "messages_br.yml");

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

//        messagesConfig.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
}
