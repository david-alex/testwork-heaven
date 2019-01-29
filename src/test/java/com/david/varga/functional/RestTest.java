package com.david.varga.functional;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

public class RestTest {

	@Before
	public void setup() {
		RestAssured.baseURI = "http://ec2-52-31-37-213.eu-west-1.compute.amazonaws.com";

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testGetSimplePage() {
		RestAssured.get().then().statusCode(HttpStatus.SC_OK);
	}

	@Test
	public void testPostEmptyBody() {
		JsonObject jsonObject = new JsonObject();
		String responseExpected = "You have successfully deposited £ in your account. If you wish to deposit again, please select a payment method.";

		RestAssured.given().body(jsonObject).when().contentType(ContentType.JSON).post("/post").then().statusCode(HttpStatus.SC_OK)
				.body("html.body.main.div", equalToIgnoringWhiteSpace(responseExpected));
	}

	@Test
	public void testPost() {
		String responseExpected = "You have successfully deposited 22 £ in your account. If you wish to deposit again, please select a payment method.";

		RestAssured.given()
				.when()
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC))).contentType(ContentType.URLENC.withCharset("UTF-8"))
				.formParam("amount", "22").post("/post")
				.then()
				.statusCode(HttpStatus.SC_OK).body("html.body.main.div", equalToIgnoringWhiteSpace(responseExpected));

	}

	@Test
	public void testPostDecimal() {
		String responseExpected = "You have successfully deposited 22.4 £ in your account. If you wish to deposit again, please select a payment method.";

		RestAssured.given()
				.when().config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC))).contentType(ContentType.URLENC.withCharset("UTF-8"))
				.formParam("amount", "22.4").post("/post")
				.then()
				.statusCode(HttpStatus.SC_OK).body("html.body.main.div", equalToIgnoringWhiteSpace(responseExpected));

	}
}
