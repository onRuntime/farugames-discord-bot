package net.farugames.discord.bot.listeners.roles;

import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.farugames.discord.bot.channels.Channel;

public class GuildMemberRoleAddListener {

	public void execute(GuildMemberRoleAddEvent event) {
		
		System.out.println(event.getMember());
		System.out.println(event.getMember().getRoles());
		System.out.println(event.getRoles().get(0).getAsMention());
		
		if(event.getMember().getRoles().isEmpty()) {
			event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
				.sendMessage(event.getGuild().getEmotesByName("white_check_mark", true) + event.getMember().getAsMention() + " is now ranked " + event.getRoles().get(0).getAsMention() + " !")
			.complete();
			return;
		}
		event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
			.sendMessage(event.getGuild().getEmotesByName("arrow_up", true) + event.getMember().getAsMention() + " up-ranked to " + event.getRoles().get(0).getAsMention() + " !")
			.complete();
		return;
	}
}
