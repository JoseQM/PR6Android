package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EdicionPersona extends AppCompatActivity
{

    EditText txtCorreo;
    EditText txtNumero;
    Button btnEditar;

    String keyMail;
    String keyPhone;

    String correito;
    String numerito;

    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion_persona);

        txtCorreo = findViewById(R.id.txtCorreo);
        txtNumero = findViewById(R.id.txtNumero);
        btnEditar = findViewById(R.id.btnEdit);

        btnEditar.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                correito = txtCorreo.getText().toString();
                numerito = txtNumero.getText().toString();

                keyMail = getIntent().getStringExtra("keyMail");
                keyPhone = getIntent().getStringExtra("keyNumero");

                prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString(keyMail, correito);
                editor.putString(keyPhone, "tel:"+numerito);
                editor.commit();

                Toast.makeText(getApplicationContext(), getString(R.string.toastEditado), Toast.LENGTH_LONG).show();

                txtCorreo.setText("");
                txtNumero.setText("");

                finish();

            }
        });
    }
}