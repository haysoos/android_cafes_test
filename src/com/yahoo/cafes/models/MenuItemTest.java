package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

	private MenuItem menuItem;

	@Before
	public final void setUp() {
		menuItem = new MenuItem();
	}
	
	@Test
	public final void testMenuItemFromJson() {
		
		menuItem.setMenuItemId(545);
		menuItem.setMenuId(349);
		menuItem.setTitle("Field to the Fork Farm cremini mushroom frittata");
		menuItem.setDescription("with spinach, garlic and green onions");
		menuItem.setVegitarian(false);
		menuItem.setVegan(false);
		menuItem.setFarmToFork(false);
		menuItem.setSeafoodWatch(false);
		menuItem.setOrganic(true);
		menuItem.setGlutenFree(false);
		menuItem.setCreatedAt("2013-09-03T06:00:08.000-07:00");
		menuItem.setUpdatedAt("2013-09-03T20:10:28.000-07:00");
		menuItem.setNumberOfReviewers(2);
		menuItem.setRating(4.5);
		
		String jsonString = "{" +
				"\"id\":545," +
				"\"menu_id\":349," +
				"\"title\":\"Field to the Fork Farm cremini mushroom frittata\"," +
				"\"description\":\"with spinach, garlic and green onions\"," +
				"\"vegitarian\":false," +
				"\"gluten_free\":false," +
				"\"vegan\":false," +
				"\"organic\":true," +
				"\"farm_to_fork\":false," +
				"\"seafood_watch\":false," +
				"\"created_at\":\"2013-09-03T06:00:08.000-07:00\"," +
				"\"updated_at\":\"2013-09-03T20:10:28.000-07:00\"," +
				"\"rating\":4.5," +
				"\"reviewers\":2" +
				"}";
		
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			MenuItem menuItem2 = new MenuItem(json);
			assertEquals(menuItem, menuItem2);
			assertEquals(menuItem.hashCode(), menuItem2.hashCode());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
			e.printStackTrace();
		}
		
		assertEquals("MenuItem [menuItemId=545, menuId=349, " +
				"description=with spinach, garlic and green onions, " +
				"title=Field to the Fork Farm cremini mushroom frittata, " +
				"vegitarian=false, vegan=false, farmToFork=false, " +
				"seafoodWatch=false, organic=true, glutenFree=false, " +
				"rating=4.5, numberOfReviewers=2, comments=[], " +
				"createdAt=2013-09-03T06:00:08.000-07:00, " +
				"updatedAt=2013-09-03T20:10:28.000-07:00, myComment=null]", 
				menuItem.toString());
		
	}
	
	@Test
	public final void testEquals(){
		assertEquals(menuItem, menuItem);
		assertFalse(menuItem.equals(new MenuItem(){}));
		assertFalse(menuItem.equals(null));
		assertEquals(menuItem, new MenuItem());
		
	}
	
	@Test
	public final void testMenuItemId() {
		menuItem.setMenuItemId(1);
		assertEquals(1, menuItem.getMenuItemId());
	}

	@Test
	public final void testMenuId() {
		menuItem.setMenuId(2);
		assertEquals(2, menuItem.getMenuId());
	}

	@Test
	public final void testDescription() {
		String description = "Menu Item Description";
		menuItem.setDescription(description);
		assertEquals(description, menuItem.getDescription());
	}

	@Test
	public final void testTitle() {
		String title = "Menu Item Title";
		menuItem.setTitle(title);
		assertEquals(title, menuItem.getTitle());
	}

	@Test
	public final void testIsVegitarian() {
		menuItem.setVegitarian(true);
		assertEquals(true, menuItem.isVegitarian());
		
		menuItem.setVegitarian(false);
		assertEquals(false, menuItem.isVegitarian());
	}
	
	@Test
	public final void testIsVegan() {
		menuItem.setVegan(true);
		assertEquals(true, menuItem.isVegan());
		
		menuItem.setVegan(false);
		assertEquals(false, menuItem.isVegan());
	}
	
	@Test
	public final void testIsOrganic() {
		menuItem.setOrganic(true);
		assertEquals(true, menuItem.isOrganic());
		
		menuItem.setOrganic(false);
		assertEquals(false, menuItem.isOrganic());
	}
	
	@Test
	public final void testIsGlutenFree() {
		menuItem.setGlutenFree(true);
		assertEquals(true, menuItem.isGlutenFree());
		
		menuItem.setGlutenFree(false);
		assertEquals(false, menuItem.isGlutenFree());
	}

	@Test
	public final void testIsFarmToFork() {
		menuItem.setFarmToFork(true);
		assertEquals(true, menuItem.isFarmToFork());
		
		menuItem.setFarmToFork(false);
		assertEquals(false, menuItem.isFarmToFork());
	}

	@Test
	public final void testIsSeafoodWatch() {
		menuItem.setSeafoodWatch(true);
		assertEquals(true, menuItem.isSeafoodWatch());
		
		menuItem.setSeafoodWatch(false);
		assertEquals(false, menuItem.isSeafoodWatch());
	}

	@Test
	public final void testGetRating() {
		menuItem.setRating(1.234);
		assertEquals(1.234, menuItem.getRating(), 0.01);
	}

	@Test
	public final void testGetNumberOfReviewers() {
		menuItem.setNumberOfReviewers(234);
		assertEquals(234, menuItem.getNumberOfReviewers());
	}

	@Test
	public final void testGetCreatedAt() {
		String createdAt = "2013-09-03T11:36:02.000-07:00";
		menuItem.setCreatedAt(createdAt);
		assertEquals(createdAt, menuItem.getCreatedAt());
	}

	@Test
	public final void testGetUpdatedAt() {
		String updatedAt = "2013-09-03T11:36:02.000-07:00";
		menuItem.setUpdatedAt(updatedAt);
		assertEquals(updatedAt, menuItem.getUpdatedAt());
	}

	@Test
	public final void testGetMyComment() {
		Comment comment = new Comment();
		menuItem.setMyComment(comment);
		assertNotNull(menuItem.getMyComment());
		
	}
	
	@Test
	public final void testGetRatingImageName() {
		menuItem.setRating(0.1423);
		assertEquals("round_rating0_150", menuItem.getRatingImageName());
		
		menuItem.setRating(0.432);
		assertEquals("round_rating05_150", menuItem.getRatingImageName());
		
		menuItem.setRating(0.632);
		assertEquals("round_rating05_150", menuItem.getRatingImageName());
		
		menuItem.setRating(0.8432);
		assertEquals("round_rating1_150", menuItem.getRatingImageName());
		
		menuItem.setRating(1.1432);
		assertEquals("round_rating1_150", menuItem.getRatingImageName());
		
		menuItem.setRating(1.5);
		assertEquals("round_rating15_150", menuItem.getRatingImageName());
		
		menuItem.setRating(2.0);
		assertEquals("round_rating2_150", menuItem.getRatingImageName());
		
		menuItem.setRating(2.5);
		assertEquals("round_rating25_150", menuItem.getRatingImageName());
		
		menuItem.setRating(3.0);
		assertEquals("round_rating3_150", menuItem.getRatingImageName());
		
		menuItem.setRating(3.5);
		assertEquals("round_rating35_150", menuItem.getRatingImageName());
		
		menuItem.setRating(4.0);
		assertEquals("round_rating4_150", menuItem.getRatingImageName());
		
		menuItem.setRating(4.5);
		assertEquals("round_rating45_150", menuItem.getRatingImageName());
		
		menuItem.setRating(5.0);
		assertEquals("round_rating5_150", menuItem.getRatingImageName());
		
	}

	@Test
	public final void testGetRatingImageNameInWhite() {
		menuItem.setRating(0.1423);
		assertEquals("round_rating0_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(0.432);
		assertEquals("round_rating05_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(0.632);
		assertEquals("round_rating05_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(0.8432);
		assertEquals("round_rating1_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(1.1432);
		assertEquals("round_rating1_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(1.5);
		assertEquals("round_rating15_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(2.0);
		assertEquals("round_rating2_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(2.5);
		assertEquals("round_rating25_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(3.0);
		assertEquals("round_rating3_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(3.5);
		assertEquals("round_rating35_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(4.0);
		assertEquals("round_rating4_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(4.5);
		assertEquals("round_rating45_150_white", menuItem.getRatingImageNameInWhite());
		
		menuItem.setRating(5.0);
		assertEquals("round_rating5_150_white", menuItem.getRatingImageNameInWhite());
	}

	@Test
	public final void testGetStringFormattedRating() {
		
		menuItem.setRating(0.1423);
		assertEquals("0", menuItem.getStringFormattedRating());
		
		menuItem.setRating(0.432);
		assertEquals("0.5", menuItem.getStringFormattedRating());
		
		menuItem.setRating(0.632);
		assertEquals("0.5", menuItem.getStringFormattedRating());
		
		menuItem.setRating(0.8432);
		assertEquals("1", menuItem.getStringFormattedRating());
		
		menuItem.setRating(1.1432);
		assertEquals("1", menuItem.getStringFormattedRating());
		
		menuItem.setRating(1.5);
		assertEquals("1.5", menuItem.getStringFormattedRating());
		
		menuItem.setRating(2.0);
		assertEquals("2", menuItem.getStringFormattedRating());
		
		menuItem.setRating(2.5);
		assertEquals("2.5", menuItem.getStringFormattedRating());
		
		menuItem.setRating(3.0);
		assertEquals("3", menuItem.getStringFormattedRating());
		
		menuItem.setRating(3.5);
		assertEquals("3.5", menuItem.getStringFormattedRating());
		
		menuItem.setRating(4.0);
		assertEquals("4", menuItem.getStringFormattedRating());
		
		menuItem.setRating(4.5);
		assertEquals("4.5", menuItem.getStringFormattedRating());
		
		menuItem.setRating(5.0);
		assertEquals("5", menuItem.getStringFormattedRating());
		
	}

	@Test
	public final void testLoadComments() {
		assertEquals(0, menuItem.getNumberOfComments());
		
		String jsonString = "[" +
				"{\"id\":5," +
				"\"user_id\":5," +
				"\"menu_item_id\":545," +
				"\"text\":\"Comment Text 1\"," +
				"\"created_at\":\"2013-09-03T11:36:02.000-07:00\"," +
				"\"updated_at\":\"2013-09-03T11:36:02.000-07:00\"," +
				"\"username\":\"example1@email.com\",\"user_rating\":2" +
				"}," +
				"{\"id\":6," +
				"\"user_id\":4," +
				"\"menu_item_id\":546," +
				"\"text\":\"Comment Text 2.\"," +
				"\"created_at\":\"2013-09-03T11:36:02.000-07:00\"," +
				"\"updated_at\":\"2013-09-03T11:36:02.000-07:00\"," +
				"\"username\":\"example2@email.com\",\"user_rating\":1" +
				"}" +
				"]";
		try {
			JSONArray json = new JSONArray(jsonString);
			menuItem.loadComments(json);
			assertEquals(2, menuItem.getNumberOfComments());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
	}

	@Test
	public final void testAddComment() {
		assertEquals(0, menuItem.getNumberOfComments());
		
		Comment comment1 = new Comment();
		menuItem.addComment(comment1);
		assertEquals(1, menuItem.getNumberOfComments());
		
		Comment comment2 = new Comment();
		menuItem.addComment(comment2);
		assertEquals(2, menuItem.getNumberOfComments());
	}

}
