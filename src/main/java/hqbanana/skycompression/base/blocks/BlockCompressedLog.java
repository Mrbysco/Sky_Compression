package hqbanana.skycompression.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCompressedLog extends CustomBlock {
	public BlockCompressedLog(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("axe", harvestLevel);
		Blocks.FIRE.setFireInfo(this, 5, 5);
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
}
