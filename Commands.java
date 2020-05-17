package ayham.staffchat;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	public static ArrayList<Player> Insc = new ArrayList<Player>();
	
	String Prefix = ChatColor.translateAlternateColorCodes('&', "&7[&bStaff&7] ");
	String NoPerm = ChatColor.translateAlternateColorCodes('&', Prefix + "&cYou do not have permission to use this command!");
	String Enabled = ChatColor.translateAlternateColorCodes('&', Prefix + "&aYou've enabled staffchat.");
	String Disabled = ChatColor.translateAlternateColorCodes('&', Prefix + "&cYou've disabled staffchat.");
	
	public Main plugin;
	
	public Commands(Main pl) {
		this.plugin = pl;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		System.out.println("[StaffChat] v1.0 | Player has executed a command.");
		System.out.println("[StaffChat] v1.0 | This command is under development.");
		if(cmd.getName().equalsIgnoreCase("staffchat")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("Only players may use /staffchat!");
				
				return true;
			}
			Player p = (Player) sender;
			
			if(args.length == 0) {
				
				if(!(p.hasPermission("staffchat.talk"))) {
					p.sendMessage(NoPerm);
					
					return true;
				}
				
				if(Insc.contains(p)) {
					Insc.remove(p);
					p.sendMessage(Disabled);
					return true;
				} else
					Insc.add(p);
				p.sendMessage(Enabled);
				
				return true;
			}
			if(args.length >= 1) {
				p.sendMessage(Prefix + ChatColor.RED + "Usage: /staffchat, thank you.");
				
				return true;
			}
		}
		return false;
	}
}
