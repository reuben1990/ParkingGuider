package tenichalService.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import tenichalService.Exception.ParkException;

public class NetworkAccessor {
	
	public static final String UTF = "utf-8"; 
	
	public HttpResponse processPost(String basicUrl, List<NameValuePair> parameters) throws ClientProtocolException, IOException, ParkException {
		HttpPost postRequest = new HttpPost(basicUrl);  
		HttpClient client = new DefaultHttpClient();  
		HttpResponse response = null;
		
		postRequest.setEntity(new UrlEncodedFormEntity(parameters, UTF));
		response = client.execute(postRequest);
		if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return response;
		} else {
			throw new ParkException(response2String(response));
		}
	}
	
	public String processReturnStringPost(String basicUrl, List<NameValuePair> parameters) throws ClientProtocolException, IOException, ParkException {
		HttpResponse response = processPost(basicUrl, parameters);
		return response2JsonString(response);
	}
	
	public HttpResponse processGet(String url) throws ClientProtocolException, IOException, ParseException, ParkException {
		HttpGet getRequest = new HttpGet(url);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		
		response = client.execute(getRequest);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return response;
		} else {
			throw new ParkException(response2String(response));
		}
	}
	
	public String processReturnStringGet(String url) throws ClientProtocolException, ParseException, IOException, ParkException {
		HttpResponse response = processGet(url);
		return response2JsonString(response);
	}
	
	public String response2JsonString(HttpResponse response) throws IllegalStateException, IOException {
		StringBuilder builder = new StringBuilder(); 
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); 
        for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2 
                .readLine()) { 
            builder.append(s); 
        }
        return builder.toString();
	}
	
	public String response2String(HttpResponse response) throws ParseException, IOException {
		String str = EntityUtils.toString(response.getEntity());
		return str;
	}

}
