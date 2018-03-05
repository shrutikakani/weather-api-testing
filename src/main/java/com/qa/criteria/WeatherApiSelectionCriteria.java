package com.qa.criteria;

import java.io.BufferedReader;

import com.qa.Base.TestBase;

public class WeatherApiSelectionCriteria extends TestBase{
	
	
		static BufferedReader reader ;
	
	
	public static String selectWeatherAPIBasedOn(String parameter) {
		String ApiUrl = properties.getProperty("HistoricalDataBaseURL").replaceAll("PARA_1",parameter);
		return ApiUrl;
	}
	
	public static String getAPIKey() {
		String Apikey =  properties.getProperty("APIKEY");
		return Apikey;
	}
	
	
	/*public static String convertJSONintoString(String fileName) {
		JSONParser parser = new JSONParser();
		String jsonString = "";
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\expectedData\\"+fileName+".txt"));
			JSONObject jSONObject=  (JSONObject)parser.parse(reader);
		    jsonString = jSONObject.toString();
			//System.out.println(jsonString);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonString ;
	}*/

}
