package com.cemerson.logicaldrops.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
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
	
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, ITooltipFlag advanced) {
		// TODO Auto-generated method stub		
		tooltip.add("\u00A7o\u00A78Mod: LogicalDrops!");
		stack.setStackDisplayName(displayName);
		super.addInformation(stack, playerIn.getEntityWorld(), tooltip, advanced);
	}
    

}
