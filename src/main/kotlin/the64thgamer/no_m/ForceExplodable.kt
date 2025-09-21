package the64thgamer.no_m

import net.minecraft.entity.mob.CreeperEntity

interface ForceExplodable {
    fun triggerForceExplosion(creeper: CreeperEntity)
}