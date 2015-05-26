/**
 * 
 */
package com.deb.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author Debmalya Jash debmalya.jash@gmail.com
 *
 */

public class DbFactoryBean implements FactoryBean<DB> {

	private Mongo mongo;
	private String name;

	@Override
	public DB getObject() throws Exception {
		Assert.notNull(mongo);
		Assert.notNull(name);
		return mongo.getDB(name);
	}

	@Override
	public Class<?> getObjectType() {
		return DB.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Required
	@Bean
	public void setMongo(Mongo mongo) {

		this.mongo = mongo;

	}

	@Required
	@Bean
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method will return the name of the database.
	 * @return database name.
	 */
	public String getName() {
		return this.name;
	}
}
