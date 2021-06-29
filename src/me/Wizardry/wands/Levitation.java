package me.Wizardry.wands;

import org.bukkit.entity.Player;

public class Levitation extends Wand {
	/*
	 * 
	 * Wand of Levitation
	 * 
	 * Usage:
	 * 
	 */
	public Levitation(Player wand_owner) {
		super("Levitation", wand_owner, wand_owner.getUniqueId());
		this.setCooldown(500);
	}

	@Override
	public void useWandLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useWandRight() {
		// TODO Auto-generated method stub
		
	}

}
