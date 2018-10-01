//package com.cemerson.logicaldrops.container;
//
//import jline.internal.Log;
//import net.minecraft.entity.player.InventoryPlayer;
//import net.minecraft.inventory.ContainerFurnace;
//import net.minecraft.inventory.IInventory;
//import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//public class ContainerFurnaceLD extends ContainerFurnace {
//
//	public ContainerFurnaceLD(InventoryPlayer playerInventory, IInventory furnaceInventory) {
//		super(playerInventory, furnaceInventory);
//		Log.info("Hi im custom furnace!");
//		// TODO Auto-generated constructor stub
//	}
//	
//    
//    @SubscribeEvent
//    public void FurnanceTest(PlayerSleepInBedEvent event){
//    	
//    	Log.info("*** Furnace noticed that player slept in bed! ***");
//    	        	
//    }	
//
//}
