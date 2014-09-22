package powerwaveinteractive.com.seoulture;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by vincenthanna on 9/17/14.
 */
public class SearchSettingDialog extends Dialog {
    public boolean _submit = false;

    public boolean submitted() {
        return _submit;
    }

    public SearchSettingDialog(Context context) {
        super(context);
        this.setContentView(R.layout.search_setting_layout);
        initUI();
    }

    public SearchSettingDialog(Context context, int theme) {
        super(context, theme);
        this.setContentView(R.layout.search_setting_layout);
        initUI();
    }

    protected SearchSettingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.setContentView(R.layout.search_setting_layout);
        initUI();
    }

    void initUI()
    {

    }
}
