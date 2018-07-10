package net.farugames.discord.bot.commands;

import java.lang.reflect.Method;

import net.farugames.discord.bot.commands.Command.ExecutorType;

public final class SimpleCommand {
	
	private final String name, description;
	private final ExecutorType exectuorType;
	private final Object object;
	private final Method method;
	
	public SimpleCommand(String name, String description, ExecutorType exectuorType, Object object, Method method) {
		super();
		this.name = name;
		this.description = description;
		this.exectuorType = exectuorType;
		this.object = object;
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ExecutorType getExecutorType() {
		return exectuorType;
	}

	public Object getObject() {
		return object;
	}

	public Method getMethod() {
		return method;
	}

}
