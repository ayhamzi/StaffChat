package ayham.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		System.out.println("[StaffChat] v1.0 | Activated");
		registerEvents();
		registerCommands();
	}

	public void onDisable() {
		System.out.println("[StaffChat] v1.0 | De-activated");
	}
	
	public void registerCommands() {
		getCommand("staffchat").setExecutor(new Commands(this));
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Chat(this), (this));
	}	
}
