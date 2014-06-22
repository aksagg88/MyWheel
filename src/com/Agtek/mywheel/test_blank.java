package com.Agtek.mywheel;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class test_blank extends Activity{
	TextView display = (TextView)findViewById(R.id.textView1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blank_test);
	}

	
}
