package powerwaveinteractive.com.seoulture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

public class ReviewListItemLayout extends RelativeLayout {

    Context _context;
    boolean _showFull = false;
    ImageView _ivFace;
    TextView _tvName;
    RatingBar _rbRating;
    TextView _tvTitle;
    TextView _tvReview;
    ReviewItem _item;
    Activity _activity;

    public ReviewListItemLayout(Context context, Activity activity, boolean showFull) {
        super(context);
        this._context = context;
        _activity = activity;
        _showFull = showFull;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.review_listitem_layout, this);
    }

    public void setActivity(Activity activity)
    {
        this._activity = activity;
    }

    public void initUI() {
        _ivFace = (ImageView)findViewById(R.id.iv_face);
        _tvName = (TextView)findViewById(R.id.tv_name);
        _rbRating = (RatingBar)findViewById(R.id.rb_rating);
        _tvTitle = (TextView)findViewById(R.id.tv_title);
        _tvReview = (TextView)findViewById(R.id.tv_review);
        if (_showFull) {
            _tvReview.setLines(3);
        }

        if (!_showFull) {
            this.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!_showFull) {
                        reviewActivity();
                    }
                }
            });
        }
    }

    void reviewActivity() {
        Intent intent = new Intent(_activity, ReviewActivity.class);
        int cultureItemId = _item.cultureItemId;
        intent.putExtra(DetailActivity.CULTURE_ITEM_ID, cultureItemId);
        _activity.startActivity(intent);
    }

    void setReviewItem(ReviewItem item) {
        this._item = item;
        updateUI();
    }

    void updateUI() {
        _tvName.setText(_item.name);
        _rbRating.setRating((float)_item.rating);
        _tvTitle.setText(_item.title);
        _tvName.setText(_item.name);
        _tvReview.setText(_item.reviewText);
    }

}
