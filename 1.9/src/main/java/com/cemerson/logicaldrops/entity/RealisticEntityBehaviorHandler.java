package com.cemerson.logicaldrops.entity;

import java.util.Random;

import com.cemerson.logicaldrops.LogicalDrops;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.TextComponentString;
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
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityCow) && (isNotServerWorld))
		{
			//String chatMsg = "LogicalDrops.intCowMeatMax=" + LogicalDrops.intCowMeatMax;        		
			//Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
				
			event.getEntityLiving().dropItem(Items.bone, getRandom(LogicalDrops.intCowBoneMin,LogicalDrops.intCowBoneMax)); 
			event.getEntityLiving().dropItem(Items.beef, getRandom(LogicalDrops.intCowMeatMin,LogicalDrops.intCowMeatMax)); // 30 lbs steaks super minimum!
		}				
	}
	
	@SubscribeEvent
	public void playerKilledEnderman(LivingDeathEvent event)
	{					
		 // String chatMsg = "Did player kill a cow?!";        		
		// Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityEnderman) && (isNotServerWorld))
		{			
			event.getEntityLiving().dropItem(Items.ender_pearl, getRandom(LogicalDrops.intEndermanPearlMin,LogicalDrops.intEndermanPearlMax));
			ItemStack blackWool = new ItemStack(Blocks.wool, 1, 15); // black wool																
			event.getEntityLiving().entityDropItem(blackWool,LogicalDrops.intEndermanWoolCount);
			PotionType potionType = PotionTypes.night_vision;
			ItemStack potionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), potionType);
			event.getEntityLiving().entityDropItem(potionStack,1);			
		}				
	}	
	
	@SubscribeEvent
	public void playerKilledChicken(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityChicken) && (isNotServerWorld))
		{
			event.getEntityLiving().dropItem(Items.feather, getRandom(LogicalDrops.intChickenFeatherMin,LogicalDrops.intChickenFeatherMax));
			event.getEntityLiving().dropItem(Items.chicken, getRandom(LogicalDrops.intChickenMeatMin,LogicalDrops.intChickenMeatMax));
		}				
	}	
	
	@SubscribeEvent
	public void playerKilledSheep(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntitySheep) && (isNotServerWorld))
		{
			event.getEntityLiving().dropItem(Items.bone, getRandom(LogicalDrops.intSheepBoneMin,LogicalDrops.intSheepBoneMax));
			event.getEntityLiving().dropItem(Items.mutton, getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax)); // 40 lbs LOW average			
		}				
	}		
	
	@SubscribeEvent
	public void playerKilledZombie(LivingDeathEvent event)
	{					
		// if(event.getEntityLiving() instanceof EntityCreeper) return;		
		
		// problem: firing two times!?
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		 if(isNotServerWorld){
			 ItemStack zombieHead;
			 if((event.getEntityLiving() instanceof EntityPigZombie)){
				 // plain skull
				zombieHead = new ItemStack(Items.skull, 1);
				event.getEntityLiving().dropItem(Items.porkchop, getRandom(LogicalDrops.intPigZombiePorkchopMin,LogicalDrops.intPigZombiePorkchopMax));
				dropZombieStuff(event, zombieHead);
			 }else if((event.getEntityLiving() instanceof EntityZombie)){
				 // zombie head
				zombieHead = new ItemStack(Items.skull, 1, 2);							
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
		 event.getEntityLiving().dropItem(Items.bone,  getRandom(LogicalDrops.intZombieBonesMin,LogicalDrops.intZombieBonesMax));		 
		 if(LogicalDrops.boolZombieAlwaysDropHead) event.getEntityLiving().entityDropItem(headToDrop, 0); // .dropItemWithOffset(Items.skull, 1, 2); //Items.skull, 1, 2); // .dropItem(Items.skull, size) Blocks.skull.getBlock.getBlockById() Items.skull., 1); //144
	}
	
	// PIG
	@SubscribeEvent
	public void playerKilledPig(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityPig) && (isNotServerWorld))
		{
			event.getEntityLiving().dropItem(Items.porkchop, getRandom(LogicalDrops.intPigMeatMin,LogicalDrops.intPigMeatMax)); // pigs have TONS of mean IRL!						
		}				
	}
	
	// WITCH
	@SubscribeEvent
	public void playerKilledWitch(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityWitch) && (isNotServerWorld))
		{
			ItemStack purpleWool = new ItemStack(Blocks.wool, 1, 10); // purple wool																
			event.getEntityLiving().entityDropItem(purpleWool, LogicalDrops.intWitchWoolCount);			
					
			PotionType witchPotionType = PotionTypes.healing;
			ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), witchPotionType);
			event.getEntityLiving().entityDropItem(healPotionStack,1);
			
