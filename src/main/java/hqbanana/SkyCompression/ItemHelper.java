package hqbanana.SkyCompression;

import java.util.ArrayList;
import java.util.List;

import hqbanana.SkyCompression.base.tools.ItemCompressedKnife;
import hqbanana.SkyCompression.base.tools.ItemCompressedRockGrinder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemHelper {
	private static List<ItemStack> rockGrinders = new ArrayList<ItemStack>();
	
	public static List<ItemStack> GetCompressedRockGrinders() {
		return rockGrinders;
	}
	
	public static void AddRockGrinder(ItemCompressedRockGrinder compressedRockGrinder) {
		rockGrinders.add(new ItemStack(compressedRockGrinder));
	}
	
	private static List<ItemStack> knives = new ArrayList<ItemStack>();

	public static List<ItemStack> getCompressedKnives()
	{
		return knives;
	}

	public static void addKnife(ItemCompressedKnife compressedKnife)
	{
		knives.add(new ItemStack(compressedKnife));
	}
	
	public static boolean ItemStacksEqual(ItemStack stack1, ItemStack stack2) {
		if (stack1.isItemEqual(stack2)) return true;
		else if (!stack1.isEmpty() && !stack2.isEmpty() && stack1.getMetadata() == OreDictionary.WILDCARD_VALUE || stack2.getMetadata() == OreDictionary.WILDCARD_VALUE) {
			return stack1.getItem() == stack2.getItem();
		}
		return false;
	}
}
