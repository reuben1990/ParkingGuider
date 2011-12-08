package test;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import tenichalService.Exception.ParkException;
import tenichalService.Net.NetworkAccessor;
import Factory.Factory;
import android.test.AndroidTestCase;
import android.util.Log;

public class TestNetworkAccessor extends AndroidTestCase{
	
	private NetworkAccessor a = Factory.getInstance().getNetworkAccessor();
	
	public void testProcessReturnStringGet() {
		String s = "http://172.18.43.52:3000/parkings.json?search=%E5%B9%BF%E5%B7%9E";
		String tmp = "empty";
		try {
			tmp = a.processReturnStringGet(s);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParkException e) {
			e.printStackTrace();
		}
		//Log.v("maccha", String.valueOf(tmp.length()));
	}
}
