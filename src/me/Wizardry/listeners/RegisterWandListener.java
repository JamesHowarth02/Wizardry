package me.Wizardry.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.Wizardry.Main;
import me.Wizardry.particles.SpawnParticle;

public class RegisterWandListener implements Listener {
	private static Main plugin;

	public RegisterWandListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void checkItemFrameRotate(PlayerInteractEntityEvent event) {
		Player plr = event.getPlayer();
		Location wand_spawn = new Location(plr.getWorld(), 199.5, 64, -221.5);
		Location back_spawn = new Location(plr.getWorld(), 199.5, 64, -224.5);

		if (event.getRightClicked() instanceof ItemFrame) {
			ItemFrame itemFrame = (ItemFrame) event.getRightClicked();
			if (itemFrame.getItem() != null) {
				PotionEffect confusion = new PotionEffect(PotionEffectType.CONFUSION, 525, 5);
				PotionEffect blindness = new PotionEffect(PotionEffectType.BLINDNESS, 550, 1);
				BukkitRunnable fallingStarTask = new SpawnParticle(wand_spawn);
				fallingStarTask.runTaskTimer(plugin, 0, 1);
				plr.addPotionEffect(confusion);
				plr.addPotionEffect(blindness);
				plr.setWalkSpeed(0);
				plr.teleport(back_spawn);
				plr.sendTitle("§l§A ACCIO!", "§fYour wand is being summoned..");
				plr.sendMessage("[DEBUG] Wizardry 1.0.3 --> handed off to SpawnParticle's runTaskTimer for BukkitRunnable");

				ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
				BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
				bookMeta.setTitle("Introduction to Wizardry");
				bookMeta.setAuthor("Ministry of Magic");

				List<String> pages = new ArrayList<String>();
				pages.add("  §lIntroduction to\n      §dWizardry\n\n   §Wand of Levitation"); // Page 1
				pages.add("bitchesonmydick"); // Page 2
				pages.add("Hope you enjoy your stay/play!"); // Page 3
				bookMeta.setPages(pages);
				writtenBook.setItemMeta(bookMeta);

				((Player) plr).openBook(writtenBook);
			}
		}
	}
}
