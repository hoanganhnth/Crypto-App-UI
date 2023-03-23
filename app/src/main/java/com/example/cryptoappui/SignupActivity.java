package com.example.cryptoappui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText edtPasswordSignUp,edtUserNameSignUp,edtConfirmPassword;
    private TextView btnSignUp,btnBackToSignIn;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();

        btnBackToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserNameSignUp.getText().toString();
                String password = edtPasswordSignUp.getText().toString();
                String repassword = edtConfirmPassword.getText().toString();

                if (username.equals("") || password.equals("") || repassword.equals("")) {
                    Toast.makeText(SignupActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                } else if (password.equals(repassword)) {
                    if (!dbHelper.checkUserName(username)) {
                        if (dbHelper.insertData(username,password)) {
                            Toast.makeText(SignupActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignupActivity.this,"Registered badly",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignupActivity.this,"The system already has this account",Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(SignupActivity.this,"Password is different from repassword",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void initView() {
        edtUserNameSignUp = findViewById(R.id.edtUserNameSignUp);
        edtPasswordSignUp = findViewById(R.id.edtPasswordSignUp);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnBackToSignIn = findViewById(R.id.btnBackToSignIn);
        dbHelper = new DBHelper(this);
    }
}