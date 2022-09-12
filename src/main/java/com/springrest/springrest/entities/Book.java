package com.springrest.springrest.entities;

public class Book {
	private long id;
	private String title;
	private String author;
	public Book(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = description;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public void setAuthor(String description) {
		this.author = description;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	

}
