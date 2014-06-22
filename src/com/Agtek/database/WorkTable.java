package com.Agtek.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class WorkTable {
	
	// Database table
		public static final String TABLE_WORK = "work";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_PROJNAME = "projname";
		public static final String COLUMN_STARTUTC = "startUTC";
		public static final String COLUMN_STOPUTC = "stopUTC";
		
	// Database creation SQL statement
			private static final String DATABASE_CREATE = "create table " 
					+ TABLE_WORK
					+ "(" + COLUMN_ID + " integer primary key autoincrement, " 
					+ COLUMN_PROJNAME + " text not null, " 
					+ COLUMN_STARTUTC + " integer not null," 
					+ COLUMN_STOPUTC + " integer not null" + ");";

			public static void onCreate(SQLiteDatabase database) {
				database.execSQL(DATABASE_CREATE);
			}
	
			public static void onUpgrade(SQLiteDatabase database, int oldVersion,int newVersion) {
				Log.w(WorkTable.class.getName(), "Upgrading database from version "
						+ oldVersion + " to " + newVersion
						+ ", which will destroy all old data");
				database.execSQL("DROP TABLE IF EXISTS " + TABLE_WORK);
				onCreate(database);
			}

}
