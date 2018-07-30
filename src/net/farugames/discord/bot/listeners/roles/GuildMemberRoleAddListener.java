package net.farugames.discord.bot.listeners.roles;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.farugames.discord.bot.channels.Channel;

public class GuildMemberRoleAddListener {

	public void execute(GuildMemberRoleAddEvent event) {
		
		if(event.getMember().getRoles().isEmpty()) {
			event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
				.sendMessage(":white_check_mark: " + event.getMember().getAsMention() + " was ranked " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
			.complete();
			return;
		}
		event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
			.sendMessage(":arrow_up: " + event.getMember().getAsMention() + " was ranked " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
		.complete();
		return;
	}
}
