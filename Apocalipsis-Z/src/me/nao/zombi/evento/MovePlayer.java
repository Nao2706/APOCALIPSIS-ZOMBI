package me.nao.zombi.evento;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;

import org.bukkit.World.Environment;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;

import org.bukkit.entity.Husk;
import org.bukkit.entity.LivingEntity;
//import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import me.nao.zombi.Main;
//import me.nao.zombi.mobs.CustomZombi;
//import net.minecraft.server.v1_16_R3.WorldServer;





public class MovePlayer {


	public int taskID;
	
	
    private Main plugin;
	int tiempo;
	
	private Player player;
	
	public MovePlayer(Main plugin,int tiempo,Player player) {
		this.plugin = plugin;
		this.tiempo = tiempo;
		this.player = player;
		
		
	}

	
	
	public void ejecucion() {
		
		
		BukkitScheduler sh = Bukkit.getServer().getScheduler();
		taskID = sh.scheduleSyncRepeatingTask(plugin,new Runnable(){
			FileConfiguration config = plugin.getConfig();
			 List<String> mundos = config.getStringList("World-Permissions.List");
		        String mundo = player.getWorld().getName();
			public void run() {
				 if(mundos.contains(mundo)) {
				
				Location block = player.getLocation();
			     block.setY(block.getY() - 0);
				
			     Block b = block.getBlock();
			     if(b.getLightFromBlocks() <= 1) {
			    	
			    		 zombi();	
			    	 
							
			     }
						if(config.getBoolean("Config.Stop")) {
							Bukkit.getScheduler().cancelTask(taskID);	
						}
				 }
						
				}
					
	
		},0L,500);
	  
		
	}
	
    public void zombi() {
    	for(Player p : Bukkit.getOnlinePlayers()) {
    	
    		
				Random random = new Random();
				Location l = p.getLocation();
				
				int n = random.nextInt(10);
				
	
				int radius = 50;
				double x = l.getX() + random.nextInt(radius);
				double z = l.getZ() + random.nextInt(radius);
				double y = l.getWorld().getHighestBlockYAt((int)x,(int)z);
				if(p.getWorld().getEnvironment() == Environment.NETHER) {
				  while(y > 128) {
				    x = p.getLocation().getX() + (random.nextBoolean() ? random.nextInt(radius) : -random.nextInt(radius));
				    z = p.getLocation().getZ() + (random.nextBoolean() ? random.nextInt(radius) : -random.nextInt(radius));
				    y = p.getWorld().getHighestBlockYAt((int)x,(int)z);
				  }
				}
				Location l2 = new Location(player.getWorld(), x, y, z); 			
			
				
				
				
				LivingEntity entidad10 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE_VILLAGER);
				ZombieVillager zv = (ZombieVillager) entidad10;
				zv.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
			
				
				
				LivingEntity entidad8 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.DROWNED);
				Drowned zombi8 = (Drowned) entidad8;
				LivingEntity entidad9 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
				Zombie zombi9 = (Zombie) entidad9;
				zombi9.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);

				PotionEffect rapido6 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
			    zombi9.addPotionEffect(rapido6);
			    PotionEffect salto6= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
				zombi9.addPotionEffect(salto6);
				
				zv.addPotionEffect(salto6);
				zv.addPotionEffect(rapido6);
				
				PotionEffect rapido3 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
			    zombi8.addPotionEffect(rapido3);
			    PotionEffect salto3= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
				zombi8.addPotionEffect(salto3);
				zombi8.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
				
				
				LivingEntity husk1 = (LivingEntity) player.getWorld().spawnEntity(l2, EntityType.HUSK);	
					Husk husk = (Husk) husk1;
					
					PotionEffect rapido5 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					husk.addPotionEffect(rapido5);
					PotionEffect rapido2 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					husk.addPotionEffect(rapido2);
				
					husk.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
				
				
				if(n == 1) {
				    LivingEntity entidad = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
					Zombie zombi = (Zombie) entidad;
				
					zombi.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					PotionEffect rapido = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  				zombi.addPotionEffect(rapido);
	  				PotionEffect salto= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  				zombi.addPotionEffect(salto);
				}else if(n == 2) {
					LivingEntity entidad1 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
					Zombie zombi1 = (Zombie) entidad1;
					zombi1.setCustomName(""+ChatColor.DARK_RED+ChatColor.BOLD+"Tank");
					
					
				    zombi1.addPotionEffect(rapido3);
					
					zombi1.addPotionEffect(salto3);
				
					zombi1.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					zombi1.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					zombi1.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
					zombi1.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
					zombi1.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
					zombi1.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
					
				}else if(n == 3) {
					
					LivingEntity entidad2 = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.BLAZE);
	  				Blaze blaze = (Blaze) entidad2;
	  				blaze.setCustomName(""+ChatColor.GOLD+"Blaze of Horde");
					
	  				LivingEntity entidad4 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
	  				Zombie zombi4 = (Zombie) entidad4;

	  				PotionEffect rapido4 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  			    zombi4.addPotionEffect(rapido4);
	  				PotionEffect salto4= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  				zombi4.addPotionEffect(salto4);
	  				zombi4.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
	  				entidad4.addPassenger(entidad2);
	  				
				}else if(n == 4) {
					
					LivingEntity entidad3 = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER);
	  				Creeper creeper = (Creeper) entidad3;
	  				creeper.setExplosionRadius(5);
		  		    creeper.setCustomName(""+ChatColor.GOLD+"Explosive Zombie");
					creeper.setMaxFuseTicks(2);
		  		    
	  				LivingEntity entidad5 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
	  				Zombie zombi5 = (Zombie) entidad5;
	  			
	  			    zombi5.addPotionEffect(rapido5);
	  				PotionEffect salto5= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  				zombi5.addPotionEffect(salto5);
	  				zombi5.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
	  				entidad5.addPassenger(entidad3);
	  				
				} else if(n == 5) {
					
					
		  		    
	  				LivingEntity entidad6 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
	  				Zombie zombi6 = (Zombie) entidad6;
	  				
	  				zombi6.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
	  			    zombi6.addPotionEffect(rapido5);
	  				PotionEffect salto5= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  				zombi6.addPotionEffect(salto5);
	  			for(int i = 0 ; i < 5 ; i ++) {	
	  				LivingEntity entidad7 = (LivingEntity) p.getWorld().spawnEntity(l2, EntityType.ZOMBIE);
	  				Zombie zombi7 = (Zombie) entidad7;
	  				zombi7.setBaby();
	  				PotionEffect rapido7 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  			    zombi7.addPotionEffect(rapido7);
	  				PotionEffect salto7= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
	  				zombi7.addPotionEffect(salto7);
	  				entidad6.addPassenger(entidad7);
	  				zombi7.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
	  			}
	  				
	  				
	  			
				}	
				/*
				 else if(n == 7) {
					
					
		  		    
					 WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
						CustomZombi giant = new CustomZombi(player.getLocation());
						
						world.addEntity(giant);
	  			
				}	
				*/
				
				
					
		}
    	return;
    }
   
	
	
	
}





/*
 * 
 * 
 * 
 * if(tiempo == 0) {
							Bukkit.getScheduler().cancelTask(taskID);
					
							return;
						}
						else {
			
							tiempo --;
					
						}
 * 
 * 
 * 
 * 
 * */
