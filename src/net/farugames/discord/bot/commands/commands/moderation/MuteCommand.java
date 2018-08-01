package net.farugames.discord.bot.commands.commands.moderation;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.farugames.discord.bot.commands.Command;
import net.farugames.discord.bot.commands.Command.ExecutorType;

public class MuteCommand {

	@Command(name="mute", type=ExecutorType.USER, description="Make a user muted.")
	public void mute(Guild guild, Member member, Message message, Member[] targets, String[] args) {
		if(!member.hasPermission(Permission.KICK_MEMBERS)) return;
		Member target = message.getMentionedMembers() != null ? message.getMentionedMembers().get(0) : null;
		if(target == null || target.hasPermission(Permission.KICK_MEMBERS)) return;
		
		if(!target.hasPermission(Permission.MESSAGE_WRITE)) return /* Error already muted. */;
		target.getPermissions().remove(Permission.MESSAGE_WRITE);
	}
}
