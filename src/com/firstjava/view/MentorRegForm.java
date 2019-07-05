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

	private JLabel la_passImage, la_background, la_idImage,la_plan,la_idPassSearch, la_job, la_major, la_license;
	public JTextField tf_job, tf_major, tf_license ; 
	public JTextArea ta_plan;
	public JButton bt_submit, bt_cancel;
	public JLabel la_mento;

	public MentorRegForm() {
		
		setTitle("멘토신청");
		
		la_job = new JLabel("학교/직장명: ");
		la_job.setForeground(Color.white);
		la_job.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		//la_idImage.setIcon(new ImageIcon("image/User_Login.PNG"));
		la_job.setBounds(25, 136, 100, 40);
		
		la_major = new JLabel("전공/부서명: ");
		la_major.setForeground(Color.white);
		la_major.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		//la_passImage.setIcon(new ImageIcon("image/Pw_Login.PNG"));
		la_major.setBounds(25, 196, 100, 40);
		
		la_license = new JLabel("자격증(선택): ");
		la_license.setForeground(Color.white);
		la_license.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
		//la_passImage.setIcon(new ImageIcon("image/Pw_Login.PNG"));
		la_license.setBounds(25, 256, 100, 40);

		tf_job = new JTextField();
		tf_job.setBounds(120, 136, 180, 41);
		tf_job.setColumns(10);

		tf_major = new JTextField();
		tf_major.setColumns(10);
		tf_major.setBounds(120, 196, 180, 41);
		
		tf_license = new JTextField();
		tf_license.setColumns(10);
		tf_license.setBounds(120, 256, 180, 41);
		

		bt_submit = new JButton("신청");
		bt_submit.setForeground(Color.white);
		bt_submit.setBackground(new Color(140, 143, 143));
		bt_submit.setFont(new Font("맑은 고딕", Font.BOLD,13));
		bt_submit.setBounds(189, 501, 100, 40);

		bt_cancel = new JButton("취소");
		bt_cancel.setForeground(Color.WHITE);
		bt_cancel.setBackground(new Color(140, 143, 143));
		bt_cancel.setFont(new Font("맑은 고딕", Font.BOLD,13));
		bt_cancel.setBounds(339, 501, 100, 40);

		getContentPane().add(la_job);
		getContentPane().add(la_major);
		getContentPane().add(la_license);
		
		getContentPane().add(tf_job);
		getContentPane().add(tf_major);
		getContentPane().add(tf_license);
		
		getContentPane().add(bt_submit);
		getContentPane().add(bt_cancel);
		
		la_mento = new JLabel("멘토 신청");
		la_mento.setForeground(Color.WHITE);
		la_mento.setFont(new Font("나눔바른고딕 Light", Font.BOLD, 22));
		la_mento.setBounds(242, 56, 148, 40);
		getContentPane().add(la_mento);
		
		la_plan = new JLabel("강의계획:");
		la_plan.setForeground(Color.WHITE);
		la_plan.setFont(new Font("나눔바른고딕 UltraLight", Font.PLAIN, 15));
		la_plan.setBounds(25, 310, 62, 18);
		getContentPane().add(la_plan);
		
		setBounds(1280, 170, 600, 600);
		getContentPane().setLayout(null);
		
		ta_plan = new JTextArea();
		ta_plan.setBounds(120, 308, 430, 180);
		getContentPane().add(ta_plan);
		
		la_background = new JLabel("");
		la_background.setIcon(new ImageIcon("image/background_800.jpg"));
		la_background.setBounds(0, 0, 582, 561);
		getContentPane().add(la_background);
		setVisible(false);

	}
	
	public void enabled() {
		tf_job.setEnabled(false);
		tf_major.setEnabled(false);
		tf_license.setEnabled(false);
		ta_plan.setEnabled(false);
		bt_submit.setVisible(false);
		
		tf_job.setDisabledTextColor(Color.BLACK); 
		tf_major.setDisabledTextColor(Color.BLACK); 
		tf_license.setDisabledTextColor(Color.BLACK); 
		ta_plan.setDisabledTextColor(Color.BLACK); 
	}
	
	public void initText() {
		tf_job.setText("");
		tf_major.setText("");
		tf_license.setText("");
		ta_plan.setText("");
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MentorRegForm frame = new MentorRegForm();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}