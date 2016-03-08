package com.digitalfishfun.morepets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by joonatoona on 3/7/16.
 */
public class petTardis extends Item {
    public petTardis() {
        setMaxStackSize(1);
        setMaxDamage(100);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        if( item.stackTagCompound == null ) {
            item.stackTagCompound = new NBTTagCompound();
        }
        if (player.isSneaking()) {
            item.stackTagCompound.setDouble("x", player.posX);
            item.stackTagCompound.setDouble("y", player.posY);
            item.stackTagCompound.setDouble("z", player.posZ);
            if (!world.isRemote) {
                player.addChatComponentMessage(new ChatComponentText("[MorePets] Set coordinates!"));
            }
        }
        else {
            player.setPosition(item.stackTagCompound.getDouble("x"), item.stackTagCompound.getDouble("y"), item.stackTagCompound.getDouble("z"));
        }
        return item;
    }
}
