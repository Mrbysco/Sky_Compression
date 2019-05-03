package hqbanana.skycompression.init;

import com.bartz24.skyresources.RandomHelper;
import com.google.common.base.Strings;
import hqbanana.skycompression.AdditionalProcessRecipesManager;
import hqbanana.skycompression.SkyCompression;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class ModCrafting {
	private static final int COMPRESSION_MULTIPLIER = 7;
	
	public static void Register() {
		AddAdditionalProcessRecipes();
	}
	
	private static void AddAdditionalProcessRecipes() {
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(Blocks.GRAVEL), 9, "compressed1xCobblestone");
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(Blocks.SAND), 9, "compressed1xGravel");
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(Items.FLINT), COMPRESSION_MULTIPLIER * 0.3F, "compressed1xGravel");
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.techComponent, 1, 3), COMPRESSION_MULTIPLIER, "compressed1xNetherrack");
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.techComponent, 1, 0), COMPRESSION_MULTIPLIER, new ItemStack(ModBlocks.compressedStone));

		
		//Adding the old recipes to the rock grinder
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(Blocks.GRAVEL), 1, new ItemStack(Blocks.COBBLESTONE));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(Blocks.SAND), 1, new ItemStack(Blocks.GRAVEL));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(Items.FLINT), 0.3F, new ItemStack(Blocks.GRAVEL));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), COMPRESSION_MULTIPLIER * 1.5F, new ItemStack(ModBlocks.compressedLogAcacia));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), COMPRESSION_MULTIPLIER * 1.5F, new ItemStack(ModBlocks.compressedLogBigOak));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), COMPRESSION_MULTIPLIER * 1.5F, new ItemStack(ModBlocks.compressedLogBirch));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), COMPRESSION_MULTIPLIER * 1.5F, new ItemStack(ModBlocks.compressedLogJungle));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), COMPRESSION_MULTIPLIER * 1.5F, new ItemStack(ModBlocks.compressedLogOak));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), COMPRESSION_MULTIPLIER * 1.5F, new ItemStack(ModBlocks.compressedLogSpruce));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.techComponent, 1, 0), 1, new ItemStack(Blocks.STONE));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.techComponent, 1, 3), 1, new ItemStack(Blocks.NETHERRACK));
		AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.baseComponent, 1, 5), 1.5F, "logWood");
		//
			
		//Adding the old extracting recipes to the water extractor
		AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes.addRecipe(new ArrayList<Object>(Arrays.asList(
				new ItemStack(com.bartz24.skyresources.registry.ModBlocks.dryCactus), new FluidStack(FluidRegistry.WATER, 50))), 0, new ItemStack(Blocks.CACTUS));	
		AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes.addRecipe(new ArrayList<Object>(Arrays.asList(
				ItemStack.EMPTY, new FluidStack(FluidRegistry.WATER, 50))), 0, new ItemStack(Blocks.SNOW));
		AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes.addRecipe(new ArrayList<Object>(Arrays.asList(
				ItemStack.EMPTY, new FluidStack(FluidRegistry.WATER, 20))), 0, "treeLeaves");
		AdditionalProcessRecipesManager.compressedWaterExtractorInsertionRecipes.addRecipe(new ItemStack(Blocks.CLAY), 0, 
				Arrays.asList(new ItemStack(Blocks.DIRT), new FluidStack(FluidRegistry.WATER, 200)));
		AdditionalProcessRecipesManager.compressedWaterExtractorInsertionRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModBlocks.dryCactus), 0, 
				Arrays.asList(new ItemStack(Blocks.CACTUS), new FluidStack(FluidRegistry.WATER, 50)));
		//
		AdditionalProcessRecipesManager.compressedWaterExtractorExtractionRecipes.addRecipe(new ArrayList<Object>(Arrays.asList(
				new ItemStack(ModBlocks.compressedDryCactus), new FluidStack(FluidRegistry.WATER, 450))), 0, new ItemStack(ModBlocks.compressedCactus));	
		
		
		AdditionalProcessRecipesManager.compressedWaterExtractorInsertionRecipes.addRecipe(new ItemStack(ModBlocks.compressedClay), 0, 
				Arrays.asList("compressed1xDirt", new FluidStack(FluidRegistry.WATER, 1800)));
		AdditionalProcessRecipesManager.compressedWaterExtractorInsertionRecipes.addRecipe(new ItemStack(ModBlocks.compressedCactus), 0,
				Arrays.asList(new ItemStack(ModBlocks.compressedDryCactus), new FluidStack(FluidRegistry.WATER, 10800)));
		AdditionalProcessRecipesManager.compressedWaterExtractorInsertionRecipes.addRecipe(new ItemStack(Blocks.CACTUS), 0,
				Arrays.asList(new ItemStack(com.bartz24.skyresources.registry.ModBlocks.dryCactus), new FluidStack(FluidRegistry.WATER, 1200)));
		
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.cactusFruit, 18), 0,
				new ItemStack(ModBlocks.compressedCactus, 1, OreDictionary.WILDCARD_VALUE));
		
		//Adding the old recipes
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.cactusFruit, 2), 0,
				new ItemStack(Blocks.CACTUS, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.MELON, 9), 0,
				new ItemStack(Blocks.MELON_BLOCK, 1, OreDictionary.WILDCARD_VALUE));
		//Adding the new knife recipes
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 54, 4), 0,
				new ItemStack(ModBlocks.compressedLogAcacia, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 54, 5), 0,
				new ItemStack(ModBlocks.compressedLogBigOak, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 54, 2), 0,
				new ItemStack(ModBlocks.compressedLogBirch, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 54, 3), 0,
				new ItemStack(ModBlocks.compressedLogJungle, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 54, 0), 0,
				new ItemStack(ModBlocks.compressedLogOak, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 54, 1), 0,
				new ItemStack(ModBlocks.compressedLogSpruce, 1, OreDictionary.WILDCARD_VALUE));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModBlocks.petrifiedPlanks, 54), 0,
				new ItemStack(ModBlocks.compressedPetrifiedWood, 1, OreDictionary.WILDCARD_VALUE));
		
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(Blocks.PLANKS, 1, 4));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(Blocks.PLANKS, 1, 5));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(Blocks.PLANKS, 1, 2));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(Blocks.PLANKS, 1, 3));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(Blocks.PLANKS, 1, 0));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(Blocks.PLANKS, 1, 1));
		AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.addRecipe(new ItemStack(Items.STICK, 6), 0,
				new ItemStack(com.bartz24.skyresources.registry.ModBlocks.petrifiedPlanks, 1));
		//
		
		
		//Manually adding the Gem Recipes to the rock grinder
		for (int i = 0; i < com.bartz24.skyresources.registry.ModItems.gemList.size(); i++) {
			Object block = GetCompressedVariant(com.bartz24.skyresources.registry.ModItems.gemList.get(i).parentBlock);
			String oreName = Strings.isNullOrEmpty(com.bartz24.skyresources.registry.ModItems.gemList.get(i).oreOverride)
                    ? ("gem" + RandomHelper.capatilizeString(com.bartz24.skyresources.registry.ModItems.gemList.get(i).name))
                    : com.bartz24.skyresources.registry.ModItems.gemList.get(i).oreOverride;
			if (com.bartz24.skyresources.config.ConfigOptions.miscSettings.allowAllGemTypes || OreDictionary.getOres(oreName).size() > 0)
			{
				AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.dirtyGem, 1, i),
						com.bartz24.skyresources.registry.ModItems.gemList.get(i).rarity * COMPRESSION_MULTIPLIER, block);
				AdditionalProcessRecipesManager.compressedRockGrinderRecipes.addRecipe(new ItemStack(com.bartz24.skyresources.registry.ModItems.dirtyGem, 1, i),
						com.bartz24.skyresources.registry.ModItems.gemList.get(i).rarity, com.bartz24.skyresources.registry.ModItems.gemList.get(i).parentBlock);
			}
		}
		//
	}
	
	public static void initOreDict() {
		OreDictionary.registerOre("compressed1xCobblestone", new ItemStack(ModBlocks.compressedCobbleStone));
		OreDictionary.registerOre("compressed1xGravel", new ItemStack(ModBlocks.compressedGravel));
		OreDictionary.registerOre("compressed1xNetherrack", new ItemStack(ModBlocks.compressedNetherrack));
		OreDictionary.registerOre("compressed1xDirt", new ItemStack(ModBlocks.compressedDirt));
		OreDictionary.registerOre("compressed1xSand", new ItemStack(ModBlocks.compressedSand));
	}
    
    private static Object GetCompressedVariant(ItemStack parentBlock) {
    	Object block = ItemStack.EMPTY;
		if (parentBlock.isItemEqual(new ItemStack(Blocks.STONE))) block = new ItemStack(ModBlocks.compressedStone);
		else if(parentBlock.isItemEqual(new ItemStack(Blocks.GRAVEL))) block = "compressed1xGravel";
		else if(parentBlock.isItemEqual(new ItemStack(Blocks.NETHERRACK))) block = "compressed1xNetherrack";
		else if(parentBlock.isItemEqual(new ItemStack(Blocks.END_STONE))) block = new ItemStack(ModBlocks.compressedEndStone);
		else SkyCompression.logger.error("Invalid item input: " + parentBlock.getItem().getRegistryName());
		return block;
    }
}
