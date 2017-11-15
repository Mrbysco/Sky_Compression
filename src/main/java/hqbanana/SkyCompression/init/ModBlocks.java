package hqbanana.SkyCompression.init;

import hqbanana.SkyCompression.SkyCompression;
import hqbanana.SkyCompression.base.blocks.BlockCompressedCactus;
import hqbanana.SkyCompression.base.blocks.BlockCompressedClay;
import hqbanana.SkyCompression.base.blocks.BlockCompressedCobbleStone;
import hqbanana.SkyCompression.base.blocks.BlockCompressedDirt;
import hqbanana.SkyCompression.base.blocks.BlockCompressedDryCactus;
import hqbanana.SkyCompression.base.blocks.BlockCompressedEndStone;
import hqbanana.SkyCompression.base.blocks.BlockCompressedGravel;
import hqbanana.SkyCompression.base.blocks.BlockCompressedLog;
import hqbanana.SkyCompression.base.blocks.BlockCompressedNetherrack;
import hqbanana.SkyCompression.base.blocks.BlockCompressedRockCrusher;
import hqbanana.SkyCompression.base.blocks.BlockCompressedStone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {
	public static Block compressedStone, compressedCobbleStone, compressedGravel, compressedNetherrack, compressedEndStone;
	public static Block compressedDryCactus, compressedCactus, compressedDirt, compressedClay, compressedSand;
	public static Block compressedLogAcacia, compressedLogBigOak, compressedLogBirch, compressedLogJungle, compressedLogOak, compressedLogSpruce;
	public static Block compressedRockCrusher;
	
	public static void Initialize() {
		compressedStone = RegisterBlock(new BlockCompressedStone("compressedstone", 1.5f, 4.0f, Material.ROCK, 1));
		compressedCobbleStone = RegisterBlock(new BlockCompressedCobbleStone("compressedcobblestone", 2.0f, 4.0f, Material.ROCK, 1));
		compressedGravel = RegisterBlock(new BlockCompressedGravel("compressedgravel", 0.7f, 4.0f, Material.ROCK, 1));
		compressedNetherrack = RegisterBlock(new BlockCompressedNetherrack("compressednetherrack", 0.4f, 1.0f, Material.ROCK, 1));
		compressedEndStone = RegisterBlock(new BlockCompressedEndStone("compressedendstone", 3.0f, 4.0f, Material.ROCK, 1));
		compressedDryCactus = RegisterBlock(new BlockCompressedDryCactus("compresseddrycactus", 0.4f, 4.0f, Material.CACTUS, 1));;
		compressedCactus = RegisterBlock(new BlockCompressedCactus("compressedcactus", 0.4f, 4.0f, 1));
		compressedDirt = RegisterBlock(new BlockCompressedDirt("compresseddirt", 0.5f, 4.0f, Material.ROCK, 1));
		compressedClay = RegisterBlock(new BlockCompressedClay("compressedclay", 0.6f, 4.0f, Material.CLAY, 1));
		compressedSand = RegisterBlock(new BlockCompressedClay("compressedsand", 0.5f, 4.0f, Material.ROCK, 1));
		compressedRockCrusher = RegisterBlock(new BlockCompressedRockCrusher("compressedrockcrusher", 1.5f, 4.0f, Material.ROCK, 1));
		
		compressedLogAcacia = RegisterBlock(new BlockCompressedLog("compressedlogacacia", 1.8f, 4.0f, Material.WOOD, 1));
		compressedLogBigOak = RegisterBlock(new BlockCompressedLog("compressedlogbigoak", 1.8f, 4.0f, Material.WOOD, 1));
		compressedLogBirch = RegisterBlock(new BlockCompressedLog("compressedlogbirch", 1.8f, 4.0f, Material.WOOD, 1));
		compressedLogJungle = RegisterBlock(new BlockCompressedLog("compressedlogjungle", 1.8f, 4.0f, Material.WOOD, 1));
		compressedLogOak = RegisterBlock(new BlockCompressedLog("compressedlogoak", 1.8f, 4.0f, Material.WOOD, 1));
		compressedLogSpruce = RegisterBlock(new BlockCompressedLog("compressedlogspruce", 1.8f, 4.0f, Material.WOOD, 1));

	}
	
	public static Block RegisterBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(SkyCompression.SKY_COMPRESSION_TAB);
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);
		return block;
	}
	
	public static void RegisterRenders() {
		RegisterBlockRenderer(compressedStone);
		RegisterBlockRenderer(compressedEndStone);
		RegisterBlockRenderer(compressedCobbleStone);
		RegisterBlockRenderer(compressedGravel);
		RegisterBlockRenderer(compressedNetherrack);
		RegisterBlockRenderer(compressedDryCactus);
		RegisterBlockRenderer(compressedCactus);
		RegisterBlockRenderer(compressedDirt);
		RegisterBlockRenderer(compressedClay);
		RegisterBlockRenderer(compressedSand);
		RegisterBlockRenderer(compressedRockCrusher);
		
		RegisterBlockRenderer(compressedLogAcacia);
		RegisterBlockRenderer(compressedLogBigOak);
		RegisterBlockRenderer(compressedLogBirch);
		RegisterBlockRenderer(compressedLogJungle);
		RegisterBlockRenderer(compressedLogOak);
		RegisterBlockRenderer(compressedLogSpruce);
	}
	
	private static void RegisterBlockRenderer(Block block, int meta, ResourceLocation name) {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), name);
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(name.toString()));
	}
	
	private static void RegisterBlockRenderer(Block block, int meta) {
		RegisterBlockRenderer(block, meta, new ResourceLocation(block.getRegistryName().toString() + meta));
	}
	
	private static void RegisterBlockRenderer(Block block) {
		RegisterBlockRenderer(block, block.getRegistryName());
	}
	
	private static void RegisterBlockRenderer(Block block, ResourceLocation name) {
		RegisterBlockRenderer(block, 0, name);
	}
}
