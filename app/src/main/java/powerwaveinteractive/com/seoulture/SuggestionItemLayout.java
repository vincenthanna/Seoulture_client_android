package powerwaveinteractive.com.seoulture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.*;

/**
 * Created by vincenthanna on 9/19/14.
 */
public class SuggestionItemLayout  extends RelativeLayout {
    CultureItem _cultureItem;

    TextView _tvTitle;
    ImageView _ivFace;

    public SuggestionItemLayout(Context context, CultureItem item) {
        super(context);
        _cultureItem = item;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.suggestionitem_layout, this);
        initUI();
    }

    void initUI()
    {
        _tvTitle = (TextView)findViewById(R.id.tv_title);
        _ivFace = (ImageView)findViewById(R.id.iv_face);
        updateUI();
    }

    void updateUI()
    {
        _tvTitle.setText(_cultureItem.getTitle());
        _ivFace.setImageBitmap(_cultureItem.bitmaps.get(0));
    }

}
