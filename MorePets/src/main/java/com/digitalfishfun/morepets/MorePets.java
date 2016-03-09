package com.digitalfishfun.morepets;

import com.inventorypets.InventoryPets;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by joonatoona on 3/7/16.
 */

@Mod(modid = "morepets", version = "Alpha 1.0", dependencies = "required-after:InventoryPets")
public class MorePets {
    public static final String modid = "morepets";
    public static final String version = "1.4.0";
    public static Item petTardis;
    public static Item petJoona;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        petTardis = new petTardis().setUnlocalizedName("petTardis").setTextureName("morepets:petTardis");
        petJoona = new petJoona();
        GameRegistry.registerItem(petTardis, petTardis.getUnlocalizedName().substring(5));
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        //new ItemStack(Items.dye, 1, 4)
        GameRegistry.addRecipe(new ItemStack(petTardis), "lll", "ldl", "lgl", 'l', InventoryPets.lapisNugget, 'd', Items.diamond, 'g', Items.gold_ingot);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
