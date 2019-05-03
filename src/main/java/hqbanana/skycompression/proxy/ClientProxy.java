package hqbanana.skycompression.proxy;

import hqbanana.skycompression.handlers.RegistryHandler;
import hqbanana.skycompression.plugins.AdditionalModPlugins;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void PreInit(FMLPreInitializationEvent event) {
		super.PreInit(event);
		System.out.println("Pre init client");
		RegistryHandler.Client();
		
		AdditionalModPlugins.initRenderers();
	}
	
	public void Init(FMLInitializationEvent event) {
		super.Init(event);
		System.out.println("init client");
	}
	
	public void PostInit(FMLPostInitializationEvent event) {
		super.PostInit(event);
		System.out.println("Post init client");
	}
}
