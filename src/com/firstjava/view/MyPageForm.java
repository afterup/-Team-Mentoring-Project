package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.firstjava.model.vo.MemberVO;

public class MyPageForm extends JFrame implements ActionListener {
	public JButton bt_my, bt_mentor_request, bt_menti_request, bt_mypage, bt_drop_id;

	public JPanel panel_my_page;// 레이아웃 기준
	public JPanel panel_my_data, panel_mentorRequest, panel_mentiRequest;// 카드
	CardLayout card;

	//mydata Component
	public JButton bt_submit, bt_reset;
	public JTextField tf_id, tf_name, tf_phone1, tf_phone2, tf_phone3, tf_addr;
	public JComboBox<String> cb_job;
	public JLabel la_my_data ,la_id, la_name, la_phone, la_addr, la_job;

	//mentorRequest Component
	public JButton bt_mentor_search, bt_mentor_select, bt_mentor_request_cancel, bt_mentor_renew;
	public JComboBox<String> cb_mentor_category;
	JLabel la_mentorRequest, la_mentor_category;
	JTable table_mentor;
	JScrollPane scroll_table_mentor;

	//mentiRequest Component
	public JButton bt_menti_search, bt_menti_select, bt_menti_request_cancel, bt_menti_renew;
	public JComboBox<String> cb_menti_category;
	JLabel la_mentiRequest, la_menti_category;
	JTable table_menti;
	JScrollPane scroll_table_menti;

