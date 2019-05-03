package hqbanana.skycompression.base.blocks;

import hqbanana.skycompression.Reference;
import hqbanana.skycompression.SkyCompression;
import hqbanana.skycompression.base.tile.TileCompressedRockCrusher;
import hqbanana.skycompression.handlers.ModGuiHandler;
import hqbanana.skycompression.init.ModBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockCompressedRockCrusher extends BlockContainer {
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockCompressedRockCrusher(String name, float hardness, float resistance, Material material, int harvestLevel) {
		super(material);
		setTranslationKey(Reference.MOD_ID + "." + name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		this.setDefaultState(this.blockState.getBaseState());
		this.setCreativeTab(SkyCompression.SKY_COMPRESSION_TAB);
		this.hasTileEntity = true;
	}
	
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.compressedRockCrusher);
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.setDefaultFacing(worldIn, pos, state);
	}
	
	public void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			IBlockState iBlockState1 = worldIn.getBlockState(pos.north());
			IBlockState iBlockState2 = worldIn.getBlockState(pos.south());
			IBlockState iBlockState3 = worldIn.getBlockState(pos.west());
			IBlockState iBlockState4 = worldIn.getBlockState(pos.east());
			EnumFacing enumFacing = (EnumFacing)state.getValue(FACING);
			
			if (enumFacing == EnumFacing.NORTH && iBlockState1.isFullBlock() && !iBlockState2.isFullBlock()) enumFacing = EnumFacing.SOUTH;
			else if (enumFacing == EnumFacing.SOUTH && iBlockState2.isFullBlock() && !iBlockState1.isFullBlock()) enumFacing = EnumFacing.NORTH;
			else if (enumFacing == EnumFacing.WEST && iBlockState3.isFullBlock() && !iBlockState4.isFullBlock()) enumFacing = EnumFacing.EAST;
			else if (enumFacing == EnumFacing.EAST && iBlockState4.isFullBlock() && !iBlockState3.isFullBlock()) enumFacing = EnumFacing.WEST;
			
			worldIn.setBlockState(pos, state.withProperty(FACING, enumFacing), 2);
		}
	}
	
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hiZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	public void OnBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumFacing = EnumFacing.byHorizontalIndex(meta);
		return this.getDefaultState().withProperty(FACING, enumFacing);
	}
	
	//Convert the BlockState into the correct metadata value
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		return i;
	}
	
	//Return the blockstate witht he given rotation fromt he apssed blockstate. If inapplicable, returns the passed blockstate
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	//Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed blockstate
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileCompressedRockCrusher();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			player.openGui(SkyCompression.instance, ModGuiHandler.COMPRESSED_ROCK_CLEANER_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileCompressedRockCrusher te = (TileCompressedRockCrusher) world.getTileEntity(pos);
		te.dropInventory();
		super.breakBlock(world, pos, state);
	}
}
