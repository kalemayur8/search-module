package com.search.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class SearchResourceTest {
	
	
	@InjectMocks
	private SearchResource searchResource;
	
	private static final String CRITERIA_01 = "/criteria?priceEUR=400";
	private static final String CRITERIA_02 = "/criteria";
	private static final String CRITERIA_03 = "/criteria?priceEUR=400&autojack=Yes";
	private static final String CRITERIA_04 = "/criteria?abc=00";
	
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(searchResource).build();

	}
	
	@Test
	public void testCriteria01() throws Exception {
		ResultActions act = this.mockMvc.perform(get(CRITERIA_01));
		act.andExpect(status().isOk());
	}
	
	@Test
	public void testCriteria02() throws Exception {
		ResultActions act = this.mockMvc.perform(get(CRITERIA_02));
		act.andExpect(status().isOk());
	}
	
	@Test
	public void testCriteria03() throws Exception {
		ResultActions act = this.mockMvc.perform(get(CRITERIA_03));
		act.andExpect(status().isOk());
	}
	
	@Test
	public void testCriteria04() throws Exception {
		ResultActions act = this.mockMvc.perform(get(CRITERIA_04));
		act.andExpect(status().isOk());
	}
	 
}
