package item

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.mixin.item.ItemSettingsMixin
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import the64thgamer.no_m.NoM

object ModItems {
    val GIBBLY: Item = registerItem("gibbly", Item(Item.Settings()))

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(
            Registries.ITEM,
            Identifier.of(NoM.MOD_ID,name),
            item
        )
    }

    fun registerModItems(){
        NoM.logger.info("Registering Mod Items for " + NoM.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(GIBBLY)
        }
    }
}