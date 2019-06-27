package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindForm extends JFrame implements ActionListener
{

	JLabel la_background, la_logoimage;
	public JButton bt_idView, bt_passView;
	public JPanel panel_main, panel_id, panel_pass;
	CardLayout card;

	//---ID 컴포넌트
	private JTextField tf_name, tf_phoneNum, tf_email;
	private JLabel la_name, la_phoneNum, la_email;
	public JButton bt_findID, bt_cancel;
	
	//---Pass 컴포넌트
	private JTextField tf_p_name, tf_p_phoneNum, tf_p_email;
	private JLabel la_p_name, la_p_phoneNum, la_p_email;
	public JButton bt_p_findID, bt_p_cancel;
	private JLabel label;

	public FindForm()
	{
		setTitle("find form");
		card = new CardLayout();
		panel_main = new JPanel();
		panel_main.setSize(340, 310);
		panel_main.setLocation(0, 240);
		panel_main.setLayout(card);

		//----ID Form --------------
		panel_id = new JPanel();

		la_name = new JLabel("이름: ");
		la_name.setForeground(Color.WHITE);
		la_name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_name.setBounds(49, 48, 39, 21);

		la_phoneNum = new JLabel("전화번호: ");
		la_phoneNum.setForeground(Color.WHITE);
		la_phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_phoneNum.setBounds(49, 98, 69, 21);

		la_email = new JLabel("이메일: ");
		la_email.setForeground(Color.WHITE);
		la_email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_email.setBounds(49, 151, 54, 21);

		tf_name = new JTextField();
		tf_name.setBounds(136, 48, 149, 24);
		tf_name.setColumns(10);

		tf_phoneNum = new JTextField();
		tf_phoneNum.setColumns(10);
		tf_phoneNum.setBounds(136, 98, 149, 24);

		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(136, 151, 149, 24);

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
		panel_id.add(la_phoneNum);
		panel_id.add(la_email);
		panel_id.add(tf_name);
		panel_id.add(tf_phoneNum);
		panel_id.add(tf_email);
		panel_id.add(bt_findID);
		panel_id.add(bt_cancel);

		//-----Pass Form ------------
		panel_pass = new JPanel();

		la_p_name = new JLabel("이름: ");
		la_p_name.setForeground(Color.WHITE);
		la_p_name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_p_name.setBounds(49, 48, 39, 21);

		la_p_phoneNum = new JLabel("전화번호: ");
		la_p_phoneNum.setForeground(Color.WHITE);
		la_p_phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_p_phoneNum.setBounds(49, 98, 69, 21);

		la_p_email = new JLabel("이메일: ");
		la_p_email.setForeground(Color.WHITE);
		la_p_email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		la_p_email.setBounds(49, 151, 54, 21);

		tf_p_name = new JTextField();
		tf_p_name.setBounds(136, 48, 149, 24);
		tf_p_name.setColumns(10);

		tf_p_phoneNum = new JTextField();
		tf_p_phoneNum.setColumns(10);
		tf_p_phoneNum.setBounds(136, 98, 149, 24);

		tf_p_email = new JTextField();
		tf_p_email.setColumns(10);
		tf_p_email.setBounds(136, 151, 149, 24);

		bt_p_findID = new JButton("아이디찾기");
		bt_p_findID.setForeground(Color.white);
		bt_p_findID.setBackground(new Color(140, 143, 143));
		bt_p_findID.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_p_findID.setBounds(50, 242, 100, 40);

		bt_p_cancel = new JButton("취소");
		bt_p_cancel.setForeground(Color.WHITE);
		bt_p_cancel.setBackground(new Color(140, 143, 143));
		bt_p_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bt_p_cancel.setBounds(185, 242, 100, 40);
		
		panel_pass.setLayout(null);
		panel_pass.add(la_p_name);
		panel_pass.add(la_p_phoneNum);
		panel_pass.add(la_p_email);
		panel_pass.add(tf_p_name);
		panel_pass.add(tf_p_phoneNum);
		panel_pass.add(tf_p_email);
		panel_pass.add(bt_p_findID);
		panel_pass.add(bt_p_cancel);
		
		
		
		
		//---------------------------

		panel_main.add(panel_id, "1");
		
		JLabel la_check = new JLabel("유효성 검사");
		la_check.setBounds(136, 203, 100, 18);
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

		setVisible(true);

		bt_idView.addActionListener(this);
		bt_passView.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object ob = e.getSource();

		if (ob == bt_idView) {
			card.show(panel_main, "1");
		} else if (ob == bt_passView) {
			card.show(panel_main, "2");

		}
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					FindForm frame = new FindForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
