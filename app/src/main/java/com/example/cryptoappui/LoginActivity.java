package com.example.cryptoappui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName;
    private TextInputLayout edtPassword;
    private TextView btnLogin,txtCreateAccount;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.toString();
                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter all the fields",Toast.LENGTH_SHORT).show();
                } else {
                    if (dbHelper.checkUserNamePassword(username,password)) {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "username or password is wrong",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
    }

    private void initView() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        dbHelper = new DBHelper(this);
        txtCreateAccount = findViewById(R.id.txtCreateAccount);
    }
}