package maccha.ParkingGuider.UI.Activity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import tenichalService.Exception.ParkException;
import tenichalService.Net.NetworkAccessor;
import tenichalService.Net.String_Pojo_Converter;
import tenichalService.Pojo.Park;
import maccha.ParkingGuider.UI.Adapter.RootFragmentAdapter;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.viewpagerindicator.TitlePageIndicator;

import Factory.Factory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

public class RootActivity extends FragmentActivity {
	
	private ViewPager viewPager;
	private TitlePageIndicator indicator;
	private RootFragmentAdapter adapter;
	public static ActionBar actionBar;
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setCurrentFragmentActivity();
        findViews();
        setListeners();
        initViewPager();
        initActionBar();
        
        //test
        /*try {
	        domain.System system = Factory.getInstance().getSystem();
	        NetworkAccessor a = Factory.getInstance().getNetworkAccessor();
	        String_Pojo_Converter converter = Factory.getInstance().getString_Pojo_Converter();
	        
	        String s = "http://172.18.43.52:3000/parkings.json?search=%E5%B9%BF%E5%B7%9E";
			String tmp = "empty";
			tmp = a.processReturnStringGet(s);
			List<Park> arr = converter.convertToParks(tmp);
			system.storedParks(arr);
			List<Park> arr1 = system.getStoredParks();
			int i =10;
			i ++;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

	private void setCurrentFragmentActivity() {
		Factory.setRootFragmentActivity(this);
	}

	private void findViews() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		indicator = (TitlePageIndicator) findViewById(R.id.indicator);
		actionBar = (ActionBar) findViewById(R.id.actionbar);
	}

	private void setListeners() {
		// TODO Auto-generated method stub
		
	}

	private void initViewPager() {
		adapter = new RootFragmentAdapter(this, getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		indicator.setViewPager(viewPager);
		viewPager.setCurrentItem(RootFragmentAdapter.PARK_LIST_FRAGMENT_PAGE);
	}
	
	private void initActionBar() {
		actionBar.addAction(new Action() {
			@Override
			public int getDrawable() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void performAction(View view) {
				// TODO Auto-generated method stub
			}
		});
	}
}