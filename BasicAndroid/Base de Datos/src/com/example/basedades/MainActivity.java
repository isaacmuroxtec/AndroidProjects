package com.example.basedades;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private BaseDades bd = new BaseDades(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/** Called when the user clicks the veureXML button*/
	public void veureXML(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, Veure.class);
		startActivity(intent);	
	}
	
	/** Called when the user clicks the Guardar button*/
	public void guarda(View view) {
		EditText editText = (EditText) findViewById(R.id.editText1);
		String message = editText.getText().toString();
		bd.guardarText(message, new Date().getTime());
	}
}
