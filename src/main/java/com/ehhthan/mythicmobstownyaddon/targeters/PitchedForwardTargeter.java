package com.ehhthan.mythicmobstownyaddon.targeters;

import com.google.common.collect.Lists;
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCaster;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.targeters.ForwardTargeter;
import io.lumine.xikage.mythicmobs.util.annotations.MythicTargeter;

import java.util.Collection;

@MythicTargeter(
    author = "Ehhthan",
    name = "pitchedforward",
    aliases = {"pforward"},
    description = "Targets a point in front of the caster where the pitch is defined."
)
public class PitchedForwardTargeter extends ForwardTargeter {
    protected final int pitch;

    public PitchedForwardTargeter(MythicLineConfig mlc) {
        super(mlc);
        this.pitch = mlc.getInteger(new String[]{"pitch", "p"}, 0);
    }

    @Override
    public Collection<AbstractLocation> getLocations(SkillMetadata data) {
        AbstractLocation location;
        SkillCaster am = data.getCaster();
        Collection<AbstractLocation> targets = Lists.newArrayList();
        if (this.useEyeLocation) {
            location = am.getEntity().getEyeLocation();
        } else {
            location = am.getEntity().getLocation();
        }

        location.setPitch(pitch);

        if (this.rotate != 0.0F) {
            location.add(location.getDirection().rotate(this.rotate).normalize().multiply(this.forward));
        } else {
            location.add(location.getDirection().normalize().multiply(this.forward));
        }
        targets.add(mutate(data, location));
        return targets;
    }
}
