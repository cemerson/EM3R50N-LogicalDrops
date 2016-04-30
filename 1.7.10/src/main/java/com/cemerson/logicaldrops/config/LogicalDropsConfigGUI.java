package com.cemerson.logicaldrops.config;

import java.util.ArrayList;
import java.util.List;

import com.cemerson.logicaldrops.LogicalDrops;
import com.cemerson.logicaldrops.Reference;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class LogicalDropsConfigGUI extends GuiConfig {
  public LogicalDropsConfigGUI(GuiScreen parent) {
	  
  	super(parent, 
  			new ConfigElement(
  					LogicalDrops.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
  			Reference.MOD_ID,
  			false,
  			false,
  			GuiConfig.getAbridgedConfigPath(LogicalDrops.configFile.toString())
  			);
	  
//	  	super(parent, 
//	  			getElements(),
//	  			Reference.MOD_ID,
//	  			false,
//	  			false,
//	  			GuiConfig.getAbridgedConfigPath(LogicalDrops.configFile.toString())
//	  			);	  
  	
  }
  
//    @SuppressWarnings({ "rawtypes" })
//	private static List<IConfigElement> getElements() {
//		String[] usedCategories = { Configuration.CATEGORY_GENERAL };
//		List<IConfigElement> list = new ArrayList<IConfigElement>();
//		for (String category : usedCategories)
//			list.add(new ConfigElement(LogicalDrops.configFile.getCategory(category)));
//		return list;
//	}  	
	  
  
  
}

