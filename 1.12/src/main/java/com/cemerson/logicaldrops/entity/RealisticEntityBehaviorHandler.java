package com.cemerson.logicaldrops.entity;

import java.util.Random;

import com.cemerson.logicaldrops.LogicalDrops;

import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.EnumCreatureType;
//import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
//import net.minecraft.world.chunk.Chunk.EnumCreateEntityType;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


// http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2389704-realistic-animal-products-and-drops-mod-updates
// Realistic Survival Mod! : https://www.youtube.com/watch?v=hQ9Ii9AZg78

// helpful!
// http://www.minecraftupdates.com/summon-command
// https://www.digminecraft.com/generators/summon_mob.php

public class RealisticEntityBehaviorHandler {
	
	// public static RealismItem item_bone_cow;
		    	
	@SubscribeEvent
	public void playerKilledCow(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityCow) && (isNotServerWorld))
		{
			//String chatMsg = "LogicalDrops.intCowMeatMax=" + LogicalDrops.intCowMeatMax;        		
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
				
			if(LogicalDrops.intCowBoneMax > 0) event.getEntityLiving().dropItem(Items.BONE, getRandom(LogicalDrops.intCowBoneMin,LogicalDrops.intCowBoneMax)); 
			if(LogicalDrops.intCowMeatMax > 0) event.getEntityLiving().dropItem(Items.BEEF, getRandom(LogicalDrops.intCowMeatMin,LogicalDrops.intCowMeatMax)); // 30 lbs steaks super minimum!			
			/* leather! duh!!*/
			if(LogicalDrops.intCowLeatherMax > 0) event.getEntityLiving().dropItem(Items.LEATHER, getRandom(LogicalDrops.intCowLeatherMin,LogicalDrops.intCowLeatherMax)); 
		
		}				
	}
	
	@SubscribeEvent
	public void playerKilledEnderman(LivingDeathEvent event)
	{					
		 // String chatMsg = "Did player kill a cow?!";        		
		// Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityEnderman) && (isNotServerWorld))
		{			
			if(LogicalDrops.intEndermanPearlMax > 0) event.getEntityLiving().dropItem(Items.ENDER_PEARL, getRandom(LogicalDrops.intEndermanPearlMin,LogicalDrops.intEndermanPearlMax));
			ItemStack blackWool = new ItemStack(Blocks.WOOL, 1, 15); // black wool																
			event.getEntityLiving().entityDropItem(blackWool,LogicalDrops.intEndermanWoolCount);
			PotionType potionType = PotionTypes.NIGHT_VISION;
			ItemStack potionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), potionType);
			event.getEntityLiving().entityDropItem(potionStack,1);			
		}				
	}	
	
	@SubscribeEvent
	public void playerKilledChicken(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityChicken) && (isNotServerWorld))
		{
			if(LogicalDrops.intChickenFeatherMax > 0) event.getEntityLiving().dropItem(Items.FEATHER, getRandom(LogicalDrops.intChickenFeatherMin,LogicalDrops.intChickenFeatherMax));
			if(LogicalDrops.intChickenMeatMax > 0) event.getEntityLiving().dropItem(Items.CHICKEN, getRandom(LogicalDrops.intChickenMeatMin,LogicalDrops.intChickenMeatMax));
		}				
	}	
	
	@SubscribeEvent
	public void playerKilledSheep(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntitySheep) && (isNotServerWorld))
		{
			if(LogicalDrops.intSheepBoneMax > 0) event.getEntityLiving().dropItem(Items.BONE, getRandom(LogicalDrops.intSheepBoneMin,LogicalDrops.intSheepBoneMax));
			if(LogicalDrops.intSheepMeatMax > 0) event.getEntityLiving().dropItem(Items.MUTTON, getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax)); // 40 lbs LOW average			
		}				
	}		
	
	@SubscribeEvent
	public void playerKilledZombie(LivingDeathEvent event)
	{					
		// if(event.getEntityLiving() instanceof EntityCreeper) return;		
		
		// problem: firing two times!?
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		 if(isNotServerWorld){
			 ItemStack zombieHead;
			 if((event.getEntityLiving() instanceof EntityPigZombie)){
				 // plain skull
				zombieHead = new ItemStack(Items.SKULL, 1);
				if(LogicalDrops.intPigZombiePorkchopMax > 0) event.getEntityLiving().dropItem(Items.PORKCHOP, getRandom(LogicalDrops.intPigZombiePorkchopMin,LogicalDrops.intPigZombiePorkchopMax));
				dropZombieStuff(event, zombieHead);
			 }else if((event.getEntityLiving() instanceof EntityZombie)){
				 // zombie head
				zombieHead = new ItemStack(Items.SKULL, 1, 2);							
				// zombie shirt/pants
//				ItemStack stackShirt = new ItemStack(Items.leather_chestplate, 1);
//				((ItemArmor) stackShirt.getItem()).setColor(stackShirt, 2651799); //15790320);			
//				event.getEntityLiving().entityDropItem(stackShirt, 1);							
//				ItemStack stack = new ItemStack(Items.leather_leggings, 1);
//				((ItemArmor) stack.getItem()).setColor(stack, 8073150); //15790320);			
//				event.getEntityLiving().entityDropItem(stack, 1);				
				dropZombieStuff(event, zombieHead);
			 } 
		 }		
	}		
	
	private void dropZombieStuff(LivingDeathEvent event, ItemStack headToDrop){		
		 if(LogicalDrops.intZombieBonesMax > 0) event.getEntityLiving().dropItem(Items.BONE,  getRandom(LogicalDrops.intZombieBonesMin,LogicalDrops.intZombieBonesMax));		 
		 if(LogicalDrops.boolZombieAlwaysDropHead && skullRandomDropSuccess()){
			 event.getEntityLiving().entityDropItem(headToDrop, 0); // .dropItemWithOffset(Items.skull, 1, 2); //Items.skull, 1, 2); // .dropItem(Items.skull, size) Blocks.skull.getBlock.getBlockById() Items.skull., 1); //144
		 }
		 enemyBowCheck(event.getEntityLiving());
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
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityPig) && (isNotServerWorld))
		{
			if(LogicalDrops.intPigMeatMax > 0) event.getEntityLiving().dropItem(Items.PORKCHOP, getRandom(LogicalDrops.intPigMeatMin,LogicalDrops.intPigMeatMax)); // pigs have TONS of mean IRL!						
		}				
	}
	
	// WITCH
	@SubscribeEvent
	public void playerKilledWitch(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityWitch) && (isNotServerWorld))
		{
			ItemStack purpleWool = new ItemStack(Blocks.WOOL, 1, 10); // purple wool																
			event.getEntityLiving().entityDropItem(purpleWool, LogicalDrops.intWitchWoolCount);			
					
			PotionType witchPotionType = PotionTypes.HEALING;
			ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), witchPotionType);
			event.getEntityLiving().entityDropItem(healPotionStack,1);
			
