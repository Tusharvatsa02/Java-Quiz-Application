package quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField t1;
    QuizApp(){
        setBounds(400, 200, 1200, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quizapp/Icons/Login.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 600, 400);
        add(l1);
        
        JLabel l2 = new JLabel("Tushar's Quiz");
        l2.setFont(new Font("Mongolian Baiti", Font.BOLD,40));
        l2.setBounds(750, 40, 300, 45);
        l2.setForeground(new Color(30, 144, 254));
        add(l2);
        
        JLabel l3 = new JLabel("Enter Your Name");
        l3.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        l3.setBounds(800, 150, 300, 25);
        l3.setForeground(new Color(30, 144, 254));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(730, 200, 300, 25);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(t1);
        
        b1 = new JButton("Start");
        b1.setBackground(new Color(30, 144, 254));
        b1.setForeground(Color.white);
        b1.setBounds(735, 270, 120, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Exit");
        b2.setBounds(915, 270, 120, 25);
        b2.setBackground(new Color(30, 144, 254));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String name = t1.getText();
            this.setVisible(false);
            new Rules(name);
        }else{
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new QuizApp();
    }
    
}
