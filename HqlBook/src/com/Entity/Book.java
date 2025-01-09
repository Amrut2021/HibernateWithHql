package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Bookdata")
public class Book {
	@Id
	private int b_id;
	private String bname;
	private String author;
	private int noOfPages;
	
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	@Override
	public String toString() {
		return "Book [b_id=" + b_id + ", bname=" + bname + ", author=" + author + ", noOfPages=" + noOfPages + "]";
	}
	

}
