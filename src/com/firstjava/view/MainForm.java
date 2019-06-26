package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainForm extends JFrame  implements ActionListener{ 
	public JTextField tf_user_id, tf_admin;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_mypage, bt_mento_demand, bt_user_photo, bt_main, bt_mento_class;
    public JPanel panel_lecture;//카드레이아웃  기준             
    public JPanel panel_empty, panel_mentor; //카드  
    public JTextArea ta_desc;
    public CardLayout card;
    
    
    
     
    
   public MainForm(MainMentorForm mentorForm) {
      setTitle("main Form");
      card = new CardLayout();
      
      panel_empty = new JPanel();
      panel_mentor = mentorForm;//new MentorForm();
      
      
      panel_lecture = new JPanel();
         //panel_lecture.add(new JLabel("빈패널"));
      panel_lecture.setLayout(card);

      //카드 붙이기
      panel_lecture.add(panel_empty,"empty");//"empty"별명
      panel_lecture.add(panel_mentor,"mentor");//"mentor"별명
      
      //panel_lecture.setBackground(Color.green); //메인에서의 영역확인
      panel_lecture.setBounds(0, 250, 780, 400);
      //전체 setBounds(450,170,800,700);
      
      bt_main = new JButton("메인");
      bt_main.setBounds(30,190,150,50);
      
      bt_mento_class = new JButton("멘토 강의");
      bt_mento_class.setBounds(190,190,150,50);
      
      bt_login = new JButton("Login");
      bt_login.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bt_login.setForeground(Color.BLUE);
      bt_login.getBackground();
      bt_login.setBounds(670,30,80,40);
      bt_login.setBackground(Color.white);
      bt_login.setOpaque(false);
      bt_login.setBorderPainted ( false );

      bt_mypage = new JButton("MyPage");
      bt_mypage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bt_mypage.setBounds(560,30,100,40);
      bt_mypage.setBackground(Color.white);
      bt_mypage.setOpaque(false);
      bt_mypage.setBorderPainted ( false );
      
      bt_mento_demand = new JButton("멘토 신청");
      bt_mento_demand.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bt_mento_demand.setBounds(425,30,120,40);
      bt_mento_demand.setBackground(Color.white);
      bt_mento_demand.setOpaque(false);
      bt_mento_demand.setBorderPainted ( false );
      
      bt_user_photo = new JButton();
      bt_user_photo.setBounds(40,30,130,130);
      bt_user_photo.setIcon(new ImageIcon("image//bt_user_photo.jpg"));
      
      tf_user_id = new JTextField("사용자 ID");
      tf_user_id.setBounds(190,50,150,40);
      
      tf_admin = new JTextField("괸리자");
      tf_admin.setBounds(190,100,150,40);

      getContentPane().setLayout(null);
      getContentPane().add(bt_main);
      getContentPane().add(bt_mento_class);
      getContentPane().add(bt_login);
      getContentPane().add(bt_mypage);
      getContentPane().add(bt_mento_demand);
      getContentPane().add(bt_user_photo);
      getContentPane().add(tf_user_id);
      getContentPane().add(tf_admin);
      getContentPane().add(panel_lecture);
      
      
      setBounds(450,170,800,700);
      setVisible(true);
      //setResizable(false);
      
      bt_main.addActionListener(this);
      bt_mento_class.addActionListener(this);
      
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
     Object ob = e.getSource();
     
     if(ob==bt_main) {
        card.show(panel_lecture, "empty");
     }else if(ob== bt_mento_class ) { 
        card.show(panel_lecture, "mentor");
        
     }
      
   }
   
   
   
   public static void main(String[] args) {
      //new MainForm();
   }
}