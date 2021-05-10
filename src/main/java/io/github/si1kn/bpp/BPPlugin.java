package io.github.si1kn.bpp;

import io.github.si1kn.bpp.cmds.Day;
import io.github.si1kn.bpp.cmds.Enderchest;
import io.github.si1kn.bpp.cmds.Fly;
import io.github.si1kn.bpp.cmds.Night;
import org.bukkit.plugin.java.JavaPlugin;

public class BPPlugin extends JavaPlugin {
    public static String prefix = "BPPlugin: ";
    @Override
    public void onEnable() {
        System.out.println("[ Basic-Perms-Plugin ] is now online!");
        getCommand("fly").setExecutor(new Fly());
        getCommand("night").setExecutor(new Night());
        getCommand("day").setExecutor(new Day());
        getCommand("enderchest").setExecutor(new Enderchest());
    }

    @Override
    public void onDisable() {

    }
}
