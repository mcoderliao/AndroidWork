package com.example.activitytest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	final String TAG = "ActivityTest";
	int mCreateCounts = 0;
	Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v(TAG, "MainActivity::OnCreate");
		findViewById(R.id.btn_singleinstancemode).setOnClickListener(this);
		findViewById(R.id.btn_singletaskmode).setOnClickListener(this);
		findViewById(R.id.btn_singletopmode).setOnClickListener(this);
		findViewById(R.id.btn_standmode).setOnClickListener(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v(TAG, "MainActivity::onDestroy");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.v(TAG, "MainActivity::onStart");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.v(TAG, "MainActivity::Onrestart");
		super.onRestart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.v(TAG, "MainActivity::onStop");
		super.onStop();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.v(TAG, "MainActivity::onResume");
		super.onStop();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.v(TAG, "MainActivity::onPause");
		super.onPause();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_singleinstancemode:

			break;
		case R.id.btn_singletaskmode:

			break;
		case R.id.btn_singletopmode:

			break;
		case R.id.btn_standmode:

			Runnable createActivityRunnable = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					mCreateCounts++;
					Intent intent = new Intent();
					intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_s);
					// intent
					intent.setComponent(new ComponentName(getPackageName(),
							"com.example.activitytest.SubActivity"));
					startActivity(intent);
					if (mCreateCounts < 4) {
						mHandler.postDelayed(this, 1000);
					}
				}
			};
			mHandler.postDelayed(createActivityRunnable, 10);

			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		Intent intent = new Intent();
		intent.setPackage(getPackageName());
		intent.setClassName(this, "com.example.activitytest.SubActivity");
		String packageString = getPackageName();

		// intent
		intent.setComponent(new ComponentName(getPackageName(),
				"com.example.activitytest.SubActivity"));
		if (keyCode != KeyEvent.KEYCODE_BACK) {
			startActivity(intent);
		}
		// TODO Auto-generated method stub
		return super.onKeyUp(keyCode, event);
	}
}
