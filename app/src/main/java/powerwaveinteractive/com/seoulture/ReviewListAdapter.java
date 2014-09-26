package powerwaveinteractive.com.seoulture;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

// 어댑터 클래스
class ReviewListAdapter extends BaseAdapter {
    ListView listView;
    LayoutInflater inflater;
    ArrayList<ReviewItem> src;
    boolean _showFull = true;
    Activity _activity;

    public ReviewListAdapter(Context context, int layout, ArrayList<ReviewItem> src, Activity activity, boolean showFull) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.src = src;
        this._activity = activity;
        _showFull = showFull;
    }

    public int getCount() {
        if (_showFull) {
            return src.size();
        }
        else {
            if (src.size() >= 3) {
                return 3;
            }
            return src.size();
        }
    }

    @Override
    public Object getItem(int i) {
        return src.get(i);
    }

    @Override
    public long getItemId(int i) {
        return src.get(i).id;
    }

    // 각 항목의 view 생성
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new ReviewListItemLayout(parent.getContext(), _activity, _showFull);
        }
        ReviewListItemLayout layout = (ReviewListItemLayout)convertView;
        layout.initUI();
        layout.setReviewItem(src.get(position));
        layout.setActivity(_activity);

        if (position == 0) {
            convertView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

            int height = convertView.getMeasuredHeight();
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = height * this.getCount() + (listView.getDividerHeight() * (getCount() - 1));
            listView.setLayoutParams(params);
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



