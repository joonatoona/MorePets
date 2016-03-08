package com.digitalfishfun.morepets;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by joonatoona on 3/7/16.
 */

@Mod(modid = "morepets", version = "Alpha 1.0")
public class MorePets {

    public static Item petTardis;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        petTardis = new petTardis().setUnlocalizedName("petTardis").setTextureName("morepets:petTardis");
        GameRegistry.registerItem(petTardis, petTardis.getUnlocalizedName().substring(5));
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
