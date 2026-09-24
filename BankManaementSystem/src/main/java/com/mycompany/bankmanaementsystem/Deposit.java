
package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{

    JTextField Amount;
    JButton Deposit , Back ;
    String Pinnumber;
    
    public Deposit(String Pinnumber ) {
        this.Pinnumber = Pinnumber;
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 900, 900);
        add(Image);
        
        Font textfont = new Font("System", Font.BOLD,16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        
        JLabel text = new JLabel("Enter the amount you want to Deposit");
        text.setForeground(Color.WHITE);
        text.setBounds(200, 310, 700, 35);
        text.setFont(textfont);
        Image.add(text);
        
        Amount = new JTextField();
        Amount.setFont(fieldFont);
        Amount.setBounds(200, 350, 280, 35);
        Image.add(Amount);
        
        
        Deposit = new JButton ("Deposit");
        Deposit.setBounds(360, 530, 150, 30);
        Deposit.addActionListener(this);
        Image.add(Deposit);
        
        Back = new JButton ("Back");
        Back.setBounds(360, 565, 150, 30);
        Back.addActionListener(this);
        Image.add(Back);
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Back){
            setVisible(false);
            new Transcations(Pinnumber).setVisible(true);
        }else if (e.getSource() == Deposit){
            try{
                String amount = Amount.getText();
                Date date = new Date();
                if(Amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your deposit amount");
                }else {
                
                    conn c = new conn();
                    String query = "insert into Bank values ('" + amount + "','" + Pinnumber + "','Deposit','" + date + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs '"+amount+"' Deposite successfully");
                    setVisible(false);
                    new Transcations(Pinnumber).setVisible(true);
                }
            
            }catch(Exception ex){
                System.out.println(ex);
            }
        
        }
        
    
    }
    
    public static void main (String [] args){
    
        new Deposit("");
    }
    
}
