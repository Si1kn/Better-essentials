package io.github.si1kn.be.cmds.time;

import io.github.si1kn.be.BEPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("bpplugin.commands.time")) {
                if (args.length <= 0) {
                    ((Player) sender).getWorld().setTime(0);
                }
            } else {
                player.sendMessage(BEPlugin.prefix + "Sorry, you don't have permissions to run this!");
            }
        } else {
            System.out.println("You cannot run this command from console!");
        }
        return true;
    }
}
