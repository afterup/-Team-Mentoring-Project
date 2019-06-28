package com.firstjava.control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTable;

import com.firstjava.model.dao.ClassDAO;
import com.firstjava.model.dao.MemberDAO;
import com.firstjava.model.vo.ClassVO;
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
	ClassForm postForm;
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

		postForm = new ClassForm();//게시글창

		
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
		mainForm.bt_manager.addActionListener(this);
		mainForm.bt_main.addActionListener(this);
		mainForm.bt_mento_class.addActionListener(this);

		// main-mentorForm
		mainForm.bt_search.addActionListener(this);
		mainForm.bt_select.addActionListener(this);
		mainForm.bt_create_class.addActionListener(this);
		mainForm.bt_class_delete.addActionListener(this);
		
		mainForm.bt_class_update.addActionListener(this);
		mainForm.table.addMouseListener(new MouseAdapter() { // ====JTable 클릭시 게시글창뷰 오픈
			public void mouseClicked(MouseEvent me) {
				JTable table = (JTable)me.getSource();
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				if(me.getClickCount()==1) {
					postForm.controlsetEnabled();
				}
			}
		});

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

		// myPage
		myPage.bt_drop_id.addActionListener(this);
		myPage.bt_menti_request.addActionListener(this);
		myPage.bt_mentor_request.addActionListener(this);
		myPage.bt_my.addActionListener(this);
		myPage.bt_mypage.addActionListener(this);
		myPage.bt_reset.addActionListener(this);
		myPage.bt_submit.addActionListener(this);

		// request
		request.bt_renew.addActionListener(this);
		request.bt_request_cancel.addActionListener(this);
		request.bt_search.addActionListener(this);
		request.bt_select.addActionListener(this);

		// ManagerForm
		managerForm.bt_search.addActionListener(this);
		managerForm.bt_homepage.addActionListener(this);
		managerForm.bt_all_select.addActionListener(this);
		managerForm.bt_id_search.addActionListener(this);
		managerForm.bt_id_delete.addActionListener(this);
		managerForm.bt_info.addActionListener(this);
		// ManagerForm-post
		managerForm.bt_p_all_select.addActionListener(this);
		managerForm.bt_p_id_delete.addActionListener(this);
		managerForm.bt_p_id_search.addActionListener(this);
		managerForm.bt_p_info.addActionListener(this);
		managerForm.bt_p_search.addActionListener(this);
		managerForm.bt_member.addActionListener(this);
		managerForm.bt_post.addActionListener(this);

		// bt_home ,

		findForm.bt_idView.addActionListener(this);
		findForm.bt_passView.addActionListener(this);
		findForm.bt_findID.addActionListener(this);
		findForm.bt_p_findPass.addActionListener(this);
		findForm.bt_cancel.addActionListener(this);
		findForm.bt_p_cancel.addActionListener(this);

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

		} else if (ob == mainForm.bt_mypage) {
			
			mainForm.setVisible(false);
			myPage.setVisible(true);
			
//			if(mainForm.bt_login == "")

			// } else if (ob == mainForm.bt_main) {// 메인

		} else if (ob == mainForm.bt_user_photo) {// 이미지수정
			
		} else if (ob == mainForm.bt_mento_demand) { // 멘토신청

			mentorRegForm.setVisible(true);

			// mentorForm.bt_search

		} else if (ob == mainForm.bt_manager) {// 임시 관리자페이지 이동버튼

			mainForm.setVisible(false);

			MemberDAO dao = new MemberDAO();
			managerForm.memberDisplayTable(dao.MemberTable());
			managerForm.setVisible(true);

		} else if (ob == mainForm.bt_search) { // 검색
			
			
			System.out.println("검색");
			
			String category = (String) mainForm.cb_category.getSelectedItem();
			
		    ClassDAO dao = new ClassDAO();
		    
		    ArrayList<ClassVO> list = dao.search(category);
		    mainForm.displayTable(list);
			
			
		} else if (ob == mainForm.bt_select) { // 전체조회

		    ClassDAO dao = new ClassDAO();
		    mainForm.displayTable(dao.findAll());
			
		} else if (ob == mainForm.bt_create_class) {// 강의개설

			classForm.setVisible(true);

		} else if (ob == mainForm.bt_class_delete) {// 강의삭제
			
			String str = mainForm.showInput("삭제할 강의 NO는? ");

			int no = Integer.parseInt(str);
			
			ClassDAO dao = new ClassDAO();
			
			if(mainForm.showConfirm("정말 삭제하시겠습니까?")==0) {

				if (dao.delete(no)) {
	
					mainForm.showMsg("삭제성공!!");
					mainForm.displayTable(dao.findAll());
	
				} else {
	
					mainForm.showMsg("삭제실패!!");
	
				}
			}
			
			

		} else if (ob == mainForm.bt_class_update) {// 강의수정
			System.out.println("수정");

		} else if (ob == mainForm.cb_category) { // 멘토신청
			System.out.println("검색");
			
			
		} else if (ob == mainForm.bt_main) {
			mainForm.card.show(mainForm.panel_lecture,"1");
			System.out.println("3");
		} else if (ob == mainForm.bt_mento_class) {
		    ClassDAO dao = new ClassDAO();
		    mainForm.displayTable(dao.findAll());
		    mainForm.card.show(mainForm.panel_lecture,"2");
// ------------------ManagerForm(매니저창)----------------

		} else if (ob == managerForm.bt_homepage) { // 홈페이지로
			managerForm.setVisible(false);
			mainForm.setVisible(true);
		} else if (ob == managerForm.bt_all_select) {// 전체조회
			MemberDAO dao = new MemberDAO();
			managerForm.memberDisplayTable(dao.MemberTable());
		} else if (ob == managerForm.bt_id_delete) {// 강퇴
			MemberDAO dao = new MemberDAO();
			int row = managerForm.table.getSelectedRow();
			String name = (managerForm.table.getValueAt(row, 0)).toString();

			if (managerForm.confirmMsg("강퇴하시겠습니까?")) {
				managerForm.showMsg(dao.memberDelete(name));
				managerForm.memberDisplayTable(dao.MemberTable());
			}
		}else if (ob == managerForm.bt_member) {
			managerForm.card.show(managerForm.panel_lecture, "1");
		}else if (ob == managerForm.bt_post) {
			managerForm.card.show(managerForm.panel_lecture, "2");
			
/*------------------LoginForm(로그인창)--------------------*/
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

/*-------------------JoinForm(회원가입창)--------------------*/
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

/*--------------------PassChangeForm(비번변경창)--------------------*/
		} else if (ob == pChangeForm.bt_submit) {

		} else if (ob == pChangeForm.bt_cancel) {

//--------------------FIND FORM(아이디 비밀번호찾기창) --------------------

		} else if (ob == findForm.bt_findID) {
			String name = findForm.tf_name.getText();
			String email = findForm.tf_email.getText();
			MemberDAO dao = new MemberDAO();
			String id = dao.findId(name, email);

			if (id.equals("")) {
				findForm.showMsg("일치하는 정보가 없습니다. " );

			} else {

				findForm.showMsg("당신의 아이디는 " + id + "입니다!!");
			}



		} else if (ob == findForm.bt_p_findPass) {
			String id = findForm.tf_p_id.getText();
			String name = findForm.tf_p_name.getText();
			String email = findForm.tf_p_email.getText();
			
			MemberDAO dao = new MemberDAO();
			String pass = dao.findPass(id, name, email);
			
			if(pass.equals("")) {
				findForm.showMsg("일치하는 정보가 없습니다.");
			}else {
				findForm.showMsg("당신의 비밀번호는 "+pass+"입니다");
			}
			

		}else if (ob == findForm.bt_idView) {
			findForm.card.show(findForm.panel_main,"1");
		}else if (ob == findForm.bt_passView) {
			findForm.card.show(findForm.panel_main,"2");
		}
		
		
		else if (ob == findForm.bt_cancel) {
		
		} else if (ob == findForm.bt_p_cancel) {

			
			
//-------------------MYPAGE FORM(마이페이지)-----------------
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