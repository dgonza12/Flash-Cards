package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CardBackPack CBP = new CardBackPack();


    //Fills out the card deck with card whose question & answer are the i
    for(int i = 0;i<=100;i++){
        String s = Integer.toString(i);
        Card temp = new Card(s,s);
        CBP.AddCard(temp);
    }


    for(int i = 0; i<CBP.Deck.size(); i++){
        CBP.CreateQuiz();
        System.out.println("[Q#"+(i+1)+"]####################################[]");
        System.out.println("[Q]:"+CBP.CurrentQuiz.Question);
        System.out.println("[1]:"+CBP.CurrentQuiz.Answer1);
        System.out.println("[2]:"+CBP.CurrentQuiz.Answer2);
        System.out.println("[3]:"+CBP.CurrentQuiz.Answer3);
        System.out.println("[4]:"+CBP.CurrentQuiz.Answer4);
        System.out.println("[A#"+(i+1)+"]####################################[]");
        System.out.println("Please enter your Answer: ");
        String j = scanner.next();
        int k = Integer.parseInt(j);
        CBP.CheckAnswer(k);
    }



    }
}
