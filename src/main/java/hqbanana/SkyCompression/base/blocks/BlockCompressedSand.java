package hqbanana.SkyCompression.base.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BlockCompressedSand extends CustomBlock{
	
	//protected Item sand = Item.getItemFromBlock(Blocks.SAND);

	public BlockCompressedSand(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(name, hardness, resistance, material);
		setHarvestLevel("shovel", harvestLevel);
	}
	
	/*
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return sand;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		if (this.getUnlocalizedName().contains("red"))
			return 1;
		else
			return 0;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 9;
	}
	*/
	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		IBlockState plant = plantable.getPlant(world, pos.offset(direction));
        net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));

        if (plant.getBlock() instanceof BlockCompressedCactus)
        {
            return true;
        }

        return false;
	}
}
