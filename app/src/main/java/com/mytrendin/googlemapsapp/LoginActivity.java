package com.mytrendin.googlemapsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import co.uk.rushorm.core.RushSearch;

public class LoginActivity extends AppCompatActivity
{
    EditText edt_email;
    Button btn_location;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=LoginActivity.this;
        edt_email = (EditText) findViewById(R.id.edt_email);
        btn_location = (Button) findViewById(R.id.btn_get_location);
       // List<RushORM> modelList = new RushSearch().find(RushORM.class);
        //Log.d("testing","Size"+modelList.size());
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<RushORM> objectKey = new RushSearch().
                        whereEqual("email", edt_email.getText().toString())
                        .find(RushORM.class);
                if (objectKey.size() > 0) {
                    Toast.makeText(context,"User found",Toast.LENGTH_SHORT).show();
                    //intent here
                    startActivity(new Intent(context, MapsActivity.class));
                }
                else
                {
                    Toast.makeText(context,"User not found",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
