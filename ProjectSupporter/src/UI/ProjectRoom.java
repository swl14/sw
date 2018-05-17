package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.collections.MappingChange.Map;

import DAO.RoomDAO;
import DAO.WorkDAO;
import DAO.WorkerDAO;
import VO.Room;
import VO.Work;
import VO.Worker;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProjectRoom extends JFrame implements ActionListener, Runnable, MouseListener {
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JTextArea outputText;
	private JTextField textField;
	private WorkDAO dao1;
	private WorkerDAO dao2;
	private Room room;
	private Work work;
	private Worker worker;
	private ArrayList<Work> workList;
	private ArrayList<Worker> workerList;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private int room_seq;
	private JTable jtable;
	private JTable jtable_1;
	private WorkUI wi;
	private String id;
	private RoomDAO rdao = new RoomDAO();

	public ProjectRoom(int room_seq, String id) {
		this.id = id;
		this.room_seq = room_seq;
		dao1 = new WorkDAO();
		dao2 = new WorkerDAO();
		room = new Room();
		
		setSize(780, 700);
		setLocation(350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD504\uB85C\uC81D\uD2B8\uBA85");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
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
		if (dao2.workerFinder(id).getWorker_seq().equals(rdao.RoomFinder(room_seq).getLeader())) {
			btnNewButton_3 = new JButton("\uD504\uB85C\uC81D\uD2B8 \uC644\uB8CC");
			btnNewButton_3.setBounds(329, 614, 122, 27);
			btnNewButton_3.addActionListener(this);
			getContentPane().add(btnNewButton_3);
		}

		btnNewButton_4 = new JButton("\uC5C5\uBB34 \uC0C1\uC138\uC815\uBCF4 \uD655\uC778");
		btnNewButton_4.setBounds(307, 261, 154, 43);
		btnNewButton_4.addActionListener(this);
		getContentPane().add(btnNewButton_4);

		outputText = new JTextArea();
		outputText.setLineWrap(true);

		JScrollPane scrollPane_2 = new JScrollPane(outputText);
		scrollPane_2.setBounds(489, 247, 259, 314);
		getContentPane().add(scrollPane_2);

		JLabel lblNewLabel_1 = new JLabel("\uD504\uB85C\uC81D\uD2B8 \uCC38\uC5EC \uD300\uC6D0");
		lblNewLabel_1.setBounds(488, 30, 130, 18);
		getContentPane().add(lblNewLabel_1);

		if (dao2.workerFinder(id).getLeader().equals("0")) {
			btnNewButton_5 = new JButton("\uD300\uC7A5 \uC120\uCD9C");
			btnNewButton_5.setBounds(488, 208, 105, 27);
			btnNewButton_5.addActionListener(this);
			getContentPane().add(btnNewButton_5);
		}
		btnNewButton_6 = new JButton("\uD300\uC6D0 \uC815\uBCF4 \uD655\uC778");
		btnNewButton_6.setBounds(626, 208, 122, 27);
		btnNewButton_6.addActionListener(this);
		getContentPane().add(btnNewButton_6);

		textField = new JTextField();
		textField.setBounds(488, 582, 196, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		btnNewButton_7 = new JButton("\uC1A1\uC2E0");
		btnNewButton_7.setBounds(687, 581, 61, 27);
		btnNewButton_7.addActionListener(this);
		getContentPane().add(btnNewButton_7);

		workTable();
		workerTable();
		
		leadercheck0();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNewButton) {
			wi = new WorkUI(room_seq);
			wi.setVisible(true);
		}

		if (e.getSource() == btnNewButton_1) {
			Work work = new Work();
			if (jtable.getSelectedRow() != -1) {
				work = workList.get(jtable.getSelectedRow());
				WorkUpdateUI workupdate = new WorkUpdateUI(work);
				workupdate.setVisible(true);
			}
		}

		if (e.getSource() == btnNewButton_2) {
			if (jtable.getSelectedRow() != -1) {
				dao1.deleteWork(workList.get(jtable.getSelectedRow()).getWork_seq());
			}
		}

		if (e.getSource() == btnNewButton_3) {
			ArrayList<Worker> workerlist = dao2.WorkerList(room_seq);
			Worker w = new Worker();
			for (int i = 0; i < workerlist.size() ; i++) {
				dao2.numUpdate(0, workerlist.get(i).getId());
			}
			dao1.finishWork(String.valueOf(room_seq));
		}

		if (e.getSource() == btnNewButton_4) {
			if (jtable.getSelectedRow() != -1) {
				work = workList.get(jtable.getSelectedRow());
				WorkDetailUI wdi = new WorkDetailUI(work);
				wdi.setVisible(true);
			}
		}
		if (e.getSource() == btnNewButton_5) {
			if (jtable_1.getSelectedRow() != -1) {
				WorkerDAO workerdao = new WorkerDAO();
				workerdao.leaderChoice(Integer.parseInt(workerList.get(jtable_1.getSelectedRow()).getWorker_seq()), id);
				JOptionPane.showMessageDialog(this, "'refresh'하시면 다시 투표 할 수 없습니다.");
			}
		}
		if (e.getSource() == btnNewButton_6) {
			if (jtable_1.getSelectedRow() != -1) {
				worker = workerList.get(jtable_1.getSelectedRow());
				WorkerDetailUI wdu = new WorkerDetailUI(worker);
				wdu.setVisible(true);
			}
		}

		if (e.getSource() == btnNewButton_7) {
			String message = textField.getText();
			if (message.isEmpty())
				return;
			textField.setText("");

			try {
				output(message);
			} catch (Exception e7) {
				System.out.println("전송 실패");
			}
		}
		if (e.getSource() == btnNewButton_8) {
			this.setVisible(false);
			ProjectRoom pr = new ProjectRoom(room_seq, id);
			pr.setVisible(true);
		}
		if (e.getSource() == btnNewButton_9) {
			leadercheck();
		}
	}

	public void output(String msg) {
		outputText.append(msg + "\n");
	}

	public void workTable() {
		String columnNames[] = { "업무명", "업무 진행도" };
		workList = dao1.WorkList(room_seq);
		Object rowData[][] = new Object[workList.size()][2];
		for (int i = 0; i < workList.size(); i++) {
			rowData[i][0] = workList.get(i).getWork_name();
			rowData[i][1] = workList.get(i).getProgress();
		}
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		jtable = new JTable(dtm);
		jtable.addMouseListener(this);
		scrollPane = new JScrollPane(jtable);
		scrollPane.setBounds(20, 114, 282, 492);
		getContentPane().add(scrollPane);
	}

	public void workerTable() {
		String columnNames[] = { "이름", "ID" };
		workerList = dao2.WorkerList(room_seq);

		Object rowData_1[][] = new Object[workerList.size()][2];
		for (int i = 0; i < workerList.size(); i++) {
			rowData_1[i][0] = workerList.get(i).getName();
			rowData_1[i][1] = workerList.get(i).getId();
		}
		DefaultTableModel dtm = new DefaultTableModel(rowData_1, columnNames);
		jtable_1 = new JTable(dtm);
		jtable_1.addMouseListener(this);
		scrollPane_1 = new JScrollPane(jtable_1);
		scrollPane_1.setBounds(488, 56, 260, 145);
		getContentPane().add(scrollPane_1);

		btnNewButton_8 = new JButton(new ImageIcon("C:\\Users\\user\\git\\sw\\ProjectSupporter\\refresh.png"));
		btnNewButton_8.setBounds(420, 10, 45, 37);
		btnNewButton_8.addActionListener(this);
		getContentPane().add(btnNewButton_8);

		btnNewButton_9 = new JButton("\uD300\uC7A5 \uD655\uC778");
		btnNewButton_9.addActionListener(this);
		btnNewButton_9.setBounds(655, 28, 93, 23);
		getContentPane().add(btnNewButton_9);
	}

	@Override
	public void run() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void leadercheck0() {
		boolean flag = true;
		ArrayList<Worker> wlist = dao2.WorkerList(room_seq);
		HashMap<String, Integer> resultList = new HashMap<>();
		for (int i = 0; i < wlist.size(); i++) {
			if (resultList.get(wlist.get(i).getLeader()) == null) {
				resultList.put(wlist.get(i).getLeader(), 1);
			}
			if (resultList.get(wlist.get(i).getLeader()) != 0) {
				resultList.put(wlist.get(i).getLeader(), resultList.get(wlist.get(i).getLeader()) + 1);
			}
		}
		// 해시맵에서 가장 값이 큰 사람을 리절트 리더에 고유번호 저장
		String resultLeader = "0";
		int high = 0;
		for (Entry<String, Integer> m : resultList.entrySet()) {
			if (m.getValue() > high) {
				high = m.getValue();
				resultLeader = m.getKey();
			}
		}
		
		Room room = rdao.RoomFinder(room_seq);

		if (room.getLeader().equals("0")) {
			flag = false;
			
		}

		for (Entry<String, Integer> m : resultList.entrySet()) {
			if (m.getKey().equals("0")) {
				flag = false;
				
			}
		}
		if (flag) {
			room.setLeader(resultLeader);
			String roomLeaderName = null;
			for (int i = 0; i < wlist.size(); i++) {
				if (wlist.get(i).getWorker_seq().equals(resultLeader)) {
					roomLeaderName = wlist.get(i).getName();
					rdao.leadUpdate(resultLeader,room_seq);
				}

			}
		}
	}
	
	public void leadercheck() {
		boolean flag = true;
		ArrayList<Worker> wlist = dao2.WorkerList(room_seq);
		HashMap<String, Integer> resultList = new HashMap<>();
		for (int i = 0; i < wlist.size(); i++) {
			if (resultList.get(wlist.get(i).getLeader()) == null) {
				resultList.put(wlist.get(i).getLeader(), 1);
			}
			if (resultList.get(wlist.get(i).getLeader()) != 0) {
				resultList.put(wlist.get(i).getLeader(), resultList.get(wlist.get(i).getLeader()) + 1);
			}
		}
		// 해시맵에서 가장 값이 큰 사람을 리절트 리더에 고유번호 저장
		String resultLeader = "0";
		int high = 0;
		for (Entry<String, Integer> m : resultList.entrySet()) {
			if (m.getValue() > high) {
				high = m.getValue();
				resultLeader = m.getKey();
			}
		}
		
		Room room = rdao.RoomFinder(room_seq);

		if (room.getLeader().equals("0")) {
			flag = false;
			JOptionPane.showMessageDialog(this, "아직 팀장이 선택되지 않았습니다.");
		}

		for (Entry<String, Integer> m : resultList.entrySet()) {
			if (m.getKey().equals("0")) {
				flag = false;
				JOptionPane.showMessageDialog(this, "아직 투표하지 않은 팀원이 있습니다.");
			}
		}
		if (flag) {
			room.setLeader(resultLeader);
			String roomLeaderName = null;
			for (int i = 0; i < wlist.size(); i++) {
				if (wlist.get(i).getWorker_seq().equals(resultLeader)) {
					roomLeaderName = wlist.get(i).getName();
					rdao.leadUpdate(resultLeader,room_seq);
				}

			}
			JOptionPane.showMessageDialog(this, "팀장 : " + roomLeaderName);
		}
	}
	/*
	 * public void refreshWorkTable() { String columnNames[] = { "업무명", "업무 진행도" };
	 * workList = dao1.WorkList(room_seq); Object rowData[][] = new
	 * Object[workList.size()][2]; for (int i = 0; i < workList.size(); i++) {
	 * rowData[i][0] = workList.get(i).getWork_name(); rowData[i][1] =
	 * workList.get(i).getProgress(); } DefaultTableModel dtm = new
	 * DefaultTableModel(rowData, columnNames); jtable.setModel(dtm); }
	 * 
	 * public void refreshWorkerTable() { workerTable(); }
	 */
}
