package tests;

import static constants.EndPoints.*;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import config.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserAccountsTest extends BaseTest {

	public static String name = "user" + (int) (Math.random() * 10000);
	public Response response;
	public static String id;

	@Test(priority = 1)
	public void testUserCreation() {

		test = report.createTest("Create User Test");

		String requestBody = String.format("""
				    {
				      "name": "%s",
				      "job": "%s"
				    }
				""", name, ConfigManager.get("JOB"));

		response = given().contentType(ContentType.JSON).header("x-api-key", "reqres-free-v1").body(requestBody).when()
				.post(CREATE_USER).then().statusCode(201).extract().response();

		System.out.println("Response Body for create user: " + response.getBody().asString()); // helpful debug

		// print in reports.
		test.log(Status.INFO, "Response body for new user is " + response.getBody().asString());

		id = response.jsonPath().getString("id");
		System.out.println(id);
		Assert.assertNotNull(id);
		test.log(Status.PASS, "User created with ID: " + id);

		name = response.jsonPath().getString("first_name");
		Assert.assertNotNull(id);
		System.out.println("Created User FirstName" + name);
		test.log(Status.PASS, "User created with id: " + id);

	}

	@Test(priority = 2)
	public void VerifytestUserIsCreated() {

		test = report.createTest("Check user is created");

		response = given().contentType(ContentType.JSON)

				.when().get(GET_SINGLEUSER).then().statusCode(200).extract().response();

		System.out.println("Response Body to check if user present: " + response.getBody().asString()); // helpful debug

		// print in reports.
		test.log(Status.INFO, "Response body to check if user is present " + response.getBody().asString());

	}

	@Test(priority = 3)
	public void VerifyListofUsers() {

		test = report.createTest("VerifyListofUsers");

		response = given().contentType(ContentType.JSON)

				.when().get(GET_AllUSER).then().statusCode(200).extract().response();

		System.out.println("Response Body to check List of Users Listed: " + response.getBody().asString()); // helpful
																												// debug
		// print in reports.
		test.log(Status.INFO, "Response Body to check List of Users Listed " + response.getBody().asString());

	}

	@Test(priority = 4)
	public void updateUserDetails() {

		test = report.createTest("Update UserDetails hence 200");

		String body = String.format("""
				{
				  "name": "%s",
				  "job": "%s"
				}
				""", name, ConfigManager.get("JOBUPDATE"));

		response = given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(body).when()
				.put(UPDATE_USER).then().statusCode(200).extract().response();

		System.out.println("Response Body for update User: " + response.getBody().asString()); // helpful debug

		// print in reports.
		test.log(Status.INFO, "Response body for updating User Details  is " + response.getBody().asString());
	}

	@Test(priority = 5)
	public void deleteUserFromCollection() {

		test = report.createTest("Delete User");
		response = given().header("x-api-key", "reqres-free-v1").contentType("application/json").when()
				.delete(DELETE_USER).then().statusCode(204).extract().response();

		System.out.println("Response Body for delete User: " + response.getBody().asString()); // helpful debug

		// print in reports.
		test.log(Status.INFO, "Response body for deleted User " + response.getBody().asString());

		String respbody = response.getBody().asString();
		Assert.assertTrue(respbody == null || respbody.trim().isEmpty(), "Expected empty response body");

		System.out.println("DELETE response is empty as expected.");
		test.log(Status.INFO, "DELETE response is empty as expected.");
	}
}
