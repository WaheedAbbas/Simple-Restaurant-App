package com.mytrendin.googlemapsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_FirstName, et_LastName, et_Gender, et_Email, et_Password, et_ConfirmPassword ;
    Button btn_Done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et_FirstName = (EditText) findViewById(R.id.et_first_name);
        et_LastName = (EditText) findViewById(R.id.et_last_name);
        et_Gender = (EditText) findViewById(R.id.et_gender);
        et_Email = (EditText) findViewById(R.id.et_email);
        et_Password = (EditText) findViewById(R.id.et_password);
        et_ConfirmPassword = (EditText) findViewById(R.id.et_confirm_password);
        btn_Done = (Button) findViewById(R.id.btn_done);
        btn_Done.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_done: {
                validity_check();
               //startActivity(new Intent(this, MapsActivity.class));


                break;
            }
        }

    }


    private void validity_check() {
        if (et_FirstName.getText().toString().equals("")) {
            et_FirstName.requestFocus();
            et_FirstName.setError(getResources().getString(R.string.error_empty));
            return;
        }

        if (et_LastName.getText().toString().equals("")) {
            et_LastName.requestFocus();
            et_LastName.setError(getResources().getString(R.string.error_empty));
            return;
        }

        if (et_Gender.getText().toString().equals("")) {
            et_Gender.requestFocus();
            et_Gender.setError(getResources().getString(R.string.error_empty));
            return;
        }

        if (et_Email.getText().toString().equals("")) {
            et_Email.requestFocus();
            et_Email.setError(getResources().getString(R.string.error_empty));
            return;
        }

        if (et_Password.getText().toString().equals("")) {
            et_Password.requestFocus();
            et_Password.setError(getResources().getString(R.string.error_empty));
            return;
        }

        if (et_ConfirmPassword.getText().toString().equals("")) {
            et_ConfirmPassword.requestFocus();
            et_ConfirmPassword.setError(getResources().getString(R.string.error_empty));
            return;
        }

        if (!et_Password.getText().toString().equals(et_ConfirmPassword.getText().toString())) {
            et_ConfirmPassword.requestFocus();
            et_ConfirmPassword.setError(getResources().getString(R.string.error_mismatch));
            return;
        } else {

            RushORM model = new RushORM();
            storeData(model);
            Toast.makeText(this, "Username is: " + et_FirstName.getText().toString()
                    + " Password is: " + et_Password.getText().toString(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MapsActivity.class));

        }
    }
    private void storeData(RushORM model)
    {
       model.setEmail(et_Email.getText().toString());
       model.setf_Name(et_FirstName.getText().toString());
        model.setl_Name(et_LastName.getText().toString());
        model.set_gender(et_Gender.getText().toString());
        model.set_password(et_Password.getText().toString());
        model.set_Confirm_password(et_ConfirmPassword.getText().toString());
       model.save();
     //  Log.d("testing","Size"+model.getEmail());

    }
}
