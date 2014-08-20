package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.*;

/**
 * Created by vincenthanna on 8/20/14.
 */
public class DashboardItemLayout extends RelativeLayout{
    private TextView _tvTitle;
    private ImageView _ivDescImg;
    private TextView _tvDescText;
    public DashboardItemLayout(Context context) {
        super(context);
        initUI(context);
    }

    public DashboardItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI(context);
    }

    public DashboardItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context);
    }

    void initUI(Context context) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.dashboard_listitem_layout, this);

        _tvTitle = (TextView) findViewById(R.id.textView_title);
        _ivDescImg = (ImageView) findViewById(R.id.imageView_pic);
        _tvDescText = (TextView) findViewById(R.id.textView_desc);
    }
}
