package hqbanana.SkyCompression.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCompressedDryCactus extends CustomBlock {
	private static final int COMPRESSION_MULTIPLIER = 9;
	protected static final AxisAlignedBB COLISSION_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);
	
	public BlockCompressedDryCactus(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		this.setDefaultState(this.blockState.getBaseState());
	}
	
	public boolean isFullCube(IBlockState state) {
        return true;
    }
	
	public boolean isOpaqueCube(IBlockState state) {
	    return true;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return COLISSION_AABB;
    }
}