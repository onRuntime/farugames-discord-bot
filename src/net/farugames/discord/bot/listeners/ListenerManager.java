package net.farugames.discord.bot.listeners;

import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.farugames.discord.bot.listeners.roles.GuildMemberRoleAddListener;
import net.farugames.discord.bot.listeners.roles.GuildMemberRoleRemoveListener;

public class ListenerManager extends ListenerAdapter {
	
	@Override
	public void onGuildMemberRoleAdd(final GuildMemberRoleAddEvent event) {
		new GuildMemberRoleAddListener().execute(event);
	}
	
	@Override
	public void onGuildMemberRoleRemove(final GuildMemberRoleRemoveEvent event) {
		new GuildMemberRoleRemoveListener().execute(event);
	}
}
