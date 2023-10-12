package de.qfirst.caravasmod.items;

import de.qfirst.caravasmod.CaravasMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CARAVAS = FabricItemGroupBuilder.build(new Identifier(CaravasMod.MOD_ID, "caravas"),
            () -> new ItemStack(Items.SUNFLOWER));
}
