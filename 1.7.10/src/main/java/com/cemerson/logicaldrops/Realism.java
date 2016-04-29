package com.cemerson.logicaldrops;

import com.cemerson.logicaldrops.entity.RealisticEntityBehaviorHandler;
import com.cemerson.logicaldrops.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Realism {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){		
				
//		RealismItems.init();
//		RealismItems.register();		
		MinecraftForge.EVENT_BUS.register(new RealisticEntityBehaviorHandler());		
	}
	@EventHandler
	public void init(FMLInitializationEvent event){
		 proxy.registerRenders();		 		 	
	}	
	
}
