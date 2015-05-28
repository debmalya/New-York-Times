package com.deb.configuration;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deb.dao.DAOImpl;
import com.deb.model.Categories;
import com.deb.model.Category;
import com.deb.service.NewYorkTimesImpl;
import com.deb.service.NewYorkTimesServices;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class ApplicationConfigurationTest {

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void setUp() {
		ctx = new ClassPathXmlApplicationContext(
				"./META-INF/spring/root-context.xml");
		ctx.refresh();
	}

	@Test
	public void testDb() {
		DB db = ctx.getBean(DB.class);
		Assert.assertNotNull(db);
	}

	@Test
	public void testMongo() {
		Mongo mongo = ctx.getBean(Mongo.class);
		Assert.assertNotNull(mongo);
	}

//	@Test
	public void testCreateRetrieveObject() {
		DB db = ctx.getBean(DB.class);
		Assert.assertNotNull(db);

		DBCollection collection = db.getCollection(DAOImpl.COLLECTION_NAME);
		collection.drop();

		NewYorkTimesServices services = new NewYorkTimesImpl();
		Categories categoryDetails = services.listCategories();
		Assert.assertNotNull(categoryDetails);
		Assert.assertTrue(categoryDetails.getCategoryList().size() > 0);

		Gson gson = new Gson();
		for (int i = 0; i < categoryDetails.getCategoryList().size(); i++) {
			Category eachCategory = categoryDetails.getCategoryList().get(i);
			String section = eachCategory.getSection();
			section = section.replace(".", "");

			DBObject doc = new BasicDBObject().append(section,
					gson.toJson(eachCategory));
			collection.insert(doc);

		}

		
	}

//	@Test
	public void printAll() {
		DB db = ctx.getBean(DB.class);
		Assert.assertNotNull(db);

		DBCollection collection = db.getCollection(DAOImpl.COLLECTION_NAME);
		 DBCursor cursor = collection.find();
	        try {
	          while (cursor.hasNext()) {
	              DBObject cur = cursor.next();
	              System.out.println(cur);
	          }
	        } finally {
	            cursor.close();
	        }
	}

}
