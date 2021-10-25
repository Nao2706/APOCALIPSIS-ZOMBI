package me.nao.zombi;



import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.nao.zombi.armas.ItemManager;
import me.nao.zombi.comandos.Comandos;
import me.nao.zombi.evento.AntiFire;
import me.nao.zombi.evento.DamagedEffect;
import me.nao.zombi.evento.ManualSpawn;



public class Main extends JavaPlugin{

	
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String nombre = ""+ChatColor.AQUA+ChatColor.BOLD+"["+ChatColor.GREEN+ChatColor.BOLD+pdffile.getName()+ChatColor.AQUA+ChatColor.BOLD+"]";
	public String rutaConfig;
	
	
	
	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new ManualSpawn(this),this);
		getServer().getPluginManager().registerEvents(new AntiFire(this),this);
		getServer().getPluginManager().registerEvents(new DamagedEffect(this),this);
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+" ===============================================");
		Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.RED+" Ha sido activado ("+ChatColor.AQUA+"version:"+ChatColor.DARK_GREEN+version+ChatColor.RED+")");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+" Disfruta el Plugin :D");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+" ===============================================");
		
		registrarcomando();
		registerConfig();
	}
	
	
	
	
	
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+" ===============================================");
		Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.RED+" Ha sido activado (version:"+ChatColor.DARK_GREEN+version+")");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+" Disfruta el Plugin :D");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE+" ===============================================");
	}
	
	public void registrarcomando() {
		ItemManager.init();
		getCommand("az").setExecutor(new Comandos(this));
		
	}
	
	public void registerConfig() {
		
		File config = new File(this.getDataFolder(),"config.yml");
		rutaConfig = config.getPath();
		if(!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
			
		}
	}

	
}
