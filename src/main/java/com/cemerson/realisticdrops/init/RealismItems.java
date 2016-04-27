package com.cemerson.realisticdrops.init;

import com.cemerson.realisticdrops.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class RealismItems {
	
	//public static RealismItem item_bone_cow;
		
	public static void init(){			
//				
//		// item_food_eggs_mushroom_omelette = (RealismItem) new RealismItem(20,1.0F,false,"Mushroom & Cheese Omelette",false).setUnlocalizedName("item_food_eggs_mushroom_omelette").setRegistryName("item_food_eggs_mushroom_omelette").setMaxStackSize(8);
//		item_bone_cow = (RealismItem) new RealismItem("Cow Bone")
//							.setRegistryName("item_bone_cow")
//							.setUnlocalizedName("item_bone_cow")
//							.setMaxStackSize(64);									
	}
	
	public static void register(){
	
		//GameRegistry.register(item_bone_cow);
	
//		EntityRegistry.registerModEntity(RealismCow.class, "Realism Cow", 1, Reference.MOD_ID, 128, 1, false);
//		// EntityRegistry.registerModEntity(RealismCow.class, "Realism Cow", 1, null, 128, 1, false, 0, 0);
//						        		
//        MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());		
		
		// GameRegistry.register(item_food_eggs_sandwich_fried);
			
//		GameRegistry.addShapelessRecipe(new ItemStack(item_food_eggs_and_beef), 
//				new Object[]{
//						Items.egg,Items.egg,Items.egg,						
//						Items.beef,
//						Items.bowl});		
				

// 			GameRegistry.addSmelting(item_food_bread, new ItemStack(item_food_toast), 2.0F);
	}
	
	public static void registerRenders(){
				
		//registerRender(item_bone_cow);
	}
	
	public static void registerRender(Item item){
						
		Minecraft.getMinecraft()
		.getRenderItem()
		.getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(
				Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),
				"inventory"));		
				
	}
	

}
