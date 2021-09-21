import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculator implements ActionListener
{
    JFrame frame;
    JTextField tf;
    JButton[] num= new JButton[10];
    JButton[] func= new JButton[9];
    JButton add,sub,mul,div,dec,equ,del,clr,neg;
    JPanel panel;

    Font myfont = new Font("Arial",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    calculator()
    {
        //frame 
        frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,520);
        frame.setLayout(null);

        //text field configure
        tf= new JTextField();
        tf.setBounds(50,25,300,50);
        tf.setFont(myfont);
        tf.setEditable(false);

        //function buttons configue
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        clr = new JButton("clear");
        equ = new JButton("=");
        del = new JButton("delete");
        neg = new JButton("(-)");


        func[0]= add;
        func[1]= sub;
        func[2]= mul;
        func[3]= div;
        func[4]= dec;
        func[5]= clr;
        func[6]= equ;
        func[7]= del;
        func[8]= neg;

        for(int i=0;i<9;i++)
        {
            func[i].addActionListener(this);
            func[i].setFont(myfont);
            func[i].setFocusable(false);
        }

        
        for(int i=0;i<10;i++)
        {
         num[i]= new JButton(String.valueOf(i));
         num[i].addActionListener(this);
         num[i].setFont(myfont);
         num[i].setFocusable(false);
        }

        neg.setBounds(50,430,100,50);
        del.setBounds(150,430,100,50);
        clr.setBounds(250,430,100,50);

        //panel configure
        panel= new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.white);

        panel.add(num[1]);
        panel.add(num[2]);
        panel.add(num[3]);
        panel.add(add);
        panel.add(num[4]);
        panel.add(num[5]);
        panel.add(num[6]);
        panel.add(sub);
        panel.add(num[7]);
        panel.add(num[8]);
        panel.add(num[9]);
        panel.add(mul);
        panel.add(div);
        panel.add(dec);
        panel.add(num[0]);
        panel.add(equ);

        //adding element to the frame
        frame.add(tf);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(panel);
        frame.setVisible(true);


    }
    
    public static void main(String[] args)
    {
        calculator calc = new calculator();

        
    }

    @Override

public void actionPerformed(ActionEvent e){
  for(int i=0;i<10;i++)
  {
    if(e.getSource()==num[i])
    {
      tf.setText(tf.getText().concat(String.valueOf(i)));
    }
  }

  if(e.getSource()==dec)
  {
    tf.setText(tf.getText().concat(String.valueOf(".")));
  }

  if(e.getSource()==add)
  {
    num1=Double.parseDouble(tf.getText());
    operator='+';
    tf.setText("");
  }

  if(e.getSource()==sub)
  {
    num1=Double.parseDouble(tf.getText());
    operator='-';
    tf.setText("");
  }
  
  if(e.getSource()==mul)
  {
    num1=Double.parseDouble(tf.getText());
    operator='*';
    tf.setText("");
  }
  
  if(e.getSource()==div)
  {
    num1=Double.parseDouble(tf.getText());
    operator='/';
    tf.setText("");
  }

  if(e.getSource()==equ)
  {
    num2=Double.parseDouble(tf.getText());
    switch(operator)
    {
      case '+':
      result=num1+num2;
      break;

      case '-':
      result=num1-num2;
      break;

      case '*':
      result=num1*num2;
      break;

      case '/':
      result=num1/num2;
      break;
    }
    tf.setText(String.valueOf(result));
    num1=result;
  }

   
  if(e.getSource()==clr)
  {
   tf.setText(" ");
  }

  if(e.getSource()==del)
  {
    String str=tf.getText();
    tf.setText("");
    for(int i=0;i<str.length()-1;i++)
    {
      tf.setText(tf.getText()+str.charAt(i));
    }
  }

  if(e.getSource()==neg)
  {
   double temp=Double.parseDouble(tf.getText());
   temp*=-1;
   tf.setText(String.valueOf(temp));
  }

}

}


