package me.nao.zombi.armas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class ItemManager {

	
	
	
	
	//agrega
	public static ItemStack Item1;
	public static ItemStack Item2;
	public static ItemStack Item3;
	public static ItemStack Item4;


	
	//agrega 
	public static void init() {
		createWand();
		createWand2();
		createWand3();
		createWand4();
		
	}
	
	//agrega
	private static void createWand() {
		
		ItemStack item = new ItemStack(Material.BLAZE_ROD,/*CANTIDAD*/1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(""+ChatColor.GOLD+ChatColor.BOLD+"["+ChatColor.RED+ChatColor.BOLD+"SPAWN ZOMBI"+ChatColor.GOLD+ChatColor.BOLD+"]");
		List<String> lore = new ArrayList<>();
		lore.add(""+ChatColor.GREEN+"[Spawnea Hordas de zombis]");
		lore.add(""+ChatColor.GOLD+ChatColor.BOLD+"Da click derecho "+ChatColor.GREEN+ChatColor.BOLD+"Para usar la habilidad");
		lore.add(""+ChatColor.YELLOW+ChatColor.BOLD+"CATEGORIA:"+ChatColor.BLUE+"[RARO]");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 20, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Item1=item;
	}
	
	private static void createWand2() {
		
		ItemStack item = new ItemStack(Material.BLAZE_ROD,/*CANTIDAD*/1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(""+ChatColor.GOLD+ChatColor.BOLD+"["+ChatColor.RED+ChatColor.BOLD+"SPAWN ZOMBI TANK"+ChatColor.GOLD+ChatColor.BOLD+"]");
		List<String> lore = new ArrayList<>();
		lore.add(""+ChatColor.GREEN+"[Spawnea Hordas de Tankes]");
		lore.add(""+ChatColor.GOLD+ChatColor.BOLD+"Da click derecho "+ChatColor.GREEN+ChatColor.BOLD+"Para usar la habilidad");
		lore.add(""+ChatColor.YELLOW+ChatColor.BOLD+"CATEGORIA:"+ChatColor.BLUE+"[RARO]");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 20, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Item2=item;
	}
	

	private static void createWand3() {
		
		ItemStack item = new ItemStack(Material.BLAZE_ROD,/*CANTIDAD*/1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(""+ChatColor.GOLD+ChatColor.BOLD+"["+ChatColor.GREEN+ChatColor.BOLD+"ONE PUNCH MAN"+ChatColor.GOLD+ChatColor.BOLD+"]");
		List<String> lore = new ArrayList<>();
		lore.add(""+ChatColor.GREEN+"[Mandalos a volar]");
		lore.add(""+ChatColor.GOLD+ChatColor.BOLD+"Golpea a quien desees"+ChatColor.GREEN+ChatColor.BOLD+" Para mandarlo a volar");
		lore.add(""+ChatColor.YELLOW+ChatColor.BOLD+"CATEGORIA:"+ChatColor.BLUE+"[RARO]");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 30, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Item3=item;
	}
	
 private static void createWand4() {
		
		ItemStack item = new ItemStack(Material.BLAZE_ROD,/*CANTIDAD*/1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(""+ChatColor.GOLD+ChatColor.BOLD+"["+ChatColor.GREEN+ChatColor.BOLD+"SPAWNEA IRON GOLEMS"+ChatColor.GOLD+ChatColor.BOLD+"]");
		List<String> lore = new ArrayList<>();
		lore.add(""+ChatColor.GREEN+"[Mandalos a volar]");
		lore.add(""+ChatColor.GOLD+ChatColor.BOLD+"Da click derecho"+ChatColor.GREEN+ChatColor.BOLD+" Spawnea Iron Golemsr");
		lore.add(""+ChatColor.YELLOW+ChatColor.BOLD+"CATEGORIA:"+ChatColor.BLUE+"[RARO]");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 30, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Item3=item;
	}
	
	
}
