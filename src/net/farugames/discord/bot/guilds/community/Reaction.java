package net.farugames.discord.bot.guilds.community;

public enum Reaction {

	LANG_EN("flag_gb", null),
	LANG_FR("flag_fr", null),
	LANG_ES("flag_es", null),
	LANG_DE("flag_de", null);
	
	public String emoteName;
	public Long roleID;
	
	private Reaction(String emoteName, Long roleID) {
		this.emoteName = emoteName;
		this.roleID = roleID;
	}
	
	public String getEmoteName() {
		return this.emoteName;
	}
	
	public Long getRoleID() {
		return this.roleID;
	}
}
