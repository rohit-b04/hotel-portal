package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setLayout(null);
        add(background, BorderLayout.CENTER);

        // Welcome Text
        JLabel heading = new JLabel("HOTEL NAKSHTRA WELCOMES YOU");
        heading.setBounds(500, 60, 1000, 80);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Serif", Font.BOLD, 50));
        heading.setOpaque(false);
        background.add(heading);

        // Centered Buttons Container
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 30, 30)); // 2x2 grid with spacing
        buttonPanel.setOpaque(false); // Make panel background transparent
        buttonPanel.setBounds(350, 250, 650, 300); // Set bounds for placement

        // HOTEL MANAGEMENT MENU BUTTONS
        JButton receptionButton = new JButton("Reception");
        receptionButton.setFont(new Font("Arial", Font.BOLD, 18));
        receptionButton.setBackground(new Color(70, 130, 180)); // SteelBlue background for button
        receptionButton.setForeground(Color.WHITE);
        receptionButton.setFocusPainted(false);
        receptionButton.setBorderPainted(false);
        receptionButton.setPreferredSize(new Dimension(250, 50));
        receptionButton.addActionListener(e -> new Reception().setVisible(true));

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setFont(new Font("Arial", Font.BOLD, 18));
        addEmployeeButton.setBackground(new Color(70, 130, 180));
        addEmployeeButton.setForeground(Color.WHITE);
        addEmployeeButton.setFocusPainted(false);
        addEmployeeButton.setBorderPainted(false);
        addEmployeeButton.setPreferredSize(new Dimension(250, 50));
        addEmployeeButton.addActionListener(e -> new AddEmployee().setVisible(true));

        JButton addRoomButton = new JButton("Add Rooms");
        addRoomButton.setFont(new Font("Arial", Font.BOLD, 18));
        addRoomButton.setBackground(new Color(70, 130, 180));
        addRoomButton.setForeground(Color.WHITE);
        addRoomButton.setFocusPainted(false);
        addRoomButton.setBorderPainted(false);
        addRoomButton.setPreferredSize(new Dimension(250, 50));
        addRoomButton.addActionListener(e -> new AddRoom().setVisible(true));

        JButton addDriverButton = new JButton("Add Drivers");
        addDriverButton.setFont(new Font("Arial", Font.BOLD, 18));
        addDriverButton.setBackground(new Color(70, 130, 180));
        addDriverButton.setForeground(Color.WHITE);
        addDriverButton.setFocusPainted(false);
        addDriverButton.setBorderPainted(false);
        addDriverButton.setPreferredSize(new Dimension(250, 50));
        addDriverButton.addActionListener(e -> new AddDrivers().setVisible(true));

        // Add buttons to the panel
        buttonPanel.add(receptionButton);
        buttonPanel.add(addEmployeeButton);
        buttonPanel.add(addRoomButton);
        buttonPanel.add(addDriverButton);

        background.add(buttonPanel); // Add the button panel to the background

        // Menu Bar (kept for additional navigation if needed)
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(4, 34, 34)); // Dark background for a sleek look
        menuBar.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2)); // Gold border for contrast
        setJMenuBar(menuBar);

        // Customizing the background color of the content pane
        getContentPane().setBackground(new Color(240, 248, 255)); // AliceBlue background for clean look
    }
}
