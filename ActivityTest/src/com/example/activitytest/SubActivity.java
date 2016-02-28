package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SubActivity extends Activity {
	final String TAG = "ActivityTest";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subacticity);
		Log.v(TAG, "SubActivity::OnCreate");
		if (savedInstanceState != null) {
			Log.d(TAG,
					"Recreate data in OnCreate "
							+ savedInstanceState.getString("testbundle"));
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v(TAG, "SubActivity::onDestroy");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.v(TAG, "SubActivity::onStart");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.v(TAG, "SubActivity::Onrestart");
		super.onRestart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.v(TAG, "SubActivity::onStop");
		super.onStop();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.v(TAG, "SubActivity::onResume");
		super.onStop();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.v(TAG, "SubActivity::onPause");
		super.onPause();
	}

	public SubActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "ReCreate data form bundle onRestoreInstanceState"
				+ savedInstanceState.getString("testbundle"));
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onSaveInstanceState");
		outState.putString("testbundle", "Unexpected destory");
		super.onSaveInstanceState(outState);
	}

}
