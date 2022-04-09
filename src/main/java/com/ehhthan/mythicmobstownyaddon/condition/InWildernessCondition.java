package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.TownyAPI;
import io.lumine.mythic.api.adapters.AbstractLocation;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.core.skills.SkillCondition;
import io.lumine.mythic.api.skills.conditions.ILocationCondition;

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
