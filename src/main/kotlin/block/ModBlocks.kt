package block

import item.ModItems.GIBBLY
import item.ModItems.GLANGRY
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import the64thgamer.no_m.NoM

object ModBlocks {
    val RUCK: Block = registerBlock(
        "ruck_block",
        Block(
            AbstractBlock.Settings.create()
                .strength(1.5f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)
        )
    )
    val STAR_BLOCK: Block = registerBlock(
        "star_block",
        Block(
            AbstractBlock.Settings.create()
                .strength(1.5f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)
        )
    )
    val PECKED_STONE_BLOCK: Block = registerBlock(
        "pecked_stone_block",
        Block(
            AbstractBlock.Settings.create()
                .strength(1.5f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)
        )
    )
    val PULVERIZED_STONE_BLOCK: Block = registerBlock(
        "pulverized_stone_block",
        Block(
            AbstractBlock.Settings.create()
                .strength(2f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)
        )
    )

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name,block)
        return Registry.register(
            Registries.BLOCK,
            Identifier.of(NoM.MOD_ID,name),
            block
        )
    }

    private fun registerBlockItem(name: String, block: Block) {
        Registry.register(
            Registries.ITEM,
            Identifier.of(NoM.MOD_ID,name),
            BlockItem(block,Item.Settings())
        )
    }

    fun registerModBlocks(){
        NoM.logger.info("Registering Mod Blocks for " + NoM.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
            entries.add(RUCK)
            entries.add(STAR_BLOCK)
            entries.add(PECKED_STONE_BLOCK)
            entries.add(PULVERIZED_STONE_BLOCK)
        }
    }
}