package com.example.marvelquiz20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        TextView tvresult = findViewById(R.id.result);
        Intent intent = getIntent();
        Integer score = intent.getIntExtra("score", 0);
        tvresult.setText(String.valueOf(score));


        //requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(result.this,MainActivity.class);
        startActivity(intent);
    }
}
