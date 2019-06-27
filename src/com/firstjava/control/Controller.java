package com.firstjava.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.firstjava.model.dao.MemberDAO;
import com.firstjava.model.vo.MemberVO;
import com.firstjava.view.ClassForm;
import com.firstjava.view.FindForm;
import com.firstjava.view.JoinForm;
import com.firstjava.view.LoginForm;
import com.firstjava.view.MainForm;
import com.firstjava.view.ManagerForm;
import com.firstjava.view.MentorRegForm;
import com.firstjava.view.MentorRequest;
import com.firstjava.view.MentorReviewForm;
import com.firstjava.view.MyPage;
import com.firstjava.view.PassChangeForm;

public class Controller implements ActionListener {
	ClassForm classForm;
	LoginForm loginForm;
	JoinForm joinForm;
	PassChangeForm pChangeForm;
	FindForm findForm;
	MainForm mainForm;
	MentorRegForm mentorRegForm;
	MyPage myPage;
	MentorReviewForm review;
	MentorRequest request;
	ManagerForm managerForm;
	
	String loginId;

	public Controller() {

		loginForm = new LoginForm();
		joinForm = new JoinForm();
		pChangeForm = new PassChangeForm();
		classForm = new ClassForm();
		mainForm = new MainForm();
		findForm = new FindForm();
		mentorRegForm = new MentorRegForm();
		myPage = new MyPage();
		review = new MentorReviewForm();
		request = new MentorRequest();
		managerForm = new ManagerForm();
		
		eventUp();
	}// 생성자

