package com.yahoo.cafes.models;

import static org.junit.Assert.assertEquals;
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
	}

	@Test
	public final void testCafeLoadFromJson() {
		Assert.assertEquals(0, cafe.getNumberOfLocations());
		File file = new File("assets/example_all.json");
		System.out.println(file.exists() + " " + file.getAbsolutePath());
		JSONArray jsonArray;
		String jsonString = null;
		try {
			jsonString = FileUtils.readFileToString(file);
			jsonArray = new JSONArray(jsonString);
			cafe.loadLocations(jsonArray);
			assertEquals(9, cafe.getNumberOfLocations());
		} catch (JSONException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		} catch (IOException e) {
			fail("INVALID JSON ARRAY STRING\n\n" + jsonString + "\n\n" + e.getMessage());
		}
	}
}
