package com.cemerson.logicaldrops.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//import com.cemerson.logicaldrops.LogicalDrops;
import com.cemerson.logicaldrops.Reference;

import net.minecraft.client.resources.I18n;
// import net.minecraft.client.Minecraft;
//import net.minecraftforge.client.model.ItemLayerModel.Loader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
//import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LDConfig {
	
	private static Configuration config = null;
	
	public static Boolean playerIsInBed = false;
		
	public static final String CATEGORY_TOGGLES = "toggles";
	public static final String CATEGORY_VALUES = "values";
	public static final String CATEGORY_VALUESLA = "valuesla";
	public static final String CATEGORY_VALUESMA = "valuesma";
	public static final String CATEGORY_VALUESSA = "valuessa";
	
		
    public static Boolean boolPreventDoubleVanillaDrops;
    public static Boolean boolWitherSkeletonCanDropHead; 
    public static Boolean boolSkeletonCanDropHead;
    public static Boolean boolCreeperCanDropHead;
    public static Boolean boolZombieCanDropHead;
    public static Boolean boolAllowCustomHeadDrops;	

	// INTS
    public static int intItemsToCookDuringSleep;
	public static int intBabyAnimalMinutesToAdult;
	public static int intAnvilBreakChancePercent;
	public static int intLargeAnimalBoneMax;
	public static int intLargeAnimalBoneMin;
	public static int intLargeAnimalMeatMax;
	public static int intLargeAnimalMeatMin;
	public static int intLargeAnimalHideMax;
	public static int intLargeAnimalHideMin;
	public static int intMediumAnimalMeatMax;
	public static int intMediumAnimalMeatMin;
	public static int intMediumAnimalBoneMax;
	public static int intMediumAnimalBoneMin;
	public static int intSmallAnimalMeatMax;
	public static int intSmallAnimalMeatMin;
	public static int intSmallAnimalHideMax;
	public static int intSmallAnimalHideMin;
	public static int intSmallAnimalBoneCount;
	public static int intIronGolemIngotsMin;
	public static int intIronGolemIngotsMax;
	public static int intChickenFeatherMax;
	public static int intChickenFeatherMin;
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
	public static int intCreeperLeavesMax;
	public static int intCreeperLeavesMin;
	public static int intWitherCoalMax;
	public static int intWitherCoalMin;
	public static int intHumanoidBonesMax;
	public static int intHumanoidBonesMin;
	public static int intPigZombiePorkchopMax;
	public static int intPigZombiePorkchopMin;
	public static int intEndermanPearlMax;
	public static int intEndermanPearlMin;
	public static int intEndermanPotionMax;
	public static int intBowEnemiesArrowMax;
	public static int intBowEnemiesArrowMin;
	public static int intEndermanWoolCount;
	public static int intWitchMaxPotionCount;
	public static int intWitchMaxEmeraldCount;
	public static int intWitchWoolCount;
	public static int intHeadDropPercentChance	;

	
	public static void preInit(){
		File configFile = new File(net.minecraftforge.fml.common.Loader.instance().getConfigDir(), "LogicalDrops.1.12.2.2.cfg");
		config = new Configuration(configFile);
		// syncConfig(true,true);
		syncFromFiles();
	}
	
	public static Configuration getConfig(){
		return config;
	}
	
	public static void clientPreInit(){
		MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
	}
	   
	/**
	 * Sync the config from a change in the gui
	 */
	public static void syncFromGui() {
		syncConfig(false, true);
	}	
	
	public static void syncFromFiles(){
		syncConfig(true,true);
	}
		
	public static void syncFromFields(){
		syncConfig(false,false);
	}
	
	private static void syncConfig(boolean loadFromConfigFile, boolean readFieldsFromConfig){
		
		if(loadFromConfigFile) config.load();
		
			
		// TOGGLES
		Property propItemsToCookDuringSleep = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.ItemsToCookDuringSleep"), 32);
		propItemsToCookDuringSleep.setLanguageKey("gui.config.toggles.ItemsToCookDuringSleep");
		propItemsToCookDuringSleep.setComment(I18n.format("gui.config.comment.ItemsToCookDuringSleep"));
		Property propAnvilBreakChancePercent = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.AnvilBreakChancePercent"), 0);
			propAnvilBreakChancePercent.setLanguageKey("gui.config.toggles.AnvilBreakChancePercent");
			propAnvilBreakChancePercent.setComment(I18n.format("gui.config.comment.AnvilBreakChancePercent"));
		Property propBabyAnimalMinutesToAdult = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.BabyAnimalMinutesToAdult"), 20);
			propBabyAnimalMinutesToAdult.setLanguageKey("gui.config.toggles.BabyAnimalMinutesToAdult");
			propBabyAnimalMinutesToAdult.setComment(I18n.format("gui.config.comment.BabyAnimalMinutesToAdult"));

        Property propAllowCustomHeadDrops = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.AllowCustomHeadDrops"), true);
    	propAllowCustomHeadDrops.setLanguageKey("gui.config.toggles.allowCustomHeadDrops");
    	propAllowCustomHeadDrops.setComment(I18n.format("gui.config.comment.AllowCustomHeadDrops"));
		Property propHeadDropPercentChance = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.HeadDropPercentChance"), 20);
		propHeadDropPercentChance.setLanguageKey("gui.config.toggles.HeadDropPercentChance");
		propHeadDropPercentChance.setComment(I18n.format("gui.config.comment.HeadDropPercentChance"));
    	
        Property propWitherSkeletonCanDropHead = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.WitherSkeletonCanDropHead"), true);
    	propWitherSkeletonCanDropHead.setLanguageKey("gui.config.toggles.witherSkeletonCanDropHead");
    	propWitherSkeletonCanDropHead.setComment(I18n.format("gui.config.comment.WitherSkeletonCanDropHead"));
        Property propSkeletonCanDropHead = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.SkeletonCanDropHead"), true);
    	propSkeletonCanDropHead.setLanguageKey("gui.config.toggles.skeletonCanDropHead");
    	propSkeletonCanDropHead.setComment(I18n.format("gui.config.comment.SkeletonCanDropHead"));
        Property propCreeperCanDropHead = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.CreeperCanDropHead"), true);
    	propCreeperCanDropHead.setLanguageKey("gui.config.toggles.creeperCanDropHead");
    	propCreeperCanDropHead.setComment(I18n.format("gui.config.comment.CreeperCanDropHead"));
        Property propZombieCanDropHead = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.ZombieCanDropHead"), false);
    	propZombieCanDropHead.setLanguageKey("gui.config.toggles.zombieCanDropHead");
    	propZombieCanDropHead.setComment(I18n.format("gui.config.comment.ZombieCanDropHead"));
        Property propPreventDoubleVanillaDrops = config.get(CATEGORY_TOGGLES,I18n.format("gui.config.setting.PreventDoubleVanillaDrops"), true);
    	propPreventDoubleVanillaDrops.setLanguageKey("gui.config.toggles.preventDoubleVanillaDrops");
    	propPreventDoubleVanillaDrops.setComment(I18n.format("gui.config.comment.PreventDoubleVanillaDrops"));
    	
    	// INTS
    	

		Property propIronGolemIngotsMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.IronGolemIngotsMin"), 8);
			propIronGolemIngotsMin.setLanguageKey("gui.config.toggles.IronGolemIngotsMin");
			propIronGolemIngotsMin.setComment(I18n.format("gui.config.comment.IronGolemIngotsMin"));
		Property propIronGolemIngotsMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.IronGolemIngotsMax"), 15);
			propIronGolemIngotsMax.setLanguageKey("gui.config.toggles.IronGolemIngotsMax");
			propIronGolemIngotsMax.setComment(I18n.format("gui.config.comment.IronGolemIngotsMax"));
		Property propBlazeFireChargeMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.BlazeFireChargeMax"), 3);
			propBlazeFireChargeMax.setLanguageKey("gui.config.toggles.BlazeFireChargeMax");
			propBlazeFireChargeMax.setComment(I18n.format("gui.config.comment.BlazeFireChargeMax"));
		Property propBlazeFireChargeMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.BlazeFireChargeMin"), 1);
			propBlazeFireChargeMin.setLanguageKey("gui.config.toggles.BlazeFireChargeMin");
			propBlazeFireChargeMin.setComment(I18n.format("gui.config.comment.BlazeFireChargeMin"));
		Property propBlazeRodMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.BlazeRodMax"), 3);
			propBlazeRodMax.setLanguageKey("gui.config.toggles.BlazeRodMax");
			propBlazeRodMax.setComment(I18n.format("gui.config.comment.BlazeRodMax"));
		Property propBlazeRodMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.BlazeRodMin"), 1);
			propBlazeRodMin.setLanguageKey("gui.config.toggles.BlazeRodMin");
			propBlazeRodMin.setComment(I18n.format("gui.config.comment.BlazeRodMin"));
		Property propCreeperLeavesMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.CreeperLeavesMax"), 4);
			propCreeperLeavesMax.setLanguageKey("gui.config.toggles.CreeperLeavesMax");
			propCreeperLeavesMax.setComment(I18n.format("gui.config.comment.CreeperLeavesMax"));
		Property propCreeperLeavesMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.CreeperLeavesMin"), 2);
			propCreeperLeavesMin.setLanguageKey("gui.config.toggles.CreeperLeavesMin");
			propCreeperLeavesMin.setComment(I18n.format("gui.config.comment.CreeperLeavesMin"));
		Property propWitherCoalMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.WitherCoalMax"), 6);
			propWitherCoalMax.setLanguageKey("gui.config.toggles.WitherCoalMax");
			propWitherCoalMax.setComment(I18n.format("gui.config.comment.WitherCoalMax"));
		Property propWitherCoalMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.WitherCoalMin"), 1);
			propWitherCoalMin.setLanguageKey("gui.config.toggles.WitherCoalMin");
			propWitherCoalMin.setComment(I18n.format("gui.config.comment.WitherCoalMin"));
		Property propHumanoidBonesMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.HumanoidBonesMax"), 6);
			propHumanoidBonesMax.setLanguageKey("gui.config.toggles.HumanoidBonesMax");
			propHumanoidBonesMax.setComment(I18n.format("gui.config.comment.HumanoidBonesMax"));
		Property propHumanoidBonesMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.HumanoidBonesMin"), 2);
			propHumanoidBonesMin.setLanguageKey("gui.config.toggles.HumanoidBonesMin");
			propHumanoidBonesMin.setComment(I18n.format("gui.config.comment.HumanoidBonesMin"));
		Property propPigZombiePorkchopMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.PigZombiePorkchopMax"), 2);
			propPigZombiePorkchopMax.setLanguageKey("gui.config.toggles.PigZombiePorkchopMax");
			propPigZombiePorkchopMax.setComment(I18n.format("gui.config.comment.PigZombiePorkchopMax"));
		Property propPigZombiePorkchopMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.PigZombiePorkchopMin"), 0);
			propPigZombiePorkchopMin.setLanguageKey("gui.config.toggles.PigZombiePorkchopMin");
			propPigZombiePorkchopMin.setComment(I18n.format("gui.config.comment.PigZombiePorkchopMin"));
		Property propEndermanPearlMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.EndermanPearlMax"), 2);
			propEndermanPearlMax.setLanguageKey("gui.config.toggles.EndermanPearlMax");
			propEndermanPearlMax.setComment(I18n.format("gui.config.comment.EndermanPearlMax"));
		Property propEndermanPearlMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.EndermanPearlMin"), 1);
			propEndermanPearlMin.setLanguageKey("gui.config.toggles.EndermanPearlMin");
			propEndermanPearlMin.setComment(I18n.format("gui.config.comment.EndermanPearlMin"));
		Property propEndermanPotionMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.EndermanPotionMax"), 0);
			propEndermanPotionMax.setLanguageKey("gui.config.toggles.EndermanPotionMax");
			propEndermanPotionMax.setComment(I18n.format("gui.config.comment.EndermanPotionMax"));
		Property propBowEnemiesArrowMax = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.BowEnemiesArrowMax"), 12);
			propBowEnemiesArrowMax.setLanguageKey("gui.config.toggles.BowEnemiesArrowMax");
			propBowEnemiesArrowMax.setComment(I18n.format("gui.config.comment.BowEnemiesArrowMax"));
		Property propBowEnemiesArrowMin = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.BowEnemiesArrowMin"), 4);
			propBowEnemiesArrowMin.setLanguageKey("gui.config.toggles.BowEnemiesArrowMin");
			propBowEnemiesArrowMin.setComment(I18n.format("gui.config.comment.BowEnemiesArrowMin"));
		Property propEndermanWoolCount = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.EndermanWoolCount"), 2);
			propEndermanWoolCount.setLanguageKey("gui.config.toggles.EndermanWoolCount");
			propEndermanWoolCount.setComment(I18n.format("gui.config.comment.EndermanWoolCount"));
		Property propWitchMaxPotionCount = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.WitchMaxPotionCount"), 1);
			propWitchMaxPotionCount.setLanguageKey("gui.config.toggles.WitchMaxPotionCount");
			propWitchMaxPotionCount.setComment(I18n.format("gui.config.comment.WitchMaxPotionCount"));
		Property propWitchMaxEmeraldCount = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.WitchMaxEmeraldCount"), 1);
			propWitchMaxEmeraldCount.setLanguageKey("gui.config.toggles.WitchMaxEmeraldCount");
			propWitchMaxEmeraldCount.setComment(I18n.format("gui.config.comment.WitchMaxEmeraldCount"));
		Property propWitchWoolCount = config.get(CATEGORY_VALUES,I18n.format("gui.config.setting.WitchWoolCount"), 2);
			propWitchWoolCount.setLanguageKey("gui.config.toggles.WitchWoolCount");
			propWitchWoolCount.setComment(I18n.format("gui.config.comment.WitchWoolCount"));


		Property propLargeAnimalBoneMax = config.get(CATEGORY_VALUESLA,I18n.format("gui.config.setting.LargeAnimalBoneMax"), 10);
			propLargeAnimalBoneMax.setLanguageKey("gui.config.toggles.LargeAnimalBoneMax");
			propLargeAnimalBoneMax.setComment(I18n.format("gui.config.comment.LargeAnimalBoneMax"));
		Property propLargeAnimalBoneMin = config.get(CATEGORY_VALUESLA,I18n.format("gui.config.setting.LargeAnimalBoneMin"), 6);
			propLargeAnimalBoneMin.setLanguageKey("gui.config.toggles.LargeAnimalBoneMin");
			propLargeAnimalBoneMin.setComment(I18n.format("gui.config.comment.LargeAnimalBoneMin"));
		Property propLargeAnimalMeatMax = config.get(CATEGORY_VALUESLA,I18n.format("gui.config.setting.LargeAnimalMeatMax"), 20);
			propLargeAnimalMeatMax.setLanguageKey("gui.config.toggles.LargeAnimalMeatMax");
			propLargeAnimalMeatMax.setComment(I18n.format("gui.config.comment.LargeAnimalMeatMax"));
		Property propLargeAnimalMeatMin = config.get(CATEGORY_VALUESLA,I18n.format("gui.config.setting.LargeAnimalMeatMin"), 10);
			propLargeAnimalMeatMin.setLanguageKey("gui.config.toggles.LargeAnimalMeatMin");
			propLargeAnimalMeatMin.setComment(I18n.format("gui.config.comment.LargeAnimalMeatMin"));
		Property propLargeAnimalHideMax = config.get(CATEGORY_VALUESLA,I18n.format("gui.config.setting.LargeAnimalHideMax"), 8);
			propLargeAnimalHideMax.setLanguageKey("gui.config.toggles.LargeAnimalHideMax");
			propLargeAnimalHideMax.setComment(I18n.format("gui.config.comment.LargeAnimalHideMax"));
		Property propLargeAnimalHideMin = config.get(CATEGORY_VALUESLA,I18n.format("gui.config.setting.LargeAnimalHideMin"), 4);
			propLargeAnimalHideMin.setLanguageKey("gui.config.toggles.LargeAnimalHideMin");
			propLargeAnimalHideMin.setComment(I18n.format("gui.config.comment.LargeAnimalHideMin"));
		Property propMediumAnimalMeatMax = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.MediumAnimalMeatMax"), 8);
			propMediumAnimalMeatMax.setLanguageKey("gui.config.toggles.MediumAnimalMeatMax");
			propMediumAnimalMeatMax.setComment(I18n.format("gui.config.comment.MediumAnimalMeatMax"));
		Property propMediumAnimalMeatMin = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.MediumAnimalMeatMin"), 4);
			propMediumAnimalMeatMin.setLanguageKey("gui.config.toggles.MediumAnimalMeatMin");
			propMediumAnimalMeatMin.setComment(I18n.format("gui.config.comment.MediumAnimalMeatMin"));
		Property propMediumAnimalBoneMax = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.MediumAnimalBoneMax"), 4);
			propMediumAnimalBoneMax.setLanguageKey("gui.config.toggles.MediumAnimalBoneMax");
			propMediumAnimalBoneMax.setComment(I18n.format("gui.config.comment.MediumAnimalBoneMax"));
		Property propMediumAnimalBoneMin = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.MediumAnimalBoneMin"), 2);
			propMediumAnimalBoneMin.setLanguageKey("gui.config.toggles.MediumAnimalBoneMin");
			propMediumAnimalBoneMin.setComment(I18n.format("gui.config.comment.MediumAnimalBoneMin"));
		Property propSpiderWebMax = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.SpiderWebMax"), 1);
			propSpiderWebMax.setLanguageKey("gui.config.toggles.SpiderWebMax");
			propSpiderWebMax.setComment(I18n.format("gui.config.comment.SpiderWebMax"));
		Property propSpiderWebMin = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.SpiderWebMin"), 0);
			propSpiderWebMin.setLanguageKey("gui.config.toggles.SpiderWebMin");
			propSpiderWebMin.setComment(I18n.format("gui.config.comment.SpiderWebMin"));
		Property propSpiderStringMax = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.SpiderStringMax"), 3);
			propSpiderStringMax.setLanguageKey("gui.config.toggles.SpiderStringMax");
			propSpiderStringMax.setComment(I18n.format("gui.config.comment.SpiderStringMax"));
		Property propSpiderStringMin = config.get(CATEGORY_VALUESMA,I18n.format("gui.config.setting.SpiderStringMin"), 1);
			propSpiderStringMin.setLanguageKey("gui.config.toggles.SpiderStringMin");
			propSpiderStringMin.setComment(I18n.format("gui.config.comment.SpiderStringMin"));

		Property propSmallAnimalMeatMax = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.SmallAnimalMeatMax"), 2);
			propSmallAnimalMeatMax.setLanguageKey("gui.config.toggles.SmallAnimalMeatMax");
			propSmallAnimalMeatMax.setComment(I18n.format("gui.config.comment.SmallAnimalMeatMax"));
		Property propSmallAnimalMeatMin = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.SmallAnimalMeatMin"), 0);
			propSmallAnimalMeatMin.setLanguageKey("gui.config.toggles.SmallAnimalMeatMin");
			propSmallAnimalMeatMin.setComment(I18n.format("gui.config.comment.SmallAnimalMeatMin"));
		Property propSmallAnimalHideMax = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.SmallAnimalHideMax"), 1);
			propSmallAnimalHideMax.setLanguageKey("gui.config.toggles.SmallAnimalHideMax");
			propSmallAnimalHideMax.setComment(I18n.format("gui.config.comment.SmallAnimalHideMax"));
		Property propSmallAnimalHideMin = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.SmallAnimalHideMin"), 0);
			propSmallAnimalHideMin.setLanguageKey("gui.config.toggles.SmallAnimalHideMin");
			propSmallAnimalHideMin.setComment(I18n.format("gui.config.comment.SmallAnimalHideMin"));
		Property propSmallAnimalBoneCount = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.SmallAnimalBoneCount"), 1);
			propSmallAnimalBoneCount.setLanguageKey("gui.config.toggles.SmallAnimalBoneCount");
			propSmallAnimalBoneCount.setComment(I18n.format("gui.config.comment.SmallAnimalBoneCount"));
		Property propChickenFeatherMax = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.ChickenFeatherMax"), 20);
			propChickenFeatherMax.setLanguageKey("gui.config.toggles.ChickenFeatherMax");
			propChickenFeatherMax.setComment(I18n.format("gui.config.comment.ChickenFeatherMax"));
		Property propChickenFeatherMin = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.ChickenFeatherMin"), 10);
			propChickenFeatherMin.setLanguageKey("gui.config.toggles.ChickenFeatherMin");
			propChickenFeatherMin.setComment(I18n.format("gui.config.comment.ChickenFeatherMin"));
		Property propRabbitFootMax = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.RabbitFootMax"), 2);
			propRabbitFootMax.setLanguageKey("gui.config.toggles.RabbitFootMax");
			propRabbitFootMax.setComment(I18n.format("gui.config.comment.RabbitFootMax"));
		Property propRabbitFootMin = config.get(CATEGORY_VALUESSA,I18n.format("gui.config.setting.RabbitFootMin"), 0);
			propRabbitFootMin.setLanguageKey("gui.config.toggles.RabbitFootMin");
			propRabbitFootMin.setComment(I18n.format("gui.config.comment.RabbitFootMin"));
        
        
        
        		
		
		
		List<String> propertyOrderToggles = new ArrayList<String>();

		// propertyOrder.add(propTest1.getName());
		// propertyOrder.add(propTest2.getName());				
		propertyOrderToggles.add(propItemsToCookDuringSleep.getName());		
		propertyOrderToggles.add(propAnvilBreakChancePercent.getName());
		propertyOrderToggles.add(propPreventDoubleVanillaDrops.getName());
		propertyOrderToggles.add(propBabyAnimalMinutesToAdult.getName());
		propertyOrderToggles.add(propHeadDropPercentChance.getName());
		propertyOrderToggles.add(propAllowCustomHeadDrops.getName());		
		propertyOrderToggles.add(propWitherSkeletonCanDropHead.getName());
		propertyOrderToggles.add(propSkeletonCanDropHead.getName());
		propertyOrderToggles.add(propCreeperCanDropHead.getName());
		propertyOrderToggles.add(propZombieCanDropHead.getName());
		
		

		List<String> propertyOrderValues = new ArrayList<String>();

		propertyOrderValues.add(propIronGolemIngotsMin.getName());
		propertyOrderValues.add(propIronGolemIngotsMax.getName());
		propertyOrderValues.add(propBlazeFireChargeMax.getName());
		propertyOrderValues.add(propBlazeFireChargeMin.getName());
		propertyOrderValues.add(propBlazeRodMax.getName());
		propertyOrderValues.add(propBlazeRodMin.getName());
		propertyOrderValues.add(propCreeperLeavesMax.getName());
		propertyOrderValues.add(propCreeperLeavesMin.getName());
		propertyOrderValues.add(propWitherCoalMax.getName());
		propertyOrderValues.add(propWitherCoalMin.getName());
		propertyOrderValues.add(propHumanoidBonesMax.getName());
		propertyOrderValues.add(propHumanoidBonesMin.getName());
		propertyOrderValues.add(propPigZombiePorkchopMax.getName());
		propertyOrderValues.add(propPigZombiePorkchopMin.getName());
		propertyOrderValues.add(propEndermanPearlMax.getName());
		propertyOrderValues.add(propEndermanPearlMin.getName());
		propertyOrderValues.add(propEndermanPotionMax.getName());
		propertyOrderValues.add(propBowEnemiesArrowMax.getName());
		propertyOrderValues.add(propBowEnemiesArrowMin.getName());
		propertyOrderValues.add(propEndermanWoolCount.getName());
		propertyOrderValues.add(propWitchMaxPotionCount.getName());
		propertyOrderValues.add(propWitchMaxEmeraldCount.getName());
		propertyOrderValues.add(propWitchWoolCount.getName());
		

		List<String> propertyOrderValuesLA = new ArrayList<String>();
		propertyOrderValuesLA.add(propLargeAnimalBoneMax.getName());
		propertyOrderValuesLA.add(propLargeAnimalBoneMin.getName());
		propertyOrderValuesLA.add(propLargeAnimalMeatMax.getName());
		propertyOrderValuesLA.add(propLargeAnimalMeatMin.getName());
		propertyOrderValuesLA.add(propLargeAnimalHideMax.getName());
		propertyOrderValuesLA.add(propLargeAnimalHideMin.getName());
		
		List<String> propertyOrderValuesMA = new ArrayList<String>();
		propertyOrderValuesMA.add(propMediumAnimalMeatMax.getName());
		propertyOrderValuesMA.add(propMediumAnimalMeatMin.getName());
		propertyOrderValuesMA.add(propMediumAnimalBoneMax.getName());
		propertyOrderValuesMA.add(propMediumAnimalBoneMin.getName());
		propertyOrderValuesMA.add(propSpiderWebMax.getName());
		propertyOrderValuesMA.add(propSpiderWebMin.getName());
		propertyOrderValuesMA.add(propSpiderStringMax.getName());
		propertyOrderValuesMA.add(propSpiderStringMin.getName());
		
		List<String> propertyOrderValuesSA = new ArrayList<String>();
		propertyOrderValuesSA.add(propSmallAnimalMeatMax.getName());
		propertyOrderValuesSA.add(propSmallAnimalMeatMin.getName());
		propertyOrderValuesSA.add(propSmallAnimalHideMax.getName());
		propertyOrderValuesSA.add(propSmallAnimalHideMin.getName());
		propertyOrderValuesSA.add(propSmallAnimalBoneCount.getName());		
		propertyOrderValuesSA.add(propChickenFeatherMax.getName());
		propertyOrderValuesSA.add(propChickenFeatherMin.getName());
		propertyOrderValuesSA.add(propRabbitFootMax.getName());
		propertyOrderValuesSA.add(propRabbitFootMin.getName());		
		 
		config.setCategoryPropertyOrder(CATEGORY_TOGGLES, propertyOrderToggles);
		config.setCategoryPropertyOrder(CATEGORY_VALUES, propertyOrderValues);
		config.setCategoryPropertyOrder(CATEGORY_VALUESLA, propertyOrderValuesLA);
		config.setCategoryPropertyOrder(CATEGORY_VALUESMA, propertyOrderValuesMA);
		config.setCategoryPropertyOrder(CATEGORY_VALUESSA, propertyOrderValuesSA);
		
		if(readFieldsFromConfig){
			// test1 = propTest1.getInt();
			// test2 = propTest2.getInt();		

			boolAllowCustomHeadDrops = propAllowCustomHeadDrops.getBoolean();
			boolWitherSkeletonCanDropHead = propWitherSkeletonCanDropHead.getBoolean();
			boolSkeletonCanDropHead = propSkeletonCanDropHead.getBoolean();
			boolCreeperCanDropHead = propCreeperCanDropHead.getBoolean();
			boolZombieCanDropHead = propZombieCanDropHead.getBoolean();
			boolPreventDoubleVanillaDrops = propPreventDoubleVanillaDrops.getBoolean();

			intItemsToCookDuringSleep = propItemsToCookDuringSleep.getInt();
			intBabyAnimalMinutesToAdult = propBabyAnimalMinutesToAdult.getInt();
			intAnvilBreakChancePercent = propAnvilBreakChancePercent.getInt();
			intLargeAnimalBoneMax = propLargeAnimalBoneMax.getInt();
			intLargeAnimalBoneMin = propLargeAnimalBoneMin.getInt();
			intLargeAnimalMeatMax = propLargeAnimalMeatMax.getInt();
			intLargeAnimalMeatMin = propLargeAnimalMeatMin.getInt();
			intLargeAnimalHideMax = propLargeAnimalHideMax.getInt();
			intLargeAnimalHideMin = propLargeAnimalHideMin.getInt();
			intMediumAnimalMeatMax = propMediumAnimalMeatMax.getInt();
			intMediumAnimalMeatMin = propMediumAnimalMeatMin.getInt();
			intMediumAnimalBoneMax = propMediumAnimalBoneMax.getInt();
			intMediumAnimalBoneMin = propMediumAnimalBoneMin.getInt();
			intSmallAnimalMeatMax = propSmallAnimalMeatMax.getInt();
			intSmallAnimalMeatMin = propSmallAnimalMeatMin.getInt();
			intSmallAnimalHideMax = propSmallAnimalHideMax.getInt();
			intSmallAnimalHideMin = propSmallAnimalHideMin.getInt();
			intSmallAnimalBoneCount = propSmallAnimalBoneCount.getInt();
			intIronGolemIngotsMin = propIronGolemIngotsMin.getInt();
			intIronGolemIngotsMax = propIronGolemIngotsMax.getInt();
			intChickenFeatherMax = propChickenFeatherMax.getInt();
			intChickenFeatherMin = propChickenFeatherMin.getInt();
			intRabbitFootMax = propRabbitFootMax.getInt();
			intRabbitFootMin = propRabbitFootMin.getInt();
			intSpiderWebMax = propSpiderWebMax.getInt();
			intSpiderWebMin = propSpiderWebMin.getInt();
			intSpiderStringMax = propSpiderStringMax.getInt();
			intSpiderStringMin = propSpiderStringMin.getInt();
			intBlazeFireChargeMax = propBlazeFireChargeMax.getInt();
			intBlazeFireChargeMin = propBlazeFireChargeMin.getInt();
			intBlazeRodMax = propBlazeRodMax.getInt();
			intBlazeRodMin = propBlazeRodMin.getInt();
			intCreeperLeavesMax = propCreeperLeavesMax.getInt();
			intCreeperLeavesMin = propCreeperLeavesMin.getInt();
			intWitherCoalMax = propWitherCoalMax.getInt();
			intWitherCoalMin = propWitherCoalMin.getInt();
			intHumanoidBonesMax = propHumanoidBonesMax.getInt();
			intHumanoidBonesMin = propHumanoidBonesMin.getInt();
			intPigZombiePorkchopMax = propPigZombiePorkchopMax.getInt();
			intPigZombiePorkchopMin = propPigZombiePorkchopMin.getInt();
			intEndermanPearlMax = propEndermanPearlMax.getInt();
			intEndermanPearlMin = propEndermanPearlMin.getInt();
			intEndermanPotionMax = propEndermanPotionMax.getInt();
			intBowEnemiesArrowMax = propBowEnemiesArrowMax.getInt();
			intBowEnemiesArrowMin = propBowEnemiesArrowMin.getInt();
			intEndermanWoolCount = propEndermanWoolCount.getInt();
			intWitchMaxPotionCount = propWitchMaxPotionCount.getInt();
			intWitchMaxEmeraldCount = propWitchMaxEmeraldCount.getInt();
			intWitchWoolCount = propWitchWoolCount.getInt();
			intHeadDropPercentChance = propHeadDropPercentChance.getInt();

			// INTS
			
		}
		
		// propTest1.set(test1);
		// propTest2.set(test2);

		propAllowCustomHeadDrops.set(boolAllowCustomHeadDrops);
		propWitherSkeletonCanDropHead.set(boolWitherSkeletonCanDropHead);
		propSkeletonCanDropHead.set(boolSkeletonCanDropHead);
		propCreeperCanDropHead.set(boolCreeperCanDropHead);
		propZombieCanDropHead.set(boolZombieCanDropHead);
		propPreventDoubleVanillaDrops.set(boolPreventDoubleVanillaDrops);

		propItemsToCookDuringSleep.set(intItemsToCookDuringSleep);
		propBabyAnimalMinutesToAdult.set(intBabyAnimalMinutesToAdult);
		propAnvilBreakChancePercent.set(intAnvilBreakChancePercent);
		propLargeAnimalBoneMax.set(intLargeAnimalBoneMax);
		propLargeAnimalBoneMin.set(intLargeAnimalBoneMin);
		propLargeAnimalMeatMax.set(intLargeAnimalMeatMax);
		propLargeAnimalMeatMin.set(intLargeAnimalMeatMin);
		propLargeAnimalHideMax.set(intLargeAnimalHideMax);
		propLargeAnimalHideMin.set(intLargeAnimalHideMin);
		propMediumAnimalMeatMax.set(intMediumAnimalMeatMax);
		propMediumAnimalMeatMin.set(intMediumAnimalMeatMin);
		propMediumAnimalBoneMax.set(intMediumAnimalBoneMax);
		propMediumAnimalBoneMin.set(intMediumAnimalBoneMin);
		propSmallAnimalMeatMax.set(intSmallAnimalMeatMax);
		propSmallAnimalMeatMin.set(intSmallAnimalMeatMin);
		propSmallAnimalHideMax.set(intSmallAnimalHideMax);
		propSmallAnimalHideMin.set(intSmallAnimalHideMin);
		propSmallAnimalBoneCount.set(intSmallAnimalBoneCount);
		propIronGolemIngotsMin.set(intIronGolemIngotsMin);
		propIronGolemIngotsMax.set(intIronGolemIngotsMax);
		propChickenFeatherMax.set(intChickenFeatherMax);
		propChickenFeatherMin.set(intChickenFeatherMin);
		propRabbitFootMax.set(intRabbitFootMax);
		propRabbitFootMin.set(intRabbitFootMin);
		propSpiderWebMax.set(intSpiderWebMax);
		propSpiderWebMin.set(intSpiderWebMin);
		propSpiderStringMax.set(intSpiderStringMax);
		propSpiderStringMin.set(intSpiderStringMin);
		propBlazeFireChargeMax.set(intBlazeFireChargeMax);
		propBlazeFireChargeMin.set(intBlazeFireChargeMin);
		propBlazeRodMax.set(intBlazeRodMax);
		propBlazeRodMin.set(intBlazeRodMin);
		propCreeperLeavesMax.set(intCreeperLeavesMax);
		propCreeperLeavesMin.set(intCreeperLeavesMin);
		propWitherCoalMax.set(intWitherCoalMax);
		propWitherCoalMin.set(intWitherCoalMin);
		propHumanoidBonesMax.set(intHumanoidBonesMax);
		propHumanoidBonesMin.set(intHumanoidBonesMin);
		propPigZombiePorkchopMax.set(intPigZombiePorkchopMax);
		propPigZombiePorkchopMin.set(intPigZombiePorkchopMin);
		propEndermanPearlMax.set(intEndermanPearlMax);
		propEndermanPearlMin.set(intEndermanPearlMin);
		propEndermanPotionMax.set(intEndermanPotionMax);
		propBowEnemiesArrowMax.set(intBowEnemiesArrowMax);
		propBowEnemiesArrowMin.set(intBowEnemiesArrowMin);
		propEndermanWoolCount.set(intEndermanWoolCount);
		propWitchMaxPotionCount.set(intWitchMaxPotionCount);
		propWitchMaxEmeraldCount.set(intWitchMaxEmeraldCount);
		propWitchWoolCount.set(intWitchWoolCount);
		propHeadDropPercentChance.set(intHeadDropPercentChance);
		
		
		
		if(config.hasChanged()) config.save();
		
		
	}
//
	public static class ConfigEventHandler{
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event){
			if(event.getModID().equals(Reference.MOD_ID)){
				syncFromGui();
			}
		}	
	}
	
	
//    @EventBusSubscriber
//    public class ConfigEventHandler {
//      
//      @SubscribeEvent
//      public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
//        if (event.getModID().equals(Reference.MOD_ID)){
//          syncFromGui();
//        }
//      }   
//	}    
//	
////	
//	public static class ConfigEventHandler {		
//		@SubscribeEvent(priority = EventPriority.NORMAL)
//		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
//			if(event.getModID().equals(Reference.MOD_ID)) {
//				syncFromGui();
//			}
//		}
//		
//	}	
}
