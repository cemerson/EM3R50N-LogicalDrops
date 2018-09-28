package com.cemerson.logicaldrops.entity;

import net.minecraftforge.event.AnvilUpdateEvent;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.cemerson.logicaldrops.LogicalDrops;
import com.cemerson.logicaldrops.config.LDConfig;

import jline.internal.Log;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumDyeColor;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;


// http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2389704-realistic-animal-products-and-drops-mod-updates
// Realistic Survival Mod! : https://www.youtube.com/watch?v=hQ9Ii9AZg78

// helpful!
// http://www.minecraftupdates.com/summon-command
// https://www.digminecraft.com/generators/summon_mob.php

public class RealisticEntityBehaviorHandler {
        
/*
 * https://github.com/FallenMoonNetwork/CanaryLib/blob/405090bda84ad4525477a26b1db8ea8646d90258/src/main/java/net/canarymod/api/DyeColor.java
 * 
    WHITE(15790320), //
    ORANGE(15435844), //
    MAGENTA(12801229), //
    LIGHT_BLUE(6719955), //
    YELLOW(14602026), //
    LIME(4312372), //
    PINK(14188952), //
    GRAY(4408131), //
    LIGHT_GRAY(11250603), //
    CYAN(2651799), //
    PURPLE(8073150), //
    BLUE(2437522), //
    BROWN(5320730), //
    GREEN(3887386), //
    RED(11743532), //
    BLACK(1973019), //
    CUSTOM(-1);
    ;*/
    
//// FOR TESTING ONLY
//  @SubscribeEvent
//  public void checkLivingEvent(LivingEvent event){            
//
//      if(event.getEntity() instanceof EntityCow || event.getEntity() instanceof EntitySheep){
//          int modifiedGrowingAge = 0;
//          int entityAge = 0;
//          int entityId = 0;
//          String etype = "";          
//          if(event.getEntity() instanceof EntitySheep){
//              EntitySheep S = (EntitySheep)event.getEntity(); 
//              entityAge = S.getGrowingAge();
//              entityId = S.getEntityId();
//              etype = "SHEEP";
//          }else{
//              
//              EntityCow C = (EntityCow)event.getEntity();
//              entityAge = C.getGrowingAge();      
//              entityId = C.getEntityId();             
//              etype = "COW";
//          }           
//          
//          EntityAgeable EA = (EntityAgeable)event.getEntity();
//          int EAage = EA.getGrowingAge();
//          
//          if(entityAge < -1){
//              Log.info(" >>> " + etype + "(" + entityId + ") AGE:(" + entityAge + ")...{EAage:" + EAage + "}");
//          }           
//      }
//  }
    
    
    //AnvilRepairEvent. You can get the "current anvil" from the opened container(event.getEntityPlayer().openContainer). It is likely an instance of ContainerRepair(although it might not be in case of modded anvils so you have to account for that). ContainerRepair has a selfPosition field you can use to get the position of the anvil.
    //Although none of that is needed if you simply want to modify the break chance for the anvil. Just use AnvilRepairEvent#setBreakChance?.   
    // vanilla break chance is 12% 0.12f
    @SubscribeEvent
    public void LogicalAnvilRepairEvent(AnvilRepairEvent event){ // Log.trace(event);           
        String breakChancePercent = "0." + LDConfig.intAnvilBreakChancePercent;
        float fbreakChance = Float.parseFloat(breakChancePercent);                      
        event.setBreakChance(fbreakChance); // Log.info("LogicalDrops: Anvil Chance to break:" + fbreakChance + "%");
    }
    
