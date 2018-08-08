package main.java.net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.net.farugames.discord.bot.guilds.staff.channels.Channel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;

public class GuildMemberRoleAddListener {

	public void execute(GuildMemberRoleAddEvent event) {
		
		if(event.getMember().getRoles().isEmpty()) {
			Channel.ANNOUNCEMENTS
				.sendMessage(":white_check_mark: " + event.getMember().getAsMention() + " was ranked " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
			.complete();
			return;
		}
		Channel.ANNOUNCEMENTS
			.sendMessage(":arrow_up: " + event.getMember().getAsMention() + " was ranked " + event.getRoles().get(0).getAsMention() + " ! **" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "**")
		.complete();
		return;
	}
}
