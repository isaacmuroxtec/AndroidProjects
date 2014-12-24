package com.example.basedades;

import java.util.Vector;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class Veure extends Activity {
	private TextView salida;
	private BaseDades bd = new BaseDades(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_veure);
		salida = (TextView) findViewById(R.id.textView1);
		salida.append("Llista:");

		Vector<String> lista = bd.listaXml();
		if (lista != null){
			for( int i=0; i<lista.size() ; i ++ ){
				String texto = lista.elementAt(i);
				salida.append(texto);
			}
		}
	}
}
