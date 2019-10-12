package com.search.eservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @author Mayur Kale
 *
 */
public class MobileInventoryEServiceImplTest {
	
	@InjectMocks
	MobileInventoryEServiceImpl mobileInventoryEServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetMobileInventoryDataJSON() {
		String response = mobileInventoryEServiceImpl.getMobileInventoryDataJSON();
		assertNotNull(response);
	}
}
