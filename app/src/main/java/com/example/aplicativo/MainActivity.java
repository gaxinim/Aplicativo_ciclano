package com.example.aplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button changeTextButton;
    private TextView message;
    private ListQuestions listQuestions;
    private Question[] questionsArray;
    int idx = 0, questionsSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.updateQuestions();

        //message = (TextView) findViewById(R.id.tvQuestion);
        changeTextButton = (Button) findViewById(R.id.btStartQuestionnaire);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);

        //        if (idx == questionsSize){
          //          Log.i("Informative", "Chegou ao final da lista");
            //    } else{
              //      message.setText(questionsArray[idx % questionsSize].getQuery());
                //    idx++;
                //}
            }
        });
    }

    private void updateQuestions() {
        this.listQuestions = new ListQuestions();
        questionsArray = this.listQuestions.getQuestions();
        questionsSize = this.listQuestions.getSize();
    }
}