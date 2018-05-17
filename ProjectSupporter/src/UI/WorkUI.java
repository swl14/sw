package UI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.nio.channels.ClosedSelectorException;

import javax.swing.*;

import DAO.WorkDAO;
import VO.Work;

import javax.swing.JTextField;
import javax.swing.JButton;

public class WorkUI extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private WorkDAO dao;
	private int room_seq;
	
	public WorkUI(int room_seq) {
	dao = new WorkDAO();
	this.room_seq = room_seq;
	
	setSize(320,400);
	setLocation(700, 200);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //현재창만 닫힘
	getContentPane().setLayout(null);
	
	JLabel label = new JLabel("\uC5C5\uBB34\uBA85 : ");
	label.setBounds(14, 60, 118, 18);
	getContentPane().add(label);
	
	JLabel lblNewLabel = new JLabel("\uC5C5\uBB34 \uC2DC\uC791\uC77C : ");
	lblNewLabel.setBounds(14, 95, 118, 18);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("\uC608\uC0C1 \uC18C\uC694\uAE30\uAC04 : ");
	lblNewLabel_1.setBounds(14, 130, 118, 18);
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("\uC5C5\uBB34 \uC778\uC6D0\uC218 : ");
	lblNewLabel_2.setBounds(14, 165, 118, 18);
	getContentPane().add(lblNewLabel_2);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(0, 42, 300, 4);
	getContentPane().add(separator);
	
	JLabel label_1 = new JLabel("\uC0C8\uB85C\uC6B4 \uC5C5\uBB34 \uCD94\uAC00");
	label_1.setBounds(100, 12, 118, 18);
	getContentPane().add(label_1);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setOrientation(SwingConstants.VERTICAL);
	separator_1.setBounds(121, 44, 11, 259);
	getContentPane().add(separator_1);
	
	textField = new JTextField();
	textField.setBounds(138, 57, 149, 24);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(137, 92, 149, 24);
	getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setBounds(137, 127, 149, 24);
	getContentPane().add(textField_2);
	textField_2.setColumns(10);
	
	textField_3 = new JTextField();
	textField_3.setBounds(137, 162, 149, 24);
	getContentPane().add(textField_3);
	textField_3.setColumns(10);
	
	JLabel lblNewLabel_3 = new JLabel("\uC5C5\uBB34 \uC0C1\uC138\uC815\uBCF4 : ");
	lblNewLabel_3.setBounds(14, 200, 104, 18);
	getContentPane().add(lblNewLabel_3);
	
	textField_4 = new JTextField();
	textField_4.setBounds(137, 198, 150, 87);
	getContentPane().add(textField_4);
	textField_4.setColumns(10);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setBounds(0, 301, 302, 12);
	getContentPane().add(separator_2);
	
	btnNewButton = new JButton("\uCDE8\uC18C");
	btnNewButton.setBounds(14, 315, 105, 27);
	btnNewButton.addActionListener(this);
	getContentPane().add(btnNewButton);
	
	btnNewButton_1 = new JButton("\uB4F1\uB85D");
	btnNewButton_1.setBounds(183, 315, 105, 27);
	btnNewButton_1.addActionListener(this);
	getContentPane().add(btnNewButton_1);
	
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton_1) {
			String work_name = textField.getText();
			String start_day = textField_1.getText();
			String period = textField_2.getText();
			String people = textField_3.getText();
			String detail = textField_4.getText();
			
			Work w = new Work();
			w.setWork_name(work_name);
			w.setStart_day(start_day);
			w.setPeriod(period);
			w.setPeople(people);
			w.setDetail(detail);
			w.setProgress("0");
			w.setRoom_seq(String.valueOf(room_seq));
			dao.insertWork(w);
			//등록 메서드 추가
			setVisible(false);
		}
		//등록 취소 버튼 (완료) 
		if(e.getSource()==btnNewButton) {
			setVisible(false);
		}
	}
}
