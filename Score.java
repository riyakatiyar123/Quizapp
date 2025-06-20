package Quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Score extends JFrame implements ActionListener{

    Score(String name,int score)
    
    {
         getContentPane().setBackground(Color.WHITE);
        
    setBounds(100,100,1200,700);
    setLayout(null);        


    ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("Quizapp/icons/ -4 18.36.48.jpg"));
    Image scaledImage = i3.getImage().getScaledInstance(500, 700, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon1 = new ImageIcon(scaledImage);
    JLabel lb1 = new JLabel(scaledIcon1);
    lb1.setBounds(-200,0,900,700);
    add(lb1);

    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Quizapp/icons/quizphoto.png"));
    Image scaledImage2 = i4.getImage().getScaledInstance(700, 200, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
    JLabel lb4 = new JLabel(scaledIcon2);
    lb4.setBounds(430,0,900,200);
    add(lb4);


    JLabel bk=new JLabel("Thank you for playing Creative Minds");
    bk.setFont(new Font("Raleway",Font.BOLD,30));
    bk.setBounds(550,200,600,70);
    add(bk);

     JLabel scr=new JLabel("YOUR SCORE IS   "+score);
    scr.setFont(new Font("Raleway",Font.BOLD,30));
    scr.setBounds(700,300,400,70);
    add(scr);

    JButton play=new JButton("PLAY AGAIN");
    play.setFont(new Font("Raleway",Font.BOLD,20));
    play.setBounds(760,470,150,50);
    play.addActionListener(this);
    add(play);
   
   setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
     setVisible(false);
     new Login();
    }

    public static void main(String[] args)
    {
        new Score("user",0);
    }
    
}
