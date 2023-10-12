package de.qfirst.caravasmod.blocks;

import de.qfirst.caravasmod.CaravasMod;
import de.qfirst.caravasmod.items.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block CUSTOM_PUMPKIN = registerBlock("mutated_pumpkin",
            new MutatedPumpkin(FabricBlockSettings.copy(Blocks.CARVED_PUMPKIN).luminance((state) -> {
                return 15;
            })), ModItemGroup.CARAVAS);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(CaravasMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(CaravasMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void register(){}
}
