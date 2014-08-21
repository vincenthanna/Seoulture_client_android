package powerwaveinteractive.com.seoulture;

import android.content.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by vincenthanna on 8/20/14.
 */
public class DashboardFragment extends Fragment {

    private ListView lv;
    private ListAdapter lvAdapter;
    ArrayList<DashboardItem> dashboardItemList;
    FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dashboardItemList = new ArrayList<DashboardItem>();
        DashboardItem item;

        for (int i = 0; i < 8; i++) {
            item = new DashboardItem("DashboardFragment", "이것은 dashboard에서 온 것이다.");
            dashboardItemList.add(item);
        }

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        lv = (ListView)(rootView.findViewById(R.id.dashboard_lv));

        lvAdapter = new DashboardListAdapter(this.getActivity(),
                R.layout.dashboard_listitem_layout,
                dashboardItemList);
        lv.setAdapter(lvAdapter);
        activity = this.getActivity();
        lv.setOnItemClickListener(mItemClickListener);
        return rootView;
    }

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            Intent intent = new Intent(activity, DetailActivity.class);

            CultureItem item = dashboardItemList.get(position);
            intent.putExtra(DetailActivity.CULTURE_ITEM, item);

            startActivity(intent);

        }
    };
}

// DashboardListAdapter impl.

class DashboardItem extends CultureItem{

    DashboardItem(String title, String desc) {
        super(title, desc);
    }
}


// 어댑터 클래스
class DashboardListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<DashboardItem> src;

    public DashboardListAdapter(Context context, int layout, ArrayList<DashboardItem> src) {
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