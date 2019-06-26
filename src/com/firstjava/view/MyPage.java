package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyPage extends JFrame {
	public JButton bt_my, bt_mentor_request, bt_menti_request, bt_mypage, bt_drop_id, bt_submit, bt_reset;
	public JTextField tf_id, tf_name, tf_phone1, tf_phone2, tf_phone3, tf_addr;
	public JPasswordField tf_pass, tf_pass2;
	public JComboBox<String> cb_job;
	JLabel[] label;

	public MyPage() {
		setTitle("마이 페이지");
		bt_my = new JButton("내 정보");

		bt_mentor_request = new JButton("멘토 신청 현황");

		bt_menti_request = new JButton("멘티 신청 현황");

		bt_mypage = new JButton("MyPage");
		bt_mypage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bt_mypage.setForeground(Color.blue);
		bt_mypage.getBackground();
		bt_mypage.setBackground(Color.white);
		bt_mypage.setOpaque(false);
		bt_mypage.setBorderPainted(false);

		bt_drop_id = new JButton("탈퇴");
		bt_drop_id.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bt_drop_id.setForeground(Color.red);
		bt_drop_id.getBackground();
		bt_drop_id.setBackground(Color.white);
		bt_drop_id.setOpaque(false);
		bt_drop_id.setBorderPainted(false);

		tf_id = new JTextField();
		tf_name = new JTextField();
		tf_phone1 = new JTextField();
		tf_phone2 = new JTextField();
		tf_phone3 = new JTextField();
		tf_addr = new JTextField();

		tf_pass = new JPasswordField();
		tf_pass2 = new JPasswordField();

		bt_submit = new JButton("정보 수정");
		bt_reset = new JButton("비밀번호 변경");

		String[] job = { "멘토", "멘티" };

		cb_job = new JComboBox<String>(job);

		// ----------------------JLabel생성-------------------------------------
		String[] labelTitle = { "I  D", "비  번", "비번확인", "이  름", "전화번호", "주  소", "직  업", "-", "-", "-" };
		label = new JLabel[labelTitle.length];

		for (int i = 0; i < labelTitle.length; i++) {
			if (i < 7)
				label[i] = new JLabel(labelTitle[i] + ":");
			else
				label[i] = new JLabel(labelTitle[i]);
		}

		// ---------------------컴포넌트 바운즈--------------------------
		tf_id.setBounds(100, 210, 100, 25);
		tf_pass.setBounds(100, 250, 100, 25);
		tf_pass2.setBounds(100, 290, 100, 25);
		tf_name.setBounds(100, 330, 100, 25);

		label[7].setBounds(131, 170, 8, 25);

		tf_phone1.setBounds(100, 370, 40, 25);
		label[8].setBounds(121, 230, 8, 25);
		tf_phone2.setBounds(150, 370, 40, 25);
		label[9].setBounds(171, 230, 8, 25);
		tf_phone3.setBounds(200, 370, 40, 25);

		tf_addr.setBounds(100, 410, 200, 25);
		cb_job.setBounds(100, 450, 100, 25);
		
		bt_my.setBounds(20, 100, 110, 50);
		bt_mentor_request.setBounds(150, 100, 130, 50);
		bt_menti_request.setBounds(300, 100, 130, 50);
		bt_mypage.setBounds(580, 30, 100, 40);
		bt_drop_id.setBounds(670, 30, 100, 40);
		bt_submit.setBounds(30, 520, 100, 25);
		bt_reset.setBounds(150, 520, 120, 25);
		// -----------------------------------------------------------
		setLayout(null);

		int y = 210;
		for (int i = 0; i < label.length - 3; i++) {
			label[i].setBounds(30, y, 150, 25);
			add(label[i]);
			y += 40;
		}

		add(label[8]);// "-"
		add(label[9]);



		getContentPane().setLayout(null);
		getContentPane().add(bt_drop_id);
		getContentPane().add(bt_mypage);
		getContentPane().add(bt_my);
		getContentPane().add(bt_mentor_request);
		getContentPane().add(bt_menti_request);
		getContentPane().add(tf_id);
		getContentPane().add(tf_pass);
		getContentPane().add(tf_pass2);
		getContentPane().add(tf_name);
		getContentPane().add(tf_phone1);
		getContentPane().add(tf_phone2);
		getContentPane().add(tf_phone3);
		getContentPane().add(tf_addr);
		getContentPane().add(cb_job);
		getContentPane().add(bt_submit);
		getContentPane().add(bt_reset);

		setBounds(450, 170, 800, 700);
		setVisible(true);
		// setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyPage();
	}

}
