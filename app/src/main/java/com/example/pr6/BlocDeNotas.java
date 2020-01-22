package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class BlocDeNotas extends AppCompatActivity
{

    EditText txtBloc;

    String texto, textoRecuperado;

    SharedPreferences prefs;

    String defaultValue = "No está asociado";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc_de_notas);

        txtBloc = findViewById(R.id.txtBloc);

        prefs = getSharedPreferences("ficheroblocdenotas", Context.MODE_PRIVATE);

        textoRecuperado = prefs.getString("blocdenotas", defaultValue);

        txtBloc.setText(textoRecuperado);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menublocnotas, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opcion:

                texto = txtBloc.getText().toString();

                prefs = getSharedPreferences("ficheroblocdenotas", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("blocdenotas", texto);
                editor.commit();

                Toast.makeText(getApplicationContext(), "Texto guardado", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}