package io.github.si1kn.bpp.cmds;

import io.github.si1kn.bpp.BPPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("bpplugin.commands.fly")) {
                if (args.length <= 0) {
                    player.setAllowFlight(!player.getAllowFlight());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Toggled Flight: " + (player.getAllowFlight() ? "&aon" : "&coff")));
                }
            } else {
                player.sendMessage(BPPlugin.prefix + "Sorry, you don't have permissions to run this!");
            }
        } else {
            System.out.println("You cannot run this command from console!");
        }
        return true;
    }
}
