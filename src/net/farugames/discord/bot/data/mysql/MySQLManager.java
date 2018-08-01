package net.farugames.discord.bot.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {

	protected final String address = "149.202.102.63";
	protected final String name = "discord";
	
	protected final Integer port = 3306;
	protected final String user = "root";
	protected final String password = "b4z5MT4Nk6hA";
	
	protected final String host = "jdbc:mysql://" + this.address + ":" + this.port + "/" + this.name;
	
	protected static Connection connection = null;
	
	protected MySQLManager() {
		this.loadDriver();
		System.out.println("Connecting database...");
		try {
			connection = DriverManager.getConnection("", this.user, this.password);
			System.out.println("Database connected !");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public void loadDriver() {
		System.out.println("Loading driver");
		try {
			Class.forName("coysql.jdbc.Driver");
			System.out.println("Driver loaded !");
		} catch (ClassNotFoundException exception) {
			throw new IllegalStateException("Cannot find the driver in the classpath !", exception);
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		if(connection == null) { System.err.println("Database already disconnected !"); return; }
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}
