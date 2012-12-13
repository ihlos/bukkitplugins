package com.github.omegajustice.realsurvival;

import java.util.Random;

import org.bukkit.CropState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MyBlockListener implements Listener{
	@EventHandler(priority=EventPriority.HIGHEST,ignoreCancelled=true)
	public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		World world = block.getWorld();
		Location location = block.getLocation();
		if (block.getType() == Material.GRAVEL){
			block.setType(Material.AIR);
			world.dropItemNaturally(location, new ItemStack(Material.FLINT, new Random().nextInt(20)+12));
			event.setCancelled(true);
		}else if (block.getType() == Material.CROPS && block.getData() == CropState.RIPE.getData()) {
			block.setType(Material.AIR);
			world.dropItemNaturally(location, new ItemStack(Material.WHEAT, 1));
			world.dropItemNaturally(location, new ItemStack(Material.SEEDS, new Random().nextInt(2)+1));
			world.dropItemNaturally(location, new ItemStack(Material.STRING, new Random().nextInt(1)+1));
			event.setCancelled(true);
		}
	}
}
