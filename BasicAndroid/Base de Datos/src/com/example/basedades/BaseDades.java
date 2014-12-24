package com.example.basedades;

import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseDades extends SQLiteOpenHelper {

	// Métodos de SQLiteOpenHelper
    public BaseDades(Context context) {
          super(context, "texto", null, 1);
    }
   
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE textos ("+
                      "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                      "text TEXT, fecha LONG)");
  }
    @Override    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // En caso de una nueva versión habría que actualizar las tablas
    }
    
   public void guardarText (String text, long fecha) {
		 SQLiteDatabase db = getWritableDatabase();
         db.execSQL("INSERT INTO textos VALUES ( null, '"+text+"', "+fecha+")");
         db.close();
    }
		
	public Vector<String> listaXml() {
        Vector<String> result = new Vector<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT text FROM " +
         "textos ORDER BY _id ", null);
        while (cursor.moveToNext()){
                      result.add(cursor.getString(0)+" ");
         }
        cursor.close();
        db.close();
        return result;
    }
}
