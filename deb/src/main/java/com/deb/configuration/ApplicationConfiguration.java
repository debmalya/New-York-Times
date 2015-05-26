package com.deb.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.mongodb.DB;
import com.mongodb.Mongo;

//@Configuration
public class ApplicationConfiguration {
	 
    @Value("${app.db.name}")
    private String appDbName;

    @Value("${db.host}")
    private String dbHost;

   @Value("${db.port}")
   private int dbPort;
   
 

   @Bean
   public DB db() throws UnknownHostException {
       return mongo().getDB(appDbName);
   }

   @Bean
   public Mongo mongo() throws UnknownHostException {
       return new Mongo(dbHost, dbPort);
   }
   

}
