package com.example.aplicativo;

import com.google.gson.Gson;

public class ListQuestions {

    private Question[] questionsArray;
    private int questionsSize = 0;

    public ListQuestions(){
        this.initializeListOfQuestions();
    }

    private void initializeListOfQuestions(){
        String questionJson = this.getQuestionsJson();
        Gson gson = new Gson();
        //questionsArray = gson.fromJson(readFromFile(), Question[].class);
        this.questionsArray = gson.fromJson(questionJson, Question[].class);
        this.questionsSize = this.questionsArray.length;
    }

    public int getSize(){ return this.questionsSize; }

    public Question[] getQuestions(){ return this.questionsArray; }

    private String getQuestionsJson(){
        return "[{'query': 'Esta é a primeira pergunta','answers': ['Resposta 1', 'Resposta 2', 'Resposta 3'],'indexAnswer': 2},{'query': 'Esta é a segunda pergunta','answers': ['Resposta 1', 'Resposta 2', 'Resposta 3'],'indexAnswer': 1},{'query': 'Esta é a terceira pergunta','answers': ['Resposta 1', 'Resposta 2', 'Resposta 3'],'indexAnswer': 3}]";
    }
}
