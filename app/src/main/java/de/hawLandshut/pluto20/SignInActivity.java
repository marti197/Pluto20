package de.hawLandshut.pluto20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditTextEmail;
    private EditText mEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        mEditTextEmail = (EditText) findViewById(R.id.signInEmail);
        mEditTextPassword = (EditText) findViewById(R.id.signInPassword);
        ((Button) findViewById(R.id.signInButtonResetPassword)).setOnClickListener(this);
        ((Button) findViewById(R.id.signInButtonSignIn)).setOnClickListener(this);
        ((Button) findViewById(R.id.signInButtonCreateAccount)).setOnClickListener(this);
    }

    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.signInButtonSignIn:
                doSignIn();
                return;

            case R.id.signInButtonResetPassword:
                doResetPassword();
                return;

            case R.id.signInButtonCreateAccount:
                doCreateAccount();
                return;
            default:
                return;
        }
    }

    protected void doSignIn() {
        Toast.makeText(getApplicationContext(), "SignIN", Toast.LENGTH_LONG).show();


    }

    protected void doResetPassword() {
        Toast.makeText(getApplicationContext(), "Reset Password ?", Toast.LENGTH_LONG).show();
    }

    protected void doCreateAccount() {
        Toast.makeText(getApplicationContext(), "Create Account?", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplication(), CreateAccountActivity.class);
        startActivity(intent);
    }


}
