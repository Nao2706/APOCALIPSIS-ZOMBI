package me.nao.zombi.evento;


import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import me.nao.zombi.Main;

public class DamagedEffect implements Listener{
	
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public DamagedEffect(Main plugin) {
		this.plugin = plugin;
	}
	
	

	@EventHandler  //METODO
    public void alpvp(EntityDamageByEntityEvent e){
       
		Entity entidad = e.getDamager();
		Entity entidadAtacada = e.getEntity();
		
		
			
		
				if(entidad.getType() == EntityType.ZOMBIE && entidadAtacada.getType() == EntityType.PLAYER) {
					Player player = (Player) entidadAtacada;
					 Random random = new Random();
					 int n = random.nextInt(100);	
				 
				
				 if(n == 0) {
					PotionEffect veneno = new PotionEffect(PotionEffectType.POISON,/*duration*/1200,/*amplifier:*/20, true ,true,true );
				      player.addPotionEffect(veneno);
					 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te infecto con Veneno");
				 }else if(n == 1) {
					PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION,/*duration*/1200,/*amplifier:*/20, true ,true,true );
				       player.addPotionEffect(nausea);
					 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te infecto con Mareos");
				 }else if(n == 2) {
					PotionEffect lento = new PotionEffect(PotionEffectType.SLOW,/*duration*/1200,/*amplifier:*/20, true ,true,true );
				      player.addPotionEffect(lento);
					 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te infecto con Lentitud");
				 }else if(n == 3) {
					
					
					   //  player.setVelocity(new Vector(0,5,0));
					
					player.setVelocity(player.getLocation().getDirection().multiply(-20).setY(3));
				    player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te mando a volar");
						 
				    Location loc = player.getLocation();
					player.getWorld().createExplosion(loc.getX(),loc.getY(),loc.getZ(),0,false,true);
					 
				 }
				
		     			
			
		     		
			   }
				
				else if(entidad.getType() == EntityType.GIANT && entidadAtacada.getType() == EntityType.PLAYER) {
					Player player = (Player) entidadAtacada;
					 Random random = new Random();
					 int n = random.nextInt(100);	
					
					if(n == 0) {
						PotionEffect veneno = new PotionEffect(PotionEffectType.POISON,/*duration*/1200,/*amplifier:*/20, true ,true,true );
					      player.addPotionEffect(veneno);
					  	PotionEffect ciego = new PotionEffect(PotionEffectType.BLINDNESS,/*duration*/1200,/*amplifier:*/20, true ,true,true );
					      player.addPotionEffect(ciego);
					      player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Titan te enveneno y te cego");
					}
					else if(n == 1) {
						 for(int i = 0 ; i < 10 ; i++) {
							 LivingEntity entidad99 = (LivingEntity) player.getWorld().spawnEntity(entidadAtacada.getLocation(), EntityType.ZOMBIE);
								Zombie zombi9 = (Zombie) entidad99;

								PotionEffect rapido6 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
							    zombi9.addPotionEffect(rapido6);
							    PotionEffect salto6= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
								zombi9.addPotionEffect(salto6);
						 }
						
						     player.playSound(player.getLocation(),Sound.ENTITY_GHAST_HURT ,50.0F , 1F  );
							 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi se multiplico");
						 }
					
				}
				
				 else if(entidad.getType() == EntityType.PLAYER && entidadAtacada.getType() == EntityType.GIANT) {
					 Player player = (Player) entidad;
					 Random random = new Random();
					 int n = random.nextInt(100);	
					 if(n == 0) {
						 Location loc = player.getLocation();
							player.getWorld().createExplosion(loc.getX(),loc.getY(),loc.getZ(),4,false,true);
							player.setVelocity(player.getLocation().getDirection().multiply(-20).setY(7));
							 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" El Titan te a lanzado");
							 player.playSound(player.getLocation(),Sound.ENTITY_GHAST_HURT ,150.0F , 1F  );
						 }else if(n == 1) {
							 for(int i = 0 ; i < 10 ; i++) {
								 LivingEntity entidad99 = (LivingEntity) player.getWorld().spawnEntity(entidadAtacada.getLocation(), EntityType.ZOMBIE);
									Zombie zombi9 = (Zombie) entidad99;

									PotionEffect rapido6 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
								    zombi9.addPotionEffect(rapido6);
								    PotionEffect salto6= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
									zombi9.addPotionEffect(salto6);
							 }
							
							     player.playSound(player.getLocation(),Sound.ENTITY_GHAST_HURT ,50.0F , 1F  );
								 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi se multiplico");
							 }
					 
				 }
				
     			return;
	}
	@EventHandler
	public void shoot(ProjectileHitEvent e) {
		
		ProjectileSource atacante = e.getEntity().getShooter();
		Entity atacado = e.getHitEntity();
		EntityType proyectile = e.getEntityType();
			 if(!(atacante instanceof HumanEntity)) {
				 return;
			 }else {
				try {
					 Player player = (Player) atacante;
					 Random random = new Random();
					 int n = random.nextInt(100);		
						// player.sendMessage("Atacaste a "+ atacado.getCustomName() );
						 
							if(atacado.getType() == EntityType.GIANT && proyectile  == EntityType.ARROW) {
								if(n == 10) {
								
									// player.sendMessage("Atacaste a "+ atacado.getCustomName() );
									atacado.setVelocity(player.getLocation().getDirection().multiply(-6).setY(5));
									
								}
							}
							else if(atacado.getType() == EntityType.GIANT && proyectile  == EntityType.SPECTRAL_ARROW) {
								if(n == 15) {
								
								
									atacado.setVelocity(player.getLocation().getDirection().multiply(-6).setY(5));
									
								}
							}
					
					
					
					
				}
				catch(NullPointerException ex) {
					return;
				}
		    }
	}
	
	
	
	
	
	

}
