package com.sumit.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
  //  private EditText mEtUserName;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid ) {
                    Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
                    //intent.putExtra("username",mEtUserName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    private void initViews() {
    //    mEtUserName = findViewById(R.id.etUsername);
        mEtEmail = findViewById(R.id.mEtEmail);
        mEtPassword = findViewById(R.id.mEtPassword);
        mBtnLogin = findViewById(R.id.mBtnLogin);

    }
    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }
    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Password length is less than 6 characters");
            return false;
        }
    }

}