    @SubscribeEvent
    public void checkLivingEvent(EntityJoinWorldEvent event){
                
        if(event.getEntity() instanceof EntityAnimal){ 
        
            int modifiedGrowingAge = 0;
            EntityAgeable EA = (EntityAgeable)event.getEntity();
            int EAage = EA.getGrowingAge();
            
            // baby?
            if(EAage < -1){

                // 20 ticks = 1 minute
                double identifier = java.lang.Double.NaN;
                int ticksPerMinute = 1200;
                if(LDConfig.intBabyAnimalMinutesToAdult != identifier){
                    modifiedGrowingAge = (0 - Math.round(LDConfig.intBabyAnimalMinutesToAdult * ticksPerMinute));               
                    EA.setGrowingAge(modifiedGrowingAge); //                                                            
                }           
                
                int entityAge = EA.getGrowingAge();
                int entityId = event.getEntity().getEntityId();
                String etype = event.getEntity().getEntityData().getTypeName(entityId);                  
        
                // String strDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
                // Log.info("******EntityJoinWorldEvent: " + etype + "(" + entityId + ") ALMOST ADULT!  | DATE:" + strDate + "*** (age:" + entityAge + ") [modifiedGrowingAge:" + modifiedGrowingAge + "]");            
            
            }
        
        }       
    }
    
    
    @SubscribeEvent
    public void AlterDrops(LivingDropsEvent event){
        
        boolean isLivingEntity = event.getEntityLiving() instanceof EntityLiving;
        if(!isLivingEntity || !LDConfig.boolPreventDoubleVanillaDrops) return;
        
        // let zombies drop whatever
        if(event.getEntityLiving() instanceof EntityZombie) return;
        
        // Log.info("Something dropping items! [isLivingEntity:" + isLivingEntity + "]");
        
        List<EntityItem> filteredDrops = new ArrayList<EntityItem>();
        
     // TESTING // Log.info("drops before...");
        List<EntityItem> drops = event.getDrops();  
        for(EntityItem ei : drops){
            // Log.info(".. item string:" + ei.getItem().toString());
            if(
                    (ei.getItem().getItem() instanceof ItemFood) ||
                    (ei.getItem().toString().indexOf("leather") > -1) ||
                    (ei.getItem().toString().indexOf("feather") > -1) ||
                    (ei.getItem().toString().indexOf("dyePowder") > -1) ||
                    (ei.getItem().toString().indexOf("wool") > -1) ||
                    (ei.getItem().toString().indexOf("ingotIron") > -1) ||
                    (ei.getItem().toString().indexOf("yellowDust") > -1) ||
                    (ei.getItem().toString().indexOf("sulphur") > -1) ||
                    (ei.getItem().toString().indexOf("potion") > -1) ||
                    (ei.getItem().toString().indexOf("item.bone") > -1) || 
                    (ei.getItem().toString().indexOf("item.arrow") > -1) ||
                    (ei.getItem().toString().indexOf("string") > -1) || 
                    (ei.getItem().toString().indexOf("rabbitHide") > -1) ||
                    (ei.getItem().toString().indexOf("skull") > -1)
                    
                    ){
                // TESTING // Log.info(" ..... Food or leather falling! leather index[" + ei.getItem().getItem().toString().indexOf("leather") + "]");
            }else{
                filteredDrops.add(ei);
            }            
            // Log.info(ei.getItem());
            // Log.info(ei);    
        }
        // TESTING // Log.info("drops after...");
        event.getDrops().clear();
        for(EntityItem fei : filteredDrops){
            // Log.info(fei.getItem());
            event.getDrops().add(fei);
        }
        
                    
    }
        
        
    // one method to rule them all
    @SubscribeEvent
    public void playerKilledSomethingWithLogicalDrops(LivingDeathEvent event)
    {                   
        int boneCount = 0;
        Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if(isNotServerWorld){

            // PARROT
            if((event.getEntityLiving() instanceof EntityParrot))
            {            
                
                int featherCount = getRandom(LDConfig.intChickenFeatherMin,LDConfig.intChickenFeatherMax);
                ItemStack feathers = new ItemStack(Items.FEATHER,0);
                                                
                if(LDConfig.intChickenFeatherMax > 0) event.getEntityLiving().entityDropItem(feathers, 0);                
                
                ItemStack meat = new ItemStack(Items.CHICKEN,0);
                int meatCount = getRandom(0,1);                
            
                if(!AgeableEntityIsAdult((EntityAgeable)event.getEntity())){
                    featherCount = getRandom(0,LDConfig.intChickenFeatherMin);
                }
                
                if(LivingEntityIsOnFire(event)){
                    meat = new ItemStack(Items.COOKED_CHICKEN,0);
                    featherCount = 0;
                }               
                
                feathers.setCount(featherCount);
                meat.setCount(meatCount);
                if(meatCount > 0) event.getEntityLiving().entityDropItem(meat,0);
                
                                                                                           
            }
            
            else if((event.getEntityLiving() instanceof EntitySquid)){
                
                ItemStack blackDye = new ItemStack(Items.field_151100_aR,1,0);
                blackDye.setCount(getRandom(2,6));
                if(blackDye.getCount() > 0) event.getEntityLiving().entityDropItem(blackDye, 0);
                
            }

            // VILLAGERS
            else if((event.getEntityLiving() instanceof EntityVillager))
            {            
                EntityVillager V = (EntityVillager)event.getEntityLiving();

                VillagerProfession prof = V.getProfessionForge();
                
                ItemStack tool;
                ItemStack shirt;
                
                //https://www.spigotmc.org/threads/get-villager-career.216494/
                
                switch(prof.getRegistryName().toString()){
                    case "minecraft:smith":
                        int ironItemCount = getRandom(1,3); //LDConfig.intMaxNumberSmithItems);
                        
                        ItemStack ironIngots = new ItemStack(Items.IRON_INGOT,0);
                        ironIngots.setCount(getRandom(1,4));
                        event.getEntityLiving().entityDropItem(ironIngots, 0);                        
                       
                        // DropRandomIronItems(event,prof.getCareer(0).getName(),ironItemCount);                                                                      
                        GetRandomIronItem(event,prof.getCareer(0).getName());

                        dropColoredShirt(event,4408131); //1973019);                        
                        
                    break;
                    case "minecraft:farmer":
                        int cropCount = getRandom(3,8);
                        ItemStack crop = GetRandomFarmerCrop();
                        crop.setCount(cropCount);
                        event.getEntityLiving().entityDropItem(crop, 0);                    
                        
                        tool = new ItemStack(Items.IRON_HOE,0);
                        tool.setCount(1);
                        event.getEntityLiving().entityDropItem(tool, 0);
                        
                        dropColoredShirt(event,5320730);     
                        
                        
                        break;
                    case "minecraft:butcher":
                        int meatCount = getRandom(4,8);
                        ItemStack meat = GetRandomMeat(event);
                                                
                        meat.setCount(meatCount);
                        event.getEntityLiving().entityDropItem(meat, 0);
                        
                        tool = new ItemStack(Items.IRON_AXE,0);
                        tool.setCount(1);
                        event.getEntityLiving().entityDropItem(tool, 0);
                        
                        dropColoredShirt(event,4408131);                               
                        
                        // also ?
                        // black leather shirt
                        break;              
                    case "minecraft:librarian":
                        int bookCount = getRandom(4,8);
                        ItemStack book = new ItemStack(Items.BOOK,0);
                        book.setCount(bookCount);
                        event.getEntityLiving().entityDropItem(book,0);                 
                        // 
                        // also pen quil?                        
                        tool = new ItemStack(Items.WRITABLE_BOOK,0);
                        tool.setCount(1);
                        event.getEntityLiving().entityDropItem(tool, 0);                        

//                      ItemStack tomeStack = new ItemStack(Item.writableBook);
//                       tomeStack.setTagInfo("pages", l);
//                       tomeStack.setTagInfo("author", new NBTTagString("author", author));
//                       tomeStack.setTagInfo("title", new NBTTagString("title", title));
//                       tomeStack.itemID = Item.writtenBook.itemID;
                        
                        dropColoredShirt(event,15790320);
                        
                        break;              
                    case "minecraft:priest":
                    case "minecraft:cleric":                    
                        //int meatCount = getRandom(4,8);
                        //ItemStack meat = new ItemStack(Items.BEEF,0);
                        //meat.setCount(meatCount);
                        //event.getEntityLiving().entityDropItem(meat, 0);                  
                        
                        PotionType potionType = GetRandomPotionType(); // PotionTypes.HEALING;
                        ItemStack potionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potionType);
                        int potionCount = getRandom(1,3);
                        potionStack.setCount(potionCount);
                        event.getEntityLiving().entityDropItem(potionStack, 0);
                        
                        // also 1 book?                       
                        tool = new ItemStack(Items.BOOK,0);
                        tool.setCount(1);
                        event.getEntityLiving().entityDropItem(tool,0);
                        
                        dropColoredShirt(event,8073150);                        
                                                                                              
                        break;                                  
                    default:
                        
                        break;          
                }
                
                
                // all villagers drop bones/skull
                ItemStack skellieHead = new ItemStack(Items.field_151144_bL, 1, 0);
                skellieHead.setCount(1);            
                dropHumanRemains(event);
            }         
            

                       


            // =============================================== ORIGINAL =====================================================

            else if(event.getEntityLiving() instanceof EntitySkeletonHorse){
                boneCount = getRandom(LDConfig.intLargeAnimalBoneMin,LDConfig.intLargeAnimalBoneMax);
                
            }
            
            // COW / polar bear / horse / llama
            else if((event.getEntityLiving() instanceof EntityCow || 
                    event.getEntityLiving() instanceof EntityPolarBear ||
                    event.getEntityLiving() instanceof EntityHorse ||
                    event.getEntityLiving() instanceof EntityMule ||
                    event.getEntityLiving() instanceof EntityDonkey ||
                    event.getEntityLiving() instanceof EntityLlama
                    ))
            {
                              
                boneCount = getRandom(LDConfig.intLargeAnimalBoneMin,LDConfig.intLargeAnimalBoneMax);
                int meatCount = getRandom(LDConfig.intLargeAnimalMeatMin,LDConfig.intLargeAnimalMeatMax); // 30 lbs steaks super minimum!           
                int leatherCount = getRandom(LDConfig.intLargeAnimalHideMin,LDConfig.intLargeAnimalHideMax);
                
                ItemStack meat = new ItemStack(Items.BEEF,0);
                ItemStack leather = new ItemStack(Items.LEATHER,0);                
                                               
                // baby animal?
                if(!AgeableEntityIsAdult((EntityAgeable)event.getEntity())){
                    boneCount = LDConfig.intSmallAnimalBoneCount;
                    meatCount = getRandom(0,LDConfig.intMediumAnimalMeatMax); // 30 lbs steaks super minimum!           
                    leatherCount = getRandom(0,LDConfig.intSmallAnimalHideMin);                 
                }
                
                if(LivingEntityIsOnFire(event)) meat = new ItemStack(Items.COOKED_BEEF,0);
                
                meat.setCount(meatCount);
                leather.setCount(leatherCount);
                                                   
                
                if(LDConfig.intLargeAnimalMeatMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
                /* leather! duh!!*/
                if(LDConfig.intLargeAnimalHideMax > 0) event.getEntityLiving().entityDropItem(leather, 0);
                

            }               


            // ENDERMAN
            else if((event.getEntityLiving() instanceof EntityEnderman))
            {           
                if(LDConfig.intEndermanPearlMax > 0) event.getEntityLiving().func_145779_a(Items.ENDER_PEARL, getRandom(LDConfig.intEndermanPearlMin,LDConfig.intEndermanPearlMax));
                ItemStack blackWool = new ItemStack(Blocks.field_150325_L, 1, 15); // black wool
                blackWool.setCount(LDConfig.intEndermanWoolCount);
                event.getEntityLiving().entityDropItem(blackWool,0);
                
                if(LDConfig.intEndermanPotionMax > 0){
                    
                    
                    ItemStack potionStack = new ItemStack(Items.GLASS_BOTTLE,0);                    
                    // if burning empty potion
                    if(!LivingEntityIsOnFire(event)){
                        potionStack = null;
                        PotionType potionType = PotionTypes.NIGHT_VISION;
                        potionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potionType);
                    }
                    
                    potionStack.setCount(getRandom(0,LDConfig.intEndermanPotionMax));
                    event.getEntityLiving().entityDropItem(potionStack,0);                  
                }
                
                
                if(skullRandomDropSuccess()){
                    ItemStack head = GetCustomHead("MHF_Enderman","Enderman Skull");
                    head.setCount(1);
                    event.getEntityLiving().entityDropItem(head,0);
                }
          
            }               


            // CHICKEN
            else if((event.getEntityLiving() instanceof EntityChicken))
            {
                int featherCount = getRandom(LDConfig.intChickenFeatherMin,LDConfig.intChickenFeatherMax);
                int meatCount = getRandom(LDConfig.intSmallAnimalMeatMin,LDConfig.intSmallAnimalMeatMax); // 30 lbs steaks super minimum!           
                // ItemStack bones = new ItemStack(Items.BONE,0);
                ItemStack meat = new ItemStack(Items.CHICKEN,0);
                ItemStack feathers = new ItemStack(Items.FEATHER,0);               
                
                if(LivingEntityIsOnFire(event)){
                    meat = new ItemStack(Items.COOKED_CHICKEN,0);
                    featherCount = 0;
                }
                                
                boneCount = LDConfig.intSmallAnimalBoneCount;
                
                if(!AgeableEntityIsAdult((EntityAgeable)event.getEntity())){
                    boneCount = 0; //LDConfig.intSmallAnimalBoneCount;
                    meatCount = 0; //getRandom(0,LDConfig.intSmallAnimalMeatMin); // 30 lbs steaks super minimum!
                    featherCount = getRandom(0,LDConfig.intChickenFeatherMin);
                }
                
                meat.setCount(meatCount);           
                feathers.setCount(featherCount);                
                            
                if(LDConfig.intChickenFeatherMax > 0) event.getEntityLiving().entityDropItem(feathers, 0);
                if(LDConfig.intSmallAnimalMeatMax > 0) event.getEntityLiving().entityDropItem(meat,0);
                // event.getEntityLiving().entityDropItem(bones,0);
            } 
            
            // OCELOT
            else if((event.getEntityLiving() instanceof EntityOcelot))
            {
//                int featherCount = getRandom(LDConfig.intChickenFeatherMin,LDConfig.intChickenFeatherMax);
//                int meatCount = getRandom(LDConfig.intSmallAnimalMeatMin,LDConfig.intSmallAnimalMeatMax); // 30 lbs steaks super minimum!           
                // ItemStack bones = new ItemStack(Items.BONE,0);
                boneCount = LDConfig.intSmallAnimalBoneCount;
                //ItemStack meat = new ItemStack(Items.CHICKEN,0);
                //ItemStack feathers = new ItemStack(Items.FEATHER,0);
                
                if(!AgeableEntityIsAdult((EntityAgeable)event.getEntity())){
                    boneCount = 0; //LDConfig.intSmallAnimalBoneCount;
                }               

            }             

            // SHEEP / PIG / WOLF
            else if((event.getEntityLiving() instanceof EntitySheep ||
                    event.getEntityLiving() instanceof EntityPig || 
                    event.getEntityLiving() instanceof EntityWolf
                    ))
            {
                // ItemStack bones = new ItemStack(Items.BONE,0);
                boneCount = getRandom(LDConfig.intMediumAnimalBoneMin,LDConfig.intMediumAnimalBoneMax);
                int meatCount = getRandom(LDConfig.intMediumAnimalMeatMin,LDConfig.intMediumAnimalMeatMax); // 30 lbs steaks super minimum!
                
                ItemStack leather = new ItemStack(Items.LEATHER,0);
                
                ItemStack meat = new ItemStack(Items.MUTTON,0);
                // if(event.getEntityLiving() instanceof EntityWolf) meat.getOrCreateChildTag("display").setString("Name","Wolf Meat");
                
                if(event.getEntityLiving() instanceof EntityPig) meat = new ItemStack(Items.PORKCHOP,0);
                
                if(event.getEntityLiving() instanceof EntitySheep && LivingEntityIsOnFire(event)){
                    EntitySheep ES = (EntitySheep)event.getEntityLiving();
                    ES.setFleeceColor(EnumDyeColor.BLACK);                  
                }
                
                // wolf logic
                int leatherCount = 1;
                if(event.getEntityLiving() instanceof EntityWolf){                                                           
                    meatCount = Math.round(meatCount/2);
                    leather.setCount(leatherCount);
                    
                    
//                    ItemStack em = new ItemStack(Items.EMERALD,0);
//                    em.setCount(10);
//                    event.getEntity().entityDropItem(em, 0);
                }                
                                                                                  
                // baby animal?
                if(!AgeableEntityIsAdult((EntityAgeable)event.getEntity())){
                    boneCount = getRandom(0,LDConfig.intSmallAnimalBoneCount);
                    meatCount = getRandom(0,LDConfig.intSmallAnimalMeatMin); // 30 lbs steaks super minimum!                                            
                    leatherCount = 0;
                }                                                  
                                                
                if(LivingEntityIsOnFire(event)){
                    meat = new ItemStack(Items.COOKED_MUTTON,0);
                    if(event.getEntityLiving() instanceof EntityPig) meat = new ItemStack(Items.COOKED_PORKCHOP,0);
                    // if(event.getEntityLiving() instanceof EntityWolf) meat.getOrCreateChildTag("display").setString("Name","Cooked Wolf Meat");
                }
                
                
                meat.setCount(meatCount);
                if(meatCount > 0) event.getEntityLiving().entityDropItem(meat, 0);
                                
                if(leatherCount > 0) event.getEntityLiving().entityDropItem(leather, 0);
                
            }               
          

            // WITCH
            else if((event.getEntityLiving() instanceof EntityWitch))
            {
                ItemStack witchWool = new ItemStack(Blocks.field_150325_L, 1, 10); // purple wool
                if(LivingEntityIsOnFire(event)){
                    witchWool = new ItemStack(Blocks.field_150325_L, 1, 15); // black because burning!
                    // purpleWool.getOrCreateChildTag("display").setString("Name","Burned Wool");                   
                }
                witchWool.setCount(LDConfig.intWitchWoolCount);
                event.getEntityLiving().entityDropItem(witchWool, 0);          
                        

                ItemStack healPotionStack = new ItemStack(Items.GLASS_BOTTLE,0);
                
                // if burning, no wool and glass bottle
                if(!LivingEntityIsOnFire(event)){
                    healPotionStack     = null;
                    PotionType witchPotionType = GetRandomPotionType();                    
                    healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), witchPotionType);                   
                }
                healPotionStack.setCount(getRandom(0,LDConfig.intWitchMaxPotionCount));
                
