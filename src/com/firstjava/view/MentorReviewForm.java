package com.firstjava.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MentorReviewForm extends JFrame {

	private JPanel contentPane;
	public JTextField tf_class;
	public JButton bt_submit,bt_cancel;
	public JComboBox cb_score;
		
	/**
	 * Create the frame.
	 */
	public MentorReviewForm() {
		setBounds(550, 200, 600, 390);
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
		
		JLabel la_review = new JLabel("평점 작성");
		la_review.setFont(new Font("나눔바른고딕 Light", Font.BOLD, 18));
		la_review.setBounds(250, 52, 99, 61);
		contentPane.add(la_review);
		

		//필드
		tf_class = new JTextField();
		tf_class.setBounds(151, 166, 395, 24);
		contentPane.add(tf_class);
		tf_class.setColumns(10);
		tf_class.setEnabled(false);
		
		bt_submit = new JButton("등록");
		bt_submit.setBounds(151, 259, 105, 30);
		contentPane.add(bt_submit);
		
		bt_cancel = new JButton("취소");                                            
		bt_cancel.setBounds(311, 259, 105, 30);
		contentPane.add(bt_cancel);
		
		cb_score = new JComboBox();
		cb_score.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1"}));
		cb_score.setBounds(149, 207, 71, 24);
		contentPane.add(cb_score);
		

		
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
