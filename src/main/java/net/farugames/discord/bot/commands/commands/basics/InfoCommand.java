package main.java.net.farugames.discord.bot.commands.commands.basics;

import main.java.net.farugames.discord.bot.commands.Command;
import main.java.net.farugames.discord.bot.commands.Command.ExecutorType;

public class InfoCommand {

	@Command(name="info", type=ExecutorType.USER, description="Display all informations about this Discord guild.")
	public void execute() {
		System.out.println("Oui");
	}
}
