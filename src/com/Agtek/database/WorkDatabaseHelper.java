package com.Agtek.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WorkDatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "worktable.db";
	private static final int DATABASE_VERSION = 1;

	public WorkDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		CityTable.onCreate(database);
	}

	// Method is called during an upgrade of the database,
	// e.g. if you increase the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		CityTable.onUpgrade(database, oldVersion, newVersion);
	}

}
