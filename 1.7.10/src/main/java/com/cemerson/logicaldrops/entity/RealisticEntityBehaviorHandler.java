package com.cemerson.logicaldrops.entity;

import java.util.Random;

import com.cemerson.logicaldrops.LogicalDrops;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;


// http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2389704-realistic-animal-products-and-drops-mod-updates
// Realistic Survival Mod! : https://www.youtube.com/watch?v=hQ9Ii9AZg78

// helpful!
// http://www.minecraftupdates.com/summon-command
// https://www.digminecraft.com/generators/summon_mob.php

public class RealisticEntityBehaviorHandler {
    
	public boolean etFuturumInstalled = Loader.isModLoaded("etfuturum"); //Loader.isModLoaded("Et Futurum"); //EtFuturumPlugin.isLoaded();
                
    @SubscribeEvent
    public void playerKilledCow(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
        if((event.entityLiving instanceof EntityCow) && (isNotServerWorld))
        {
            //String chatMsg = "LogicalDrops.intCowMeatMax=" + LogicalDrops.intCowMeatMax;              
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
                
            event.entityLiving.dropItem(Items.bone, getRandom(LogicalDrops.intCowBoneMin,LogicalDrops.intCowBoneMax)); 
            event.entityLiving.dropItem(Items.beef, getRandom(LogicalDrops.intCowMeatMin,LogicalDrops.intCowMeatMax)); // 30 lbs steaks super minimum!
        }               
    }
    
    @SubscribeEvent
    public void playerKilledEnderman(LivingDeathEvent event)
    {                   
         // String chatMsg = "Did player kill a cow?!";             
        // Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
         Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
        if((event.entityLiving instanceof EntityEnderman) && (isNotServerWorld))
        {           
            event.entityLiving.dropItem(Items.ender_pearl,  getRandom(LogicalDrops.intEndermanPearlMin,LogicalDrops.intEndermanPearlMax));
            ItemStack blackWool = new ItemStack(Blocks.wool, 1, 15); // black wool                                                              
            event.entityLiving.entityDropItem(blackWool,LogicalDrops.intEndermanWoolCount);         
                        
            ItemStack potionStack = new ItemStack(Items.potionitem, 1, 16310); //PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), potionType);
            event.entityLiving.entityDropItem(potionStack,1);                	
        }               
    }   
    
    @SubscribeEvent
    public void playerKilledChicken(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
        if((event.entityLiving instanceof EntityChicken) && (isNotServerWorld))
        {
            event.entityLiving.dropItem(Items.feather, getRandom(LogicalDrops.intChickenFeatherMin,LogicalDrops.intChickenFeatherMax));
            event.entityLiving.dropItem(Items.chicken, getRandom(LogicalDrops.intChickenMeatMin,LogicalDrops.intChickenMeatMax));
        }               
    }   
    
