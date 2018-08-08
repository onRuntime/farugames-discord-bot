package main.java.net.farugames.discord.bot;

import java.awt.Color;

import javax.security.auth.login.LoginException;

import main.java.net.farugames.discord.bot.data.mysql.MySQLManager;
import main.java.net.farugames.discord.bot.guilds.Guilds;
import main.java.net.farugames.discord.bot.guilds.staff.channels.Channel;
import main.java.net.farugames.discord.bot.listeners.ListenerManager;
import main.java.net.farugames.discord.bot.utils.builders.EmbedMessageBuilder;
import main.java.net.farugames.discord.bot.utils.messages.Prefix;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class FaruGamesBot extends MySQLManager implements Runnable {

	private static FaruGamesBot instance;
	private static Thread thread;
	
	private JDA jda;
	
	private Boolean running;
	
	private Long stateMessageID;
	
	public static void main(String[] args) {
		thread = new Thread(new FaruGamesBot(), "bot");
		thread.start();
	}
	
	public FaruGamesBot() {
		instance = this;
		System.out.println(Prefix.JDA + Prefix.INFO + getInstance().getClass().getPackage() + " - Starting discord bot program...");
		try {
			this.jda = new JDABuilder(AccountType.BOT)
					.setToken("NDY2MDI1OTI3OTE1MjA4NzA2.DiWEmw.7eMka8vJpbI2BaXYOFO8H7GtqLU")
					.setGame(Game.watching("UNDER DEVELOPMENT ● PLAY.FARUGAMES.NET"))
					.addEventListener(new ListenerManager())
					.setStatus(OnlineStatus.ONLINE)
				.buildAsync();
			System.out.println(Prefix.JDA + Prefix.INFO + getInstance().getClass().getPackage() + " - Discord bot program started !");
		} catch (LoginException | IllegalArgumentException exception) {
			throw new IllegalStateException("Cannot start discord bot program !", exception);
		}
	}
	
	@Override
	public void run() {
		
		this.setRunning(true);
//		Channel.ADMIN.sendMessage(
//			new EmbedMessageBuilder()
//				.withAuthor("🚩 INFO » Bot Ready !", Guilds.STAFF.getIconUrl())
//				.withDescription("Discord bot program has been started !")
//				.withColor(Color.GREEN)
//			.build()
//		).complete();
//		this.stateMessageID = Channel.ADMIN.getLatestMessageIdLong();
//		Channel.ADMIN.pinMessageById(this.stateMessageID).complete();
		
		while(this.isRunning()) {
			
		}
		
		this.stop();
	}
	
	public void setRunning(Boolean running) {
		this.running = running;
	}
	
	public Boolean isRunning() {
		return this.running;
	}
	
	@SuppressWarnings("deprecation")
	public void stop() {
		if(this.stateMessageID != null) {
			Channel.ADMIN.editMessageById(this.stateMessageID, 
					new EmbedMessageBuilder()
					.withAuthor("🚩 INFO » Bot Unready !", Guilds.STAFF.getIconUrl())
					.withDescription("Discord bot program has been stopped !")
					.withColor(Color.RED)
					.build())
			.complete();
			Channel.ADMIN.unpinMessageById(this.stateMessageID).complete();
		}
		System.out.println(Prefix.JDA + Prefix.INFO + getInstance().getClass().getPackage() + " - Stopping discord bot program...");
		MySQLManager.disconnect();
		this.jda.shutdown();
		System.out.println(Prefix.JDA + Prefix.INFO + getInstance().getClass().getPackage() + " - Discord bot program stopped !");
		System.exit(0);
		thread.stop();
		thread.destroy();
	}
	
	@SuppressWarnings("deprecation")
	public void restart() {
		if(this.stateMessageID != null) {
			Channel.ADMIN.editMessageById(this.stateMessageID, 
					new EmbedMessageBuilder()
					.withAuthor("🚩 INFO » Bot Restarting !", Guilds.STAFF.getIconUrl())
					.withDescription("Discord bot program is restarting...")
					.withColor(Color.ORANGE)
					.build())
			.complete();
		}
		System.out.println(Prefix.JDA + Prefix.INFO + getInstance().getClass().getPackage() + " - Restarting discord bot program...");
		MySQLManager.disconnect();
		this.jda.shutdown();
		thread.stop();
		new FaruGamesBot();
		System.out.println(Prefix.JDA + Prefix.INFO + getInstance().getClass().getPackage() + " - Discord bot program restarted !");
	}
	
	public JDA getJDA() {
		return this.jda;
	}
	
	public static FaruGamesBot getInstance() {
		return instance;
	}
}
