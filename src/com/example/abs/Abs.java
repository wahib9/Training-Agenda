package com.example.abs;
// sohaib changes
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.Toast;

public class Abs extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abs);

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
		android.app.ActionBar ab = getActionBar();
		ab.setDisplayShowTitleEnabled(false);
		ab.setHomeButtonEnabled(true);
	
	    ab.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
	   
	    Tab tab = ab.newTab()
	                       .setText("Music")
	                       .setTabListener(new TabListener<PlaceholderFragment>(
	                               this, "Music", PlaceholderFragment.class));
	    ab.addTab(tab);

	    tab = ab.newTab()
	                   .setText("Movies")
	                   .setTabListener(new TabListener<PlaceholderFragment1>(
	                           this, "Movies", PlaceholderFragment1.class));
	    ab.addTab(tab);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.abs, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		
		if (id == R.id.action_search) {
			Toast.makeText(getApplicationContext(), "Implemented Soon :)", 
					   Toast.LENGTH_LONG).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends android.app.Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_abs, container,
					false);
			return rootView;
		}
	}
	
	public static class PlaceholderFragment1 extends android.app.Fragment {

		public PlaceholderFragment1() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_abs1, container,
					false);
			return rootView;
		}
	}
	
	public static class TabListener<T extends android.app.Fragment> implements android.app.ActionBar.TabListener {
	    private android.app.Fragment mFragment;
	    private final Activity mActivity;
	    private final String mTag;
	    private final Class<T> mClass;

	    /** Constructor used each time a new tab is created.
	      * @param activity  The host Activity, used to instantiate the fragment
	      * @param tag  The identifier tag for the fragment
	      * @param clz  The fragment's Class, used to instantiate the fragment
	      */
	    public TabListener(Activity activity, String tag, Class<T> clz) {
	        mActivity = activity;
	        mTag = tag;
	        mClass = clz;
	    }
	    
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
	        if (mFragment == null) {
	            // If not, instantiate and add it to the activity
	            mFragment = android.app.Fragment.instantiate(mActivity, mClass.getName());
	            ft.add(android.R.id.content, mFragment, mTag);
	        } else {
	            // If it exists, simply attach it in order to show it
	            ft.attach(mFragment);
	        }
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
	        if (mFragment != null) {
	            // Detach the fragment, because another one is being attached
	            ft.detach(mFragment);
	        }
		}
	}
}
