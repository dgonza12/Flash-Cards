package com.company;

import java.util.Random;

/**
 * Created by danny on 2/8/17.
 */
public class Quiz {
    String Question;
    String Answer1;
    String Answer2;
    String Answer3;
    String Answer4;


    public String toString(){
        String s = getQuestion()+" [A]"+getAnswer1()+" [B]"+getAnswer2()+" [C]"+getAnswer3()+" [D]"+getAnswer4();
        return s;
    }


    public void shuffleAnswers(){
        String temp1 = Answer1;
        String temp2 = Answer2;
        String temp3 = Answer3;
        String temp4 = Answer4;
        Random rand = new Random();
        final int n = rand.nextInt(4);
        switch (n) {
            case 0: Answer1 = temp1;
                    Answer2 = temp2;
                    Answer3 = temp3;
                    Answer4 = temp4;
                    break;
            case 1: Answer1 = temp4;
                    Answer2 = temp2;
                    Answer3 = temp3;
                    Answer4 = temp1;
                    break;
            case 2: Answer1 = temp3;
                    Answer2 = temp2;
                    Answer3 = temp1;
                    Answer4 = temp4;
                    break;
            default:Answer1 = temp2;
                    Answer2 = temp4;
                    Answer3 = temp3;
                    Answer4 = temp1;
                    break;
        }
    }

    public Quiz(String q, String a, String b, String c, String d ){
        Question = q;
        Answer1 = a;
        Answer2 = b;
        Answer3 = c;
        Answer4 = d;

    }

    public String getQuestion(){return Question;}

    public String getAnswer1() {
        return Answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }
}

