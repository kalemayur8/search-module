package com.search.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.search.model.Response;

public interface SearchService {

	Response searchWithCriteria(MultiValueMap<String, List<String>> queryMap);
	
}
