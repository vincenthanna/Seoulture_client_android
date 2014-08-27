package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
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

        searchItemList = new ArrayList<CultureItem>();
        CultureItem item;

        for (int i = 0; i < 8; i++) {
            item = new CultureItem(i, "fromSearchFragment", "이것은 SearchFragment에서 넘어온것이다.");
            searchItemList.add(item);
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
        if (convertView == null) {
            convertView = new DashboardItemLayout(parent.getContext());
        }
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