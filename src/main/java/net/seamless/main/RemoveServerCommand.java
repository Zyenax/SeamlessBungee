package net.seamless.main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class RemoveServerCommand extends Command{
	
	public RemoveServerCommand() {
	      super("removeserver");
	  }
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
			if(args.length == 0){
				sender.sendMessage(Main.color("&cUSAGE: /removeserver [name]"));
			}
		
			if(args.length == 1){
				String target = args[0];
					if(ProxyServer.getInstance().getServers().remove(target) == null){
						sender.sendMessage(Main.color("&cYou must supply a valid server name."));
					}else{
						ProxyServer.getInstance().getServers().remove(target);
		                sender.sendMessage(Main.color("&aServer &e" + target + " &ahas been removed."));
					}
			}
	}
}
