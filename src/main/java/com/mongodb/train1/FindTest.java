package com.mongodb.train1;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class FindTest {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("course");
		MongoCollection<Document> collection = database.getCollection("findTest");
		collection.drop();
		for(int i =0; i< 10;i++){
			collection.insertOne(new Document("x",i));
		}
		Document first = collection.find().first();
		Helpers.printJson(first);
		
		MongoCursor<Document> mongoCursor = collection.find().iterator();
		try{
			while(mongoCursor.hasNext()){
				Document cur = mongoCursor.next();
				Helpers.printJson(cur);
			}
		}finally{
			mongoCursor.close();
		}
		mongoClient.close();
	}
}
