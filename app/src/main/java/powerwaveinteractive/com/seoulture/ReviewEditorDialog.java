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

    public ReviewEditorDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.review_editor_layout);
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
    }
}
