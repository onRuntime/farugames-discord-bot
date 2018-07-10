package net.farugames.discord.bot.listeners;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.farugames.discord.bot.listeners.message.MessageReceivedListener;
import net.farugames.discord.bot.listeners.roles.GuildMemberRoleAddListener;
import net.farugames.discord.bot.listeners.roles.GuildMemberRoleRemoveListener;

public class ListenerManager implements EventListener {

	@Override
	public void onEvent(Event event) {
		if(event instanceof MessageReceivedEvent) new MessageReceivedListener().execute((MessageReceivedEvent) event);
		if(event instanceof GuildMemberRoleAddEvent) new GuildMemberRoleAddListener().execute((GuildMemberRoleAddEvent) event);
		if(event instanceof GuildMemberRoleRemoveEvent) new GuildMemberRoleRemoveListener().execute((GuildMemberRoleRemoveEvent) event);
	}
}
