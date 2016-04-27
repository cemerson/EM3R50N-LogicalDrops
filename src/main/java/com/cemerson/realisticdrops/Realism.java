package com.cemerson.realisticdrops;

import com.cemerson.realisticdrops.entity.RealisticEntityBehaviorHandler;
import com.cemerson.realisticdrops.init.RealismItems;
import com.cemerson.realisticdrops.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Realism {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){		
				
		RealismItems.init();
		RealismItems.register();		
		MinecraftForge.EVENT_BUS.register(new RealisticEntityBehaviorHandler());		
	}
	@EventHandler
	public void init(FMLInitializationEvent event){
		 proxy.registerRenders();		 		 	
	}	
	
}
