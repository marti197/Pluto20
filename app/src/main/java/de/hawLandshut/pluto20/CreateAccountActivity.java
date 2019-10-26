package de.hawLandshut.pluto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText mEditTextEMail;
    private EditText mEditTextPassword1;
    private EditText mEditTextPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mEditTextEMail =  ((EditText) findViewById(R.id.createAccountEmail));
        mEditTextPassword1 =  ((EditText) findViewById(R.id.createAccountPassword1));
        mEditTextPassword2 =  ((EditText) findViewById(R.id.createAccountPassword2));

        // TODO: Remove presets later
        mEditTextEMail.setText("xxx@gmail.com");
        mEditTextPassword1.setText("123456");
        mEditTextPassword2.setText("123456");

    }


    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.createAccountButtonCreateAccount:
                doCreateAccount();
                return;
            default:
                return;
        }
    }

    private void doCreateAccount(){
        Toast.makeText(getApplicationContext(), "created Account test", Toast.LENGTH_LONG).show();
    }
}
