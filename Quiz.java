package Quizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.awt.color.*;



public class Quiz extends JFrame implements ActionListener{

String questions[][]=new String[10][5];
String answers[][]=new String[10][2];
String userans[][]=new String[10][1];

JLabel qno,question;
JRadioButton opt1,opt2,opt3,opt4;
ButtonGroup groupoption;
JButton next,submit;
public int timer =10;
public int ans_given=0;//FLAG
public int count;
public int score;
String name;
    Quiz(String name)
    {
      this.name=name;
    setLayout(null); 
    setBounds(250,50,1100,700);
    setVisible(true);
    getContentPane().setBackground(Color.WHITE);
        
       
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Quizapp/icons/quiz-time-9163843_1280.jpg"));
    Image scaledImage = i1.getImage().getScaledInstance(600, 250, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    JLabel lb = new JLabel(scaledIcon);
    lb.setBounds(100,0,900,290);
    add(lb);

    qno=new JLabel();
    qno.setFont(new Font("Raleway",Font.BOLD,25));
    qno.setBounds(20,300,60,70);
    add(qno);

    question=new JLabel();
    question.setFont(new Font("Raleway",Font.BOLD,25));
    question.setBounds(70,300,1000,70);
    add(question);

    questions[0][0]="What is the size of an int in Java?";
    questions[0][1]=" 8 bits";
    questions[0][2]=" 16 bits";
    questions[0][3]=" 32 bits";
    questions[0][4]=" 64 bits";

    questions[1][0]="Which keyword is used to inherit a class in Java?";
    questions[1][1]=" implement";
    questions[1][2]=" import ";
    questions[1][3]=" extends ";
    questions[1][4]=" inherit";

    questions[2][0]="Which of the following is not a Java keywords";
    questions[2][1]=" static";
    questions[2][2]=" include";
    questions[2][3]=" booelan";
    questions[2][4]=" final";

    questions[3][0]="What is the default value of a local variable in Java?";
    questions[3][1]=" 0";
    questions[3][2]=" null";
    questions[3][3]=" false";
    questions[3][4]=" It must be initialized before use";

    questions[4][0]="Which method is used to start a thread execution?";
    questions[4][1]=" start()";
    questions[4][2]=" begin()";
    questions[4][3]=" run()";
    questions[4][4]=" execute";

    questions[5][0]="Which of these is not a feature of Java?";
    questions[5][1]=" Object-Oriented";
    questions[5][2]=" Platform Independent";
    questions[5][3]=" Uses pointers explicitly";
    questions[5][4]=" Automatic Garbage Collection";

    questions[6][0]=" What is the parent class of all Java classes?";
    questions[6][1]=" java.lang.Class";
    questions[6][2]=" java.lang.Super";
    questions[6][3]=" java.lang.Object";
    questions[6][4]=" java.util.Base";

    questions[7][0]="What will be the output of System.out.println(10 + 20 + \"30\");?";
    questions[7][1]=" 1030 ";
    questions[7][2]=" 102030 ";
    questions[7][3]=" 30";
    questions[7][4]=" 3030";

    questions[8][0]=" Which exception is thrown when an array is accessed with an illegal index?";
    questions[8][1]="  NullPointerException";
    questions[8][2]="  ArrayIndexOutOfBoundsException";
    questions[8][3]="  IllegalArgumentException";
    questions[8][4]="  NumberFormatException";

    questions[9][0]=" Which collection class allows duplicate elements?";
    questions[9][1]="  HashSet";
    questions[9][2]="  TreeSet";
    questions[9][3]="  ArrayList";
    questions[9][4]="  LinkedHashSet";

    answers[0][1]=" 32 bits";
    answers[1][1]=" extends";
    answers[2][1]=" include";
    answers[3][1]=" It must be initialized before use";
    answers[4][1]=" start()";
    answers[5][1]=" Uses pointers explicitly";
    answers[6][1]=" java.lang.Object";
    answers[7][1]=" 1030 ";
    answers[8][1]= " ArrayIndexOutOfBoundsException";
    answers[9][1]=" ArrayList";


    opt1=new JRadioButton();
    opt1.setFont(new Font("Raleway",Font.BOLD,20));
    opt1.setBounds(20,400,400,50);
    opt1.addActionListener(this);
    add(opt1);

    opt2=new JRadioButton();
    opt2.setFont(new Font("Raleway",Font.BOLD,20));
    opt2.setBounds(20,450,400,50);
    opt2.addActionListener(this);
    add(opt2);

    opt3=new JRadioButton();
    opt3.setFont(new Font("Raleway",Font.BOLD,20));
    opt3.setBounds(20,500,400,50);
    opt3.addActionListener(this);
    add(opt3);

    opt4=new JRadioButton();
    opt4.setFont(new Font("Raleway",Font.BOLD,20));
    opt4.setBounds(20,550,400,50);
    opt4.addActionListener(this);
    add(opt4);

    groupoption=new ButtonGroup();
    groupoption.add(opt1);
    groupoption.add(opt2);
    groupoption.add(opt3);
    groupoption.add(opt4);

    next=new JButton("NEXT");
    next.setBounds(700,450,170,50);
    next.setFont(new Font("Raleway",Font.BOLD,27));
    next.addActionListener(this);
    add(next);

    submit=new JButton("SUBMIT");
    submit.setBounds(700,520,170,50);
    submit.setFont(new Font("Raleway",Font.BOLD,27));
    submit.addActionListener(this);
    submit.setEnabled(false);
    add(submit);

    start(count);

    setVisible(true);
    }

  //   public void paint(Graphics g)
  //   {
  //     super.paint(g);

  //     String time = "Time left "+ timer +" seconds";
  //     g.setColor(Color.RED);
  //     g.setFont(new Font("Raleway",Font.BOLD,27));

  //     if(timer>0)
  //     {
  //       g.drawString(time,700,450);
  //     }
  //     else{
  //      g.drawString("TIMES UP!!",700,450);
  //     }
  //     timer--;
      
  //     try{
  //       Thread.sleep(1000);
  //       repaint();
  //     }
  //     catch(Exception e){
  //      e.printStackTrace();
  //     }

  //     if(ans_given==1)
  //     {
  //       timer=10;
  //       ans_given=0;
  //     }
  //     else if(timer<0)
  //     {
  //        timer=10;
  //       if(count==8)
  //       {
  //         next.setEnabled(false);
  //         submit.setEnabled(true);
  //       }
  //       if(count==9)//submit case
  //      {
  //       if(groupoption.getSelection()==null)
  //        {
  //          userans[count][0]="";
  //        }
  //        else{
  //        userans[count][0]=groupoption.getSelection().getActionCommand();
  //         }
  //        for (int i=0;i<userans.length;i++)
  //        {
  //         if(userans[i][0].equals(answers[i][1]))
  //         {
  //            score+=10;
  //         }
          
  //        }
  //        setVisible(false);
  //        new Score(name,score);
  //       }
  //       else//next case
  //      {
  //        if(groupoption.getSelection()==null)
  //        {
  //          userans[count][0]="";
  //        }
  //        else{
  //        userans[count][0]=groupoption.getSelection().getActionCommand();

  //        }
  //        if (count == 8) { // Next is the last question (index 9)
  //       count++;
  //       start(count);
  //        if (count < 10) {
  //       start(count);
  //        }
  //       next.setEnabled(false);
  //       submit.setEnabled(true);
  //        }
  //        else if (count < 8)
  //        {
        
  //        count++;
  //        if(count<10)
  //        start(count);
  //       }
  //     }
  //   }
  // }

      
   public void paint(Graphics g) {
    super.paint(g);

    String time = "Time left " + timer + " seconds";
    g.setColor(Color.RED);
    g.setFont(new Font("Raleway", Font.BOLD, 27));

    if (timer > 0) {
        g.drawString(time, 700, 450);
    } else {
        g.drawString("TIMES UP!!", 700, 450);
    }

    timer--;

    try {
        Thread.sleep(1000);
        repaint();
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (ans_given == 1) {
        timer = 10;
        ans_given = 0;
    } else if (timer < 0) {
        timer = 10;

        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        if (count == 9) {
            // Submit case
            if (groupoption.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = groupoption.getSelection().getActionCommand();
            }

            

            setVisible(false);
            new Score(name, score);
        } else {
            // Next question case
            if (groupoption.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = groupoption.getSelection().getActionCommand();
            }

            count++;

            if (count < 10) {
                start(count);
            }

            if (count == 9) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        }
    }
}

   
      

    
    
    
     public void start(int count)
    {
       qno.setText(""+(count+1)+" . ");
       question.setText(questions[count][0]);
       opt1.setText(questions[count][1]);
       opt1.setActionCommand(questions[count][1]);
       //Use setActionCommand() when you want to easily fetch the selected answer string for scoring or processing the quiz results.
      //allows you to store the actual value/label of the option

       opt2.setText(questions[count][2]);
       opt2.setActionCommand(questions[count][2]);

       opt3.setText(questions[count][3]);
       opt3.setActionCommand(questions[count][3]);

       opt4.setText(questions[count][4]);
       opt4.setActionCommand(questions[count][4]);

       groupoption.clearSelection();
    }





    //  public void actionPerformed(ActionEvent ae)
    // {
    //   if(ae.getSource()==next)
    //   {
    //     repaint();//You change something visually on the screen (like a score, timer, shape, etc.)
       
    //     ans_given=1;
    //      if(groupoption.getSelection()==null)
    //      {
    //        userans[count][0]="";
    //      }
    //      else{
    //      userans[count][0]=groupoption.getSelection().getActionCommand();

    //      }
    //      if (count==8)
    //      {
    //       next.setEnabled(false);
    //       submit.setEnabled(true);
    //      }
    //     count++;
    //     start(count);
    //   }

    //     else 
    //     {
    //       if(groupoption.getSelection()==null)
    //      {
    //        userans[count][0]="";
    //      }
    //      else
    //      { 
    //      userans[count][0]=groupoption.getSelection().getActionCommand();
    //      }
    //      for (int i=0;i<userans.length;i++)
    //      {
    //       if(userans[i][0].trim().equals(answers[i][1].trim()))
    //       {
    //          score+=10;
    //       }
         
    //    }
      
    //   setVisible(false);
    // new Score(name,score);
    //   }
    // }

    public void actionPerformed(ActionEvent ae)
{
    if (ae.getSource() == next)
    {
        ans_given = 1;

        // Save current answer
        if (groupoption.getSelection() == null) {
            userans[count][0] = "";
        } else {
            userans[count][0] = groupoption.getSelection().getActionCommand();
        }

        // Last question
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }

        count++;
        start(count);  // Go to next question
    }
    else if (ae.getSource() == submit)
    {
        // Save current answer
        if (groupoption.getSelection() == null) {
            userans[count][0] = "";
        } else {
            userans[count][0] = groupoption.getSelection().getActionCommand();
        }

        // Call clean score calculation method
        calculateScore();

        setVisible(false);
        new Score(name, score);
    }
}
public void calculateScore() {
    score = 0;  // Ensure we start from 0
    for (int i = 0; i < userans.length; i++) {
        if (userans[i][0] != null && userans[i][0].trim().equals(answers[i][1].trim())) {
            score += 10;
        }
    }
}
      
    public static void main(String[] args)
    {
        new Quiz("username");
    }
  }

    

