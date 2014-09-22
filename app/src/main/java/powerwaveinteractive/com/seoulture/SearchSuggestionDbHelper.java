package powerwaveinteractive.com.seoulture;

/**
 * Created by vincenthanna on 9/19/14.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.os.Bundle;
import android.provider.BaseColumns;

import junit.framework.Assert;

import java.util.ArrayList;

import powerwaveinteractive.com.seoulture.SearchSettingDialog;
import powerwaveinteractive.com.seoulture.SuggestionItemLayout;

public class SearchSuggestionDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "searchs.db";

    public SearchSuggestionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final class SearchStrColumns implements BaseColumns {
        public static final String TABLE_NAME = "search";
        public static final String COLUMN_NAME_SEARCH_STR = "searchstr";
    }

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + SearchStrColumns.TABLE_NAME + " (" + SearchStrColumns.COLUMN_NAME_SEARCH_STR + " TEXT" + " )";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
            + SearchStrColumns.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        arg0.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        arg0.execSQL(SQL_DELETE_ENTRIES);
        onCreate(arg0);
    }

    public void addSuggestionString(String str)
    {
        SQLiteDatabase db = getWritableDatabase();
        if (str.length() > 0) {
            // 동일한 것이 없을 경우에만 추가한다.
            String queryStr = "select * from " + SearchStrColumns.TABLE_NAME +
                    " where " + SearchStrColumns.COLUMN_NAME_SEARCH_STR + " = " + "'" + str + "'";
            System.out.println("QueryStr=" + queryStr);
            Cursor c = db.rawQuery(queryStr, null);

            if (c.getCount() == 0) {
                ContentValues values = new ContentValues();
                values.put(SearchStrColumns.COLUMN_NAME_SEARCH_STR, str);
                long rowId = db.insert(SearchStrColumns.TABLE_NAME, null, values);
                if (rowId == 0 /*number of rows affected*/) {
                    Assert.assertEquals(rowId,0);
                }
            }

            if (c != null) {
                c.close();
            }
        }
        db.close();
    }

    public ArrayList<String> getSuggestionString(String strSearch)
    {
        ArrayList<String> strArray = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + SearchStrColumns.TABLE_NAME +
                " where " + SearchStrColumns.COLUMN_NAME_SEARCH_STR + " LIKE " +
                "'%" + strSearch + "%'", null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    //int key = c.getInt(c.getColumnIndex(SearchStrColumns._ID));
                    String str = c.getString(c.getColumnIndex(SearchStrColumns.COLUMN_NAME_SEARCH_STR));
                    strArray.add(str);

                } while (c.moveToNext());
            }
            c.close();
        }
        db.close();

        return strArray;
    }
}