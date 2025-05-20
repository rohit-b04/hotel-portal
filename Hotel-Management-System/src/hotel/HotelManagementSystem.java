package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

        JLabel l1, lid;
        JButton b1;

        public HotelManagementSystem() {

                // Set frame size and layout
                setSize(1366, 768);  // Full-screen height and width for better appearance
                setLayout(null);
                setLocationRelativeTo(null); // Center the window on screen

                // Background Image
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                l1.setBounds(0, 0, 1366, 768);  // Set background image size
                add(l1);

                // Title Label with Larger Font
                lid = new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(50, 250, 1300, 100);
                lid.setFont(new Font("Arial", Font.BOLD, 70));  // Make the title font bigger
                lid.setForeground(Color.WHITE);  // Set the title text to white for contrast
                lid.setHorizontalAlignment(JLabel.CENTER);  // Center align the title
                l1.add(lid);

                // Button to proceed
                b1 = new JButton("Next");
                b1.setBounds(1170, 650, 150, 50);
                b1.setFont(new Font("Arial", Font.BOLD, 18));
                b1.setBackground(new Color(0, 102, 204));  // Blue background for button
                b1.setForeground(Color.WHITE);
                b1.setFocusPainted(false);  // Remove border around button
                b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));  // White border around button
                b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  // Hand cursor for button hover
                l1.add(b1);

                // Add action listener for button
                b1.addActionListener(this);

                // Set background to soft white color
                getContentPane().setBackground(new Color(250, 250, 250));

                // Show the window
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when clicking the close button
        }

        // Action performed when the button is clicked
        public void actionPerformed(ActionEvent ae) {
                new Login().setVisible(true);
                this.setVisible(false);
        }

        public static void main(String[] args) {
                new HotelManagementSystem();
        }
}
