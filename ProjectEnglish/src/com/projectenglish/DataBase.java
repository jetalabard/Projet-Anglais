package com.projectenglish;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 */
public class DataBase extends SQLiteOpenHelper {

	/**
	 * nom de la base
	 */
	public static final String DATABASE_NAME = "BDD_QUESTION_ENGLISH";
	/**
	 * version de la base
	 */
	private static final int DATABASE_VERSION = 1;

	private SQLiteDatabase db;
	
	private SQLiteDatabase dbWritable;
	/**
	 * instance de la classe
	 */
	private static DataBase instance;
	/**
	 * liste des tables Ã  créer
	 */

	public static DataBase getInstance(Activity context)
	{
		if(instance == null)
		{
			instance = new DataBase(context);
		}
		return instance;
	}

	
	/**
	 * constructeur
	 *
	 * @param context
	 */
	private DataBase(Activity context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		db = this.getReadableDatabase();
		dbWritable = this.getWritableDatabase();
	}	

	@Override
	public void onCreate(final SQLiteDatabase dbase) {
		
		createBase(dbase);
	}
	private void createBase(final SQLiteDatabase db) {

		for(String nameFile : URLDownLoader.getNameFileOfUrl()){
			loadCommandTo(db,nameFile);
		}
	}
	private void loadCommandTo(SQLiteDatabase db, String nameFile) {
		List<String> listCommandInsert = new LoadSQLCommand().execute(nameFile);
		db.beginTransaction();
		for(String s : listCommandInsert)
		{
			db.execSQL(s);
		}	
		db.setTransactionSuccessful();
		db.endTransaction();
	}

	public SQLiteDatabase getDB()
	{
		return db;
	}
	
	public SQLiteDatabase getDBWritable()
	{
		return dbWritable;
	}
	public static boolean isAvailable(Activity act)
	{
		File database= act.getApplicationContext().getDatabasePath(DATABASE_NAME);
		if (!database.exists()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public static void resetInstance() {
		instance = null;
		AccessData.resetInstance();
	}

}