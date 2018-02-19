package hqbanana.SkyCompression.base.items;

import hqbanana.SkyCompression.Reference;
import net.minecraft.item.Item;

public class CustomItem extends Item {
	
	public CustomItem(String name) {
		super();
		setUnlocalizedName(Reference.MOD_ID + "." + name);
		setRegistryName(name);
	}
}