package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static android.Manifest.permission.CALL_PHONE;

public class Personas extends AppCompatActivity
{

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;

    ImageView img5;
    ImageView img6;

    String email;
    String numeroTelefono;

    SharedPreferences prefs;

    Fragment fragmentoEdit;
    Fragment frag;

    EditText txtCorreo;
    EditText txtNumero;
    Button btnEdit;

    String correito;
    String numerito;

    String defaultValue = "No está asociado";

    Intent intencion;

    String keyPhone, keyMail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        //save();

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        //frag = (Fragment)getSupportFragmentManager().findFragmentById(R.id.fragment);

        registerForContextMenu(img1);
        registerForContextMenu(img2);
        registerForContextMenu(img3);
        registerForContextMenu(img4);
        registerForContextMenu(img5);
        registerForContextMenu(img6);
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();


        if(v.getId() == R.id.img1)
        {
            prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);

            numeroTelefono = prefs.getString("numTelefono1", defaultValue);
            email = prefs.getString("correoElectronico1", defaultValue);

            keyMail = "correoElectronico1";
            keyPhone = "numTelefono1";
        }
        if(v.getId() == R.id.img2)
        {

            prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);

            numeroTelefono = prefs.getString("numTelefono2", defaultValue);
            email = prefs.getString("correoElectronico2", defaultValue);

            keyMail = "correoElectronico2";
            keyPhone = "numTelefono2";
        }
        if(v.getId() == R.id.img3)
        {
            prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);

            numeroTelefono = prefs.getString("numTelefono3", defaultValue);
            email = prefs.getString("correoElectronico3", defaultValue);

            keyMail = "correoElectronico3";
            keyPhone = "numTelefono3";
        }
        if(v.getId() == R.id.img4)
        {
            prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);

            numeroTelefono = prefs.getString("numTelefono4", defaultValue);
            email = prefs.getString("correoElectronico4", defaultValue);

            keyMail = "correoElectronico4";
            keyPhone = "numTelefono4";
        }
        if(v.getId() == R.id.img5)
        {
            prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);

            numeroTelefono = prefs.getString("numTelefono5", defaultValue);
            email = prefs.getString("correoElectronico5", defaultValue);

            keyMail = "correoElectronico5";
            keyPhone = "numTelefono5";
        }
        if(v.getId() == R.id.img6)
        {
            prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);

            numeroTelefono = prefs.getString("numTelefono6", defaultValue);
            email = prefs.getString("correoElectronico6", defaultValue);

            keyMail = "correoElectronico6";
            keyPhone = "numTelefono6";
        }
        inflater.inflate(R.menu.menucontextual, menu);
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opcion1:

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    Intent i42 = new Intent(Intent.ACTION_CALL);
                    i42.setData(Uri.parse(numeroTelefono));
                    startActivity(i42);
                }
                else
                {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
                break;

            case R.id.opcion2:

                Intent i41 = new Intent(Intent.ACTION_SEND);
                i41.setType("text/plain");
                i41.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                i41.putExtra(Intent.EXTRA_TEXT, "Probando el envío");
                i41.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                startActivity(i41);
                break;

            case R.id.opcion3:

                /*fragmentoEdit = new FragmentoEdicion();
                FragmentTransaction transacction = getSupportFragmentManager().beginTransaction();
                transacction.add(R.id.container, fragmentoEdit);
                transacction.commit();*/

                intencion = new Intent(getApplicationContext(), EdicionPersona.class);

                intencion.putExtra("keyNumero", keyPhone);
                intencion.putExtra("keyMail", keyMail);

                startActivity(intencion);
                break;

        }
        return true;
    }

    public void save()
    {

        prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("numTelefono1", "tel:689668725");
        editor.putString("numTelefono2", "tel:644228332");
        editor.putString("numTelefono3", "tel:689668723");
        editor.putString("numTelefono4", "tel:689668724");
        editor.putString("numTelefono5", "tel:689668726");
        editor.putString("numTelefono6", "tel:689668728");

        editor.putString("correoElectronico1", "depresetion45@gmail.com");
        editor.putString("correoElectronico2", "josemaruiz@gmail.com");
        editor.putString("correoElectronico3", "jason@gmail.com");
        editor.putString("correoElectronico4", "anakin@gmail.com");
        editor.putString("correoElectronico5", "kiryu@gmail.com");
        editor.putString("correoElectronico6", "ninofumando@gmail.com");

        editor.commit();
    }
}