package com.deb.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class JSONReaderTest {

	@Test
	public void testReadJsonFromUrl() {
		try {
			JSONObject json = JSONReader
					.readJsonFromUrl(URLConstants.NYT_SECTION_URL);
			Assert.assertNotNull(json);
			 JSONArray sectionResults = json.getJSONArray(URLConstants.RESULTS);
			Assert.assertNotNull(sectionResults);


			

		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertFalse(e.getMessage(), true);
		}
	}

}
