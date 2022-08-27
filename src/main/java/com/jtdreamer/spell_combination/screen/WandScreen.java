package com.jtdreamer.spell_combination.screen;

import com.jtdreamer.spell_combination.ModInit;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WandScreen extends AbstractContainerScreen<WandMenu> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInit.MODID, "textures/gui/hopper.png");
	protected int imageWidth = 175;
	protected int imageHeight = 132;
	protected int titleLabelX = 8;
	protected int titleLabelY = 23;
	protected int inventoryLabelX = 8;
	protected int inventoryLabelY = 56;

	public WandScreen(WandMenu menu, Inventory inv, Component component) {
		super(menu, inv, component);
	}

	@Override
	protected void init() {
		super.init();
	}

	@Override
	protected void renderBg(PoseStack stack, float tick, int x, int y) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int m = (width - imageWidth) / 2;
		int n = (height - imageHeight) / 2;

		this.blit(stack, m, n, 0, 0, imageWidth, imageHeight);
	}

	@Override
	public void render(PoseStack stack, int x, int y, float tick) {
		renderBackground(stack);
		super.render(stack, x, y, tick);
		renderTooltip(stack, x, y);
	}

	@Override
	protected void renderLabels(PoseStack stack, int x, int y) {
		this.font.draw(stack, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 4210752);
		this.font.draw(stack, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY,
				4210752);
	}
}
