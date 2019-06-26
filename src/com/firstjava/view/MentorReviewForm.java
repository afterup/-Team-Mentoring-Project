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

public class MentorReviewForm extends JFrame {

	private JPanel contentPane;
	private JTextField tf_class, textField_4, textField_4_2;
	private JTextField tf_category;
		
	/**
	 * Create the frame.
	 */
	public MentorReviewForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setTitle("강의등록");
		
		
		//라벨
		
		JLabel la_class = new JLabel("강의");
		la_class.setBounds(50, 40, 80, 18);
		contentPane.add(la_class);
		
		JLabel la_category = new JLabel("카테고리");
		la_category.setBounds(50, 80, 80, 18);
		contentPane.add(la_category);
		
		JLabel label_4 = new JLabel("개강일자");
		label_4.setBounds(50, 114, 80, 18);
		contentPane.add(label_4);
		
		JLabel label_4_2 = new JLabel("종강일자");
		label_4_2.setBounds(300, 114, 80, 18);
		contentPane.add(label_4_2);
		
		JLabel la_post = new JLabel("리뷰작성");
		la_post.setBounds(50, 163, 80, 18);
		contentPane.add(la_post);
		

		//필드
		tf_class = new JTextField();
		tf_class.setBounds(150, 40, 580, 24);
		contentPane.add(tf_class);
		tf_class.setColumns(10);
		
		String category[] = {"프로그래밍", "영어", "뷰티"};
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 114, 130, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_4_2 = new JTextField();
		textField_4_2.setBounds(380, 114, 130, 24);
		contentPane.add(textField_4_2);
		textField_4_2.setColumns(10);
		
		
		JTextArea ta_post = new JTextArea();
		ta_post.setBounds(150, 163, 580, 364);
		contentPane.add(ta_post);
		
		JButton bt_submit = new JButton("등록");
		bt_submit.setBounds(280, 580, 105, 30);
		contentPane.add(bt_submit);
		
		JButton bt_cancel = new JButton("취소");                                            
		bt_cancel.setBounds(440, 580, 105, 30);
		contentPane.add(bt_cancel);
		
		tf_category = new JTextField();
		tf_category.setColumns(10);
		tf_category.setBounds(150, 77, 130, 24);
		contentPane.add(tf_category);
		
	}
	

	/**
	 * Launch the application.

	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MentorReviewForm frame = new MentorReviewForm();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//main
}//class
