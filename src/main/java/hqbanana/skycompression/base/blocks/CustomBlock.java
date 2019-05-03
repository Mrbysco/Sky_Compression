package hqbanana.skycompression.base.blocks;

import hqbanana.skycompression.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class CustomBlock extends Block {
	public CustomBlock(String name, float hardness, float resistance, Material material) {
		super(material);
		setTranslationKey(Reference.MOD_ID + "." + name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}