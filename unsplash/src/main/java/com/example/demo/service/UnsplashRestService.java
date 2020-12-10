package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UnsplashModel;
import com.example.demo.service.dto.UnsplashDto;

@RestController
public class UnsplashRestService {

@Autowired
UnsplashAPIConnect unsplashAPIConnect;
	
	@GetMapping(path = "/unsplash", consumes = MediaType.TEXT_PLAIN_VALUE)
	public List <UnsplashDto> data(@RequestBody String filter) {
		
		List <UnsplashModel> unsplash = unsplashAPIConnect.APIConsumer()
				.stream()
				.filter(u -> u.getId() != null && u.getId().contains(filter)
					|| u.getDescription() != null && u.getDescription().contains(filter)
					|| u.getTitle() != null && u.getTitle().contains(filter)
					|| u.getCover_photo().getId() != null && u.getCover_photo().getId().contains(filter))
				.collect(Collectors.toList());
		
		List <UnsplashDto> unsplashDto = unsplash
				.stream()
				.map(u -> new UnsplashDto(u.getId(), u.getTitle(), u.getDescription(), u.getCover_photo().getId()))
				.collect(Collectors.toList());
				
		return unsplashDto;
	}
}
