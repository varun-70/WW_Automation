package util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONObject;

import com.google.gson.Gson;

public class LoginApi {

	/**
	 * To get the login OTP from the API response by sending the API request
	 * 
	 * @param phNumber
	 * @return the OTP in string
	 */
	public static String getLoginCode(String phNumber) throws URISyntaxException, IOException, InterruptedException {
		LoginRequestBody loginRequest = new LoginRequestBody();
		loginRequest.setPhoneNumber(phNumber);
		Gson gson = new Gson();
		String json = gson.toJson(loginRequest);
		
		System.out.println(json);
		
		//post API request
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.dev.dubai.lotterydev.com/api/main/operations/Login"))
//				.header("Authorization", Constants.API_KEY)
				.POST(BodyPublishers.ofString(json))
				.build();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		String response = postResponse.body();
		System.out.println(response);
		
		JSONObject myResponse = new JSONObject(response);
		JSONObject code = (myResponse.getJSONObject("data").getJSONObject("Login"));
		System.out.println(code.get("code"));
		
		return code.getString("code");
	}
}

/**
 * To convert the API request text into JSON format
 */
class LoginRequestBody{
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
