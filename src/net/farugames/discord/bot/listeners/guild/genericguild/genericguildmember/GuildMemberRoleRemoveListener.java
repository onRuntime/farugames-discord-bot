package net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import net.farugames.discord.bot.guilds.staff.channels.Channel;

public class GuildMemberRoleRemoveListener {

	public void execute(GuildMemberRoleRemoveEvent event) {
		if(event.getMember().getRoles().isEmpty()) {
			event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
				.sendMessage(":no_entry: " + event.getMember().getAsMention() + " was unranked from " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
			.complete();
			return;
		}
		event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
			.sendMessage(":arrow_down: " + event.getMember().getAsMention() + " was unranked from " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
		.complete();
		return;
	}
}
