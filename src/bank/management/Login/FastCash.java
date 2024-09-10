package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    private JLabel selectionLabel;
    private JButton btn100, btn500, btn1000, btn2000, btn5000, btn10000, btnBack;
    private JTextField amountField;
    private String pin;

    public FastCash(String pin) {
        this.pin = pin;

        // Set up background image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        add(backgroundLabel);

        // Set up labels
        selectionLabel = new JLabel("SELECT WITHDRAWL AMOUNT");
        selectionLabel.setForeground(Color.WHITE);
        selectionLabel.setFont(new Font("System", Font.BOLD, 16));

        // Set up buttons
        btn100 = new JButton("Rs 100");
        btn500 = new JButton("Rs 500");
        btn1000 = new JButton("Rs 1000");
        btn2000 = new JButton("Rs 2000");
        btn5000 = new JButton("Rs 5000");
        btn10000 = new JButton("Rs 10000");
        btnBack = new JButton("BACK");

        // Set layout and add components
        setLayout(null);

        selectionLabel.setBounds(210, 300, 700, 35);
        backgroundLabel.add(selectionLabel);

        btn100.setBounds(170, 415, 150, 30);
        backgroundLabel.add(btn100);

        btn500.setBounds(355, 415, 150, 30);
        backgroundLabel.add(btn500);

        btn1000.setBounds(170, 450, 150, 30);
        backgroundLabel.add(btn1000);

        btn2000.setBounds(355, 450, 150, 30);
        backgroundLabel.add(btn2000);

        btn5000.setBounds(170, 485, 150, 30);
        backgroundLabel.add(btn5000);

        btn10000.setBounds(355, 485, 150, 30);
        backgroundLabel.add(btn10000);

        btnBack.setBounds(355, 520, 150, 30);
        backgroundLabel.add(btnBack);

        // Add action listeners
        btn100.addActionListener(this);
        btn500.addActionListener(this);
        btn1000.addActionListener(this);
        btn2000.addActionListener(this);
        btn5000.addActionListener(this);
        btn10000.addActionListener(this);
        btnBack.addActionListener(this);

        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

 
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton) ae.getSource()).getText().substring(3); 
            
            Conn connection = new Conn();
            ResultSet rs = connection.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";

            if (ae.getSource() != btnBack && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            if (ae.getSource() == btnBack) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                Date date = new Date();
                connection.s.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