                ItemStack emeralds = new ItemStack(Items.EMERALD,0);
                emeralds.setCount(getRandom(0,LDConfig.intWitchMaxEmeraldCount));
                
                event.getEntityLiving().entityDropItem(emeralds,0);
                event.getEntityLiving().entityDropItem(healPotionStack,0);
                
            //          ItemBook boo
            //          Enchantment ench = new Enchantment();
            //          
            //          EnchantedBook bookType = PotionTypes.healing;
            //          ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), witchPotionType);
            //          event.getEntityLiving().func_145779_a(healPotionStack,1);           

                if(LDConfig.intHumanoidBonesMax > 0) event.getEntityLiving().entityDropItem(new ItemStack(Items.BONE), getRandom(LDConfig.intHumanoidBonesMin,LDConfig.intHumanoidBonesMax)); // human, 8 bones
                
            } 
            
            // IRON GOLEM
            else if((event.getEntityLiving() instanceof EntityIronGolem))
            {
                int ironCount = getRandom(LDConfig.intIronGolemIngotsMin,LDConfig.intIronGolemIngotsMax);
                ItemStack iron = new ItemStack(Items.IRON_INGOT,0);
                iron.setCount(ironCount);
                event.getEntityLiving().entityDropItem(iron, 0);
                
                // if(LDConfig.intHumanoidBonesMax > 0) event.getEntityLiving().entityDropItem(new ItemStack(Items.BONE), getRandom(LDConfig.intHumanoidBonesMin,LDConfig.intHumanoidBonesMax)); // human, 8 bones
                
                dropHumanRemains(event);                
                
                
            }             


            // CREEPER
            else if((event.getEntityLiving() instanceof EntityCreeper))
            {
                // event.getEntityLiving().entityDropItem(new ItemStack(Blocks.TNT),0); // TNT!
                // ItemStack greenWool = new ItemStack(Blocks.field_150325_L, 1, 5);
                // greenWool.setCount(getRandom(LDConfig.intCreeperWoolMin,LDConfig.intCreeperWoolMax));
                // if(LDConfig.intCreeperWoolMax > 0) event.getEntityLiving()
                //  .entityDropItem(greenWool,0);
                
                ItemStack gunp = new ItemStack(Items.GUNPOWDER,0);
                gunp.setCount(getRandom(1,2));
                event.getEntityLiving().entityDropItem(gunp,0);
                
                ItemStack creeperHead = new ItemStack(Items.field_151144_bL, 1, 4);
                creeperHead.setCount(1);
                if(LDConfig.boolCreeperCanDropHead && skullRandomDropSuccess()) event.getEntityLiving()
                .entityDropItem(creeperHead,0);
                
                ItemStack leaves = new ItemStack(Blocks.field_150362_t, 1, 0);
                leaves.setCount(getRandom(LDConfig.intCreeperLeavesMin,LDConfig.intCreeperLeavesMax));
                if(LDConfig.intCreeperLeavesMax > 0) event.getEntityLiving().entityDropItem(leaves ,0);         
            }               

            // SKELETON
            else if((event.getEntityLiving() instanceof EntitySkeleton))
            {           
                
//              String armors = event.getEntityLiving().getArmorInventoryList().toString();             
//              Log.info("skeleton armors? {" + armors + "}");

                        
                ItemStack skellieHead = new ItemStack(Items.field_151144_bL, 1, 0);
                skellieHead.setCount(1);
                
                // ItemStack bones = new ItemStack(Items.BONE,0);
                boneCount = getRandom(LDConfig.intHumanoidBonesMin,LDConfig.intHumanoidBonesMax);
                
                if(LDConfig.boolWitherSkeletonCanDropHead && skullRandomDropSuccess()) 
                    event.getEntityLiving().entityDropItem(skellieHead, 0);                     
                // if(LDConfig.intHumanoidBonesMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
                
                enemyBowCheck(event.getEntityLiving());                                             
            }               


            // WITHERSKELETON
            else if((event.getEntityLiving() instanceof EntityWitherSkeleton))
            {       
                ItemStack witherHead = new ItemStack(Items.field_151144_bL, 1, 1);
                witherHead.setCount(1);
                
                ItemStack coal = new ItemStack(Items.COAL,0);
                coal.setCount(getRandom(LDConfig.intWitherCoalMin,LDConfig.intWitherCoalMax));
                
                // ItemStack bones = new ItemStack(Items.BONE,0);
                boneCount = getRandom(LDConfig.intHumanoidBonesMin,LDConfig.intHumanoidBonesMax);
                
                if(LDConfig.boolSkeletonCanDropHead && skullRandomDropSuccess()) 
                    event.getEntityLiving().entityDropItem(witherHead,0); // wither skull!
                if(LDConfig.intWitherCoalMax > 0) event.getEntityLiving().entityDropItem(coal, 0);
                
                // if(LDConfig.intHumanoidBonesMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
                
                enemyBowCheck(event.getEntityLiving());                                             
            }                       

            // BLAZE
            else if((event.getEntityLiving() instanceof EntityBlaze))
            {           
                                                                                
                if(LDConfig.intBlazeFireChargeMax > 0){
                    ItemStack blazeCharges = new ItemStack(Items.FIRE_CHARGE, 1);
                    blazeCharges.setCount(getRandom(LDConfig.intBlazeFireChargeMin,LDConfig.intBlazeFireChargeMax));
                    event.getEntityLiving().entityDropItem(blazeCharges,0);             
                }
                if(LDConfig.intBlazeRodMax > 0){
                    ItemStack blazeRods = new ItemStack(Items.BLAZE_ROD,1);
                    blazeRods.setCount(getRandom(LDConfig.intBlazeRodMin,LDConfig.intBlazeRodMax));
                    event.getEntityLiving().entityDropItem(blazeRods,0);
                }
                
                if(skullRandomDropSuccess()){
                    ItemStack head = GetCustomHead("MHF_Blaze","Blaze Skull");
                    head.setCount(1);
                    event.getEntityLiving().entityDropItem(head,0);
                }
                
                
            }               

            // SPIDER
            else if((event.getEntityLiving() instanceof EntitySpider && !LivingEntityIsOnFire(event)))
            {           
                //TODO: web not dropping            
                // ItemStack spiderWebs = new ItemStack(Blocks.web, 1);
                ItemBlock spiderWeb = (ItemBlock) ItemBlock.getItemFromBlock(Blocks.field_150321_G);
                int numberOfWebs = getRandom(LDConfig.intSpiderWebMin,LDConfig.intSpiderWebMax);
                int numberOfString = getRandom(LDConfig.intSpiderStringMin,LDConfig.intSpiderStringMax);
                
                ItemStack webs = new ItemStack(Blocks.field_150321_G,0);
                webs.setCount(numberOfWebs);
                ItemStack strings = new ItemStack(Items.STRING,0);
                strings.setCount(numberOfString); 
                
                if(LDConfig.intSpiderWebMax > 0) event.getEntityLiving().entityDropItem(webs, 0);
                if(LDConfig.intSpiderStringMax > 0) event.getEntityLiving().entityDropItem(strings, 0);
            }               

            // RABBIT
            else if((event.getEntityLiving() instanceof EntityRabbit))
            {                       

                boneCount = getRandom(0,LDConfig.intSmallAnimalBoneCount);
                int hideCount = getRandom(LDConfig.intSmallAnimalHideMin,LDConfig.intSmallAnimalHideMax);
                int meatCount = getRandom(LDConfig.intSmallAnimalMeatMin,LDConfig.intSmallAnimalMeatMax); // 30 lbs steaks super minimum!         
                // ItemStack bones = new ItemStack(Items.BONE,0);
                ItemStack meat = new ItemStack(Items.RABBIT,0);
                ItemStack hides = new ItemStack(Items.RABBIT_HIDE,0);
                ItemStack foots = new ItemStack(Items.RABBIT_FOOT,0);
                
                if(LivingEntityIsOnFire(event)){
                    hideCount = 0;
                    meat = new ItemStack(Items.COOKED_RABBIT,0);
                    foots.setCount(0);
                }
                               
                // if baby rabbit or on fire no meat/hide/feet
                if(!AgeableEntityIsAdult((EntityAgeable)event.getEntity())){
                    meatCount = 0;
                    hideCount = 0;
                    boneCount = 0;
                    foots.setCount(0);
                }
                
                
                
                // bones.setCount(boneCount);
                meat.setCount(meatCount);           
                hides.setCount(hideCount);
                foots.setCount(getRandom(LDConfig.intRabbitFootMin,LDConfig.intRabbitFootMax));
                
                            
                if(LDConfig.intRabbitFootMax > 0) event.getEntityLiving().entityDropItem(foots, 0);
                if(LDConfig.intSmallAnimalHideMax > 0) event.getEntityLiving().entityDropItem(hides, 0);
                if(LDConfig.intSmallAnimalMeatMax > 0) event.getEntityLiving().entityDropItem(meat,0);
                // event.getEntityLiving().entityDropItem(bones,0);                    
            }               
                         

            // PIGZOMBIE
            else if((event.getEntityLiving() instanceof EntityPigZombie))
            {
                 // plain skull
//                ItemStack zombieHead;
//                zombieHead = new ItemStack(Items.field_151144_bL,1, 0);
//                
                ItemStack meat = new ItemStack(Items.PORKCHOP,0);
                int pigZombieMeatCount = getRandom(LDConfig.intPigZombiePorkchopMin,LDConfig.intPigZombiePorkchopMax);
                
                if(LivingEntityIsOnFire(event)) meat = new ItemStack(Items.COOKED_PORKCHOP,0);
                
                meat.setCount(pigZombieMeatCount);                
                if(pigZombieMeatCount > 0) event.getEntityLiving().entityDropItem(meat, 0);
                
                dropHumanRemains(event);

            }
            // ZOMBIE
            else if((event.getEntityLiving() instanceof EntityZombie))
            {
                 // zombie head
                ItemStack zombieHead;
                zombieHead = new ItemStack(Items.field_151144_bL, 1, 2);                            
                // zombie shirt/pants
                //              ItemStack stackShirt = new ItemStack(Items.leather_chestplate, 1);
                //              ((ItemArmor) stackShirt.getItem()).setColor(stackShirt, 2651799); //15790320);          
                //              event.getEntityLiving().func_145779_a(stackShirt, 1);                           
                //              ItemStack stack = new ItemStack(Items.leather_leggings, 1);
                //              ((ItemArmor) stack.getItem()).setColor(stack, 8073150); //15790320);            
                //              event.getEntityLiving().func_145779_a(stack, 1);                
                dropHumanRemains(event);
              
             }      

        }
        
        
        if(boneCount > 0){
            ItemStack bones = new ItemStack(Items.BONE,0);
            bones.setCount(boneCount);            
            event.getEntityLiving().entityDropItem(bones, 0);                   
        }

    }


    private PotionType GetRandomPotionType() {
        PotionType pt = null;
        
        int rand = getRandom(0,11);
        int str = getRandom(0,100);
        switch(rand){
        case 0:    
            if(str > 60){
                pt = PotionTypes.LONG_FIRE_RESISTANCE;
            }else{
                pt = PotionTypes.FIRE_RESISTANCE;
            }            
            break;
        case 1:            
            if(str > 60){
                pt = PotionTypes.STRONG_HARMING;                
            }else{
                pt = PotionTypes.HARMING;
            }
            break;
        case 2:
            
            if(str > 60){
                pt = PotionTypes.STRONG_HEALING;    
            }else{
                pt = PotionTypes.HEALING;
            }
            break;
        case 3:
            
            if(str > 60){
                pt = PotionTypes.LONG_INVISIBILITY;
            }else{
                pt = PotionTypes.INVISIBILITY;
            }
            break;
        case 4:
            
            if(str > 80){
                pt = PotionTypes.STRONG_LEAPING;    
            }else if(str > 60){
                pt = PotionTypes.LONG_LEAPING;
            }else{
                pt = PotionTypes.LEAPING;
            }
            break;
        case 5:
            
            if(str > 60){
                pt = PotionTypes.LONG_NIGHT_VISION;
            }else{
                pt = PotionTypes.NIGHT_VISION;
            }
            break;
        case 6:
            
            if(str > 80){
                pt = PotionTypes.STRONG_POISON;    
            }else if(str > 60){
                pt = PotionTypes.LONG_POISON;
            }else{
                pt = PotionTypes.POISON;
            }
            break;
        case 7:
            
            if(str > 80){
                pt = PotionTypes.STRONG_REGENERATION;    
            }else if(str > 60){
                pt = PotionTypes.LONG_REGENERATION;
            }else{
                pt = PotionTypes.REGENERATION;
            }
            break;
        case 8:
            
            if(str > 60){
                pt = PotionTypes.LONG_SLOWNESS;
            }else{
                pt = PotionTypes.SLOWNESS;
            }
            break;
        case 9:
            
            if(str > 80){
                pt = PotionTypes.STRONG_STRENGTH;    
            }else if(str > 60){
                pt = PotionTypes.LONG_STRENGTH;
            }else{
                pt = PotionTypes.STRENGTH;
            }
            break;
        case 10:            
            if(str > 60){                
                pt = PotionTypes.LONG_WEAKNESS;
            }else{
                pt = PotionTypes.WEAKNESS;
            }
            break;
        }        
        
        return pt;
    }

    private boolean LivingEntityIsOnFire(LivingDeathEvent event) {
        boolean onFire = false; 
        
        // check first
        onFire = event.getSource().isFireDamage();
        
        // then check
        if(!onFire){
            EntityLiving EL = (EntityLiving)event.getEntityLiving();
            if(EL != null) onFire = (EL.isBurning());                   
        }
                
        // Log.info("was that on fire? [" + onFire + "]");

        return onFire;
    }


    private ItemStack GetRandomMeat(LivingDeathEvent event) {

        int randomMeatIndex = getRandom(0,4);
        ItemStack meat = new ItemStack(Items.BEEF,0);
        boolean isCooked = (LivingEntityIsOnFire(event));
        
        switch(randomMeatIndex){
        case 4:
            if(isCooked){
                meat = new ItemStack(Items.COOKED_BEEF);
            }else{
                meat = new ItemStack(Items.BEEF);
            }
            break;
        case 3:
            if(isCooked){
                meat = new ItemStack(Items.COOKED_CHICKEN);
            }else{
                meat = new ItemStack(Items.CHICKEN);
            }           
            break;
        case 2:
            if(isCooked){
                meat = new ItemStack(Items.COOKED_RABBIT);
            }else{
                meat = new ItemStack(Items.RABBIT);
            }           
            break;
        case 1:
            if(isCooked){
                meat = new ItemStack(Items.COOKED_MUTTON);
            }else{
                meat = new ItemStack(Items.MUTTON);
            }           
            break;
        case 0:
            if(isCooked){
                meat = new ItemStack(Items.COOKED_PORKCHOP);
            }else{
                meat = new ItemStack(Items.PORKCHOP);
            }           
            break;
        }
        
        return meat;        
        
    }


    private ItemStack GetRandomFarmerCrop() {
        // TODO Auto-generated method stub
        int cropSeed = getRandom(0,6);
        
        ItemStack crop = new ItemStack(Items.WHEAT,0);
        switch(cropSeed){
        case 0:
            crop = new ItemStack(Items.WHEAT,0);
            break;
        case 1:
            crop = new ItemStack(Items.POTATO,0);
            break;
        case 2:
            crop = new ItemStack(Items.PUMPKIN_SEEDS,0);
            break;
        case 3:
            crop = new ItemStack(Items.CARROT,0);
            break;
        case 4:
            crop = new ItemStack(Items.BEETROOT_SEEDS,0);           
            break;      
        case 5:                                 
            crop = new ItemStack(Items.field_151100_aR, 1, 3); // cocobean?            
            break;                  
        case 6:
            crop = new ItemStack(Items.MELON_SEEDS,0);          
            break;                              
        }
        
        int cropCount = getRandom(1,4);
        crop.setCount(cropCount);
        return crop;
        
    }

    private void GetRandomIronItem(LivingDeathEvent event, String professionName) {
        
        // no repeats?       
        ItemStack ironItem = new ItemStack(Items.IRON_NUGGET,0);

        int randomItemSeed = getRandom(0,8);
        //change iron item based on PRIMARY (0) career
        switch(randomItemSeed){ //professionName){
            case 8:
                ironItem = new ItemStack(Items.IRON_CHESTPLATE,0);                                                                   
                break;
            case 7:
                ironItem = new ItemStack(Items.IRON_LEGGINGS,0);                                                                         
                break;
            case 6:
                ironItem = new ItemStack(Items.IRON_BOOTS,0);                                            
                break;
            case 5:
                ironItem = new ItemStack(Items.IRON_HELMET,0);                                               
                break;
            case 4:
                ironItem = new ItemStack(Items.IRON_SWORD,0);                
                break;
            case 3:
                ironItem = new ItemStack(Items.IRON_AXE,0);              
                break;
            case 2:
                ironItem = new ItemStack(Items.IRON_PICKAXE,0);                                                                      
                break;                    
            case 1:
                ironItem = new ItemStack(Items.IRON_HOE,0);                             
                break;
            case 0:
            default:
                ironItem = new ItemStack(Items.IRON_SHOVEL,0);                                               
                break;
             
              }
                              
         ironItem.setCount(1); //ironCount);         
         event.getEntityLiving().entityDropItem(ironItem, 0);
            
         
    }

    private void DropRandomIronItems(LivingDeathEvent event, String professionName, int numberOfItems) {
     
     int randomIronCareer = getRandom(1,3);  
     
     for(int i=0;i<numberOfItems;i++){

        // no repeats?       
         ItemStack ironItem = new ItemStack(Items.IRON_NUGGET,0);
         
         int randomItemSeed = getRandom(0,100);
         //change iron item based on PRIMARY (0) career
         switch(randomIronCareer){ //professionName){
             case 3: //"armor":
                if(randomItemSeed > 75){
                    ironItem = new ItemStack(Items.IRON_CHESTPLATE,0);                                                      
                }else if(randomItemSeed > 50){
                    ironItem = new ItemStack(Items.IRON_LEGGINGS,0);                                                            
                }else if(randomItemSeed > 25){                              
                    ironItem = new ItemStack(Items.IRON_BOOTS,0);                               
                }else{
                    ironItem = new ItemStack(Items.IRON_HELMET,0);                                  
                }                           
                break;
             case 2: // "weapon":
                if(randomItemSeed > 50){
                    ironItem = new ItemStack(Items.IRON_SWORD,0);   
                }else{
                    ironItem = new ItemStack(Items.IRON_AXE,0); 
                }                                                       
                break;
             case 1: //"tool":
                if(randomItemSeed > 75){
                    ironItem = new ItemStack(Items.IRON_AXE,0);                                                     
                }else if(randomItemSeed > 50){
                    ironItem = new ItemStack(Items.IRON_PICKAXE,0);                                                         
                }else if(randomItemSeed > 25){                              
                    ironItem = new ItemStack(Items.IRON_HOE,0);                             
                }else{
                    ironItem = new ItemStack(Items.IRON_SHOVEL,0);                                  
                }                           
                break;
         }
                              
         ironItem.setCount(1); //ironCount);         
         event.getEntityLiving().entityDropItem(ironItem, 0);
     }       
         
 }       
         
        

