package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;


public class Fashcash extends JFrame implements ActionListener{

    JButton Rs1, Rs2 , Rs3 , Rs4 , Rs5 , Rs6 , Exit;
    String Pinnumber;

    Fashcash(String Pinnumber){
        this.Pinnumber = Pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        Font textfont = new Font("System", Font.BOLD,16);

        JLabel text = new JLabel("Please Select Your Fash cash ");
        text.setBounds(235, 310, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(textfont);
        image.add(text);

        Rs1 = new JButton ("Rs 500");
        Rs1.setBounds(170, 450, 150, 30);
        Rs1.addActionListener(this);
        image.add(Rs1);

        Rs2 = new JButton ("Rs 1000");
        Rs2.setBounds(360, 450, 150, 30);
        Rs2.addActionListener(this);
        image.add(Rs2);

        Rs3 = new JButton ("Rs 3000");
        Rs3.setBounds(170, 490, 150, 30);
        Rs3.addActionListener(this);
        image.add(Rs3);

        Rs4 = new JButton ("Rs 5000");
        Rs4.setBounds(360, 490, 150, 30);
        Rs4.addActionListener(this);
        image.add(Rs4);

        Rs5 = new JButton ("Rs 10000");
        Rs5.setBounds(170, 530, 150, 30);
        Rs5.addActionListener(this);
        image.add(Rs5);

        Rs6 = new JButton ("Rs 20000");
        Rs6.setBounds(360, 530, 150, 30);
        Rs6.addActionListener(this);
        image.add(Rs6);

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

        if (e.getSource() == Exit){
            setVisible(false);
            new Transcations(Pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            conn c = new conn();
            try{
                // ---- Balance calculate karne ke liye ----
                ResultSet rs = c.s.executeQuery("select * from Bank where Pinnumber = '" + Pinnumber + "'");
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

                // ---- Insert (loop ke bahar, sirf ek dafa) ----
                Date date = new Date();
                String query = "insert into Bank (amount, Pinnumber, transcation_type, [Date]) values ('" + amount + "','" + Pinnumber + "','Cashwithdrawal','" + date + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs " + amount + " Cash withdrawal successful");

                setVisible(false);
                new Transcations(Pinnumber).setVisible(true);

            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args){
        new Fashcash("");
    }
}