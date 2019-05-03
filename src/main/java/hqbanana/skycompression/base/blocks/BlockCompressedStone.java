package hqbanana.skycompression.base.blocks;

import net.minecraft.block.material.Material;

public class BlockCompressedStone extends CustomBlock{
	public BlockCompressedStone(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("pickaxe", harvestLevel);
	}
}
