package com.mycompany.bankmanaementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton Login , Clear , Signup;
    JTextField Cardtextfield,Pintextfield;
     
        Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);

        // ATM Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Heading
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Segoe UI", Font.BOLD, 32));
        text.setForeground(new Color(20, 20, 20));
        text.setBounds(200, 30, 450, 50);
        add(text);

        // Card No
        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);

        Cardtextfield = new JTextField();
        Cardtextfield.setBounds(300, 150, 250, 35);
        Cardtextfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        Cardtextfield.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(Cardtextfield);

        // PIN
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        pin.setBounds(120, 220, 300, 40);
        add(pin);

        Pintextfield = new JPasswordField();
        Pintextfield.setBounds(300, 220, 250, 35);
        Pintextfield.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        Pintextfield.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(Pintextfield);

        // Sign In Button
        Login = new JButton("Sign IN");
        Login.setBounds(300, 290, 110, 35);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Login.setFocusPainted(false);
        Login.setBorder(BorderFactory.createEmptyBorder());
        Login.addActionListener(this);
        add(Login);

        // Clear Button
        Clear = new JButton("Clear");
        Clear.setBounds(440, 290, 110, 35);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Clear.setFocusPainted(false);
        Clear.setBorder(BorderFactory.createEmptyBorder());
        Clear.addActionListener(this);
        add(Clear);

        // Sign Up Button
        Signup = new JButton("Sign UP");
        Signup.setBounds(300, 340, 250, 35);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.WHITE);
        Signup.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Signup.setFocusPainted(false);
        Signup.setBorder(BorderFactory.createEmptyBorder());
        Signup.addActionListener(this);
        add(Signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 450);
        setVisible(true);
        setLocation(350, 200);
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== Clear){
            Cardtextfield.setText("");
            Pintextfield.setText("");    
        }else if (e.getSource()== Login){
            
          String Cardnumber = Cardtextfield.getText();
          String Pinnumber = Pintextfield.getText();
                
          conn c = new conn();
          String query = "select * from User_login where cardnumber = '"+Cardnumber+"' and PINnumber = '"+Pinnumber+"' ";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transcations(Pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "incorrect Card number and Pin"); 
                }
      
                      
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }else if (e.getSource()== Signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[]){
        new Login();
    }
}