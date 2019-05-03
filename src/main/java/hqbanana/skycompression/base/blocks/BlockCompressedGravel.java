package hqbanana.skycompression.base.blocks;

import net.minecraft.block.material.Material;

public class BlockCompressedGravel extends CustomBlock {
	public BlockCompressedGravel(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("shovel", harvestLevel);
	}
}
