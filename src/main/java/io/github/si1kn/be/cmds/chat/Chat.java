package io.github.si1kn.be.cmds.chat;

import io.github.si1kn.be.BEPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat implements CommandExecutor {
    public boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("bpplugin.commands.chat")) {

                if (args.length <= 1) {
                    enabled = Boolean.parseBoolean(args[0]);
                    System.out.println(args[0]);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', BEPlugin.prefix + "&7Toggled Chat: " + (enabled ? "&aon" : "&coff")));
                } else {
                    player.sendMessage("No args! args are /chat <true,false>");
                }
            } else {
                player.sendMessage(BEPlugin.prefix + "Sorry, you don't have permissions to run this!");
            }
        } else {
            System.out.println("You need to run it from in game!");
        }
        return true;
    }
}
