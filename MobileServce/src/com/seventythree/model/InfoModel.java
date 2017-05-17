package com.seventythree.model;



public class InfoModel {
	int id;//自增 可不设置
	String name; //不能为空
	String title;//不能为空
	String author;//不能为空
	String date;//不能为空
	String content;
	String images;
//	DatatypeConverter
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "InfoModel [name=" + name + ", title=" + title + ", author=" + author + ", date=" + date + ", content="
				+ content + ", images=" + images + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
}
