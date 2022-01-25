package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.TownyAPI;
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.ILocationCondition;

public class InWildernessCondition extends SkillCondition implements ILocationCondition {
    private final TownyAPI townyAPI;

    public InWildernessCondition(TownyAPI api, MythicLineConfig config) {
        super(config.getLine());
        this.townyAPI = api;
    }

    @Override
    public boolean check(AbstractLocation location) {
        return townyAPI.isWilderness(BukkitAdapter.adapt(location));
    }
}
