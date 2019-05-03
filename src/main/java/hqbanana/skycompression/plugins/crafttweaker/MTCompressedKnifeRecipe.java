package hqbanana.skycompression.plugins.crafttweaker;

import com.bartz24.skyresources.recipe.ProcessRecipe;
import crafttweaker.api.item.IItemStack;
import hqbanana.skycompression.AdditionalProcessRecipesManager;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Collections;

@ZenClass("mods.sc.compressedknife")
public class MTCompressedKnifeRecipe extends MTRecipeBase
{

	@ZenMethod
	public static void addRecipe(IItemStack output, IItemStack input)
	{
		addRecipe(
				new ProcessRecipe(Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output)),
						Arrays.asList(AdditionalCraftTweakerPlugin.toStack(input)), 1, "compressedKnife"),
				AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes);
	}
	@ZenMethod
	public static void removeRecipe(IItemStack output)
	{
		removeRecipe(new ProcessRecipe(Arrays.asList(AdditionalCraftTweakerPlugin.toStack(output)), Collections.emptyList(), 0,
				"compressedKnife"), AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes);
	}

}