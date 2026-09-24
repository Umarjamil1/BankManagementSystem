package com.mycompany.bankmanaementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class MiniStatement extends JFrame implements ActionListener {

    String Pinnumber;
    JButton back;

    MiniStatement(String Pinnumber){

        this.Pinnumber = Pinnumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel Bank = new JLabel("ABC Bank");
        Bank.setFont(new Font("Segoe UI", Font.BOLD, 18));
        Bank.setBounds(150, 20, 200, 25);
        add(Bank);

        JLabel card = new JLabel();
        card.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        card.setBounds(20, 60, 350, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setVerticalAlignment(SwingConstants.TOP);
        mini.setBounds(20, 100, 400, 260);
        add(mini);

        JLabel balance = new JLabel();
        balance.setFont(new Font("Segoe UI", Font.BOLD, 14));
        balance.setBounds(20, 400, 350, 25);
        add(balance);

        back = new JButton("Back");
        back.setBounds(150, 500, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try{
            conn c = new conn();

            // ---- Card Number fetch karein ----
            ResultSet rs1 = c.s.executeQuery("select * from User_login where Pinnumber = '" + Pinnumber + "'");
            while(rs1.next()){
                String cardNo = rs1.getString("cardnumber");
                card.setText("Card Number: " + cardNo.substring(0,4) + "XXXXXXXX" + cardNo.substring(12));
            }

            // ---- Transactions fetch karein ----
            StringBuilder sb = new StringBuilder("<html>");
            int balanceAmount = 0;

            ResultSet rs2 = c.s.executeQuery("select * from Bank where Pinnumber = '" + Pinnumber + "'");
            while(rs2.next()){
                String type = rs2.getString("transcation_type");
                String amount = rs2.getString("amount");
                String date = rs2.getString("Date");

                sb.append(date)
                  .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(type)
                  .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(amount)
                  .append("<br><br>");

                if(type.equals("Deposit")){
                    balanceAmount += Integer.parseInt(amount);
                } else {
                    balanceAmount -= Integer.parseInt(amount);
                }
            }
            sb.append("</html>");

            mini.setText(sb.toString());
            balance.setText("Current Balance: Rs " + balanceAmount);

        }
        catch (Exception ex){
            System.err.println(ex);
        }

        setSize(450, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Transcations(Pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}