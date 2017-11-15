package hqbanana.SkyCompression.proxy;

import hqbanana.SkyCompression.SkyCompression;
import hqbanana.SkyCompression.Handlers.ModGuiHandler;
import hqbanana.SkyCompression.Handlers.RegistryHandler;
import hqbanana.SkyCompression.init.ModCrafting;
import hqbanana.SkyCompression.init.ModTileEntities;
import hqbanana.SkyCompression.plugins.AdditionalModPlugins;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		System.out.println("Pre init server");
		RegistryHandler.Common();
		
		AdditionalModPlugins.preInit();
	}
	
	public void Init(FMLInitializationEvent event) {
		System.out.println("init server");
		NetworkRegistry.INSTANCE.registerGuiHandler(SkyCompression.instance, new ModGuiHandler());
		ModTileEntities.init();
		ModCrafting.initOreDict();
		
		AdditionalModPlugins.init();
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		System.out.println("Post init server");
		ModCrafting.Register();
		
		AdditionalModPlugins.postInit();
	}
}
