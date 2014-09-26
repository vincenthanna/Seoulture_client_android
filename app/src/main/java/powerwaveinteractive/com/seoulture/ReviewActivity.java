package powerwaveinteractive.com.seoulture;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
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
        getActionBar().setDisplayHomeAsUpEnabled(true);

        int cultureItemId = getIntent().getIntExtra(DetailActivity.CULTURE_ITEM_ID, 0);
        _cultureItem = MainActivity.testDataStorage.getCultureItemById(cultureItemId);

        _rootLayout = (RelativeLayout)findViewById(R.id.activity_review_layout);
        _reviewListLayout = new ReviewListLayout(this.getBaseContext(), _cultureItem, this, true);
        _rootLayout.addView(_reviewListLayout);

        _rootScrollView = (ScrollView)findViewById(R.id.sv_reviews);

        setTitle(_cultureItem.getTitle());
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

        switch(id) {
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);

                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                                    // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
