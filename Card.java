package com.company;
import java.io.Serializable;
/**
 * Created by danny on 2/8/17.
 */
public class Card implements Serializable{
    String Question;
    String Answer;

    Card(String q, String a){//Constructor
        Question = q;
        Answer = a;
    }

    public String getAnswer() {
        return Answer;
    }

    public String getQuestion(){
        return Question;
    }

    public boolean checkanswer(String theanswer){
        if (theanswer== Answer){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public String toString() {
        return new StringBuffer(" Question : ").append(this.Question).append(" Answer : ")
                .append(this.Answer).toString();
    }
}
