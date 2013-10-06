package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {

	private Menu menu;

	@Before
	public void setUp() throws Exception {
		menu = new Menu();
		menu.setMenuId(2);
		menu.setLocationId(2);
		menu.setStation("market grill");
		menu.setCreatedAt("2013-08-19T09:15:14.000-07:00");
		menu.setUpdatedAt("2013-08-19T09:15:14.000-07:00");
	}

	@Test
	public final void testMenuGetters(){
		assertEquals(menu.getMenuId(), 2);
		assertEquals(2, menu.getLocationId());
		assertEquals("market grill", menu.getStation());
		assertEquals("2013-08-19T09:15:14.000-07:00", menu.getCreatedAt());
		assertEquals("2013-08-19T09:15:14.000-07:00", menu.getUpdatedAt());
	}

	@Test
	public final void testMenuFromJson(){
		String jsonString = "{\"id\":2," +
				"\"location_id\":2," +
				"\"station\":\"market grill\","+
				"\"created_at\":\"2013-08-19T09:15:14.000-07:00\"," +
				"\"updated_at\":\"2013-08-19T09:15:14.000-07:00\"}";
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			Menu menu2 = new Menu(json);
			assertEquals(menu, menu2);
			assertEquals(menu.hashCode(), menu2.hashCode());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
		
	}
	
	@Test
	public final void testLoadingMenuItems() {
		
		String jsonString = "[" +
				"{" +
				"\"id\": 936," +
				"\"menu_id\": 602," +
				"\"title\": \"macchi aur dahi-dhania chutni\"," +
				"\"description\": \"whitefish with cilantro-yogurt sauce and split chick pea dal with toasted coconut rice or steamed basmati rice\"," +
				"\"vegitarian\": false," +
				"\"gluten_free\": true," +
				"\"vegan\": false," +
				"\"organic\": false," +
				"\"farm_to_fork\": true," +
				"\"seafood_watch\": false," +
				"\"created_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"updated_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"rating\": 0," +
				"\"reviewers\": 0" +
				"}," +
				"{" +
				"\"id\": 937," +
				"\"menu_id\": 602," +
				"\"title\": \"paneer makhani\"," +
				"\"description\": \"farmers cheese with spiced tomato cream and split chick pea dal with toasted coconut rice or steamed basmati rice\"," +
				"\"vegitarian\": false," +
				"\"gluten_free\": true," +
				"\"vegan\": false," +
				"\"organic\": false," +
				"\"farm_to_fork\": false," +
				"\"seafood_watch\": false," +
				"\"created_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"updated_at\": \"2013-09-13T06:00:10.000-07:00\"," +
				"\"rating\": 0," +
				"\"reviewers\": 0" +
				"}" +
				"]";
		
		JSONArray jsonArray;
		try {
			assertEquals(0, menu.getCountOfMenuItems());
			jsonArray = new JSONArray(jsonString);
			menu.loadMenuItems(jsonArray);
			assertEquals(2, menu.getCountOfMenuItems());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
		
	}
	
	@Test
	public final void testEquals(){
		assertEquals(menu, menu);
		assertFalse(menu.equals(new Menu(){}));
		assertFalse(menu.equals(null));
		assertFalse(menu.equals(new Menu()));
	}
	
	@Test
	public final void testToString(){
		assertEquals("Menu [menuId=2, locationId=2, " +
				"station=market grill, " +
				"createdAt=2013-08-19T09:15:14.000-07:00, " +
				"updatedAt=2013-08-19T09:15:14.000-07:00]", 
				menu.toString());
	}
}
