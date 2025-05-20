package hotel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class CustomerInfo extends JFrame {

	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblId, lblNewLabel, lblGender, lblCountry, lblRoom, lblStatus, lblDeposit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CustomerInfo frame = new CustomerInfo();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Method to close the window
	public void close() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public CustomerInfo() throws SQLException {
		// Setup connection
		// conn = Javaconnect.getDBConnection();

		setTitle("Customer Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Set the background color of the window
		getContentPane().setBackground(Color.WHITE);

		// Button to load data
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.setBounds(300, 510, 120, 30);
		btnLoadData.setBackground(new Color(30, 144, 255));  // Dodger Blue
		btnLoadData.setForeground(Color.WHITE);
		btnLoadData.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(btnLoadData);

		btnLoadData.addActionListener(arg0 -> {
			try {
				conn c = new conn();
				String displayCustomersql = "SELECT * FROM Customer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// Back Button
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(450, 510, 120, 30);
		btnExit.setBackground(new Color(255, 69, 0));  // Red-Orange
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(btnExit);

		btnExit.addActionListener(e -> {
			new Reception().setVisible(true);
			setVisible(false);
		});

		// Column Headers (Labels)
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblId);

		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(150, 11, 65, 14);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(270, 11, 65, 14);
		lblGender.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblGender);

		lblCountry = new JLabel("Country");
		lblCountry.setBounds(360, 11, 65, 14);
		lblCountry.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblCountry);

		lblRoom = new JLabel("Room");
		lblRoom.setBounds(470, 11, 65, 14);
		lblRoom.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblRoom);

		lblStatus = new JLabel("Check-in Status");
		lblStatus.setBounds(560, 11, 120, 14);
		lblStatus.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblStatus);

		lblDeposit = new JLabel("Deposit");
		lblDeposit.setBounds(690, 11, 65, 14);
		lblDeposit.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblDeposit);

		// Table to display data
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setRowHeight(30);
		table.setGridColor(Color.GRAY);
		contentPane.add(table);

		// Set background color of the window to white
		getContentPane().setBackground(Color.WHITE);
	}
}
