package com.ehhthan.mythicmobstownyaddon.condition;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;
import org.bukkit.entity.LivingEntity;

public class AtWarCondition extends SkillCondition implements ITargetedEntitySkill {
    public AtWarCondition(MythicLineConfig config) {
        super(config.getLine());
    }

    @Override
    public boolean check(AbstractEntity target) {
        LivingEntity bukkitTarget = (LivingEntity) BukkitAdapter.adapt(target);
        return (bukkitTarget.getVehicle() != null);
    }

    @Override
    public boolean castAtEntity(SkillMetadata skillMetadata, AbstractEntity abstractEntity) {
        return false;
    }
}
