package com.deb.dao;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

//@Configuration
public class DAOImpl {

	public static final String COLLECTION_NAME = "new_york_times";

	private static final Logger logger = Logger.getLogger(DAOImpl.class);

	private DbFactoryBean factoryBean;

	@Bean
	public void setDbFactoryBean(DbFactoryBean factoryBean) {
		this.factoryBean = factoryBean;

	}

	/**
	 * Save all the elements in the list into MongoDB.
	 * 
	 * @param objectList
	 *            to be saved.
	 * @return true if save is successful, RuntimeException will be thrown
	 *         otherwise.
	 */
	public boolean saveObjects(JSONArray objectList) {
		try {
			if (factoryBean != null) {
				DB db = factoryBean.getObject();
				DBCollection collection = db.getCollection(COLLECTION_NAME);

				for (int i = 0; i < objectList.length(); i++) {
					JSONObject eachCategory = (JSONObject)objectList.get(i);
					DBObject doc = new BasicDBObject().append(eachCategory.getString("section"), eachCategory);
					collection.insert(doc);
				}
			} else {
				logger.error("factoryBean is null, cannot save object");
				return false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}
}
