package main.java.net.farugames.discord.bot.listeners.message.genericmessage.genericmessagereaction;

import main.java.net.farugames.discord.bot.guilds.community.Reaction;
import main.java.net.farugames.discord.bot.guilds.community.channels.Channel;
import main.java.net.farugames.discord.bot.messages.Message;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;

public class MessageReactionRemoveListener {

	public void execute(MessageReactionRemoveEvent event) {
		if(event.getChannelType() == ChannelType.TEXT && event.getChannel().getIdLong() == Channel.WELCOME.getID() && event.getMessageIdLong() == Message.WELCOME.getID()) {
			for(Reaction reaction : Reaction.values()) {
				if(event.getReactionEmote().getName() != reaction.getEmoteName()) return;
				if(!event.getMember().getRoles().contains(event.getGuild().getRoleById(reaction.getRoleID()))) return;
				event.getMember().getRoles().remove(event.getGuild().getRoleById(reaction.getRoleID()));
			}
		}
	}
}
