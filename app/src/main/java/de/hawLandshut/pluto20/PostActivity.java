package de.hawLandshut.pluto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText mPostTitle;
    EditText mPostBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mPostTitle = (EditText) findViewById( R.id.postTitle);
        mPostBody  = (EditText) findViewById( R.id.postText);
        ((Button) findViewById( R.id.postButtonPost)).setOnClickListener( this );

        //  TODO: Remove; test setting
        mPostBody.setText("Lore ipsum se...");
        mPostTitle.setText("Title");
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.postButtonPost:
                doPost();
                return;
            default:
                return;
        }
    }

    public void doPost(){
        Toast.makeText(getApplicationContext(), "Test Posting ", Toast.LENGTH_SHORT).show();
    }
}