	private void eventUp() {

		loginForm.bt_login.addActionListener(this);

		loginForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				loginForm.setVisible(false);
				mainForm.setVisible(true);
			}
		});

		loginForm.la_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinForm.initText();
				joinForm.setVisible(true);
				loginForm.setVisible(false);
			}
		});

		loginForm.la_idPassSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Click");
			}
		});

		// login
		loginForm.la_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				joinForm.initText();
				joinForm.setVisible(true);
				loginForm.setVisible(false);
			}
		});

		// mainForm
		mainForm.bt_login.addActionListener(this);
		mainForm.bt_mypage.addActionListener(this);
		mainForm.bt_mento_demand.addActionListener(this);
		mainForm.bt_user_photo.addActionListener(this);
		mainForm.bt_main.addActionListener(this);
		mainForm.bt_mento_class.addActionListener(this);
		mainForm.bt_manager.addActionListener(this);

		// main-mentorForm
		mainForm.bt_search.addActionListener(this);
		mainForm.bt_select.addActionListener(this);
		mainForm.bt_create_class.addActionListener(this);
		mainForm.bt_class_delete.addActionListener(this);
		mainForm.bt_class_data.addActionListener(this);
		mainForm.cb_category.addActionListener(this);

		// classForm

		// join
		joinForm.bt_submit.addActionListener(this);
		joinForm.bt_cancel.addActionListener(this);
		joinForm.bt_checkid.addActionListener(this);

		joinForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				joinForm.setVisible(false);
				loginForm.setVisible(true);
				mainForm.setVisible(true);

			}
		});

		// idPassSearch
		loginForm.la_idPassSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findForm.setVisible(true);
				loginForm.setVisible(false);
			}
		});

		// pchangeForm
		pChangeForm.bt_submit.addActionListener(this);
		pChangeForm.bt_cancel.addActionListener(this);
		
		//myPage
		myPage.bt_drop_id.addActionListener(this);
		myPage.bt_menti_request.addActionListener(this);
		myPage.bt_mentor_request.addActionListener(this);
		myPage.bt_my.addActionListener(this);
		myPage.bt_mypage.addActionListener(this);
		myPage.bt_reset.addActionListener(this);
		myPage.bt_submit.addActionListener(this);
		
		//request
		request.bt_renew.addActionListener(this);
		request.bt_request_cancel.addActionListener(this);
		request.bt_search.addActionListener(this);
		request.bt_select.addActionListener(this);
		
		//ManagerForm
		managerForm.bt_search.addActionListener(this);
		managerForm.bt_homepage.addActionListener(this);
		managerForm.bt_all_select.addActionListener(this);
		managerForm.bt_id_search.addActionListener(this);
		managerForm.bt_id_delete.addActionListener(this);
		managerForm.bt_info.addActionListener(this);
		//ManagerForm-post
		managerForm.bt_p_all_select.addActionListener(this);
		managerForm.bt_p_id_delete.addActionListener(this);
		managerForm.bt_p_id_search.addActionListener(this);
		managerForm.bt_p_info.addActionListener(this);
		managerForm.bt_p_search.addActionListener(this);
		
		// bt_home , 
		
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		// bt_mypage, bt_mento_demand, bt_user_photo, bt_main, bt_mento_class
		/*-------------mainForm--------------------*/
		if (ob == mainForm.bt_login) { // 로그인 <-> 로그아웃

			if (mainForm.bt_login.getText() == "Login") {
				loginForm.setVisible(true);
			} else {
				System.out.println("로그아웃");
				mainForm.la_user_id.setText("Welcome");
				mainForm.bt_login.setText("Login");
			}
		
		} else if(ob == mainForm.bt_mypage) {
//			if(mainForm.bt_login == "")
			
			
			
			// } else if (ob == mainForm.bt_main) {// 메인

			// } else if (ob == mainForm.bt_mento_class) {// 멘토강의

		} else if (ob == mainForm.bt_user_photo) {// 이미지수정

		} else if (ob == mainForm.bt_mento_demand) { // 멘토신청

			mentorRegForm.setVisible(true);

			// mentorForm.bt_search
		
		}else if(ob == mainForm.bt_manager) {// 임시 관리자페이지 이동버튼
			
			mainForm.setVisible(false);
			
			MemberDAO dao = new MemberDAO();
			managerForm.memberDisplayTable(dao.MemberTable());
			managerForm.setVisible(true);
			
		/*-------------main_mentorForm--------------------*/
		} else if (ob == mainForm.bt_search) { // 검색

			System.out.println("검색");

		} else if (ob == mainForm.bt_select) { // 전체조회

			System.out.println("검색");
		} else if (ob == mainForm.bt_create_class) {// 강의개설

			System.out.println("반응");

			classForm.setVisible(true);

		} else if (ob == mainForm.bt_class_delete) {// 강의삭제
			System.out.println("검색");

		} else if (ob == mainForm.bt_class_data) {// 수강정보
			System.out.println("검색");

		} else if (ob == mainForm.cb_category) { // 멘토신청
			System.out.println("검색");
		//------------------ManagerForm(매니저창)----------------
		
		} else if(ob == managerForm.bt_homepage) { //홈페이지로
			managerForm.setVisible(false);
			mainForm.setVisible(true);
		} else if(ob == managerForm.bt_all_select) {//전체조회
			MemberDAO dao = new MemberDAO();
			managerForm.memberDisplayTable(dao.MemberTable());
		} else if(ob== managerForm.bt_id_delete) {//강퇴
			MemberDAO dao = new MemberDAO();
			int row = managerForm.table.getSelectedRow();
			String name = (managerForm.table.getValueAt(row, 0)).toString();
			
			if(managerForm.confirmMsg("강퇴하시겠습니까?")) {
				managerForm.showMsg(dao.memberDelete(name));
				managerForm.memberDisplayTable(dao.MemberTable());
			}
			
	
	    /*-------------LoginForm(로그인창)--------------------*/
		} else if (ob == loginForm.bt_login) { // 로그인 버튼 클릭

			MemberDAO dao = new MemberDAO();

			String id = loginForm.tf_id.getText();
			loginId = id;
			String pass = new String(loginForm.tf_pass.getPassword());

			if (dao.findLogin(id, pass)) {
				loginId = id;
				loginForm.showMsg("로그인 성공!");
				loginForm.setVisible(false);
				loginForm.initText();
				mainForm.bt_login.setText("Logout");
				mainForm.la_user_id.setText(id);
			} else {
				loginForm.showMsg("아이디와 비밀번호를 확인해주세요!!");
			}

		} else if (ob == loginForm.la_join) { // 회원가입

			joinForm.setVisible(true);

		} else if (ob == loginForm.la_idPassSearch) { // 아이디,비밀번호찾기

			findForm.setVisible(true);

		/*-------------JoinForm(회원가입창)--------------------*/
		} else if (ob == joinForm.bt_submit) { // 가입 등록
			MemberDAO dao = new MemberDAO();

			String id = joinForm.tf_id.getText();
			String pwd = new String(joinForm.tf_pass.getPassword());
			String name = joinForm.tf_name.getText();

			String phone1 = joinForm.tf_phone1.getText();
			String phone2 = joinForm.tf_phone2.getText();
			String phone3 = joinForm.tf_phone3.getText();
			String phone = phone1 + "-" + phone2 + "-" + phone3;

			String email = joinForm.tf_email.getText();

			if (!id.matches("^[a-zA-Z]{5,12}+$")) {
				joinForm.showMsg("아이디 확인");
				joinForm.tf_id.setText("");
				joinForm.tf_id.requestFocus();
				return;
			} else if (!pwd.matches("[\\d]+")) {
				joinForm.showMsg("비밀번호 확인");
				joinForm.tf_pass.setText("");
				joinForm.tf_pass.requestFocus();
				return;

			} else if (!pwd.equals(new String(joinForm.tf_pass2.getPassword()))) {
				joinForm.showMsg("비밀번호가 일치하지 않습니다");
				joinForm.tf_pass.setText("");
				joinForm.tf_pass2.setText("");
				joinForm.tf_pass.requestFocus();
				return;
			} else if (!name.matches("[ㄱ-힣a-zA-Z]+")) {
				joinForm.showMsg("이름확인");
				joinForm.tf_name.setText("");
				joinForm.tf_name.requestFocus();
				return;
			} else if (((!phone1.matches("^[0-9]{2,3}$")) || (!phone2.matches("^[0-9]{2,4}$"))
					|| (!phone3.matches("^[0-9]{2,4}$")))) {
				joinForm.showMsg("전화번호 확인");
				return;
			}

			MemberVO vo = new MemberVO(id, pwd, name, email, phone);

			if (dao.memberJoin(vo)) {

				joinForm.showMsg("가입 성공");

				joinForm.initText();

				joinForm.setVisible(false);
				loginForm.setVisible(true);

			} else {
				joinForm.showMsg("다시 확인해주세요.");
			}

		} else if (ob == joinForm.bt_cancel) { // 취소

			joinForm.initText();

		} else if (ob == joinForm.bt_checkid) {// 중복확인
			checkId();

		/*-------------PassChangeForm(비번변경창)--------------------*/
		} else if (ob == pChangeForm.bt_submit) {

		} else if (ob == pChangeForm.bt_cancel) {

		}

	}
	

	public void checkId() {
		System.out.println("checkId()");
		MemberDAO dao = new MemberDAO();
		String id = joinForm.tf_id.getText();
		if (dao.findExistId(id) == 1) {
			joinForm.showMsg("이미 사용중인 아이디입니다!!");
		} else {
			joinForm.showMsg("사용가능한 아이디입니다!!");
			if (joinForm.showConfirm("이 아이디를 사용하시겠습니까?") == 0) {
				joinForm.tf_id.setText(id);
			}
		}
	}// checkId

	public static void main(String[] args) {
		new Controller();
	}

}