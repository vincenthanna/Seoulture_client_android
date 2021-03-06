package powerwaveinteractive.com.seoulture;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.*;


import java.util.ArrayList;

import powerwaveinteractive.com.seoulture.CultureItem;
import powerwaveinteractive.com.seoulture.MainActivity;
import powerwaveinteractive.com.seoulture.R;
import powerwaveinteractive.com.seoulture.ReviewItem;
import powerwaveinteractive.com.seoulture.Views.BarChartView;

/**
 * Created by yeonhuikim on 2014. 9. 13..
 */
public class ReviewListLayout extends RelativeLayout {

    Context _context;
    public CultureItem _cultureItem;
    ArrayList<ReviewItem> _reviewArray;

    TextView _tvRatingAvg;
    RatingBar _rbRatingAvg;
    TextView _tvRatingTotal;
    LinearLayout _llRatingsGraph;
    ListView _lvReview;
    ReviewListAdapter _adapter;
    Activity _activity;
    boolean _showFull = true;



    public ReviewListLayout(Context context, CultureItem cultureItem, Activity activity, boolean showFull) {
        super(context);
        this._context = context;
        this._cultureItem = cultureItem;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.review_list_layout, this);
        _activity = activity;
        _showFull = showFull;
        initUI();
    }


    public void initUI() {
        _tvRatingAvg = (TextView)findViewById(R.id.ratingAvgTxt);
        _rbRatingAvg = (RatingBar)findViewById(R.id.ratingAvgBar);
        _tvRatingTotal = (TextView)findViewById(R.id.tv_ratingTotalNum);
        _llRatingsGraph = (LinearLayout)findViewById(R.id.ratingsGraph);
        _lvReview = (ListView)findViewById(R.id.lv_review);
        _lvReview.setFocusable(false); // ScrollView가 처음 열릴 때 가장 위로 가있도록 한다.

        _reviewArray = MainActivity.testDataStorage.getReviews(_cultureItem.getId());

        _adapter = new ReviewListAdapter(_context,
                R.layout.dashboard_listitem_layout,
                _reviewArray, _activity, _showFull);
        _lvReview.setAdapter(_adapter);
        _adapter.listView = _lvReview;

        updateUI();
    }

    void updateUI() {
        // rating avg
        double ratingAvg = 0;
        for (int i = 0;i < _reviewArray.size(); i++) {
            ReviewItem ri = _reviewArray.get(i);
            ratingAvg += ri.rating;
        }
        int reviewCount = _reviewArray.size() == 0 ? 1 : _reviewArray.size();
        ratingAvg /= reviewCount;
        _rbRatingAvg.setRating((float)ratingAvg);
        _tvRatingAvg.setText( String.format("%.01f", ratingAvg));
        _tvRatingTotal.setText(String.format("%d", _reviewArray.size()));
        drawChart(_llRatingsGraph);
    }

    public void drawChart(LinearLayout layout) {
        BarChartView view = new BarChartView(_context);
        int[] array = new int[6];
        for (int i = 0; i < _reviewArray.size(); i++) {
            ReviewItem reviewItem = _reviewArray.get(i);
            array[(int)Math.round(reviewItem.rating)]++;
        }
        view.setData(5, array);
        ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
        layout.addView(view);
        ViewGroup.LayoutParams viewParams = view.getLayoutParams();

        viewParams.width = layoutParams.width;
        viewParams.height = layoutParams.height;

        view.setLayoutParams(viewParams);
    }
}
