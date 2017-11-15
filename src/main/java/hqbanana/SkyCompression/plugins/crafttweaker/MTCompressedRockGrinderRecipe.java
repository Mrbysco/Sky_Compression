package hqbanana.SkyCompression.plugins.crafttweaker;

import java.util.Arrays;
import java.util.Collections;

import com.bartz24.skyresources.recipe.ProcessRecipe;

import crafttweaker.api.item.IItemStack;
import hqbanana.SkyCompression.AdditionalProcessRecipesManager;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.sc.compressedrockgrinder")
public class MTCompressedRockGrinderRecipe extends MTRecipeBase
{

	@ZenMethod
	public static void addRecipe(IItemStack output, IItemStack input)
	{
		addRecipe(
				new ProcessRecipe(Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(input)), 1, "compressedRockGrinder"),
				AdditionalProcessRecipesManager.compressedRockGrinderRecipes);
	}

	@ZenMethod
	public static void addRecipe(IItemStack output, IItemStack input, float chance)
	{
		addRecipe(
				new ProcessRecipe(Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(input)), chance, "compressedRockGrinder"),
				AdditionalProcessRecipesManager.compressedRockGrinderRecipes);
	}

	@ZenMethod
	public static void removeRecipe(IItemStack output)
	{
		removeRecipe(new ProcessRecipe(Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output)), Collections.emptyList(), 0,
				"compressedRockGrinder"), AdditionalProcessRecipesManager.compressedRockGrinderRecipes);
	}

}