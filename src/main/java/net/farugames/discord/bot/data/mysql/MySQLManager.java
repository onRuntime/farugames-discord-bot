package main.java.net.farugames.discord.bot.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.java.net.farugames.discord.bot.utils.messages.Prefix;

public class MySQLManager {
	
	protected static MySQLManager INSTANCE;

	protected final String address = "149.202.102.63";
	protected final String name = "discord";
	
	protected final Integer port = 3306;
	protected final String user = "root";
	protected final String password = "b4z5MT4Nk6hA";
	
	protected final String host = "jdbc:mysql://" + this.address + ":" + this.port + "/" + this.name + "?autoReconnect=true";
	
	protected static Connection connection = null;
	
	protected MySQLManager() {
		INSTANCE = this;
		this.loadDriver();
		System.out.println(Prefix.MYSQL_MANAGER + Prefix.INFO + getInstance().getClass().getPackage() + " - Connecting database...");
		try {
			connection = DriverManager.getConnection(this.host, this.user, this.password);
			System.out.println(Prefix.MYSQL_MANAGER + Prefix.INFO + getInstance().getClass().getPackage() + " - Database connected !");
		} catch (SQLException exception) {
			throw new IllegalStateException("Cannot connect to database !", exception);
		}
	}
	
	public void loadDriver() {
		System.out.println(Prefix.MYSQL_MANAGER + Prefix.INFO + getInstance().getClass().getPackage() + " - Loading driver...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(Prefix.MYSQL_MANAGER + Prefix.INFO + getInstance().getClass().getPackage() + " - Driver loaded !");
		} catch (ClassNotFoundException exception) {
			throw new IllegalStateException("Cannot find the driver in the classpath !", exception);
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void disconnect() {
		System.out.println(Prefix.MYSQL_MANAGER + Prefix.INFO + getInstance().getClass().getPackage() + " - Disconnecting database...");
		if(connection == null) { System.err.println(Prefix.MYSQL_MANAGER + Prefix.ERROR + getInstance().getClass().getPackage() + " - Database already disconnected !"); return; }
		try {
			connection.close();
			System.out.println(Prefix.MYSQL_MANAGER + Prefix.INFO + getInstance().getClass().getPackage() + " - Database disconnected !");
			connection = null;
		} catch (SQLException exception) {
			throw new IllegalStateException("Cannot disconnect from database !", exception);
		}
	}
	
	public static MySQLManager getInstance() {
		return INSTANCE;
	}
}
