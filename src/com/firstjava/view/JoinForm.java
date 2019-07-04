package com.firstjava.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class JoinForm extends JFrame {

	public JTextField tf_id, tf_name, tf_phone1, tf_phone2, tf_phone3, tf_email;
	public JPasswordField tf_pass, tf_pass2;
	public JButton bt_submit, bt_cancel;
	JLabel la_ID, la_pass, la_passCheck, la_name, la_phone, la_email;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNewLabel_1;
	public JLabel la_checkid;

	public JoinForm() {
		//비밀번호는 영문자, 숫자, 특수문자(!@#$%^&)의 조합 8~12자로 설정해주세요.
		setTitle("회원가입");

		tf_id = new JTextField();
		tf_name = new JTextField();
		tf_phone1 = new JTextField();
		tf_phone2 = new JTextField();
		tf_phone3 = new JTextField();
		tf_email = new JTextField();

		tf_pass = new JPasswordField();
		tf_pass2 = new JPasswordField();

		bt_submit = new JButton("등록");
		bt_submit.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		bt_submit.setForeground(new Color(211, 211, 211));
		bt_submit.setBackground(new Color(140, 143, 143));
		
		bt_cancel = new JButton("취소");
		bt_cancel.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		bt_cancel.setForeground(new Color(211, 211, 211));
		bt_cancel.setBackground(new Color(140, 143, 143));
		bt_cancel.setBackground(new Color(140, 143, 143));	

		// ---------------------컴포넌트 바운즈--------------------------
		tf_id.setBounds(117, 223, 100, 25);
		tf_pass.setBounds(117, 263, 100, 25);
		tf_pass2.setBounds(117, 303, 100, 25);
		tf_name.setBounds(117, 343, 100, 25);

		tf_phone1.setBounds(117, 380, 40, 25);
		tf_phone2.setBounds(167, 380, 40, 25);
		tf_phone3.setBounds(217, 380, 40, 25);

		tf_email.setBounds(117, 420, 200, 25);

		bt_submit.setBounds(74, 499, 90, 34);
		bt_cancel.setBounds(174, 499, 90, 34);
		// -----------------------------------------------------------
		getContentPane().setLayout(null);

		getContentPane().add(tf_id);
		getContentPane().add(tf_pass);
		getContentPane().add(tf_pass2);
		getContentPane().add(tf_name);
		getContentPane().add(tf_phone1);
		getContentPane().add(tf_phone2);
		getContentPane().add(tf_phone3);
		getContentPane().add(tf_email);

		getContentPane().add(bt_submit);
		getContentPane().add(bt_cancel);

		la_ID = new JLabel("아이디 :");
		la_ID.setForeground(Color.WHITE);
		la_ID.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		la_ID.setBounds(30, 223, 90, 15);
		getContentPane().add(la_ID);

		la_pass = new JLabel("비밀번호 :");
		la_pass.setForeground(Color.WHITE);
		la_pass.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		la_pass.setBounds(30, 265, 90, 15);
		getContentPane().add(la_pass);

		la_passCheck = new JLabel("비번확인 :");
		la_passCheck.setForeground(Color.WHITE);
		la_passCheck.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		la_passCheck.setBounds(30, 305, 90, 15);
		getContentPane().add(la_passCheck);

		la_name = new JLabel("이 름 :");
		la_name.setForeground(Color.WHITE);
		la_name.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		la_name.setBounds(30, 345, 90, 15);
		getContentPane().add(la_name);

		la_phone = new JLabel("휴대번호 :");
		la_phone.setForeground(Color.WHITE);
		la_phone.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		la_phone.setBounds(30, 382, 90, 15);
		getContentPane().add(la_phone);

		la_email = new JLabel("이메일주소 :");
		la_email.setForeground(Color.WHITE);
		la_email.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		la_email.setBounds(30, 422, 90, 15);
		getContentPane().add(la_email);

		JLabel la_join = new JLabel("회 원 가 입");
		la_join.setForeground(Color.WHITE);
		la_join.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 20));
		la_join.setBounds(117, 96, 108, 41);
		getContentPane().add(la_join);

		lblNewLabel = new JLabel("-");
		lblNewLabel.setBounds(157, 384, 8, 18);
		getContentPane().add(lblNewLabel);

		label = new JLabel("-");
		label.setBounds(207, 383, 8, 18);
		getContentPane().add(label);
		
		la_checkid = new JLabel();
		la_checkid.setFont(new Font("나눔바른고딕 UltraLight", Font.PLAIN, 16));
		la_checkid.setForeground(new Color(255, 192, 203));
		la_checkid.setBounds(231, 226, 111, 18);
		getContentPane().add(la_checkid);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image/background_800.jpg"));
		lblNewLabel_1.setBounds(0, 0, 342, 553);
		getContentPane().add(lblNewLabel_1);
		

		setVisible(false);
		setBounds(1280, 170, 360, 600);

	}
	

	// tf_id, tf_name, tf_ssn1, tf_phone1, tf_phone2, tf_phone3, tf_email
	public void initText() {
		tf_id.setText("");
		tf_pass.setText("");
		tf_pass2.setText("");
		tf_name.setText("");
		tf_phone1.setText("");
		tf_phone2.setText("");
		tf_phone3.setText("");
		tf_email.setText("");
		tf_id.requestFocus();

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinForm frame = new JoinForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}