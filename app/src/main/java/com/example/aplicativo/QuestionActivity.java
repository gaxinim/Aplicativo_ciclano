package com.example.aplicativo;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private Button nextQuestion;
    private TextView message;
    private RadioGroup rdGroup;

    private ListQuestions listQuestions;
    private Question[] questionsArray;
    int idx=0, questionsSize=0, idxAnswer=0, score=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        this.message = (TextView) findViewById(R.id.txtQuestion);
        this.nextQuestion = (Button) findViewById(R.id.btNextQuestion);
        this.rdGroup = (RadioGroup) findViewById(R.id.rdGroupQuestions);
        this.getQuestions();
        this.updateQuestions();

        this.nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestions();
            }
        });
    }

    private void getQuestions() {
        this.listQuestions = new ListQuestions();
        questionsArray = this.listQuestions.getQuestions();
        questionsSize = this.listQuestions.getSize();
    }

    private void updateQuestions() {
        if (this.idx < this.questionsSize) {
            this.message.setText(this.questionsArray[this.idx % this.questionsSize].getQuery());

            /*
            check https://github.com/sandipapps/TechQuizApp/blob/master/app/src/main/java/com/sandipbhattacharya/techquizapp/StartGame.java
             */
            ArrayList<String> answers = this.questionsArray[this.idx].getAnswers();
            for (int i = 0; i < answers.size(); i++){
                RadioButton rb = new RadioButton(this);
                rb.setText(answers.get(i));
                this.rdGroup.addView(rb, i);
                //this.rdGroup.removeAllViews();
            }

            this.idxAnswer = this.questionsArray[this.idx].getIndexAnswer();
            boolean answerIsRight = ((RadioButton) this.rdGroup.findViewById(this.idxAnswer)).isChecked();

            this.score = (answerIsRight) ? this.score++ : this.score;
            this.idx++;
        }

        if (this.idx == this.questionsSize) {
            /*
                    check for more information Intent
                    https://stackoverflow.com/questions/4186021/how-to-start-new-activity-on-button-click
                    here call new Intent for show score
                     */
            Log.i("Informative", "Chegou ao final da lista");
            this.nextQuestion.setText(R.string.last_question);
        }
    }

    private void nextQuestion(){

    }

    private void checkAnswerOfQuestion(){

    }
}
