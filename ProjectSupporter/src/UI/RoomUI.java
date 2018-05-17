package UI;

import java.awt.event.*;

import javax.swing.*;

import DAO.RoomDAO;
import VO.Room;

public class RoomUI extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private RoomDAO dao;
	private String id;
	private int room_seq;
	
	public RoomUI(String id) {
		this.id = id;
		dao = new RoomDAO();
		setSize(500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC29 \uC774\uB984");
		lblNewLabel.setBounds(77, 165, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uC2DC\uC791\uC77C");
		lblNewLabel_1.setBounds(77, 227, 97, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uC885\uB8CC\uC77C");
		lblNewLabel_2.setBounds(77, 282, 88, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uBC29 \uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_3.setBounds(77, 326, 72, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(225, 161, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(226, 223, 115, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 279, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(225, 323, 116, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBounds(294, 397, 97, 23);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton) {
			String room_name = textField.getText();
			String first_day = textField_1.getText();
			String last_day = textField_2.getText();
			String room_password = textField_3.getText();
			
			Room vo = new Room();
			vo.setRoom_name(room_name);
			vo.setFirst_day(first_day);
			vo.setLast_day(last_day);
			vo.setRoom_password(room_password);
			vo.setLeader("notyet");
			vo.setRoom_creater(id);
			dao.insertRoom(vo);
			room_seq = dao.Room_seqFinder(id);
			
			System.out.println(room_seq);
			ProjectRoom pr = new ProjectRoom(room_seq, id);
			pr.setVisible(true);
			this.setVisible(false);
		}
	}
}
