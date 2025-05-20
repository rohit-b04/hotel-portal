package hotel;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ManagerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ManagerInfo frame = new ManagerInfo();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ManagerInfo() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		// Column Labels
		String[] headers = { "Name", "Age", "Gender", "Job", "Salary", "Phone", "Aadhar", "Gmail" };
		int x = 30;
		for (String header : headers) {
			JLabel label = new JLabel(header);
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setBounds(x, 10, 100, 20);
			contentPane.add(label);
			x += 120;
		}

		// Table
		table = new JTable();
		table.setBounds(0, 40, 980, 420);
		contentPane.add(table);

		// Load Data Button
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.setBounds(350, 480, 130, 35);
		btnLoadData.setBackground(new Color(34, 139, 34));
		btnLoadData.setForeground(Color.WHITE);
		btnLoadData.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnLoadData);

		// Back Button
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(510, 480, 130, 35);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnExit);

		// Load Button Logic
		btnLoadData.addActionListener(e -> {
			try {
				conn c = new conn();
				String displayQuery = "SELECT * FROM Employee WHERE job = 'Manager'";
				ResultSet rs = c.s.executeQuery(displayQuery);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Back Button Logic
		btnExit.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
	}
}
