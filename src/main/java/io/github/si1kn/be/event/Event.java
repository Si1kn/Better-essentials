package io.github.si1kn.be.event;

import io.github.si1kn.be.cmds.chat.Chat;
import io.github.si1kn.be.cmds.help.Report;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {

    private final Chat chat;
    private final Report report;

    public Event(Chat chat, Report report) {
        this.chat = chat;
        this.report = report;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (!chat.enabled) {
            if (!player.hasPermission("be.commands.chat")) {
                player.sendMessage("§4Chat is disabled!");
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(event.getPlayer().hasPermission("be.staff.report")) {
            report.reportEnabled.add(event.getPlayer());
        }
    }

}
