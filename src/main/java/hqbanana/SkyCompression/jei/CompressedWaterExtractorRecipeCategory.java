package hqbanana.SkyCompression.jei;

import java.util.List;

import com.bartz24.skyresources.References;

import hqbanana.SkyCompression.base.tools.ItemCompressedWaterExtractor;
import hqbanana.SkyCompression.init.ModItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fluids.FluidStack;

public class CompressedWaterExtractorRecipeCategory extends BlankRecipeCategory {
	private static final int SLOT_INPUT_STACK = 0;
	private static final int SLOT_INPUT_EXTRACTOR = 1;
	private static final int SLOT_OUTPUT = 2;
	private static final int SLOT_INPUT_FLUID = 3;
	private static final int SLOT_OUTPUT_FLUID = 4;
	
	private final IDrawable BACKGROUND;
	
	private final String localizedName = I18n.translateToLocalFormatted("jei.sc.recipe.compressedWaterExtractor");
	
	public CompressedWaterExtractorRecipeCategory(IGuiHelper guiHelper) {
		super();
		BACKGROUND = guiHelper.createDrawable(new ResourceLocation(References.ModID, "textures/gui/jei/extractor.png"), 0, 0, 150, 50);
	}
	
	@Override
	public void drawExtras(Minecraft minecraft) {
		
	}
	
	@Override
	public IDrawable getBackground() {
		return BACKGROUND;
	}
	
	@Override
	public String getTitle() {
		return localizedName;
	}
	
	@Override
	public String getUid() {
		return com.bartz24.skyresources.References.ModID + ":compressedWaterExtractor";
	}
	
	@Override
	public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingredients) {
		layout.getItemStacks().init(SLOT_INPUT_EXTRACTOR, true, 32, 1);
		layout.getItemStacks().init(SLOT_INPUT_STACK, true, 53, 29);
		layout.getItemStacks().init(SLOT_OUTPUT, false, 106, 15);
		layout.getFluidStacks().init(SLOT_INPUT_FLUID, false, 3, 4, 14, 42, ItemCompressedWaterExtractor.MAX_WATER_MB, true, null);
		layout.getFluidStacks().init(SLOT_OUTPUT_FLUID, false, 132, 4, 14, 42, ItemCompressedWaterExtractor.MAX_WATER_MB, false, null);
		
		List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
		List<List<FluidStack>> finputs = ingredients.getInputs(FluidStack.class);
		layout.getItemStacks().set(SLOT_INPUT_STACK, inputs.get(0));
		layout.getItemStacks().set(SLOT_INPUT_EXTRACTOR, new ItemStack(ModItems.compressedWaterExtractor));
		List<List<ItemStack>> outputs = ingredients.getOutputs(ItemStack.class);
		List<List<FluidStack>> foutputs = ingredients.getOutputs(FluidStack.class);
		layout.getItemStacks().set(SLOT_OUTPUT, outputs.get(0));
		if (finputs != null && finputs.size() > 0) layout.getFluidStacks().set(SLOT_INPUT_FLUID, finputs.get(0));
		if (foutputs != null && foutputs.size() > 0) layout.getFluidStacks().set(SLOT_OUTPUT_FLUID, foutputs.get(0));
	}
	
	@Override
	public String getModName() {
		return com.bartz24.skyresources.References.ModName;
	}
}
