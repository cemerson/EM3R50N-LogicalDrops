package com.cemerson.logicaldrops;
import com.cemerson.logicaldrops.config.LogicalDropsConfigGUI;
import com.cemerson.logicaldrops.entity.RealisticEntityBehaviorHandler;
import com.cemerson.logicaldrops.proxy.CommonProxy;

import cpw.mods.fml.client.GuiIngameModOptions;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(
        modid = Reference.MOD_ID, 
        name = Reference.MOD_NAME, 
        version = Reference.VERSION,
        guiFactory = "com.cemerson.logicaldrops.config.LogicalDropsGuiFactory")

public class LogicalDrops {

    @Mod.Instance(Reference.MOD_ID)
    public static LogicalDrops instance;
    
    public static Configuration configFile;
     
    public static int intCowMeatMax;
    public static int intCowMeatMin;
    public static int intCowLeatherMax;
    public static int intCowLeatherMin;    
    public static int intSheepMeatMax;
    public static int intSheepMeatMin;
    public static int intPigMeatMax;
    public static int intPigMeatMin;
    public static int intChickenMeatMax;
    public static int intChickenMeatMin;
    public static int intChickenFeatherMax;
    public static int intChickenFeatherMin;
    public static int intRabbitMeatMax;
    public static int intRabbitMeatMin;
    public static int intRabbitHideMax;
    public static int intRabbitHideMin;
    public static int intRabbitFootMax;
    public static int intRabbitFootMin;
    public static int intSpiderWebMax;
    public static int intSpiderWebMin;
    public static int intSpiderStringMax;
    public static int intSpiderStringMin;
    public static int intBlazeFireChargeMax;
    public static int intBlazeFireChargeMin;
    public static int intBlazeRodMax;
    public static int intBlazeRodMin;
    // public static int intCreeperWoolMax;
    // public static int intCreeperWoolMin;
    public static int intWitherCoalMax;
    public static int intWitherCoalMin;
    public static int intWitchBonesMax;
    public static int intWitchBonesMin;
    public static int intSkeletonBonesMax;
    public static int intSkeletonBonesMin;
    public static int intZombieBonesMax;
    public static int intZombieBonesMin;
    public static int intPigZombiePorkchopMax;
    public static int intPigZombiePorkchopMin;
    public static int intSheepBoneMax;
    public static int intSheepBoneMin;
    public static int intEndermanPearlMax;
    public static int intEndermanPearlMin;
    public static int intCowBoneMax;
    public static int intCowBoneMin;
    public static int intEndermanWoolCount;
    public static int intWitchWoolCount;
    public static int intBowEnemiesArrowMax;
    public static int intBowEnemiesArrowMin;
    public static int intHeadDropPercentChance;
    
    public static int intHorseBoneMin;
    public static int intHorseBoneMax;
    public static int intHorseMeatMax;
    public static int intHorseMeatMin;
    public static int intHorseLeatherMax;
    public static int intHorseLeatherMin;
    
    public static Boolean boolWitherSkeletonAlwaysDropHead; 
    public static Boolean boolSkeletonAlwaysDropHead;
    public static Boolean boolCreeperAlwaysDropHead;
    public static Boolean boolZombieAlwaysDropHead;

    
    
