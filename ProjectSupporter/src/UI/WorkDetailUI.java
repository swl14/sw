package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.WorkDAO;
import VO.Work;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class WorkDetailUI extends JFrame implements ActionListener{
	private JLabel textField;
	private JLabel textField_1;
	private JLabel textField_2;
	private JLabel textField_3;
	private JLabel textField_4;
	private JButton btnNewButton_1;
	private WorkDAO dao;
	private Work w;
	
	public WorkDetailUI(Work work) {
	w = work;
	dao = new WorkDAO();
	setSize(320,400);
	setLocation(700, 200);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //ÇöÀçÃ¢¸¸ ´ÝÈû
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
	
	JLabel label_1 = new JLabel("\uC5C5\uBB34 \uC0C1\uC138 \uBCF4\uAE30");
	label_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
	label_1.setBounds(81, 14, 149, 18);
	getContentPane().add(label_1);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setOrientation(SwingConstants.VERTICAL);
	separator_1.setBounds(121, 44, 11, 259);
	getContentPane().add(separator_1);
	
	textField = new JLabel();
	textField.setBackground(Color.WHITE);
	textField.setBounds(138, 57, 149, 24);
	textField.setOpaque(true);
	getContentPane().add(textField);
	textField.setText(w.getWork_name());
	
	textField_1 = new JLabel();
	textField_1.setBackground(Color.WHITE);
	textField_1.setBounds(137, 92, 149, 24);
	textField_1.setOpaque(true);
	getContentPane().add(textField_1);
	textField_1.setText(w.getStart_day());
	
	textField_2 = new JLabel();
	textField_2.setBackground(Color.WHITE);
	textField_2.setBounds(137, 127, 149, 24);
	textField_2.setOpaque(true);
	getContentPane().add(textField_2);
	textField_2.setText(w.getPeriod());
	
	textField_3 = new JLabel();
	textField_3.setBackground(Color.WHITE);
	textField_3.setBounds(137, 162, 149, 24);
	textField_3.setOpaque(true);
	getContentPane().add(textField_3);
	
	textField_3.setText(w.getPeople());
	
	JLabel lblNewLabel_3 = new JLabel("\uC5C5\uBB34 \uC0C1\uC138\uC815\uBCF4 : ");
	lblNewLabel_3.setBounds(14, 200, 104, 18);
	getContentPane().add(lblNewLabel_3);
	
	textField_4 = new JLabel();
	textField_4.setBackground(Color.WHITE);
	textField_4.setBounds(137, 198, 150, 87);
	textField_4.setOpaque(true);
	getContentPane().add(textField_4);
	
	textField_4.setText(w.getDetail());
	JSeparator separator_2 = new JSeparator();
	separator_2.setBounds(0, 301, 302, 12);
	getContentPane().add(separator_2);
	
	btnNewButton_1 = new JButton("\uD655\uC778");
	btnNewButton_1.setBounds(183, 315, 105, 27);
	btnNewButton_1.addActionListener(this);
	getContentPane().add(btnNewButton_1);
	
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
