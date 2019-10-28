package de.hawLandshut.pluto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ManageAccountActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mEmail, mAccountState, mTechnicalId;
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        mEmail = (TextView) findViewById(R.id.manageAccountEmail);
        mAccountState = (TextView) findViewById(R.id.manageAccountVerificationState);
        mTechnicalId = (TextView) findViewById(R.id.manageAccountTechnicalId);
        mPassword = (EditText) findViewById(R.id.manageAccountPassword);


        ((Button) findViewById( R.id.manageAccountButtonSignOut)).setOnClickListener( this );
        ((Button) findViewById( R.id.manageAccountButtonSendActivationMail)).setOnClickListener( this );
        ((Button) findViewById( R.id.manageAccountButtonDeleteAccount)).setOnClickListener( this );
        // TODO just for testing
        mEmail.setText("Mail : " + "user@demo.de");
        mAccountState.setText("Account verified: NO");
        mTechnicalId.setText("ID : " + "uis-1231231");
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.manageAccountButtonDeleteAccount:
                doDeleteAccount();
                return;
            case R.id.manageAccountButtonSignOut:
                doSignOut();
                return;
            case R.id.manageAccountButtonSendActivationMail:
                doSendActivationMail();
                return;
            default:
                return;
        }
    }

    private void doDeleteAccount(){
        Toast.makeText(getApplicationContext(), "Delete Account!", Toast.LENGTH_LONG).show();

    }
    private void doSignOut(){
        Toast.makeText(getApplicationContext(), "SignOUt!", Toast.LENGTH_SHORT).show();
        //Length_short : duration of displayed toast : just 2 sec ( long: 3,5 sec)
    }
    private void doSendActivationMail(){
        Toast.makeText(getApplicationContext(), "Sending Mail...", Toast.LENGTH_LONG).show();

    }
}
