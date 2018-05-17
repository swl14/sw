package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import DAO.WorkerDAO;
import VO.Worker;

public class WorkerDetailUI extends JFrame implements ActionListener {
	private JLabel textField;
	private JLabel textField_1;
	private JLabel textField_3;
	private JLabel textField_4;
	private JButton btnNewButton;
	private WorkerDAO dao;
	private Worker w;

	public WorkerDetailUI(Worker worker) {
		w = worker;
		dao = new WorkerDAO();
		setSize(400, 450);
		setLocation(450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(77, 105, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(77, 155, 97, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setBounds(77, 206, 57, 15);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_4.setBounds(77, 261, 57, 15);
		getContentPane().add(lblNewLabel_4);

		textField = new JLabel();
		textField.setBackground(Color.WHITE);
		textField.setBounds(225, 100, 116, 24);
		textField.setOpaque(true);
		getContentPane().add(textField);
		textField.setText(w.getName());

		textField_1 = new JLabel();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(225, 150, 116, 24);
		textField_1.setOpaque(true);
		getContentPane().add(textField_1);
		textField_1.setText(w.getId());

		textField_3 = new JLabel();
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(225, 203, 116, 21);
		textField_3.setOpaque(true);
		getContentPane().add(textField_3);
		textField_3.setText(w.getPhone_number());

		textField_4 = new JLabel();
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(225, 258, 116, 21);
		textField_4.setOpaque(true);
		getContentPane().add(textField_4);
		textField_4.setText(w.getEmail());

		btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(244, 318, 97, 51);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 50, 384, 8);
		getContentPane().add(separator);

		JLabel lblNewLabel_5 = new JLabel("\uD300\uC6D0 \uC0C1\uC138 \uC815\uBCF4");
		lblNewLabel_5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblNewLabel_5.setBounds(115, 10, 168, 30);
		getContentPane().add(lblNewLabel_5);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
