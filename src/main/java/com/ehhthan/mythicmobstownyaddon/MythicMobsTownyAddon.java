package com.ehhthan.mythicmobstownyaddon;

import com.ehhthan.mythicmobstownyaddon.condition.AtWarCondition;
import com.ehhthan.mythicmobstownyaddon.condition.InWildernessCondition;
import com.palmergames.bukkit.towny.TownyAPI;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicMobsTownyAddon extends JavaPlugin implements Listener {
    private TownyAPI townyAPI;

    @Override
    public void onEnable() {
        this.townyAPI = TownyAPI.getInstance();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMythicConditionLoad(MythicConditionLoadEvent event) {
        if (event.getConditionName().equalsIgnoreCase("atWar"))
            event.register(new AtWarCondition(townyAPI, event.getConfig()));

        if (event.getConditionName().equalsIgnoreCase("inWild")
        || event.getConditionName().equalsIgnoreCase("inWilderness"))
            event.register(new InWildernessCondition(townyAPI, event.getConfig()));
    }
}
