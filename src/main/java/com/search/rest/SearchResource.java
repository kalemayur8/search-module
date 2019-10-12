package com.search.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.model.Response;
import com.search.service.SearchService;

import reactor.core.publisher.Flux;

@RestController
public class SearchResource {
	
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("/criteria")
	public Flux<Response> searchWithCriteria(@RequestParam MultiValueMap<String, List<String>> queryMap) {
		return Flux.just(searchService.searchWithCriteria(queryMap));
	}
}
