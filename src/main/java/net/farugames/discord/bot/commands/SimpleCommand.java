package main.java.net.farugames.discord.bot.commands;

import java.lang.reflect.Method;

import main.java.net.farugames.discord.bot.commands.Command.ExecutorType;

public final class SimpleCommand {
	
	private final String name, description;
	private final ExecutorType exectuorType;
	private final Class<?> executedClass;
	private final Method method;
	
	public SimpleCommand(String name, String description, ExecutorType exectuorType, Class<?> executedClass, Method method) {
		super();
		this.name = name;
		this.description = description;
		this.exectuorType = exectuorType;
		this.executedClass = executedClass;
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

	public Class<?> getExecutedClass() {
		return executedClass;
	}

	public Method getMethod() {
		return method;
	}

}
