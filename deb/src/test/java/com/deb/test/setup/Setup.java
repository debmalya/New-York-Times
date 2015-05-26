/**
 * 
 */
package com.deb.test.setup;

import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Debmalya Jash
 * debmalya.jash@gmail.com
 *
 */
public class Setup {
	
	private static ClassPathXmlApplicationContext ctx;
	
	@BeforeClass
	public static void setUp(){
		ctx = new ClassPathXmlApplicationContext("./META-INF/spring/root-context.xml");
		ctx.refresh();
	}

	/**
	 * @return the ctx
	 */
	public static ClassPathXmlApplicationContext getCtx() {
		return ctx;
	}
	
	
}
