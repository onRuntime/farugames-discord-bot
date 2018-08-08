package main.java.net.farugames.discord.bot.commands.commands.basics;

import main.java.net.farugames.discord.bot.FaruGamesBot;
import main.java.net.farugames.discord.bot.commands.Command;
import main.java.net.farugames.discord.bot.commands.CommandMap;
import main.java.net.farugames.discord.bot.commands.Command.ExecutorType;
import main.java.net.farugames.discord.bot.utils.messages.Message;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class StopCommand {

	@Command(name="stop", type=ExecutorType.ALL, description="Stop the principal instance of the bot.")
	public void execute(Guild guild, MessageChannel messageChannel, User user, String command) {
		if(!guild.getMember(user).hasPermission(Permission.ADMINISTRATOR)) {
			messageChannel.sendMessage(Message.NO_PERMISSION
					.withFooter(guild.getMember(user).getEffectiveName() + " (" + CommandMap.getTag() + command + ")", user.getAvatarUrl())
				.build())
			.complete();
			return;
		}
		FaruGamesBot.getInstance().stop();
	}
}