    @SubscribeEvent
    public void playerKilledSheep(LivingDeathEvent event)
    {                                               
        Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
        if((event.entityLiving instanceof EntitySheep) && (isNotServerWorld))
        {
            if(etFuturumInstalled){
                // Item eFmutton = (Item) EtFuturumPlugin.getMutton();
                // event.entityLiving.dropItem(eFmutton, getRandom(4,10)); // ModItems.raw_mutton
                // Item eFmutton = (Item)Item.itemRegistry.getObject("etfuturum:raw_mutton");
            	Item eFmutton = (Item)Item.itemRegistry.getObject("etfuturum:raw_mutton");
            	int meatCount = getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax);
            	event.entityLiving.dropItem(eFmutton, meatCount);
            	// ItemStack eFmutton = new ItemStack((Item)Item.itemRegistry.getObject("etfuturum:etfuturum:raw_mutton"), 1, getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax));               
                // event.entityLiving.entityDropItem(eFmutton,1); // eFmutton, getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax));
                
                // ganymedes01.etfuturum.ModItems
            }else{
                event.entityLiving.dropItem(Items.beef, getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax));
            }            
            event.entityLiving.dropItem(Items.bone, getRandom(LogicalDrops.intSheepBoneMin,LogicalDrops.intSheepBoneMax));                        
        }               
    }       
    
    @SubscribeEvent
    public void playerKilledZombie(LivingDeathEvent event)
    {                   
        // if(event.entityLiving instanceof EntityCreeper) return;     
        
        // problem: firing two times!?
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
         if(isNotServerWorld){
             ItemStack zombieHead;
             if((event.entityLiving instanceof EntityPigZombie)){
                 // plain skull
                zombieHead = new ItemStack(Items.skull, 1);
                event.entityLiving.dropItem(Items.porkchop, getRandom(LogicalDrops.intPigZombiePorkchopMin,LogicalDrops.intPigZombiePorkchopMax));
                dropZombieStuff(event, zombieHead);
             }else if((event.entityLiving instanceof EntityZombie)){
                 // zombie head
                zombieHead = new ItemStack(Items.skull, 1, 2);                          
                // zombie shirt/pants
//              ItemStack stackShirt = new ItemStack(Items.leather_chestplate, 1);
//              ((ItemArmor) stackShirt.getItem()).setColor(stackShirt, 2651799); //15790320);          
//              event.entityLiving.entityDropItem(stackShirt, 1);                          
//              ItemStack stack = new ItemStack(Items.leather_leggings, 1);
//              ((ItemArmor) stack.getItem()).setColor(stack, 8073150); //15790320);            
//              event.entityLiving.entityDropItem(stack, 1);               
                dropZombieStuff(event, zombieHead);
             } 
         }      
    }       
    
    private void dropZombieStuff(LivingDeathEvent event, ItemStack headToDrop){     
         event.entityLiving.dropItem(Items.bone,  getRandom(LogicalDrops.intZombieBonesMin,LogicalDrops.intZombieBonesMax));        
         if(LogicalDrops.boolZombieAlwaysDropHead && skullRandomDropSuccess()) event.entityLiving.entityDropItem(headToDrop, 0); // .dropItemWithOffset(Items.skull, 1, 2); //Items.skull, 1, 2); // .dropItem(Items.skull, size) Blocks.skull.getBlock.getBlockById() Items.skull., 1); //144
         enemyBowCheck(event.entityLiving);
    }
    
	private Boolean skullRandomDropSuccess(){
		Boolean willDrop = false;
		int percentChanceSkullDrops = (100-LogicalDrops.intHeadDropPercentChance); // 60  100-60
		willDrop = (getRandom(1,100) >= percentChanceSkullDrops);
		return willDrop;
	}    
    
    // PIG
    @SubscribeEvent
    public void playerKilledPig(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
        if((event.entityLiving instanceof EntityPig) && (isNotServerWorld))
        {
            event.entityLiving.dropItem(Items.porkchop, getRandom(LogicalDrops.intPigMeatMin,LogicalDrops.intPigMeatMax)); // pigs have TONS of mean IRL!                      
        }               
    }
    
    // WITCH
    @SubscribeEvent
    public void playerKilledWitch(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
        if((event.entityLiving instanceof EntityWitch) && (isNotServerWorld))
        {
            ItemStack purpleWool = new ItemStack(Blocks.wool, 1, 10); // purple wool                                                                
            event.entityLiving.entityDropItem(purpleWool, LogicalDrops.intWitchWoolCount);          
                                            
            ItemStack potionStack = new ItemStack(Items.potionitem, 1, 16341);
            event.entityLiving.entityDropItem(potionStack,1);
                        
            event.entityLiving.dropItem(Items.bone, getRandom(LogicalDrops.intWitchBonesMin,LogicalDrops.intWitchBonesMax)); // human, 8 bones
            
        }               
    }   
    
    
    // CREEPER
    @SubscribeEvent
    public void playerKilledCreeper(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
        if((event.entityLiving instanceof EntityCreeper) && (isNotServerWorld))
        {
            event.entityLiving.entityDropItem(new ItemStack(Blocks.tnt),1); // TNT!
            ItemStack greenWool = new ItemStack(Blocks.wool, 1, 5);                                                             
            event.entityLiving.entityDropItem(greenWool,getRandom(LogicalDrops.intCreeperWoolMin,LogicalDrops.intCreeperWoolMax));
            
            ItemStack creeperHead = new ItemStack(Items.skull, 1, 4);                                                               
            if(LogicalDrops.boolCreeperAlwaysDropHead && skullRandomDropSuccess()) event.entityLiving.entityDropItem(creeperHead,1);                           
        }               
    }

//  public RealisticPlayerWakeUpEvent(EntityPlayer player){
//  super(player);
////  this.wakeImmediatly = wakeImmediatly;
////  this.updateWorld = updateWorld;
////  this.setSpawn = setSpawn;
//  
//}     
    
