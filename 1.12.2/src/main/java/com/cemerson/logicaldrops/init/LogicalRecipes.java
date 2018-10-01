//package com.cemerson.logicaldrops.init;
//
//import com.cemerson.logicaldrops.Reference;
//import com.cemerson.logicaldrops.util.CraftingHelper;
//
//import net.minecraft.block.BlockFlower.EnumFlowerType;
//import net.minecraft.block.material.Material;
//import net.minecraft.entity.passive.EntityWolf;
//import net.minecraft.init.Blocks;
//import net.minecraft.init.Items;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.crafting.IRecipe;
//import net.minecraft.nbt.NBTBase;
//import net.minecraft.nbt.NBTTagString;
//import net.minecraftforge.event.RegistryEvent;
//
//public class LogicalRecipes{
//	public static void registerRecipes(RegistryEvent.Register<IRecipe> event){
//						
//	    // 3 string from wool
//	    CraftingHelper.addShapeless(event, new ItemStack(Items.STRING,3), 
//				new Object[]{
//						Blocks.WOOL});
//				
//	    ItemStack greenDye = new ItemStack(Items.DYE,1,2);		
//	    	greenDye.setCount(1);
//	    // Black Dye from coal/charcoal
//	    ItemStack blackDye = new ItemStack(Items.DYE,1,0);	    
//    	blackDye.setCount(1);	    
//	    ItemStack charcoal = new ItemStack(Items.COAL,1,1);
//    	charcoal.setCount(1);	     	
//	    CraftingHelper.addShapeless(event, blackDye,new Object[]{Items.COAL});  
//	    CraftingHelper.addShapeless(event, blackDye,new Object[]{charcoal});	    
//	    	     
//	    // green dye from lilypad 
//	    CraftingHelper.addShapeless(1,event, greenDye,new Object[]{Blocks.WATERLILY});
//	    	    
//	    // recipe to make saddle 
//	    CraftingHelper.addShapeless(event, new ItemStack(Items.SADDLE), 
//				new Object[]{
//						Items.LEATHER,Items.LEATHER,Items.LEATHER,Items.LEATHER,Items.LEATHER,
//						Blocks.GOLD_BLOCK,
//						Items.IRON_INGOT,Items.IRON_INGOT,
//						Items.STRING});	    
//	    
// 
//	    
//	}
//	
//}
