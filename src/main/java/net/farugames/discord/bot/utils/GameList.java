package main.java.net.farugames.discord.bot.utils;

public enum GameList {

	MAINTENANCE(""),
	NORMAL("");
	
	public String game;
	
	private GameList(String game) {
		this.game = game;
	}
	
	public String getGame() {
		return this.game;
	}
}
