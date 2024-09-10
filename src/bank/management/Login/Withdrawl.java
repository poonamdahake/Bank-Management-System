package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    private JTextField amountField;
    private JButton withdrawButton, backButton;
    private JLabel maxWithdrawalLabel, enterAmountLabel, backgroundLabel;
    private String pin;

    public Withdrawl(String pin) {
        this.pin = pin;

        // Set up background image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        add(backgroundLabel);

        // Set up labels
        maxWithdrawalLabel = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        maxWithdrawalLabel.setForeground(Color.WHITE);
        maxWithdrawalLabel.setFont(new Font("System", Font.BOLD, 16));

        enterAmountLabel = new JLabel("PLEASE ENTER YOUR AMOUNT");
        enterAmountLabel.setForeground(Color.WHITE);
        enterAmountLabel.setFont(new Font("System", Font.BOLD, 16));

        // Set up text field
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 25));

        // Set up buttons
        withdrawButton = new JButton("WITHDRAW");
        backButton = new JButton("BACK");

        // Set layout and add components
        setLayout(null);
        maxWithdrawalLabel.setBounds(170, 300, 400, 20);
        backgroundLabel.add(maxWithdrawalLabel);

        enterAmountLabel.setBounds(190, 350, 400, 20);
        backgroundLabel.add(enterAmountLabel);

        amountField.setBounds(170, 380, 320, 25);
        backgroundLabel.add(amountField);

        withdrawButton.setBounds(355, 485, 150, 30);
        backgroundLabel.add(withdrawButton);

        backButton.setBounds(355, 520, 150, 30);
        backgroundLabel.add(backButton);

        withdrawButton.addActionListener(this);
        backButton.addActionListener(this);

        // Set frame properties
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountField.getText();
            Date date = new Date();

            if (ae.getSource() == withdrawButton) {
                if (amountField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    Conn connection = new Conn();

                    ResultSet rs = connection.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    connection.s.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == backButton) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
