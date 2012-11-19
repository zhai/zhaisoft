package com.zhai.host;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.view.Window;
import com.zhai.utils.VersionUtil;

public class WelcomeActivity extends CommonActivity {

	TextView textview_version;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	//	setTheme(R.style.Theme_Sherlock_Light_NoTitleBar_Fullscreen);
		
	requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		//
		setContentView(R.layout.activity_welcome);
		
		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//getSupportActionBar().setDisplayShowHomeEnabled(true);
		textview_version = (TextView) findViewById(R.id.textview_version);
		textview_version.setText("v"
				+ VersionUtil.getAppVersionName(WelcomeActivity.this));

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(800);
					goMainActivity();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		new Thread(runnable).start();

	}

	protected void goMainActivity() {
		// TODO Auto-generated method stub

		Intent intent = new Intent();
		intent.setClass(WelcomeActivity.this, MainActivity.class);
		startActivity(intent);
		finish();

	}

}
