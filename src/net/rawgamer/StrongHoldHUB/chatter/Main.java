package net.rawgamer.StrongHoldHUB.chatter;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static ArrayList<Player> chatmute = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new net.rawgamer.StrongHoldHUB.chatter.events.chat(), this);
	}
	
}
