package org.kteam.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class Question implements Serializable {
    private int ID;
    private String question_audio;
    private String choose1;
    private String choose2;
    private String answer;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion_audio() {
        return question_audio;
    }

    public void setQuestion_audio(String question_audio) {
        this.question_audio = question_audio;
    }

    public String getChoose1() {
        return choose1;
    }

    public void setChoose1(String choose1) {
        this.choose1 = choose1;
    }

    public String getChoose2() {
        return choose2;
    }

    public void setChoose2(String choose2) {
        this.choose2 = choose2;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ID=" + ID +
                ", question_audio='" + question_audio + '\'' +
                ", choose1='" + choose1 + '\'' +
                ", choose2='" + choose2 + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
