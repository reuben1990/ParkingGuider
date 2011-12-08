package domain;

import java.sql.SQLException;
import java.util.List;

import Factory.Factory;

import tenichalService.Persistence.DataAccessor;
import tenichalService.Pojo.Park;

public class System {
	
	private DataAccessor dataAccessor = Factory.getInstance().getDataAccessor();
	
	public void storedParks(List<Park> parks) throws SQLException {
		dataAccessor.storeParks(parks);
	}
	
	public List<Park> getStoredParks() throws SQLException {
		return dataAccessor.getStoredParks();
	}
}
