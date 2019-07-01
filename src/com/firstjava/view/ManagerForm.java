package com.firstjava.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.firstjava.model.vo.ClassVO;
import com.firstjava.model.vo.MemberVO;

public class ManagerForm extends JFrame{
    public JPasswordField tf_pass;
    public JButton bt_homepage, bt_member, bt_post;
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
	DefaultTableModel dtm; //멤버
	DefaultTableModel p_dtm; // 클래스
	 
	
	//PostForm 컴포넌트 
    public JButton bt_p_search, bt_p_all_select, bt_p_info, bt_p_id_search, bt_p_id_delete;
	public JComboBox<String> cb_p_category;
	JLabel la_p_category;
	public JTable p_table;
	JScrollPane p_scroll_table;
	private JLabel label;
	private JLabel label_1;
    
   public ManagerForm() {
      setTitle("Manager Form");
      card = new CardLayout();
      panel_lecture = new JPanel();
      panel_lecture.setLayout(card);
      
      //폰트설정
      Font font16 = new Font("나눔바른고딕 UltraLight",Font.BOLD, 16);
      
      
      //-----------------Member Form------------------
      panel_member = new JPanel();
      
      bt_search = new JButton("검색");
      bt_search.setBounds(207,524,61,30);
      
      bt_all_select = new JButton("전체 조회");
      bt_all_select.setBounds(397,524,93,30);
      

      bt_info = new JButton("정보조회");
      bt_info.setBounds(613,162,90,30);
   
      bt_id_search = new JButton("아이디검색");
      bt_id_search.setBounds(282,524,103,30);
      
      bt_id_delete = new JButton("회원삭제");
      bt_id_delete.setBounds(511,162,90,30);
  
      
      la_category = new JLabel("카테고리");
      la_category.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
      la_category.setBounds(50,528,61,24);
      
      String []categoryTitle= {"회원","멘티","멘토"};
      cb_category = new JComboBox<String>(categoryTitle);
      cb_category.setBounds(110, 525, 80, 30);

      
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
	  table.getColumn("ID").setPreferredWidth(20);
	  table.getColumn("Name").setPreferredWidth(20);
	  table.getColumn("Email").setPreferredWidth(200);
	  table.getColumn("Phone").setPreferredWidth(50);
	  
      scroll_table = new JScrollPane(table);
      scroll_table.setBounds(50, 202, 653, 312);
      panel_member.setLayout(null);
      
      panel_member.add(bt_search);
      panel_member.add(bt_all_select);
      panel_member.add(bt_info);
      panel_member.add(bt_id_search);
      panel_member.add(bt_id_delete);
      panel_member.add(la_category);
      panel_member.add(cb_category);
      panel_member.add(scroll_table);
      
      JLabel la_logo2 = new JLabel("");
      la_logo2.setIcon(new ImageIcon("image/logo_blacksmall.png"));
      la_logo2.setBounds(50, 10, 144, 150);
      panel_member.add(la_logo2);
      
      
      //----------------Post Form---------------------
      
      panel_post = new JPanel();
       
      bt_p_search = new JButton("검색");
      bt_p_search.setBounds(207,524,61,30);
      
      bt_p_all_select = new JButton("전체 조회");
      bt_p_all_select.setBounds(397,524,93,30);
      

      bt_p_info = new JButton("정보 조회");
      bt_p_info.setBounds(613,162,90,30);
   
      bt_p_id_search = new JButton("아이디검색");
      bt_p_id_search.setBounds(282,524,103,30);
      
      bt_p_id_delete = new JButton("삭제");
      bt_p_id_delete.setBounds(511,162,90,30);
  
      
      la_p_category = new JLabel("카테고리");
      la_p_category.setFont(new Font("나눔바른고딕 UltraLight", Font.BOLD, 15));
      la_p_category.setBounds(50,528,61,24);
      
      String[] c_categoryTitle = { "JAVA", "HTML", "뷰티", "외국어", "음악", "라이프" };
      cb_p_category = new JComboBox<String>(c_categoryTitle);
      cb_p_category.setBounds(110, 525, 80, 30);

      
      String [] p_columnTitle = { "NO", "분류", "강의명", "개강일", "종강일", "멘토명", "수강생", "정원" };
      Object[][] p_rowData = new Object[0][9];
      p_dtm = new DefaultTableModel(p_rowData,p_columnTitle);
      
      p_table = new JTable(p_dtm) {
             @Override
           public boolean isCellEditable(int row, int column) {
             return false;
           }
          };
      
      p_table.setRowHeight(30);
      p_scroll_table = new JScrollPane(p_table);
      p_scroll_table.setBounds(50, 202, 653, 312);
      panel_post.setLayout(null);
      
      panel_post.add(bt_p_search);
      panel_post.add(bt_p_all_select);
      panel_post.add(bt_p_info);
      panel_post.add(bt_p_id_search);
      panel_post.add(bt_p_id_delete);
      panel_post.add(la_p_category);
      panel_post.add(cb_p_category);
      panel_post.add(p_scroll_table);
      //---------------------------------------------
      //카드 붙이기
      panel_lecture.add(panel_member,"1");
      
      JLabel la_memberpost = new JLabel("회원 조회");
      la_memberpost.setFont(new Font("나눔바른고딕 UltraLight", Font.PLAIN, 18));
      la_memberpost.setBounds(193, 73, 144, 47);
      panel_member.add(la_memberpost);
      panel_lecture.add(panel_post,"2");
      
      label = new JLabel("");
      label.setBounds(50, 10, 144, 150);
      panel_post.add(label);
      
      label_1 = new JLabel("게시글 관리");
      label_1.setFont(new Font("나눔바른고딕 UltraLight", Font.PLAIN, 18));
      label_1.setBounds(193, 73, 144, 47);
      panel_post.add(label_1);
      
      
      panel_lecture.setBounds(25, 80, 736, 564);
      
      bt_member = new JButton("회원조회");
      bt_member.setForeground(new Color(255, 255, 255));
      bt_member.setFont(font16);
      bt_member.setBackground(Color.white);
      bt_member.setOpaque(false);
      bt_member.setBorderPainted ( false );
      bt_member.setBounds(435,30,111,40);
      
      bt_post = new JButton("게시글관리");
      bt_post.setFont(font16);
      bt_post.setBackground(Color.white);
      bt_post.setOpaque(false);
      bt_post.setBorderPainted ( false );
      bt_post.setBounds(530,30,120,40);
      

      bt_homepage = new JButton("홈페이지");
      bt_homepage.setFont(font16);
      bt_homepage.setBounds(635,30,120,40);
      bt_homepage.setBackground(Color.white);
      bt_homepage.setOpaque(false);
      bt_homepage.setBorderPainted ( false );

      getContentPane().setLayout(null);
      getContentPane().add(bt_member);
      getContentPane().add(bt_post);
      getContentPane().add(bt_homepage);
      getContentPane().add(panel_lecture);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon("image\\background_800.jpg"));
      lblNewLabel.setBounds(0, 0, 784, 661);
      getContentPane().add(lblNewLabel);
      
      
      setBounds(450,170,800,700);
      setVisible(false);
      //setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      

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
   
	public void classDisplayTable(ArrayList<ClassVO> list) {

		p_dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ClassVO vo = list.get(i);
			Object[] rowData = { vo.getClassno(), vo.getCname(), vo.getClassinfo(), vo.getOpenDate(),
					vo.getCloseDate(), vo.getUserid(), vo.getStudent(), vo.getLimit() };
			p_dtm.addRow(rowData);

		}

	}// displayTable
   
   
   
   
   public void showMsg(String msg) {
	   JOptionPane.showMessageDialog(this, msg);
   }
   
   public boolean confirmMsg(String msg) {// yes =0 , no = 1
	   
	   if(JOptionPane.showConfirmDialog(this, msg)==0) {
		   return true;
	   }else {
		   return false;
	   }
   }
   
   
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerForm frame = new ManagerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}