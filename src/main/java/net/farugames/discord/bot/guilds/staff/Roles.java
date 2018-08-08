package main.java.net.farugames.discord.bot.guilds.staff;

public enum Roles {

	OWNER(457566376664498184L),
	ADMIN(457865365137915925L),
	RESP(null),
	SUPERDEV(null),
	DEV(null),
	MINIDEV(null),
	SUPERBUILDER(null),
	BUILDER(null),
	MINIBUILDER(null),
	SUPERMOD(null),
	MOD(null),
	MINIMOD(null),
	SUPERHELPER(null),
	HELPER(null),
	MINIHELPER(null),
	SUPERSTAFF(null),
	STAFF(null),
	MINISTAFF(null),
	YOUTUBER(null);
	
	public Long ID;
	
	private Roles(Long ID) {
		this.ID = ID;
	}
	
	public Long getID() {
		return this.ID;
	}
}