//			ItemBook boo
//			Enchantment ench = new Enchantment();
//			
//			EnchantedBook bookType = PotionTypes.healing;
//			ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), witchPotionType);
//			event.getEntityLiving().entityDropItem(healPotionStack,1);			
		
			event.getEntityLiving().dropItem(Items.bone, getRandom(LogicalDrops.intWitchBonesMin,LogicalDrops.intWitchBonesMax)); // human, 8 bones
			
		}				
	}	
	
	// CREEPER
	@SubscribeEvent
	public void playerKilledCreeper(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityCreeper) && (isNotServerWorld))
		{
			event.getEntityLiving().entityDropItem(new ItemStack(Blocks.tnt),1); // TNT!
			ItemStack greenWool = new ItemStack(Blocks.wool, 1, 5);																
			event.getEntityLiving().entityDropItem(greenWool,getRandom(LogicalDrops.intCreeperWoolMin,LogicalDrops.intCreeperWoolMax));
			
			ItemStack creeperHead = new ItemStack(Items.skull, 1, 4);																
			if(LogicalDrops.boolCreeperAlwaysDropHead) event.getEntityLiving().entityDropItem(creeperHead,1);							
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
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);		 
		if((event.getEntityLiving() instanceof EntitySkeleton) && (isNotServerWorld))
		{
			EntitySkeleton skel = (EntitySkeleton) event.getEntityLiving();// Boolean isWitherSkeleton = event.getEntityLiving().getSke
			Boolean isWitherSkeleton = (skel.getSkeletonType() == 1);			
			// how to get bow if has one?
			if(isWitherSkeleton){
				// do stuff!
				ItemStack witherHead = new ItemStack(Items.skull, 1, 1); 												
				if(LogicalDrops.boolSkeletonAlwaysDropHead) event.getEntityLiving().entityDropItem(witherHead,1); // wither skull!
				event.getEntityLiving().dropItem(Items.coal,getRandom(LogicalDrops.intWitherCoalMin,LogicalDrops.intWitherCoalMax)); // 3 coal!
			}else{
				if(LogicalDrops.boolWitherSkeletonAlwaysDropHead) event.getEntityLiving().dropItem(Items.skull, 1);
			}			
			event.getEntityLiving().dropItem(Items.bone, getRandom(LogicalDrops.intSkeletonBonesMin,LogicalDrops.intSkeletonBonesMax)); // skeletons? hello.. more than 2 bones please!?						
		}				
		
		// add spider riding to drop saddle?
		///summon Spider ~ ~ ~ {Passengers:[{id:Skeleton}]}
	}	
	
	
	// BLAZE
	@SubscribeEvent
	public void playerKilledBlaze(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityBlaze) && (isNotServerWorld))
		{			
			ItemStack blazeRods = new ItemStack(Items.blaze_rod,getRandom(LogicalDrops.intBlazeRodMin,LogicalDrops.intBlazeRodMax));																
			ItemStack blazeCharges = new ItemStack(Items.fire_charge, getRandom(LogicalDrops.intBlazeFireChargeMin,LogicalDrops.intBlazeFireChargeMax));			
			event.getEntityLiving().entityDropItem(blazeRods,1);			
			event.getEntityLiving().entityDropItem(blazeCharges,1);
		}				
	}
	
	// SPIDER
	@SubscribeEvent
	public void playerKilledSpider(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntitySpider) && (isNotServerWorld))
		{			
			//TODO: web not dropping			
			// ItemStack spiderWebs = new ItemStack(Blocks.web, 1);
			ItemBlock spiderWeb = (ItemBlock) ItemBlock.getItemFromBlock(Blocks.web);
			int numberOfWebs = getRandom(LogicalDrops.intSpiderWebMin,LogicalDrops.intSpiderWebMax);
			int numberOfString = getRandom(LogicalDrops.intSpiderStringMin,LogicalDrops.intSpiderStringMax);
			event.getEntityLiving().dropItem(spiderWeb,numberOfWebs);			
			event.getEntityLiving().dropItem(Items.string, numberOfString);
		}				
	}	

	// SPIDER
	@SubscribeEvent
	public void playerKilledRabbit(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.getEntity().worldObj.isRemote);
		if((event.getEntityLiving() instanceof EntityRabbit) && (isNotServerWorld))
		{						
			event.getEntityLiving().dropItem(Items.rabbit_foot, getRandom(LogicalDrops.intRabbitFootMin,LogicalDrops.intRabbitFootMax));
			event.getEntityLiving().dropItem(Items.rabbit_hide, getRandom(LogicalDrops.intRabbitHideMin,LogicalDrops.intRabbitHideMax));
			event.getEntityLiving().dropItem(Items.rabbit, getRandom(LogicalDrops.intRabbitMeatMin,LogicalDrops.intRabbitMeatMax));
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
