package com.mycompany.bankmanaementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    Random rand;
    int formNumber;   // ab class-level field hai, actionPerformed mein bhi milega
    JTextField  nameField,fatherField,emailField,addressField,cityField,panField,stateField;
    JDateChooser dobChooser;
    JRadioButton male, female,married,unmarried,other;
    JButton nextButton;

    SignupOne() {
        setLayout(null);
        setTitle("Automated Teller Machine");

        // ---- Random Positive Form Number ----
        rand = new Random();
        formNumber = rand.nextInt(9000) + 1000; // hamesha positive, 4-digit

        JLabel heading = new JLabel("APPLICATION FORM NO. " + formNumber, SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setBounds(0, 15, 520, 40);
        add(heading);

        JLabel subHeading = new JLabel("Page 1: Personal Details", SwingConstants.CENTER);
        subHeading.setFont(new Font("Segoe UI", Font.BOLD, 14));
        subHeading.setBounds(0, 55, 520, 25);
        add(subHeading);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        // ---- Name ----
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(30, 100, 150, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(fieldFont);
        nameField.setBounds(180, 100, 280, 25);
        add(nameField);

        // ---- Father's Name ----
        JLabel fatherLabel = new JLabel("Father's Name:");
        fatherLabel.setFont(labelFont);
        fatherLabel.setBounds(30, 135, 150, 25);
        add(fatherLabel);

        fatherField = new JTextField();
        fatherField.setFont(fieldFont);
        fatherField.setBounds(180, 135, 280, 25);
        add(fatherField);

        // ---- Date of Birth (JCalendar) ----
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(labelFont);
        dobLabel.setBounds(30, 170, 150, 25);
        add(dobLabel);

        dobChooser = new JDateChooser();
        dobChooser.setFont(fieldFont);
        dobChooser.setBounds(180, 170, 280, 25);
        add(dobChooser);

        // ---- Gender ----
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(30, 205, 150, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        male.setBounds(180, 205, 80, 25);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(270, 205, 90, 25);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // ---- Email ----
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setFont(labelFont);
        emailLabel.setBounds(30, 240, 150, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(fieldFont);
        emailField.setBounds(180, 240, 280, 25);
        add(emailField);

        // ---- Marital Status ----
        JLabel maritalLabel = new JLabel("Marital Status:");
        maritalLabel.setFont(labelFont);
        maritalLabel.setBounds(30, 275, 150, 25);
        add(maritalLabel);

        married = new JRadioButton("Married");
        married.setBounds(180, 275, 90, 25);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(270, 275, 100, 25);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(380, 275, 80, 25);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        // ---- Address ----
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        addressLabel.setBounds(30, 310, 150, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setFont(fieldFont);
        addressField.setBounds(180, 310, 280, 25);
        add(addressField);

        // ---- City ----
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(labelFont);
        cityLabel.setBounds(30, 345, 150, 25);
        add(cityLabel);

        cityField = new JTextField();
        cityField.setFont(fieldFont);
        cityField.setBounds(180, 345, 280, 25);
        add(cityField);

        // ---- State ----
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(labelFont);
        stateLabel.setBounds(30, 380, 150, 25);
        add(stateLabel);

        stateField = new JTextField();
        stateField.setFont(fieldFont);
        stateField.setBounds(180, 380, 280, 25);
        add(stateField);

        // ---- Postal code ----
        JLabel PostalcodeLabel = new JLabel("Postal Code:");
        PostalcodeLabel.setFont(labelFont);
        PostalcodeLabel.setBounds(30, 415, 150, 25);
        add(PostalcodeLabel);

        panField = new JTextField();
        panField.setFont(fieldFont);
        panField.setBounds(180, 415, 280, 25);
        add(panField);

        // ---- Next Button ----
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nextButton.setBounds(380, 460, 80, 30);
        nextButton.addActionListener(this);
        add(nextButton);

        // ---- Frame Settings ----
        getContentPane().setBackground(Color.WHITE);
        setSize(520, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String Formno = "" + formNumber;   // ab actual form number aayega
        String name = nameField.getText();
        String fname = fatherField.getText();
        String email = emailField.getText();   // semicolon add kiya
        String Address = addressField.getText();
        String City = cityField.getText();
        String Postal = panField.getText();
        String state = stateField.getText();
        
        String dob =  ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();

        String Gender = null;
        if(male.isSelected()){
            Gender = "Male";
        }else if(female.isSelected()){
            Gender = "Female";
        }

        String Marital = null;
        if(married.isSelected()){
            Marital = "Married";
        }else if (unmarried.isSelected()){
            Marital = "Unmarried";
        }else if (other.isSelected()){
            Marital = "Other";   // typo fix kiya "Otner" se "Other"
        }

        try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is required");
        }else {
            
            conn c = new conn();
            String query = "insert into Signup values('" + Formno + "','" + name + "','" + fname + "','" + dob + "','" + Gender + "','" + email + "','" + Marital + "','" + Address + "','" + City + "','" + state + "','" + Postal + "')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signuptwo(Formno).setVisible(true);
        }
        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }

    public static void main(String[] args){
        new SignupOne();
    }
}