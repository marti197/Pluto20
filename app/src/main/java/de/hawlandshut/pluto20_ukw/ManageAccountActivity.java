package de.hawlandshut.pluto20_ukw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManageAccountActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mEmail, mAccountState, mTechnicalId;
    Button mButtonSignOut, mButtonDeleteAccount, mButtonSendActivationMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = (TextView) findViewById( R.id.manageAccountTechnicalId);
        setContentView(R.layout.activity_manage_account);

        // UI Elemente-Initialiseren
        mEmail = findViewById( R.id.manageAccountEmail );
        mAccountState = findViewById( R.id.manageAccountVerificationState );
        mTechnicalId = findViewById( R.id.manageAccountTechnicalId );

        mButtonDeleteAccount = findViewById( R.id.manageAccountButtonDeleteAccount);
        mButtonSendActivationMail = findViewById( R.id.manageAccountButtonSendActivationMail );
        mButtonSignOut = findViewById( R.id.manageAccountButtonSignOut );

        // Listener registrieren
        mButtonSignOut.setOnClickListener( this );
        mButtonSendActivationMail.setOnClickListener( this );
        mButtonDeleteAccount.setOnClickListener( this );

        // Text setzen // TODO: review later
        mEmail.setText( "E-Mail: ");
        mTechnicalId.setText("Technical Id : 1123123" );
        mAccountState.setText("Account verified : no");
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch(i) {
            case R.id.manageAccountButtonDeleteAccount:
                Toast.makeText( getApplicationContext(), "Delete Account pressed", Toast.LENGTH_LONG).show();
                return;
            case R.id.manageAccountButtonSignOut:
                Toast.makeText( getApplicationContext(), "Sign Out pressed", Toast.LENGTH_LONG).show();
                return;

            case R.id.manageAccountButtonSendActivationMail:
                Toast.makeText( getApplicationContext(), "Send Act Mail pressed", Toast.LENGTH_LONG).show();
                return;
        }
    }
}
