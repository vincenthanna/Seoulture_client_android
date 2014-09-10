package powerwaveinteractive.com.seoulture;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.*;
import android.widget.*;


/**
 * Created by vincenthanna on 9/2/14.
 */
public class ReviewEditorDialog extends Dialog{

    EditText _etTitle;
    TextView _tvRating;
    EditText _etDesc;
    Button _btnSubmit;
    RatingBar _rbRating;

    /*
    public String strTitle;
    public String strDesc;
    public double rating;
    */

    boolean submit = false;
    public ReviewItem _reviewItem;

    public ReviewEditorDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.review_editor_layout);
        initUI();
    }

    public ReviewEditorDialog(Context context, ReviewItem reviewItem) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.review_editor_layout);
        _reviewItem = reviewItem;
        initUI();
    }

    public ReviewEditorDialog(Context context, int theme) {
        super(context, theme);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.review_editor_layout);
        initUI();
    }

    protected ReviewEditorDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.review_editor_layout);
        initUI();
    }

    void initUI()
    {
        _etTitle = (EditText)findViewById(R.id.et_reviewTitle);
        _etDesc = (EditText)findViewById(R.id.et_reviewDesc);
        _tvRating = (TextView)findViewById(R.id.tv_rating);
        _rbRating = (RatingBar)findViewById(R.id.rb_rating);
        _btnSubmit = (Button)findViewById((R.id.btn_review_submit));
        _btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _reviewItem.setValue(_etTitle.getText().toString(),
                        _etDesc.getText().toString(),
                        _rbRating.getRating());
                submit = true;
                dismiss();
            }
        });

        _rbRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                updateRatingBarText(v);
            }
        });

        updateRatingBarText((float)_reviewItem.rating);
    }

    void updateRatingBarText(float v) {
        System.out.println("ratingBar Value=" + String.format("%f", v));
        String ratingStr[] = {"Not rated", "Poor", "Not good", "Average", "Good", "Best"};
        if (v == 0) {
            _tvRating.setText(ratingStr[0]);
        }
        else {
            _tvRating.setText(ratingStr[(int) Math.ceil(v)]);
        }
    }
}
