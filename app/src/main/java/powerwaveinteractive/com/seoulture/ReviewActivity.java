package powerwaveinteractive.com.seoulture;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.ScrollView;


public class ReviewActivity extends Activity {

    RelativeLayout _rootLayout;
    ReviewListLayout _reviewListLayout;
    CultureItem _cultureItem;
    ScrollView _rootScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        int cultureItemId = getIntent().getIntExtra(DetailActivity.CULTURE_ITEM_ID, 0);
        _cultureItem = MainActivity.testDataStorage.getCultureItemById(cultureItemId);

        _rootLayout = (RelativeLayout)findViewById(R.id.activity_review_layout);
        _reviewListLayout = new ReviewListLayout(this.getBaseContext(), _cultureItem);
        _rootLayout.addView(_reviewListLayout);

        _rootScrollView = (ScrollView)findViewById(R.id.sv_reviews);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.review, menu);
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


}
