package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Pinchange extends JFrame implements ActionListener{
    
    JPasswordField Pin ,repin;
    String Pinnumber;
    JButton change,back;

    Pinchange(String Pinnumber) {
        this.Pinnumber = Pinnumber;
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        Font textfont = new Font("System", Font.BOLD,18);
        Font subtextfont = new Font("Segoe UI", Font.BOLD,14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        
        JLabel text = new JLabel ("Change your pin");
        text.setForeground(Color.WHITE);
        text.setBounds(300, 300, 150, 35);
        text.setFont(textfont);
        image.add(text);
        
        JLabel Pintext = new JLabel ("Enter New Pin :");
        Pintext.setForeground(Color.WHITE);
        Pintext.setBounds(170, 370, 150, 25);
        Pintext.setFont(subtextfont);
        image.add(Pintext);
        
        JLabel RePintext = new JLabel ("Enter Re PIN :");
        RePintext.setForeground(Color.WHITE);
        RePintext.setBounds(170, 400, 200, 25);
        RePintext.setFont(subtextfont);
        image.add(RePintext);
        
        Pin = new JPasswordField ();
        Pin.setBounds(300, 370, 200, 25);
        Pin.setFont(fieldFont);
        image.add(Pin);
        
        repin = new JPasswordField ();
        repin.setBounds(300, 400, 200, 25);
        repin.setFont(fieldFont);
        image.add(repin);
        
        
        change = new JButton ("Change PIN");
        change.setBounds(360, 530, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton ("Back");
        back.setBounds(360, 565, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == change){
            
            String pin = new String(Pin.getPassword());
            String Repin = new String(repin.getPassword());
            
            try{
                
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter your new pin");
                    return;
                }
            
                if(Repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter your repin");
                     return;
                }
                
                if (!pin.equals(Repin)){
                    JOptionPane.showMessageDialog(null, "pin and repin are not match enter right pin");
                       return;
                }
                
                conn c = new conn();
                String query1 = "Update Bank set Pinnumber = '"+Repin+"' where Pinnumber = '"+Pinnumber+"' ";
                String query2 = "Update User_login set PINnumber = '"+Repin+"' where PINnumber = '"+Pinnumber+"' ";
                String query3 = "Update Signupthree set Pinnumber = '"+Repin+"' where Pinnumber = '"+Pinnumber+"' ";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "your pin is successfully change");
                 setVisible(false);
                 new Transcations(Pinnumber).setVisible(true);
                        
                
            }
            catch (Exception ex){
                
                System.out.println(ex);
            }
        
        
        }else {
            setVisible(false);
            new Transcations(Pinnumber).setVisible(true); 
        }
    
    }
    
    
        public static void main(String[] args){
        new Pinchange("");
    }
}
