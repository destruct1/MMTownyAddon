package com.ehhthan.mythicmobstownyaddon;

import com.ehhthan.mythicmobstownyaddon.condition.AtWarCondition;
import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicMobsTownyAddon extends JavaPlugin implements Listener {
    private static MythicMobsTownyAddon INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public static MythicMobsTownyAddon getInstance() {
        return INSTANCE;
    }

    @EventHandler
    public void onMythicConditionLoad(MythicConditionLoadEvent event) {
        if (event.getConditionName().equalsIgnoreCase("atWar"))
            event.register(new AtWarCondition(event.getConfig()));
    }
}
