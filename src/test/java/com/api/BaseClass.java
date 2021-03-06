package com.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
@@@@@@@@@@@@@#############
public class BaseClass {

		RequestSpecification reqspec;
		Response response;
		
		public String getPropertyValue(String key) throws IOException {
			Properties properties = new Properties();
			FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");

		properties.load(stream);
		Object obj = properties.get(key);
		String value = (String) obj;
		return value;
		
		}

		public void basicAuth(String userName, String password) {
			reqspec.auth().preemptive().basic(userName, password);

		}

		public void addHeader(String key, String value) {

			reqspec = RestAssured.given();
			reqspec = reqspec.header(key, value);

		}

		public void queryParam(String key, String value) {
			reqspec = reqspec.queryParam(key, value);

		}

		public void pathParam(String key, String value) {
			reqspec = reqspec.pathParam(key, value);
		}

		public void addBody(String body) {
			reqspec = reqspec.body(body);

		}

		public Response requestType(String reqType, String endpoint) {

			switch (reqType) {
			case "GET":
				response = reqspec.get();
				break;
			case "POST":
				response = reqspec.get();
				break;
			case "PUT":
				response = reqspec.get();
				break;
			case "DELETE":
				response = reqspec.get();
				break;
			default:
				break;
			}
			return response;
		}

		public int gatStatusCode(Response response) {
			int statusCode = response.getStatusCode();
			return statusCode;
		}

		public ResponseBody getBody() {
			ResponseBody body = response.getBody();
			return body;
		}

		public String getBodyAsString(Response response) {
			String asString = response.asString();
			return asString;
		}

		public String getBodyAsPretty(Response response) {
			String asPrettyString = response.asPrettyString();
			return asPrettyString;
		}
	}
