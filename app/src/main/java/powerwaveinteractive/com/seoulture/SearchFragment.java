package powerwaveinteractive.com.seoulture;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by vincenthanna on 8/21/14.
 */
public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

    private ListView lv;
    private SearchListAdapter _searchListAdapter;
    ArrayList<CultureItem> searchItemList;
    FragmentActivity activity;
    //SearchRecentSuggestions _searchSuggestion;
    MySuggestionProvider _suggestionProvider;
    SearchCultureItemAdapter _searchSuggestionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        searchItemList = new ArrayList<CultureItem>();
        CultureItem item;

        ArrayList<CultureItem> cultureArray = MainActivity.testDataStorage._cultures;
        for (int i = 0; i < cultureArray.size(); i++) {
            item = new CultureItem(cultureArray.get(i));
            searchItemList.add(item);
        }

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        lv = (ListView)(rootView.findViewById(R.id.search_lv));

        lv.setOnItemClickListener(mItemClickListener);

        _searchListAdapter = new SearchListAdapter(this.getActivity(),
                R.layout.dashboard_listitem_layout,
                searchItemList);
        lv.setAdapter(_searchListAdapter);

        activity = this.getActivity();

        _suggestionProvider = new MySuggestionProvider();
        _suggestionProvider.initDb(this.activity.getBaseContext());

        return rootView;
    }

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            Intent intent = new Intent(activity, DetailActivity.class);
            int cultureItemId = searchItemList.get(position).id;
            intent.putExtra(DetailActivity.CULTURE_ITEM_ID, cultureItemId);
            startActivity(intent);
        }
    };

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.searchfragmentmenu, menu);


        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
        searchView.setOnQueryTextListener(this);
        searchView.setIconifiedByDefault(false);

        {
            String[] args = new String[10];
            args[0] = "hello";
            args[1] = "world";
            Cursor cursor = _suggestionProvider.query(null, null, null, args, null);
            _searchSuggestionAdapter = new SearchCultureItemAdapter(activity.getBaseContext(), cursor);
            _searchSuggestionAdapter.activity = activity;
            searchView.setSuggestionsAdapter(_searchSuggestionAdapter);
            searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                @Override
                public boolean onSuggestionSelect(int i) {
                    return false;
                }

                @Override
                 public boolean onSuggestionClick(int i) {
                    // searchView를 선택한 텍스트로 변경
                    Cursor cursor = _searchSuggestionAdapter.getCursor();
                    cursor.moveToPosition(i);
                    String str = cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
                    searchView.setQuery(str, false);

                    searchListItem(str);

                    return false;
                }
            });
        }

        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {
            item.expandActionView();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void popupWindwoShow() {
        ViewGroup view = (ViewGroup)this.getView().getRootView();

        SearchSettingDialog d = new SearchSettingDialog(activity);
        d.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                SearchSettingDialog dlg = (SearchSettingDialog)dialogInterface;
                System.out.println("SearchSettingDialog closed.");
                // OK가 눌러졌을 때에만 검색필터를 갱신하고 ListView를 refresh해야 한다.
            }
        });

        d.show();
    }

    //TODO:
    void searchListItem(String str)
    {
        ArrayList<CultureItem> list = MainActivity.testDataStorage.getCultureItems(str);
        _searchListAdapter.setSource(list);
        _searchListAdapter.notifyDataSetChanged();
    }

    ////////////////////////////////////////////////////////////////////
    /// SearchView.OnQueryTextListener override functions

    // 키보드 검색 아이콘 버튼을 눌렀을때
    @Override
    public boolean onQueryTextSubmit(String s) {
        _suggestionProvider.addSuggestionStr(s);

        // 검색목록에 저장한다.
        {
            String[] args = new String[10];
            args[0] = s;
            Cursor cursor = _suggestionProvider.query(null, null, null, args, null);
            _searchSuggestionAdapter.swapCursor(cursor);
            _searchSuggestionAdapter.notifyDataSetInvalidated();

        }
        searchListItem(s);
        return true;
    }

    // Search Text내용이 변경되었을 때
    @Override
    public boolean onQueryTextChange(String s) {
        {
            String[] args = new String[10];
            args[0] = s;
            Cursor cursor = _suggestionProvider.query(null, null, null, args, null);
            _searchSuggestionAdapter.swapCursor(cursor);
        }
        if (s.length() == 0) {
            searchListItem("");
        }
        return true;
    }
    ////////////////////////////////////////////////////////////////////
}

///////////////////////////////////////////////////////////////////////////
// 어댑터 클래스
class SearchListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<CultureItem> src;

    public SearchListAdapter(Context context, int layout, ArrayList<CultureItem> src) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.src = src;
    }

    public void setSource(ArrayList<CultureItem> newSrc) {
        src = newSrc;
    }

    public int getCount() {
        return src.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // 각 항목의 view 생성
    public View getView(int position, View convertView, ViewGroup parent) {
        DashboardItemLayout layout;
        if (convertView == null) {
            convertView = new DashboardItemLayout(parent.getContext());
        }
        layout = (DashboardItemLayout)convertView;
        layout.setCultureItem(src.get(position));
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
}

///////////////////////////////////////////////////////////////////////////
// Action Bar의 Search검색에 사용할 Adapter
class SearchCultureItemAdapter extends CursorAdapter {

    public Activity activity;

    public SearchCultureItemAdapter(Context context, Cursor cursor) {
        super(context, cursor, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String str = cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
        TextView tv = (TextView)view.findViewById(R.id.tv_title);
        tv.setText(str);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        /*
        int id = cursor.getInt(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
        CultureItem item = MainActivity.testDataStorage.getCultureItemById(id);
        SuggestionItemLayout layout = new SuggestionItemLayout(context, item);
        */
        String str = cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
        SuggestionItemLayout layout = new SuggestionItemLayout(context, str);
        return layout;
    }
}