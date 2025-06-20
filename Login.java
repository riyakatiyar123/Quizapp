package Quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
    JButton rule,back;
    JTextField namef;

Login()
{
    setLayout(null);
    //to select the whole panel use getContentPane
    getContentPane().setBackground(Color.WHITE);

    //we have a class name imageicon inside jframe
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Quizapp/icons/quiz-2074324_1280.png"));
    Image scaledImage = i1.getImage().getScaledInstance(550, 250, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    JLabel lb = new JLabel(scaledIcon);
    lb.setBounds(100,10,700,300);
    add(lb);

    JLabel heading=new JLabel("CREATIVE MINDS");
    heading.setFont(new Font("Raleway",Font.BOLD,35));
    heading.setBounds(300,300,400,100);
    add(heading);

    JLabel name=new JLabel("Enter Your Name:");
    name.setFont(new Font("Raleway",Font.BOLD,25));
    name.setBounds(170,400,250,100);
    add(name);

    namef=new JTextField();
    namef.setFont(new Font("Times New Roman",Font.BOLD,25));
    namef.setBounds(400,430,400,40);
    add(namef);

   rule=new JButton("RULES");
   rule.setFont(new Font("Raleway",Font.BOLD,25));
   rule.setBounds(600,520,150,50);
    //rule.setBackground(new Color(30,144,254));
    //rule.setForeground(Color.WHITE);
   rule.addActionListener(this);
    add(rule);

    back=new JButton("CLOSE");
    back.setFont(new Font("Raleway",Font.BOLD,25));
    back.setBounds(300,520,150,50);
    back.addActionListener(this);
    add(back);
    
    setSize(900,700);
    setLocation(200,150);
 
    setVisible(true);
}


public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==rule)
    {
     String namefield=namef.getText();
     setVisible(false);
     new Rules(namefield);

    }
    else if(ae.getSource()==back)
    {
        setVisible(false);//we have to close the screen if back is closed 
    }

}
public static void main(String args[])
    {
        new Login();
    }
    
}
