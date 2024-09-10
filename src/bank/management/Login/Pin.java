package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {
    
    private JPasswordField newPinField, reenterPinField;
    private JButton changeButton, backButton;
    private JLabel titleLabel, newPinLabel, reenterPinLabel;
    private String pin;
    
    public Pin(String pin) {
        this.pin = pin;
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        add(backgroundLabel);
        
        titleLabel = new JLabel("CHANGE YOUR PIN");
        titleLabel.setFont(new Font("System", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        
        newPinLabel = new JLabel("New PIN:");
        newPinLabel.setFont(new Font("System", Font.BOLD, 16));
        newPinLabel.setForeground(Color.WHITE);
        
        reenterPinLabel = new JLabel("Re-Enter New PIN:");
        reenterPinLabel.setFont(new Font("System", Font.BOLD, 16));
        reenterPinLabel.setForeground(Color.WHITE);
        
        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        reenterPinField = new JPasswordField();
        reenterPinField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        changeButton = new JButton("CHANGE");
        backButton = new JButton("BACK");
        
        changeButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setLayout(null);
        
        titleLabel.setBounds(250, 280, 500, 35);
        backgroundLabel.add(titleLabel);
        
        newPinLabel.setBounds(165, 320, 180, 25);
        backgroundLabel.add(newPinLabel);
        
        reenterPinLabel.setBounds(165, 360, 180, 25);
        backgroundLabel.add(reenterPinLabel);
        
        newPinField.setBounds(330, 320, 180, 25);
        backgroundLabel.add(newPinField);
        
        reenterPinField.setBounds(330, 360, 180, 30);
        backgroundLabel.add(reenterPinField);
        
        changeButton.setBounds(355, 485, 150, 30);
        backgroundLabel.add(changeButton);
        
        backButton.setBounds(355, 520, 150, 30);
        backgroundLabel.add(backButton);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String newPin = new String(newPinField.getPassword());
            String reenteredPin = new String(reenterPinField.getPassword());
            
            if (!newPin.equals(reenteredPin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if (ae.getSource() == changeButton) {
                if (newPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (reenteredPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String updateBankQuery = "UPDATE bank SET pin = '" + reenteredPin + "' WHERE pin = '" + pin + "'";
                String updateLoginQuery = "UPDATE login SET pin = '" + reenteredPin + "' WHERE pin = '" + pin + "'";
                String updateSignupQuery = "UPDATE signupthree SET pin = '" + reenteredPin + "' WHERE pin = '" + pin + "'";
                
                conn.s.executeUpdate(updateBankQuery);
                conn.s.executeUpdate(updateLoginQuery);
                conn.s.executeUpdate(updateSignupQuery);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(reenteredPin).setVisible(true);
            
            } else if (ae.getSource() == backButton) {
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}
