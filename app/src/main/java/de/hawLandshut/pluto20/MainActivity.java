package de.hawLandshut.pluto20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "XX MyActivity";
    public boolean currentUser=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "my log onStart");

        if (currentUser ) {
            Log.d(TAG, "User not authenticated! ");
            Intent intent = new Intent(getApplication(),
                    SignInActivity.class);
            startActivity(intent);
            currentUser=false;

        } else {
            Log.d(TAG, "User authenticated.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "my log onResume");
        Toast.makeText(getApplicationContext(), "Your Pluto20 was been resumed!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "my log onPause");
        Toast.makeText(getApplicationContext(), "Your Pluto20 was been paused", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "my log onPause");
        Toast.makeText(getApplicationContext(), "Your Pluto20 was been stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "my log onDestroy");
        Toast.makeText(getApplicationContext(), "Your Pluto20 was been destroyed", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater;
        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.mainMenuPost:
                Log.d(TAG, "Post was pressed");
                return true;

            case R.id.mainMenuHelp:
                Log.d(TAG, "Help was pressed");
                intent = new Intent ( getApplication(), SignInActivity.class);
                startActivity(intent);
                return true;

            case R.id.mainMenuTest:
                Log.d(TAG, "Test was pressed");
                return true;

            case R.id.mainMenuManageAccount:
                Log.d(TAG, "ManageAccount was pressed.");
                return true;

            case R.id.idWriteTime:
                Toast.makeText(getApplicationContext(), "You want to write the time :D", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
