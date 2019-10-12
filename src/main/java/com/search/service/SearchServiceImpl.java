package com.search.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.search.builder.JsonPathQueryBuilder;
import com.search.eservice.MobileInvetoryEService;
import com.search.model.Response;

@Service
public class SearchServiceImpl implements SearchService {
	
	Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	String mobileInventoryData;
	Object mobileInventoryparsedData;
	
	@Autowired
	MobileInvetoryEService mobileInventoryEService;
	
	/**
	 * Loading inventory data with the initialisation of this class as this data is static and should be one time gets load.
	 * 
	 */
	@PostConstruct
    private void init() {
		LOGGER.info("Loading inventory data");
		mobileInventoryData = mobileInventoryEService.getMobileInventoryDataJSON();
		mobileInventoryparsedData = Configuration.defaultConfiguration().jsonProvider().parse(mobileInventoryData);
		LOGGER.info("Inventory data loaded successfully");
    }

	@Override
	public Response searchWithCriteria(MultiValueMap<String, List<String>> queryMap) {
		Response responses = new Response();
		try {
			String jsonQuery = JsonPathQueryBuilder.buildCriteria(queryMap);
			LOGGER.info("Query formed to search from json : {} " , jsonQuery);
			responses.setResponse(JsonPath.read(mobileInventoryparsedData, jsonQuery));
			responses.setSuccess(true);
		}catch(Exception e) {
			LOGGER.error("Exception while parsing Json Data : {}" , e);
			responses.setSuccess(false);
			responses.setErrorMessage("Exception while parsing Json Data");
		}
		return responses;
	}
}
