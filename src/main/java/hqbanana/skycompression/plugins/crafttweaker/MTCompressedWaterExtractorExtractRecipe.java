package hqbanana.skycompression.plugins.crafttweaker;

import com.bartz24.skyresources.recipe.ProcessRecipe;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import hqbanana.skycompression.AdditionalProcessRecipesManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;

@ZenClass("mods.sc.compressedwaterextractor.extract")
public class MTCompressedWaterExtractorExtractRecipe extends MTRecipeBase
{
	@ZenMethod
	public static void addRecipe(int waterOut, IItemStack output, IIngredient input)
	{
		addRecipe(
				new ProcessRecipe(
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output),
								new FluidStack(FluidRegistry.WATER, waterOut)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toObject(input)), 0, "compressedWaterExtractor-extract"),
				AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes);
	}

	@ZenMethod
	public static void removeRecipe(int waterOut, IItemStack output, IIngredient input)
	{
		removeRecipe(
				new ProcessRecipe(
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output),
								new FluidStack(FluidRegistry.WATER, waterOut)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toObject(input)), 0, "compressedWaterExtractor-extract"),
				AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes);
	}

}