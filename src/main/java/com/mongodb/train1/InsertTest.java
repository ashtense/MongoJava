package com.mongodb.train1;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertTest {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase mongoDatabase = mongoClient.getDatabase("course");
		MongoCollection<Document> collection = mongoDatabase.getCollection("insertTest");
		collection.drop();

		Document ashwani = new Document().append("name", "Ashwani Solanki").append("age", 25).append("profession",
				"programmer");
		collection.insertOne(ashwani);
		Helpers.printJson(ashwani);
	}
}
