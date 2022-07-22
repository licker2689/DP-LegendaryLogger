package com.darksoldier1404.dll.events.players;

import com.darksoldier1404.dll.LegendaryLogger;
import com.darksoldier1404.dll.functions.DLLFunction;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreProcess implements Listener {
    private final LegendaryLogger plugin = LegendaryLogger.getInstance();

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        YamlConfiguration data = plugin.udata.get(p.getUniqueId());
        if (data == null) return;
        String now = DLLFunction.getNow();
        Bukkit.getScheduler().runTask(plugin, () -> {
        data.set(now + ".PlayerCommandPreprocessEvent.command_preprocess", e.getMessage());
        });
    }
}
