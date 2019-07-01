package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindForm extends JFrame {

	JLabel la_background, la_logoimage;
	public JButton bt_idView, bt_passView;
	public JPanel panel_main, panel_id, panel_pass;
	public CardLayout card;

	// ---ID 컴포넌트
	public JTextField tf_name, tf_email;
	private JLabel la_name, la_email;
	public JButton bt_findID, bt_cancel;

	// ---Pass 컴포넌트
	public JTextField tf_p_id, tf_p_name, tf_p_email;
	public JButton bt_p_findPass, bt_p_cancel;
	private JLabel la_p_id, la_p_name, la_p_email;
	private JLabel label;

	public FindForm() {
		setTitle("find form");
		card = new CardLayout();
		panel_main = new JPanel();
		panel_main.setSize(340, 310);
		panel_main.setLocation(0, 240);
		panel_main.setLayout(card);

		// ----ID Form --------------
		panel_id = new JPanel();

		la_name = new JLabel("이름: ");
		la_name.setForeground(Color.BLACK);
		la_name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_name.setBounds(49, 66, 39, 21);

		la_email = new JLabel("이메일: ");
		la_email.setForeground(Color.BLACK);
		la_email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_email.setBounds(49, 128, 54, 21);

		tf_name = new JTextField();
		tf_name.setBounds(136, 66, 149, 24);
		tf_name.setColumns(10);

		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(136, 128, 149, 24);

		bt_findID = new JButton("아이디찾기");
		bt_findID.setForeground(Color.white);
		bt_findID.setBackground(new Color(140, 143, 143));
		bt_findID.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_findID.setBounds(50, 242, 100, 40);

		bt_cancel = new JButton("취소");
		bt_cancel.setForeground(Color.WHITE);
		bt_cancel.setBackground(new Color(140, 143, 143));
		bt_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_cancel.setBounds(185, 242, 100, 40);
		panel_id.setLayout(null);

		panel_id.add(la_name);
		panel_id.add(la_email);
		panel_id.add(tf_name);
		panel_id.add(tf_email);
		panel_id.add(bt_findID);
		panel_id.add(bt_cancel);

		// -----Pass Form ------------
		panel_pass = new JPanel();

		la_p_id = new JLabel("아이디:");
		la_p_id.setForeground(Color.BLACK);
		la_p_id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_p_id.setBounds(49, 48, 69, 21);

		la_p_name = new JLabel("이름:");
		la_p_name.setForeground(Color.BLACK);
		la_p_name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_p_name.setBounds(49, 98, 69, 21);

		la_p_email = new JLabel("이메일: ");
		la_p_email.setForeground(Color.BLACK);
		la_p_email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_p_email.setBounds(49, 151, 54, 21);

		tf_p_id = new JTextField();
		tf_p_id.setBounds(136, 48, 149, 24);
		tf_p_id.setColumns(10);

		tf_p_name = new JTextField();
		tf_p_name.setColumns(10);
		tf_p_name.setBounds(136, 98, 149, 24);

		tf_p_email = new JTextField();
		tf_p_email.setColumns(10);
		tf_p_email.setBounds(136, 151, 149, 24);

		bt_p_findPass = new JButton("비번찾기");
		bt_p_findPass.setForeground(Color.white);
		bt_p_findPass.setBackground(new Color(140, 143, 143));
		bt_p_findPass.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_p_findPass.setBounds(50, 242, 100, 40);

		bt_p_cancel = new JButton("취소");
		bt_p_cancel.setForeground(Color.WHITE);
		bt_p_cancel.setBackground(new Color(140, 143, 143));
		bt_p_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_p_cancel.setBounds(185, 242, 100, 40);

		panel_pass.setLayout(null);

		panel_pass.add(la_p_id);
		panel_pass.add(la_p_name);
		panel_pass.add(la_p_email);
		panel_pass.add(tf_p_id);
		panel_pass.add(tf_p_name);
		panel_pass.add(tf_p_email);
		panel_pass.add(bt_p_findPass);
		panel_pass.add(bt_p_cancel);

		// ---------------------------

		panel_main.add(panel_id, "1");

		JLabel la_check = new JLabel("유효성 검사");
		la_check.setForeground(new Color(128, 0, 0));
		la_check.setBounds(122, 204, 100, 18);
		panel_id.add(la_check);
		panel_main.add(panel_pass, "2");
		panel_pass.setLayout(null);

		label = new JLabel("유효성 검사");
		label.setBounds(117, 212, 100, 18);
		panel_pass.add(label);

		setBounds(1280, 170, 360, 600);

		bt_idView = new JButton("ID 찾기");
		bt_idView.setBounds(0, 214, 105, 27);

		bt_passView = new JButton("PW 찾기");
		bt_passView.setBounds(105, 214, 105, 27);

		la_logoimage = new JLabel("");
		la_logoimage.setIcon(new ImageIcon("image/logo_42.png"));
		la_logoimage.setBounds(85, 30, 170, 180);

		la_background = new JLabel("");
		la_background.setIcon(new ImageIcon("image/background_800.jpg"));
		la_background.setBounds(0, 0, 344, 561);

		getContentPane().setLayout(null);
		getContentPane().add(bt_idView);
		getContentPane().add(bt_passView);
		getContentPane().add(panel_main);
		getContentPane().add(la_logoimage);
		getContentPane().add(la_background);

		setVisible(false);

	}

//	public static void main(String[] args)
//	{
//		EventQueue.invokeLater(new Runnable()
//		{
//			public void run()
//			{
//				try {
//					FindForm frame = new FindForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
