package com.Agtek.mywheel;

import com.Agtek.mywheel.R;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
  
public class MainActivityv2 extends Activity {
	// Scrolling flag
	private boolean scrolling = false;
	TextView cityName;
	ToggleButton workON;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cityName = (TextView)findViewById(R.id.tvCityName);
		workON = (ToggleButton)findViewById(R.id.tbWork);
		
		//wheel cosmetics
		final WheelView cities = (WheelView) findViewById(R.id.city);
		cities.setVisibleItems(5); // Number of items
		cities.setWheelBackground(R.drawable.wheel_bg_holo);
		cities.setWheelForeground(R.drawable.wheel_val_holo);
		cities.setShadowColor(0xFF000000, 0x88000000, 0x00000000);
		//wheel data adapter
		//old //cities.setViewAdapter(new CityAdapter(this));
		String[] citiesList = new String[] { getCitiesList() };
		ArrayWheelAdapter<String> CitiesAdapter = new ArrayWheelAdapter<String>(this, citiesList);

		
		cities.setCurrentItem(3);
		
		cities.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if (!scrolling) {
				}
			}
		});

		
		cities.addScrollingListener(new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				
			}
		});
		
	}
	
	
	
	private String getCitiesList() {
		// TODO Auto-generated method stub
		//add the code to retrive list of cities from the db here...
		return null;
	}



	private class CitiesAdapter extends ArrayWheelAdapter {

		// City names
		final String cities[] = new String[100];

		/**
		 * Constructor
		 */
		protected CitiesAdapter(Context context, String[] string) {
			super(context, R.layout.city_holo_layout, NO_RESOURCE);
			setItemTextResource(R.id.city_name);
			this.cities = string;
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			return view;
		}

		@Override
		public int getItemsCount() {
			return cities.length;
		}

		@Override
		protected CharSequence getItemText(int index) {
			return cities[index];
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.Agtek.mywheel.ABOUTUS");
			startActivity(i);
			break;
			
		case R.id.cities_overview:			
			Intent cityOverviewActivity = new Intent("com.Agtek.mywheel.CITYOVERVIEW");
			startActivity(cityOverviewActivity);
			break;
			
		case R.id.exit:
			finish();
			break;
		}
				
		return true;
	}

}
