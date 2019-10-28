package de.hawlandshut.pluto20_ukw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity implements View.OnClickListener{

    // UI Variablen deklarieren
    EditText mEditTextTitle;
    EditText mEditTextMessage;
    Button mButtonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // UI Elemente initialisieren
        mEditTextTitle = (EditText) findViewById(R.id.post_edittext_title);
        mEditTextMessage = (EditText) findViewById( R.id.post_edittext_text);
        mButtonSend = (Button) findViewById( R.id.post_button_send );

        mButtonSend.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch(i) {
            case R.id.post_button_send:
                Toast.makeText( getApplicationContext(), "Send pressed", Toast.LENGTH_LONG).show();
                return;
        }
    }
}
