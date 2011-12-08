package test;

import java.io.IOException;
import java.util.List;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import tenichalService.Exception.ParkException;
import tenichalService.Net.NetworkAccessor;
import tenichalService.Net.String_Pojo_Converter;
import tenichalService.Pojo.Park;
import Factory.Factory;
import android.test.AndroidTestCase;
import android.util.Log;

public class TestString_Pojo_Converter extends AndroidTestCase{
	
	String_Pojo_Converter converter = null;
	NetworkAccessor networkAccessor = null;
	
	public void testConvertToParks() {
		converter = Factory.getInstance().getString_Pojo_Converter();
		networkAccessor = Factory.getInstance().getNetworkAccessor();
		List<Park> arr = null; 
		try {
			arr = converter.convertToParks(networkAccessor.processReturnStringGet("http://172.18.43.52:3000/parkings.json?search=%E5%B9%BF%E5%B7%9E"));
		} catch (ClientProtocolException e) {
			Log.v("maccha", e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			Log.v("maccha", e.getMessage());
			e.printStackTrace();
		} catch (JSONException e) {
			Log.v("maccha", e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Log.v("maccha", e.getMessage());
			e.printStackTrace();
		} catch (ParkException e) {
			Log.v("maccha", e.getMessage());
			e.printStackTrace();
		}
		Log.v("maccha", String.valueOf(arr == null));
	}

}
