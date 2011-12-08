package maccha.ParkingGuider.UI.Adapter;

import maccha.ParkingGuider.UI.Activity.R;
import maccha.ParkingGuider.UI.Fragment.AdvertisementFragment;
import maccha.ParkingGuider.UI.Fragment.ParkListFragment;
import maccha.ParkingGuider.UI.Fragment.UploadParkFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.TitleProvider;

public class RootFragmentAdapter extends FragmentPagerAdapter implements TitleProvider {
	
	private Fragment[] pageFragments = null;
	public static final int PAGE_COUNT = 3;
	public static final int UPLOAD_FRAGMENT_PAGE = 0;
	public static final int PARK_LIST_FRAGMENT_PAGE = 1;
	public static final int ADVERTISEMENT_FRAGMENT_PAGE = 2;
	
	Context context = null;
	
	public RootFragmentAdapter(Context context, FragmentManager fm) {
		super(fm);
		this.context = context;
		pageFragments = new Fragment[PAGE_COUNT];	
		pageFragments[UPLOAD_FRAGMENT_PAGE] = new UploadParkFragment();
		pageFragments[PARK_LIST_FRAGMENT_PAGE] = new ParkListFragment();
		pageFragments[ADVERTISEMENT_FRAGMENT_PAGE] = new AdvertisementFragment();
	}
	
	@Override
	public String getTitle(int position) {
		String title = "error";
		switch(position) {
		case UPLOAD_FRAGMENT_PAGE:
			title = context.getResources().getString(R.string.upload_park);
			break;
		case PARK_LIST_FRAGMENT_PAGE:
			title = context.getResources().getString(R.string.park_list);
			break;
		case ADVERTISEMENT_FRAGMENT_PAGE:
			title = context.getResources().getString(R.string.ad);
			break;
		}
		return title;
	}

	@Override
	public Fragment getItem(int arg0) {
		return pageFragments[arg0];
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
}