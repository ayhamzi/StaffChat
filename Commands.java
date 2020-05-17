package ayham.staffchat;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// implements CommandExecutor basically means that it is making this Class a command, which then adds unimplemented methods.
public class Commands implements CommandExecutor {
// public static ArrayList stores elements and inherits codes
	public static ArrayList<Player> Insc = new ArrayList<Player>();
	
// its saying when i type (prefix + "text") to prefix will mean "&7[&bStaff&7]" which also applies to the other 3.
	String Prefix = ChatColor.translateAlternateColorCodes('&', "&7[&bStaff&7] ");
	String NoPerm = ChatColor.translateAlternateColorCodes('&', Prefix + "&cYou do not have permission to use this command!");
	String Enabled = ChatColor.translateAlternateColorCodes('&', Prefix + "&aYou've enabled staffchat.");
	String Disabled = ChatColor.translateAlternateColorCodes('&', Prefix + "&cYou've disabled staffchat.");
	
// this right here links it to the Main class
	public Main plugin;
	
	public Commands(Main pl) {
		this.plugin = pl;
	}

// @Override tells me when something is not capatalized correctly
	@Override
// public boolean onCommand means that this is the code that executes when the command is run.
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
// system.out.println is the printing something in console when the command is executed in this case.
		System.out.println("[StaffChat] v1.0 | Player has executed a command.");
		System.out.println("[StaffChat] v1.0 | This command is under development.");
		if(cmd.getName().equalsIgnoreCase("staffchat")) {
// the (!( means that if it is NOT the instanceof a player then to send the sender or 'CommandSender' that message, basically sending that message to console.
			if(!(sender instanceof Player)) {
				sender.sendMessage("Only players may use /staffchat!");
				
				return true;
			}
// this is making it so instead of you typing player you just type p,
			Player p = (Player) sender;
// if the command is written perfectly
			if(args.length == 0) {
				
				if(!(p.hasPermission("staffchat.talk"))) {
// as i said (!( means that if the player does not have that permission then it goes up and uses the NoPerm string and sends that to the player!
					p.sendMessage(NoPerm);
					
					return true;
				}
// this line is saying that if you send the command and staffchat is on it will turn it off.
				if(Insc.contains(p)) {
					Insc.remove(p);
					p.sendMessage(Disabled);
					return true;
				} else
// this line is saying that if you send the command and staffchat is off it will turn it on.
					Insc.add(p);
				p.sendMessage(Enabled);
				
				return true;
			}
			if(args.length >= 1) {
// if the command is like "/staffchat hi" it will tell you the proper usage and ChatColor.RED is org.bukkit.ChatColor
				p.sendMessage(Prefix + ChatColor.RED + "Usage: /staffchat, thank you.");
				
				return true;
			}
		}
		return false;
	}
}
