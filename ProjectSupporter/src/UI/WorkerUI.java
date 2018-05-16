package UI;

import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;

import Common.Data;
import DAO.WorkerDAO;
import VO.Room;
import VO.Worker;
import java.awt.Font;

public class WorkerUI extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private WorkerDAO dao;
	private JList list;

	public WorkerUI() {
		dao = new WorkerDAO();
		setSize(400, 450);
		setLocation(450, 300);
		getContentPane().setLayout(null);
		list = new JList();

		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(77, 71, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(77, 117, 97, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_2.setBounds(77, 165, 57, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setBounds(77, 220, 57, 15);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_4.setBounds(77, 275, 57, 15);
		getContentPane().add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(225, 71, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(225, 117, 116, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(225, 162, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(225, 217, 116, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(225, 272, 116, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(244, 318, 97, 51);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 50, 384, 8);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("\uD68C\uC6D0 \uAC00\uC785");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_5.setBounds(145, 10, 97, 30);
		getContentPane().add(lblNewLabel_5);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) {
			String name = textField.getText();
			String id = textField_1.getText();
			String password = textField_2.getText();
			String phone_number = textField_3.getText();
			String email = textField_4.getText();

			Worker vo = new Worker();
			
			if (dao.idInsert(id)) {
				vo.setName(name);
				vo.setId(id);
				vo.setPassword(password);
				vo.setPhone_number(phone_number);
				vo.setEmail(email);
				vo.setRoom_seq("0");
				dao.insertWorker(vo);
				JOptionPane.showMessageDialog(btnNewButton, "가입 완료");
				this.setVisible(false);

			} else {
				JOptionPane.showMessageDialog(btnNewButton, "같은 아이디가 있습니다");
				textField_1.setText("");
			}
		}
	}
}
