package com.cemerson.logicaldrops.entity;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

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
		 // String chatMsg = "Did player kill a cow?!";        		
		// Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
		// event.entityLiving.dr
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntityCow) && (isNotServerWorld))
		{			
			event.entityLiving.dropItem(Items.bone, getRandom(10,16)); 
			event.entityLiving.dropItem(Items.beef, getRandom(12,16)); // 30 lbs steaks super minimum!
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
			event.entityLiving.dropItem(Items.ender_pearl, getRandom(1,3));
			ItemStack blackWool = new ItemStack(Blocks.wool, 2, 15); // black wool																
			event.entityLiving.entityDropItem(blackWool,1);			
			            
			ItemStack potionStack = new ItemStack(Items.potionitem, 1, 16310); //PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), potionType);
			event.entityLiving.entityDropItem(potionStack,1); 			
		}				
	}	
	
	@SubscribeEvent
	public void playerKilledChicken(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntityChicken) && (isNotServerWorld))
		{
			event.entityLiving.dropItem(Items.feather, getRandom(10,20)); // instead of 1!!?!
			event.entityLiving.dropItem(Items.chicken, getRandom(2,4));  // at least 3 meals per chicken
		}				
	}	
	
	@SubscribeEvent
	public void playerKilledSheep(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntitySheep) && (isNotServerWorld))
		{
			event.entityLiving.dropItem(Items.bone, 8);
			event.entityLiving.dropItem(Items.beef, getRandom(4,10)); // 40 lbs LOW average			
		}				
	}		
	
	@SubscribeEvent
	public void playerKilledZombie(LivingDeathEvent event)
	{					
		// if(event.entityLiving instanceof EntityCreeper) return;		
		
		// problem: firing two times!?
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		 if(isNotServerWorld){
			 ItemStack zombieHead;
			 if((event.entityLiving instanceof EntityPigZombie)){
				 // plain skull
				zombieHead = new ItemStack(Items.skull, 1);
				event.entityLiving.dropItem(Items.porkchop, getRandom(3,6));
				dropZombieStuff(event, zombieHead);
			 }else if((event.entityLiving instanceof EntityZombie)){
				 // zombie head
				zombieHead = new ItemStack(Items.skull, 1, 2);							
				// zombie shirt/pants
//				ItemStack stackShirt = new ItemStack(Items.leather_chestplate, 1);
//				((ItemArmor) stackShirt.getItem()).setColor(stackShirt, 2651799); //15790320);			
//				event.entityLiving.entityDropItem(stackShirt, 1);							
//				ItemStack stack = new ItemStack(Items.leather_leggings, 1);
//				((ItemArmor) stack.getItem()).setColor(stack, 8073150); //15790320);			
//				event.entityLiving.entityDropItem(stack, 1);				
				dropZombieStuff(event, zombieHead);
			 } 
		 }		
	}		
	
	private void dropZombieStuff(LivingDeathEvent event, ItemStack headToDrop){		
		 event.entityLiving.dropItem(Items.bone, 12); //. he's human! some bones please!?		 
		 event.entityLiving.entityDropItem(headToDrop, 0); // .dropItemWithOffset(Items.skull, 1, 2); //Items.skull, 1, 2); // .dropItem(Items.skull, size) Blocks.skull.getBlock.getBlockById() Items.skull., 1); //144
	}
	
	// PIG
	@SubscribeEvent
	public void playerKilledPig(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntityPig) && (isNotServerWorld))
		{
			event.entityLiving.dropItem(Items.porkchop, getRandom(10,15)); // pigs have TONS of mean IRL!						
		}				
	}
	
	// WITCH
	@SubscribeEvent
	public void playerKilledWitch(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntityWitch) && (isNotServerWorld))
		{
			ItemStack purpleWool = new ItemStack(Blocks.wool, 2, 10); // purple wool																
			event.entityLiving.entityDropItem(purpleWool,1);			
											
			ItemStack potionStack = new ItemStack(Items.potionitem, 1, 16341);
			event.entityLiving.entityDropItem(potionStack,1); 										
			event.entityLiving.dropItem(Items.bone, 8); // human, 8 bones
			
		}				
	}	
	
	// CREEPER
	@SubscribeEvent
	public void playerKilledCreeper(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntityCreeper) && (isNotServerWorld))
		{
			event.entityLiving.entityDropItem(new ItemStack(Blocks.tnt),1); // TNT!
			ItemStack greenWool = new ItemStack(Blocks.wool, 1, 5);																
			event.entityLiving.entityDropItem(greenWool,3);
			
			ItemStack creeperHead = new ItemStack(Items.skull, 1, 4);																
			event.entityLiving.entityDropItem(creeperHead,1);							
		}				
	}
	
	// SKELETONS
	@SubscribeEvent
	public void playerKilledSkeleton(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);		 
		if((event.entityLiving instanceof EntitySkeleton) && (isNotServerWorld))
		{
			EntitySkeleton skel = (EntitySkeleton) event.entityLiving;// Boolean isWitherSkeleton = event.entityLiving.getSke
			Boolean isWitherSkeleton = (skel.getSkeletonType() == 1);			
			// how to get bow if has one?
			if(isWitherSkeleton){
				// do stuff!
				ItemStack witherHead = new ItemStack(Items.skull, 1, 1); 												
				event.entityLiving.entityDropItem(witherHead,1); // wither skull!
				event.entityLiving.dropItem(Items.coal,getRandom(1,4)); // 3 coal!
			}else{
				event.entityLiving.dropItem(Items.skull, 1);
			}			
			event.entityLiving.dropItem(Items.bone, getRandom(10,20)); // skeletons? hello.. more than 2 bones please!?						
		}				
		
		// add spider riding to drop saddle?
		///summon Spider ~ ~ ~ {Passengers:[{id:Skeleton}]}
	}	
	
	
	// BLAZE
	@SubscribeEvent
	public void playerKilledBlaze(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntityBlaze) && (isNotServerWorld))
		{			
			ItemStack blazeRods = new ItemStack(Items.blaze_rod,3);																
			event.entityLiving.entityDropItem(blazeRods,1);					
			event.entityLiving.dropItem(Items.fire_charge, getRandom(1,3));
		}				
	}
	
	// SPIDER
	@SubscribeEvent
	public void playerKilledSpider(LivingDeathEvent event)
	{					
		 Boolean isNotServerWorld = (!event.entityLiving.worldObj.isRemote);
		if((event.entityLiving instanceof EntitySpider) && (isNotServerWorld))
		{			
			//TODO: web not dropping			
			// ItemStack spiderWebs = new ItemStack(Blocks.web, 1);
			ItemBlock spiderWeb = (ItemBlock) ItemBlock.getItemFromBlock(Blocks.web);
			int numberOfWebs = getRandom(1,3);
			int numberOfString = getRandom(2,4);
			event.entityLiving.dropItem(spiderWeb,numberOfWebs);			
			event.entityLiving.dropItem(Items.string, numberOfString);
		}				
	}	
	
	
	// blze
	// at least 2 rods
	private int getRandom(int low, int high){
		Random generator = new Random(); 
		int i = generator.nextInt(high) + low;
		return i;
	}
	
	
	
}
