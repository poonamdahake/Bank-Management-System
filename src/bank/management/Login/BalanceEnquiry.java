package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    private JLabel balanceLabel;
    private JButton backButton;
    private String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        add(backgroundLabel);

        balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 16));

        backButton = new JButton("BACK");

        setLayout(null);

        balanceLabel.setBounds(170, 300, 400, 30);
        backgroundLabel.add(balanceLabel);

        backButton.setBounds(355, 520, 150, 30);
        backgroundLabel.add(backButton);

        int balance = 0;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        balanceLabel.setText("Your Current Account Balance is Rs " + balance);

        backButton.addActionListener(this);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
