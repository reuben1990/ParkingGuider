package Factory;

import tenichalService.Net.NetworkAccessor;
import tenichalService.Net.String_Pojo_Converter;
import tenichalService.Persistence.DataAccessor;
import domain.System;
import android.app.Activity;

public class Factory {
	
	private static Activity rootFragmentActivity = null;
	private static Factory factory = null;
	
	public static synchronized Factory getInstance() {
		if(factory == null) {
			factory = new Factory();
		}
		return factory;
	}
	
	public System getSystem() {
		return new System();
	}
	
	public NetworkAccessor getNetworkAccessor() {
		return new NetworkAccessor();
	}
	
	public String_Pojo_Converter getString_Pojo_Converter() {
		return new String_Pojo_Converter();
	}
	
	public DataAccessor getDataAccessor() {
		return new DataAccessor();
	}

	public static Activity getRootFragmentActivity() {
		return rootFragmentActivity;
	}

	public static void setRootFragmentActivity(Activity rootFragmentActivity) {
		Factory.rootFragmentActivity = rootFragmentActivity;
	}
}
