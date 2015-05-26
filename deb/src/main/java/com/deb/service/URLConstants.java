/**
 * 
 */
package com.deb.service;

/**
 * @author Debmalya Jash debmalya.jash@gmail.com
 *
 */
public class URLConstants {
	
	public static final String API_KEY = "Your API Key";
	/**
	 * This URL will return all the news category in JSON format.
	 */
	public static final String NYT_SECTION_URL = "http://api.nytimes.com/svc/news/v3/content/section-list.json?api-key="+API_KEY;

	/**
	 * To retrieve JSON results.
	 */
	public static final String RESULTS = "results";

	/**
	 * First part of the details URL.
	 */
	public static final String FIRST_PART_DETAIL_URL = "http://api.nytimes.com/svc/news/v3/content/all/";

	/**
	 * Last part of the details URL. Section name will be added in the middle.
	 */
	public static final String LAST_PART_DETAIL_URL = ".json?api-key=" + API_KEY;
	
	/**
	 * To retrieve section details.
	 */
	public static final String SECTION = "section";
	
	/**
	 * To set and get details
	 */
	public static final String DETAILS = "details";

}
