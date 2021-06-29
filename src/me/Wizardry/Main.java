package me.Wizardry;

import org.bukkit.plugin.java.JavaPlugin;

import me.Wizardry.commands.Intro;
import me.Wizardry.listeners.JoinListener;
import me.Wizardry.listeners.RegisterWandListener;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new Intro(this);
		new JoinListener(this);
		new RegisterWandListener(this);
		System.out.println("Wizardry: Initialized!");
	}
	
	public void onDisable() {
		System.out.println("Wizardry: Deinitializing plugin.");
	}
	
}
