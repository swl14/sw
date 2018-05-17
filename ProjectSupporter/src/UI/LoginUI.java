package UI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import DAO.WorkerDAO;
import VO.Worker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Font;

public class LoginUI extends JFrame implements ActionListener {
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private WorkerDAO dao;
	private JSeparator separator;
	private JLabel lblNewLabel_2;
	private Worker worker;

	public LoginUI() {
		setSize(390, 280);
		setLocation(450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(80, 74, 57, 15);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_1.setBounds(80, 120, 57, 15);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(177, 70, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(196, 160, 97, 23);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setBounds(80, 160, 97, 23);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(177, 117, 116, 21);
		passwordField.addActionListener(this);
		getContentPane().add(passwordField);
		
		separator = new JSeparator();
		separator.setBounds(0, 50, 384, 7);
		getContentPane().add(separator);
		
		lblNewLabel_2 = new JLabel("Welcome ProjectSupporter");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(58, 10, 265, 30);
		getContentPane().add(lblNewLabel_2);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) {
			String name = textField.getText();
			String password = passwordField.getText();
			dao = new WorkerDAO();
			worker = dao.workerFinder(name);
			if(worker != null) {
				String seq = worker.getRoom_seq();
				if(dao.WorkerCheck(name, password)) {
					JOptionPane.showMessageDialog(btnNewButton, "로그인 성공");
					
					if(seq.equals("0")) {
					SelectUI selectUI = new SelectUI(name);
					selectUI.setVisible(true);
					}else {
						ProjectRoom projectroom = new ProjectRoom(Integer.parseInt(seq));
					}
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "로그인 실패");
				}			
			}else {
				JOptionPane.showMessageDialog(btnNewButton, "존재 하지 않는 ID");
			}
			
		} 
		
		if (e.getSource() == btnNewButton_1) {
			WorkerUI workerUI = new WorkerUI();
			workerUI.setVisible(true);
		}
	}
	
	
}
