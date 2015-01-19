package crm.gobelins.helloandroid.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import crm.gobelins.helloandroid.R;
import crm.gobelins.helloandroid.fragment.dummy.DummyContent;

public class TestActivity extends ActionBarActivity implements EditMessageFragment.OnSendClickListener, ItemFragment.OnFragmentInteractionListener {

    private static final String TAG = "TEST_ACTIVITY";
    private ItemFragment mItemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        DummyContent.readFromPrefs(this);

        mItemFragment = new ItemFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_edit, new EditMessageFragment())
                    .add(R.id.container_display, mItemFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSendClick(String message) {
        Log.d(TAG, message);

        DummyContent.addAndSaveItem(this, new DummyContent.DummyItem(
                String.valueOf(DummyContent.ITEMS.size()), message));
    }

    @Override
    public void onFragmentInteraction(String id) {
        Log.d(TAG, id);
    }
}
