package de.hawlandshut.pluto20_ukw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ManageAccountActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = (TextView) findViewById( R.id.manageAccountTechnicalId);
        setContentView(R.layout.activity_manage_account);
    }
}
