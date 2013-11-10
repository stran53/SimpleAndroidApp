package com.example.musicselectorapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button b1, b2, b3, b4;
	String[] boredStrings = {"http://reddit.com", "http://"};
	String[] hungryStrings = new String[5];
	String[] lonelyStrings = {"http://friendsy.net"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);

		createListeners();
		
	}

	private void createListeners() {
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goToWebsite(1, "http://reddit.com");
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goToWebsite(2, "https://friendsy.net");
			}
		});
		
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goToWebsite(3, "https://blackboard.princeton.edu");
			}
		});
		
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goToWebsite(4, "http://www.foodnetwork.com/recipes-and-cooking/index.html");
			}
		});	
	}
	
	private void startSecondActivity(int numButton) {
		
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("BUTTON NUMBER", numButton);
		Toast.makeText(getApplicationContext(), "Huh.", Toast.LENGTH_SHORT).show();
		Toast.makeText(getApplicationContext(), "Well let's fix that.", Toast.LENGTH_SHORT).show();
		
		startActivity(intent);
	}
	
	private void goToWebsite(int numButton, String URL) {
		Uri webpage = Uri.parse(URL);
		Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
		
		Toast.makeText(getApplicationContext(), "Let's fix that.", Toast.LENGTH_SHORT).show();
		startActivity(webIntent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
