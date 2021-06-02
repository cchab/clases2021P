package chab.dog.basededatos.OpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLite_OpenHelper extends SQLiteOpenHelper {
    private static  final String CREATE_TABLE_USER = "CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
    public static final String DB_NAME = "DemoUser";
    public static final int DB_VERSION = 1;


    public SQLite_OpenHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openConn(){
        this.getReadableDatabase();
    }

    public void closeConn(){
        this.close();
    }
}
