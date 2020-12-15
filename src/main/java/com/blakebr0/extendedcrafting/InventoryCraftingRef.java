package com.blakebr0.extendedcrafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryCraftingRef extends InventoryCrafting {

    public InventoryCraftingRef(int width, int height) {
        super(null, width, height);
    }

    public InventoryCraftingRef(NonNullList<ItemStack> contents, int width, int height) {
        this(width, height);
        setContents(contents);
    }

    public void setContents(NonNullList<ItemStack> contents) {
        if (contents.size() != this.stackList.size()) {
            throw new IllegalArgumentException();
        }
        this.stackList = contents;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.stackList, index, count);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.stackList.set(index, stack);
    }
}
