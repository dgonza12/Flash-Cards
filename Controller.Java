package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * Created by danny on 2/28/17.
 * help and some code from Tutorials Point on Swing:
 * https://www.tutorialspoint.com/swing/swing_event_handling.htm
 */
public class Controller {
    private JFrame mainframe;
    private JLabel QuestionLabel;
    private JLabel Alabel;
    private JLabel Blabel;
    private JLabel Clabel;
    private JLabel Dlabel;
    private JPanel controlPanel;
    private CardBackPack backpack;
    public Controller(CardBackPack b){
        backpack = b;
        prepareGUI();
        showQuiz();
    }

    private void prepareGUI(){
        mainframe = new JFrame("FlashCards");
        mainframe.setSize(500,400);
        mainframe.setLayout(new GridLayout(6,1));

        QuestionLabel = new JLabel("",JLabel.CENTER);
        Alabel = new JLabel("",JLabel.CENTER);
        Blabel = new JLabel("",JLabel.CENTER);
        Clabel = new JLabel("",JLabel.CENTER);
        Dlabel = new JLabel("",JLabel.CENTER);
        mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainframe.add(controlPanel);
        mainframe.add(QuestionLabel);
        mainframe.add(Alabel);
        mainframe.add(Blabel);
        mainframe.add(Clabel);
        mainframe.add(Dlabel);
        mainframe.setVisible(true);
    }

    private void update(){
        backpack.Shuffledeck();
        backpack.CreateQuiz();
        QuestionLabel.setText(backpack.CurrentQuiz.getQuestion()+". Number correct:"+backpack.numberCorrect);
        Alabel.setText("{a}"+backpack.CurrentQuiz.getAnswer1());
        Blabel.setText("{b}"+backpack.CurrentQuiz.getAnswer2());
        Clabel.setText("{c}"+backpack.CurrentQuiz.getAnswer3());
        Dlabel.setText("{d}"+backpack.CurrentQuiz.getAnswer4());
    }


    private void showQuiz(){
        QuestionLabel.setText(backpack.CurrentQuiz.getQuestion()+". Number correct:"+backpack.numberCorrect);
        Alabel.setText("{a}"+backpack.CurrentQuiz.getAnswer1());
        Blabel.setText("{b}"+backpack.CurrentQuiz.getAnswer2());
        Clabel.setText("{c}"+backpack.CurrentQuiz.getAnswer3());
        Dlabel.setText("{d}"+backpack.CurrentQuiz.getAnswer4());
        JButton aButton = new JButton("A");
        JButton bButton = new JButton("B");
        JButton cButton = new JButton("C");
        JButton dButton = new JButton("D");

        aButton.setActionCommand("A");
        bButton.setActionCommand("B");
        cButton.setActionCommand("C");
        dButton.setActionCommand("D");

        aButton.addActionListener(new ButtonClickListener());
        bButton.addActionListener(new ButtonClickListener());
        cButton.addActionListener(new ButtonClickListener());
        dButton.addActionListener(new ButtonClickListener());

        controlPanel.add(aButton);
        controlPanel.add(bButton);
        controlPanel.add(cButton);
        controlPanel.add(dButton);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            String s = "";
            if(command.equals("A")){
                s = backpack.CheckAnswer(1);
            } else if(command.equals("B")){
                s = backpack.CheckAnswer(2);
            } else if(command.equals("C")){
                s = backpack.CheckAnswer(3);
            } else {
                s = backpack.CheckAnswer(4);
            }
        QuestionLabel.setText(s);
        update();
        }

    }
}
