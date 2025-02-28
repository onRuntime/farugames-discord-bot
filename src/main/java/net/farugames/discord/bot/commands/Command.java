package main.java.net.farugames.discord.bot.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

	public String name();
	public String description() default "No description set.";
	public ExecutorType type() default ExecutorType.ALL;
	
	public enum ExecutorType {
		ALL, USER, HELPER, MODERATOR, ADMIN, CONSOLE;
	}
	
}
