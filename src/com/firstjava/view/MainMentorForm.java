package com.firstjava.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainMentorForm extends JPanel{ 

    public JButton bt_search, bt_select,
                   bt_create_class, bt_class_delete, bt_class_data;
    public JComboBox<String> cb_category;
   JLabel la_category;
   JTable table;
   JScrollPane scroll_table;
   
   public MainMentorForm() {
     // setTitle("metor");
      System.out.println("MentorForm생성자");
  
      //y축을 -250
      bt_search = new JButton("검색");
      bt_search.setBounds(610,10,60,40);
      
      bt_select = new JButton("전체 조회");
      bt_select.setBounds(680,10,95,40);
      
      bt_class_data = new JButton("신청 정보");
      bt_class_data.setBounds(650,330,100,40);

      bt_create_class = new JButton("강의 개설");
      bt_create_class.setBounds(430,330,100,40);

      bt_class_delete = new JButton("강의 삭제");
      bt_class_delete.setBounds(540,330,100,40);
   
 
      
  
      
      la_category = new JLabel("카테고리");
      la_category.setFont(new Font("맑은 고딕", Font.BOLD, 17));
      la_category.setBounds(350,10,150,40);
      
      String []categoryTitle= {"a","b","c"};
      cb_category = new JComboBox<String>(categoryTitle);
      cb_category.setBounds(450,10,150,40);

      
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
      scroll_table.setBounds(0, 70, 800, 250);
      table.setRowHeight(30);

      
      setLayout(null);
 
      add(bt_search);
      add(bt_select);
      add(bt_create_class);
      add(bt_class_delete);
      add(bt_class_data); 
      add(la_category);
      add(cb_category);
      add(scroll_table);
      
      
      //setBounds(450,170,800,700);
      setVisible(true);
      //setResizable(false);
      
   }
}