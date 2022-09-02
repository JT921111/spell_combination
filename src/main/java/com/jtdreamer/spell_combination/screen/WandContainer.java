package com.jtdreamer.spell_combination.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class WandContainer implements MenuProvider {
	private final ItemStackHandler inventory = new ItemStackHandler(5);
	private final Player player;
	private ItemStack stack;

	public WandContainer(ItemStack stack, Player player) {
		this.player = player;
		this.stack = stack;
	}

	public ItemStackHandler getHandler() {
		return this.inventory;
	}

	@Override
	public AbstractContainerMenu createMenu(int i, Inventory inv, Player player) {
		return new WandMenu(i, inv, this);
	}

	@Override
	public Component getDisplayName() {
		return Component.translatable("screen.spell_combination.title");
	}
}
