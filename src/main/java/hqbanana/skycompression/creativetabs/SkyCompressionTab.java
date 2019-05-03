package hqbanana.skycompression.creativetabs;

import hqbanana.skycompression.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SkyCompressionTab extends CreativeTabs {

	public SkyCompressionTab(String label) {
		super(label);
		this.setBackgroundImageName("skycompressiontab.png");
	}

	public ItemStack createIcon() {
		return new ItemStack(ModBlocks.compressedStone);
	}
}
