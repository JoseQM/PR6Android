package com.example.pr6;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentoEdicion extends Fragment
{

    View view;

    EditText txtCorreo;
    EditText txtNumero;

    Button btnEdit;

    String correito;
    String numerito;

    public FragmentoEdicion()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        return view;
    }
}