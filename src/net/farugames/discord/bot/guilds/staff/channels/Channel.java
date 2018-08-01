package net.farugames.discord.bot.guilds.staff.channels;

public enum Channel {

	ANNOUNCEMENTS(457872493516947457L);
	
	private Long channelID;
	
	private Channel(Long channelID) {
		this.channelID = channelID;
	}
	
	public Long getID() {
		return this.channelID;
	}
}
