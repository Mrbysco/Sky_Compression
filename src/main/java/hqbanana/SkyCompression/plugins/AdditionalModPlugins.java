package hqbanana.SkyCompression.plugins;

import java.util.HashMap;
import java.util.Map;

import hqbanana.SkyCompression.plugins.crafttweaker.AdditionalCraftTweakerPlugin;
import net.minecraftforge.fml.common.Loader;

public class AdditionalModPlugins {
	public static Map<String, com.bartz24.skyresources.plugin.IModPlugin> plugins = new HashMap();

	public static void preInit()
	{
		addPlugin("crafttweaker", new AdditionalCraftTweakerPlugin());

		for (com.bartz24.skyresources.plugin.IModPlugin p : plugins.values())
		{
			p.preInit();
		}
	}

	public static void init()
	{
		for (com.bartz24.skyresources.plugin.IModPlugin p : plugins.values())
		{
			p.init();
		}
	}

	public static void postInit()
	{
		for (com.bartz24.skyresources.plugin.IModPlugin p : plugins.values())
		{
			p.postInit();
		}
	}

	public static void initRenderers()
	{
		for (com.bartz24.skyresources.plugin.IModPlugin p : plugins.values())
		{
			p.initRenderers();
		}
	}
	
	public static void addPlugin(String modID, com.bartz24.skyresources.plugin.IModPlugin plugin)
	{
		if (Loader.isModLoaded(modID))
			plugins.put(modID, plugin);		
	}
}
