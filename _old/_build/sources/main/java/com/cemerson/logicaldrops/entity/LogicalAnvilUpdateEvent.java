//package com.cemerson.logicaldrops.entity;
//
//import jline.internal.Log;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.event.AnvilUpdateEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//public class LogicalAnvilUpdateEvent extends AnvilUpdateEvent {
//
//	public LogicalAnvilUpdateEvent(ItemStack left, ItemStack right, String name, int cost) {
//		super(left, right, name, 0);
//		
//		
//		// TODO Auto-generated constructor stub
//	}
//	
//	@SubscribeEvent
//	public void LogicalAnvilUpdate(AnvilUpdateEvent event){
//		Log.info("logical drops overriding anvil cost!..");
//		event.setCost(0);	
//	
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//}
//
//
