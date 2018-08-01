package net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;

public class GuildMemberJoinListener {

	public void execute(GuildMemberJoinEvent event) {
		event.getMember().getRoles().add(event.getGuild().getRoleById(null));
	}
}
