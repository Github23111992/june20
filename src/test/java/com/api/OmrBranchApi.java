package com.api;


import org.testng.annotations.Test;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.response.Response;

public class OmrBranchApi extends BaseClass {
	
	

@Test
	public void getUsers() throws ParseException, IOException {
	
		//adding header
		addHeader("Content-Type","application/json");
		
		//2. auth
		basicAuth(getPropertyValue("username"),getPropertyValue("password"));
				
		//req method:
		Response response = requestType("POST", Endpoints.LOGIN);
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		String bodyAsPretty = getBodyAsPretty(response);
		System.out.println(bodyAsPretty);
		
		
		JSONParser jsonpaser = new JSONParser();
		Object parse = jsonpaser.parse(bodyAsPretty);
		JSONObject m = (JSONObject)parse;
		
		Object objdata = m.get("data");
		JSONObject objln = (JSONObject)objdata;
		
		Object om = objln.get("last_name");
		String lastname = (String)om;
		System.out.println(lastname);
		
	

	}	
		
		

	

}
