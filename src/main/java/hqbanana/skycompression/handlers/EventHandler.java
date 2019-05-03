package hqbanana.skycompression.handlers;

import hqbanana.skycompression.init.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent
	public void fuelTime(FurnaceFuelBurnTimeEvent event)
	{
		if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedLogAcacia)))
			event.setBurnTime(2700);
		else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedLogBigOak)))
			event.setBurnTime(2700);
		else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedLogBirch)))
			event.setBurnTime(2700);
		else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedLogJungle)))
			event.setBurnTime(2700);
		else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedLogOak)))
			event.setBurnTime(2700);
		else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedLogSpruce)))
			event.setBurnTime(2700);
		else if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.compressedPetrifiedWood)))
			event.setBurnTime(21600);
	}
}
