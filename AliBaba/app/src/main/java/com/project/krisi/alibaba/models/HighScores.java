package com.project.krisi.alibaba.models;

/**
 * Created by Krisi on 11.10.2017 г..
 */

import com.orm.SugarRecord;

public class HighScores extends SugarRecord {

    String name;
    int score;
    // Default constructor is important!
    public HighScores() {
    }

    public HighScores(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
