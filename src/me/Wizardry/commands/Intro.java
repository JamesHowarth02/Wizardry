package me.Wizardry.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.GameMode;
import org.bukkit.Material;
import me.Wizardry.Main;


public class Intro implements CommandExecutor {

	private Main plugin;
	
	public Intro(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("intro").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
			bookMeta.setTitle("Introduction to Wizardry");
			bookMeta.setAuthor("Ministry of Magic");
			
			List<String> pages = new ArrayList<String>();
			pages.add("  §lIntroduction to\n      §dWizardry\n\n   §0Ministry of Magic"); // Page 1
			pages.add("Website: timevisualsales.com"); // Page 2
			pages.add("Hope you enjoy your stay/play!"); // Page 3
			bookMeta.setPages(pages);
			writtenBook.setItemMeta(bookMeta);
			
			((Player) sender).openBook(writtenBook);
		}
		return false;
	}
}
