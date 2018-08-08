package main.java.net.farugames.discord.bot.listeners.message.genericmessage;

import main.java.net.farugames.discord.bot.commands.CommandMap;
import main.java.net.farugames.discord.bot.listeners.ListenerManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MessageReceivedListener {

	public void execute(MessageReceivedEvent event) {
		if(event.getAuthor() == event.getJDA().getSelfUser()) return;
		
		if(CommandMap.isDiscordCommand(event.getMessage())
				&& ListenerManager.getAPI().commandUser(event.getAuthor(), event.getMessage().getContentDisplay().replaceFirst(CommandMap.getTag(), ""), event.getMessage())
				&& !event.getMessage().getContentDisplay().replaceFirst(CommandMap.getTag(), "").equals("stop") 
				&& !event.getMessage().getContentDisplay().replaceFirst(CommandMap.getTag(), "").equals("restart"))
					event.getMessage().delete().complete();
	}
}
