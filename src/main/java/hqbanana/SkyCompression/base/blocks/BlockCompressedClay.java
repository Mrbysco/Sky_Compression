package hqbanana.SkyCompression.base.blocks;

import java.util.Random;

import com.bartz24.skyresources.RandomHelper;
import com.bartz24.skyresources.alchemy.item.AlchemyItemComponent;

import hqbanana.SkyCompression.base.tools.ItemCompressedRockGrinder;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
