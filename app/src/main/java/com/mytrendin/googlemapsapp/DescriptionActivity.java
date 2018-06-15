package com.mytrendin.googlemapsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_Text;
    ImageView iv_Logo;
    Button btn_SignUp, btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        tv_Text = (TextView) findViewById(R.id.tv_app_description);
        iv_Logo = (ImageView) findViewById(R.id.iv_logo);
        btn_SignUp = (Button) findViewById(R.id.btn_signup);
        btn_SignUp.setOnClickListener(this);
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_signup:
                startActivity(new Intent(this, SignUpActivity.class));
                break;


            case R.id.btn_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;


        }
    }
}
