package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class Cashwithdrawal extends JFrame implements ActionListener{

    JTextField Amount;
    JButton Cashwithdrawal , Back ;
    String Pinnumber;

    public Cashwithdrawal(String Pinnumber ) {
        this.Pinnumber = Pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 900, 900);
        add(Image);

        Font textfont = new Font("System", Font.BOLD,16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel text = new JLabel("Enter the amount you want to Cash withdrawal");
        text.setForeground(Color.WHITE);
        text.setBounds(200, 310, 700, 35);
        text.setFont(textfont);
        Image.add(text);

        Amount = new JTextField();
        Amount.setFont(fieldFont);
        Amount.setBounds(200, 350, 280, 35);
        Image.add(Amount);

        Cashwithdrawal = new JButton ("Cash withdrawal");
        Cashwithdrawal.setBounds(360, 530, 150, 30);
        Cashwithdrawal.addActionListener(this);
        Image.add(Cashwithdrawal);

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
        }else if (e.getSource() == Cashwithdrawal){
            try{
                String amount = Amount.getText();

                if(amount.equals("")){   // 'Amount' se 'amount' kiya
                    JOptionPane.showMessageDialog(null, "Please enter your Cash Withdrawal amount");
                }else {
                    conn c = new conn();

                    // ---- Balance check add kiya ----
                    ResultSet rs = c.s.executeQuery("select * from Bank where PINnumber = '" + Pinnumber + "'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("transcation_type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    int withdrawAmount = Integer.parseInt(amount);
                    if(balance < withdrawAmount){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    Date date = new Date();
                    String query = "insert into Bank values ('" + amount + "','" + Pinnumber + "','Cashwithdrawal','" + date + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Cash withdrawal successful");
                    setVisible(false);
                    new Transcations(Pinnumber).setVisible(true);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }

    public static void main (String [] args){
        new Cashwithdrawal("");
    }
}