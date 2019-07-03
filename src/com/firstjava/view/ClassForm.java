package com.firstjava.view;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;


public class ClassForm extends JFrame {

	private JPanel contentPane;
	public JTextField tf_name, tf_student, tf_open, tf_close;
	public JComboBox jb_category;
	public JTextArea ta_desc;
	public JButton bt_new, bt_cancel; 
	private JLabel lblNewLabel;
		
	/**
	 * Create the frame.
	 */
	public ClassForm() {
		setBounds(550, 200, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setTitle("강의정보");
		
		
		//라벨
		
		JLabel label_1 = new JLabel("강의");
		label_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(50, 40, 80, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("카테고리");
		label_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(50, 80, 80, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("최대인원수");
		label_3.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(50, 120, 80, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("개강일자");
		label_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(50, 160, 80, 18);
		contentPane.add(label_4);
		
		JLabel label_4_2 = new JLabel("종강일자");
		label_4_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_4_2.setForeground(Color.WHITE);
		label_4_2.setBounds(50, 200, 80, 18);
		contentPane.add(label_4_2);
		
		JLabel label_7 = new JLabel("강의설명");
		label_7.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(50, 240, 80, 18);
		contentPane.add(label_7);
		

		//필드
		tf_name = new JTextField();
		tf_name.setBounds(150, 40, 580, 24);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		String category[] = {"IT", "디자인", "뷰티", "외국어", "음악", "라이프"};
		
		jb_category = new JComboBox(category);
		jb_category.setBounds(150, 80, 130, 24);
		contentPane.add(jb_category);
		
		tf_student = new JTextField();
		tf_student.setBounds(150, 120, 130, 24);
		contentPane.add(tf_student);
		tf_student.setColumns(10);
		
		tf_open = new JTextField();
		tf_open.setBounds(150, 160, 130, 24);
		contentPane.add(tf_open);
		tf_open.setColumns(10);
		
		tf_close = new JTextField();
		tf_close.setBounds(150, 200, 130, 24);
		contentPane.add(tf_close);
		tf_close.setColumns(10);
		
		
		ta_desc = new JTextArea();
		ta_desc.setBounds(150, 240, 580, 300);
		contentPane.add(ta_desc);
		
		
		
		//버튼
		
		bt_new = new JButton("강의신청");
		bt_new.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		bt_new.setBounds(490, 580, 105, 30);
		contentPane.add(bt_new);
		
		bt_cancel = new JButton("취소");
		bt_cancel.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		bt_cancel.setBounds(600, 580, 105, 30);
		contentPane.add(bt_cancel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/background_800.jpg"));
		lblNewLabel.setBounds(0, 0, 782, 653);
		contentPane.add(lblNewLabel);
		
		setVisible(false);
	}
	
	public void limitMember() {
		bt_new.setEnabled(false);
		bt_new.setText("마감");
	}
	
	public void rightMember() {
		bt_new.setEnabled(true);
		bt_new.setText("강의신청");
	}
	
	public void controlsetEnabled() {
		tf_name.setEnabled(false);
		tf_student.setEnabled(false); 
		tf_open.setEnabled(false);
		tf_close.setEnabled(false);
		ta_desc.setEnabled(false);
		jb_category.setEnabled(false);
		
		tf_name.setDisabledTextColor(Color.BLACK); 
		tf_student.setDisabledTextColor(Color.BLACK); 
		tf_open.setDisabledTextColor(Color.BLACK); 
		tf_close.setDisabledTextColor(Color.BLACK); 
		ta_desc.setDisabledTextColor(Color.BLACK); 
		
		setVisible(true);
	}
	
}
