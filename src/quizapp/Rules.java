package quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    JButton b1,b2;
    String username;
    Rules(String username){
        this.username = username;
        setBounds(600,200,800,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Welcome " + username + " kindly read the rules");
        l1.setForeground(new Color(30, 144, 255));
        l1.setBounds( 50, 20, 650, 30);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(l1);
        JLabel l2 = new JLabel("");
        l2.setFont(new Font("Times new Roman", Font.BOLD, 22));
        l2.setBounds(30, 80, 750, 400);
        l2.setText(
                "<html>"+
                    "1. User need to answer all 10 questions all questions carry equal marks." +"<br><br>"+
                    "2. There are ten questions each question carrries 10 marks each."+"<br><br> "+
                    "3. The time for each question is 20 seconds user must answer within 20 seconds."+"<br><br>"+
                    "4. User cannot submit the paper until he/she attempts all 10 questions."+"<br><br>"+
                    "5. User must score at least 30 points in order to pass."+"<br><br>"+
                "<html>" 
        );
        add(l2);
        b1 = new JButton("Back");
        b1.setBounds(250, 500, 100, 30);
        b1.setBackground(new Color(30, 144, 255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Start");
        b2.setBounds(400, 500, 100, 30);
        b2.setBackground(new Color(30, 144, 255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
        
    }
    
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == b1){
           this.setVisible(false);
           new QuizApp().setVisible(true);
       }else if(ae.getSource() == b2){
           new Quiz(username).setVisible(true);
       }
   }
    
   public static void main(String[] args){
       new Rules("");
   } 
}
