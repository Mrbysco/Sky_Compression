package hqbanana.SkyCompression.base.blocks;

import net.minecraft.block.material.Material;

public class BlockCompressedEndStone extends CustomBlock {
	public BlockCompressedEndStone(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("pickaxe", harvestLevel);
	}
}
