package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddEmployee extends JFrame {

    JTextField textField, textField_1, textField_3, textField_4, textField_5;
    JComboBox<String> c1;
    JButton b2;
    JRadioButton maleButton, femaleButton;

    public AddEmployee() {
        setTitle("ADD EMPLOYEE DETAILS");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1000, 600);
        getContentPane().setLayout(null);

        // Setting background to a light blue for a fresh feel
        getContentPane().setBackground(new Color(235, 243, 250));

        // Header section with a larger font
        JLabel header = new JLabel("ADD EMPLOYEE DETAILS");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setForeground(new Color(0, 102, 204));
        header.setBounds(330, 30, 400, 40);
        add(header);

        // Form Fields with large padding and modern fonts
        JLabel lblName = new JLabel("NAME");
        lblName.setFont(new Font("Arial", Font.PLAIN, 18));
        lblName.setBounds(100, 100, 150, 30);
        add(lblName);

        textField = new JTextField();
        textField.setBounds(250, 100, 300, 35);
        textField.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
        add(textField);

        JLabel lblAge = new JLabel("AGE");
        lblAge.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAge.setBounds(100, 160, 150, 30);
        add(lblAge);

        textField_1 = new JTextField();
        textField_1.setBounds(250, 160, 300, 35);
        textField_1.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
        add(textField_1);

        JLabel lblGender = new JLabel("GENDER");
        lblGender.setFont(new Font("Arial", Font.PLAIN, 18));
        lblGender.setBounds(100, 220, 150, 30);
        add(lblGender);

        maleButton = new JRadioButton("MALE");
        maleButton.setBackground(Color.WHITE);
        maleButton.setFont(new Font("Arial", Font.PLAIN, 16));
        maleButton.setBounds(250, 220, 100, 30);
        add(maleButton);

        femaleButton = new JRadioButton("FEMALE");
        femaleButton.setBackground(Color.WHITE);
        femaleButton.setFont(new Font("Arial", Font.PLAIN, 16));
        femaleButton.setBounds(370, 220, 100, 30);
        add(femaleButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel lblJob = new JLabel("JOB");
        lblJob.setFont(new Font("Arial", Font.PLAIN, 18));
        lblJob.setBounds(100, 280, 150, 30);
        add(lblJob);

        String[] jobRoles = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox<>(jobRoles);
        c1.setBounds(250, 280, 300, 35);
        c1.setFont(new Font("Arial", Font.PLAIN, 16));
        c1.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
        add(c1);

        // Additional fields like salary, phone, etc.
        JLabel lblSalary = new JLabel("SALARY");
        lblSalary.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSalary.setBounds(100, 340, 150, 30);
        add(lblSalary);

        textField_3 = new JTextField();
        textField_3.setBounds(250, 340, 300, 35);
        textField_3.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
        add(textField_3);

        JLabel lblPhone = new JLabel("PHONE");
        lblPhone.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPhone.setBounds(100, 400, 150, 30);
        add(lblPhone);

        textField_4 = new JTextField();
        textField_4.setBounds(250, 400, 300, 35);
        textField_4.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
        add(textField_4);

        // Save button with larger text and a bold color
        b2 = new JButton("SAVE");
        b2.setBounds(250, 470, 300, 45);
        b2.setBackground(new Color(0, 102, 204));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setBorder(BorderFactory.createEmptyBorder());
        add(b2);

        // Action listener for the save button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = textField.getText();
                String age = textField_1.getText();
                String salary = textField_3.getText();
                String phone = textField_4.getText();
                String gender = null;

                if (maleButton.isSelected()) {
                    gender = "male";
                } else if (femaleButton.isSelected()) {
                    gender = "female";
                }

                String job = (String) c1.getSelectedItem();

                try {
                    conn c = new conn();
                    String query = "INSERT INTO employee (name, age, gender, job, salary, phone) values( '" + name + "', '" + age + "', '" + gender + "','" + job + "', '" + salary + "', '" + phone + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
        });

        // Set the window to be centered and allow full-screen size adjustments
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
