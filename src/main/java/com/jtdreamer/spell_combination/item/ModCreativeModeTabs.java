package com.jtdreamer.spell_combination.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTabs {
	public static final CreativeModeTab SPELL_COMBINATION = new CreativeModeTab("spell_combination_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.DIAMOND);
		}
	};
}
