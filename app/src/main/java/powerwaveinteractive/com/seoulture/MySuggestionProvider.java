package powerwaveinteractive.com.seoulture;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;

/**
 * Created by vincenthanna on 9/18/14.
 */
public class MySuggestionProvider extends SearchRecentSuggestionsProvider {
    static final String TAG = MySuggestionProvider.class.getSimpleName();
    public static final String AUTHORITY = MySuggestionProvider.class
            .getName();
    public static final int MODE = DATABASE_MODE_QUERIES | DATABASE_MODE_2LINES;
    /*
    private static final String[] COLUMNS = {
            "_id", // must include this column
            SearchManager.SUGGEST_COLUMN_TEXT_1,
            SearchManager.SUGGEST_COLUMN_TEXT_2,
            SearchManager.SUGGEST_COLUMN_INTENT_DATA,
            SearchManager.SUGGEST_COLUMN_INTENT_ACTION,
            SearchManager.SUGGEST_COLUMN_SHORTCUT_ID };
            */
    private static final String[] COLUMNS = {
            "_id", // must include this column
            SearchManager.SUGGEST_COLUMN_TEXT_1};

    public MySuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
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

            int id = 0;
            for (int i = 0; i < MainActivity.testDataStorage._cultures.size(); i++) {
                //cursor.addRow(createRow(i, query, query, query));
                CultureItem item = MainActivity.testDataStorage._cultures.get(i);
                if (item.title.contains(query)) {
                    Integer cultureItemId = new Integer(MainActivity.testDataStorage._cultures.get(i).getId());
                    rowObjs = createRow(id++, cultureItemId);
                    cursor.addRow(rowObjs);
                }
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

    private Object[] createRow(Integer id, Integer cultureItemId)
    {
        return new Object[] {id, cultureItemId};
    }
}
