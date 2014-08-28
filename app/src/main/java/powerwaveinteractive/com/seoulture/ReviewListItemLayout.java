package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.*;

public class ReviewListItemLayout extends RelativeLayout {

    Context _context;
    boolean preview = false;
    ImageView _ivFace;
    TextView _tvName;
    RatingBar _rbRating;
    TextView _tvTitle;
    TextView _tvReview;
    ReviewItem _item;

    public ReviewListItemLayout(Context context) {
        super(context);
        this._context = context;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.review_listitem_layout, this);
    }

    public ReviewListItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this._context = context;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.review_listitem_layout, this);
    }

    public ReviewListItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this._context = context;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.review_listitem_layout, this);
    }

    public void initUI() {
        _ivFace = (ImageView)findViewById(R.id.iv_face);
        _tvName = (TextView)findViewById(R.id.tv_name);
        _rbRating = (RatingBar)findViewById(R.id.rb_rating);
        _tvTitle = (TextView)findViewById(R.id.tv_title);
        _tvReview = (TextView)findViewById(R.id.tv_review);
        if (preview) {
            _tvReview.setLines(3);
        }
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
