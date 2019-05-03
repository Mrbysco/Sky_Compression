package hqbanana.skycompression.plugins.jei;

import hqbanana.skycompression.AdditionalProcessRecipesManager;
import hqbanana.skycompression.ItemHelper;
import hqbanana.skycompression.init.ModItems;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
	@Override
	public void onRuntimeAvailable(IJeiRuntime arg0) {
		
	}

	@Override
	public void register(IModRegistry registry) {
		registry.addRecipes(AdditionalProcessRecipesManager.compressedRockGrinderRecipes.getRecipes(), com.bartz24.skyresources.References.ModID + ":compressedRockGrinder");
		registry.addRecipes(AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.getRecipes(), com.bartz24.skyresources.References.ModID + ":compressedKnife");
		registry.addRecipes(AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes.getRecipes(), com.bartz24.skyresources.References.ModID + ":compressedWaterExtractor");
		registry.addRecipes(AdditionalProcessRecipesManager.compressedWaterExtractorInsertionRecipes.getRecipes(), com.bartz24.skyresources.References.ModID + ":compressedWaterExtractor");
		
		for (ItemStack i : ItemHelper.GetCompressedRockGrinders()) {
			registry.addRecipeCatalyst(i, com.bartz24.skyresources.References.ModID + ":compressedRockGrinder");
		}
		for (ItemStack i : ItemHelper.getCompressedKnives()) {
			registry.addRecipeCatalyst(i, com.bartz24.skyresources.References.ModID + ":compressedKnife");
		}
		
		registry.addRecipeCatalyst(new ItemStack(ModItems.compressedWaterExtractor), com.bartz24.skyresources.References.ModID + ":compressedWaterExtractor");
	}

	@Override
	public void registerIngredients(IModIngredientRegistration imodingredientregistration) {

	}

	@Override
	public void registerItemSubtypes(ISubtypeRegistry isubtyperegistry) {

	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		registry.addRecipeCategories(new CompressedCuttingKnifeRecipeCategory(jeiHelpers.getGuiHelper()),
				new CompressedRockGrinderRecipeCategory(jeiHelpers.getGuiHelper()),
				new CompressedWaterExtractorRecipeCategory(jeiHelpers.getGuiHelper()));
	}
}
