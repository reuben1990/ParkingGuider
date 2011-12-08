package tenichalService.Persistence;

import java.sql.SQLException;

import tenichalService.Pojo.Park;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class SqliteOpenHelper extends OrmLiteSqliteOpenHelper{

	private static final String databaseName = "ParkingGuider.db";
	private static final int databaseVersion = 1;
	
	public SqliteOpenHelper(Context context) {
		super(context, databaseName, null, databaseVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		try {
			TableUtils.createTable(arg1, Park.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		try {
			TableUtils.dropTable(arg1, Park.class, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
