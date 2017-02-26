package com.prk.maven.spring.hellomvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.prk.maven.spring.hellomvc.model.Product;

public class MongoApp {
	static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

	// @Autowired
	private Mongo mongo;

	public static void main(String[] args) throws Exception {
		System.out.println("MongoApp");
		System.out.println("Another comment");
		MongoApp app = new MongoApp();
		app.mongo = new MongoClient("localhost");
		app.mongoTest();
	}

	private void mongoTest() {
		MongoOperations mongoOps = new MongoTemplate(mongo, "products");
		mongoOps.insert(new Product("Model-S", "Tesla", 78000));

		System.out.println(mongoOps.findOne(new Query(Criteria.where("brand").is("Tesla")), Product.class).toString());

		mongoOps.dropCollection("products");
	}
}
