package com.wehigami.warp.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class WarpCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to execute this command");
            return true;
        }
        Player player = (Player) sender;
        World world = player.getWorld();

        Location loc = new Location(world, -12, 203, -39);

        if (cmd.getName().equalsIgnoreCase("warp")) {
            try {
                player.sendMessage("§cpodaj gdzie cie tepnac");
            } catch (InternalError e) {
                player.sendMessage("§cerror skurwysyn error");
            }


            if (args[0].equals("chuj")) {
                try {
                    player.sendMessage("§eYou will be teleported in 3");
                    Thread.sleep(1000);
                    player.sendMessage("§eYou will be teleported in 2");
                    Thread.sleep(1000);
                    player.sendMessage("§eYou will be teleported in 1");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    player.sendMessage("§cerror");
                }
                player.teleport(loc);
                player.sendMessage("§eTeleported");
            }

        } else if (cmd.getName().equalsIgnoreCase("farm")) {
            if (args.length >= 2) {
                try {
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                }catch (IllegalArgumentException e) {
                    player.sendMessage("§czla nazwa stwora");
                }


            } else {
                player.sendMessage("§cerror skurwysyn error");
            }
        }


        return true;
    }
}