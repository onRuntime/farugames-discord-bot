package main.java.net.farugames.discord.bot.guilds.community.channels;

public enum Channel {

	WELCOME(459346803104546821L);
	
	private Long channelID;
	
	private Channel(Long channelID) {
		this.channelID = channelID;
	}
	
	public Long getID() {
		return this.channelID;
	}
}
