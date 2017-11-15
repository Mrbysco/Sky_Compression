package hqbanana.SkyCompression.base.tools;

import java.util.Collections;

import com.bartz24.skyresources.RandomHelper;
import com.bartz24.skyresources.recipe.ProcessRecipe;
import com.google.common.collect.Multimap;

import hqbanana.SkyCompression.AdditionalProcessRecipesManager;
import hqbanana.SkyCompression.ItemHelper;
import hqbanana.SkyCompression.Reference;
import hqbanana.SkyCompression.SkyCompression;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCompressedKnife extends ItemAxe 
{
	private float damageVsEntity;
	
	ToolMaterial toolMaterial;
	
	public ItemCompressedKnife(ToolMaterial material, String name) {
		super(material, (float) (com.bartz24.skyresources.config.ConfigOptions.toolSettings.knifeBaseDamage + material.getAttackDamage()), -3);
		setUnlocalizedName(Reference.MOD_ID + "." + name);
		setRegistryName(name);
		setCreativeTab(SkyCompression.SKY_COMPRESSION_TAB);
		toolMaterial = material;
		//this.setMaxDamage((int)(material.getMaxUses() * 5)); //ConfigOptions.toolSettings.knifeBaseDurability (see how he did this)
		//this.damageVsEntity = 2 + material.getAttackDamage(); //See above statement
		this.setMaxStackSize(1);
		this.setHarvestLevel("knife", material.getHarvestLevel());
		this.setMaxDamage((int)(material.getMaxUses() * com.bartz24.skyresources.config.ConfigOptions.toolSettings.knifeBaseDurability));
		ItemHelper.addKnife(this);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
	{
		Block block = state.getBlock();

		ProcessRecipe rec = new ProcessRecipe(
				Collections.singletonList(new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state))),
				Integer.MAX_VALUE, "compressedKnife");

		ProcessRecipe recipe = AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.getRecipe(
				new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state)), 0, false, false);

		if (recipe != null)
		{
			if (toolMaterial.getHarvestLevel() < block.getHarvestLevel(state))
				return super.getDestroySpeed(stack, state);
			else
			{
				return toolMaterial.getEfficiency();
			}
		}
		return super.getDestroySpeed(stack, state);

	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, BlockPos pos, EntityPlayer player)
	{
		World world = player.world;
		IBlockState state = world.getBlockState(pos);
		if (item.attemptDamageItem(1, this.itemRand, null))
		{
			player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
		}

		ProcessRecipe recipe = AdditionalProcessRecipesManager.compressedCuttingKnifeRecipes.getRecipe(
				new ItemStack(state.getBlock(), 1, state.getBlock().getMetaFromState(state)), 0, false, false);
		if (recipe != null)
		{
			if (!world.isRemote)
			{
				int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, item);
				float chance = (((float) level + 3F) / 3F);
				while (chance >= 1)
				{
					RandomHelper.spawnItemInWorld(world, recipe.getOutputs().get(0).copy(), pos);
					chance -= 1;
				}
				if (itemRand.nextFloat() <= chance)
					RandomHelper.spawnItemInWorld(world, recipe.getOutputs().get(0).copy(), pos);
			}
			world.destroyBlock(pos, false);
			return true;
		}
		
		world.destroyBlock(pos, true);
		return false;
	}
	
	public ToolMaterial GetMaterial() {
		return toolMaterial;
	}
	
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) 
	{
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
		
		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) 
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), 
					new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damageVsEntity, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), 
					new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.8000000953674316D, 0));		
		}
		return multimap;
	}
}