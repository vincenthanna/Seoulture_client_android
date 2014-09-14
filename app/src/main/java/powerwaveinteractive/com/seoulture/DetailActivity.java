package powerwaveinteractive.com.seoulture;

import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.webkit.*;
import android.webkit.WebViewClient.*;
import android.webkit.WebSettings.*;
import android.support.v4.view.ViewPager;

import java.text.Format;
import java.util.ArrayList;

import powerwaveinteractive.com.seoulture.Views.*;
import powerwaveinteractive.com.tabsswipe.adapter.*;

public class DetailActivity extends FragmentActivity {

    static String CULTURE_ITEM = "CULTUREITEM";
    static String CULTURE_ITEM_ID = "CULTUREITEMID";
    private CultureItem _cultureItem;

    ReviewListAdapter mAdapter;
    ArrayList<ReviewItem> _reviewArray;

    TextView _tvTitle;
    ViewPager _vpTop;
    ImageView _ivSub;
    TextView _tvDescription;
    ListView _lvReviews;

    Button _btnBookmark;
    Button _btnShare;
    Button _btnLike;
    RatingBar _rbStar;
    RatingBar _rbRatingAvg;
    //WebView _wbRatingStat
    LinearLayout _ratingBarLayout;
    TextView _tvRatingAvg;
    TextView _tvReviewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int cultureItemId = getIntent().getIntExtra(CULTURE_ITEM_ID, 0);
        _cultureItem = MainActivity.testDataStorage.getCultureItemById(cultureItemId);
        _reviewArray = MainActivity.testDataStorage.getReviews(cultureItemId);

        _vpTop = (ViewPager) findViewById(R.id.detail_mainpic);
        SwipeImageViewAdapter adapter = new SwipeImageViewAdapter(getSupportFragmentManager());
        adapter.bitmaps = _cultureItem.bitmaps;
        _vpTop.setAdapter(adapter);

        _tvTitle = (TextView) findViewById(R.id.title);
        _tvDescription = (TextView) findViewById(R.id.description);
        _ivSub = (ImageView) findViewById(R.id.pic);
        _lvReviews = (ListView) (findViewById(R.id.lv_review));
        _btnBookmark = (Button)findViewById(R.id.btn_bookmark);
        _btnShare = (Button)findViewById(R.id.btn_share);
        _btnLike = (Button)findViewById(R.id.btn_like);
        _rbStar = (RatingBar)findViewById(R.id.ratingBar);
        _ratingBarLayout = (LinearLayout)findViewById(R.id.ratingsGraph);
        _tvRatingAvg = (TextView)findViewById(R.id.ratingAvgTxt);
        _tvReviewTotal = (TextView)findViewById(R.id.tv_ratingTotalNum);
        _rbRatingAvg = (RatingBar)findViewById(R.id.ratingAvgBar);
        mAdapter = new ReviewListAdapter(this,
                R.layout.dashboard_listitem_layout,
                _reviewArray);
        _lvReviews.setAdapter(mAdapter);
        mAdapter.listView = _lvReviews;

        if (_reviewArray.size() == 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getTotalHeightofListView(_lvReviews);
                }
            }, 500);
        }

        _btnBookmark.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("BtnBookmark pressed!");
            }
        });

        _btnShare.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("BtnShare pressed!");
            }
        });

        _btnLike.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("BtnLike pressed!");
            }
        });

        _rbStar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindwoShow();
            }
        });

        _rbStar.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    popupWindwoShow();
                }
                return false;
            }
        });

        updateUI();

    }

    public void drawChart(LinearLayout layout) {
        BarChartView view = new BarChartView(this);
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

    void popupWindwoShow() {
        ViewGroup view = (ViewGroup)getWindow().getDecorView().getRootView();
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.review_editor_layout, view, false);

        //FIXME: 먼저 작성한 리뷰가 있다면 찾아서 넘겨주고 그렇지 않다면 빈 것을 생성해서 넘겨준다.
        ReviewItem reviewItem = new ReviewItem(0, 0, "kim", "Hello", "Test",0.0f);

        ReviewEditorDialog d = new ReviewEditorDialog(this, reviewItem);
        d.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                ReviewEditorDialog dlg = (ReviewEditorDialog)dialogInterface;
                if (dlg.submit) {
                    System.out.println("title=" + dlg._reviewItem.title + " desc=" + dlg._reviewItem.reviewText + " rating=" +
                            String.format("%f", dlg._reviewItem.rating));
                }
            }
        });

        d.show();
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

    void updateUI()
    {
        _ivSub.setImageBitmap(_cultureItem.bitmaps.get(0));
        _tvTitle.setText(_cultureItem.title);
        _tvDescription.setText(_cultureItem.description);

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
        _tvReviewTotal.setText(String.format("%d", _reviewArray.size()));
        drawChart(_ratingBarLayout);
    }

    public static void getTotalHeightofListView(ListView listView) {
        ListAdapter mAdapter = listView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);

            mView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

            totalHeight += mView.getMeasuredHeight();
            System.out.println("HEIGHT" + String.valueOf(totalHeight));
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.deferNotifyDataSetChanged();
    }

    void reviewActivity() {
        Intent intent = new Intent(this, ReviewActivity.class);
        //int cultureItemId = dashboardItemList.get(position).getCultureItem().id;
        int cultureItemId = _cultureItem.id;
        intent.putExtra(DetailActivity.CULTURE_ITEM_ID, cultureItemId);
        startActivity(intent);
    }
}



// 어댑터 클래스
class ReviewListAdapter extends BaseAdapter {
    ListView listView;
    LayoutInflater inflater;
    ArrayList<ReviewItem> src;

    public ReviewListAdapter(Context context, int layout, ArrayList<ReviewItem> src) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.src = src;
    }

    public int getCount() {
        if (src.size() >= 3) {
            return 3;
        }
        return src.size();
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
            convertView = new ReviewListItemLayout(parent.getContext());
        }
        ReviewListItemLayout layout = (ReviewListItemLayout)convertView;
        layout.preview = true;
        layout.initUI();
        layout.setReviewItem(src.get(position));


        if (position == 0) {
            convertView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

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



