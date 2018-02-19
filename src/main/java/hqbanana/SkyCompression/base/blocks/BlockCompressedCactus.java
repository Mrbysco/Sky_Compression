package hqbanana.SkyCompression.base.blocks;

import java.util.Random;

import com.bartz24.skyresources.RandomHelper;
import com.bartz24.skyresources.alchemy.item.AlchemyItemComponent;

import hqbanana.SkyCompression.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class BlockCompressedCactus extends BlockCactus{
	private static final int COMPRESSION_MULTIPLIER = 9;
	protected static final AxisAlignedBB COLISSION_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);
	
	public BlockCompressedCactus(String name, float hardness, float resistance, int harvestLevel) {
		super();
		setUnlocalizedName(Reference.MOD_ID + "." + name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
        this.setTickRandomly(true);
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 2;
	}
	
	public boolean isFullCube(IBlockState state) {
        return true;
    }
	
	public boolean isOpaqueCube(IBlockState state) {
	    return true;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote && playerIn.isSneaking() && playerIn.inventory.getCurrentItem().isEmpty()) {
			RandomHelper.spawnItemInWorld(worldIn, new ItemStack(com.bartz24.skyresources.registry.ModItems.alchemyComponent, COMPRESSION_MULTIPLIER,
                    ((AlchemyItemComponent) com.bartz24.skyresources.registry.ModItems.alchemyComponent).getNames().indexOf("cactusNeedle")),
                    playerIn.getPosition());
			playerIn.attackEntityFrom(DamageSource.CACTUS, 15);
			return true;
		}
		else
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return COLISSION_AABB;
    }
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.attackEntityFrom(DamageSource.CACTUS, 15);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            worldIn.destroyBlock(pos, true);
        }
    }
	
	@Override	
	public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos.down());

        for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
        {
            Material material = worldIn.getBlockState(pos.offset(enumfacing)).getMaterial();

            if (material.isSolid() || material == Material.LAVA)
            {
                return false;
            }
        }
        
        boolean flag = state.getBlock().getUnlocalizedName().contains("compressedsand");
        boolean flag2 = state.getBlock().getUnlocalizedName().contains("compressedredsand");
        boolean flag3 = state.getBlock().getUnlocalizedName().contains("compressedsnad");
        boolean flag4 = state.getBlock().getUnlocalizedName().contains("compressedredsnad");
        
        return !worldIn.getBlockState(pos.up()).getMaterial().isLiquid() && (flag || flag2 || flag3 || flag4 || state.getBlock() == this);
    }
	
	@Override	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        BlockPos blockpos = pos.up();

        if (worldIn.isAirBlock(blockpos))
        {
            int i;

            for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i)
            {
                ;
            }

            if (i < 3)
            {
                int j = ((Integer)state.getValue(AGE)).intValue();

                if(ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true))
                {
	                if (j == 15)
	                {
	                    worldIn.setBlockState(blockpos, this.getDefaultState());
	                    IBlockState iblockstate = state.withProperty(AGE, Integer.valueOf(0));
	                    worldIn.setBlockState(pos, iblockstate, 4);
	                    iblockstate.neighborChanged(worldIn, blockpos, this, pos);
	                }
	                else
	                {
	                	if(worldIn.rand.nextInt(9) < 1)
	                	{
	                		worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
	                	}
	                }
	                ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            }
        }
    }
}