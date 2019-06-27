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

import com.firstjava.model.vo.MemberVO;

public class ManagerForm extends JFrame  implements ActionListener{ 
	public JTextField tf_user_id, tf_admin;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_homepage, bt_user_photo, bt_member, bt_post;
    public JPanel panel_lecture;//카드레이아웃  기준             
    public JPanel panel_member, panel_post; //카드  
    public JTextArea ta_desc;
    public CardLayout card;
    
    //MemberForm 컴포넌트
    public JButton bt_search, bt_all_select,bt_info, bt_id_search, bt_id_delete;
	public JComboBox<String> cb_category;
	public JTable table;
	JLabel la_category;
	JScrollPane scroll_table;	
	DefaultTableModel dtm;
	 
	
	//PostForm 컴포넌트 
    public JButton bt_p_search, bt_p_all_select,
    bt_p_info, bt_p_id_search, bt_p_id_delete;
	public JComboBox<String> cb_p_category;
	JLabel la_p_category;
	JTable p_table;
	JScrollPane p_scroll_table;
    
   public ManagerForm() {
      setTitle("Login Form");
      card = new CardLayout();
      panel_lecture = new JPanel();
      panel_lecture.setLayout(card);
      
      
      
      //-----------------Member Form------------------
      panel_member = new JPanel();
      
      bt_search = new JButton("검색");
      bt_search.setBounds(440,16,61,27);
      
      bt_all_select = new JButton("전체 조회");
      bt_all_select.setBounds(632,16,93,27);
      

      bt_info = new JButton("정보 조회");
      bt_info.setBounds(557,361,93,27);
   
      bt_id_search = new JButton("아이디검색");
      bt_id_search.setBounds(515,16,103,27);
      
      bt_id_delete = new JButton("삭제");
      bt_id_delete.setBounds(664,361,61,27);
  
      
      la_category = new JLabel("카테고리");
      la_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      la_category.setBounds(267,15,68,24);
      
      String []categoryTitle= {"회원","멘티","멘토"};
      cb_category = new JComboBox<String>(categoryTitle);
      cb_category.setBounds(340,10,90,40);

      
      String [] columnTitle = {"ID", "Name", "Email","Phone"};
      Object[][] rowData = new Object[0][4];
      dtm = new DefaultTableModel(rowData,columnTitle);
      
      table = new JTable(dtm) {
             @Override
           public boolean isCellEditable(int row, int column) {
             return false;
           }
          };
      
      table.setRowHeight(30);
      scroll_table = new JScrollPane(table);
      scroll_table.setBounds(50, 55, 675, 287);
      panel_member.setLayout(null);
      
      panel_member.add(bt_search);
      panel_member.add(bt_all_select);
      panel_member.add(bt_info);
      panel_member.add(bt_id_search);
      panel_member.add(bt_id_delete);
      panel_member.add(la_category);
      panel_member.add(cb_category);
      panel_member.add(scroll_table);
      
      JLabel label = new JLabel("회원조회 (임시텍스트)");
      label.setBounds(14, 9, 143, 18);
      panel_member.add(label);
      
      
      //----------------Post Form---------------------
      panel_post = new JPanel();
      
      bt_p_search = new JButton("검색");
      bt_p_search.setBounds(440,16,61,27);
      
      bt_p_all_select = new JButton("전체 조회");
      bt_p_all_select.setBounds(632,16,93,27);
      

      bt_p_info = new JButton("정보 조회");
      bt_p_info.setBounds(557,361,93,27);
   
      bt_p_id_search = new JButton("아이디검색");
      bt_p_id_search.setBounds(515,16,103,27);
      
      bt_p_id_delete = new JButton("삭제");
      bt_p_id_delete.setBounds(664,361,61,27);
  
      
      la_p_category = new JLabel("카테고리");
      la_p_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      la_p_category.setBounds(267,15,68,24);
      
      String []p_categoryTitle= {"회원","멘티","멘토"};
      cb_p_category = new JComboBox<String>(p_categoryTitle);
      cb_p_category.setBounds(340,10,90,40);

      
      String [] p_columnTitle = {"No.", "test", "value"};
      Object[][] p_rowData = new Object[0][3];
      DefaultTableModel p_dtm = new DefaultTableModel(p_rowData,p_columnTitle);
      
      p_table = new JTable(p_dtm) {
             @Override
           public boolean isCellEditable(int row, int column) {
             return false;
           }
          };
      
      p_table.setRowHeight(30);
      p_scroll_table = new JScrollPane(p_table);
      p_scroll_table.setBounds(50, 55, 675, 287);
      panel_post.setLayout(null);
      
      panel_post.add(bt_p_search);
      panel_post.add(bt_p_all_select);
      panel_post.add(bt_p_info);
      panel_post.add(bt_p_id_search);
      panel_post.add(bt_p_id_delete);
      panel_post.add(la_p_category);
      panel_post.add(cb_p_category);
      panel_post.add(p_scroll_table);
      
      

      JLabel label_1 = new JLabel("게시글관리 (임시텍스트)");
      label_1.setBounds(14, 9, 157, 18);
      panel_post.add(label_1);
      //---------------------------------------------
      //카드 붙이기
      panel_lecture.add(panel_member,"1");
      panel_lecture.add(panel_post,"2");
      
      
      panel_lecture.setBounds(0, 250, 780, 400);
      
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
      setVisible(false);
      //setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      bt_member.addActionListener(this);
      bt_post.addActionListener(this);
      
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
     Object ob = e.getSource();
     
     if(ob==bt_member) {
        card.show(panel_lecture, "1");
     }else if(ob== bt_post ) {
        card.show(panel_lecture, "2");
        
     }
      
   }
   
   public void memberDisplayTable(ArrayList<MemberVO> list) {

	    dtm.setRowCount(0);
	    
	    for(int i=0; i<list.size(); i++) {
	    	MemberVO vo = list.get(i);
	    	Object []rowData= {vo.getUserId(),vo.getUname(),vo.getEmail(),vo.getPhone()};
	    	dtm.addRow(rowData);
	    }
	    
    //JScrollBar bar= scroll_table.getVerticalScrollBar();
    //bar.setValue(bar.getMaximum());
    
   }//displayTable
   
   
   
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerForm frame = new ManagerForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}