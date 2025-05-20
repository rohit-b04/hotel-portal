package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddDrivers extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5;
	private JComboBox<String> comboBox, comboBox_1;
	private JButton b1, b2;

	public static void main(String[] args) {
		new AddDrivers().setVisible(true);
	}

	public AddDrivers() {
		setBounds(450, 200, 1000, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Background image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l15 = new JLabel(i2);
		l15.setBounds(400, 30, 500, 370);
		add(l15);

		// Title label
		JLabel l10 = new JLabel("Add Drivers");
		l10.setFont(new Font("Tahoma", Font.BOLD, 18));
		l10.setBounds(194, 10, 120, 22);
		contentPane.add(l10);

		// Name label and text field
		JLabel l1 = new JLabel("Name");
		l1.setForeground(new Color(25, 25, 112));
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(64, 70, 102, 22);
		contentPane.add(l1);

		t1 = new JTextField();
		t1.setBounds(174, 70, 156, 20);
		contentPane.add(t1);

		// Age label and text field
		JLabel l2 = new JLabel("Age");
		l2.setForeground(new Color(25, 25, 112));
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(64, 110, 102, 22);
		contentPane.add(l2);

		t2 = new JTextField();
		t2.setBounds(174, 110, 156, 20);
		contentPane.add(t2);

		// Gender label and combo box
		JLabel l3 = new JLabel("Gender");
		l3.setForeground(new Color(25, 25, 112));
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(64, 150, 102, 22);
		contentPane.add(l3);

		comboBox = new JComboBox<>(new String[] { "Male", "Female" });
		comboBox.setBounds(176, 150, 154, 20);
		contentPane.add(comboBox);

		// Car company label and text field
		JLabel l4 = new JLabel("Car Company");
		l4.setForeground(new Color(25, 25, 112));
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(64, 190, 102, 22);
		contentPane.add(l4);

		t3 = new JTextField();
		t3.setBounds(174, 190, 156, 20);
		contentPane.add(t3);

		// Car brand label and text field
		JLabel l5 = new JLabel("Car Brand");
		l5.setForeground(new Color(25, 25, 112));
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(64, 230, 102, 22);
		contentPane.add(l5);

		t4 = new JTextField();
		t4.setBounds(174, 230, 156, 20);
		contentPane.add(t4);

		// Available label and combo box
		JLabel l6 = new JLabel("Available");
		l6.setForeground(new Color(25, 25, 112));
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setBounds(64, 270, 102, 22);
		contentPane.add(l6);

		comboBox_1 = new JComboBox<>(new String[] { "Yes", "No" });
		comboBox_1.setBounds(176, 270, 154, 20);
		contentPane.add(comboBox_1);

		// Location label and text field
		JLabel l7 = new JLabel("Location");
		l7.setForeground(new Color(25, 25, 112));
		l7.setFont(new Font("Tahoma", Font.BOLD, 14));
		l7.setBounds(64, 310, 102, 22);
		contentPane.add(l7);

		t5 = new JTextField();
		t5.setBounds(174, 310, 156, 20);
		contentPane.add(t5);

		// Buttons
		b1 = new JButton("Add");
		b1.setBounds(64, 380, 111, 33);
		b1.setBackground(new Color(0, 0, 0));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		contentPane.add(b1);

		b2 = new JButton("Back");
		b2.setBounds(198, 380, 111, 33);
		b2.setBackground(new Color(0, 0, 0));
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		contentPane.add(b2);

		// Panel background color
		contentPane.setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == b1) {
				String name = t1.getText();
				String age = t2.getText();
				String gender = (String) comboBox.getSelectedItem();
				String company = t3.getText();
				String brand = t4.getText();
				String available = (String) comboBox_1.getSelectedItem();
				String location = t5.getText();

				// Insert data into the database
				conn c = new conn();
				String str = "INSERT INTO driver VALUES('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + brand + "', '" + available + "', '" + location + "')";
				c.s.executeUpdate(str);

				JOptionPane.showMessageDialog(null, "Driver Successfully Added");
				this.setVisible(false);

			} else if (ae.getSource() == b2) {
				this.setVisible(false); // Go back to the previous screen
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}
	}
}
