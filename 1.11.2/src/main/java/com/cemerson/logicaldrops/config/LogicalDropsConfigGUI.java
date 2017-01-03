package com.cemerson.logicaldrops.config;

import com.cemerson.logicaldrops.LogicalDrops;
import com.cemerson.logicaldrops.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class LogicalDropsConfigGUI extends GuiConfig {
  public LogicalDropsConfigGUI(GuiScreen parent) {
    super(parent,
        new ConfigElement(
        		LogicalDrops.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
        		Reference.MOD_ID, 
        		false, 
    			false, 
    			GuiConfig.getAbridgedConfigPath(LogicalDrops.configFile.toString()));
  }
}

