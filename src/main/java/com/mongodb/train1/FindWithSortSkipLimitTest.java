package com.mongodb.train1;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class FindWithSortSkipLimitTest {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("course");
		MongoCollection<Document> collection = database.getCollection("findWithProjectionTest");
		collection.drop();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				collection.insertOne(new Document().append("i", i).append("j", j));

			}
		}
		Bson projection = Projections.excludeId();

		// Bson sort = new Document("i",1).append("j", -1);
		Bson sort = Sorts.orderBy(Sorts.ascending("i"), Sorts.descending("j"));

		List<Document> into = collection.find().sort(sort).limit(1).projection(projection)
				.into(new ArrayList<Document>());
		for (Document cur : into) {
			Helpers.printJson(cur);
		}
	}
}
