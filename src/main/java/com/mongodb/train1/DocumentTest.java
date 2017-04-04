package com.mongodb.train1;

import org.bson.Document;
import org.bson.types.ObjectId;

public class DocumentTest {

	public static void main(String[] args) {
		Document document = new Document().append("str", "MongoDB, Hello").append("objectId", new ObjectId());
		Helpers.printJson(document);
	}
}
