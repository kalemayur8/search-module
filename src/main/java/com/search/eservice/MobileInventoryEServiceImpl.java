package com.search.eservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.search.constant.SearchDataConstant;

/**
 * contains call for external json data service to fetch all invetory data.
 * @author Mayur Kale
 *
 */
@Service
public class MobileInventoryEServiceImpl implements MobileInvetoryEService{

	Logger LOGGER = LoggerFactory.getLogger(MobileInventoryEServiceImpl.class);
	
	@Override
	public String getMobileInventoryDataJSON() {
		LOGGER.info("Calling Inventory Data Service : {} " , SearchDataConstant.MOBILE_INVENTORY_JSON_DATA_URL);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response
		  = restTemplate.exchange(SearchDataConstant.MOBILE_INVENTORY_JSON_DATA_URL, HttpMethod.GET, null,String.class);
		return response.getBody();
	}
}
