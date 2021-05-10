package io.github.si1kn.be.cmds.help;


import io.github.si1kn.be.BEPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Report implements CommandExecutor {

    public List<Player> reportEnabled = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ChatColor.translateAlternateColorCodes('&', "&a[BE-Plugin]: &r");
            if (args.length <= 2) {
                for (Player player2 : reportEnabled) {
                    player2.sendMessage(BEPlugin.prefix + ChatColor.translateAlternateColorCodes('&', "&a" + player.getName() + ": &r") + " has reported " + ChatColor.translateAlternateColorCodes('&', "&c" + args[0] + "&r") + " for " + ChatColor.translateAlternateColorCodes('&', "&c" + args[1] + "&r"));
                }

            } else {
                player.sendMessage("Not enough args! /report user cheat");
            }
        } else {
            System.out.println("You cannot run this command from console!");
        }

        return true;
    }
}
