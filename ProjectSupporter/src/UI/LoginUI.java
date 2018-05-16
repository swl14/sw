package UI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import DAO.WorkerDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LoginUI extends JFrame implements ActionListener {
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private WorkerDAO dao;

	public LoginUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(80, 165, 57, 15);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_1.setBounds(80, 227, 57, 15);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(225, 161, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(231, 363, 97, 23);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setBounds(340, 363, 97, 23);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(225, 224, 116, 21);
		passwordField.addActionListener(this);
		getContentPane().add(passwordField);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) {
			String name = textField.getText();
			String password = passwordField.getText();
			dao = new WorkerDAO();
			if(dao.WorkerCheck(name, password)) {
				JOptionPane.showMessageDialog(btnNewButton, "로그인 성공");
				SelectUI selectUI = new SelectUI(name);
				selectUI.setVisible(true);
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(btnNewButton, "로그인 실패");
			}			
		} 
		
		if (e.getSource() == btnNewButton_1) {
			WorkerUI workerUI = new WorkerUI();
			workerUI.setVisible(true);
		}
	}
	
	
}
