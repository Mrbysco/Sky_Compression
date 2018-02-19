package hqbanana.SkyCompression.base.blocks;

import java.util.Random;

import hqbanana.SkyCompression.config.AdditionalConfigOptions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockCompressedSnad extends CustomBlock {
	
	public BlockCompressedSnad(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("shovel", harvestLevel);
		setTickRandomly(true);
	}
	
	@Override
    public void randomTick(World world, BlockPos position, IBlockState state, Random random) {
        super.randomTick(world, position, state, random);

        Block blockAbove = world.getBlockState(position.up()).getBlock();
        if (blockAbove instanceof BlockCompressedCactus) {
            checkColumnOfPlant(world, position, random, blockAbove);
        } else if (blockAbove instanceof IPlantable) {
            blockAbove.randomTick(world, position.up(), world.getBlockState(position.up()), random);
        }
	}
	
	private void checkColumnOfPlant(World world, BlockPos originalPosition, Random random, Block blockAbove) {
        Block nextPlantBlock;
        for (BlockPos nextPosition = originalPosition.up(); (nextPlantBlock = world.getBlockState(nextPosition).getBlock()).getClass().equals(blockAbove.getClass()); nextPosition = nextPosition.up()) {
            growthLoop(world, originalPosition, random, (IPlantable) blockAbove, nextPosition, nextPlantBlock);
        }
	
	}
	
	private void growthLoop(World world, BlockPos orignalPosition, Random random, IPlantable blockAbove, BlockPos nextPosition, Block nextPlantBlock) {
        for (int growthAttempts = 0; growthAttempts < AdditionalConfigOptions.modsupport.snadSpeedIncrease; growthAttempts++) {
            if (growthAttempts == 0 || canSustainPlant(world.getBlockState(orignalPosition), world, orignalPosition, null, blockAbove)) {
                nextPlantBlock.randomTick(world, nextPosition, world.getBlockState(nextPosition), random);
            }
        }
	}
	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		BlockPos plant = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		EnumPlantType plantType = plantable.getPlantType(world, plant);

		switch (plantType) {
	        case Desert:
	            return true;
	        default: {
	            return false;
	        }
		}
	}
}
