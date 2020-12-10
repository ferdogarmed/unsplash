package com.example.demo.model;

public class UnsplashModel {

	private String id;
	private String title;
	private String description;
	private UnsplashCover cover_photo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public UnsplashCover getCover_photo() {
		return cover_photo;
	}
	public void setCover_photo(UnsplashCover cover_photo) {
		this.cover_photo = cover_photo;
	}
	
}
