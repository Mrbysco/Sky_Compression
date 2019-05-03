package hqbanana.skycompression.plugins.jei;

import com.bartz24.skyresources.References;
import hqbanana.skycompression.ItemHelper;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import java.util.List;

public class CompressedCuttingKnifeRecipeCategory implements IRecipeCategory {
	private static final int slotInputStack = 0;
	private static final int slotInputGrinder = 1;
	private static final int slotOutput = 2;
	
	private final IDrawable background;
	
	private final String localizedName = I18n.translateToLocalFormatted("jei.sc.recipe.compressedKnife");
	
	public CompressedCuttingKnifeRecipeCategory(IGuiHelper guiHelper) {
		super();
		background = guiHelper.createDrawable(new ResourceLocation(References.ModID, "textures/gui/jei/infusion.png"), 32, 0, 96, 50);
	}
	
	@Override
	public void drawExtras(Minecraft minecraft) {
		
	}
	
	@Override
	public IDrawable getBackground() {
		return background;
	}
	
	@Override
	public String getTitle() {
		return localizedName;
	}
	
	@Override
	public String getUid() {
		return com.bartz24.skyresources.References.ModID + ":compressedKnife";
	}
	
	@Override
	public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingredients)
	{
		layout.getItemStacks().init(slotInputGrinder, true, 0, 1);
		layout.getItemStacks().init(slotInputStack, true, 21, 29);
		layout.getItemStacks().init(slotOutput, false, 74, 15);

		List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
		layout.getItemStacks().set(slotInputStack, inputs.get(0));
		layout.getItemStacks().set(slotInputGrinder, ItemHelper.getCompressedKnives());
		List<List<ItemStack>> outputs = ingredients.getOutputs(ItemStack.class);
		layout.getItemStacks().set(slotOutput, outputs.get(0));
	}
	
	@Override
	public String getModName() {
		return com.bartz24.skyresources.References.ModName;
	}
}