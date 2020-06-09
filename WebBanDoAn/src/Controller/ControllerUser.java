package Controller;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.Gson;

import include.User;

public class ControllerUser {
	public boolean create(User u) throws ClientProtocolException, IOException {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(u);//chuyen obj MonAn thanh json de gui cho url khi them or sua
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://localhost:8080/serviceWebFoods/restservices/user/insert");

		StringEntity input = new StringEntity(jsonInString);
//		SysStem.out.println(jsonInString);
		input.setContentType("application/json");
		postRequest.setEntity(input);

		HttpResponse r = httpClient.execute(postRequest);
		
		//Now pull back the response object
        HttpEntity httpEntity = r.getEntity();
        String apiOutput = EntityUtils.toString(httpEntity);
         
        //Lets see what we got from API
        System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
        if (apiOutput.equals("{\\\"success\\\":1}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validate(User u) throws ClientProtocolException, IOException {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(u);//chuyen obj MonAn thanh json de gui cho url khi them or sua
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://localhost:8080/serviceWebFoods/restservices/user/authentication");

		StringEntity input = new StringEntity(jsonInString);
		System.out.println(jsonInString);
		input.setContentType("application/json");
		postRequest.setEntity(input);

		HttpResponse r = httpClient.execute(postRequest);
		
		//Now pull back the response object
        HttpEntity httpEntity = r.getEntity();
        String apiOutput = EntityUtils.toString(httpEntity);
         
        //Lets see what we got from API
        System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
        if (apiOutput.equals("{\\\"success\\\":1}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean display(User u) throws ClientProtocolException, IOException {

		Gson gson = new Gson();
		String jsonInString = gson.toJson(u);//chuyen obj MonAn thanh json de gui cho url khi them or sua
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://localhost:8080/serviceWebFoods/restservices/user/authenticationAdmin");

		StringEntity input = new StringEntity(jsonInString);
		System.out.println(jsonInString);
		input.setContentType("application/json");
		postRequest.setEntity(input);

		HttpResponse r = httpClient.execute(postRequest);
		
		//Now pull back the response object
        HttpEntity httpEntity = r.getEntity();
        String apiOutput = EntityUtils.toString(httpEntity);
         
        //Lets see what we got from API
        System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
        if (apiOutput.equals("{\\\"success\\\":1}")) {
			return true;
		} else {
			return false;
		}
	}
	
//test	
//	public static void main(String[] args) throws ClientProtocolException, IOException, JAXBException {
//	
//	         
//	    	User  u = new User("a", "a");
//	    	Gson gson = new Gson();
//			String jsonInString = gson.toJson(u);//chuyen obj MonAn thanh json de gui cho url khi them or sua
//			DefaultHttpClient httpClient = new DefaultHttpClient();
//			HttpPost postRequest = new HttpPost(
//				"http://localhost:8080/serviceWebFoods/restservices/user/authentication");
//
//			StringEntity input = new StringEntity(jsonInString);
//			input.setContentType("application/json");
//			postRequest.setEntity(input);
//
//			HttpResponse r = httpClient.execute(postRequest);
//			
//	      //Now pull back the response object
//	        HttpEntity httpEntity = r.getEntity();
//	        String apiOutput = EntityUtils.toString(httpEntity);
//	         
//	        //Lets see what we got from API
//	        System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
//	   
//	}
}
