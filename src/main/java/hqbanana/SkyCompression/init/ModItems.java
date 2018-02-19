package hqbanana.SkyCompression.init;

import hqbanana.SkyCompression.base.items.CustomItem;
import hqbanana.SkyCompression.base.tools.ItemCompressedKnife;
import hqbanana.SkyCompression.base.tools.ItemCompressedRockGrinder;
import hqbanana.SkyCompression.base.tools.ItemCompressedWaterExtractor;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems {
	public static Item compressedWaterExtractor;
	public static Item compressedStoneRockGrinder, compressedIronRockGrinder, compressedDiamondRockGrinder;
	public static Item compressedCactusKnife, compressedStoneKnife, compressedIronKnife, compressedDiamondKnife;
	public static Item compressedStick;
	//public static ToolMaterial cheeseSwordMaterial = EnumHelper.addToolMaterial("TutorialTool", 3, 2159, 11.0F, 3.5F, 16);
	
	public static ToolMaterial materialCactusNeedle = EnumHelper
			.addToolMaterial("CACTUSNEEDLE", 0, 4, 5, 1, 5);
	
	public static void Initialize() {
		compressedWaterExtractor = RegisterItem(new ItemCompressedWaterExtractor("compressedwaterextractor"));
		compressedStoneRockGrinder = RegisterItem(new ItemCompressedRockGrinder(ToolMaterial.STONE, "compressedrockgrinder"));
		compressedIronRockGrinder = RegisterItem(new ItemCompressedRockGrinder(ToolMaterial.IRON, "compressedirongrinder"));
		compressedDiamondRockGrinder = RegisterItem(new ItemCompressedRockGrinder(ToolMaterial.DIAMOND, "compresseddiamondgrinder"));
		compressedCactusKnife = RegisterItem(new ItemCompressedKnife(materialCactusNeedle, "compressedcactusknife"));
		compressedStoneKnife = RegisterItem(new ItemCompressedKnife(ToolMaterial.STONE, "compressedstoneknife"));
		compressedIronKnife = RegisterItem(new ItemCompressedKnife(ToolMaterial.IRON, "compressedironknife"));
		compressedDiamondKnife = RegisterItem(new ItemCompressedKnife(ToolMaterial.DIAMOND, "compresseddiamondknife"));
		compressedStick = RegisterItem(new CustomItem("compressedstick"));
	}
	
	public static Item RegisterItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
		return item;
	}
	
	public static void RegisterRenders() {
		RegisterItemRenderer(compressedWaterExtractor);
		RegisterItemRenderer(compressedStoneRockGrinder);
		RegisterItemRenderer(compressedIronRockGrinder);
		RegisterItemRenderer(compressedDiamondRockGrinder);
		RegisterItemRenderer(compressedCactusKnife);
		RegisterItemRenderer(compressedStoneKnife);
		RegisterItemRenderer(compressedIronKnife);
		RegisterItemRenderer(compressedDiamondKnife);
		RegisterItemRenderer(compressedStick);
	}
	
	private static void RegisterItemRenderer(Item item, int meta, ResourceLocation name) {
		ModelBakery.registerItemVariants(item, name);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
	}
	
	private static void RegisterItemRenderer(Item item, int meta) {
		RegisterItemRenderer(item, meta, new ResourceLocation(item.getRegistryName().toString() + meta));
	}
	
	private static void RegisterItemRenderer(Item item) {
		RegisterItemRenderer(item, item.getRegistryName());
	}
	
	private static void RegisterItemRenderer(Item item, ResourceLocation name) {
		RegisterItemRenderer(item, 0, name);
	}
}
