package hqbanana.SkyCompression.base.blocks;

import net.minecraft.block.material.Material;

public class BlockCompressedDirt extends CustomBlock {
	public BlockCompressedDirt(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("shovel", harvestLevel);
	}
}
