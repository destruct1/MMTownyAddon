package com.ehhthan.mythicmobstownyaddon;

import com.ehhthan.mythicmobstownyaddon.targeters.PitchedForwardTargeter;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicTargeterLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TargetMMAddon extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMythicTargeterLoadEvent(MythicTargeterLoadEvent event) {
        if (event.getTargeterName().equalsIgnoreCase("pitchedforward")
            || event.getTargeterName().equalsIgnoreCase("pforward"))
            event.register(new PitchedForwardTargeter(event.getConfig()));
    }
}
