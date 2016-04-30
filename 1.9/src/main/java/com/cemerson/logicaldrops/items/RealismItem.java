package com.cemerson.logicaldrops.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RealismItem extends Item {

	public String displayName;
	public Boolean foodUsesBowl = false;
	
	public RealismItem(String name){		
		super();
		displayName = name;
		//super(healAmount, potionEffectProbability, alwaysEdible);
//		displayName = name;
//		foodUsesBowl = usesBowl;
        // no break!
        // this.setBlockUnbreakable();
        
        // no explode either! 
        // this.setResistance(2000.0f);               
	}		
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		// TODO Auto-generated method stub		
		tooltip.add("\u00A7o\u00A78Mod: LogicalDrops!");
		stack.setStackDisplayName(displayName);
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

//	@Override
//	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
//		// TODO Auto-generated method stub
//		super.onFoodEaten(stack, worldIn, player);		
//		givePlayerEmptyBowl(player,stack);				
//	}
//	
//	private void givePlayerEmptyBowl(EntityPlayer player,ItemStack stack){		
//		// ItemStack emptyBowl = new ItemStack(Items.bowl);
//		if(foodUsesBowl){
//			player.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
//		}
		
//		String itemsLeftMsg = "There are "+itemsLeft+" items left in your hand!";
//		player.addChatComponentMessage(new TextComponentString(itemsLeftMsg));								
//		if(player.inventory.mainInventory.length <= 0){			
//			player.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
//		}
		// stack.setItem(Items.bowl);
		// stack.setItem(emptyBowl);
		// return emptyBowl;
// }
	
    

}
