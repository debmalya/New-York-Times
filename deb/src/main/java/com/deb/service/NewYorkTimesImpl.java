/**
 * 
 */
package com.deb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.deb.model.Categories;
import com.deb.model.Category;
import com.deb.model.CategoryDetails;
import com.google.gson.Gson;

/**
 * @author Debmalya Jash debmalya.jash@gmail.com
 * 
 */
public class NewYorkTimesImpl implements NewYorkTimesServices {

	private static final Logger logger = Logger
			.getLogger(NewYorkTimesImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.deb.service.NewYorkTimesServices#getCategories()
	 */
	@Override
	public JSONArray getCategories() {
		return getJSONResult(URLConstants.NYT_SECTION_URL);
	}

	private JSONArray getJSONResult(String URL) {
		JSONArray sectionResults = null;
		try {
			JSONObject json = JSONReader.readJsonFromUrl(URL);
			sectionResults = json.getJSONArray(URLConstants.RESULTS);
		} catch (JSONException e) {
			logger.error(e.getMessage(), e);

		} catch (IOException e) {
			logger.error(e.getMessage(), e);

		}
		return sectionResults;
	}

	@Override
	public JSONArray getCategoryDetails(JSONArray categories, int categoryIndex) {
		if (categories != null && categoryIndex > -1) {
			JSONObject category = (JSONObject) categories.get(categoryIndex);
			String sectionName = (String) category.get(URLConstants.SECTION);
			if (sectionName != null) {
				sectionName = sectionName.replace(" ", "%20");
				JSONArray detailResult = getJSONResult(URLConstants.FIRST_PART_DETAIL_URL
						+ sectionName + URLConstants.LAST_PART_DETAIL_URL);
				category.append(URLConstants.DETAILS, detailResult);

			}
		}
		return categories;
	}

	@Override
	public Categories listCategories() {
		JSONArray categoriesJSONArray = getCategories();

		Gson gson = new Gson();
		Categories categoryList = new Categories();
		if (categoriesJSONArray != null && categoriesJSONArray.length() > 0)
			for (int i = 0; i < categoriesJSONArray.length(); i++) {
				JSONObject eachCategory = (JSONObject) categoriesJSONArray
						.get(i);
				Category category = gson.fromJson(eachCategory.toString(),
						Category.class);
				categoryList.getCategoryList().add(category);
			}
		return categoryList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.deb.service.NewYorkTimesServices#listCategoryDetails(org.json.JSONArray
	 * , int)
	 */
	@Override
	public List<CategoryDetails> listCategoryDetails(JSONArray categories,
			int categoryIndex) {
		List<CategoryDetails> categoryDetailList = new ArrayList<CategoryDetails>();
		if (categories != null && categoryIndex > -1) {
			JSONObject category = (JSONObject) categories.get(categoryIndex);
			String sectionName = (String) category.get(URLConstants.SECTION);
			categoryDetailList = getSectionDetails(category, sectionName);
		}

		return categoryDetailList;
	}

	private List<CategoryDetails> getSectionDetails(JSONObject category,
			String sectionName) {
		List<CategoryDetails> categoryDetailList = new ArrayList<CategoryDetails>();
		if (sectionName != null) {
			sectionName = sectionName.replace(" ", "%20");
			categoryDetailList = getCategoryDetailsBySection(sectionName);

		}
		return categoryDetailList;
	}

	private List<CategoryDetails> getCategoryDetailsBySection(String sectionName) {
		if (sectionName != null) {
			sectionName = sectionName.replace(" ", "%20");
		}
		JSONArray detailResult = getJSONResult(URLConstants.FIRST_PART_DETAIL_URL
				+ sectionName + URLConstants.LAST_PART_DETAIL_URL);

		List<CategoryDetails> categoryDetailList = new ArrayList<CategoryDetails>();

		if (detailResult != null) {
			for (int i = 0; i < detailResult.length(); i++) {

				JSONObject categoryDetailsJSON = (JSONObject) detailResult
						.get(i);

				CategoryDetails categoryDetails = new CategoryDetails();
				categoryDetails.setTitle((String) categoryDetailsJSON
						.get("abstract"));
				categoryDetails.setUrl((String) categoryDetailsJSON.get("url"));
				categoryDetailList.add(categoryDetails);

			}
		}
		return categoryDetailList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.deb.service.NewYorkTimesServices#listCategoryDetails(org.json.JSONArray
	 * , java.lang.String)
	 */
	@Override
	public List<CategoryDetails> listCategoryDetails(JSONArray categories,
			String section) {
		int index = getIndex(categories, section);
		if (index > -1) {
			return getSectionDetails((JSONObject) categories.get(index),
					section);
		} else {
			return null;
		}
	}

	/**
	 * @param categories
	 * @param section
	 * @return
	 */
	private int getIndex(JSONArray categories, String section) {
		for (int i = 0; i < categories.length(); i++) {
			JSONObject eachCategory = (JSONObject) categories.get(i);
			if (eachCategory.get("section").equals(section)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param nyt_categories
	 */
	public List<CategoryDetails> listCategoryDetails(String nyt_categories) {
		return getCategoryDetailsBySection(nyt_categories);

	}

}
