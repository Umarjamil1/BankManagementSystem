package com.mycompany.bankmanaementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener {
    JTextField  CNICNumaberField,PANNumberField;
    JRadioButton ysc,Nsc,YEA,NEA;
    JButton nextButton;
    JComboBox Religion,Category,Income,Education_Qualification,Occupation;
    String formno;

Signuptwo(String Formno) {
    
    formno = Formno;

    setLayout(null);
    setTitle("Automated Teller Machine");

    JLabel heading = new JLabel("Signup Application", SwingConstants.CENTER);
    heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
    heading.setBounds(0, 15, 520, 40);
    add(heading);

    JLabel subHeading = new JLabel("Page 02: Additional Details", SwingConstants.CENTER);
    subHeading.setFont(new Font("Segoe UI", Font.BOLD, 14));
    subHeading.setBounds(0, 55, 520, 25);
    add(subHeading);

    Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
    Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

    // ---- Religion ----
    JLabel ReligionLabel = new JLabel("Religion:");
    ReligionLabel.setFont(labelFont);
    ReligionLabel.setBounds(30, 100, 150, 25);
    add(ReligionLabel);

    String ValReligion[] = {"Muslim","Hindu","Sikh","Christan","Other"};
    Religion = new JComboBox(ValReligion);
    Religion.setFont(fieldFont);
    Religion.setBounds(180, 100, 280, 25);
    Religion.setBackground(Color.WHITE);
    add(Religion);

    // ---- Category ----
    JLabel CategoryLabel = new JLabel("Category:");
    CategoryLabel.setFont(labelFont);
    CategoryLabel.setBounds(30, 135, 150, 25);
    add(CategoryLabel);

    String CategoryVal[] = {"General","OBC","SC","ST","Other"};
    Category = new JComboBox(CategoryVal);
    Category.setFont(fieldFont);
    Category.setBounds(180, 135, 280, 25);
    Category.setBackground(Color.WHITE);
    add(Category);

    // ---- Income ----
    JLabel IncomeLabel = new JLabel("Income:");
    IncomeLabel.setFont(labelFont);
    IncomeLabel.setBounds(30, 170, 150, 25);
    add(IncomeLabel);

    String IncomeVal[] = {"<50000","<100000","<150000","<200000","<1000000","Other"};
    Income = new JComboBox(IncomeVal);
    Income.setFont(fieldFont);
    Income.setBackground(Color.WHITE);
    Income.setBounds(180, 170, 280, 25);
    add(Income);

    // ---- Education / Qualification ----
    JLabel EducationLabel = new JLabel("Qualification:");
    EducationLabel.setFont(labelFont);
    EducationLabel.setBounds(30, 205, 150, 25);
    add(EducationLabel);

    String Education_QualificationVal[] = {"Matric","Intermediate","Bachelor","Master","PhD"};
    Education_Qualification = new JComboBox(Education_QualificationVal);
    Education_Qualification.setFont(fieldFont);
    Education_Qualification.setBounds(180, 205, 280, 25);
    Education_Qualification.setBackground(Color.WHITE);
    add(Education_Qualification);

    // ---- Occupation ----
    JLabel OccupationLabel = new JLabel("Occupation:");
    OccupationLabel.setFont(labelFont);
    OccupationLabel.setBounds(30, 240, 150, 25);
    add(OccupationLabel);

    String OccupationVal[] = {"Student","Employer","Entrepreneur","Business","Other"};
    Occupation = new JComboBox(OccupationVal);
    Occupation.setFont(fieldFont);
    Occupation.setBackground(Color.WHITE);
    Occupation.setBounds(180, 240, 280, 25);
    add(Occupation);

    // ---- PAN Number ----
    JLabel PANNumberLabel = new JLabel("PAN Number:");
    PANNumberLabel.setFont(labelFont);
    PANNumberLabel.setBounds(30, 275, 150, 25);
    add(PANNumberLabel);

    PANNumberField = new JTextField();
    PANNumberField.setFont(fieldFont);
    PANNumberField.setBounds(180, 275, 280, 25);
    PANNumberField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    add(PANNumberField);

    // ---- CNIC Number ----
    JLabel CNICNumberLabel = new JLabel("CNIC Number:");
    CNICNumberLabel.setFont(labelFont);
    CNICNumberLabel.setBounds(30, 310, 150, 25);
    add(CNICNumberLabel);

    CNICNumaberField = new JTextField();
    CNICNumaberField.setFont(fieldFont);
    CNICNumaberField.setBounds(180, 310, 280, 25);
    CNICNumaberField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    add(CNICNumaberField);

    // ---- Senior Citizen ----
    JLabel SeniorCitizenLabel = new JLabel("Senior Citizen:");
    SeniorCitizenLabel.setFont(labelFont);
    SeniorCitizenLabel.setBounds(30, 345, 150, 25);
    add(SeniorCitizenLabel);

    ysc = new JRadioButton("Yes");
    ysc.setFont(fieldFont);
    ysc.setBackground(Color.WHITE);
    ysc.setBounds(180, 345, 80, 25);
    add(ysc);

    Nsc = new JRadioButton("No");
    Nsc.setFont(fieldFont);
    Nsc.setBackground(Color.WHITE);
    Nsc.setBounds(270, 345, 90, 25);
    add(Nsc);

    ButtonGroup seniorGroup = new ButtonGroup();
    seniorGroup.add(ysc);
    seniorGroup.add(Nsc);

    // ---- Existing Account ----
    JLabel ExistingAccountLabel = new JLabel("Existing Account:");
    ExistingAccountLabel.setFont(labelFont);
    ExistingAccountLabel.setBounds(30, 380, 150, 25);
    add(ExistingAccountLabel);

    YEA = new JRadioButton("Yes");
    YEA.setFont(fieldFont);
    YEA.setBackground(Color.WHITE);
    YEA.setBounds(180, 380, 80, 25);
    add(YEA);

    NEA = new JRadioButton("No");
    NEA.setFont(fieldFont);
    NEA.setBackground(Color.WHITE);
    NEA.setBounds(270, 380, 90, 25);
    add(NEA);

    ButtonGroup existingAccGroup = new ButtonGroup();
    existingAccGroup.add(YEA);
    existingAccGroup.add(NEA);

    // ---- Next Button ----
    nextButton = new JButton("Next");
    nextButton.setBackground(Color.BLACK);
    nextButton.setForeground(Color.WHITE);
    nextButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
    nextButton.setFocusPainted(false);
    nextButton.setBorder(BorderFactory.createEmptyBorder());
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
        String Formno = formno;   // ab actual form number aayega
        String religion =(String) Religion.getSelectedItem();
        String category = (String) Category.getSelectedItem();
        String income = (String) Income.getSelectedItem();   // semicolon add kiya
        String Education = (String) Education_Qualification.getSelectedItem();
        String occupation = (String) Occupation.getSelectedItem() ;
        
        // Text field 
        String PANNO = PANNumberField.getText();
        String CNICNO = CNICNumaberField.getText();

        // radiobutton
        String Senior = null;
        if(ysc.isSelected()){
            Senior = "Senior Citizen";
        }else if(Nsc.isSelected()){
            Senior = "Adult Citizen";
        }

        String ExistingAccount = null;
        if(YEA.isSelected()){
            ExistingAccount = "Yes";
        }else if (NEA.isSelected()){
            ExistingAccount = "NO";

        try{
            conn c = new conn();
            String query = "insert into Signuptwo values('" + Formno + "','" + religion + "','" + category + "','" + income + "','" + Education + "','" + occupation + "','" + PANNO + "','" + CNICNO + "','" + Senior + "','" + ExistingAccount + "')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}

    public static void main(String[] args){
        new Signuptwo("");
    }
}
