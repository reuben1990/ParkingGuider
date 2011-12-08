package tenichalService.Persistence;

import java.sql.SQLException;
import java.util.List;

import Factory.Factory;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import tenichalService.Pojo.Park;

public class DataAccessor {
	
	OrmLiteSqliteOpenHelper openHelper = null;
	Dao<Park, String> parkDao = null;
	
	public DataAccessor() {
		openHelper = OpenHelperManager.getHelper(Factory.getRootFragmentActivity(), SqliteOpenHelper.class);
	}
	
	public List<Park> getStoredParks() throws SQLException {
		checkParkDao();
		return  parkDao.queryForAll();
	}
	
	public void storeParks(List<Park> parks) throws SQLException {
		checkParkDao();
		parkDao = openHelper.getDao(Park.class);
		for(Park park : parks) {
			parkDao.createIfNotExists(park);
		}
	}
	
	private void checkParkDao() throws SQLException {
		if(parkDao == null) {
			parkDao = openHelper.getDao(Park.class);
		}
	}
}
