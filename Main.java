package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {




    CardBackPack CBP = new CardBackPack();

    Card d = new Card("Who made this?","Danny");
    CBP.AddCard(d);
    d = new Card("How many bits does a short have?","16 bits");
    CBP.AddCard(d);
    d = new Card("How many bits does a int have?","32 bits");
    CBP.AddCard(d);
    d = new Card("How many bits does a char have?","16 bits");
    CBP.AddCard(d);
    d = new Card("How many bits does a double have?","64 bits");
    CBP.AddCard(d);
    CBP.CreateQuiz();
    Controller c = new Controller(CBP);



    }
}
