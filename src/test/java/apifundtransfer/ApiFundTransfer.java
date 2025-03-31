package apifundtransfer;



	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import org.json.JSONObject;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import static io.restassured.RestAssured.given;

	public class ApiFundTransfer {

	    String baseURL = "https://banking-api.com/api";

	    @Test(priority = 1)
	    public void initiateFundTransfer() {
	        RestAssured.baseURI = baseURL;

	        JSONObject requestParams = new JSONObject();
	        requestParams.put("senderAccount", "987654321");
	        requestParams.put("receiverAccount", "123456789");
	        requestParams.put("amount", 500);
	        requestParams.put("currency", "USD");

	        Response response = given()
	                .header("Authorization", "Bearer YOUR_ACCESS_TOKEN")
	                .contentType(ContentType.JSON)
	                .body(requestParams.toString())
	                .when()
	                .post("/fund-transfer");

	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 201);
	        Assert.assertEquals(response.jsonPath().getString("status"), "success");
	    }

	    @Test(priority = 2)
	    public void verifyTransaction() {
	        RestAssured.baseURI = baseURL;

	        Response response = given()
	                .header("Authorization", "Bearer YOUR_ACCESS_TOKEN")
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/transactions/987654321");

	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertTrue(response.jsonPath().getList("transactions").size() > 0, "No Transactions Found!");
	    }
	}


