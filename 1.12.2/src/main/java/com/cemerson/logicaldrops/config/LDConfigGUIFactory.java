package com.cemerson.logicaldrops.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cemerson.logicaldrops.Reference;

import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

public class LDConfigGUIFactory implements IModGuiFactory{

	@Override
	public void initialize(Minecraft minecraftInstance) {
		// TODO Auto-generated method stub	
	}	
	
	@Override
	public boolean hasConfigGui() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) {		
		return new LDConfigGui(parentScreen);
	}
	

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}
	
	public static class LDConfigGui extends GuiConfig{
				
		public LDConfigGui(GuiScreen parentScreen) {
			super(parentScreen,getConfigElements(),Reference.MOD_ID,false,false,I18n.format("gui.config.mainscreen.title"));
		}

		private static List<IConfigElement> getConfigElements() {
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			
			list.add(new DummyCategoryElement("Global Toggles",I18n.format("gui.config.category.toggles"), CategoryEntryToggles.class)); //I18n.format("gui.config.category.toggles")			
			list.add(new DummyCategoryElement("Humanoid/Other",I18n.format("gui.config.category.values"), CategoryEntryValues.class)); //I18n.format("gui.config.category.toggles")
			list.add(new DummyCategoryElement("Large Animals",I18n.format("gui.config.category.valuesla"), CategoryEntryValuesLA.class)); //I18n.format("gui.config.category.toggles")
			list.add(new DummyCategoryElement("Medium Animals",I18n.format("gui.config.category.valuesma"), CategoryEntryValuesMA.class)); //I18n.format("gui.config.category.toggles")
			list.add(new DummyCategoryElement("Small Animals",I18n.format("gui.config.category.valuessa"), CategoryEntryValuesSA.class)); //I18n.format("gui.config.category.toggles")
			
			return list;
		}
		
//		private static IConfigElement categoryElement(String category, String name, String tooltip_key) 
//		{
//	        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key, new ConfigElement(LDConfig.getConfig().getCategory(category)).getChildElements());
//	    }		
				
		public static class CategoryEntryToggles extends CategoryEntry{							
			public CategoryEntryToggles(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement) {super(owningScreen, owningEntryList, configElement);}
			@Override
			protected GuiScreen buildChildScreen(){Configuration config = LDConfig.getConfig();ConfigElement myCat = new ConfigElement(config.getCategory(LDConfig.CATEGORY_TOGGLES));List<IConfigElement> propertiesOnScreen = myCat.getChildElements();
			String windowTitle = I18n.format("gui.config.toggles.title");
			return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,false,false,windowTitle);}			
		}
		
		public static class CategoryEntryValues extends CategoryEntry{						
			public CategoryEntryValues(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement) {super(owningScreen, owningEntryList, configElement);}
			@Override
			protected GuiScreen buildChildScreen(){Configuration config = LDConfig.getConfig();ConfigElement myCat = new ConfigElement(config.getCategory(LDConfig.CATEGORY_VALUES));List<IConfigElement> propertiesOnScreen = myCat.getChildElements();
			String windowTitle = I18n.format("gui.config.values.title");
			return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,false,false,windowTitle);}			
		}	

		public static class CategoryEntryValuesLA extends CategoryEntry{						
			public CategoryEntryValuesLA(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement) {super(owningScreen, owningEntryList, configElement);}
			@Override
			protected GuiScreen buildChildScreen(){Configuration config = LDConfig.getConfig();ConfigElement myCat = new ConfigElement(config.getCategory(LDConfig.CATEGORY_VALUESLA));List<IConfigElement> propertiesOnScreen = myCat.getChildElements();
			String windowTitle = I18n.format("gui.config.valuesla.title");
			return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,false,false,windowTitle);}			
		}	
		
		public static class CategoryEntryValuesMA extends CategoryEntry{						
			public CategoryEntryValuesMA(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement) {super(owningScreen, owningEntryList, configElement);}
			@Override
			protected GuiScreen buildChildScreen(){Configuration config = LDConfig.getConfig();ConfigElement myCat = new ConfigElement(config.getCategory(LDConfig.CATEGORY_VALUESMA));List<IConfigElement> propertiesOnScreen = myCat.getChildElements();
			String windowTitle = I18n.format("gui.config.valuesma.title");
			return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,false,false,windowTitle);}			
		}	
		
		public static class CategoryEntryValuesSA extends CategoryEntry{			
			public CategoryEntryValuesSA(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement) {super(owningScreen, owningEntryList, configElement);}
			@Override
			protected GuiScreen buildChildScreen(){Configuration config = LDConfig.getConfig();ConfigElement myCat = new ConfigElement(config.getCategory(LDConfig.CATEGORY_VALUESSA));List<IConfigElement> propertiesOnScreen = myCat.getChildElements();
			String windowTitle = I18n.format("gui.config.valuessa.title");
			return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID,false,false,windowTitle);}			
		}			
		

	}

}
