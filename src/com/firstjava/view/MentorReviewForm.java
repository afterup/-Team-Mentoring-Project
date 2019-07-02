package com.firstjava.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class MentorReviewForm extends JFrame {

	private JPanel contentPane;
	private JTextField tf_class;
		
	/**
	 * Create the frame.
	 */
	public MentorReviewForm() {
		setBounds(550, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setTitle("강의등록");
		
		
		//라벨
		
		JLabel la_class = new JLabel("강의");
		la_class.setBounds(51, 169, 80, 18);
		contentPane.add(la_class);
		
		JLabel la_score = new JLabel("평점");
		la_score.setBounds(51, 210, 80, 18);
		contentPane.add(la_score);
		
		JLabel la_post = new JLabel("리뷰작성");
		la_post.setBounds(51, 245, 80, 18);
		contentPane.add(la_post);
		

		//필드
		tf_class = new JTextField();
		tf_class.setBounds(151, 166, 395, 24);
		contentPane.add(tf_class);
		tf_class.setColumns(10);
		
		String category[] = {"프로그래밍", "영어", "뷰티"};
		
		
		JTextArea ta_post = new JTextArea();
		ta_post.setBounds(151, 243, 395, 246);
		contentPane.add(ta_post);
		
		JButton bt_submit = new JButton("등록");
		bt_submit.setBounds(151, 511, 105, 30);
		contentPane.add(bt_submit);
		
		JButton bt_cancel = new JButton("취소");                                            
		bt_cancel.setBounds(311, 511, 105, 30);
		contentPane.add(bt_cancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1"}));
		comboBox.setBounds(149, 207, 71, 24);
		contentPane.add(comboBox);
		
		JLabel la_review = new JLabel("리뷰 작성");
		la_review.setFont(new Font("나눔바른고딕 Light", Font.BOLD, 18));
		la_review.setBounds(250, 52, 99, 61);
		contentPane.add(la_review);
		
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
