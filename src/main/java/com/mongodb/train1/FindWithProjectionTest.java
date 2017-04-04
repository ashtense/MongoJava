package com.mongodb.train1;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class FindWithProjectionTest {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("course");
		MongoCollection<Document> collection = database.getCollection("findWithProjectionTest");
		collection.drop();
		for (int i = 0; i < 10; i++) {
			collection.insertOne(new Document().append("x", new Random().nextInt(2))
					.append("y", new Random().nextInt(10)).append("i", i));
		}

		Bson filter = and(eq("x", 0), gt("y", 2), lt("y", 90));

		//Bson projection = new Document("x", 0).append("_id", 0);

		Bson projection = Projections.exclude("x","_id");
		
		List<Document> into = collection.find(filter).projection(projection).into(new ArrayList<Document>());
		for (Document cur : into) {
			Helpers.printJson(cur);
		}
	}
}