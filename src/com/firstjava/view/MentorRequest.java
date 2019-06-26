package com.firstjava.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MentorRequest extends JFrame{

	public JButton bt_search, bt_select, bt_request_cancel, bt_renew;
	public JComboBox<String> cb_category;
	JLabel la_category;
	JTable table;
	JScrollPane scroll_table;

	public MentorRequest() {
		 setTitle("멘토 신청 현황");
		 la_category = new JLabel("카테고리");
		 la_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		 la_category.setBounds(350,15,150,40);
		
		  bt_search = new JButton("검색");
	      bt_search.setBounds(610,15,60,40);
	      
	      bt_select = new JButton("전체 조회");
	      bt_select.setBounds(680,15,95,40);
	      
	      bt_request_cancel = new JButton("신청 취소");
	      bt_request_cancel.setBounds(540,390,100,40);
	      
	      bt_renew = new JButton("갱신");
	      bt_renew.setBounds(650,390,100,40);

	      
	      String []category= {"."};
	      cb_category = new JComboBox<String>(category);
	      cb_category.setBounds(450,15,150,40);

	      
	      String [] columnTitle = {"No.", "Name", "value"};
	      Object[][] rowData = { 
	                             {"", "", ""}
	                           };
	      DefaultTableModel dtm = new DefaultTableModel(rowData,columnTitle);
	      
	      table = new JTable(rowData,columnTitle) {
	             @Override
	           public boolean isCellEditable(int row, int column) {
	             return false;
	           }
	          };
	      
	      scroll_table = new JScrollPane(table);
	      scroll_table.setBounds(0, 80, 800, 300);
	      table.setRowHeight(30);

	      
	      setLayout(null);
	 
	      add(bt_search);
	      add(bt_select);
	      add(bt_request_cancel);
	      add(bt_renew); 
	      add(la_category);
	      add(cb_category);
	      add(scroll_table);
	      
	      
	      setBounds(450,370,800,500);
	      setVisible(true);
	      

	}
	public static void main(String[] args) {
		new MentorRequest();
	}

}