    // config stuff
    // http://jabelarminecraft.blogspot.com/p/minecraft-modding-configuration-guis.html
    // http://forum.feed-the-beast.com/threads/code-snippets-classes.51404/page-4#post-876553
    //https://github.com/Minalien/BlogArchive/blob/master/ForgeTutorials/Spotlight__Config_GUIs.md
    
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
        
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){       
                
        configFile = new Configuration(event.getSuggestedConfigurationFile());     
        syncConfig();
        
        // FMLCommonHandler.instance().bus().register(instance);
        // FMLCommonHandler.instance().bus().register(instance);
        // MinecraftForge.EVENT_BUS.register(instance); 
        FMLCommonHandler.instance().bus().register(instance);
        
        MinecraftForge.EVENT_BUS.register(new RealisticEntityBehaviorHandler());
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.registerRenders();                    
    }
    
    
    public static void syncConfig() {
        
        
        intCowMeatMax = configFile.get(Configuration.CATEGORY_GENERAL, "CowMeatMax", 16).getInt();
        intCowMeatMin = configFile.get(Configuration.CATEGORY_GENERAL, "CowMeatMin", 10).getInt();
        intSheepMeatMax = configFile.get(Configuration.CATEGORY_GENERAL, "SheepMeatMax", 10).getInt();
        intSheepMeatMin = configFile.get(Configuration.CATEGORY_GENERAL, "SheepMeatMin", 6).getInt();
        intPigMeatMax = configFile.get(Configuration.CATEGORY_GENERAL, "PigMeatMax", 16).getInt();
        intPigMeatMin = configFile.get(Configuration.CATEGORY_GENERAL, "PigMeatMin", 10).getInt();
        intChickenMeatMax = configFile.get(Configuration.CATEGORY_GENERAL, "ChickenMeatMax", 4).getInt();
        intChickenMeatMin = configFile.get(Configuration.CATEGORY_GENERAL, "ChickenMeatMin", 2).getInt();
        intChickenFeatherMax = configFile.get(Configuration.CATEGORY_GENERAL, "ChickenFeatherMax", 20).getInt();
        intChickenFeatherMin = configFile.get(Configuration.CATEGORY_GENERAL, "ChickenFeatherMin", 10).getInt();
        intRabbitMeatMax = configFile.get(Configuration.CATEGORY_GENERAL, "RabbitMeatMax", 1).getInt();
        intRabbitMeatMin = configFile.get(Configuration.CATEGORY_GENERAL, "RabbitMeatMin", 2).getInt();
        intRabbitHideMax = configFile.get(Configuration.CATEGORY_GENERAL, "RabbitHideMax", 1).getInt();
        intRabbitHideMin = configFile.get(Configuration.CATEGORY_GENERAL, "RabbitHideMin", 0).getInt();
        intRabbitFootMax = configFile.get(Configuration.CATEGORY_GENERAL, "RabbitFootMax", 2).getInt();
        intRabbitFootMin = configFile.get(Configuration.CATEGORY_GENERAL, "RabbitFootMin", 0).getInt();
        intSpiderWebMax = configFile.get(Configuration.CATEGORY_GENERAL, "SpiderWebMax", 3).getInt();
        intSpiderWebMin = configFile.get(Configuration.CATEGORY_GENERAL, "SpiderWebMin", 0).getInt();
        intSpiderStringMax = configFile.get(Configuration.CATEGORY_GENERAL, "SpiderStringMax", 3).getInt();
        intSpiderStringMin = configFile.get(Configuration.CATEGORY_GENERAL, "SpiderStringMin", 1).getInt();
        intBlazeFireChargeMax = configFile.get(Configuration.CATEGORY_GENERAL, "BlazeFireChargeMax", 3).getInt();
        intBlazeFireChargeMin = configFile.get(Configuration.CATEGORY_GENERAL, "BlazeFireChargeMin", 1).getInt();
        intBlazeRodMax = configFile.get(Configuration.CATEGORY_GENERAL, "BlazeRodMax", 3).getInt();
        intBlazeRodMin = configFile.get(Configuration.CATEGORY_GENERAL, "BlazeRodMin", 1).getInt();
        //intCreeperWoolMax = configFile.get(Configuration.CATEGORY_GENERAL, "CreeperWoolMax", 2).getInt();
        //intCreeperWoolMin = configFile.get(Configuration.CATEGORY_GENERAL, "CreeperWoolMin", 0).getInt();
        intWitherCoalMax = configFile.get(Configuration.CATEGORY_GENERAL, "WitherCoalMax", 6).getInt();
        intWitherCoalMin = configFile.get(Configuration.CATEGORY_GENERAL, "WitherCoalMin", 1).getInt();
        intWitchBonesMax = configFile.get(Configuration.CATEGORY_GENERAL, "WitchBonesMax", 2).getInt();
        intWitchBonesMin = configFile.get(Configuration.CATEGORY_GENERAL, "WitchBonesMin", 0).getInt();
        intSkeletonBonesMax = configFile.get(Configuration.CATEGORY_GENERAL, "SkeletonBonesMax", 4).getInt();
        intSkeletonBonesMin = configFile.get(Configuration.CATEGORY_GENERAL, "SkeletonBonesMin", 0).getInt();
        intZombieBonesMax = configFile.get(Configuration.CATEGORY_GENERAL, "ZombieBonesMax", 3).getInt();
        intZombieBonesMin = configFile.get(Configuration.CATEGORY_GENERAL, "ZombieBonesMin", 0).getInt();
        intPigZombiePorkchopMax = configFile.get(Configuration.CATEGORY_GENERAL, "PigZombiePorkchopMax", 3).getInt();
        intPigZombiePorkchopMin = configFile.get(Configuration.CATEGORY_GENERAL, "PigZombiePorkchopMin", 1).getInt();
        intSheepBoneMax = configFile.get(Configuration.CATEGORY_GENERAL, "SheepBoneMax", 3).getInt();
        intSheepBoneMin = configFile.get(Configuration.CATEGORY_GENERAL, "SheepBoneMin", 1).getInt();
        intEndermanPearlMax = configFile.get(Configuration.CATEGORY_GENERAL, "EndermanPearlMax", 2).getInt();
        intEndermanPearlMin = configFile.get(Configuration.CATEGORY_GENERAL, "EndermanPearlMin", 1).getInt();
        intCowBoneMax = configFile.get(Configuration.CATEGORY_GENERAL, "CowBoneMax", 8).getInt();
        intCowBoneMin = configFile.get(Configuration.CATEGORY_GENERAL, "CowBoneMin", 4).getInt();                
        intCowLeatherMax = configFile.get(Configuration.CATEGORY_GENERAL, "CowLeatherMax", 12).getInt();
        intCowLeatherMin = configFile.get(Configuration.CATEGORY_GENERAL, "CowLeatherMin", 8).getInt();
        
        intHorseMeatMax = configFile.get(Configuration.CATEGORY_GENERAL, "HorseMeatMax", 16).getInt();
        intHorseMeatMin = configFile.get(Configuration.CATEGORY_GENERAL, "HorseMeatMin", 10).getInt();        
        intHorseBoneMax = configFile.get(Configuration.CATEGORY_GENERAL, "HorseBoneMax", 8).getInt();
        intHorseBoneMin = configFile.get(Configuration.CATEGORY_GENERAL, "HorseBoneMin", 4).getInt();
        intHorseLeatherMax = configFile.get(Configuration.CATEGORY_GENERAL, "HorseLeatherMax", 12).getInt();
        intHorseLeatherMin = configFile.get(Configuration.CATEGORY_GENERAL, "HorseLeatherMin", 8).getInt();        
                       
        intBowEnemiesArrowMax = configFile.get(Configuration.CATEGORY_GENERAL, "BowEnemiesArrowMax", 12).getInt();
        intBowEnemiesArrowMin = configFile.get(Configuration.CATEGORY_GENERAL, "BowEnemiesArrowMin", 4).getInt();               
        
        intEndermanWoolCount = configFile.get(Configuration.CATEGORY_GENERAL, "EndermanWoolCount", 2).getInt();
        intWitchWoolCount = configFile.get(Configuration.CATEGORY_GENERAL, "WitchWoolCount", 2).getInt();
        intHeadDropPercentChance = configFile.get(Configuration.CATEGORY_GENERAL, "HeadDropPercentChance", 20).getInt(); 

        boolWitherSkeletonAlwaysDropHead = configFile.getBoolean("WitherSkeletonAlwaysDropHead", Configuration.CATEGORY_GENERAL, true, ""); 
        boolSkeletonAlwaysDropHead = configFile.getBoolean("SkeletonAlwaysDropHead", Configuration.CATEGORY_GENERAL, true, "");
        boolCreeperAlwaysDropHead = configFile.getBoolean("CreeperAlwaysDropHead", Configuration.CATEGORY_GENERAL, true, "");
        boolZombieAlwaysDropHead = configFile.getBoolean("ZombieAlwaysDropHead", Configuration.CATEGORY_GENERAL, false, "");
    
        if(configFile.hasChanged()) configFile.save();
   }    

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs){
        if(eventArgs.modID.equals(Reference.MOD_ID)){                      
            syncConfig();       
        }       
    }
    
//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
//    public void onEvent(GuiOpenEvent event)
//    {
//        if (event.gui instanceof GuiOptions)
//        {
//            System.out.println("GuiOpenEvent for GuiIngameModOptions");
//            event.gui = new LogicalDropsConfigGUI(null);            
//            //event.setGui(new LogicalDropsConfigGUI(null));         
//        }
//    }   
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(GuiOpenEvent event)
    {
        if (event.gui instanceof GuiIngameModOptions)
        {
            System.out.println("GuiOpenEvent for GuiIngameModOptions");
            event.gui = new LogicalDropsConfigGUI(null);        
        }
    }    
    
//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
//    public void onEvent(GuiOpenEvent event)
//    {
//        if (event.getGui() instanceof GuiOptions)
//        {
//            System.out.println("GuiOpenEvent for GuiIngameModOptions");
//            event.setGui(new LogicalDropsConfigGUI(null));
//            // event.setGui(new LogicalDropsConfigGUI(null));        
//        }
//    }   
//    
    
//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
//    public void openGui(GuiOpenEvent event) {
//        if (event.gui instanceof GuiMainMenu) {
//            event.gui = new LogicalDropsConfigGUI(null);
//        }
//    }    

    
}
