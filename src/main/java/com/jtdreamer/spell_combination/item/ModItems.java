package com.jtdreamer.spell_combination.item;

import com.jtdreamer.spell_combination.ModInit;
import com.jtdreamer.spell_combination.item.custom.CombinationWandItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModInit.MODID);

	public static final RegistryObject<Item> COMBINATION_WAND = ITEMS.register("combination_wand",
			() -> new CombinationWandItem(new Item.Properties().tab(ModCreativeModeTabs.SPELL_COMBINATION).stacksTo(1)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
