package com.madmaxi.bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button newButton = (Button) findViewById(R.id.newButton);
        final Button resumeButton = (Button) findViewById(R.id.resumeButton);
        final Button copyrightsButton = (Button) findViewById(R.id.copyrightsButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newAction();
            }
        });
        resumeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resumeAction();
            }
        });
        copyrightsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                copyrightsAction();
            }
        });
    }

    private void newAction(){
        setContentView(R.layout.activity_new);
    }
    private void resumeAction(){
        setContentView(R.layout.activity_resume);
    }
    private void copyrightsAction(){
        setContentView(R.layout.activity_copyrights);
    }
}
