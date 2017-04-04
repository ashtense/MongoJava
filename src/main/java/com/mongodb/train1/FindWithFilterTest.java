package com.mongodb.train1;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FindWithFilterTest {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("course");
		MongoCollection<Document> collection = database.getCollection("findWithFilterTest");
		collection.drop();
		for (int i = 0; i < 10; i++) {
			collection.insertOne(
					new Document().append("x", new Random().nextInt(2)).append("y", new Random().nextInt(10)));
		}

		// Bson filter = new Document("x", 0).append("y", new Document("$gt",
		// 2).append("$lt", 50));
		Bson filter = and(eq("x", 0), gt("y", 2));

		List<Document> into = collection.find(filter).into(new ArrayList<Document>());
		for (Document cur : into) {
			Helpers.printJson(cur);
		}

		long count = collection.count(filter);
		System.out.println("Count is " + count);
		mongoClient.close();
	}
}
