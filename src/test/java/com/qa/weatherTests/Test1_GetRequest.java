package com.qa.weatherTests;

import static com.qa.criteria.WeatherApiSelectionCriteria.*;
import static io.restassured.RestAssured.given;
import java.util.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.qa.expectedData.ExpectedData;
import com.qa.pojo.weather.groupID.ParentGroupID;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test1_GetRequest{

	@Test
	public void getWeatherDataUsingCityID() {
		
		given().
			param("id","524901").
			param("APPID", getAPIKey()).
		when().
			get(selectWeatherAPIBasedOn("forecast")).
		then().
			statusCode(200);
	}

	
	@Test
	public void getWeatherUsingCityName() {
		
		given().
			param("q","London").
			param("APPID", getAPIKey()).
		when().
			get(selectWeatherAPIBasedOn("forecast")).
		then().
			statusCode(200);
	}
	

	@Test
	public void getWeatherUsingGeographicCoordinates() {
		
		given().
			param("lat","35").param("lon","139").
			param("APPID", getAPIKey()).
		when().
			get(selectWeatherAPIBasedOn("weather")).
		then().
			statusCode(200);
		
	
	}
	
	
	@Test(testName = "getUsingGroupID")
	public void getWeatherUsingGroupID() {
		
		 Response response = given().
			param("id","524901,703448,2643743").
			param("units","metric").
			param("APPID", getAPIKey()).
		when().
			get(selectWeatherAPIBasedOn("group"));
			Gson gson = new Gson();
			 ParentGroupID parentGroupIDResponse = gson.fromJson(response.asString(), ParentGroupID.class);
			List<Integer> ids = new ArrayList<Integer>();
		    for(int i = 0 ; i < parentGroupIDResponse.getList().size() ; i++) {
			 ids.add( parentGroupIDResponse.getList().get(i).getId());
		      }
		    Assert.assertEquals(ids, ExpectedData.getExpectedSysID());
	}
	
	@Test
	public void getWeatherUsingGroupIDTest2() {
		
		 given().
			param("id","524901,703448,2643743").
			param("units","metric").
			param("APPID", getAPIKey()).
		when().
			get(selectWeatherAPIBasedOn("group")).then().assertThat().body("list.id",Matchers.equalTo(ExpectedData.getExpectedSysID()));
		 
	
	}
	
	@Test
	public void getWeatherUsingGroupIDTest3() {
		
		 given().
			param("id","524901,703448,2643743").
			param("units","metric").
			param("APPID", getAPIKey()).
		when().
			get(selectWeatherAPIBasedOn("group")).then().extract().path("list.weather.id");
		
	
	}
	
}
