package main.java.net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.net.farugames.discord.bot.guilds.staff.channels.Channel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;

public class GuildMemberRoleRemoveListener {

	public void execute(GuildMemberRoleRemoveEvent event) {
		if(event.getMember().getRoles().isEmpty()) {
			Channel.ANNOUNCEMENTS
				.sendMessage(":no_entry: " + event.getMember().getAsMention() + " was unranked from " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
			.complete();
			return;
		}
		Channel.ANNOUNCEMENTS
			.sendMessage(":arrow_down: " + event.getMember().getAsMention() + " was unranked from " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
		.complete();
		return;
	}
}
