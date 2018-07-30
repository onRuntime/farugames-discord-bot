package net.farugames.discord.bot.commands.commands.basics;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.farugames.discord.bot.FaruGamesBot;
import net.farugames.discord.bot.commands.Command;
import net.farugames.discord.bot.commands.Command.ExecutorType;

public class StopCommand {

	@Command(name="stop", type=ExecutorType.ALL, description="Stop the principal instance of the bot.")
	public void execute(Guild guild, Member member) {
		if(!member.hasPermission(Permission.ADMINISTRATOR)) {
			return;
		}
		
		FaruGamesBot.getInstance().setRunning(false);
	}
}
