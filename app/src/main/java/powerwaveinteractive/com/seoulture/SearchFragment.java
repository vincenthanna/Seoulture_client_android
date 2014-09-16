package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by vincenthanna on 8/21/14.
 */
public class SearchFragment extends Fragment {

    private ListView lv;
    private ListAdapter lvAdapter;
    ArrayList<CultureItem> searchItemList;
    FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        searchItemList = new ArrayList<CultureItem>();
        CultureItem item;

        searchItemList = new ArrayList<CultureItem>();
        for (int i = 0; i < searchItemList.size(); i++) {

        }

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        lv = (ListView)(rootView.findViewById(R.id.search_lv));

        lv.setOnItemClickListener(mItemClickListener);

        lvAdapter = new SearchListAdapter(this.getActivity(),
                R.layout.dashboard_listitem_layout,
                searchItemList);
        lv.setAdapter(lvAdapter);

        activity = this.getActivity();
        return rootView;
    }

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            Intent intent = new Intent(activity, DetailActivity.class);
            CultureItem item = searchItemList.get(position);
            intent.putExtra(DetailActivity.CULTURE_ITEM, item);
            startActivity(intent);

        }
    };

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.searchfragmentmenu, menu);

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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

// 어댑터 클래스
class SearchListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<CultureItem> src;

    public SearchListAdapter(Context context, int layout, ArrayList<CultureItem> src) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.src = src;
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
        layout.setCultureItem(MainActivity.testDataStorage._cultures.get(position));
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }
}