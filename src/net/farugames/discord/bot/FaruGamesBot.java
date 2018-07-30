package net.farugames.discord.bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.farugames.discord.bot.listeners.ListenerManager;

public class FaruGamesBot implements Runnable {

	private static FaruGamesBot instance;
	
	private JDA jda;
	
	private Boolean running;
	private static Thread thread;
	
	public static void main(String[] args) {
		thread = new Thread(new FaruGamesBot(), "bot");
		thread.start();
	}
	
	public FaruGamesBot() {
		instance = this;
		try {
			this.jda = new JDABuilder(AccountType.BOT)
					.setToken("NDY2MDI1OTI3OTE1MjA4NzA2.DiWEmw.7eMka8vJpbI2BaXYOFO8H7GtqLU")
					.setGame(Game.watching("UNDER DEVELOPMENT ● PLAY.FARUGAMES.NET"))
					.addEventListener(new ListenerManager())
					.setStatus(OnlineStatus.ONLINE)
				.buildAsync();
			System.out.println("FaruGames BOT has been started.");
		} catch (LoginException | IllegalArgumentException exception) {
			exception.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		this.running = true;
		
		while(this.running) {
		}
		
		this.jda.shutdown();
		thread.destroy();
		System.out.println("FaruGames BOT has been stoped.");
		System.exit(0);
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public JDA getJDA() {
		return this.jda;
	}
	
	public static FaruGamesBot getInstance() {
		return instance;
	}
}
