package net.seamless.main;

import java.net.InetSocketAddress;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {
	public void onEnable() {
		getProxy().getPluginManager().registerListener(this, this);
		getProxy().getPluginManager().registerCommand(this, new AddServerCommand());
		getProxy().getPluginManager().registerCommand(this, new RemoveServerCommand());
		getProxy().getPluginManager().registerCommand(this, new ListPlayersCommand());
	}

	@EventHandler(priority = 64)
	public void onPing(ProxyPingEvent ev) {
		ServerPing r = ev.getResponse();
		ServerPing.Players p = r.getPlayers();
		p = new ServerPing.Players(p.getOnline() + 1, p.getOnline(),
				p.getSample());
		ServerPing ping = new ServerPing(r.getVersion(), p,
				color("&b&lSeamless Network &c&l- &a&lComing Soon!"),
				r.getFaviconObject());
		ev.setResponse(ping);
	}

	@EventHandler
	public void playerJoin(LoginEvent e) {
		ServerInfo serverInfo = ProxyServer.getInstance().constructServerInfo(
				"TEST", new InetSocketAddress("127.0.0.1", 29999), "", false);
		ProxyServer.getInstance().getServers().put("TEST", serverInfo);
	}

	public static String color(String string) {
		return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&',
				string);
	}
}
