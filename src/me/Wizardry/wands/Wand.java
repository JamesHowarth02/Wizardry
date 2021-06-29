package me.Wizardry.wands;

import org.bukkit.entity.Player;
import java.util.UUID;

public abstract class Wand {
	protected String wand_name;
	protected Player wand_owner;
	protected int cooldown;
	protected UUID UUID;
	
	public Wand(String wand_name, Player wand_owner, UUID UUID) {
		this.wand_name = wand_name;
		this.wand_owner = wand_owner;
		this.UUID = UUID;
	}
	
	public void setOwner(Player plr) {
		this.wand_owner = plr;
	}
	
	public void setName(String name) {
		this.wand_name = name;
	}
		
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	public abstract void useWandLeft();
	public abstract void useWandRight();
}
