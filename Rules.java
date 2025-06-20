package Quizapp;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
    JButton previous,start;
    String namefield;

    Rules(String namefield)
    {
        this.namefield=namefield;

        

     

     JLabel content=new JLabel("WELCOME "+namefield+" T0 CREATIVE MINDS");
     content.setFont(new Font("Raleway",Font.BOLD,27));
     content.setBounds(140,7,800,100);
     add(content);

     JLabel rules=new JLabel();
     rules.setFont(new Font("Trebuchet MS",Font.BOLD,19));
     rules.setBounds(10,500,700,700);
     rules.setText("<html>"
    + "1. Each quiz contains 10 multiple-choice questions.<br><br><br><br><br><br>"
    + "1. Each quiz contains 10 multiple-choice questions.<br><br>"
    + "2. You will have 10 seconds to answer each question.<br><br>"
    + "3. Only one option is correct for each question.<br><br>"
    + "4. No negative marking for wrong answers.<br><br>"
    + "5. Once you select an option, it cannot be changed.<br><br>"
    + "6. You cannot skip a question; you must answer to move forward.<br><br>"
    + "7. Your final score will be displayed at the end of the quiz.<br><br>"
    + "8. Do not close the window or refresh the page during the quiz.<br><br>"
    + "9. Each quiz contains 10 multiple-choice questions.<br><br>"
    + "10. Click the \"Start\" button below to begin the quiz."
    + "</div></html>");
    rules.setBounds(50, 50, 800, 400);
    add(rules);

    previous=new JButton("PREVIOUS");
    previous.setFont(new Font("Raleway",Font.BOLD,25));
    previous.setBounds(100,520,150,45);
    // previous.setpreviousground(new Color(30,144,254));
    // previous.setForeground(Color.WHITE);
    previous.addActionListener(this);
    add(previous);

    start=new JButton("START");
    start.setFont(new Font("Raleway",Font.BOLD,25));
    start.setBounds(500,520,150,45);
    start.addActionListener(this);
    add(start);
    

    





      getContentPane().setBackground(Color.WHITE);  
      setLayout(null);
      setSize(800,700);
      setLocation(200,100);
      setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            setVisible(false);
          new Quiz("user");
        }
        else 
        {
           setVisible(false);
            new Login(); 
        }

    }
    public static void main(String[] args)
    {
        new Rules("username");
    }
    
}
