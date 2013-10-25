package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetters() {
		JSONObject json = new JSONObject();
		try {
			json.put("username", "myUsername@yahoo.com");
			json.put("id", 3);
			json.put("token", "somereallylongtoken");
			User.getInstance().loadFromJson(json);
			
			assertEquals("myUsername@yahoo.com", User.getInstance().getUsername());
			assertEquals(3, User.getInstance().getUserId());
			assertEquals("somereallylongtoken", User.getInstance().getToken());
			
		} catch (JSONException e) {
			fail(e.getMessage());
		}
	}

}
