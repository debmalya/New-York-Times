package com.deb.dao;

import static org.junit.Assert.fail;

import java.net.UnknownHostException;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.DB;
import com.mongodb.Mongo;


public class DbFactoryBeanTest {

	private static DbFactoryBean dbFactoryBean;

	@BeforeClass
	public static void  init() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("./META-INF/spring/root-context.xml");
		ctx.refresh();
		
		dbFactoryBean = ctx.getBean(DbFactoryBean.class);
	}
	@Test
	public void testGetObject() {
		
		try {
			DB dbObject = dbFactoryBean.getObject();
			Assert.assertNotNull(dbObject);
			
		} catch (Exception e) {
			Assert.assertFalse(e.getMessage(),true);
		}
	}

	@Test
	public void testGetObjectType() {
		Class<?> objectType = dbFactoryBean.getObjectType();
		Assert.assertNotNull(objectType);
		System.out.println("Type :" + objectType);
	}

	@Test
	public void testIsSingleton() {
		Assert.assertTrue(dbFactoryBean.isSingleton());
	}

	@Test
	public void testSetMongo() {
		try {
			Assert.assertNotNull(dbFactoryBean.getObject());
			Assert.assertNotNull(dbFactoryBean.getObject().getMongo());
			Assert.assertNotNull(dbFactoryBean.getObject().getMongo());
			Mongo mongo = new Mongo();
			System.out.println(mongo.getAddress());
			dbFactoryBean.setMongo(mongo);
			List<String> dbNameList = mongo.getDatabaseNames();
			if (!dbNameList.contains(dbFactoryBean.getName())) {
				DB mongoDB = dbFactoryBean.getObject();
				DB candidatedB = mongoDB.getMongo().getDB(dbFactoryBean.getName());
				System.out.println("Database Name :" + candidatedB.getName());
			}
	
			
		} catch (Exception e) {
			Assert.assertFalse(e.getMessage(),false);
		}
	}

	@Test
	public void testSetName() {
		Assert.assertNotNull(dbFactoryBean.getName());
		dbFactoryBean.setName("Candidate1");
	}

}
