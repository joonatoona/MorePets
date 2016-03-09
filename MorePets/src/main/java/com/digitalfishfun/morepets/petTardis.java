package com.digitalfishfun.morepets;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import com.inventorypets.*;

import java.util.List;

/**
 * Created by joonatoona on 3/7/16.
 */
public class petTardis extends Item {
    public petTardis() {
        setMaxStackSize(1);
        setMaxDamage(2);
        setCreativeTab(InventoryPets.TabInventoryPets);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(EnumChatFormatting.GREEN + "TP To saved coords " + EnumChatFormatting.DARK_GREEN + "[" + EnumChatFormatting.DARK_GRAY + "Right Click" + EnumChatFormatting.DARK_GREEN + "]");
        par3List.add(EnumChatFormatting.GREEN + "Save current coords " + EnumChatFormatting.DARK_GREEN + "[" + EnumChatFormatting.DARK_GRAY + "Sneak + Right Click" + EnumChatFormatting.DARK_GREEN + "]");
        par3List.add(EnumChatFormatting.GRAY + "Favorite Food: " + StatCollector.translateToLocal("item.lapisNugget.name"));
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        if( item.stackTagCompound == null ) {
            item.stackTagCompound = new NBTTagCompound();
        }
        if (player.isSneaking()) {
            item.stackTagCompound.setDouble("x", player.posX);
            item.stackTagCompound.setDouble("y", player.posY);
            item.stackTagCompound.setDouble("z", player.posZ);
            item.stackTagCompound.setBoolean("set", true);
            if (!world.isRemote) {
                player.addChatComponentMessage(new ChatComponentText("[MorePets] Set TARDIS coordinates!"));
            }
        }
        else {
            //new ItemStack(Items.dye, 1, 4).getItem()
            if (item.getItemDamage() == 2 && player.inventory.consumeInventoryItem(InventoryPets.lapisNugget)) {
                item.setItemDamage(-1);
                world.playSoundEffect(player.posX, player.posY, player.posZ, "morepets:nomnom", 1, 1);
            }
            if (item.getItemDamage() < 2) {
                if (item.stackTagCompound.getBoolean("set")) {
                    if (!player.capabilities.isCreativeMode) {
                        item.damageItem(1, player);
                    }
                    world.playSoundEffect(player.posX, player.posY, player.posZ, "morepets:tardisWoosh", 1, 1);
                    player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 40, 0));
                    player.setPosition(item.stackTagCompound.getDouble("x"), item.stackTagCompound.getDouble("y"), item.stackTagCompound.getDouble("z"));
                    world.playSoundEffect(item.stackTagCompound.getDouble("x"), item.stackTagCompound.getDouble("y"), item.stackTagCompound.getDouble("z"), "morepets:tardisWoosh", 1, 1);
                }
            }
        }
        return item;
    }
}
