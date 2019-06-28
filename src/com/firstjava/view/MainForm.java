package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.firstjava.model.vo.ClassVO;

public class MainForm extends JFrame { 
	public JTextField tf_admin;
	public JLabel la_user_id;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_mypage, bt_mento_demand, bt_user_photo, bt_main, bt_mento_class;
    public JPanel panel_lecture;//카드레이아웃  기준             
    public JPanel panel_main, panel_mentor; //카드  
    public JTextArea ta_desc;
    public CardLayout card;
    
    //MentorForm Component
    public JButton bt_search, bt_select, bt_create_class, bt_class_delete, bt_class_update, bt_manager;
    public JComboBox<String> cb_category;
    public JTable table;
    JScrollPane scroll_table;   
    JLabel la_category;
    
    DefaultTableModel dtm;
    
   public MainForm() {
      setTitle("main Form");
      card = new CardLayout();
      panel_lecture = new JPanel();
      panel_mentor = new JPanel();//new MentorForm();
      panel_lecture.setLayout(card);
      
      //----------------MENTOR FRAME------------
      bt_search=new JButton("검색");
      bt_search.setBounds(557,17,61,27);
      
      bt_select = new JButton("전체 조회");
      bt_select.setBounds(632,17,93,27);
      
      bt_create_class = new JButton("강의 개설");
      bt_create_class.setBounds(418,361,93,27);

      bt_class_update = new JButton("강의 수정");
      bt_class_update.setBounds(525,361,93,27);
  
      bt_class_delete = new JButton("신청 삭제");
      bt_class_delete.setBounds(632,361,93,27);
      
      la_category = new JLabel("카테고리");
      la_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      la_category.setBounds(353,16,68,24);
      
      String []categoryTitle= {"JAVA","HTML","뷰티","외국어","음악","라이프"};
      cb_category = new JComboBox<String>(categoryTitle);
      cb_category.setBounds(450,10,80,40);
      
      //컬럼명 설정
      
	  String[] columnTitle = { "NO", "분류", "강의명", "개강일", "종강일" };
	  Object[][] rowData = new Object[0][6];
	  dtm = new DefaultTableModel(rowData, columnTitle);
		
      table = new JTable(dtm) {
             @Override
           public boolean isCellEditable(int row, int column) {
             return false;
           }
          };
      
      //컬럼 크기 설정  
	  table.getColumn("NO").setPreferredWidth(20);
	  table.getColumn("분류").setPreferredWidth(50);
	  table.getColumn("강의명").setPreferredWidth(280);
	  table.getColumn("개강일").setPreferredWidth(25);
	  table.getColumn("종강일").setPreferredWidth(25);          
	       
      
      table.setRowHeight(30);
      scroll_table = new JScrollPane(table);
      scroll_table.setBounds(50, 55, 675, 287);
      panel_mentor.setLayout(null);
      
      
      panel_mentor.add(bt_search);
      panel_mentor.add(bt_select);
      panel_mentor.add(bt_class_update);
      panel_mentor.add(bt_create_class);
      panel_mentor.add(bt_class_delete);
      panel_mentor.add(la_category);
      panel_mentor.add(cb_category);
      panel_mentor.add(scroll_table);
      
      
      
      //------------------MAINFORM------------------------
      panel_main = new JPanel();

      
      
      
      
      //---------------------------------------------------

      //카드 붙이기
      panel_lecture.add(panel_main,"1");//"empty"별명
      panel_lecture.add(panel_mentor,"2");//"mentor"별명
      
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
      bt_login.setBounds(670,30,110,40);
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
      
      la_user_id = new JLabel("Welcome");
      la_user_id.setBounds(190,50,150,40);
      
      tf_admin = new JTextField("관리자");
      tf_admin.setBounds(190,100,150,40);

      getContentPane().setLayout(null);
      getContentPane().add(bt_main);
      getContentPane().add(bt_mento_class);
      getContentPane().add(bt_login);
      getContentPane().add(bt_mypage);
      getContentPane().add(bt_mento_demand);
      getContentPane().add(bt_user_photo);
      getContentPane().add(la_user_id);
      getContentPane().add(tf_admin);
      getContentPane().add(panel_lecture);
      
      bt_manager = new JButton("관리자(임시)");
      bt_manager.setBounds(560, 100, 120, 34);
      getContentPane().add(bt_manager);
      
      setBounds(450,170,800,700);
      setVisible(true);
      //setResizable(false);
      
   }//생성자
   
   
	public void displayTable(ArrayList<ClassVO> list) {

		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ClassVO vo = list.get(i);
			Object[] rowData = { vo.getClassno(), vo.getCname(), vo.getClassinfo(), vo.getOpenDate(),
					vo.getCloseDate() };
			dtm.addRow(rowData);

		}

	}// displayTable   
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}