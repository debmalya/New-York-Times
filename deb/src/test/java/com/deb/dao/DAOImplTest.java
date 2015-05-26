package com.deb.dao;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import com.deb.service.NewYorkTimesImpl;
import com.deb.service.NewYorkTimesServices;
import com.deb.test.setup.Setup;

public class DAOImplTest extends Setup {

	@Test
	public void testSaveObject() {
		DAOImpl dao = super.getCtx().getBean(DAOImpl.class);
		Assert.assertNotNull(dao);
		
		
	}

}
