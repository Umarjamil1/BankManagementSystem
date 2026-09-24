
package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transcations extends JFrame implements ActionListener{
    
    JButton Deposit, Cashwithdrawal , Fastcash , MiniStatement , Pinchange , Balanceenquiry , Exit;
    String Pinnumber;

    Transcations(String Pinnumber){
        this.Pinnumber = Pinnumber;
        
        setLayout(null);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); 
        add(image);
        
        Font textfont = new Font("System", Font.BOLD,16); 
        
        
        JLabel text = new JLabel("Please Select Your Transcation");
        text.setBounds(235, 310, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(textfont);
        image.add(text);
        
        
        Deposit = new JButton ("Deposit");
        Deposit.setBounds(170, 450, 150, 30);
        Deposit.addActionListener(this);
        image.add(Deposit);
        
        Cashwithdrawal = new JButton (" Cash withdrawal");
        Cashwithdrawal.setBounds(360, 450, 150, 30);
        Cashwithdrawal.addActionListener(this);
        image.add(Cashwithdrawal);
        
        Fastcash = new JButton ("Fast cash");
        Fastcash.setBounds(170, 490, 150, 30);
        Fastcash.addActionListener(this);
        image.add(Fastcash);
        
        MiniStatement = new JButton ("Mini Statement");
        MiniStatement.setBounds(360, 490, 150, 30);
        MiniStatement.addActionListener(this);
        image.add(MiniStatement);
        
        Pinchange = new JButton ("Pin change");
        Pinchange.setBounds(170, 530, 150, 30);
        Pinchange.addActionListener(this);
        image.add(Pinchange);
        
        Balanceenquiry = new JButton ("Balance enquiry");
        Balanceenquiry.setBounds(360, 530, 150, 30);
        Balanceenquiry.addActionListener(this);
        image.add(Balanceenquiry);
        
        Exit = new JButton ("Exit");
        Exit.setBounds(360, 565, 150, 30);
        Exit.addActionListener(this);
        image.add(Exit);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
      
    }
    
        public void actionPerformed(ActionEvent e){
            
            if (e.getSource()== Exit){
                setVisible(false);
            }else if (e.getSource() == Deposit){
                setVisible(false);
                new Deposit(Pinnumber).setVisible(true);
            
            }else if (e.getSource() == Cashwithdrawal){
                setVisible(false);
                new Cashwithdrawal(Pinnumber).setVisible(true);                 
            }else if (e.getSource() == Fastcash){
                setVisible(false);
                new Fashcash(Pinnumber).setVisible(true); 
            }else if (e.getSource() == Pinchange){
                setVisible(false);
                new Pinchange(Pinnumber).setVisible(true);
            }else if(e.getSource() == Balanceenquiry){
                setVisible(false);
                new Balanceenquiry(Pinnumber).setVisible(true);
            }else if (e.getSource() == MiniStatement){
                new MiniStatement(Pinnumber).setVisible(true);
            }
        }
    
  
      public static void main(String[] args){
        new Transcations("");
    }
    
    
}

