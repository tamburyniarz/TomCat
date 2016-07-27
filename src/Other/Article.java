package Other;

import java.sql.Date;

public class Article {
	
	private int id;
	private String tite;
	private String text;
	private Date date;


	@Override
	public String toString() {
		return "Article [id=" + id + ", tite=" + tite + ", text=" + text + ", date=" + date + "]";
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
