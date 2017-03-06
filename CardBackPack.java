package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by danny on 2/8/17.
 */
public class CardBackPack  {
    public ArrayList<Card> Deck;
    public int numberCorrect = 0;
    Quiz CurrentQuiz;
    Card CurrentQuestion;
    int Index = 0;


    public CardBackPack(){
        Deck = new ArrayList<Card>();
    }

    public void AddCard(Card newcard){
        Deck.add(newcard);
        System.out.println(newcard.toString());
    }

    public void Cleardeck(){
        Deck.clear();
    }





    public void Shuffledeck(){
        Random rand = new Random();
        int  n = rand.nextInt(Deck.size());
        for (int i =0;i<=n;i++) {
            rand = new Random();
            n = rand.nextInt(Deck.size());
            Card temp = Deck.get(n);
            Deck.remove(n);
            Deck.add(temp);
        }
    }

    public void CreateQuiz(){
        Random rand = new Random();
        Card temp = Deck.get(0);
        CurrentQuestion = temp;
        Deck.remove(0);
        rand = new Random();
        int n = rand.nextInt(Deck.size());
        Card temp2 = Deck.get(n);
        Deck.remove(n);
        n = rand.nextInt(Deck.size());
        Card temp3 = Deck.get(n);
        Deck.remove(n);
        n = rand.nextInt(Deck.size());
        Card temp4 = Deck.get(n);
        Deck.remove(n);
        CurrentQuiz = new Quiz(temp.getQuestion(),temp.getAnswer(),temp2.getAnswer(),temp3.getAnswer(),temp4.getAnswer());
        CurrentQuiz.shuffleAnswers();
        Deck.add(temp4);
        Deck.add(temp2);
        Deck.add(temp3);
        Deck.add(temp);
    }


    public String CheckAnswer(int i){
      Card temp = CurrentQuestion;
      String s = "Wrong!";
      switch (i){
          case 1:
              if(temp.checkanswer(CurrentQuiz.Answer1)){
                  numberCorrect+=1;
                  s = "Correct!";
              }else{
                  s = ("Wrong");
              }

              break;
          case 2:
              if(temp.checkanswer(CurrentQuiz.Answer2)){
                  numberCorrect+=1;
                  s = "Correct!";
              }else{
                  s = ("Wrong");
              }
              break;
          case 3:
              if(temp.checkanswer(CurrentQuiz.Answer3)){
                  numberCorrect+=1;
                  s = "Correct!";
              }else{
                  s = ("Wrong");
              }
              break;
          case 4:
              if(temp.checkanswer(CurrentQuiz.Answer4)){
                  numberCorrect+=1;
                  s = "Correct!";
              }else{
                  s = ("Wrong");
              }
              break;
          default:
              s = ("Wrong");
              break;

      }
      System.out.println("Number correct: "+numberCorrect);
      return s;
    }

}
