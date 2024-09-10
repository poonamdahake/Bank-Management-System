package bank.management.Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JLabel labelPageTitle, labelAccountType, labelCardNumber, labelDisplayedCardNumber, labelCardNumberInfo, labelCardInfoExtra, labelPIN, labelDisplayedPIN, labelPINInfo, labelServicesRequired, labelFormNumber, labelDisplayedFormNumber;
    JRadioButton radioSavingAccount, radioFixedDeposit, radioCurrentAccount, radioRecurringDeposit;
    JButton buttonSubmit, buttonCancel;
    JCheckBox checkboxATMCard, checkboxInternetBanking, checkboxMobileBanking, checkboxEmailAlerts, checkboxChequeBook, checkboxEStatement, checkboxDeclaration;
    String formno;

    SignUpThree(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image scaledLogo = logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel labelLogo = new JLabel(new ImageIcon(scaledLogo));
        labelLogo.setBounds(150, 0, 100, 100);
        add(labelLogo);

        // Initialize the components
        labelPageTitle = new JLabel("Page 3: Account Details");
        labelPageTitle.setFont(new Font("Raleway", Font.BOLD, 22));

        labelAccountType = new JLabel("Account Type:");
        labelAccountType.setFont(new Font("Raleway", Font.BOLD, 18));

        labelCardNumber = new JLabel("Card Number:");
        labelCardNumber.setFont(new Font("Raleway", Font.BOLD, 18));

        labelDisplayedCardNumber = new JLabel("XXXX-XXXX-XXXX-4184");
        labelDisplayedCardNumber.setFont(new Font("Raleway", Font.BOLD, 18));

        labelCardNumberInfo = new JLabel("(Your 16-digit Card number)");
        labelCardNumberInfo.setFont(new Font("Raleway", Font.BOLD, 12));

        labelCardInfoExtra = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        labelCardInfoExtra.setFont(new Font("Raleway", Font.BOLD, 12));

        labelPIN = new JLabel("PIN:");
        labelPIN.setFont(new Font("Raleway", Font.BOLD, 18));

        labelDisplayedPIN = new JLabel("XXXX");
        labelDisplayedPIN.setFont(new Font("Raleway", Font.BOLD, 18));

        labelPINInfo = new JLabel("(4-digit password)");
        labelPINInfo.setFont(new Font("Raleway", Font.BOLD, 12));

        labelServicesRequired = new JLabel("Services Required:");
        labelServicesRequired.setFont(new Font("Raleway", Font.BOLD, 18));

        labelFormNumber = new JLabel("Form No:");
        labelFormNumber.setFont(new Font("Raleway", Font.BOLD, 14));

        labelDisplayedFormNumber = new JLabel(formno);
        labelDisplayedFormNumber.setFont(new Font("Raleway", Font.BOLD, 14));

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonSubmit.setBackground(Color.BLACK);
        buttonSubmit.setForeground(Color.WHITE);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonCancel.setBackground(Color.BLACK);
        buttonCancel.setForeground(Color.WHITE);

        checkboxATMCard = new JCheckBox("ATM CARD");
        checkboxATMCard.setBackground(Color.WHITE);
        checkboxATMCard.setFont(new Font("Raleway", Font.BOLD, 16));

        checkboxInternetBanking = new JCheckBox("Internet Banking");
        checkboxInternetBanking.setBackground(Color.WHITE);
        checkboxInternetBanking.setFont(new Font("Raleway", Font.BOLD, 16));

        checkboxMobileBanking = new JCheckBox("Mobile Banking");
        checkboxMobileBanking.setBackground(Color.WHITE);
        checkboxMobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));

        checkboxEmailAlerts = new JCheckBox("EMAIL Alerts");
        checkboxEmailAlerts.setBackground(Color.WHITE);
        checkboxEmailAlerts.setFont(new Font("Raleway", Font.BOLD, 16));

        checkboxChequeBook = new JCheckBox("Cheque Book");
        checkboxChequeBook.setBackground(Color.WHITE);
        checkboxChequeBook.setFont(new Font("Raleway", Font.BOLD, 16));

        checkboxEStatement = new JCheckBox("E-Statement");
        checkboxEStatement.setBackground(Color.WHITE);
        checkboxEStatement.setFont(new Font("Raleway", Font.BOLD, 16));

        checkboxDeclaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        checkboxDeclaration.setBackground(Color.WHITE);
        checkboxDeclaration.setFont(new Font("Raleway", Font.BOLD, 12));

        radioSavingAccount = new JRadioButton("Saving Account");
        radioSavingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        radioSavingAccount.setBackground(Color.WHITE);

        radioFixedDeposit = new JRadioButton("Fixed Deposit Account");
        radioFixedDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        radioFixedDeposit.setBackground(Color.WHITE);

        radioCurrentAccount = new JRadioButton("Current Account");
        radioCurrentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        radioCurrentAccount.setBackground(Color.WHITE);

        radioRecurringDeposit = new JRadioButton("Recurring Deposit Account");
        radioRecurringDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        radioRecurringDeposit.setBackground(Color.WHITE);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(radioSavingAccount);
        accountTypeGroup.add(radioFixedDeposit);
        accountTypeGroup.add(radioCurrentAccount);
        accountTypeGroup.add(radioRecurringDeposit);

        // Create a JPanel to hold all the components
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Add components to the panel
        labelFormNumber.setBounds(700, 10, 70, 30);
        panel.add(labelFormNumber);

        labelDisplayedFormNumber.setBounds(770, 10, 40, 30);
        panel.add(labelDisplayedFormNumber);

        labelPageTitle.setBounds(280, 40, 400, 40);
        panel.add(labelPageTitle);

        labelAccountType.setBounds(100, 140, 200, 30);
        panel.add(labelAccountType);

        radioSavingAccount.setBounds(100, 180, 150, 30);
        panel.add(radioSavingAccount);

        radioFixedDeposit.setBounds(350, 180, 300, 30);
        panel.add(radioFixedDeposit);

        radioCurrentAccount.setBounds(100, 220, 250, 30);
        panel.add(radioCurrentAccount);

        radioRecurringDeposit.setBounds(350, 220, 250, 30);
        panel.add(radioRecurringDeposit);

        labelCardNumber.setBounds(100, 300, 200, 30);
        panel.add(labelCardNumber);

        labelDisplayedCardNumber.setBounds(330, 300, 250, 30);
        panel.add(labelDisplayedCardNumber);

        labelCardNumberInfo.setBounds(100, 330, 200, 20);
        panel.add(labelCardNumberInfo);

        labelCardInfoExtra.setBounds(330, 330, 500, 20);
        panel.add(labelCardInfoExtra);

        labelPIN.setBounds(100, 370, 200, 30);
        panel.add(labelPIN);

        labelDisplayedPIN.setBounds(330, 370, 200, 30);
        panel.add(labelDisplayedPIN);

        labelPINInfo.setBounds(100, 400, 200, 20);
        panel.add(labelPINInfo);

        labelServicesRequired.setBounds(100, 450, 200, 30);
        panel.add(labelServicesRequired);

        checkboxATMCard.setBounds(100, 500, 200, 30);
        panel.add(checkboxATMCard);

        checkboxInternetBanking.setBounds(350, 500, 200, 30);
        panel.add(checkboxInternetBanking);

        checkboxMobileBanking.setBounds(100, 550, 200, 30);
        panel.add(checkboxMobileBanking);

        checkboxEmailAlerts.setBounds(350, 550, 200, 30);
        panel.add(checkboxEmailAlerts);

        checkboxChequeBook.setBounds(100, 600, 200, 30);
        panel.add(checkboxChequeBook);

        checkboxEStatement.setBounds(350, 600, 200, 30);
        panel.add(checkboxEStatement);

        checkboxDeclaration.setBounds(100, 680, 600, 20);
        panel.add(checkboxDeclaration);

        buttonSubmit.setBounds(250, 720, 100, 30);
        panel.add(buttonSubmit);

        buttonCancel.setBounds(420, 720, 100, 30);
        panel.add(buttonCancel);

        // Set panel size larger than the frame
        panel.setPreferredSize(new Dimension(850, 900));

        // Wrap the panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the JScrollPane to the JFrame
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        buttonSubmit.addActionListener(this);
        buttonCancel.addActionListener(this);

        // Window settings
        setSize(850, 820);
        setLocation(350, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accountType = null;
        if (radioSavingAccount.isSelected()) {
            accountType = "Saving Account";
        } else if (radioFixedDeposit.isSelected()) {
            accountType = "Fixed Deposit Account";
        } else if (radioCurrentAccount.isSelected()) {
            accountType = "Current Account";
        } else if (radioRecurringDeposit.isSelected()) {
            accountType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardNumber = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (checkboxATMCard.isSelected()) {
            facility += " ATM Card";
        }
        if (checkboxInternetBanking.isSelected()) {
            facility += " Internet Banking";
        }
        if (checkboxMobileBanking.isSelected()) {
            facility += " Mobile Banking";
        }
        if (checkboxEmailAlerts.isSelected()) {
            facility += " EMAIL Alerts";
        }
        if (checkboxChequeBook.isSelected()) {
            facility += " Cheque Book";
        }
        if (checkboxEStatement.isSelected()) {
            facility += " E-Statement";
        }

        try {
            if (ae.getSource() == buttonSubmit) {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Please select an account type.");
                } else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardNumber + "','" + pin + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardNumber + "','" + pin + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n PIN: " + pin);

                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            } else if (ae.getSource() == buttonCancel) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
