package com.firstjava.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;

public class MentorRegForm extends JFrame {

	private JTextField tf_academy, tf_major, tf_certification ; 
	JLabel la_passImage, la_background, la_idImage;
	public JLabel la_academy, la_major, la_certification;
	public JButton bt_findID, bt_cancel;
	public JLabel la_idPassSearch;
	private JLabel la_mento;
	private JLabel lblNewLabel;

	public MentorRegForm() {
		
		setTitle("멘토신청");
		
		la_academy = new JLabel("학교/직장명: ");
		la_academy.setForeground(Color.white);
		la_academy.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		//la_idImage.setIcon(new ImageIcon("image/User_Login.PNG"));
		la_academy.setBounds(25, 136, 100, 40);
		
		la_major = new JLabel("전공/부서명: ");
		la_major.setForeground(Color.white);
		la_major.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		//la_passImage.setIcon(new ImageIcon("image/Pw_Login.PNG"));
		la_major.setBounds(25, 196, 100, 40);
		
		la_certification = new JLabel("자격증(선택): ");
		la_certification.setForeground(Color.white);
		la_certification.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		//la_passImage.setIcon(new ImageIcon("image/Pw_Login.PNG"));
		la_certification.setBounds(25, 256, 100, 40);

		tf_academy = new JTextField();
		tf_academy.setBounds(120, 136, 180, 41);
		tf_academy.setColumns(10);

		tf_major = new JTextField();
		tf_major.setColumns(10);
		tf_major.setBounds(120, 196, 180, 41);
		
		tf_certification = new JTextField();
		tf_certification.setColumns(10);
		tf_certification.setBounds(120, 256, 180, 41);
		

		bt_findID = new JButton("신청");
		bt_findID.setForeground(Color.white);
		bt_findID.setBackground(new Color(140, 143, 143));
		bt_findID.setFont(new Font("맑은 고딕", Font.BOLD,13));
		bt_findID.setBounds(189, 501, 100, 40);

		bt_cancel = new JButton("취소");
		bt_cancel.setForeground(Color.WHITE);
		bt_cancel.setBackground(new Color(140, 143, 143));
		bt_cancel.setFont(new Font("맑은 고딕", Font.BOLD,13));
		bt_cancel.setBounds(339, 501, 100, 40);

		getContentPane().add(la_academy);
		getContentPane().add(la_major);
		getContentPane().add(la_certification);
		
		getContentPane().add(tf_academy);
		getContentPane().add(tf_major);
		getContentPane().add(tf_certification);
		
		getContentPane().add(bt_findID);
		getContentPane().add(bt_cancel);
		
		la_mento = new JLabel("멘토 신청");
		la_mento.setForeground(Color.WHITE);
		la_mento.setFont(new Font("나눔바른고딕 Light", Font.BOLD, 22));
		la_mento.setBounds(242, 56, 148, 40);
		getContentPane().add(la_mento);
		
		lblNewLabel = new JLabel("강의계획:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("나눔바른고딕 UltraLight", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 310, 62, 18);
		getContentPane().add(lblNewLabel);
		
		setBounds(1280, 170, 600, 600);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 308, 430, 180);
		getContentPane().add(textArea);
		
				la_background = new JLabel("");
				la_background.setIcon(new ImageIcon("image/background_800.jpg"));
				la_background.setBounds(0, 0, 582, 561);
				getContentPane().add(la_background);
		setVisible(false);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MentorRegForm frame = new MentorRegForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}