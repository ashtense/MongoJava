package com.mongodb.train1;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("video").withReadPreference(ReadPreference.secondary());
		MongoCollection<Document> collection = database.getCollection("movies");
		FindIterable<Document> find = collection.find();
		for(Document document: find){
			System.out.println(document.toString());
		}
		mongoClient.close();
	}
}