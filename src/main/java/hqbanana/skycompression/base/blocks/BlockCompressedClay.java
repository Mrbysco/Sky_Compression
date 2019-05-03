package hqbanana.skycompression.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCompressedClay extends CustomBlock {
	Item drop;
	int meta;
	
	public BlockCompressedClay(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("shovel", harvestLevel);
		drop = Items.CLAY_BALL;
		meta = 0;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.drop;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.meta;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 36;
	}
}
