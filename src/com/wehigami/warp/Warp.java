package com.wehigami.warp;

import com.wehigami.warp.commands.TestCommands;
import com.wehigami.warp.commands.WarpCommands;
import com.wehigami.warp.events.TestEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Warp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TestEvent(), this); //do this for every new events class
        getCommand("warp").setExecutor(new WarpCommands());
        getCommand("farm").setExecutor(new WarpCommands());

        getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "Warp is up");



    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Warp is down");
    }

}
