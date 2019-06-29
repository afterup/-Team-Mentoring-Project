package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.firstjava.model.vo.ClassVO;
import java.awt.SystemColor;

public class MainForm extends JFrame {
	public JTextField tf_admin;
	public JLabel la_user_id;
	public JPasswordField tf_pass;
	public JButton bt_login, bt_mypage, bt_mento_demand, bt_main, bt_mento_class;
	public JPanel panel_lecture;// 카드레이아웃 기준
	public JPanel panel_main, panel_mentor; // 카드
	public JTextArea ta_desc;
	public boolean authState;
	public CardLayout card;

	// MentorForm Component
	public JButton bt_search, bt_select, bt_create_class, bt_manager;
	public JComboBox<String> cb_category;
	public JTable table;
	JScrollPane scroll_table;
	JLabel la_category;

	DefaultTableModel dtm;
	private JLabel lblNewLabel;
	private JLabel la_logo2;
	private JLabel la_pagemento;

	public MainForm() {
		setTitle("main Form");
		card = new CardLayout();
		panel_lecture = new JPanel();
		panel_lecture.setLayout(card);
		
		String[] categoryTitle = { "JAVA", "HTML", "뷰티", "외국어", "음악", "라이프" };
		cb_category = new JComboBox<String>(categoryTitle);
		cb_category.setBounds(125, 523, 80, 30);

		// 컬럼명 설정

		String[] columnTitle = { "NO", "분류", "강의명", "개강일", "종강일" };
		Object[][] rowData = new Object[0][6];
		dtm = new DefaultTableModel(rowData, columnTitle);
		
		//폰트 설정
		Font font16 = new Font("나눔바른고딕 UltraLight",Font.BOLD, 16);

		// ------------------MAINFORM------------------------
		panel_main = new JPanel();

		// ---------------------------------------------------

		// 카드 붙이기
		panel_lecture.add(panel_main, "1");// "empty"별명
		panel_main.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("imagelogo_black.png"));
		lblNewLabel_1.setBounds(266, 25, 199, 170);
		panel_main.add(lblNewLabel_1);

		bt_manager = new JButton("관리자(임시)");
		bt_manager.setBounds(604, 520, 120, 34);
		panel_main.add(bt_manager);

		// panel_lecture.setBackground(Color.green); //메인에서의 영역확인
		panel_lecture.setBounds(25, 80, 736, 564);
		// 전체 setBounds(450,170,800,700);

		bt_main = new JButton("메인");
		bt_main.setForeground(Color.WHITE);
		bt_main.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		bt_main.setBackground(Color.white);
		bt_main.setOpaque(false);
		bt_main.setBorderPainted(false);
		bt_main.setBounds(314, 30, 74, 40);

		bt_mento_class = new JButton("멘토강의");
		bt_mento_class.setForeground(Color.WHITE);
		bt_mento_class.setFont(font16);
		bt_mento_class.setBackground(Color.white);
		bt_mento_class.setOpaque(false);
		bt_mento_class.setBorderPainted(false);
		bt_mento_class.setBounds(386, 30, 100, 40);

		bt_login = new JButton("로그인");
		bt_login.setFont(font16);
		bt_login.setForeground(new Color(65, 105, 225));
		bt_login.getBackground();
		bt_login.setBounds(672, 30, 89, 40);
		bt_login.setBackground(Color.white);
		bt_login.setOpaque(false);
		bt_login.setBorderPainted(false);

		bt_mypage = new JButton("MyPage");
		bt_mypage.setForeground(Color.WHITE);
		bt_mypage.setFont(font16);
		bt_mypage.setBounds(580, 30, 100, 40);
		bt_mypage.setBackground(Color.white);
		bt_mypage.setOpaque(false);
		bt_mypage.setBorderPainted(false);

		bt_mento_demand = new JButton("멘토신청");
		bt_mento_demand.setForeground(Color.WHITE);
		bt_mento_demand.setFont(font16);
		bt_mento_demand.setBounds(484, 30, 100, 40);
		bt_mento_demand.setBackground(Color.white);
		bt_mento_demand.setOpaque(false);
		bt_mento_demand.setBorderPainted(false);

		la_user_id = new JLabel("Welcome!");
		la_user_id.setForeground(Color.WHITE);
		la_user_id.setBounds(40, 44, 105, 28);

		tf_admin = new JTextField("관리자");
		tf_admin.setBounds(192, 42, 74, 28);

		getContentPane().setLayout(null);
		getContentPane().add(bt_main);
		getContentPane().add(bt_mento_class);
		getContentPane().add(bt_login);
		getContentPane().add(bt_mypage);
		getContentPane().add(bt_mento_demand);
		getContentPane().add(la_user_id);
		getContentPane().add(tf_admin);
		getContentPane().add(panel_lecture);
		panel_mentor = new JPanel();
		panel_lecture.add(panel_mentor, "name_64479852722351");

		// ----------------MENTOR FRAME------------

		bt_search = new JButton("검색");
		bt_search.setBounds(223, 524, 61, 30);

		bt_select = new JButton("전체 조회");
		bt_select.setBounds(296, 524, 93, 30);

		bt_create_class = new JButton("강의 개설");
		bt_create_class.setBounds(613, 524, 90, 30);

		la_category = new JLabel("카테고리");
		la_category.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		la_category.setBounds(50, 523, 68, 24);

		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// 컬럼 크기 설정
		table.getColumn("NO").setPreferredWidth(20);
		table.getColumn("분류").setPreferredWidth(50);
		table.getColumn("강의명").setPreferredWidth(280);
		table.getColumn("개강일").setPreferredWidth(25);
		table.getColumn("종강일").setPreferredWidth(25);

		table.setRowHeight(30);
		scroll_table = new JScrollPane(table);
		scroll_table.setBounds(50, 202, 653, 312);
		panel_mentor.setLayout(null);

		panel_mentor.add(bt_search);
		panel_mentor.add(bt_select);
		panel_mentor.add(bt_create_class);
		panel_mentor.add(la_category);
		panel_mentor.add(cb_category);
		panel_mentor.add(scroll_table);

		la_logo2 = new JLabel("");
		la_logo2.setIcon(new ImageIcon("image/logo_blacksmall.png"));
		la_logo2.setBounds(43, 22, 132, 142);
		panel_mentor.add(la_logo2);

		la_pagemento = new JLabel("멘토 강의");
		la_pagemento.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 20));
		la_pagemento.setBounds(187, 75, 102, 44);
		panel_mentor.add(la_pagemento);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/background_800.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 661);
		getContentPane().add(lblNewLabel);

		setBounds(450, 170, 800, 700);
		setVisible(true);
		// setResizable(false);

	}// 생성자

	public void displayTable(ArrayList<ClassVO> list) {

		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ClassVO vo = list.get(i);
			Object[] rowData = { vo.getClassno(), vo.getCname(), vo.getClassinfo(), vo.getOpenDate(),
					vo.getCloseDate() };
			dtm.addRow(rowData);

		}

	}// displayTable

	// MSGBOX

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg

	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this, msg);
	}// showInput

	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}// showConfirm

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}