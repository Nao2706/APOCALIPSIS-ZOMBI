package me.nao.zombi.evento;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;


import me.nao.zombi.Main;

public class AntiFire implements Listener{
    
	
	@SuppressWarnings("unused")
	private Main plugin ;
	
	public AntiFire(Main plugin){
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void Nofire(EntityCombustEvent e) {
		     
		   Entity entidad = e.getEntity();
		
		if(entidad.getType().equals(EntityType.ZOMBIE)) {
			if(e instanceof EntityCombustByEntityEvent || e instanceof EntityCombustByBlockEvent ) {
				return;
			}else {
				e.setCancelled(true);
			}
		}
		if(entidad.getType().equals(EntityType.DROWNED)) {
			if(e instanceof EntityCombustByEntityEvent || e instanceof EntityCombustByBlockEvent ) {
				return;
			}else {
				e.setCancelled(true);
			}
		}
		if(entidad.getType().equals(EntityType.ZOMBIE_VILLAGER)) {
			if(e instanceof EntityCombustByEntityEvent || e instanceof EntityCombustByBlockEvent ) {
				return;
			}else {
				e.setCancelled(true);
			}
		}
		if(entidad.getType().equals(EntityType.PHANTOM)) {
			if(e instanceof EntityCombustByEntityEvent || e instanceof EntityCombustByBlockEvent ) {
				return;
			}else {
				e.setCancelled(true);
			}
		}
			
	}
	
/*
	@EventHandler
	public void spawn(EntitySpawnEvent e) {
		
	}
	*/
	
}
