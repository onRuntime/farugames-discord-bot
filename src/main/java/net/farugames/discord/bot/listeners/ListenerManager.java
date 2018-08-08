package main.java.net.farugames.discord.bot.listeners;

import main.java.net.farugames.discord.bot.commands.CommandMap;
import main.java.net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember.GuildMemberJoinListener;
import main.java.net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember.GuildMemberLeaveListener;
import main.java.net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember.GuildMemberRoleAddListener;
import main.java.net.farugames.discord.bot.listeners.guild.genericguild.genericguildmember.GuildMemberRoleRemoveListener;
import main.java.net.farugames.discord.bot.listeners.message.genericmessage.MessageReceivedListener;
import main.java.net.farugames.discord.bot.listeners.message.genericmessage.genericmessagereaction.MessageReactionAddListener;
import main.java.net.farugames.discord.bot.listeners.message.genericmessage.genericmessagereaction.MessageReactionRemoveListener;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ListenerManager extends ListenerAdapter {
	
	private static CommandMap commandMap;
	
	public static CommandMap getAPI() {
		if(commandMap == null) commandMap = new CommandMap();
		return commandMap;
	}
	
	@Override
	public void onMessageReceived(final MessageReceivedEvent event) {
		new MessageReceivedListener().execute(event);
	}
	
	@Override
	public void onGuildMemberRoleAdd(final GuildMemberRoleAddEvent event) {
		new GuildMemberRoleAddListener().execute(event);
	}
	
	@Override
	public void onGuildMemberRoleRemove(final GuildMemberRoleRemoveEvent event) {
		new GuildMemberRoleRemoveListener().execute(event);
	}
	
	@Override
	public void onMessageReactionAdd(final MessageReactionAddEvent event) {
		new MessageReactionAddListener().execute(event);
	}
	
	@Override
	public void onMessageReactionRemove(final MessageReactionRemoveEvent event) {
		new MessageReactionRemoveListener().execute(event);
	}
	
	@Override
	public void onGuildMemberJoin(final GuildMemberJoinEvent event) {
		new GuildMemberJoinListener().execute(event);
	}
	
	@Override
	public void onGuildMemberLeave(final GuildMemberLeaveEvent event) {
		new GuildMemberLeaveListener().execute(event);
	}
}
