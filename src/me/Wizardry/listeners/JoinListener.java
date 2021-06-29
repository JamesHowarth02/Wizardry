package me.Wizardry.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Wizardry.Main;

public class JoinListener implements Listener {
	private static Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player plr = e.getPlayer(); // 199 64 -223
		plr.kickPlayer("You're not eligible to test §l§5Wizardry for 1.17.§l§f\nIf you're looking for the §cRealm of Bevilon§f, it has closed its portal §4permanently.§f\n\nIf you feel this is a mistake, reach out to the developer's email: §njameshowarth02@gmail.com§n");
		/*
		if(plr.hasPlayedBefore()) {
			org.bukkit.World world = Bukkit.createWorld(new WorldCreator("world_intro"));
			Location location = new Location((org.bukkit.World) world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ());
			plr.teleport(location);
			plr.setWalkSpeed(0.1f);
			plr.setGameMode(GameMode.ADVENTURE);
			plr.sendTitle("§l§dWizardry", "§fApproach the Enchantment Table");
		}else {
			plr.sendMessage("Welcome back, " + plr.getName());
		}*/
	}
}