// ------------------------------- HELPER METHODS -----------------------------

    private void dropHumanRemains(LivingDeathEvent event){

        // HEAD
        ItemStack head = null;
        if((event.getEntityLiving() instanceof EntityIronGolem) && skullRandomDropSuccess()){
            head = GetCustomHead("MHF_Golem","Iron Golem Skull");
            
        }else if((event.getEntityLiving() instanceof EntityVillager) && skullRandomDropSuccess()){          
            head = GetCustomHead("MHF_Villager","Villager Skull");          
            // head = new ItemStack(Items.field_151144_bL, 1, 0);
        }else if((event.getEntityLiving() instanceof EntityPigZombie)){
            if(LDConfig.boolZombieCanDropHead && skullRandomDropSuccess()) head = GetCustomHead("MHF_PigZombie","Pig Zombie Skull");
            
        }else if((event.getEntityLiving() instanceof EntityZombie)){
            if(LDConfig.boolZombieCanDropHead && skullRandomDropSuccess()) head = new ItemStack(Items.field_151144_bL, 1, 2);
            
        }else if((event.getEntityLiving() instanceof EntityWitherSkeleton)){            
            if (LDConfig.boolWitherSkeletonCanDropHead && skullRandomDropSuccess()) head = new ItemStack(Items.field_151144_bL, 1, 1);
        
        }else if((event.getEntityLiving() instanceof EntitySkeleton)){            
            if (LDConfig.boolSkeletonCanDropHead && skullRandomDropSuccess()) head = new ItemStack(Items.field_151144_bL, 1, 0);
        }
                
        if(head != null){
            head.setCount(1);
            event.getEntityLiving().entityDropItem(head, 0);
        }

        // BONES        
        int boneCount = getRandom(LDConfig.intHumanoidBonesMin,LDConfig.intHumanoidBonesMax);
        ItemStack bones = new ItemStack(Items.BONE,0);
        bones.setCount(boneCount);
        if(boneCount > 0) event.getEntityLiving().entityDropItem(bones, 0);
        
        
        // BOW?
        enemyBowCheck(event.getEntityLiving());
    }
    
    // REFERENCE: http://www.minecraftforge.net/forum/topic/24228-solved-1710-player-skulls/        
    private ItemStack GetCustomHead(String playerName, String headName) {           
        ItemStack customHead = new ItemStack(Items.field_151144_bL, 1, 3);    
        customHead.setTag(new NBTTagCompound()); 
        customHead.getTag().setTag("SkullOwner", new NBTTagString(playerName));         
        customHead.getOrCreateChildTag("display").setString("Name",headName);   
        return customHead;          
    }


    private Boolean skullRandomDropSuccess(){
        Boolean willDrop = false;
        int percentChanceSkullDrops = (100-LDConfig.intHeadDropPercentChance); // 60  100-60
        willDrop = (getRandom(1,100) >= percentChanceSkullDrops);
        return willDrop;
    }
         
    
    public void enemyBowCheck(EntityLivingBase enemy){
        try{
            EntityMob mob = (EntityMob) enemy;
            mob.getActiveHand();
            Item mobWeapon = mob.getHeldItem(EnumHand.MAIN_HAND).getItem();
            Boolean enemyHasBow = (mobWeapon instanceof ItemBow);       
            ItemStack arrowStack = new ItemStack(Items.ARROW);
            arrowStack.setCount(getRandom(LDConfig.intBowEnemiesArrowMin,LDConfig.intBowEnemiesArrowMax));
            if(LDConfig.intBowEnemiesArrowMax > 0) if(enemyHasBow) enemy.entityDropItem(arrowStack, 0);
        } catch (Exception e) {        
            // System.err.println("ouch!");
        }               
    }
    
      
    private int getRandom(int low, int high){
        Random rand = new Random(); 

        if(low == 0 && high == 0) return 0;
        if(high == 0) return 0;
        if(low > high) return 0;
        
        int randomNum = rand.nextInt((high - low) + 1) + low;        
        return randomNum;       
    }
        
    
    private void dropColoredShirt(LivingDeathEvent event, int color){

        ItemStack shirt = new ItemStack(Items.LEATHER_CHESTPLATE,0);
        
        if(LivingEntityIsOnFire(event)){
            color = 1973019;            
//          shirt.setTag(new NBTTagCompound()); 
//          shirt.getTag().setTag("SkullOwner", new NBTTagString(playerName));          
            shirt.getOrCreateChildTag("display").setString("Name","Burned Shirt");
        }       
        
        shirt.setCount(1);                                                
        ItemArmor colorShirt = (ItemArmor)shirt.getItem();
        shirt.setCount(1);                                        
        colorShirt.func_82813_b(shirt,color);                       
        event.getEntityLiving().entityDropItem(shirt, 0);               
    }

    private Boolean AgeableEntityIsAdult(EntityAgeable EA){
        return (EA.getGrowingAge() >= -1);              
    }
    
    // ---------------- NEW 20180915 --------------------   
    //  
    //     public int getColorInt( String color) {
    //            int intColor = 0;
    //          switch ( color ) {
    //              case "BLACK":
    //                  intColor = hex2Rgb( "#1D1D21");
    //                  break;
    //              case "RED":
    //                  intColor = hex2Rgb( "#B02E26");
    //                  break;
    //              case "GREENDARK":
    //                  intColor = hex2Rgb( "#5E7C16");
    //                  break;
    //              case "BROWN":
    //                  intColor = hex2Rgb( "#835432");
    //                  break;
    //              case "BLUE":
    //                case "BLUEDARK":
    //                  intColor = hex2Rgb( "#3C44AA");
    //                  break;
    //              case "PURPLE":
    //                  intColor = hex2Rgb( "#8932B8");
    //                  break;
    //              case "CYAN":
    //                  intColor = hex2Rgb( "#169C9C");
    //                  break;
    //              case "GRAYLIGHT":
    //                  intColor = hex2Rgb( "#9D9D97");
    //                  break;
    //              case "GRAY":
    //                case "GRAYDARK":
    //                  intColor = hex2Rgb( "#474F52");
    //                  break;
    //              case "PINK":
    //                  intColor = hex2Rgb( "#F38BAA");
    //                  break;
    //              case "LIME":
    //                case "GREENLIGHT":
    //                  intColor = hex2Rgb( "#80C71F");
    //                  break;
    //              case "YELLOW":
    //                  intColor = hex2Rgb( "#FED83D");
    //                  break;
    //              case "BLUELIGHT":
    //                  intColor = hex2Rgb( "#3AB3DA");
    //                  break;
    //              case "MAGENTA":
    //                  intColor = hex2Rgb( "#C74EBD");
    //                  break;
    //              case "ORANGE":
    //                  intColor = hex2Rgb( "#F9801D");
    //                  break;
    //              case "WHITE":
    //                  intColor = hex2Rgb( "#F9FFFE");
    //          }
    //          
    //          return intColor;
    //      }
    //
    //      private int hex2Rgb( String colorStr ) {
    //          Color rgb = new Color(
    //              Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
    //              Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
    //              Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
    //          
    //          return Integer.valueOf(rgb.toString());
    //      }       
    

      
}
