package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton SA, FDA, CA, RDA;
    JCheckBox AC, IB, MB, ESA, CB, ES, Statement;
    JButton Submit, Cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        
        setLayout(null);
        setTitle("Automated Teller Machine");

        JLabel heading = new JLabel("Account Details:", SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setBounds(0, 15, 520, 40);
        add(heading);

        JLabel subHeading = new JLabel("Page 03: Account Selection", SwingConstants.CENTER);
        subHeading.setFont(new Font("Segoe UI", Font.BOLD, 14));
        subHeading.setBounds(0, 55, 520, 25);
        add(subHeading);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font noteFont = new Font("Segoe UI", Font.PLAIN, 11);

        // ---- Account Type ----
        JLabel AccountLabel = new JLabel("Account Type:");
        AccountLabel.setFont(labelFont);
        AccountLabel.setBounds(30, 100, 200, 25);
        add(AccountLabel);

        SA = new JRadioButton("Saving Account");
        SA.setFont(fieldFont);
        SA.setBackground(Color.WHITE);
        SA.setBounds(30, 135, 170, 25);
        add(SA);

        FDA = new JRadioButton("Fixed Deposit Account");
        FDA.setFont(fieldFont);
        FDA.setBackground(Color.WHITE);
        FDA.setBounds(220, 135, 220, 25);
        add(FDA);

        CA = new JRadioButton("Current Account");
        CA.setFont(fieldFont);
        CA.setBackground(Color.WHITE);
        CA.setBounds(30, 165, 170, 25);
        add(CA);

        RDA = new JRadioButton("Recurring Deposit Account");
        RDA.setFont(fieldFont);
        RDA.setBackground(Color.WHITE);
        RDA.setBounds(220, 165, 250, 25);
        add(RDA);

        ButtonGroup Accounttype = new ButtonGroup();
        Accounttype.add(SA);
        Accounttype.add(FDA);
        Accounttype.add(CA);
        Accounttype.add(RDA);

        // ---- Card Number ----
        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(labelFont);
        cardNumber.setBounds(30, 210, 180, 25);
        add(cardNumber);

        JLabel CN = new JLabel("Your 18 Digit Card Number");
        CN.setFont(noteFont);
        CN.setBounds(30, 235, 200, 20);
        add(CN);

        JLabel CNS = new JLabel("XXXX-XXXX-XXXX-4184");
        CNS.setFont(labelFont);
        CNS.setBounds(220, 210, 250, 25);
        add(CNS);

        // ---- PIN Number ----
        JLabel PINNumber = new JLabel("PIN Number:");
        PINNumber.setFont(labelFont);
        PINNumber.setBounds(30, 265, 180, 25);
        add(PINNumber);

        JLabel PN = new JLabel("Your 04 Digit Pin Number");
        PN.setFont(noteFont);
        PN.setBounds(30, 290, 200, 20);
        add(PN);

        JLabel PNS = new JLabel("XXXX");
        PNS.setFont(labelFont);
        PNS.setBounds(220, 265, 150, 25);
        add(PNS);

        // ---- Services Required ----
        JLabel ServicesRequired = new JLabel("Services Required:");
        ServicesRequired.setFont(labelFont);
        ServicesRequired.setBounds(30, 325, 250, 25);
        add(ServicesRequired);

        AC = new JCheckBox("ATM Card");
        AC.setFont(fieldFont);
        AC.setBackground(Color.WHITE);
        AC.setBounds(30, 360, 150, 25);
        add(AC);

        IB = new JCheckBox("Internet Banking");
        IB.setFont(fieldFont);
        IB.setBackground(Color.WHITE);
        IB.setBounds(220, 360, 170, 25);
        add(IB);

        MB = new JCheckBox("Mobile Banking");
        MB.setFont(fieldFont);
        MB.setBackground(Color.WHITE);
        MB.setBounds(30, 395, 170, 25);
        add(MB);

        ESA = new JCheckBox("Email & SMS Alerts");
        ESA.setFont(fieldFont);
        ESA.setBackground(Color.WHITE);
        ESA.setBounds(220, 395, 180, 25);
        add(ESA);

        CB = new JCheckBox("Cheque Book");
        CB.setFont(fieldFont);
        CB.setBackground(Color.WHITE);
        CB.setBounds(30, 430, 170, 25);
        add(CB);

        ES = new JCheckBox("E-Statement");
        ES.setFont(fieldFont);
        ES.setBackground(Color.WHITE);
        ES.setBounds(220, 430, 170, 25);
        add(ES);

        Statement = new JCheckBox("<html>I hereby declare that the above entered details are correct to the best of my knowledge</html>");
        Statement.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Statement.setBackground(Color.WHITE);
        Statement.setBounds(30, 470, 460, 40);
        add(Statement);

        // ---- Buttons ----
        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Submit.setFocusPainted(false);
        Submit.setBorder(BorderFactory.createEmptyBorder());
        Submit.setBounds(150, 530, 100, 32);
        Submit.addActionListener(this);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Cancel.setFocusPainted(false);
        Cancel.setBorder(BorderFactory.createEmptyBorder());
        Cancel.setBounds(280, 530, 100, 32);
        Cancel.addActionListener(this);
        add(Cancel);

        // ---- Frame Settings ----
        getContentPane().setBackground(Color.WHITE);
        setSize(560, 630);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        String Formno = "" + formno;
        
        // ---- Genrate cardnumber and Pinnumber ----
        Random rand = new Random();
        String cardnumber = "" + (Math.abs(rand.nextLong() % 9000000000000000L) + 5040936000000000L);
        String PINnumber = "" + (Math.abs(rand.nextLong() % 9000L) + 1000L);
        
        // ---- Multiple Checkbox   ----
        String facility = "";
        if(AC.isSelected()){
            facility = facility + "ATM card";
        }else if (IB.isSelected()){
            facility = facility + "Internet Banking";
        }else if (MB.isSelected()){
            facility = facility + "Mobile Banking";
        }else if (ESA.isSelected()){
            facility = facility + "Email & SMS Alerts";
        }else if (CB.isSelected()){
            facility = facility + "Cheque Book";
        }else if (ES.isSelected()){
            facility = facility + "E Statement";
        }
        
        // ---- Account type selection    ----
        String Accounttype = "";
        if(AC.isSelected()){
            Accounttype =  "Saving Account";
        }else if (IB.isSelected()){
            Accounttype = "Fixed Deposit Account";
        }else if (MB.isSelected()){
            Accounttype = "Current Account";
        }else if (ESA.isSelected()){
            Accounttype = "Recurring Deposit Account";
        }
        
        // ---- Condition ----
        String Condition = Statement.getText();
        
        try
        {
            if(Condition.equals("")){
               JOptionPane.showMessageDialog(null, "Check the Condition checkbox");
            }else{
                
                conn c = new conn();
                String query1 = "insert into Signupthree values('" + Formno + "','" + cardnumber + "','" + PINnumber + "','" + facility + "','" + Accounttype +"')";
                String query2 = "insert into User_login values('" + Formno + "','" + cardnumber + "','" + PINnumber + "')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Card NO: " +cardnumber+ "\n Pin NO; "+PINnumber);
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args){
        new SignupThree("");
    }
}