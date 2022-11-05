package com.example.aplicativo;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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

        this.nextQuestion.setOnClickListener(v -> isCorrect());
    }

    private void getQuestions() {
        this.listQuestions = new ListQuestions();
        this.questionsArray = this.listQuestions.getQuestions();
        this.questionsSize = this.listQuestions.getSize();

        this.updateQuestion();
    }

    private void isCorrect() {
        if (this.rdGroup.getCheckedRadioButtonId() != -1){
            int selectedValue = this.rdGroup.getCheckedRadioButtonId() % this.questionsSize;
            boolean answerIsRight = (selectedValue == this.idxAnswer);
            this.score = (answerIsRight) ? this.score+1 : this.score;

            this.rdGroup.removeAllViews();
            this.rdGroup.clearCheck();
            if (this.idx >= this.questionsSize){
                this.calculateScore();
            }

            this.updateQuestion();
        } else {
            Toast.makeText(getApplicationContext(), R.string.option_not_selected, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateQuestion(){
        if (this.idx < this.questionsSize) {
            this.message.setText(this.questionsArray[this.idx % this.questionsSize].getQuery());

            ArrayList<String> answers = this.questionsArray[this.idx].getAnswers();
            for (int i = 0; i < answers.size(); i++){
                RadioButton rb = new RadioButton(this);
                rb.setText(answers.get(i));
                this.rdGroup.addView(rb, i);
            }

            this.idxAnswer = this.questionsArray[this.idx].getIndexAnswer();
            this.idx++;
        }

        if (this.idx == this.questionsSize) {
            this.nextQuestion.setText(R.string.last_question);
        }
    }

    private void calculateScore(){
        double dScore = (double)(this.score * 100) / this.questionsSize;
        Intent intent = new Intent(QuestionActivity.this, FinishActivity.class);
        intent.putExtra("score", dScore);
        startActivity(intent);
        finish();
    }
}
