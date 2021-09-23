package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.war.eventwar.War;
import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityComparisonCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class AtWarCondition extends SkillCondition implements IEntityComparisonCondition {
    private final TownyAPI townyAPI;

    public AtWarCondition(MythicLineConfig config) {
        super(config.getLine());
        this.townyAPI = TownyAPI.getInstance();
    }

    @Override
    public boolean check(AbstractEntity abstractEntity, AbstractEntity abstractTarget) {
        Entity entity = abstractEntity.getBukkitEntity();
        Entity target = abstractTarget.getBukkitEntity();
        if (entity instanceof Player && target instanceof Player) {
            Nation entityNation = townyAPI.getResidentNationOrNull(townyAPI.getResident((Player) entity));
            Nation targetNation = townyAPI.getResidentNationOrNull(townyAPI.getResident((Player) target));

            return atWar(entityNation, targetNation);
        } else
            return false;
    }


    private boolean atWar(Nation first, Nation second) {
        if (first == null || second == null)
            return false;

        War event = TownyUniverse.getInstance().getWarEvent();
        return event != null &&
            event.isWarTime()
            && event.isWarringNation(first)
            && event.isWarringNation(second)
            && first.hasEnemy(second);
    }
}
