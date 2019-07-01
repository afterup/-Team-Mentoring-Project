package com.firstjava.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;

public class JoinForm extends JFrame {

	public JTextField tf_id, tf_name, tf_phone1, tf_phone2, tf_phone3, tf_email;
	public JPasswordField tf_pass, tf_pass2;
	public JButton bt_submit, bt_cancel, bt_checkid;
	JLabel la_ID, la_pass, la_passCheck, la_name, la_phone, la_email, la_validCheck;
	private JLabel lblNewLabel;
	private JLabel label;

	public JoinForm() {

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
		bt_cancel = new JButton("취소");
		bt_checkid = new JButton("중복확인");

		// ---------------------컴포넌트 바운즈--------------------------
		tf_id.setBounds(117, 181, 100, 25);
		tf_pass.setBounds(117, 221, 100, 25);
		tf_pass2.setBounds(117, 261, 100, 25);
		tf_name.setBounds(117, 301, 100, 25);

		tf_phone1.setBounds(117, 338, 40, 25);
		tf_phone2.setBounds(167, 338, 40, 25);
		tf_phone3.setBounds(217, 338, 40, 25);

		tf_email.setBounds(117, 378, 200, 25);

		bt_submit.setBounds(74, 499, 90, 34);
		bt_cancel.setBounds(174, 499, 90, 34);
		bt_checkid.setBounds(227, 181, 90, 25);
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
		getContentPane().add(bt_checkid);

		la_ID = new JLabel("아이디 :");
		la_ID.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_ID.setBounds(30, 181, 90, 15);
		getContentPane().add(la_ID);

		la_pass = new JLabel("비밀번호 :");
		la_pass.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_pass.setBounds(30, 223, 90, 15);
		getContentPane().add(la_pass);

		la_passCheck = new JLabel("비번확인 :");
		la_passCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_passCheck.setBounds(30, 263, 90, 15);
		getContentPane().add(la_passCheck);

		la_name = new JLabel("이 름 :");
		la_name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_name.setBounds(30, 303, 90, 15);
		getContentPane().add(la_name);

		la_phone = new JLabel("휴대번호 :");
		la_phone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_phone.setBounds(30, 340, 90, 15);
		getContentPane().add(la_phone);

		la_email = new JLabel("이메일주소 :");
		la_email.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_email.setBounds(30, 380, 90, 15);
		getContentPane().add(la_email);

		la_validCheck = new JLabel("유효성 검사");
		la_validCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		la_validCheck.setBounds(128, 449, 100, 15);
		getContentPane().add(la_validCheck);

		JLabel la_join = new JLabel("회 원 가 입");
		la_join.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		la_join.setBounds(117, 62, 108, 41);
		getContentPane().add(la_join);

		lblNewLabel = new JLabel("-");
		lblNewLabel.setBounds(157, 342, 8, 18);
		getContentPane().add(lblNewLabel);

		label = new JLabel("-");
		label.setBounds(207, 341, 8, 18);
		getContentPane().add(label);

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