package com.yahoo.cafes.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yahoo.cafes.models.Cafe;

public class UrlsClientTest {

	@Test
	public final void testLoadingFromApi() {
		UrlsClient.getInstance().loadCafeFromApi();
		assertNotNull(Cafe.getInstance().getLocations());
		
	}

}
