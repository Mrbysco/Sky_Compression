package hqbanana.SkyCompression;

import hqbanana.SkyCompression.config.AdditionalConfigOptions;
import hqbanana.SkyCompression.creativetabs.SkyCompressionTab;
import hqbanana.SkyCompression.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, dependencies = "required-after:skyresources;after:crafttweaker")
public class SkyCompression {
	public static final CreativeTabs SKY_COMPRESSION_TAB = new SkyCompressionTab("skycompressiontab");
	
	@Mod.Instance
	public static SkyCompression instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new AdditionalConfigOptions());
		
		System.out.println("Pre init");
		proxy.PreInit(event);
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		System.out.println("init");
		proxy.Init(event);
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		System.out.println("Post init");
		proxy.PostInit(event);
	}
}
