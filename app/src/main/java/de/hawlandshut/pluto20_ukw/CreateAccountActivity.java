package de.hawlandshut.pluto20_ukw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{

    // Deklarieren der UI Variablen
    EditText mEditTextMail;
    EditText mEditTextPassword1;
    EditText mEditTextPassword2;
    Button mButtonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // UI Variablen initialisieren
        mEditTextMail = (EditText) findViewById( R.id.create_account_edittext_email);
        mEditTextPassword1 = (EditText) findViewById( R.id.create_account_edittext_password1);
        mEditTextPassword2 = (EditText) findViewById( R.id.create_account_edittext_password2);
        mButtonCreateAccount = (Button) findViewById(R.id.create_account_button_create);

        // Listener registrieren
        mButtonCreateAccount.setOnClickListener( this );

        // Editext vorbelegen
        mEditTextMail.setText("dietergreipl@gmail.com");
        mEditTextPassword1.setText("123456");
        mEditTextPassword2.setText("123456");

    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch(i) {
            case R.id.create_account_button_create:
                Toast.makeText( getApplicationContext(), "Create Account pressed", Toast.LENGTH_LONG).show();
                return;
        }
    }

}
