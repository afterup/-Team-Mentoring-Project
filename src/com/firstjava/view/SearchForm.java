package com.firstjava.view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchForm extends JFrame {

	public JComboBox<String> cb_columnTitle, cb_columnSort;
	JRadioButton radio_asc, radio_desc;
	ButtonGroup group;

	// 둘째패널에 위치할 컴포넌트 ==> 라벨, 텍스트필드
	JTextField tf_search;

	JPanel panel_first, panel_second, panel_third, panel_option;

	public SearchForm() {

		radio_asc = new JRadioButton("오름차순", true);
		radio_desc = new JRadioButton("내림차순");

		group = new ButtonGroup();		
		group.add(radio_asc);
		group.add(radio_desc);

		String[] categoryTitle = {"목록", "NO", "분류", "강의명", "개강일", "종강일", "멘토명", "수강생", "정원" };
		cb_columnTitle = new JComboBox<String>(categoryTitle);
		cb_columnSort = new JComboBox<String>(categoryTitle); 
		
		tf_search = new JTextField(15);
		panel_first = new JPanel();
		panel_first.add(cb_columnTitle);
		panel_first.add(tf_search);
		
		panel_second = new JPanel();
		panel_second.add(new JLabel("정렬:"));
		panel_second.add(cb_columnSort);
		panel_second.add(new JPanel());
		
		panel_third = new JPanel();
		panel_third.add(radio_asc);
		panel_third.add(radio_desc);



		panel_option = new JPanel();
		panel_option.setLayout(new GridLayout(3, 1));
		panel_option.add(panel_first);
		panel_option.add(panel_second);
		panel_option.add(panel_third);


		setBounds(300, 200, 450, 300);
		//setVisible(true);

	}

	public Map<String, Object>  showOption() { //Map<String, String>
		// JOptionPane.showOptionDialog(parentComponent, message, title,
		// optionType, messageType, icon, options, initialValue)
		String[] options = { "확인", "취소" };
		JOptionPane.showOptionDialog(this, panel_option, "Search", 
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.PLAIN_MESSAGE, // JOptionPane.ERROR_MESSAGE,
									null, null, // options,
									null);// options[1])
		
		int columnTitle = cb_columnTitle.getSelectedIndex();
		
		int columnSort = cb_columnSort.getSelectedIndex();
		
		String keyword = tf_search.getText();
		
		String sort = "";// 만약 라디오 버튼 중 아이디가 선택되었다면 title= "아이디";
					// "아이디" , "이름", "주소"

		if (radio_asc.isSelected()) {// 버튼그룹 중 아이디가 선택되었다면
			sort = "오름차순"; // title=radio_id.getText();
		} else if (radio_desc.isSelected()) {// 버튼그룹 중 이름이 선택되었다면
			sort = "내림차순";
		}

		Map<String, Object> map = new HashMap<>();
			
			map.put("columnTitle", columnTitle);
			map.put("keyword", keyword);
			map.put("columnSort", columnSort);
			map.put("sort", sort);

		return map;
	}// showOption
	
	


	public static void main(String[] args) {

		SearchForm sb = new SearchForm();
		
		sb.isShowing();
		
		
		
	}

}
