package ayham.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
	
	public Main plugin;
	
	public Chat(Main pl) {
		
		this.plugin = pl;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		String Prefix = ChatColor.translateAlternateColorCodes('&', "&7[&bStaff&7]");
		String msg = e.getMessage();
		
		if(Commands.Insc.contains(p)) {
			
			e.setCancelled(true);
				for(Player staff : Bukkit.getServer().getOnlinePlayers()) {
					if(staff.hasPermission("staffchat.see")) {
						staff.sendMessage(Prefix + " " + p.getDisplayName() + org.bukkit.ChatColor.AQUA + " » " + org.bukkit.ChatColor.GRAY + msg);
				}
			}
		}
	}
}
