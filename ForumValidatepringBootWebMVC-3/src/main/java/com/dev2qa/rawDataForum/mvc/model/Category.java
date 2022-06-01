package com.dev2qa.rawDataForum.mvc.model;

import java.util.List;

public class Category {
	private String title;
	private Category category;
	private List<Category> children;
	public Category(String title, Category category, List<Category> children) {
		super();
		this.title = title;
		this.category = category;
		this.children = children;
	}
	public Category() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	

}
