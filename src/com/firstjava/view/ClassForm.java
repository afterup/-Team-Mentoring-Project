package com.firstjava.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class ClassForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1, textField_3, textField_4, textField_4_2, textField_5;
		
	/**
	 * Create the frame.
	 */
	public ClassForm() {
		setBounds(550, 200, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setTitle("강의등록");
		
		
		//라벨
		
		JLabel label_1 = new JLabel("강의");
		label_1.setBounds(50, 40, 80, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("카테고리");
		label_2.setBounds(50, 80, 80, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("최대인원수");
		label_3.setBounds(50, 120, 80, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("개강일자");
		label_4.setBounds(50, 160, 80, 18);
		contentPane.add(label_4);
		
		JLabel label_4_2 = new JLabel("종강일자");
		label_4_2.setBounds(300, 160, 80, 18);
		contentPane.add(label_4_2);
		
		JLabel label_5 = new JLabel("장소");
		label_5.setBounds(50, 200, 80, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("강사소개");
		label_6.setBounds(50, 240, 80, 18);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("강사설명");
		label_7.setBounds(50, 360, 80, 18);
		contentPane.add(label_7);
		

		//필드
		textField_1 = new JTextField();
		textField_1.setBounds(150, 40, 580, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String category[] = {"프로그래밍", "영어", "뷰티"};
		
		JComboBox comboBox = new JComboBox(category);
		comboBox.setBounds(150, 80, 130, 24);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 120, 130, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 160, 130, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_4_2 = new JTextField();
		textField_4_2.setBounds(380, 160, 130, 24);
		contentPane.add(textField_4_2);
		textField_4_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(150, 200, 130, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(150, 240, 580, 100);
		contentPane.add(textArea1);
		
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(150, 360, 580, 180);
		contentPane.add(textArea2);
		
		
		
		//버튼
		
		JButton btnNewButton = new JButton("신청");
		btnNewButton.setBounds(120, 580, 105, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setBounds(280, 580, 105, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");                                            
		btnNewButton_2.setBounds(440, 580, 105, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("취소");
		btnNewButton_3.setBounds(600, 580, 105, 30);
		contentPane.add(btnNewButton_3);
		
	}
	
}
