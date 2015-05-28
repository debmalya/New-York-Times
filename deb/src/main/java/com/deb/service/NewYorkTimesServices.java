/**
 * 
 */
package com.deb.service;

import java.util.List;

import org.json.JSONArray;

import com.deb.model.Categories;
import com.deb.model.CategoryDetails;

/**
 * @author Debmalya Jash
 * debmalya.jash@gmail.com
 *
 */
public interface NewYorkTimesServices {
	/**
	 * 
	 * @return categories of new york times.
	 */
	JSONArray getCategories();
	
	/**
	 * 
	 */
	JSONArray getCategoryDetails(JSONArray categories,int categoryIndex);
	
	/**
	 * 
	 * @return Category List.
	 */
	Categories listCategories();
	
	/**
	 * 
	 */
	List<CategoryDetails> listCategoryDetails(JSONArray categories,int categoryIndex);
	
	/**
	 * List category details for the specified section.
	 */
	List<CategoryDetails> listCategoryDetails(JSONArray categories,String section);
	
	/**
	 * List category details by section name.
	 */
	List<CategoryDetails> listCategoryDetails(String nyt_categories);
}
