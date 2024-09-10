package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    private JTextField amountField;
    private JButton depositButton, backButton;
    private JLabel instructionLabel, backgroundLabel;
    private String pin;

    Deposit(String pin) {
        this.pin = pin;

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        add(backgroundLabel);

        
        instructionLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("System", Font.BOLD, 16));

        
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));

       
        depositButton = new JButton("DEPOSIT");
        backButton = new JButton("BACK");

       
        setLayout(null);
        instructionLabel.setBounds(170, 300, 400, 25);
        backgroundLabel.add(instructionLabel);

        amountField.setBounds(170, 350, 320, 25);
        backgroundLabel.add(amountField);

        depositButton.setBounds(355, 485, 150, 30);
        backgroundLabel.add(depositButton);

        backButton.setBounds(355, 520, 150, 30);
        backgroundLabel.add(backButton);

        depositButton.addActionListener(this);
        backButton.addActionListener(this);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

  
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountField.getText();
            Date date = new Date();
            if (ae.getSource() == depositButton) {
                if (amountField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    Conn connection = new Conn();
                    connection.s.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == backButton) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
