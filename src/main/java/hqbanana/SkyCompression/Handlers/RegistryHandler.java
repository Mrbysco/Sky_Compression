package hqbanana.SkyCompression.Handlers;

import com.bartz24.skyresources.base.guide.SkyResourcesGuide;

import hqbanana.SkyCompression.init.ModBlocks;
import hqbanana.SkyCompression.init.ModItems;
import net.minecraft.item.ItemStack;

public class RegistryHandler {
	public static void Client() {
		ModItems.RegisterRenders();
		ModBlocks.RegisterRenders();
		AddGuidePages();
	}
	
	public static void Common() {
		ModItems.Initialize();
		ModBlocks.Initialize();
		new ModGuiHandler();
	}
	
	private static void AddGuidePages() {
		SkyResourcesGuide.addPage("compression", "guide.skyresources.compression", new ItemStack(ModBlocks.compressedStone));
		SkyResourcesGuide.addPage("compressedwaterextracting", "guide.skyresources.compression", new ItemStack(ModItems.compressedWaterExtractor));
		SkyResourcesGuide.addPage("compressedCactus", "guide.skyresources.compression", new ItemStack(ModBlocks.compressedCactus));
		SkyResourcesGuide.addPage("compressedAutomation", "guide.skyresources.compression", new ItemStack(ModBlocks.compressedRockCrusher));
	}
}