//			ItemBook boo
//			Enchantment ench = new Enchantment();
//			
//			EnchantedBook bookType = PotionTypes.healing;
//			ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), witchPotionType);
//			event.getEntityLiving().entityDropItem(healPotionStack,1);			
		
			if(LogicalDrops.intWitchBonesMax > 0) event.getEntityLiving().dropItem(Items.BONE, getRandom(LogicalDrops.intWitchBonesMin,LogicalDrops.intWitchBonesMax)); // human, 8 bones
			
		}				
	}	
	
	// CREEPER
	@SubscribeEvent
	public void playerKilledCreeper(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityCreeper) && (isNotServerWorld))
		{
			event.getEntityLiving().entityDropItem(new ItemStack(Blocks.TNT),1); // TNT!
			ItemStack greenWool = new ItemStack(Blocks.WOOL, 1, 5);																
			if(LogicalDrops.intCreeperWoolMax > 0) event.getEntityLiving().entityDropItem(greenWool,getRandom(LogicalDrops.intCreeperWoolMin,LogicalDrops.intCreeperWoolMax));
			
			ItemStack creeperHead = new ItemStack(Items.SKULL, 1, 4);																
			if(LogicalDrops.boolCreeperAlwaysDropHead && skullRandomDropSuccess()) event.getEntityLiving().entityDropItem(creeperHead,1);
			
			ItemStack leaves = new ItemStack(Blocks.LEAVES, 1, 0);
			if(LogicalDrops.intCreeperLeavesMax > 0) event.getEntityLiving().entityDropItem(leaves ,getRandom(LogicalDrops.intCreeperLeavesMin,LogicalDrops.intCreeperLeavesMax));			
		}				
	}

//  public RealisticPlayerWakeUpEvent(EntityPlayer player){
//  super(player);
////  this.wakeImmediatly = wakeImmediatly;
////  this.updateWorld = updateWorld;
////  this.setSpawn = setSpawn;
//  
//}		
	
