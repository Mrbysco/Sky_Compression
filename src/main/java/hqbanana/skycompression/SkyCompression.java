package hqbanana.skycompression;

import hqbanana.skycompression.config.AdditionalConfigOptions;
import hqbanana.skycompression.creativetabs.SkyCompressionTab;
import hqbanana.skycompression.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, dependencies = "required-after:skyresources@[2.3.1,);after:justanothersnad")
public class SkyCompression {
	public static final CreativeTabs SKY_COMPRESSION_TAB = new SkyCompressionTab("skycompressiontab");
	
	@Mod.Instance
	public static SkyCompression instance;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		if(Loader.isModLoaded("justanothersnad"))logger.info("Loading With Just Another Snad support");

		MinecraftForge.EVENT_BUS.register(new AdditionalConfigOptions());
		
		logger.debug("Pre init");
		proxy.PreInit(event);
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		logger.debug("init");
		proxy.Init(event);
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		logger.debug("Post init");
		proxy.PostInit(event);
	}
}
