package de.hawlandshut.pluto20_ukw;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import de.hawlandshut.pluto20_ukw.model.Post;
import de.hawlandshut.pluto20_ukw.test.TestData;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "xx Main Activity";

    // Initialisieren der ListView
    ListView mListView;

    // Liste der von Firebase empfangenen Posts
    ArrayList<Post> mPostList;
    ArrayAdapter<Post> mAdapter;

    // TODO: Just for testing. Remove
    String TEST_MAIL = "dieter.greipl@gmail.com";
    String TEST_PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init ListView
        mListView = findViewById( R.id.mainListViewMessages);

        // Initialisieren der Post-Liste mit Testdaten
        mPostList = (ArrayList<Post>) TestData.createTestdata();
        mAdapter = new ArrayAdapter<Post>(
                this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                mPostList
        ){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView line1, line2;

                line1 = view.findViewById( android.R.id.text1 );
                line2 = view.findViewById( android.R.id.text2 );

                Post post = getItem(position);

                line1.setText(post.author+ " (" +post.title + " )");
                line2.setText(post.body );

                return view;
            }
        };

        // Adapter der Listview zuordnen...
        mListView.setAdapter( mAdapter );
    }


    // Menue aus der XML Datei "aufblasen"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.menu_main, menu);
        return true;
    }

    // Listener für Menu Events erzeugen
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch( item.getItemId() ){
            case R.id.menu1TestAuth:
               doTestAuth();

            case R.id.menu2CreateUser:
                doCreateUser();

            case R.id.menu3SignIn:
                doSignIn();

            case R.id.menu4SignOut:
                doTestSignOut();

            case R.id.menu5DeleteTestUser:
                doDeleteTestUser();

            case R.id.menu6SendResetPasswordMail:
                doSendResetPasswordMail();

            case R.id.menu7SendActivationMail:
                doSendActivationMail();


            case R.id.menu8SetDisplayName:
                doSetDisplayName();

            default:
                return true;
        }
    }

    private void doSetDisplayName() {

    }

    private void doSendActivationMail() {

    }

    private void doSendResetPasswordMail() {

    }

    private void doDeleteTestUser() {

    }

    private void doTestSignOut() {

    }

    private void doSignIn() {

    }

    private void doCreateUser() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword( TEST_MAIL, TEST_PASSWORD).addOnCompleteListener(
                this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText( getApplicationContext(), "User created.", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText( getApplicationContext(), "User creation failed.", Toast.LENGTH_LONG).show();
                            Log.d(TAG,task.getException().getLocalizedMessage());
                        }
                    }
                }
        );
    }

    private void doTestAuth() {
        FirebaseUser user;
        user = FirebaseAuth.getInstance().getCurrentUser();
        String msg =  (user == null) ? "Not Authenticated" : ("Authenticated : " +user.getEmail() );
        Toast.makeText( getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
    }


}
