package me.nao.zombi.GeneradorRandom;

import java.util.HashSet;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import org.bukkit.entity.Player;

import me.nao.zombi.Main;

public class RandomTpmob {

	
    static Main plugin;
	
	@SuppressWarnings("static-access")
	public RandomTpmob(Main plugin) {
		this.plugin = plugin;
	}

	public static HashSet<Material> badblocks = new HashSet<>();
	
	static {
		badblocks.add(Material.LAVA);
		badblocks.add(Material.FIRE);
		
	}
	
	// min 31:04
	public static Location generateLocation(Player player) {
		
		Random random = new Random();
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		if(plugin.getConfig().getBoolean("Config.World-Border")) {
			 x = random.nextInt(plugin.getConfig().getInt("Config.Range"));
			 y = 150;
			 z = random.nextInt(plugin.getConfig().getInt("Config.Range"));
		}else if (!plugin.getConfig().getBoolean("Config.World-Border")){
			 x = random.nextInt(25000);
			 y = 150;
			 z = random.nextInt(25000);
		}
		
		
		
		Location randomLocation = new Location(player.getWorld(),x,y,z);
		
		y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
		randomLocation.setY(y);
		
		while(!isLocationSafe(randomLocation)) {
			randomLocation = generateLocation(player);
		}
		
		return randomLocation;
	}
	
	public static boolean isLocationSafe(Location location){
		
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		
		Block block = location.getWorld().getBlockAt(x, y , z);
		Block below = location.getWorld().getBlockAt(x, y -1, z);
		Block above = location.getWorld().getBlockAt(x, y +1, z);
		
		return !(badblocks.contains(below.getType()) || (block.getType().isSolid()) ||  (above.getType().isSolid()) );
	}
	
}
