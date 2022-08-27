package com.jtdreamer.spell_combination.item.custom;

import com.jtdreamer.spell_combination.screen.WandContainer;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class CombinationWandItem extends Item {
	public CombinationWandItem(Properties prop) {
		super(prop);
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);

		if (!level.isClientSide) {
			if (hand == InteractionHand.MAIN_HAND) {
				if (itemstack.getItem() == this && !player.isCrouching()) {
					NetworkHooks.openScreen((ServerPlayer)player, new WandContainer(itemstack, player));
				}
			}
		}
		return InteractionResultHolder.pass(itemstack);
	}
}
