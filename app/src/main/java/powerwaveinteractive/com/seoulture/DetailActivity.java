package powerwaveinteractive.com.seoulture;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;


public class DetailActivity extends Activity {

    static String CULTURE_ITEM = "CULTUREITEM";
    private CultureItem _cultureItem;

    ReviewListAdapter mAdapter;
    ArrayList<ReviewItem> _reviewArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        _cultureItem = (CultureItem) getIntent().getSerializableExtra(
                CULTURE_ITEM);

        System.out.println("Received CultureItem:" + _cultureItem.title + ", " + _cultureItem.description);

        _reviewArray = new ArrayList<ReviewItem>();
        ReviewItem item;

        for (int i = 0; i < 3; i++) {
            item = new ReviewItem("리뷰 씁니다.", "이것은 " + i + " 번째 리뷰이다.", 3.0);
            _reviewArray.add(item);
        }

        ListView lv = (ListView)(findViewById(R.id.lv_review));

        mAdapter = new ReviewListAdapter(this,
                R.layout.dashboard_listitem_layout,
                _reviewArray);
        lv.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


// 어댑터 클래스
class ReviewListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<ReviewItem> src;

    public ReviewListAdapter(Context context, int layout, ArrayList<ReviewItem> src) {
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
            convertView = new ReviewListItemLayout(parent.getContext());
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