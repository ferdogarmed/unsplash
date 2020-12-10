package com.example.demo.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.configuration.UnsplashConfiguration;
import com.example.demo.model.UnsplashModel;

@Service
public class UnsplashAPIConnect {
	
	@Autowired
	UnsplashConfiguration cfg;
	
	
	public List<UnsplashModel> APIConsumer() {
		
		RestTemplate restTemplate = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme(cfg.getScheme())
				.host(cfg.getHost())
				.path(cfg.getPath())
				.build();
		
		ResponseEntity<UnsplashModel[]> response = restTemplate.getForEntity(uri.toString(), UnsplashModel[].class);
		List<UnsplashModel> unsplashList = Arrays.asList(response.getBody());
		
		return unsplashList;
		
	}
		
			
	
}
