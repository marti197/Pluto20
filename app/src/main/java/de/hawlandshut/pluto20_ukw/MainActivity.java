package de.hawlandshut.pluto20_ukw;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "xx Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate called");
        Toast.makeText( getApplicationContext(), "Hat funktioniert", Toast.LENGTH_LONG).show();
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
            case R.id.menuWebView:
                intent = new Intent( getApplication(), WebViewActivity.class);
                startActivity( intent );
                return true;

            case R.id.menuGotoSignIn:
                intent = new Intent( getApplication(), SignInActivity.class);
                startActivity( intent );
                return true;

            case R.id.menuGotoManageAccount:
                intent = new Intent( getApplication(), ManageAccountActivity.class);
                startActivity( intent );
                return true;

            case R.id.menuGotoCreateAccount:
                intent = new Intent( getApplication(), CreateAccountActivity.class);
                startActivity( intent );
                return true;

            case R.id.menuGotoPost:
                intent = new Intent( getApplication(), PostActivity.class);
                startActivity( intent );
                return true;

            default:
                return true;
        }
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
