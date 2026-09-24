
package com.mycompany.bankmanaementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Balanceenquiry extends JFrame implements ActionListener {
    
    String Pinnumber;
    JButton back;
    
    Balanceenquiry(String Pinnumber){
        this.Pinnumber = Pinnumber;
        Font subtextfont = new Font("Segoe UI", Font.BOLD,16);
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        int bal = 0;
        
        try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from Bank where Pinnumber = '" + Pinnumber + "'");
                while(rs.next()){
                    if(rs.getString("transcation_type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }            
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        
        JLabel text = new JLabel("Your current Account balance is RS: " + bal);
        text.setFont(subtextfont);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 350, 400, 30);
        image.add(text);
        
        
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
        if(e.getSource() == back){
            setVisible(false);
            new Transcations(Pinnumber).setVisible(true);
        }
        
        }
    
    public static void main(String[] args){
        new Balanceenquiry("");
    }
}
