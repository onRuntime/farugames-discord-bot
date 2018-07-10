package net.farugames.discord.bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.farugames.discord.bot.listeners.ListenerManager;
import net.farugames.discord.bot.listeners.message.MessageReceivedListener;

public class FaruGamesBot implements Runnable {

	private static JDA jda;
	
	private Boolean running;
	
	public static void main(String[] args) {
		new Thread(new FaruGamesBot(), "bot").start();
	}
	
	public FaruGamesBot() {
		try {
			jda = new JDABuilder(AccountType.BOT)
					.setToken("NDY2MDI1OTI3OTE1MjA4NzA2.DiWEmw.7eMka8vJpbI2BaXYOFO8H7GtqLU")
					.addEventListener(new ListenerManager())
					.setGame(Game.watching("Currently under maintenance."))
					.setStatus(OnlineStatus.ONLINE)
				.buildAsync();
			System.out.println("FaruGames BOT has been started.");
		} catch (LoginException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.running = true;
		
		while(this.running) {
			jda.addEventListener(new MessageReceivedListener());
		}
		
		jda.shutdown();
		System.out.println("FaruGames BOT has been stoped.");
		System.exit(0);
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public static JDA getJDA() {
		return jda;
	}
}
