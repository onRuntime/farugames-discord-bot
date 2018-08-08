package main.java.net.farugames.discord.bot.utils.messages;

import java.awt.Color;

import main.java.net.farugames.discord.bot.FaruGamesBot;
import main.java.net.farugames.discord.bot.guilds.Guilds;
import main.java.net.farugames.discord.bot.utils.builders.EmbedMessageBuilder;

public class Message {
	
	public static EmbedMessageBuilder NO_PERMISSION = new EmbedMessageBuilder()
			.withAuthor("❌ No Permission !", FaruGamesBot.getInstance().getJDA().getSelfUser().getAvatarUrl())
			.withDescription("You do not have permission to do that.")
			.withColor(Color.RED);
	
	public static EmbedMessageBuilder BAD_USER = new EmbedMessageBuilder()
			.withAuthor("❗ Bad User Account !", FaruGamesBot.getInstance().getJDA().getSelfUser().getAvatarUrl())
			.withDescription("There is a problem with the selected user account, contact Administrators for more informations.")
			.withColor(Color.RED);
	
	public static EmbedMessageBuilder BOT_STATE_STARTING = new EmbedMessageBuilder()
			.withAuthor("🚩 INFO » Bot Ready !", Guilds.STAFF.getIconUrl())
			.withDescription("Discord bot program has been started !")
			.withColor(Color.GREEN);
	
	public static EmbedMessageBuilder BOT_STATE_RESTARTING = new EmbedMessageBuilder()
			.withAuthor("🚩 INFO » Bot Restarting !", Guilds.STAFF.getIconUrl())
			.withDescription("Discord bot program is restarting...")
			.withColor(Color.ORANGE);
	
	public static EmbedMessageBuilder BOT_STATE_STOPPING = new EmbedMessageBuilder()
			.withAuthor("🚩 INFO » Bot Unready !", Guilds.STAFF.getIconUrl())
			.withDescription("Discord bot program has been stopped !")
			.withColor(Color.RED);
	
	public static EmbedMessageBuilder MEMBER_ALREADY_MUTED = new EmbedMessageBuilder()
			.withAuthor("❌ Already Muted !", FaruGamesBot.getInstance().getJDA().getSelfUser().getAvatarUrl())
			.withDescription("This member is already muted.")
			.withColor(Color.YELLOW);
	
	public static EmbedMessageBuilder MEMBER_MUTED = new EmbedMessageBuilder()
			.withAuthor("✅ Member Muted !", FaruGamesBot.getInstance().getJDA().getSelfUser().getAvatarUrl())
			.withColor(Color.GREEN);
}
