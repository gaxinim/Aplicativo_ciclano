package com.example.aplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    private Button changeTextButton;
    private TextView message;
    private Question[] questionsArray;
    int idx = 0, questionsSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initArrayListQuestion();

        message = (TextView) findViewById(R.id.tvQuestion);
        changeTextButton = (Button) findViewById(R.id.btChangeText);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idx == questionsSize){
                    Log.i("Informative", "Chegou ao final da lista");
                } else{
                    message.setText(questionsArray[idx % questionsSize].getQuery());
                    idx++;
                }
            }
        });
    }

    /*private String readFromFile() {
        StringBuilder resultStringBuilder = new StringBuilder();
        File directory = new File("./");
        File[] files = directory.listFiles();
        Path path = Paths.get(pathString);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> resultStringBuilder.append(s));
        } catch (IOException ex) {
            Log.e("ERROR", "ex");
        }
        return resultStringBuilder.toString();
    }*/

    private void initArrayListQuestion() {
        String questionJson = "[{'query': 'Esta é a primeira pergunta','answers': ['Resposta 1', 'Resposta 2', 'Resposta 3'],'indexAnswer': 2},{'query': 'Esta é a segunda pergunta','answers': ['Resposta 1', 'Resposta 2', 'Resposta 3'],'indexAnswer': 1},{'query': 'Esta é a terceira pergunta','answers': ['Resposta 1', 'Resposta 2', 'Resposta 3'],'indexAnswer': 3}]";
        Gson gson = new Gson();
        //questionsArray = gson.fromJson(readFromFile(), Question[].class);
        questionsArray = gson.fromJson(questionJson, Question[].class);
        questionsSize = questionsArray.length;
    }
}