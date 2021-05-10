package io.github.si1kn.be;

import io.github.si1kn.be.cmds.Enderchest;
import io.github.si1kn.be.cmds.Fly;
import io.github.si1kn.be.cmds.chat.Chat;
import io.github.si1kn.be.cmds.help.Report;
import io.github.si1kn.be.cmds.time.Day;
import io.github.si1kn.be.cmds.time.Night;
import io.github.si1kn.be.event.Event;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BEPlugin extends JavaPlugin {


    public static String prefix = ChatColor.translateAlternateColorCodes('&', "&a[BE-Plugin]: &r");


    @Override
    public void onEnable() {
        System.out.println("[Better-Essentials-Plugin] is now online!");

        Chat enableChat = new Chat();
        Report report = new Report();
        getServer().getPluginManager().registerEvents(new Event(enableChat, report), this);

        getCommand("fly").setExecutor(new Fly());
        getCommand("night").setExecutor(new Night());
        getCommand("day").setExecutor(new Day());
        getCommand("enderchest").setExecutor(new Enderchest());
        getCommand("chat").setExecutor(enableChat);
        getCommand("report").setExecutor(report);

    }

    @Override
    public void onDisable() {

    }
}
