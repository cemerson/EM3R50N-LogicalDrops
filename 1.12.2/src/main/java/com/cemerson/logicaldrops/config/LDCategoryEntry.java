//package com.cemerson.logicaldrops.config;
//
//import java.util.List;
//
//import net.minecraft.client.gui.GuiScreen;
//import net.minecraftforge.common.config.ConfigElement;
//import net.minecraftforge.common.config.Configuration;
//import net.minecraftforge.fml.client.config.GuiConfig;
//import net.minecraftforge.fml.client.config.GuiConfigEntries;
//import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
//import net.minecraftforge.fml.client.config.IConfigElement;
//
//public class LDCategoryEntry extends CategoryEntry {
//	
//	public String myCategory = ""; 
//	public String myTitle = "";
//
//	public LDCategoryEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
//		super(owningScreen, owningEntryList, configElement);				
//	}
//
//	@Override
//	protected GuiScreen buildChildScreen(){				
//		Configuration config = LDConfig.getConfig();
//		ConfigElement myCat = new ConfigElement(config.getCategory(myCategory));
//		List<IConfigElement> propertiesOnScreen = myCat.getChildElements();
//		String windowTitle = myTitle; 
//		return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,windowTitle);								
//	}	
//}
//
