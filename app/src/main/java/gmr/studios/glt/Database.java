package gmr.studios.glt;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GYLT.db";
    public static final String TABLE_TEXTEDITS = "textEdits";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEXTVALUE = "textValue";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TEXTEDITS_TABLE = "CREATE TABLE " + TABLE_TEXTEDITS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_TEXTVALUE + " TEXT" + ")";
        db.execSQL(CREATE_TEXTEDITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEXTEDITS);
        onCreate(db);
    }

    public void addTextField(String textField){

        ContentValues values = new ContentValues();
        values.put(COLUMN_TEXTVALUE, textField);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_TEXTEDITS, null, values);
        db.close();
    }
}
