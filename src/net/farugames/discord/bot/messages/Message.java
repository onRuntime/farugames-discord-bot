package net.farugames.discord.bot.messages;

public enum Message {

	WELCOME(465142161906728960L);
	
	public Long ID;
	
	private Message(Long ID) {
		this.ID = ID;
	}
	
	public Long getID() {
		return this.ID;
	}
}
