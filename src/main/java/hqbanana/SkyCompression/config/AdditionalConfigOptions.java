package hqbanana.SkyCompression.config;

import hqbanana.SkyCompression.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
public class AdditionalConfigOptions 
{
	@Config.Comment("Config Settings for Compressed Machines")
	public static MachineSettings machineSettings = new MachineSettings();

	public static class MachineSettings
	{
		@Config.Comment("Compressed Rock Crusher Speed")
		public int compressedRockCrusherSpeed = 7;
		@Config.Comment("Compressed Rock Crusher RF Rate")
		public int compressedRockCrusherPowerUsage = 1000;
	}

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) 
			{
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}