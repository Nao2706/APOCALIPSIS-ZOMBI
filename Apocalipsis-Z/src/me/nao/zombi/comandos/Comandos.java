package me.nao.zombi.comandos;





import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

import me.nao.zombi.Main;
import me.nao.zombi.armas.ItemManager;
import me.nao.zombi.evento.MovePlayer;
import me.nao.zombi.mobs.CustomZombi;
import net.minecraft.server.level.WorldServer;









public class Comandos implements CommandExecutor{

	
	
	
	private Main plugin;
	
	public Comandos(Main plugin) {
		this.plugin = plugin;
	}
	
	
	//Captador de mensaje 

	public boolean onCommand( CommandSender sender,  Command comando,  String label,
		 String[] args) {
		
		//mensaje desde consola
		// con el if se evita que se use el comando desde consola
		if(!(sender instanceof Player)){
			
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					Bukkit.getConsoleSender().sendMessage(plugin.nombre+ChatColor.GREEN+" Se ha recargado correctamente el Plugin ");
					return true;
					}
			
				
				
				
			}else {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+ChatColor.RED+" El Comando que escribiste no existe o lo escribiste mal.");
			}
			
			
		}
		
		//COMANDOS QUE PUEDE USAR JUGADOR CANTIDAD
		else {
			
			Player player = (Player) sender ;
	
			FileConfiguration config = plugin.getConfig();
			
			
			if(args.length > 0 && player.hasPermission("zombie.op")) {
				if(args[0].equalsIgnoreCase("version")) {
					player.sendMessage(plugin.nombre+ChatColor.GREEN+" La Version del Plugin es: "+ChatColor.YELLOW+plugin.version)
							;
					return true;
				    }
				
				else if(args[0].equalsIgnoreCase("spawn")) {
					
					WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
					CustomZombi giant = new CustomZombi(player.getLocation());
					Entity entidad1 = (Entity) player.getWorld().spawnEntity(player.getLocation().add(0, 20, 0), EntityType.LIGHTNING);
					LightningStrike rayo = (LightningStrike) entidad1;
					rayo.setCustomName("rayo");
					world.addEntity(giant);
					Bukkit.broadcastMessage(ChatColor.RED+"Un Titan a Spawneado Cuidado!!!");
					return true;
					}
				
	//==================================================================================			
				
				
			   else if(args[0].equalsIgnoreCase("start")) {
				   player.sendMessage(ChatColor.GREEN+"El Apocalipsis Zombi se a Comenzado");
				   player.sendMessage(ChatColor.GREEN+"Start");
					MovePlayer m = new MovePlayer(plugin,100,player);
					m.ejecucion();
					config.set("Config.Stop", false);
					plugin.saveConfig();
					return true;
					}
			   else if(args[0].equalsIgnoreCase("stop")) {
				
				if(!config.getBoolean("Config.Stop")){
					config.set("Config.Stop", true);
					plugin.saveConfig();
					plugin.reloadConfig();
				}
				 player.sendMessage(ChatColor.RED+"El Apocalipsis Zombi se a Detenido");
					player.sendMessage(ChatColor.RED+"Stop");
					
					return true;
					}
				
	//==================================================================================		
				
				
				else if(args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
			
					player.sendMessage(plugin.nombre+ChatColor.GREEN+" Se ha recargado correctamente el Plugin ");
					return true;
					}
				
				else if(args[0].equalsIgnoreCase("zombi")) {
					player.getInventory().addItem(ItemManager.Item1);
					player.getInventory().addItem(ItemManager.Item2);
					player.getInventory().addItem(ItemManager.Item3);
					player.getInventory().addItem(ItemManager.Item4);
			
					player.sendMessage(plugin.nombre+ChatColor.GREEN+" Spawnea Zombis donde sea ");
					return true;
					}	
			
		
		
				
				
				
			}
			else if(!player.hasPermission("zombie.op")) {
				
				player.sendMessage(plugin.nombre+ChatColor.RED+" No tienes permiso para ejecutar este Comando. ");
			}
			
			player.sendMessage(plugin.nombre+ChatColor.RED+" escribe "+ChatColor.YELLOW+"/az info");
			
			
			
		}
		return true;
	}
	
	
}


/*
 * 
 * 
 * else if (args[0].equalsIgnoreCase("creative")){
    ChangeMode("creative", player);
}else if (args[0].equalsIgnoreCase("survival")){
    ChangeMode("survival", player);
}
public voidChangeMode(String mode, Player player){
    inventoryCache.put(player.getUniqueId(), player.getInventory().getContents());
    player.getInventory().setContents(inventoryCache.get(player.getUniqueId()));
    if(mode.equals("survival")){
        player.setGameMode(GameMode.Survival);
        player.sendMessage(plugin.nombre+ChatColor.GREEN+"Modo de juego survival");
    }else if(mode.equals("survival")){
        player.setGameMode(GameMode.Creative);
        player.sendMessage(plugin.nombre+ChatColor.GREEN+"Modo de juego creative");
    }
}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * String enumValue = args[0] != null ? (args[0].equalsIgnoreCase("survival") ? "SURVIVAL" :  args[0].equalsIgnoreCase("creative") ? "CREATIVE" : args[0].equalsIgnoreCase("adventure") : "ADVENTURE" : args[0].equalsIgnoreCase("spectator") ? "SPECTATOR" : "NONE"): "NONE";
if(enumValue.equals("NONE") {player.sendMessage("Modo inválido como tu primo");return;}
GameMode mode = GameMode.valueOf(enumValue);
player.setGameMode(mode);
player.sendMessage("Tu modo de juego ha sido cambiado a "+enumValue.toLowerCase());
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */







