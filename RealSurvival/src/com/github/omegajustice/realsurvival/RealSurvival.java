package com.github.omegajustice.realsurvival;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RealSurvival extends JavaPlugin{
	public static RealSurvival plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final MyBlockListener bl = new MyBlockListener();
	public final MyPlayerListener pl = new MyPlayerListener();
	
	public void onDisable(){
		PluginDescriptionFile pdf = this.getDescription();
		this.logger.info(pdf.getDescription() + " disabled");
	}
	public void onEnable(){
		PluginDescriptionFile pdf = this.getDescription();
		this.logger.info(pdf.getDescription() + " enabled");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.bl, this);
	//	pm.registerEvents(this.pl, this);
		ShapelessRecipe gunpowder = new ShapelessRecipe(new ItemStack(Material.SULPHUR, 2));
		gunpowder.addIngredient(Material.COAL);
		gunpowder.addIngredient(Material.SUGAR);
		getServer().addRecipe(gunpowder);
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		return false;
	}
}
