package com.firstjava.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class LoginForm extends JFrame {

	public JTextField tf_id;
	public JPasswordField tf_pass;
	JLabel la_passImage, la_background, la_idImage, la_logoimage;
	public JLabel la_join;
	public JLabel la_idPassSearch;
	public JButton bt_login,bt_cancel;

	public LoginForm() {
		
		setTitle("로그인");

		tf_id = new JTextField();
		tf_id.setBounds(90, 267, 200, 41);
		tf_id.setColumns(10);

		tf_pass = new JPasswordField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(90, 327, 200, 41);

		la_idImage = new JLabel("");
		la_idImage.setLabelFor(tf_id);
		la_idImage.setIcon(new ImageIcon("image/User_Login.PNG"));
		la_idImage.setBounds(38, 267, 60, 40);

		la_passImage = new JLabel("");
		la_passImage.setIcon(new ImageIcon("image/Pw_Login.PNG"));
		la_passImage.setBounds(38, 327, 60, 40);

		bt_login = new JButton("로그인");
		bt_login.setForeground(new Color(211, 211, 211));
		bt_login.setBackground(new Color(140, 143, 143));
		bt_login.setFont(new Font("맑은 고딕", Font.PLAIN, 18));

		bt_login.setBounds(38, 407, 120, 35);

		la_join = new JLabel("회원가입");
		la_join.setForeground(SystemColor.activeCaption);
		la_join.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		la_join.setBounds(123, 452, 76, 32);

		la_idPassSearch = new JLabel("아이디/비밀번호 찾기");
		la_idPassSearch.setForeground(SystemColor.menu);
		la_idPassSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		la_idPassSearch.setBounds(85, 496, 178, 32);

		la_logoimage = new JLabel("");
		la_logoimage.setIcon(new ImageIcon("image/logo_42.png"));
		la_logoimage.setBounds(85, 30, 170, 180);

		la_background = new JLabel("");
		la_background.setIcon(new ImageIcon("image/background_800.jpg"));
		la_background.setBounds(0, 0, 344, 561);

		getContentPane().add(tf_id);
		getContentPane().add(tf_pass);
		getContentPane().add(la_idImage);
		getContentPane().add(bt_login);
		getContentPane().add(la_join);
		getContentPane().add(la_idPassSearch);
		getContentPane().add(la_passImage);
		getContentPane().add(la_logoimage);
		
		bt_cancel = new JButton("취소");
		bt_cancel.setForeground(new Color(211, 211, 211));
		bt_cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		bt_cancel.setBackground(new Color(140, 143, 143));
		bt_cancel.setBounds(170, 407, 120, 35);
		getContentPane().add(bt_cancel);
		getContentPane().add(la_background);
		
		setBounds(1280, 170, 360, 600);
		getContentPane().setLayout(null);
		setVisible(false);

	}
	
	public void initText() {
		tf_id.setText("");
		tf_pass.setText("");
	}//initText
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}