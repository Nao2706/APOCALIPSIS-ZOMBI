package me.nao.zombi.evento;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Husk;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.nao.zombi.Main;
import me.nao.zombi.armas.ItemManager;



public class ManualSpawn implements Listener{

	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public ManualSpawn(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	@EventHandler
	public void spawnm(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem() != null) {
				if (e.getItem().getItemMeta().equals(ItemManager.Item1.getItemMeta())) {
					
					Player p = (Player)e.getPlayer();
					
					PotionEffect rapido2 = new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					PotionEffect rapido5 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					LivingEntity entidad10 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE_VILLAGER);
					ZombieVillager zv = (ZombieVillager) entidad10;
					
					LivingEntity entidad11 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE_VILLAGER);
					ZombieVillager zv1 = (ZombieVillager) entidad11;
					zv1.setBaby();
					zv1.addPotionEffect(rapido5);
					zv1.addPotionEffect(rapido2);
					zv1.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					
					
					LivingEntity entidad12 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
					Zombie zv2 = (Zombie) entidad12;
					zv2.setBaby();
					zv2.addPotionEffect(rapido5);
					zv2.addPotionEffect(rapido2);
					zv2.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					
					LivingEntity entidad13 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.DROWNED);
					Drowned zv3 = (Drowned) entidad13;
					zv3.setBaby();
					zv3.addPotionEffect(rapido5);
					zv3.addPotionEffect(rapido2);
					zv3.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					
					
					LivingEntity husk2 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.HUSK);	
					Husk husk22 = (Husk) husk2;
					husk22.setBaby();
					husk22.addPotionEffect(rapido5);
					husk22.addPotionEffect(rapido2);
					husk22.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					
					zv.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					zv.addPotionEffect(rapido5);
					zv.addPotionEffect(rapido2);
					
					
					LivingEntity entidad8 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.DROWNED);
					Drowned zombi8 = (Drowned) entidad8;
					LivingEntity entidad9 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
					Zombie zombi9 = (Zombie) entidad9;
					zombi9.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);

					PotionEffect rapido6 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
				    zombi9.addPotionEffect(rapido6);
				    PotionEffect salto6= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					zombi9.addPotionEffect(salto6);
					
					PotionEffect rapido3 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
				    zombi8.addPotionEffect(rapido3);
				    PotionEffect salto3= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					zombi8.addPotionEffect(salto3);
					zombi8.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					
					
					LivingEntity husk1 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.HUSK);	
						Husk husk = (Husk) husk1;
						
						
						husk.addPotionEffect(rapido5);
					
						husk.addPotionEffect(rapido2);
					
						husk.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					
				}
			}
		}
				
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem() != null) {
				if (e.getItem().getItemMeta().equals(ItemManager.Item2.getItemMeta())) {
					
					Player p = (Player)e.getPlayer();
					
					
					LivingEntity entidad1 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
					LivingEntity entidad2 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
					LivingEntity entidad3 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
					LivingEntity entidad4 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
					Zombie zombi1 = (Zombie) entidad1;
					Zombie zombi2 = (Zombie) entidad2;
					Zombie zombi3 = (Zombie) entidad3;
					Zombie zombi4 = (Zombie) entidad4;
					
					zombi1.setCustomName(""+ChatColor.DARK_RED+ChatColor.BOLD+"Tank Infectado");
					zombi3.setCustomName(""+ChatColor.DARK_PURPLE+ChatColor.BOLD+"Elite Infectado");
					zombi2.setCustomName(""+ChatColor.WHITE+ChatColor.BOLD+"Soldado Infectado");
					zombi4.setCustomName(""+ChatColor.GREEN+ChatColor.BOLD+"Superviviente Infectado");
				
					
					PotionEffect rapido5 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
				 
					PotionEffect salto5 = new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
					zombi1.addPotionEffect(salto5);
					zombi1.addPotionEffect(rapido5);
					zombi1.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					zombi1.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					zombi1.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
					zombi1.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
					zombi1.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
					zombi1.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
					
					
					
					
					zombi2.addPotionEffect(salto5);
					zombi2.addPotionEffect(rapido5);
					zombi2.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					zombi2.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
					zombi2.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
					zombi2.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					zombi2.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
					zombi2.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
					
					zombi3.addPotionEffect(salto5);
					zombi3.addPotionEffect(rapido5);
					zombi3.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					zombi3.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
					zombi3.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
					zombi3.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
					zombi3.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
					zombi3.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
					
					
					zombi4.addPotionEffect(salto5);
					zombi4.addPotionEffect(rapido5);
					zombi4.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(150);
					zombi4.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
					zombi4.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					zombi4.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
					zombi4.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
					zombi4.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
				}
			}
		}
			
		
	}
	
	
}
