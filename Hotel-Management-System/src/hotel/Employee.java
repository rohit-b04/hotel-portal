package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new Employee().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Employee() throws SQLException {
		setTitle("Employee Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Table
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);

		// Column Headers
		String[] headers = {"Name", "Age", "Gender", "Job", "Salary", "Phone", "Aadhar", "Gmail"};
		int x = 41;
		for (String header : headers) {
			JLabel label = new JLabel(header);
			label.setBounds(x, 11, 86, 14);
			contentPane.add(label);
			x += 118; // spacing between labels
		}

		// Load Data Button
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.setBounds(350, 500, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		btnLoadData.addActionListener(e -> {
			try {
				conn c = new conn();
				String sql = "SELECT * FROM Employee";
				ResultSet rs = c.s.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Back Button
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(510, 500, 120, 30);
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		contentPane.add(btnBack);

		btnBack.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
	}
}
