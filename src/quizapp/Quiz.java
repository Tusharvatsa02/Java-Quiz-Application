package quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    JButton submit,next;
    JLabel qno,question;
    public static int count = 0;
    public static int timer = 20;
    public static int ans_given = 0;
    public static int score = 0;
    String q[][] = new String[10][5];
    String pa[][] = new String[10][1];
    String qa[][] = new String[10][2];
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup options;
    String username;
    
    Quiz(String username){
        this.username = username;
        setBounds(250, 50, 1440, 950);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("quizapp/icons/quiz.jpg"));
        JLabel l1 = new JLabel(il);
        l1.setBounds(0, 0, 1440, 492);
        add(l1);
        
        qno = new JLabel("");
        qno.setFont(new Font("Tahoma", Font.PLAIN, 22));
        qno.setBounds(100, 480, 50, 30);
        add(qno);
        
        question = new JLabel("");
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setBounds(150, 480, 1200, 30);
        add(question);
        
        q[0][0] = "How can we describe an array in the best possible way?";
        q[0][1] = "The Array shows a hierarchical structure.";
        q[0][2] = "Arrays are immutable.";
        q[0][3] = "Container that stores the elements of similar types";
        q[0][4] = "The Array is not a data structure";

        q[1][0] = "Which of the following is the correct way of declaring an array?";
        q[1][1] = "int javatpoint[10];";
        q[1][2] = "int javatpoint;";
        q[1][3] = "javatpoint{20};";
        q[1][4] = "array javatpoint[10];";

        q[2][0] = "How can we initialize an array in C language?";
        q[2][1] = "int arr[2]=(10, 20)";
        q[2][2] = "int arr(2)={10, 20}";
        q[2][3] = "int arr[2] = {10, 20}";
        q[2][4] = "int arr(2) = (10, 20)";

        q[3][0] = "Which one of the following is the process of inserting an element in the stack?";
        q[3][1] = "Insert";
        q[3][2] = "Add";
        q[3][3] = "Push";
        q[3][4] = "None of the above";

        q[4][0] = "When the user tries to delete the element from the empty stack then the condition is said to be a ____";
        q[4][1] = "Underflow";
        q[4][2] = "Garbage collection";
        q[4][3] = "Overflow";
        q[4][4] = "None of the above";

        q[5][0] = "Which of the following is not the correct statement for a stack data structure?";
        q[5][1] = "Arrays can be used to implement the stack";
        q[5][2] = "Stack follows FIFO";
        q[5][3] = "Elements are stored in a sequential manner";
        q[5][4] = "Top of the stack contains the last inserted element";

        q[6][0] = "If the elements '1', '2', '3' and '4' are added in a stack, so what would be the order for the removal?";
        q[6][1] = "1234";
        q[6][2] = "2134";
        q[6][3] = "4321";
        q[6][4] = "None of the above";

        q[7][0] = "Which of the following principle does Queue use?";
        q[7][1] = "LIFO principle";
        q[7][2] = "FIFO principle";
        q[7][3] = "Linear tree";
        q[7][4] = "Ordered array";

        q[8][0] = "Which of the following is the time complexity to search an element in the linked list?";
        q[8][1] = "O(1)";
        q[8][2] = "O(n)";
        q[8][3] = "O(logn)";
        q[8][4] = "O(nlogn)";

        q[9][0] = "What is the maximum number of children that a node can have in a binary tree?";
        q[9][1] = "3";
        q[9][2] = "1";
        q[9][3] = "4";
        q[9][4] = "2";
        
        qa[0][1] = "Container that stores the elements of similar types";
        qa[1][1] = "int javatpoint[10];";
        qa[2][1] = "int arr[2] = {10, 20}";
        qa[3][1] = "Push";
        qa[4][1] = "Underflow";
        qa[5][1] = "Stack follows FIFO";
        qa[6][1] = "4321";
        qa[7][1] = "FIFO principle";
        qa[8][1] = "O(n)";
        qa[9][1] = "2";
        
        opt1 = new JRadioButton("");
        opt1.setBounds(170, 530, 800, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBackground(Color.WHITE);
        add(opt1);
        
        opt2 = new JRadioButton("");
        opt2.setBounds(170, 580, 800, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBackground(Color.WHITE);
        add(opt2);
        
        opt3 = new JRadioButton("");
        opt3.setBounds(170, 630, 800, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.WHITE);
        add(opt3);
        
        opt4 = new JRadioButton("");
        opt4.setBounds(170, 680, 800, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.WHITE);
        add(opt4);
        
        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        
        next = new JButton("Next");
        next.setFont(new Font("Tahima", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setBounds(1100, 700, 200, 40);
        add(next);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Tahima", Font.PLAIN, 22));
        submit.setEnabled(false);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(1100, 800, 200, 40);
        add(submit);
        
        start(0);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            ans_given = 1;
            if(options.getSelection() == null){
                pa[count][0] ="";
            }else{
                pa[count][0] = options.getSelection().getActionCommand();
            }
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(ae.getSource() == submit){
                ans_given = 1;
             if(options.getSelection() == null){
                     pa[count][0] ="";
            }else{
                pa[count][0] = options.getSelection().getActionCommand();
                }
                
                for(int i = 0 ; i < pa.length ; i++){
                    if(pa[i][0].equals(qa[i][1])){
                        score+=10;
                }else{
                        score+=0;
                }  
        } 
                this.setVisible(false);
                new Score(username, score).setVisible(true);
    }
 }
    
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time-Left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if(timer > 0){
            g.drawString(time, 1110, 600);
        }else{
            g.drawString("Time's up!", 1110, 600);
        }
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 20;
        }else if(timer < 0){
            timer = 20;
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(options.getSelection() == null){
                     pa[count][0] ="";
            }else{
                pa[count][0] = options.getSelection().getActionCommand();
            }
                
            for(int i = 0 ; i < pa.length ; i++){
                if(pa[i][0].equals(qa[i][1])){
                    score+=10;
                }else{
                    score+=0;
                }
            }
            this.setVisible(false);
            new Score(username, score).setVisible(true);
         }else{
                if(options.getSelection() == null){
                     pa[count][0] ="";
            }else{
                pa[count][0] = options.getSelection().getActionCommand();
          }
        }
            count++;
            start(count);
      }
  }
    
    public void start(int count){
        qno.setText("" + (count + 1) +" . ");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();
        
    } 
    public static void main(String[] args){
        new Quiz("").setVisible(true);
    }
}
