package com.jtdreamer.spell_combination.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class WandMenu extends AbstractContainerMenu {
	protected WandMenu(int i, Inventory inv, FriendlyByteBuf buf) {
		this(i, inv, createInventory(inv, buf));
	}

	public WandMenu(int i, Inventory inv, WandContainer container) {
		super(ModMenuTypes.WAND_MENU.get(), i);
		addPlayerInventoryAndHotbar(inv);
		for (int l = 0; l < 5; l++) {
			this.addSlot(new SlotItemHandler(container.getHandler(), l, 45 + l * 18, 37));
		}
	}

	@Override
	public ItemStack quickMoveStack(Player player, int i) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(i);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (i < 5) {
				if (!this.moveItemStackTo(itemstack1, 5, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 0, 5, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}

		return itemstack;
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	public void addPlayerInventoryAndHotbar(Inventory inventory) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlot(new Slot(inventory, x + y * 9 + 9, 9 + x * 18, 68 + y * 18));
			}
		}

		for (int x = 0; x < 9; x++) {
			this.addSlot(new Slot(inventory, x, 9 + x * 18, 126));
		}
	}

	private static WandContainer createInventory(Inventory inventory, FriendlyByteBuf data) {
		ItemStack stack = inventory.player.getItemBySlot(EquipmentSlot.MAINHAND);
		return new WandContainer(stack, inventory.player);
	}
}
