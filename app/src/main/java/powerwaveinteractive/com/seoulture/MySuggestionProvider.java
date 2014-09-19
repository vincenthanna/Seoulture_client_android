package powerwaveinteractive.com.seoulture;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by vincenthanna on 9/18/14.
 */
public class MySuggestionProvider extends SearchRecentSuggestionsProvider {

    SearchSuggestionDbHelper _dbHelper = null;
    Context _context;

    static final String TAG = MySuggestionProvider.class.getSimpleName();
    public static final String AUTHORITY = MySuggestionProvider.class
            .getName();
    public static final int MODE = DATABASE_MODE_QUERIES | DATABASE_MODE_2LINES;

    private static final String[] COLUMNS = {
            "_id", // must include this column
            SearchManager.SUGGEST_COLUMN_TEXT_1};

    public MySuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

    public void initDb(Context context){
        _context = context;
        _dbHelper = new SearchSuggestionDbHelper(_context);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        String query = selectionArgs[0];
        /*
        String query = selectionArgs[0];
        if (query == null || query.length() == 0) {
            return null;
        }
        */

        MatrixCursor cursor = new MatrixCursor(COLUMNS);

        try {
            //커서에 넘겨줄 row들을 추가한다.

            Object[] rowObjs;


            ArrayList<String> strs = _dbHelper.getSuggestionString(query);

            int id = 0;
            for (int i = 0; i < strs.size(); i++) {
                    rowObjs = createRow(id++, strs.get(i));
                    cursor.addRow(rowObjs);
            }

        } catch (Exception e) {
            Log.e(TAG, "Failed to lookup " + query, e);
        }
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    /*
    private Object[] createRow(Integer id, String text1, String text2,
                               String name) {
        return new Object[] { id, // _id
                text1, // text1
                text2, // text2
                text1, "android.intent.action.SEARCH", // action
                SearchManager.SUGGEST_NEVER_MAKE_SHORTCUT };
    }
    */

    private Object[] createRow(Integer id, String suggestionStr)
    {
        return new Object[] {id, suggestionStr};
    }

    public void addSuggestionStr(String str)
    {
        _dbHelper.addSuggestionString(str);
    }
}
