package de.hawlandshut.pluto20_ukw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ManageAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "xx ManageACActivity ";

    TextView mEmail, mAccountState, mTechnicalId;
    Button mButtonSignOut, mButtonDeleteAccount, mButtonSendActivationMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = (TextView) findViewById(R.id.manageAccountTechnicalId);
        setContentView(R.layout.activity_manage_account);

        // UI Elemente-Initialiseren
        mEmail = findViewById(R.id.manageAccountEmail);
        mAccountState = findViewById(R.id.manageAccountVerificationState);
        mTechnicalId = findViewById(R.id.manageAccountTechnicalId);

        mButtonDeleteAccount = findViewById(R.id.manageAccountButtonDeleteAccount);
        mButtonSendActivationMail = findViewById(R.id.manageAccountButtonSendActivationMail);
        mButtonSignOut = findViewById(R.id.manageAccountButtonSignOut);

        // Listener registrieren
        mButtonSignOut.setOnClickListener(this);
        mButtonSendActivationMail.setOnClickListener(this);
        mButtonDeleteAccount.setOnClickListener(this);

        // nur zur Sicherheit ; die aufrufende Activity muss garantieren, dass es einen User gibt.
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            // finish beendet Activity
            finish();
        }
        // Text setzen // TODO: review later
        mEmail.setText("E-Mail: " + user.getEmail());
        mTechnicalId.setText("Technical Id : " + user.getUid());
        mAccountState.setText("Account verified : " + user.isEmailVerified());

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.manageAccountButtonDeleteAccount:
                doDeleteAccount();

                Toast.makeText(getApplicationContext(), "Delete Account pressed", Toast.LENGTH_LONG).show();
                return;
            case R.id.manageAccountButtonSignOut:
                doSignOut();
                Toast.makeText(getApplicationContext(), "Sign Out pressed", Toast.LENGTH_LONG).show();
                return;

            case R.id.manageAccountButtonSendActivationMail:
                doSendActivationMail();
                Toast.makeText(getApplicationContext(), "Send Act Mail pressed", Toast.LENGTH_LONG).show();
                return;
        }
    }

    private void doSignOut() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            Toast.makeText(getApplicationContext(), "You are not signed in", Toast.LENGTH_SHORT).show();
            return;
        }
        FirebaseAuth.getInstance().signOut();
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Toast.makeText(getApplicationContext(), "SignetOUt", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Sign out failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void doDeleteAccount() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            Toast.makeText(getApplicationContext(), "Can not delete Account. You are not signed in", Toast.LENGTH_SHORT).show();
            return;
        }

        user.delete().addOnCompleteListener(
                this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Account deletion failed (check log)", Toast.LENGTH_LONG).show();
                            Log.d(TAG, task.getException().getLocalizedMessage());
                        }

                    }
                });


    }

    private void doSendActivationMail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Toast.makeText(getApplicationContext(), "Sending not possible: not signed in", Toast.LENGTH_SHORT).show();
            return;
        }
        // At this point we have a valid use object
        if (user.isEmailVerified()) {
            Toast.makeText(getApplicationContext(), "Account already verified", Toast.LENGTH_SHORT).show();
            return;
        }
        user.sendEmailVerification().addOnCompleteListener(
                this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Verification mail sent",
                                    Toast.LENGTH_LONG).show();
                            Log.d(TAG, "Email sent.");
                        } else {
                            Toast.makeText(getApplicationContext(), "Sending mail failed (check log",
                                    Toast.LENGTH_LONG).show();
                            Log.d(TAG, task.getException().getLocalizedMessage());

                        }

                    }
                });

    }
}
