package main.java.net.farugames.discord.bot.utils.builders;

import java.awt.Color;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.MessageEmbed.Field;

public class EmbedMessageBuilder {

	private EmbedBuilder embedBuilder = new EmbedBuilder();
	
	private String avatarUrl = null;
	private String authorName = null;
	private String authorUrl = null;
	
	private String thumbnailUrl = null;
	
	private String title = null;
	private String titleUrl = null;
	
	private String description = null;
	
	private List<Field> fields = new ArrayList<Field>();
	
	private String imageUrl = null;
	
	private String footerText = null;
	private String footerUrl = null;
	private TemporalAccessor temporalAccessor = null;
	
	private Color color = null;
	
	public EmbedMessageBuilder() {}
	
	public EmbedMessageBuilder withAuthor(String authorName) {
		this.authorName = authorName;
		return this;
	}
	
	public EmbedMessageBuilder withAuthor(String authorName, String avatarUrl) {
		this.authorName = authorName;
		this.avatarUrl = avatarUrl;
		return this;
	}
	
	public EmbedMessageBuilder withAuthor(String authorName, String avatarUrl, String authorUrl) {
		this.authorName = authorName;
		this.avatarUrl = avatarUrl;
		this.authorUrl = authorUrl;
		return this;
	}
	
	public EmbedMessageBuilder withThumbnail(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
		return this;
	}
	
	public EmbedMessageBuilder withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public EmbedMessageBuilder withTitle(String title, String titleUrl) {
		this.title = title;
		this.titleUrl = titleUrl;
		return this;
	}
	
	public EmbedMessageBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public EmbedMessageBuilder addField(Boolean inline) {
		this.fields.add(new Field(null, null, inline));
		return this;
	}
	
	public EmbedMessageBuilder addField(String fieldName, Boolean inline) {
		this.fields.add(new Field(fieldName, null, inline));
		return this;
	}
	
	public EmbedMessageBuilder addField(String fieldName, String fieldValue, Boolean inline) {
		this.fields.add(new Field(fieldName, fieldValue, inline));
		return this;
	}
	
	public EmbedMessageBuilder withImage(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	
	public EmbedMessageBuilder withFooter(String footerText) {
		this.footerText = footerText;
		return this;
	}
	
	public EmbedMessageBuilder withFooter(String footerText, String footerUrl) {
		this.footerText = footerText;
		this.footerUrl = footerUrl;
		return this;
	}
	
	public EmbedMessageBuilder withTimeStamp(TemporalAccessor temporalAccessor) {
		this.temporalAccessor = temporalAccessor;
		return this;
	}
	
	public EmbedMessageBuilder withColor(Color color) {
		this.color = color;
		return this;
	}
	
	public String getAuthorName() {return this.authorName;}
	public String getAuthorUrl() {return this.authorUrl;}
	public String getAvatarUrl() {return this.avatarUrl;}
	
	public String getThumbnailUrl() {return this.thumbnailUrl;}
	
	public String getTitle() {return this.title;}
	public String getTitleUrl() {return this.titleUrl;}
	
	public String getDescription() {return this.description;}
	
	public List<Field> getFields() {return this.fields;}
	
	public String getImageUrl() {return this.imageUrl;}
	
	public String getFooterText() {return this.footerText;}
	public String getFooterUrl() {return this.footerUrl;}
	public TemporalAccessor getTimeStamp() {return this.temporalAccessor;}
	
	public Color getColor() {return this.color;}
	
	public MessageEmbed build() {
		this.embedBuilder.setAuthor(this.getAuthorName(), this.getAuthorUrl(), this.getAvatarUrl());
		if(this.getThumbnailUrl() != null) this.embedBuilder.setThumbnail(this.getThumbnailUrl());
		if(this.getTitleUrl() != null) this.embedBuilder.setTitle(this.getTitle(), this.getTitleUrl());
		if(this.getDescription() != null) this.embedBuilder.setDescription(this.getDescription());
		for(Field field : this.fields) this.embedBuilder.addField(field);
		if(this.getImageUrl() != null) this.embedBuilder.setImage(this.imageUrl);
		this.embedBuilder.setFooter(this.getFooterText(), this.getFooterUrl());
		if(this.getTimeStamp() != null) this.embedBuilder.setTimestamp(this.getTimeStamp());
		if(this.getColor() != null) this.embedBuilder.setColor(this.getColor());
		
		return this.embedBuilder.build();
	}
}
