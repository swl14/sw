package UI;

import javax.swing.*;

import DAO.RoomDAO;
import DAO.WorkerDAO;
import VO.Room;
import VO.Worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectUI extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private Room room;
	private RoomDAO dao = new RoomDAO();
	private WorkerDAO wdao = new WorkerDAO();
	private ArrayList<Room> roomList;
	private JList list;
	private String id;

	public SelectUI(String id) {
		this.id = id;
		setSize(750, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 10, 534, 315);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("\uBC29 \uBC88\uD638");
		lblNewLabel.setBounds(26, 18, 89, 15);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uC774\uB984");
		lblNewLabel_1.setBounds(150, 18, 136, 15);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uAE30\uAC04");
		lblNewLabel_2.setBounds(345, 18, 170, 15);
		panel.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 43, 516, 259);
		panel.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		btnNewButton = new JButton("\uC785\uC7A5");
		btnNewButton.setBounds(417, 350, 129, 85);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
		btnNewButton_1.setBounds(581, 350, 129, 85);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);

		refreshList();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		roomList = new ArrayList<Room>();
		room = new Room();	
		if (e.getSource() == btnNewButton) {
			room = dao.RoomList().get(list.getSelectedIndex());
			String check = JOptionPane.showInputDialog("패스워드를 입력하세요");
			if (dao.RoomCheck(room.getRoom_seq(), check)) {
				ProjectRoom pr = new ProjectRoom();
				new Thread(pr).start();
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(btnNewButton, "입장에 실패했습니다");
				return;
			}
			wdao.numUpdate(room, id);
		}
		if (e.getSource() == btnNewButton_1) {
			RoomUI roomUI = new RoomUI();
			roomUI.setVisible(true);
		}
	}

	public void refreshList() {
		list.setListData(dao.RoomList().toArray());
	}

}
