package com.sa.bean;

public class EditToDoBean {

	private Integer id;
	private String title;
	private String description;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "EditToDoBean [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	
	
}
