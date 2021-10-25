package me.nao.zombi.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.attributes.GenericAttributes;
import net.minecraft.world.entity.ai.goal.PathfinderGoalAvoidTarget;
import net.minecraft.world.entity.ai.goal.PathfinderGoalFloat;
import net.minecraft.world.entity.ai.goal.PathfinderGoalLookAtPlayer;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMeleeAttack;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMoveThroughVillage;
import net.minecraft.world.entity.ai.goal.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomLookaround;
import net.minecraft.world.entity.ai.goal.PathfinderGoalRandomStroll;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalHurtByTarget;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.animal.EntityIronGolem;
import net.minecraft.world.entity.animal.EntityTurtle;
import net.minecraft.world.entity.monster.EntityGiantZombie;
import net.minecraft.world.entity.monster.EntityPillager;
import net.minecraft.world.entity.monster.EntityVindicator;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.player.EntityHuman;



public class CustomZombi extends EntityGiantZombie{

	
	public CustomZombi (Location loc) {
		super(EntityTypes.G,((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getBlockX(),loc.getY(),loc.getBlockZ());
	//	this.getAttributeInstance(GenericAttributes.f).setValue(50);
		this.setCustomName(new ChatComponentText(""+ChatColor.GOLD+ChatColor.BOLD+"[TITAN]"));
		this.setCustomNameVisible(true);
		this.getAttributeMap().a(GenericAttributes.b).setValue(80);
		this.setCanPickupLoot(true);

		
	
	
		
	}

	

	@Override
	public void initPathfinder() {
		
		this.bP.a(0, new PathfinderGoalFloat(this));
		
		this.bP.a(4, new PathfinderGoalMeleeAttack(this, 1.0D ,true));
		this.bP.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.2D));
		this.bP.a(6, new PathfinderGoalMoveThroughVillage(this,0.2D,false,1,null));
		this.bP.a(7, new PathfinderGoalRandomStroll(this, 0.2D));
		this.bP.a(8, new PathfinderGoalRandomLookaround(this));
		this.bP.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 20.0F)); // estaba en 8
		
		this.bQ.a(1, new PathfinderGoalHurtByTarget(this));
		this.bQ.a(2, new PathfinderGoalNearestAttackableTarget <EntityPlayer>(this, EntityPlayer.class,true));
		this.bQ.a(2, new PathfinderGoalNearestAttackableTarget <EntityVillager>(this, EntityVillager.class, true));
		this.bQ.a(2, new PathfinderGoalNearestAttackableTarget <EntityIronGolem>(this, EntityIronGolem.class, true));
		this.bQ.a(2, new PathfinderGoalNearestAttackableTarget <EntityPillager>(this, EntityPillager.class, true));
		this.bQ.a(2, new PathfinderGoalNearestAttackableTarget <EntityVindicator>(this, EntityVindicator.class, true));
		this.bQ.a(3, new PathfinderGoalAvoidTarget <EntityTurtle>(this,EntityTurtle.class,20,1.0D,1.0D));
		
	 }
		
	}
	

