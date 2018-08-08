package main.java.net.farugames.discord.bot.commands.commands.moderation;

import main.java.net.farugames.discord.bot.commands.Command;
import main.java.net.farugames.discord.bot.commands.CommandMap;
import main.java.net.farugames.discord.bot.commands.Command.ExecutorType;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class MuteCommand {

	@Command(name="mute", type=ExecutorType.USER, description="Make a user muted.")
	public void execute(Member[] targets, MessageChannel messageChannel, Member member, String command, User user) {
		System.out.println("1");
		if(targets == null || targets[0] == null) {
			messageChannel.sendMessage(main.java.net.farugames.discord.bot.utils.messages.Message.BAD_USER
				.withFooter(member.getEffectiveName() + " (" + CommandMap.getTag() + command + ")", user.getAvatarUrl())
				.build())
			.complete();
			return;
		}
		Member target = targets[0];
		if(!member.hasPermission(Permission.KICK_MEMBERS) || target.hasPermission(Permission.KICK_MEMBERS)) {
			messageChannel.sendMessage(main.java.net.farugames.discord.bot.utils.messages.Message.NO_PERMISSION
				.withFooter(member.getEffectiveName() + " (" + CommandMap.getTag() + command + ")", user.getAvatarUrl())
				.build())
			.complete();
			return;
		}
		if(!target.hasPermission(Permission.MESSAGE_WRITE)) {
			messageChannel.sendMessage(main.java.net.farugames.discord.bot.utils.messages.Message.MEMBER_ALREADY_MUTED
				.withFooter(member.getEffectiveName() + " (" + CommandMap.getTag() + command + ")", user.getAvatarUrl())
				.build())
			.complete();
			return;
		}
		
		target.getPermissions().remove(Permission.MESSAGE_WRITE);
		messageChannel.sendMessage(main.java.net.farugames.discord.bot.utils.messages.Message.MEMBER_MUTED
			.withDescription(target.getAsMention() + " was successfuly muted.")
			.withFooter(member.getEffectiveName() + " (" + CommandMap.getTag() + command + ")", user.getAvatarUrl())
			.build())
		.complete();
		return;
	}
}
