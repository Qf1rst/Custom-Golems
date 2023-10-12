package de.qfirst.caravasmod.items;

import de.qfirst.caravasmod.CaravasMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item DEEPSLATE_LEGGINGS = registerItem("deepslate_leggings",
            new ModArmorItem(ModArmorMaterials.DEEPSLATE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.CARAVAS)));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            new ModArmorItem(ModArmorMaterials.OBSIDIAN,EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.CARAVAS)));
    public static final Item MAGMA_BOOTS = registerItem("magma_boots",
            new ModArmorItem(ModArmorMaterials.MAGMA,EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.CARAVAS)));
    public static final Item SNOW_HELMET = registerItem("snow_helmet",
            new ModArmorItem(ModArmorMaterials.SNOW,EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.CARAVAS)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(CaravasMod.MOD_ID, name), item);
    }

    public static final void register(){}
}
