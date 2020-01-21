package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    ImageView imgCliente;
    ImageView imgBloc;

    Intent intencion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCliente = findViewById(R.id.imgCliente);
        imgBloc = findViewById(R.id.imgBloc);

        imgCliente.setOnClickListener(new ImageView.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intencion = new Intent(getApplicationContext(), Personas.class);
                startActivity(intencion);
            }
        });


        imgBloc.setOnClickListener(new ImageView.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intencion = new Intent(getApplicationContext(), BlocDeNotas.class);
                startActivity(intencion);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menupersona, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.item1:
                intencion = new Intent(getApplicationContext(), Personas.class);
                startActivity(intencion);
                break;
            case R.id.item2:
                intencion = new Intent(getApplicationContext(), BlocDeNotas.class);
                startActivity(intencion);
                break;
        }
        return true;
    }
}