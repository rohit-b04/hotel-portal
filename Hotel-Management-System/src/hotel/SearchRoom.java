package hotel;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class SearchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
	Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SearchRoom frame = new SearchRoom();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SearchRoom() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitle = new JLabel("Search Room");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setBounds(260, 10, 200, 30);
		contentPane.add(lblTitle);

		JLabel lblBedType = new JLabel("Room Bed Type:");
		lblBedType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBedType.setBounds(50, 70, 120, 25);
		contentPane.add(lblBedType);

		c1 = new Choice();
		c1.add("Single Bed");
		c1.add("Double Bed");
		c1.setBounds(180, 70, 130, 25);
		contentPane.add(c1);

		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBackground(Color.WHITE);
		checkRoom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkRoom.setBounds(400, 70, 200, 25);
		contentPane.add(checkRoom);

		// Table Column Labels
		String[] columnLabels = { "Room Number", "Availability", "Clean Status", "Price", "Bed Type" };
		int x = 30;
		for (String label : columnLabels) {
			JLabel lbl = new JLabel(label);
			lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbl.setBounds(x, 140, 100, 20);
			contentPane.add(lbl);
			x += 125;
		}

		table = new JTable();
		table.setBounds(0, 170, 680, 200);
		contentPane.add(table);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(180, 400, 120, 35);
		btnSearch.setBackground(new Color(34, 139, 34));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnSearch);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(360, 400, 120, 35);
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnBack);

		// Button Actions
		btnSearch.addActionListener(e -> {
			String SQL = "select * from Room where bed_type = '" + c1.getSelectedItem() + "'";
			String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '" + c1.getSelectedItem() + "'";
			try {
				conn c = new conn();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				if (checkRoom.isSelected()) {
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
			} catch (SQLException ss) {
				ss.printStackTrace();
			}
		});

		btnBack.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});
	}
}
