package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    private JButton exitButton;
    private JLabel statementLabel, bankNameLabel, cardNumberLabel, balanceLabel;
    
    public MiniStatement(String pin) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        
        
        statementLabel = new JLabel();
        statementLabel.setBounds(20, 140, 400, 200);
        add(statementLabel);
        
        bankNameLabel = new JLabel("Indian Bank");
        bankNameLabel.setBounds(150, 20, 100, 20);
        add(bankNameLabel);
        
        cardNumberLabel = new JLabel();
        cardNumberLabel.setBounds(20, 80, 300, 20);
        add(cardNumberLabel);
        
        balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 400, 300, 20);
        add(balanceLabel);
        
      
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            if (rs.next()) {
                cardNumberLabel.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        try {
            int balance = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (rs.next()) {
                statementLabel.setText(statementLabel.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceLabel.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setLayout(null);
        exitButton = new JButton("Exit");
        add(exitButton);
        
        
        exitButton.addActionListener(this); 
        
        statementLabel.setBounds(20, 140, 400, 200);
        exitButton.setBounds(20, 500, 100, 25);
        
        setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
