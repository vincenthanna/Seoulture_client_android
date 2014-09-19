package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.*;

/**
 * Created by vincenthanna on 9/19/14.
 */
public class SuggestionItemLayout  extends RelativeLayout {
    String _str;
    TextView _tvTitle;

    public SuggestionItemLayout(Context context, String str) {
        super(context);
        _str = str;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.suggestionitem_layout, this);
        initUI();
    }

    void initUI()
    {
        _tvTitle = (TextView)findViewById(R.id.tv_title);
        updateUI();
    }

    void updateUI()
    {
        _tvTitle.setText(_str);
    }

}
