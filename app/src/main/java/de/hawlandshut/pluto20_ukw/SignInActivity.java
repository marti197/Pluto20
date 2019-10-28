package de.hawlandshut.pluto20_ukw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    // UI Variablen deklarieren
    EditText mEditTextEmail;
    EditText mEditTextPassword;
    Button mButtonSignIn;
    Button mButtonResetPassword;
    Button mButtonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        // Initialiseren der UT Variablen
        mEditTextEmail = (EditText) findViewById( R.id.sign_in_edittext_email);
        mEditTextPassword = (EditText) findViewById( R.id.sign_in_edittext_password);
        mButtonSignIn = (Button) findViewById( R.id.sign_in_button_sign_in);
        mButtonCreateAccount = (Button) findViewById( R.id.sign_in_button_create_account );
        mButtonResetPassword = (Button) findViewById( R.id.sign_in_button_reset_password );

        // Listener registrieren
        mButtonSignIn.setOnClickListener( this );
        mButtonResetPassword.setOnClickListener( this );
        mButtonCreateAccount.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch(i) {
            case R.id.sign_in_button_create_account:
                Toast.makeText( getApplicationContext(), "Create Account pressed", Toast.LENGTH_LONG).show();
                return;
            case R.id.sign_in_button_reset_password:
                Toast.makeText( getApplicationContext(), "Reset Password pressed", Toast.LENGTH_LONG).show();
                return;

            case R.id.sign_in_button_sign_in:
                Toast.makeText( getApplicationContext(), "SigIn in pressed", Toast.LENGTH_LONG).show();
                return;
        }
    }
}
