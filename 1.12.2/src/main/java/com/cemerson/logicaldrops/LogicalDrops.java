package com.cemerson.logicaldrops;
import java.util.List;
import java.util.Set;

import com.cemerson.logicaldrops.config.LDConfig;
import com.cemerson.logicaldrops.entity.RealisticEntityBehaviorHandler;
// import com.cemerson.logicaldrops.init.LogicalRecipes;
import com.cemerson.logicaldrops.proxy.CommonProxy;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
        modid = Reference.MOD_ID, 
        name = Reference.MOD_NAME, 
        version = Reference.VERSION,
        guiFactory = LogicalDrops.GUI_FACTORY) //guiFactory = "com.cemerson.logicaldrops.config.LogicalDropsGuiFactory")



public class LogicalDrops {
	
	public static final String GUI_FACTORY = "com.cemerson.logicaldrops.config.LDConfigGUIFactory";

    @Mod.Instance(Reference.MOD_ID)
        
    public static LogicalDrops instance;
        
    // config stuff
    // http://jabelarminecraft.blogspot.com/p/minecraft-modding-configuration-guis.html
    // http://forum.feed-the-beast.com/threads/code-snippets-classes.51404/page-4#post-876553
    // https://github.com/Minalien/BlogArchive/blob/master/ForgeTutorials/Spotlight__Config_GUIs.md
        
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;       
         
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){       
            	
    	LDConfig.preInit();
    	       
        MinecraftForge.EVENT_BUS.register(instance);         
        MinecraftForge.EVENT_BUS.register(new RealisticEntityBehaviorHandler());        
        // MinecraftForge.EVENT_BUS.register(new RegisterEventHandler());
        
        LDConfig.clientPreInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){    	    	   
        proxy.registerRenders();                     
    }
    
    
}
