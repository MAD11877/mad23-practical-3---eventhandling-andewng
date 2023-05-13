package com.example.week2prac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ImageView imageView;
    AlertDialog.Builder builder;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        imageView=(ImageView) findViewById(R.id.imageButton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             openAlertBox();


            }
        });

    }
    private int generateNO(){
        Random random= new Random();
        int randNum =random.nextInt(99999999);
        return randNum;

    }
    Integer RandomNum;

    private void openAlertBox() {
        txt = findViewById(R.id.textView);
        builder = new AlertDialog.Builder(ListActivity.this);
        builder.setTitle("User profile");
        builder.setMessage("hello world");
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                RandomNum=generateNO();
                Intent newAct = new Intent(ListActivity.this,MainActivity.class);
                newAct.putExtra("randomNumber",RandomNum);
                startActivity(newAct);


            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}