package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel instructionLabel;
    JButton depositButton, cashWithdrawalButton, fastCashButton, miniStatementButton, pinChangeButton, balanceEnquiryButton, exitButton;
    String pin;

    Transactions(String pin){
        this.pin = pin;
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        add(backgroundLabel);
        
        instructionLabel = new JLabel("Please Select Your Transaction");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("System", Font.BOLD, 16));
        
        depositButton = new JButton("DEPOSIT");
        cashWithdrawalButton = new JButton("CASH WITHDRAWL");
        fastCashButton = new JButton("FAST CASH");
        miniStatementButton = new JButton("MINI STATEMENT");
        pinChangeButton = new JButton("PIN CHANGE");
        balanceEnquiryButton = new JButton("BALANCE ENQUIRY");
        exitButton = new JButton("EXIT");
        
        setLayout(null);
        
        instructionLabel.setBounds(210, 300, 700, 30);
        backgroundLabel.add(instructionLabel);
        
        depositButton.setBounds(170, 415, 150, 30);
        backgroundLabel.add(depositButton);
        
        cashWithdrawalButton.setBounds(355, 415, 150, 30);
        backgroundLabel.add(cashWithdrawalButton);
        
        fastCashButton.setBounds(170, 450, 150, 30);
        backgroundLabel.add(fastCashButton);
        
        miniStatementButton.setBounds(355, 450, 150, 30);
        backgroundLabel.add(miniStatementButton);
        
        pinChangeButton.setBounds(170, 485, 150, 30);
        backgroundLabel.add(pinChangeButton);
        
        balanceEnquiryButton.setBounds(355, 485, 150, 30);
        backgroundLabel.add(balanceEnquiryButton);
        
        exitButton.setBounds(355, 520, 150, 30);
        backgroundLabel.add(exitButton);
        
        depositButton.addActionListener(this);
        cashWithdrawalButton.addActionListener(this);
        fastCashButton.addActionListener(this);
        miniStatementButton.addActionListener(this);
        pinChangeButton.addActionListener(this);
        balanceEnquiryButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == depositButton){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if(ae.getSource() == cashWithdrawalButton){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if(ae.getSource() == fastCashButton){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if(ae.getSource() == miniStatementButton){ 
            new MiniStatement(pin).setVisible(true);
        } else if(ae.getSource() == pinChangeButton){ 
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if(ae.getSource() == balanceEnquiryButton){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if(ae.getSource() == exitButton){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}
