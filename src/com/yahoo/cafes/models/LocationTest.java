package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

	private Location location;

	@Before
	public void setUp() throws Exception {
		location = new Location();
		location.setLocationId(165);
		location.setMenuDate("2013-09-13");
		location.setName("Url's Cafe");
		location.setMealtime("breakfast");
		location.setCreatedAt("2013-09-13T06:00:10.000-07:00");
		location.setUpdatedAt("2013-09-13T06:00:10.000-07:00");
	}

	@Test
	public final void testLocationGetters() {
		assertEquals(165, location.getLocationId());
		assertEquals("2013-09-13", location.getMenuDate());
		assertEquals("Url's Cafe", location.getName());
		assertEquals("breakfast", location.getMealtime());
		assertEquals("2013-09-13T06:00:10.000-07:00", location.getCreatedAt());
		assertEquals("2013-09-13T06:00:10.000-07:00", location.getUpdatedAt());
		
	}

	@Test
	public final void testLocationFromJson() {
		String jsonString = "{" +
				"\"id\": 165," +
	    "\"menu_date\": \"2013-09-13\"," +
	    "\"name\": \"Url's Cafe\"," +
	    "\"mealtime\": \"breakfast\"," +
	    "\"created_at\": \"2013-09-13T06:00:10.000-07:00\"," +
	    "\"updated_at\": \"2013-09-13T06:00:10.000-07:00\"" +
	    "}";
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			Location location2 = new Location(json);
			assertEquals(location, location2);
			assertEquals(location.hashCode(), location2.hashCode());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
	}
	
	@Test
	public final void testLoadMenus() {
		assertEquals(0, location.getNumberOfMenus());
		
		String jsonString = "[" +
				"{" +
				"\"menu\": {" +
				"\"id\": 610," +
				"\"location_id\": 167," +
				"\"station\": \"breakfast\"," +
				"\"created_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"updated_at\": \"2013-09-13T06:00:10.000-07:00\"" +
				"}," +
				"\"menu_items\": [" +
				"{" +
				"\"id\": 953," +
				"\"menu_id\": 610," +
				"\"title\": \"continental breakfast with oatmeal\"," +
				"\"description\": null," +
				"\"vegitarian\": false," +
				"\"gluten_free\": false," +
				"\"vegan\": false," +
				"\"organic\": false," +
				"\"farm_to_fork\": false," +
				"\"seafood_watch\": false," +
				"\"created_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"updated_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"rating\": 0," +
				"\"reviewers\": 0" +
				"}" +
				"]" +
				"}" +
				"]";
		
		JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(jsonString);
			location.loadMenus(jsonArray);
			assertEquals(1, location.getNumberOfMenus());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
		
	}
	
	@Test
	public final void testEquals() {
		assertEquals(location, location);
		assertFalse(location.equals(new Location(){}));
		assertFalse(location.equals(null));
		assertFalse(location.equals(new Location()));
	}
	
	@Test
	public final void testToString() {
		assertEquals("Location [locationId=165, menuDate=2013-09-13, " +
				"name=Url's Cafe, mealtime=breakfast, " +
				"createdAt=2013-09-13T06:00:10.000-07:00, " +
				"updatedAt=2013-09-13T06:00:10.000-07:00]", 
				location.toString());
	}
	
}
