package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.*;

public class ReviewListItemLayout extends RelativeLayout {

    public ReviewListItemLayout(Context context) {
        super(context);
        initUI(context);
    }

    public ReviewListItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI(context);
    }

    public ReviewListItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context);
    }

    void initUI(Context context) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.review_listitem_layout, this);
    }
}
