package com.example.adaptertext;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button btnAgregar = (Button) findViewById(R.id.btnagregar);
		final EditText txtDatos = (EditText) findViewById(R.id.txtdatos);
		final Spinner spinerDatos = (Spinner) findViewById(R.id.spinnerdatos);
		
		btnAgregar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String datos[] = txtDatos.getText().toString().split(",");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, datos);
				spinerDatos.setAdapter(adapter);
			}
		});
		
		
		spinerDatos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int ag2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(spinerDatos.getContext(), "Seleccionaste " + spinerDatos.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
