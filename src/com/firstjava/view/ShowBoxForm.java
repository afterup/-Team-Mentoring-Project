package com.firstjava.view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ShowBoxForm extends JFrame {

	JRadioButton radio_id, radio_name, radio_email, radio_phone;
	ButtonGroup group;

	// 둘째패널에 위치할 컴포넌트 ==> 라벨, 텍스트필드
	JTextField tf_search;

	JPanel panel_first, panel_second, panel_option;

	public ShowBoxForm() {

		radio_id = new JRadioButton("아이디", true);
		radio_name = new JRadioButton("이름");
		radio_email = new JRadioButton("이메일");
		radio_phone = new JRadioButton("전화번호");

		group = new ButtonGroup();
		group.add(radio_id);
		group.add(radio_name);
		group.add(radio_email);
		group.add(radio_phone);

		panel_first = new JPanel();
		panel_first.add(radio_id);
		panel_first.add(radio_name);
		panel_first.add(radio_email);
		panel_first.add(radio_phone);
		

		tf_search = new JTextField(15);
		panel_second = new JPanel();
		panel_second.add(new JLabel("검색어:"));
		panel_second.add(tf_search);

		panel_option = new JPanel();
		panel_option.setLayout(new GridLayout(2, 1));
		panel_option.add(panel_first);
		panel_option.add(panel_second);



		setBounds(300, 200, 450, 300);
		//setVisible(true);

	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg

	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this, msg);
	}// showInput

	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}// showConfirm

	public Map<String, String> showOption() {
		// JOptionPane.showOptionDialog(parentComponent, message, title,
		// optionType, messageType, icon, options, initialValue)
		String[] options = { "확인", "취소" };
		JOptionPane.showOptionDialog(this, panel_option, "Search", 
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.PLAIN_MESSAGE, // JOptionPane.ERROR_MESSAGE,
									null, null, // options,
									null);// options[1])
							// t==> 확인, 취소, X : 0, 1, -1

		String keyword = tf_search.getText().toLowerCase();
		String title = "";// 만약 라디오 버튼 중 아이디가 선택되었다면 title= "아이디";
					// "아이디" , "이름", "주소"

		if (radio_id.isSelected()) {// 버튼그룹 중 아이디가 선택되었다면
			title = "아이디"; // title=radio_id.getText();
		} else if (radio_name.isSelected()) {// 버튼그룹 중 이름이 선택되었다면
			title = "이름";
		} else if (radio_email.isSelected()) {// 버튼그룹 중 이름이 선택되었다면
			title = "이메일";
		} else {// if(radio_addr.isSelected()) {//버튼그룹 중 주소가 선택되었다면
			title = "전화번호";
		}

		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("title", title);

		return map;
	}// showOption
	
	
	public Map<String, String> showOptionClass() {
		// JOptionPane.showOptionDialog(parentComponent, message, title,
		// optionType, messageType, icon, options, initialValue)
		String[] options = { "확인", "취소" };
		JOptionPane.showOptionDialog(this, panel_option, "Search", 
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.PLAIN_MESSAGE, // JOptionPane.ERROR_MESSAGE,
									null, null, // options,
									null);// options[1])
							// t==> 확인, 취소, X : 0, 1, -1

		String keyword = tf_search.getText();
		String title = "";// 만약 라디오 버튼 중 아이디가 선택되었다면 title= "아이디";
					// "아이디" , "이름", "주소"

		if (radio_id.isSelected()) {// 버튼그룹 중 아이디가 선택되었다면
			title = "아이디"; // title=radio_id.getText();
		} else if (radio_name.isSelected()) {// 버튼그룹 중 이름이 선택되었다면
			title = "이름";
		} else if (radio_name.isSelected()) {// 버튼그룹 중 이름이 선택되었다면
			title = "이메일";
		} else {// if(radio_addr.isSelected()) {//버튼그룹 중 주소가 선택되었다면
			title = "전화번호";
		}

		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("title", title);

		return map;
	}// showOption

	public static void main(String[] args) {

		new ShowBoxForm();
	}

}
