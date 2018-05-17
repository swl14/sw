package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAO.RoomDAO;
import DAO.WorkerDAO;
import VO.Room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public class SelectUI extends JFrame implements ActionListener {
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private Room room;
	private RoomDAO dao = new RoomDAO();
	private WorkerDAO wdao = new WorkerDAO();
	private ArrayList<Room> roomList;
	private JTable jtable;
	private String id;
	private DefaultTableModel dtm;

	public SelectUI(String id) {
		this.id = id;
		setSize(570, 500);
		setLocation(350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnNewButton = new JButton("\uC785\uC7A5");
		btnNewButton.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(298, 350, 130, 85);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(95, 350, 130, 85);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);

		roomTable();
		setVisible(true);

	}

	public void roomTable() {
		String columnNames[] = { "방 번호", "프로젝트 이름", "프로젝트 기간" };
		roomList = dao.RoomList();
		Object rowData[][] = new Object[roomList.size()][3];
		for (int i = 0; i < roomList.size(); i++) {
			rowData[i][0] = roomList.get(i).getRoom_seq();
			rowData[i][1] = roomList.get(i).getRoom_name();
			rowData[i][2] = roomList.get(i).getFirst_day();
		}
		dtm = new DefaultTableModel(rowData, columnNames);
		JTable jtable = new JTable(dtm);
		
		scrollPane = new JScrollPane(jtable);
		scrollPane.setBounds(12, 10, 530, 311);
		getContentPane().add(scrollPane);
		
		/*JButton btnNewButton_2 = new JButton(new ImageIcon);
		btnNewButton_2.setBounds(492, 394, 50, 41);
		getContentPane().add(btnNewButton_2);*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		roomList = new ArrayList<Room>();
		
			
		int row = dtm.getRowCount();

		if (e.getSource() == btnNewButton) {
			String check = JOptionPane.showInputDialog("패스워드를 입력하세요");
			if (dao.RoomCheck(String.valueOf(row), check)) {
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(btnNewButton, "입장에 실패했습니다");
				return;
			}
			wdao.numUpdate(row, id);
			ProjectRoom projectRoom = new ProjectRoom(row);
			projectRoom.setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == btnNewButton_1) {
			RoomUI roomUI = new RoomUI(id);
			roomUI.setVisible(true);
		}
	}
}
