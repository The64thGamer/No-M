package the64thgamer.no_m.mixin

import item.ModItems
import net.minecraft.entity.ItemEntity
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(ItemEntity::class)
abstract class NoMModEvents {

    @Inject(
        method = ["<init>(Lnet/minecraft/world/World;DDD Lnet/minecraft/item/ItemStack;)V"],
        at = [At("RETURN")]
    )
    fun onConstructed(world: World, x: Double, y: Double, z: Double, stack: ItemStack, ci: CallbackInfo) {
        // Only transform Gibbly when dropped
        if (stack.isOf(ModItems.GIBBLY)) {
            // Replace with Glangry
            (this as ItemEntity).setStack(ItemStack(ModItems.GLANGRY, stack.count))
        }
    }

}