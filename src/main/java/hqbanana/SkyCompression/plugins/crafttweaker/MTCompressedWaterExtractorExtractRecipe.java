package hqbanana.SkyCompression.plugins.crafttweaker;

import java.util.Arrays;

import com.bartz24.skyresources.recipe.ProcessRecipe;

import crafttweaker.api.item.IItemStack;
import hqbanana.SkyCompression.AdditionalProcessRecipesManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.sc.compressedwaterextractor.extract")
public class MTCompressedWaterExtractorExtractRecipe extends MTRecipeBase
{
	@ZenMethod
	public static void addRecipe(int waterOut, IItemStack output, IItemStack input)
	{
		addRecipe(
				new ProcessRecipe(
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output),
								new FluidStack(FluidRegistry.WATER, waterOut)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(input)), 0, "compressedWaterExtractor-extract"),
				AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes);
	}

	@ZenMethod
	public static void removeRecipe(int waterOut, IItemStack output, IItemStack input)
	{
		removeRecipe(
				new ProcessRecipe(
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output),
								new FluidStack(FluidRegistry.WATER, waterOut)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(input)), 0, "compressedWaterExtractor-extract"),
				AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes);
	}

}