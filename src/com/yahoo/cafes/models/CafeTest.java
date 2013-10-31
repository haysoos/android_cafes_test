package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

public class CafeTest {

	private Cafe cafe;

	@Before
	public void setUp() throws Exception {
		cafe = Cafe.getInstance();
		
		File file = new File("assets/example_all.json");
		System.out.println(file.exists() + " " + file.getAbsolutePath());
		JSONArray jsonArray;
		String jsonString = null;
		try {
			jsonString = FileUtils.readFileToString(file);
			jsonArray = new JSONArray(jsonString);
			cafe.loadLocations(jsonArray);
			
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		} catch (IOException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
	}

	@Test
	public final void testCafeLoadFromJson() {
		assertEquals(9, cafe.getNumberOfLocations());
		assertEquals(9, cafe.getLocations().size());
	}
	
	@Test
	public final void testGetMenuItemById() {
		MenuItem menuItem = cafe.getMenuItemById(959);
		assertEquals(612, menuItem.getMenuId());
		assertEquals(959, menuItem.getMenuItemId());
		assertEquals("paneer makhani", menuItem.getTitle());	
	}
	
	@Test
	public final void testMyComment() {
		MenuItem menuItem = cafe.getMenuItemById(959);
		Comment myComment = new Comment();
		myComment.setCommentId(123);
		myComment.setMenuItemId(menuItem.getMenuItemId());
		myComment.setText("My Comment");
		myComment.setUserId(1234);
		myComment.setUsername("someuser@example.com");
		myComment.setUserRating(4);
		menuItem.addComment(myComment);
		menuItem.setMyComment(myComment);

		assertNotNull(cafe.getMenuItemById(959).getMyComment());
		
	}
	
}
