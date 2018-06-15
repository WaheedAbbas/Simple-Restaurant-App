package com.mytrendin.googlemapsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TitleActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_AppName;
    ImageView iv_Restaurants, iv_Proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        tv_AppName = (TextView) findViewById(R.id.tv_app_name);
        iv_Restaurants = (ImageView) findViewById(R.id.iv_restaurants);
        iv_Proceed = (ImageView) findViewById(R.id.iv_proceed);
        iv_Proceed.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.iv_proceed:
                startActivity(new Intent(this, DescriptionActivity.class));
        }
    }
}
