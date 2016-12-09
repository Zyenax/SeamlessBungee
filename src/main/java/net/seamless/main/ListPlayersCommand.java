package net.seamless.main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class ListPlayersCommand extends Command{
	
	public ListPlayersCommand() {
		super("list", null, "glist");
	  }
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
			if(args.length >= 0){
				sender.sendMessage(Main.color("&aThere are &c" + ProxyServer.getInstance().getOnlineCount() + " &aplayers across &e" + ProxyServer.getInstance().getServers().size() + " &aservers!"));
			}
	}
}
