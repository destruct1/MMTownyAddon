package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;

public class InMyTownCondition extends SkillCondition implements IEntityCondition {
    private final TownyAPI townyAPI;

    public InMyTownCondition(TownyAPI api, MythicLineConfig config) {
        super(config.getLine());
        this.townyAPI = api;
    }
    @Override
    public boolean check(AbstractEntity abstractEntity) {
        Town townOrNull = townyAPI.getTownOrNull(townyAPI.getTownBlock(BukkitAdapter.adapt(abstractEntity.getLocation())));
        if (townOrNull == null || !abstractEntity.isPlayer()) {
            return false;
        }
        return townOrNull.hasResident(BukkitAdapter.adapt(abstractEntity.asPlayer()).getUniqueId());

    }
}