//	public void playerKilledT(LivingDeathEvent event){
//		
//		event.getEntity().pla
//		
//	}
	
	// SKELETONS
	@SubscribeEvent
	public void playerKilledSkeleton(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);		 
		if((event.getEntityLiving() instanceof EntitySkeleton) && (isNotServerWorld))
		{			
			if(LogicalDrops.boolWitherSkeletonAlwaysDropHead && skullRandomDropSuccess()) event.getEntityLiving().dropItem(Items.SKULL, 1);						
			if(LogicalDrops.intSkeletonBonesMax > 0) event.getEntityLiving().dropItem(Items.BONE, getRandom(LogicalDrops.intSkeletonBonesMin,LogicalDrops.intSkeletonBonesMax)); // skeletons? hello.. more than 2 bones please!?
			
			enemyBowCheck(event.getEntityLiving()); 											
		}				
		
		// add spider riding to drop saddle?
		///summon Spider ~ ~ ~ {Passengers:[{id:Skeleton}]}
	}	
	
	// WITHER SKELETONS
	@SubscribeEvent
	public void playerKilledWitherSkeleton(LivingDeathEvent event)
	{					
		Boolean isNotServerWorld = (!event.getEntity().world.isRemote);		 
		if((event.getEntityLiving() instanceof EntityWitherSkeleton) && (isNotServerWorld))
		{		
			ItemStack witherHead = new ItemStack(Items.SKULL, 1, 1); 												
			if(LogicalDrops.boolSkeletonAlwaysDropHead && skullRandomDropSuccess()) event.getEntityLiving().entityDropItem(witherHead,1); // wither skull!
			if(LogicalDrops.intWitherCoalMax > 0) event.getEntityLiving().dropItem(Items.COAL,getRandom(LogicalDrops.intWitherCoalMin,LogicalDrops.intWitherCoalMax)); // 3 coal!
			if(LogicalDrops.intSkeletonBonesMax > 0) event.getEntityLiving().dropItem(Items.BONE, getRandom(LogicalDrops.intSkeletonBonesMin,LogicalDrops.intSkeletonBonesMax)); // skeletons? hello.. more than 2 bones please!?
			
			enemyBowCheck(event.getEntityLiving()); 											
		}						
	}		
	
	public void enemyBowCheck(EntityLivingBase enemy){
        try{
    		EntityMob mob = (EntityMob) enemy;
    		mob.getActiveHand();
			Item mobWeapon = mob.getHeldItem(EnumHand.MAIN_HAND).getItem();
    		Boolean enemyHasBow = (mobWeapon instanceof ItemBow);		
    		if(LogicalDrops.intBowEnemiesArrowMax > 0) if(enemyHasBow) enemy.dropItem(Items.ARROW, getRandom(LogicalDrops.intBowEnemiesArrowMin,LogicalDrops.intBowEnemiesArrowMax));
        } catch (Exception e) {        
            // System.err.println("ouch!");
        }        		
	}
	
	
	// BLAZE
	@SubscribeEvent
	public void playerKilledBlaze(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityBlaze) && (isNotServerWorld))
		{			
																			
			if(LogicalDrops.intBlazeFireChargeMax > 0){
				ItemStack blazeCharges = new ItemStack(Items.FIRE_CHARGE, getRandom(LogicalDrops.intBlazeFireChargeMin,LogicalDrops.intBlazeFireChargeMax));
				event.getEntityLiving().entityDropItem(blazeCharges,1);
				
			}
			if(LogicalDrops.intBlazeRodMax > 0){
				ItemStack blazeRods = new ItemStack(Items.BLAZE_ROD,getRandom(LogicalDrops.intBlazeRodMin,LogicalDrops.intBlazeRodMax));
				event.getEntityLiving().entityDropItem(blazeRods,1);
			}
			
		}				
	}
	
	// SPIDER
	@SubscribeEvent
	public void playerKilledSpider(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntitySpider) && (isNotServerWorld))
		{			
			//TODO: web not dropping			
			// ItemStack spiderWebs = new ItemStack(Blocks.web, 1);
			ItemBlock spiderWeb = (ItemBlock) ItemBlock.getItemFromBlock(Blocks.WEB);
			int numberOfWebs = getRandom(LogicalDrops.intSpiderWebMin,LogicalDrops.intSpiderWebMax);
			int numberOfString = getRandom(LogicalDrops.intSpiderStringMin,LogicalDrops.intSpiderStringMax);
			event.getEntityLiving().dropItem(spiderWeb,numberOfWebs);			
			event.getEntityLiving().dropItem(Items.STRING, numberOfString);
		}				
	}	

	// SPIDER
	@SubscribeEvent
	public void playerKilledRabbit(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
		if((event.getEntityLiving() instanceof EntityRabbit) && (isNotServerWorld))
		{						
			if(LogicalDrops.intRabbitFootMax > 0) event.getEntityLiving().dropItem(Items.RABBIT_FOOT, getRandom(LogicalDrops.intRabbitFootMin,LogicalDrops.intRabbitFootMax));
			if(LogicalDrops.intRabbitHideMax > 0) event.getEntityLiving().dropItem(Items.RABBIT_HIDE, getRandom(LogicalDrops.intRabbitHideMin,LogicalDrops.intRabbitHideMax));
			if(LogicalDrops.intRabbitMeatMax > 0) event.getEntityLiving().dropItem(Items.RABBIT, getRandom(LogicalDrops.intRabbitMeatMin,LogicalDrops.intRabbitMeatMax));
		}				
	}	
		
	private int getRandom(int low, int high){
	    Random rand = new Random(); 

	    if(low == 0 && high == 0) return 0;
	    if(high == 0) return 0;
	    if(low > high) return 0;
	    
	    int randomNum = rand.nextInt((high - low) + 1) + low;
	    // int randomNum = rand.nextInt((high - low) + low)-1;
	    
	    //DEBUG
//		String chatMsg = "randomNum = (" + randomNum + ")";        		
//		Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));	    
	    
	    return randomNum;	    

	}
	
}
