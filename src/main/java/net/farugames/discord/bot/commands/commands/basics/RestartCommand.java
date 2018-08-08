package main.java.net.farugames.discord.bot.commands.commands.basics;

import main.java.net.farugames.discord.bot.FaruGamesBot;
import main.java.net.farugames.discord.bot.commands.Command;
import main.java.net.farugames.discord.bot.commands.CommandMap;
import main.java.net.farugames.discord.bot.commands.Command.ExecutorType;
import main.java.net.farugames.discord.bot.utils.messages.Message;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class RestartCommand {

	@Command(name="restart", type=ExecutorType.ALL, description="Restart the bot application.")
	public void execute(User user, Member member, MessageChannel messageChannel, String command) {
		if(!member.hasPermission(Permission.ADMINISTRATOR)) {
			messageChannel.sendMessage(Message.NO_PERMISSION
					.withFooter(member.getEffectiveName() + " (" + CommandMap.getTag() + command + ")", user.getAvatarUrl())
				.build())
			.complete();
			return;
		}
		FaruGamesBot.getInstance().restart();
	}
}
