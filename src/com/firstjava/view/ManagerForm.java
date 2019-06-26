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
import javax.swing.JLabel;

public class ManagerForm extends JFrame  implements ActionListener{ 
	public JTextField tf_user_id, tf_admin;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_homepage, bt_user_photo, bt_member, bt_post;
    public JPanel panel_lecture;//카드레이아웃  기준             
    public JPanel panel_member, panel_post; //카드  
    public JTextArea ta_desc;
    public CardLayout card;
    
    
    
    
    
   public ManagerForm() {
      setTitle("Login Form");
      card = new CardLayout();
      
      panel_member = new ManagerMemberForm();
      panel_post = new ManagerPostForm();
      
      
      panel_lecture = new JPanel();
         //panel_lecture.add(new JLabel("빈패널"));
      panel_lecture.setLayout(card);

      //카드 붙이기
      panel_lecture.add(panel_member,"empty");//"empty"별명
      
      JLabel label = new JLabel("회원조회 (임시텍스트)");
      label.setBounds(14, 21, 191, 18);
      panel_member.add(label);
      panel_lecture.add(panel_post,"mentor");//"mentor"별명
      
      JLabel label_1 = new JLabel("게시글관리 (임시텍스트)");
      label_1.setBounds(25, 32, 191, 18);
      panel_post.add(label_1);
      
      //panel_lecture.setBackground(Color.green); //메인에서의 영역확인
      panel_lecture.setBounds(0, 250, 780, 400);
      //전체 setBounds(450,170,800,700);
      
      bt_member = new JButton("회원조회");
      bt_member.setBounds(30,190,150,50);
      
      bt_post = new JButton("게시글 관리");
      bt_post.setBounds(190,190,150,50);
      
      bt_login = new JButton("Login");
      bt_login.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bt_login.setForeground(Color.BLUE);
      bt_login.getBackground();
      bt_login.setBounds(670,30,80,40);
      bt_login.setBackground(Color.white);
      bt_login.setOpaque(false);
      bt_login.setBorderPainted ( false );

      bt_homepage = new JButton("홈페이지로");
      bt_homepage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      bt_homepage.setBounds(533,30,125,40);
      bt_homepage.setBackground(Color.white);
      bt_homepage.setOpaque(false);
      bt_homepage.setBorderPainted ( false );
      
      bt_user_photo = new JButton();
      bt_user_photo.setBounds(40,30,130,130);
      bt_user_photo.setIcon(new ImageIcon("image//bt_user_photo.jpg"));
      
      tf_user_id = new JTextField("사용자 ID");
      tf_user_id.setBounds(190,50,150,40);
      
      tf_admin = new JTextField("관리자");
      tf_admin.setBounds(190,100,150,40);

      getContentPane().setLayout(null);
      getContentPane().add(bt_member);
      getContentPane().add(bt_post);
      getContentPane().add(bt_login);
      getContentPane().add(bt_homepage);
      getContentPane().add(bt_user_photo);
      getContentPane().add(tf_user_id);
      getContentPane().add(tf_admin);
      getContentPane().add(panel_lecture);
      
      
      setBounds(450,170,800,700);
      setVisible(true);
      //setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      bt_member.addActionListener(this);
      bt_post.addActionListener(this);
      
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
     Object ob = e.getSource();
     
     if(ob==bt_member) {
        card.show(panel_lecture, "empty");
     }else if(ob== bt_post ) {
        card.show(panel_lecture, "mentor");
        
     }
      
   }
   
   
   
   public static void main(String[] args) {
      new ManagerForm();
   }
}