package com.deb.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.deb.model.Categories;
import com.deb.model.Category;
import com.deb.model.CategoryDetails;
import com.google.gson.Gson;

public class NewYorkTimesServicesTest {

	private JSONArray categoryDetails;

	@Test
	public void testGetCategories() {
		NewYorkTimesServices services = new NewYorkTimesImpl();
		categoryDetails = services.getCategories();
		Assert.assertNotNull(categoryDetails);
		Assert.assertTrue(categoryDetails.length() > 0);

		Gson gson = new Gson();
		Categories categoryList = new Categories();
		for (int i = 0; i < categoryDetails.length(); i++) {
			JSONObject eachCategory = (JSONObject) categoryDetails.get(i);
			// System.out.println(eachCategory.toString());
			Category category = gson.fromJson(eachCategory.toString(),
					Category.class);
			Assert.assertNotNull(category);
			// System.out.println(category);
			categoryList.getCategoryList().add(category);
		}
	}

	@Test
	public void testGetCategoryDetails() {
		NewYorkTimesServices services = new NewYorkTimesImpl();
		categoryDetails = services.getCategories();
		Assert.assertNotNull(categoryDetails);
		Assert.assertTrue(categoryDetails.length() > 0);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignore) {
			// API can support one call in one second. That's why added this
			// sleep.
		}
		services = new NewYorkTimesImpl();
		int randomIndex = (int) (Math.random() * categoryDetails.length());
		JSONObject details = (JSONObject) categoryDetails.get(randomIndex);
		//
		try {
			details.get(URLConstants.DETAILS);
		} catch (JSONException exc) {
			Assert.assertTrue("Details not set,  should have exception", true);
		}
		services.getCategoryDetails(categoryDetails, randomIndex);

		details = (JSONObject) categoryDetails.get(randomIndex);
		try {
			JSONArray detailObject = (JSONArray) details
					.get(URLConstants.DETAILS);
			Assert.assertTrue("Details set,  should not have exception", true);
//			Gson gson = new Gson();
			for (int i = 0; i < detailObject.length(); i++) {
				JSONArray object = (JSONArray) detailObject.get(i);
				for (int j = 0; j < object.length(); j++) {
					

					JSONObject categoryDetails = (JSONObject) object.get(j);
					System.out.println(categoryDetails.get("url")+ " : " + categoryDetails.get("abstract"));
					
					
				}
			}
		} catch (JSONException exc) {
			exc.printStackTrace();
			Assert.assertTrue("Details set,  should not have exception", false);
		}

	}

	@Test
	public void testListCategories() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignore) {
			// API can support one call in one second. That's why added this
			// sleep.
		}
		NewYorkTimesServices services = new NewYorkTimesImpl();
		Categories categories = services.listCategories();
		Assert.assertNotNull(categories);
		Assert.assertNotNull(categories.getCategoryList());
		Assert.assertTrue(categories.getCategoryList().size() > 0);
	}

}
