package com.cemerson.logicaldrops.config;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

//package net.minecraftforge.fml.client;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Pattern;
//import com.google.common.collect.ImmutableSet;
//import net.minecraft.client.gui.Gui;
//import net.minecraft.client.gui.GuiButton;
//import net.minecraft.client.resources.I18n;
//import net.minecraftforge.fml.client.config.ConfigGuiType;
//import net.minecraftforge.fml.client.config.DummyConfigElement;
//import net.minecraftforge.fml.client.config.GuiConfig;
//import net.minecraftforge.fml.client.config.GuiEditArray;
//import net.minecraftforge.fml.client.config.GuiEditArrayEntries;
//import net.minecraftforge.fml.client.config.IConfigElement;
//import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
//import net.minecraftforge.fml.client.config.DummyConfigElement.DummyListElement;
//import net.minecraftforge.fml.client.config.GuiConfigEntries.NumberSliderEntry;


public class LogicalDropsGuiFactory implements IModGuiFactory {

	  @Override
	  public void initialize(Minecraft minecraftInstance) {
	  }

	  @Override
	  public Class<? extends GuiScreen> mainConfigGuiClass() {
	    return LogicalDropsConfigGUI.class;
	  }
	  	 	    	   	   	

//	  @Override
//	  public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
//	    return null;
//	  }

// 	  @Override
//	  public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
//	    return null;
//	  }
	  
	  	  
	   @Override
	    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
	    {
//	        return new RuntimeOptionGuiHandler() {
//	            @Override
//	            public void paint(int x, int y, int w, int h)
//	            {
//	                // TODO Auto-generated method stub
//
//	            }
//
//	            @Override
//	            public void close()
//	            {
//	            }
//
//	            @Override
//	            public void addWidgets(List<Gui> widgets, int x, int y, int w, int h)
//	            {
//	                widgets.add(new GuiButton(100, x+10, y+10, "HELLO"));
//	            }
//
//	            @Override
//	            public void actionCallback(int actionId)
//	            {
//	                // TODO Auto-generated method stub
//
//	            }
//	        };
		   return null;
	    }	   
	  
	  

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen){ // (GuiScreen arg0) {
		// TODO Auto-generated method stub
		 return new LogicalDropsConfigGUI(parentScreen);
		// return null;
	}
	

	@Override
	public boolean hasConfigGui() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}

/*
public class FMLConfigGuiFactory implements IModGuiFactory 
{
    public static class FMLConfigGuiScreen extends GuiConfig 
    {

   @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
    {
        return new RuntimeOptionGuiHandler() {
            @Override
            public void paint(int x, int y, int w, int h)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void close()
            {
            }

            @Override
            public void addWidgets(List<Gui> widgets, int x, int y, int w, int h)
            {
                widgets.add(new GuiButton(100, x+10, y+10, "HELLO"));
            }

            @Override
            public void actionCallback(int actionId)
            {
                // TODO Auto-generated method stub

            }
        };
    }

} 
 */
