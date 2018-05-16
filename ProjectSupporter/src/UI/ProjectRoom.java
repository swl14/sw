package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Common.Data;
import DAO.WorkDAO;
import DAO.WorkerDAO;
import VO.Room;
import VO.Work;
import VO.Worker;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class ProjectRoom extends JFrame implements ActionListener, Runnable {
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_7;
	private JList list;
	private JList list_2;
	JTextArea outputText;
	private JTextField textField;
	private WorkDAO dao1;
	private WorkerDAO dao2;
	private Room room;
	private Work work;
	private Worker worker;
	private ArrayList<Work> workList;

	public ProjectRoom() {
		dao1 = new WorkDAO();
		dao2 = new WorkerDAO();
		room = new Room();
		setSize(780, 700);
		setLocation(350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD504\uB85C\uC81D\uD2B8\uBA85");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(164, 12, 152, 43);
		getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 56, 474, 11);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(475, 0, 16, 700);
		getContentPane().add(separator_1);

		JLabel label = new JLabel("\uC5C5\uBB34 \uB9AC\uC2A4\uD2B8");
		label.setBounds(121, 79, 81, 18);
		getContentPane().add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 114, 282, 492);
		getContentPane().add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
		refreshWorkList();

		btnNewButton = new JButton("\uC0C8\uB85C\uC6B4 \uC5C5\uBB34 \uB4F1\uB85D");
		btnNewButton.setBounds(307, 114, 157, 37);
		btnNewButton.addActionListener(this);

		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uC5C5\uBB34 \uC218\uC815");
		btnNewButton_1.setBounds(307, 163, 154, 37);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("\uC5C5\uBB34 \uC0AD\uC81C");
		btnNewButton_2.setBounds(307, 212, 154, 37);
		btnNewButton_2.addActionListener(this);
		getContentPane().add(btnNewButton_2);

		JLabel label_1 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uC9C4\uCC99\uB3C4 :");
		label_1.setBounds(30, 618, 122, 18);
		getContentPane().add(label_1);

		JButton btnNewButton_3 = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC644\uB8CC");
		btnNewButton_3.setBounds(329, 614, 122, 27);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\uC5C5\uBB34 \uC0C1\uC138\uC815\uBCF4 \uD655\uC778");
		btnNewButton_4.setBounds(307, 261, 154, 43);
		getContentPane().add(btnNewButton_4);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(488, 56, 260, 145);
		getContentPane().add(scrollPane_1);

		list_2 = new JList();
		scrollPane_1.setViewportView(list_2);
		refreshWorkerList();

		outputText = new JTextArea();
		outputText.setLineWrap(true);

		JScrollPane scrollPane_2 = new JScrollPane(outputText);
		scrollPane_2.setBounds(489, 247, 259, 314);
		getContentPane().add(scrollPane_2);

		JLabel lblNewLabel_1 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uCC38\uC5EC \uD300\uC6D0");
		lblNewLabel_1.setBounds(488, 30, 130, 18);
		getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_5 = new JButton("\uD300\uC7A5 \uC120\uCD9C");
		btnNewButton_5.setBounds(488, 208, 105, 27);
		getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\uD300\uC6D0 \uC815\uBCF4 \uD655\uC778");
		btnNewButton_6.setBounds(626, 208, 122, 27);
		getContentPane().add(btnNewButton_6);

		textField = new JTextField();
		textField.setBounds(488, 582, 196, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton_7 = new JButton("\uC1A1\uC2E0");
		btnNewButton_7.setBounds(687, 581, 61, 27);
		btnNewButton_7.addActionListener(this);
		getContentPane().add(btnNewButton_7);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnNewButton) {
			WorkUI wi = new WorkUI();
			wi.setVisible(true);
		}

		if (e.getSource() == btnNewButton_1) {
			Work work = new Work(); 
			System.out.println(list.getSelectedIndex());
			work = dao1.WorkList().get(list.getSelectedIndex());
			WorkUpdateUI wu = new WorkUpdateUI();
			wu.setVisible(true);
			dao1.updateWork(work);
		}
		
		if (e.getSource() == btnNewButton_2) {
			dao1.deleteWork(work.getWork_seq());
			System.out.println(work.getWork_seq());
			refreshWorkList();
		}
		
		if (e.getSource() == btnNewButton_7) {
			String message = textField.getText();
			if (message.isEmpty())
				return;
			textField.setText("");

			Data data = new Data(Data.CHAT_MESSAGE, message);
			try {
				output(message);
			} catch (Exception e7) {
				System.out.println("���� ����");
			}
		}
	}

	public void output(String msg) {
		outputText.append(msg + "\n");
	}

	public void refreshWorkList() {
		list.setListData(dao1.WorkList().toArray());
	}

	public void refreshWorkerList() {
		list_2.setListData(dao2.WorkerList().toArray());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
/*		while (true) {
			refreshWorkList();
			refreshWorkerList();
		}*/
	}
}