	public MyPageForm() {
		setTitle("마이 페이지");
		
		bt_my = new JButton("내 정보");
		bt_my.setBounds(20, 100, 110, 50);

		bt_mentor_request = new JButton("멘토 신청 현황");
		bt_mentor_request.setBounds(150, 100, 130, 50);

		bt_menti_request = new JButton("멘티 신청 현황");
		bt_menti_request.setBounds(300, 100, 130, 50);

		bt_mypage = new JButton("MyPage");
		bt_mypage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bt_mypage.setBounds(580, 30, 100, 40);
		bt_mypage.setForeground(Color.blue);
		bt_mypage.getBackground();
		bt_mypage.setBackground(Color.white);
		bt_mypage.setOpaque(false);
		bt_mypage.setBorderPainted(false);

		bt_drop_id = new JButton("탈퇴");
		bt_drop_id.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bt_drop_id.setBounds(670, 30, 100, 40);
		bt_drop_id.setForeground(Color.red);
		bt_drop_id.getBackground();
		bt_drop_id.setBackground(Color.white);
		bt_drop_id.setOpaque(false);
		bt_drop_id.setBorderPainted(false);

		getContentPane().setLayout(null);
		getContentPane().add(bt_drop_id);
		getContentPane().add(bt_mypage);
		getContentPane().add(bt_my);
		getContentPane().add(bt_mentor_request);
		getContentPane().add(bt_menti_request);

		// ==================================MYDATA FRAME========================================
		panel_my_data = new JPanel(); // new
		panel_my_data.setBounds(0, 162, 782, 500);
		bt_reset = new JButton("비밀번호 변경");
		bt_reset.setBounds(200, 360, 130, 25);
		bt_submit = new JButton("정보 수정");
		bt_submit.setBounds(60, 360, 120, 25);

		tf_id = new JTextField();
		tf_id.setBounds(100, 80, 100, 25);
		tf_name = new JTextField();
		tf_name.setBounds(100, 120, 100, 25);
		tf_phone1 = new JTextField();
		tf_phone1.setBounds(100, 160, 40, 25);
		tf_phone2 = new JTextField();
		tf_phone2.setBounds(150, 160, 40, 25);
		tf_phone3 = new JTextField();
		tf_phone3.setBounds(200, 160, 40, 25);
		tf_addr = new JTextField();
		tf_addr.setBounds(100, 200, 200, 25);

		la_my_data = new JLabel("내 정보");
		la_my_data.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		la_my_data.setBounds(30, 15, 150, 40);
		la_id = new JLabel("ID :");
		la_id.setBounds(30, 80, 50, 25);
		la_name = new JLabel("이름 :");
		la_name.setBounds(30, 120, 80, 25);
		la_phone = new JLabel("전화번호 :");
		la_phone.setBounds(30, 160, 80, 25);
		la_addr = new JLabel("주소 :");
		la_addr.setBounds(30, 200, 80, 25);
		la_job = new JLabel("카테고리 :");
		la_job.setBounds(30, 240, 80, 25);

		String[] job = { "멘토", "멘티" };
		cb_job = new JComboBox<String>(job);
		cb_job.setBounds(100, 240, 80, 25);
		
		panel_my_data.setLayout(null);
		panel_my_data.add(bt_reset);
		panel_my_data.add(bt_submit);
		panel_my_data.add(tf_id);
		panel_my_data.add(tf_name);
		panel_my_data.add(tf_phone1);
		panel_my_data.add(tf_phone2);
		panel_my_data.add(tf_phone3);
		panel_my_data.add(tf_addr);
		panel_my_data.add(cb_job);
		panel_my_data.add(la_my_data);
		panel_my_data.add(la_id);
		panel_my_data.add(la_name);
		panel_my_data.add(la_phone);
		panel_my_data.add(la_addr);
		panel_my_data.add(la_job);
		panel_my_data.add(cb_job);
		// ==================================/MYDATE FRAME======================================
		

		// ==================================MENTOR FRMAE=======================================
		panel_mentorRequest = new JPanel();
		panel_mentorRequest.setBounds(0, 162, 770, 500);
		
		la_mentorRequest = new JLabel("멘토 현황");
		la_mentorRequest.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		la_mentorRequest.setBounds(55, 15, 150, 40);

		la_mentor_category = new JLabel("카테고리");
		la_mentor_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		la_mentor_category.setBounds(310, 15, 150, 40);

		bt_mentor_search = new JButton("검색");
		bt_mentor_search.setBounds(560, 15, 60, 40);

		bt_mentor_select = new JButton("전체 조회");
		bt_mentor_select.setBounds(630, 15, 95, 40);

		bt_mentor_request_cancel = new JButton("신청 취소");
		bt_mentor_request_cancel.setBounds(515, 390, 100, 40);

		bt_mentor_renew = new JButton("갱신");
		bt_mentor_renew.setBounds(625, 390, 100, 40);

		String[] categoryTitle_mentor = { "IT", "디자인", "뷰티", "외국어", "음악", "라이프" };
		cb_mentor_category = new JComboBox<String>(categoryTitle_mentor);
		cb_mentor_category.setBounds(400, 15, 150, 40);

		String[] columnTitle_mentor = { "No.", "Name", "ID" };
		Object[][] rowData_mentor = new Object[0][3];
		DefaultTableModel dtm_mentor = new DefaultTableModel(rowData_mentor, columnTitle_mentor);

		table_mentor = new JTable(dtm_mentor) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll_table_mentor = new JScrollPane(table_mentor);
		scroll_table_mentor.setBounds(50, 75, 675, 287);
		table_mentor.setRowHeight(30);

		panel_mentorRequest.setLayout(null);
		panel_mentorRequest.add(la_mentorRequest);
		panel_mentorRequest.add(la_mentor_category);
		panel_mentorRequest.add(bt_mentor_search);
		panel_mentorRequest.add(bt_mentor_select);
		panel_mentorRequest.add(bt_mentor_request_cancel);
		panel_mentorRequest.add(bt_mentor_renew);
		panel_mentorRequest.add(cb_mentor_category);
		panel_mentorRequest.add(scroll_table_mentor);
		// ==================================/MENTOR FRAME==========================================
		

		// ==================================MENTI FRAME============================================
		panel_mentiRequest = new JPanel(); // new
		panel_mentiRequest.setBounds(0, 162, 770, 500);
		
		la_mentiRequest = new JLabel("멘티 현황");
		la_mentiRequest.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		la_mentiRequest.setBounds(55, 15, 150, 40);

		la_menti_category = new JLabel("카테고리");
		la_menti_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		la_menti_category.setBounds(310, 15, 150, 40);

		bt_menti_search = new JButton("검색");
		bt_menti_search.setBounds(560, 15, 60, 40);

		bt_menti_select = new JButton("전체 조회");
		bt_menti_select.setBounds(630, 15, 95, 40);

		bt_menti_request_cancel = new JButton("신청 취소");
		bt_menti_request_cancel.setBounds(515, 390, 100, 40);

		bt_menti_renew = new JButton("갱신");
		bt_menti_renew.setBounds(625, 390, 100, 40);

		String[] categoryTitle_menti = { "IT", "디자인", "뷰티", "외국어", "음악", "라이프" };
		cb_menti_category = new JComboBox<String>(categoryTitle_menti);
		cb_menti_category.setBounds(400, 15, 150, 40);

		String[] columnTitle_menti = { "No.", "Name", "ID" };
		Object[][] rowData_menti = new Object[0][3];
		DefaultTableModel dtm_menti = new DefaultTableModel(rowData_menti, columnTitle_menti);

		table_menti = new JTable(dtm_menti) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll_table_menti = new JScrollPane(table_menti);
		scroll_table_menti.setBounds(50, 75, 675, 287);
		table_menti.setRowHeight(30);

		panel_mentiRequest.setLayout(null);
		panel_mentiRequest.add(la_mentiRequest);
		panel_mentiRequest.add(la_menti_category);
		panel_mentiRequest.add(bt_menti_search);
		panel_mentiRequest.add(bt_menti_select);
		panel_mentiRequest.add(bt_menti_request_cancel);
		panel_mentiRequest.add(bt_menti_renew);
		panel_mentiRequest.add(cb_menti_category);
		panel_mentiRequest.add(scroll_table_menti);
		// ==================================/MENTi FRAME==========================================

		

		//카드 레이아웃
		card = new CardLayout();
		panel_my_page = new JPanel();
		panel_my_page.setBounds(0, 180, 800, 500);

		panel_my_page.setLayout(card);// 카드레이아웃
		panel_my_page.add(panel_my_data, "my"); // 카드붙이기
		panel_my_page.add(panel_mentorRequest, "mentor"); // 카드붙이기
		panel_my_page.add(panel_mentiRequest, "menti"); // 카드붙이기

		getContentPane().add(panel_my_page);

		setBounds(450, 170, 800, 700);
		setVisible(false);
		setResizable(false);

		bt_my.addActionListener(this);
		bt_mentor_request.addActionListener(this);
		bt_menti_request.addActionListener(this);
	}
	
	public void showInfo(ArrayList<MemberVO> list)
	{
		
		for (int i = 0; i < list.size(); i++) {
			MemberVO mVO = list.get(i);
			tf_id.setText(mVO.getUserId());
//			tf_name.setText(mVO.getUname());
//			tf_email.setText(mVO.getEmail());
//			tf_phone.setText(mVO.getPhone());
			

		}
	}// displayTable

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == bt_my) {
			card.show(panel_my_page, "my");
		} else if (ob == bt_mentor_request) {
			card.show(panel_my_page, "mentor");
		} else if (ob == bt_menti_request) {
			card.show(panel_my_page, "menti");
		}

	}// actionperformed

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageForm frame = new MyPageForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
