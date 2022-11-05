package com.example.aplicativo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;

public class FinishActivity extends AppCompatActivity {

    private TextView txtScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);

        this.txtScore = (TextView) findViewById(R.id.txtScore);

        Intent intent = getIntent();
        double dScore = intent.getDoubleExtra("score", 0);
        this.txtScore.setText(MessageFormat.format("{0} {1}", getResources().getString(R.string.score), dScore));
    }
}