//  public void playerKilledT(LivingDeathEvent event){
//      
//      event.getEntity().pla
//      
//  }
    
    // SKELETONS
    @SubscribeEvent
    public void playerKilledSkeleton(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);      
        if((event.entityLiving instanceof EntitySkeleton) && (isNotServerWorld))
        {
            EntitySkeleton skel = (EntitySkeleton) event.entityLiving;// Boolean isWitherSkeleton = event.entityLiving.getSke
            Boolean isWitherSkeleton = (skel.getSkeletonType() == 1);           
            // how to get bow if has one?
            if(isWitherSkeleton){
                // do stuff!
                ItemStack witherHead = new ItemStack(Items.skull, 1, 1);                                                
                if(LogicalDrops.boolSkeletonAlwaysDropHead && skullRandomDropSuccess()) event.entityLiving.entityDropItem(witherHead,1); // wither skull!
                event.entityLiving.dropItem(Items.coal,getRandom(LogicalDrops.intWitherCoalMin,LogicalDrops.intWitherCoalMax)); // 3 coal!
            }else{
                if(LogicalDrops.boolWitherSkeletonAlwaysDropHead && skullRandomDropSuccess()) event.entityLiving.dropItem(Items.skull, 1);
            }           
            event.entityLiving.dropItem(Items.bone, getRandom(LogicalDrops.intSkeletonBonesMin,LogicalDrops.intSkeletonBonesMax)); // skeletons? hello.. more than 2 bones please!?
            enemyBowCheck(event.entityLiving);            
        }               
        
        // add spider riding to drop saddle?
        ///summon Spider ~ ~ ~ {Passengers:[{id:Skeleton}]}
    }   
    
    
    // BLAZE
    @SubscribeEvent
    public void playerKilledBlaze(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
        if((event.entityLiving instanceof EntityBlaze) && (isNotServerWorld))
        {           
            ItemStack blazeRods = new ItemStack(Items.blaze_rod,getRandom(LogicalDrops.intBlazeRodMin,LogicalDrops.intBlazeRodMax));                                                                
            ItemStack blazeCharges = new ItemStack(Items.fire_charge, getRandom(LogicalDrops.intBlazeFireChargeMin,LogicalDrops.intBlazeFireChargeMax));            
            event.entityLiving.entityDropItem(blazeRods,1);            
            event.entityLiving.entityDropItem(blazeCharges,1);
        }               
    }
    
    // sadly this won't work in 1.7.10 ... no bows yet?    
	public void enemyBowCheck(EntityLivingBase enemy){
//        try{
//    		EntityMob mob = (EntityMob) enemy;
//    		Item mobWeapon = mob.getHeldItem().getItem();
//    		Boolean enemyHasBow = (mobWeapon instanceof ItemBow);		
//    		if(enemyHasBow) enemy.dropItem(Items.arrow, getRandom(LogicalDrops.intBowEnemiesArrowMin,LogicalDrops.intBowEnemiesArrowMax));
//        }
//        catch(StackOverflowError e){
//            // System.err.println("ouch!");
//        }        		
	}    
    
    // SPIDER
    @SubscribeEvent
    public void playerKilledSpider(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.entity.worldObj.isRemote);
        if((event.entityLiving instanceof EntitySpider) && (isNotServerWorld))
        {           
            //TODO: web not dropping            
            // ItemStack spiderWebs = new ItemStack(Blocks.web, 1);
            ItemBlock spiderWeb = (ItemBlock) ItemBlock.getItemFromBlock(Blocks.web);
            int numberOfWebs = getRandom(LogicalDrops.intSpiderWebMin,LogicalDrops.intSpiderWebMax);
            int numberOfString = getRandom(LogicalDrops.intSpiderStringMin,LogicalDrops.intSpiderStringMax);
            event.entityLiving.dropItem(spiderWeb,numberOfWebs);           
            event.entityLiving.dropItem(Items.string, numberOfString);
        }               
    }   

//    // RABBIT
//    @SubscribeEvent
//    public void playerKilledRabbit(LivingDeathEvent event)
//    {
//        Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
//        if((event.entityLiving instanceof EntityRabbit) && (isNotServerWorld))
//        {
//            if(etFuturumInstalled){
//                Item rabbitMeat = (Item)Item.itemRegistry.getObject("rabbit_raw");
//                event.entityLiving.dropItem(rabbitMeat, getRandom(LogicalDrops.intRabbitMeatMin,LogicalDrops.intRabbitMeatMax));
//                Item rabbitFoot= (Item)Item.itemRegistry.getObject("rabbit_foot");
//                event.entityLiving.dropItem(rabbitFoot, getRandom(LogicalDrops.intRabbitFootMin,LogicalDrops.intRabbitFootMax));
//                Item rabbitHide = (Item)Item.itemRegistry.getObject("rabbit_hide");
//                event.entityLiving.dropItem(rabbitHide, getRandom(LogicalDrops.intRabbitHideMin,LogicalDrops.intRabbitHideMax));                                                                              
//            }else{
//                event.entityLiving.dropItem(Items.beef, getRandom(LogicalDrops.intRabbitMeatMin,LogicalDrops.intRabbitMeatMax));
//            }                                               
//        }                   	                      
//    }   
               
    private int getRandom(int low, int high){
        Random rand = new Random(); 

        if(low == 0 && high == 0) return 0;
        if(high == 0) return 0;
        if(low > high) return 0;
        
        int randomNum = rand.nextInt((high - low) + 1) + low;
        // int randomNum = rand.nextInt((high - low) + low)-1;
        
        //DEBUG
      String chatMsg = "randomNum = (" + randomNum + ")";             
//      Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
      Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(chatMsg));
      

        
        return randomNum;       

    }
    
}
