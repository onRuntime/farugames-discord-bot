package main.java.net.farugames.discord.bot.commands;

import main.java.net.farugames.discord.bot.commands.commands.basics.InfoCommand;
import main.java.net.farugames.discord.bot.commands.commands.basics.RestartCommand;
import main.java.net.farugames.discord.bot.commands.commands.basics.StopCommand;
import main.java.net.farugames.discord.bot.commands.commands.moderation.MuteCommand;

public class Commands {

	public InfoCommand INFO = new InfoCommand();
	public StopCommand STOP = new StopCommand();
	public RestartCommand RESTART = new RestartCommand();
	public MuteCommand MUTE = new MuteCommand();
}
