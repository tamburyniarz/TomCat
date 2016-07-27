package Other;

import java.sql.Date;

public class Article {
	
	private String tite;
	private String text;
	private Date date;

	@Override
	public String toString() {
		return "Article [tite=" + tite + ", text=" + text + "]";
	}
	/*
	 * 
	 *  Getterss and setters
	 * 
	 */
	public String getTite() {
		return tite;
	}
	public void setTite(String tite) {
		this.tite = tite;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
