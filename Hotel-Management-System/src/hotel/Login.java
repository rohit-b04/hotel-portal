package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Login() {
        super("Login");

        setLayout(null);
        setSize(700, 400);  // Increase window size for a more modern layout
        setLocation(400, 200);
        getContentPane().setBackground(new Color(250, 250, 250));  // Soft background color

        // Header
        JLabel title = new JLabel("Hotel Management System");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(180, 30, 400, 40);
        title.setForeground(new Color(0, 102, 204));
        add(title);

        // Username label
        l1 = new JLabel("Username");
        l1.setBounds(100, 100, 100, 30);
        l1.setFont(new Font("Arial", Font.PLAIN, 16));
        l1.setForeground(new Color(80, 80, 80));
        add(l1);

        // Username text field
        t1 = new JTextField();
        t1.setBounds(210, 100, 300, 35);
        t1.setFont(new Font("Arial", Font.PLAIN, 16));
        t1.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        add(t1);

        // Password label
        l2 = new JLabel("Password");
        l2.setBounds(100, 150, 100, 30);
        l2.setFont(new Font("Arial", Font.PLAIN, 16));
        l2.setForeground(new Color(80, 80, 80));
        add(l2);

        // Password field
        t2 = new JPasswordField();
        t2.setBounds(210, 150, 300, 35);
        t2.setFont(new Font("Arial", Font.PLAIN, 16));
        t2.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        add(t2);

        // Image icon (branding, logo, etc.)
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(img);
        l3 = new JLabel(imageIcon);
        l3.setBounds(550, 30, 150, 150);
        add(l3);

        // Login Button
        b1 = new JButton("Login");
        b1.setBounds(100, 220, 200, 40);
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setBackground(new Color(0, 102, 204));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        add(b1);

        // Cancel Button
        b2 = new JButton("Cancel");
        b2.setBounds(320, 220, 200, 40);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setBackground(new Color(255, 0, 0));
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        add(b2);

        setResizable(false);
        setVisible(true);
    }

    // Action performed when login or cancel button is clicked
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();
                String u = t1.getText();
                String v = new String(t2.getPassword());  // Get password in string format

                String q = "SELECT * FROM login WHERE username='" + u + "' AND password='" + v + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            System.exit(0);  // Close the application
        }
    }

    // Main method to run the login screen
    public static void main(String[] arg) {
        new Login();
    }
}
