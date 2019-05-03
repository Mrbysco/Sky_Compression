package hqbanana.skycompression.plugins;

import hqbanana.skycompression.plugins.crafttweaker.AdditionalCraftTweakerPlugin;
import net.minecraftforge.fml.common.Loader;

import java.util.HashMap;
import java.util.Map;

public class AdditionalModPlugins {
	public static Map<String, com.bartz24.skyresources.plugin.IModPlugin> plugins = new HashMap();

	public static void preInit()
	{
		addPlugin("crafttweaker", AdditionalCraftTweakerPlugin.class);

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
	
	public static void addPlugin(String modID, Class plugin)
	{
		if (Loader.isModLoaded(modID))
		{
			try
			{
				plugins.put(modID, (com.bartz24.skyresources.plugin.IModPlugin) plugin.newInstance());
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
	}
}
