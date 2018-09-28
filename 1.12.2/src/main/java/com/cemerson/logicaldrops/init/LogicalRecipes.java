package com.cemerson.logicaldrops.init;

import com.cemerson.logicaldrops.Reference;
import com.cemerson.logicaldrops.util.CraftingHelper;

import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.event.RegistryEvent;

public class LogicalRecipes{
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event){
						
	    // 3 string from wool
	    CraftingHelper.addShapeless(event, new ItemStack(Items.STRING,3), 
				new Object[]{
						Blocks.field_150325_L});
				
		// DYE RECIPES
	    ItemStack orangeDye = new ItemStack(Items.field_151100_aR,1,14);
	    ItemStack greenDye = new ItemStack(Items.field_151100_aR,1,2);		
	    ItemStack blackDye = new ItemStack(Items.field_151100_aR,1,0);	    
	    ItemStack grayLightDye  = new ItemStack(Items.field_151100_aR,1,7);
	    ItemStack grayDye = new ItemStack(Items.field_151100_aR,1,8);	     	   
	    ItemStack pinkDye = new ItemStack(Items.field_151100_aR,1,9);
	    ItemStack redDye = new ItemStack(Items.field_151100_aR,1,1);
	    ItemStack limeDye =  new ItemStack(Items.field_151100_aR,1,10);
	    ItemStack brownDye =  new ItemStack(Items.field_151100_aR,1,3);
	    ItemStack blueDye =  new ItemStack(Items.field_151100_aR,1,4);
	    ItemStack blueLightDye =  new ItemStack(Items.field_151100_aR,1,12);
	    ItemStack charcoal = new ItemStack(Items.COAL,1,1);
	    ItemStack yellowDye =  new ItemStack(Items.field_151100_aR,1,11);
	    ItemStack purpleDye =  new ItemStack(Items.field_151100_aR,1,5);
	    ItemStack cyanDye =  new ItemStack(Items.field_151100_aR,1,6);
	    ItemStack purpleLightDye =  new ItemStack(Items.field_151100_aR,1,13);
	    ItemStack boneMeal =  new ItemStack(Items.field_151100_aR,1,15);
	    		
	    // Black Dye from coal/charcoal
	    CraftingHelper.addShapeless(event, blackDye,new Object[]{Items.COAL});  
	    CraftingHelper.addShapeless(event, blackDye,new Object[]{charcoal});	    
	    	    
	    // green dye from lilypad 
	    CraftingHelper.addShapeless(event, greenDye,new Object[]{Blocks.field_150392_bi});
	    
	    // DYE COLOR MIXING!
	    // blue
	    CraftingHelper.addShapeless(event, blueDye,new Object[]{blackDye,blueLightDye});
	    // pink
	    CraftingHelper.addShapeless(event, pinkDye,new Object[]{redDye,boneMeal});
	    CraftingHelper.addShapeless(event, pinkDye,new Object[]{boneMeal,purpleLightDye});	    
	    // cyan/teal
	    CraftingHelper.addShapeless(event, cyanDye,new Object[]{blueDye,limeDye});
	    // light purple
	    CraftingHelper.addShapeless(event, purpleLightDye,new Object[]{purpleDye,boneMeal});
	    CraftingHelper.addShapeless(event, purpleLightDye,new Object[]{pinkDye,blueLightDye});
	    CraftingHelper.addShapeless(event, purpleLightDye,new Object[]{redDye,blueLightDye});
	    CraftingHelper.addShapeless(event, purpleLightDye,new Object[]{pinkDye,blueLightDye});
	    //green
	    CraftingHelper.addShapeless(event, greenDye,new Object[]{yellowDye,blueDye});
	    // gray
	    CraftingHelper.addShapeless(event, grayDye,new Object[]{blackDye,boneMeal});
	    CraftingHelper.addShapeless(event, grayDye,new Object[]{blackDye,grayLightDye});
	    // light gray
	    CraftingHelper.addShapeless(event, grayLightDye,new Object[]{blackDye,boneMeal,boneMeal});
	    CraftingHelper.addShapeless(event, grayLightDye,new Object[]{grayLightDye,boneMeal});
	    // brown
	    CraftingHelper.addShapeless(event, brownDye,new Object[]{orangeDye,blackDye});
	    // green
	    CraftingHelper.addShapeless(event, greenDye,new Object[]{blackDye,limeDye});	   
	    // blue light
	    CraftingHelper.addShapeless(event, blueLightDye,new Object[]{boneMeal,blueDye});	    
	    // purple
	    CraftingHelper.addShapeless(event, purpleDye,new Object[]{purpleLightDye,blackDye});
	    CraftingHelper.addShapeless(event, purpleDye,new Object[]{pinkDye,blueDye});
	    // lime dye
	    CraftingHelper.addShapeless(event, limeDye,new Object[]{greenDye,boneMeal});
	    CraftingHelper.addShapeless(event, limeDye,new Object[]{blueLightDye,yellowDye});
	    // orange
	    CraftingHelper.addShapeless(event, orangeDye,new Object[]{redDye,yellowDye});
	    // brown
	    
	    
	    // recipe to make saddle 
	    CraftingHelper.addShapeless(event, new ItemStack(Items.SADDLE), 
				new Object[]{
						Items.LEATHER,Items.LEATHER,Items.LEATHER,Items.LEATHER,
						Items.IRON_INGOT,Items.IRON_INGOT,
						Items.STRING,Items.STRING,Items.STRING});
	    
	    
	}
	
}
