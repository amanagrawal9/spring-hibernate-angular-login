package com.krew.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krew.salesforce.OAuthTokenInfo;
import com.krew.wrapper.UserInfo;

@Service
public class SalesforceService {
	private static final Logger logger = Logger.getLogger(SalesforceService.class.getName());
	
	public static final String APP_ID = "3MVG9YDQS5WtC11qtfBtItRaxAnit7bgxt61MHe2bG3Gx3fhqoCh4nvyMaZ0d8Sum9NjGw8NQTjR4kX5pwAXM";
	public static final String APP_SECRET = "4306203620848091525";

	static String accessToken = "";

	public void loginToSalesforce() {
		HttpClient client = HttpClientBuilder.create().build();
		List<NameValuePair> pairs = new ArrayList<NameValuePair> ();
		pairs.add (new BasicNameValuePair ("grant_type","password"));
		pairs.add (new BasicNameValuePair ("client_id", APP_ID));
		pairs.add (new BasicNameValuePair ("client_secret", APP_SECRET));
		pairs.add (new BasicNameValuePair ("username", "nehajain@westbrook.com"));
		pairs.add (new BasicNameValuePair ("password", "welcome@1234Xr58HyzGrUadwzrQCC7D1EtM4"));
		HttpPost post = new HttpPost("https://login.salesforce.com/services/oauth2/token");
		try {
			HttpEntity postParams = new UrlEncodedFormEntity(pairs);
			post.setHeader("Content-Type","application/x-www-form-urlencoded");
			post.setEntity(postParams);
			
			HttpResponse response = client.execute(post);
	
			System.out.println("Response Code : "
			                + response.getStatusLine().getStatusCode());
	
	
			ObjectMapper mapper = new ObjectMapper();
	
			OAuthTokenInfo tokenInfo = mapper.readValue(response.getEntity().getContent(), OAuthTokenInfo.class);
	
			accessToken = tokenInfo.getAccessToken();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JSONObject createContact(UserInfo user) {
		loginToSalesforce();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://ap4.salesforce.com/services/apexrest/UserAuth");
		JSONObject json = new JSONObject();
		json.put("ContactEmail", user.getEmail());
		json.put("ContactFirstName", user.getFirstName());
		json.put("ContactLastName", user.getLastName());
		json.put("CreateUser", "true");
		json.put("ContactPhone", user.getContactNo());
		try {
			post.addHeader("Authorization","Bearer " + accessToken);
	
			StringEntity se = new StringEntity(json.toString());
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            post.setEntity(se);
			HttpResponse response = client.execute(post);
	
			System.out.println("Response Code : "
			                + response.getStatusLine().getStatusCode());
	
			ObjectMapper mapper = new ObjectMapper();
			String responseStatus = mapper.readValue(response.getEntity().getContent(), String.class);

			JSONObject object = new JSONObject(responseStatus);
			return object;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}