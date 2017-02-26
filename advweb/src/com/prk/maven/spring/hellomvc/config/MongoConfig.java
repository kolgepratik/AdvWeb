/**
 * 
 */
package com.prk.maven.spring.hellomvc.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author kolge
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prk.maven.spring.hellomvc")
public class MongoConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Mongo mongo() throws UnknownHostException {
		return new MongoClient("localhost");
	}

}