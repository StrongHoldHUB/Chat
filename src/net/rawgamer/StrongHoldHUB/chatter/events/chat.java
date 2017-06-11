package net.rawgamer.StrongHoldHUB.chatter.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.rawgamer.StrongHoldHUB.chatter.Main;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class chat implements Listener {
	
	@EventHandler
	public void onchat(AsyncPlayerChatEvent e){
		if(e.getPlayer() instanceof Player){
			Player player = (Player) e.getPlayer();
			PermissionUser user = PermissionsEx.getUser(player);	
			e.setCancelled(true);
			if(Main.chatmute.contains(player)){
				player.sendMessage(format("&3Chat> &7You currently do not have permission to speak."));
			}else {
				if(!(player.hasPermission("chatter.chatcolors"))){
					Bukkit.broadcastMessage(chat.format(user.getPrefix()+"&r "+player.getDisplayName()+"&e |&r &7"+e.getMessage().replaceAll("&", "(gbhb)")).replaceAll("(gbhb)","&"));
				}else {
					Bukkit.broadcastMessage(chat.format(user.getPrefix()+"&r "+player.getDisplayName()+"&e |&r &f"+e.getMessage()));	
				}
			}
		}
	}
	
	public static String format(String str) {
		return str.replaceAll("&", "§");
	}
	
}
