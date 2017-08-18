/*******************************************
 * Copyright (c) 2017, Copyright ADP Inc.
 * All Rights Reserved.
 ******************************************/
package com.mongodb;

import java.util.Map;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;

public class Test {

	public static void main(final String[] args) {
		final String json = "{ \"a\" : { \"b\" : 1, \"c\": null, \"d\": [false, true] }, \"e\": \"f\", \"g\":2.3 }";
		final Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(json);

		System.out.println(flattenJson);
		// Output: {a.b=1, a.c=null, a.d[0]=false, a.d[1]=true, e=f, g=2.3}

		final String jsonStr = JsonFlattener.flatten(json);
		System.out.println(jsonStr);
		// Output:
		// {"a.b":1,"a.c":null,"a.d[0]":false,"a.d[1]":true,"e":"f","g":2.3}

		final String nestedJson = JsonUnflattener.unflatten(jsonStr);
		System.out.println(nestedJson);
		// {"a":{"b":1,"c":null,"d":[false,true]},"e":"f","g":2.3}

		// Support JSON keys which contain dots or square brackets
		final String flattendJsonWithDotKey = JsonFlattener.flatten("[{\"a.a.[\":1},2,{\"c\":[3,4]}]");
		System.out.println(flattendJsonWithDotKey);
		// Output: {"[0][\"a.a.[\"]":12,"[1]":2,"[2].c[0]":3,"[2].c[1]":4}

		final String nestedJsonWithDotKey = JsonUnflattener
				.unflatten("{\"[1][0];\":2,\"[0]\":1,\"[1][1]\":3,\"[2]\":4,\"[3][\\\"ab.c.[\\\"]\":5}");
		System.out.println(nestedJsonWithDotKey);
		// Output: [1,[2,3],4,{"ab.c.[":5}]
	}
}
