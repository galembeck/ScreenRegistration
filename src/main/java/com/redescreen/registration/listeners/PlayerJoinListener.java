package com.redescreen.registration.listeners;

import com.redescreen.registration.Registration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class PlayerJoinListener implements Listener {

//    public Registration plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        createScoreboard(e.getPlayer());
        sendValidationInformation(e.getPlayer());
    }

    public void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("screen", "scoreboard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(Registration.plugin.getConfig().getString("Scoreboard.display-name").replace("&", "§"));

        objective.getScore("").setScore(10);

        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.authentication").replace("&", "§")).setScore(9);
        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.authentication-description").replace("&", "§")).setScore(8);
        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.authentication-lore").replace("&", "§")).setScore(7);

        objective.getScore("  ").setScore(6);

        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.registration").replace("&", "§")).setScore(5);
        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.registration-description").replace("&", "§")).setScore(4);
        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.registration-lore").replace("&", "§")).setScore(3);

        objective.getScore("   ").setScore(2);

        objective.getScore(Registration.plugin.getConfig().getString("Scoreboard.website-store").replace("&", "§")).setScore(1);

        player.setScoreboard(scoreboard);
    }

    public void sendValidationInformation(Player player) {
        for (String validationStringList : Registration.plugin.getConfig().getStringList("Messages.validation")) {
            player.sendMessage(validationStringList.replace("&", "§"));
        }
        for (String loginInformationStringList : Registration.plugin.getConfig().getStringList("Messages.login-information")) {
            player.sendMessage(loginInformationStringList.replace("&", "§").replace("@", "➜").replace("^", "❤"));
        }
    }
}
