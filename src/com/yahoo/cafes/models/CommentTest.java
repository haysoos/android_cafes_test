package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class CommentTest {

	private Comment comment;

	@Before
	public void setUp() throws Exception {
		comment = new Comment();
		comment.setCommentId(5);
		comment.setUserId(5);
		comment.setMenuItemId(545);
		comment.setText("Comment Text 1");
		comment.setCreatedAt("2013-09-03T11:36:02.000-07:00");
		comment.setUpdatedAt("2013-09-03T11:36:02.000-07:00");
		comment.setUsername("example1@email.com");
		comment.setUserRating(2);
	}

	@Test
	public final void testCommentGetters(){
		assertEquals(5, comment.getCommentId());
		assertEquals(5, comment.getUserId());
		assertEquals(545, comment.getMenuItemId());
		assertEquals("Comment Text 1", comment.getText());
		assertEquals("2013-09-03T11:36:02.000-07:00", comment.getCreatedAt());
		assertEquals("2013-09-03T11:36:02.000-07:00", comment.getUpdatedAt());
		assertEquals("example1@email.com", comment.getUsername());
		assertEquals(2, comment.getUserRating());
	}
	
	@Test
	public final void testEquals(){
		assertEquals(comment, comment);
		assertFalse(comment.equals(new Comment(){}));
		assertFalse(comment.equals(null));
		assertFalse(comment.equals(new Comment()));
	}
	
	@Test
	public final void testCommentFromJSONObject(){
		String jsonString = "" +
				"{\"id\":5," +
				"\"user_id\":5," +
				"\"menu_item_id\":545," +
				"\"text\":\"Comment Text 1\"," +
				"\"created_at\":\"2013-09-03T11:36:02.000-07:00\"," +
				"\"updated_at\":\"2013-09-03T11:36:02.000-07:00\"," +
				"\"username\":\"example1@email.com\"," +
				"\"user_rating\":2" +
				"}";
		
		JSONObject json;
		try {
			json = new JSONObject(jsonString);
			Comment comment2 = new Comment(json);
			assertEquals(comment, comment2);
			assertEquals(comment.hashCode(), comment2.hashCode());
			
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
		
		assertEquals("Comment [commentId=5, userId=5, menuItemId=545, " +
				"text=Comment Text 1, createdAt=2013-09-03T11:36:02.000-07:00, " +
				"updatedAt=2013-09-03T11:36:02.000-07:00, " +
				"username=example1@email.com, userRating=2]", 
				comment.toString());
		
		
	}

}
