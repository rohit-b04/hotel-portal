package hotel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.event.*;

public class CheckOut extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
	private Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CheckOut frame = new CheckOut();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void close() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public CheckOut() throws SQLException {
		// Setup the window
		setTitle("Check-Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Set background image
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(300, 0, 500, 225);
		add(l1);

		// Check-out label
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);

		// Number label and choice (dropdown)
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);

		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			}
		} catch (Exception e) {}

		c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);

		// Check button to retrieve room number based on customer number
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JButton l2 = new JButton(i6);
		l2.setBounds(290, 82, 20, 20);
		add(l2);

		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					conn c = new conn();
					String number = c1.getSelectedItem();
					ResultSet rs = c.s.executeQuery("select * from customer where number = " + number);

					if (rs.next()) {
						t1.setText(rs.getString("room_number"));
					}
				} catch (Exception e) {}
			}
		});

		// Room Number label and text field
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 120, 20);
		contentPane.add(lblRoomNumber);

		t1 = new JTextField();
		t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);

		// Check-out button
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = c1.getSelectedItem();
				String roomNumber = t1.getText();
				String deleteSQL = "DELETE FROM customer WHERE number = " + id;
				String q2 = "UPDATE room SET availability = 'Available' WHERE room_number = " + roomNumber;

				conn c = new conn();
				try {
					c.s.executeUpdate(deleteSQL);
					c.s.executeUpdate(q2);
					JOptionPane.showMessageDialog(null, "Check Out Successful");
					new Reception().setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
		btnCheckOut.setBackground(new Color(30, 144, 255)); // Dodger Blue
		btnCheckOut.setForeground(Color.WHITE);
		btnCheckOut.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(btnCheckOut);

		// Back button
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
		btnExit.setBackground(new Color(255, 69, 0)); // Red-Orange
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(btnExit);

		// Set background color for the content pane
		getContentPane().setBackground(Color.WHITE);
	}
}
