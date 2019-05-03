package hqbanana.skycompression.base.items;

import hqbanana.skycompression.Reference;
import net.minecraft.item.Item;

public class CustomItem extends Item {
	
	public CustomItem(String name) {
		super();
		setTranslationKey(Reference.MOD_ID + "." + name);
		setRegistryName(name);
	}
}