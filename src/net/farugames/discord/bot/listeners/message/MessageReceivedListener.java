package net.farugames.discord.bot.listeners.message;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.farugames.discord.bot.channels.Channel;
import net.farugames.discord.bot.commands.CommandMap;

public class MessageReceivedListener implements EventListener {
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof MessageReceivedEvent) this.execute((MessageReceivedEvent) event);
	}

	public void execute(MessageReceivedEvent event) {
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) return;
		
		String message = event.getMessage().getContentDisplay();
		
		System.out.println(message);
		event.getGuild().getTextChannelById(Channel.ANNOUNCEMENTS.getID())
			.sendMessage(message)
		.complete();
		
		if(!message.startsWith(CommandMap.getTag())) { /* ERROR MESSAGE */ }
		message = message.replaceFirst(CommandMap.getTag(), "");
		
		/*
		 * Event content.
		 */
	}
}
