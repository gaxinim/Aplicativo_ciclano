package com.example.projeto_ciclano;

import java.util.ArrayList;


/*
 Estrutura padrão
 {
    Pergunta,
    [Resposta 1, Resposta 2, Resposta 3, ...],
    2 -- indice do array com a resposta correta
 */
public class Question {
    private String query;
    private ArrayList<String> answers;
    private int indexAnswer;

    public Question(String query, ArrayList<String> answers, int indexAnswer) {
        this.query = query;
        this.answers = answers;
        this.indexAnswer = indexAnswer;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getIndexAnswer() {
        return indexAnswer;
    }

    public void setIndexAnswer(int indexAnswer) {
        this.indexAnswer = indexAnswer;
    }
}
