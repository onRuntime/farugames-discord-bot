package main.java.net.farugames.discord.bot.commands;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import main.java.net.farugames.discord.bot.FaruGamesBot;
import main.java.net.farugames.discord.bot.commands.Command.ExecutorType;
import main.java.net.farugames.discord.bot.utils.messages.Prefix;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageReaction;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public final class CommandMap {
	 
    public final Map<String, SimpleCommand> commands = new HashMap<>();
    private static String tag = "/";
   
    public CommandMap() {
    	for(Field field : Commands.class.getDeclaredFields()) {
    		registerCommand(field.getType());
    	}
    }
   
    public static String getTag() {
        return tag;
    }
   
    public Collection<SimpleCommand> getCommands(){
        return commands.values();
    }
   
    public void registerCommands(Object[] objects) {
        for(Object object : objects) registerCommand(object);
    }
   
    public void registerCommand(Object object) {
        for(Method method : ((Class<?>) object).getDeclaredMethods()) {
            if(method.isAnnotationPresent(Command.class)) {
                Command command = method.getAnnotation(Command.class);
                method.setAccessible(true);
                SimpleCommand simpleCommand = new SimpleCommand(command.name(), command.description(), command.type(), (Class<?>) object, method);
                commands.put(command.name(), simpleCommand);
            }
        }
    }
    
    public boolean commandAdmin(User user, String command, Message message) {
    	Member member = (Member) user;
    	if(member.hasPermission(Permission.ADMINISTRATOR)) return true;
		return false;
    }
   
    public void commandConsole(String command) {
        Object[] object = getCommand(command);
        if(object[0] == null || ((SimpleCommand) object[0]).getExecutorType() == ExecutorType.USER){
            System.err.println(Prefix.COMMAND_MAP + "Unknown command.");
            return;
        }
        try{
            execute(((SimpleCommand) object[0]), command, (String[]) object[1], null);
        }catch(Exception exception){
            System.err.println(Prefix.COMMAND_MAP + Prefix.ERROR + "- Method " + ((SimpleCommand) object[0]).getMethod().getName() + " wasn't correctly initialized.");
            exception.printStackTrace();
        }
    }
   
    public boolean commandUser(User user, String command, Message message) {
        Object[] object = getCommand(command);
        if(object[0] == null || ((SimpleCommand) object[0]).getExecutorType() == ExecutorType.CONSOLE) return false;
        try {
            execute(((SimpleCommand)object[0]), command,((String[])object[1]), message);
        } catch(Exception exception) {
            System.err.println(Prefix.COMMAND_MAP + Prefix.ERROR + "- Method " + ((SimpleCommand) object[0]).getMethod().getName() + " wasn't correctly initialized.");
            exception.printStackTrace();
        }
        return true;
    }
   
    private Object[] getCommand(String command){
        String[] commandSplit = command.split(" ");
        String[] args = new String[commandSplit.length-1];
        for(int i = 1; i < commandSplit.length; i++) args[i-1] = commandSplit[i];
        SimpleCommand simpleCommand = commands.get(commandSplit[0]);
        return new Object[]{simpleCommand, args};
    }
   
    private void execute(SimpleCommand simpleCommand, String command, String[] args, Message message) throws Exception, IllegalArgumentException {
        Parameter[] parameters = simpleCommand.getMethod().getParameters();
        Object[] objects = new Object[parameters.length];
        for(int i = 0; i < parameters.length; i++) {
            if(parameters[i].getType() == String[].class) objects[i] = args;
            else if(parameters[i].getType() == MessageReaction[].class) objects[i] = message == null ? null : message.getReactions();
            else if(parameters[i].getType() == Member[].class) objects[i] = message == null ? null : message.getMentionedMembers();
            else if(parameters[i].getType() == User[].class) objects[i] = message == null ? null : message.getMentionedUsers();
            else if(parameters[i].getType() == Channel[].class) objects[i] = message == null ? null : message.getMentionedChannels();
            else if(parameters[i].getType() == Role[].class) objects[i] = message == null ? null : message.getMentionedRoles();
            else if(parameters[i].getType() == Emote[].class) objects[i] = message == null ? null : message.getEmotes();
            else if(parameters[i].getType() == User.class) objects[i] = message == null ? null : message.getAuthor();
            else if(parameters[i].getType() == Member.class) objects[i] = message == null ? null : message.getMember();
            else if(parameters[i].getType() == TextChannel.class) objects[i] = message == null ? null : message.getTextChannel();
            else if(parameters[i].getType() == PrivateChannel.class) objects[i] = message == null ? null : message.getPrivateChannel();
            else if(parameters[i].getType() == Guild.class) objects[i] = message == null ? null : message.getGuild();
            else if(parameters[i].getType() == String.class) objects[i] = command;
            else if(parameters[i].getType() == Message.class) objects[i] = message;
            else if(parameters[i].getType() == JDA.class) objects[i] = FaruGamesBot.getInstance().getJDA();
            else if(parameters[i].getType() == MessageChannel.class) objects[i] = message == null ? null : message.getChannel();
        }
        simpleCommand.getMethod().invoke((Object) simpleCommand.getExecutedClass().newInstance(), objects);
    }
    
    public static Boolean isDiscordCommand(Message command) {
    	if(command.getContentDisplay().startsWith(getTag())) return true;
    	return false;
    }
}

