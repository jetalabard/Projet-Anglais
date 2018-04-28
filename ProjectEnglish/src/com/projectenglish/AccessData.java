package com.projectenglish;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AccessData implements Requete{

	private SQLiteDatabase dataBase;

	private SQLiteDatabase dataBaseWritable;

	private static AccessData instance;

	private AccessData(Activity context) {
		dataBase = DataBase.getInstance(context).getDB();
		dataBaseWritable = DataBase.getInstance(context).getDBWritable();
	}

	public static AccessData getInstance(Activity context)
	{
		if(instance == null)
			instance = new AccessData(context);
		return instance;
	}
	
	@Override
	public User loadUser() {
		SQLiteDatabase db = dataBase;
		String query = "SELECT * FROM USER";
		Cursor cursor = db.rawQuery(query, null);
		User user = null;
		if (cursor.moveToFirst()) {
			try {
				do {
					user = new User(
							cursor.getInt(cursor.getColumnIndex("POINT")));
				} while (cursor.moveToNext()) ;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}

		return user;
	}
	
	@Override
	public Stat loadStat() {
		SQLiteDatabase db = dataBase;
		String query = "SELECT * FROM STAT";
		Cursor cursor = db.rawQuery(query, null);
		Stat stat = null;
		if (cursor.moveToFirst()) {
			try {
				do {
					stat = new Stat(
							cursor.getInt(cursor.getColumnIndex("NBQUESTION")),
							cursor.getInt(cursor.getColumnIndex("NBAVERAGEQUESTIONBYPART")),
							cursor.getInt(cursor.getColumnIndex("NBQUESTIONWRONG")),
							cursor.getInt(cursor.getColumnIndex("NBPART"))
							);
				} while (cursor.moveToNext()) ;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}

		return stat;
	}
	
	@Override
	public void changeStat(int NBQUESTION,int NBAVERAGEQUESTIONBYPART, int NBQUESTIONWRONG, int NBPART, int statId) {
		try{
			String strSQL = "UPDATE STAT SET NBQUESTION = "+NBQUESTION+", NBAVERAGEQUESTIONBYPART ="+NBAVERAGEQUESTIONBYPART+", NBQUESTIONWRONG = "+NBQUESTIONWRONG+" , NBPART = "+NBPART+"  WHERE ID = "+ statId;
			SQLiteDatabase db = dataBaseWritable;
			db.execSQL(strSQL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Maj loadMaj() {
		SQLiteDatabase db = dataBase;
		String query = "SELECT * FROM MAJ";
		Cursor cursor = db.rawQuery(query, null);
		Maj maj = null;
		if (cursor.moveToFirst()) {
			try {
				do {
					maj = new Maj(
							cursor.getString(cursor.getColumnIndex("TEXT")),
							cursor.getString(cursor.getColumnIndex("BUTTON")));
				} while (cursor.moveToNext()) ;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}

		return maj;
	}

	@Override
	public List<Question> loadQuestion() {
		SQLiteDatabase db = dataBase;
		String query = "SELECT * FROM QUESTION";
		Cursor cursor = db.rawQuery(query, null);
		List<Question> questions = new ArrayList<Question>();
		if (cursor.moveToFirst()) {
			try {
				do {
					questions.add(new Question(
							cursor.getInt(cursor.getColumnIndex("ID")),
							cursor.getString(cursor.getColumnIndex("QUESTION")),
							cursor.getString(cursor.getColumnIndex("REPONSE1")),
							cursor.getString(cursor.getColumnIndex("REPONSE2")),
							cursor.getString(cursor.getColumnIndex("REPONSE3")),
							cursor.getString(cursor.getColumnIndex("REPONSE4")),
							cursor.getString(cursor.getColumnIndex("REPONSEJUSTE")),
							cursor.getString(cursor.getColumnIndex("THEME")),
							cursor.getInt(cursor.getColumnIndex("POINT")),
							cursor.getInt(cursor.getColumnIndex("NIVEAU")),
							cursor.getInt(cursor.getColumnIndex("IMAGE"))
							));
				} while (cursor.moveToNext()) ;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}

		return questions;
	}
	
	@Override
	public List<Level> loadLevel() {
		SQLiteDatabase db = dataBase;
		String query = "SELECT * FROM NIVEAU";
		Cursor cursor = db.rawQuery(query, null);
		List<Level> levels = new ArrayList<Level>();
		if (cursor.moveToFirst()) {
			try {
				do {
					levels.add(new Level(
							cursor.getInt(cursor.getColumnIndex("NIVEAU")),
							cursor.getInt(cursor.getColumnIndex("MINVAL")),
							cursor.getInt(cursor.getColumnIndex("MAXVAL"))
							));
				} while (cursor.moveToNext()) ;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}

		return levels;
	}
	@Override
	public void changeUserPoint(int point,int userId) {
		try{
			String strSQL = "UPDATE USER SET POINT = "+point+" WHERE ID = "+ userId+";";
			SQLiteDatabase db = dataBaseWritable;
			db.execSQL(strSQL);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void resetInstance() {
		instance =null;
	}

}
