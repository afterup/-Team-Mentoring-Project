package com.firstjava.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JComboBox;

import com.firstjava.model.dao.ClassDAO;
import com.firstjava.model.dao.MemberDAO;
import com.firstjava.model.vo.ClassVO;
import com.firstjava.model.vo.MemberVO;
import com.firstjava.model.vo.MentorVO;
import com.firstjava.model.vo.RegisterVO;
import com.firstjava.view.ClassForm;
import com.firstjava.view.FindForm;
import com.firstjava.view.JoinForm;
import com.firstjava.view.LoginForm;
import com.firstjava.view.MainForm;
import com.firstjava.view.ManagerForm;
import com.firstjava.view.MentorRegForm;
import com.firstjava.view.MentorReviewForm;
import com.firstjava.view.MyPageForm;
import com.firstjava.view.NewclassForm;
import com.firstjava.view.PassChangeForm;
import com.firstjava.view.SearchForm;
import com.firstjava.view.ShowBoxForm;

public class Controller implements ActionListener {
	ClassForm classForm;
	LoginForm loginForm;
	JoinForm joinForm;
	PassChangeForm pChangeForm;
	FindForm findForm;
	MainForm mainForm;
	MentorRegForm mentorRegForm;
	MyPageForm myPageForm;
	MentorReviewForm review;
	ManagerForm managerForm;
	NewclassForm newclassForm;
	NewclassForm updateclassForm;
	ShowBoxForm showBox;
	SearchForm searchForm;

	String loginId;
	int classId;

	public Controller() {

		loginForm = new LoginForm();
		joinForm = new JoinForm();
		pChangeForm = new PassChangeForm();
		classForm = new ClassForm();// 게시글창
		mainForm = new MainForm();
		findForm = new FindForm();
		mentorRegForm = new MentorRegForm();
		myPageForm = new MyPageForm();
		review = new MentorReviewForm();
		managerForm = new ManagerForm();

		newclassForm = new NewclassForm();
		updateclassForm = new NewclassForm();
		showBox = new ShowBoxForm();
		searchForm = new SearchForm();

		eventUp();
	}// 생성자

	private void eventUp() {

		// login
		loginForm.bt_login.addActionListener(this);
		loginForm.tf_pass.addActionListener(this);
		loginForm.bt_cancel.addActionListener(this);
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
				findForm.setVisible(true);
				loginForm.setVisible(false);
			}
		});

		loginForm.la_join.addMouseListener(new MouseAdapter()

		{
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
		mainForm.bt_main.addActionListener(this);
		mainForm.bt_manager.addActionListener(this);
		mainForm.bt_main.addActionListener(this);
		mainForm.bt_mento_class.addActionListener(this);
		// main-mentorForm
		mainForm.bt_search.addActionListener(this);
		mainForm.bt_select.addActionListener(this);
		mainForm.bt_create_class.addActionListener(this);
		mainForm.table.addMouseListener(new MouseAdapter() { // ====JTable 클릭시 게시글창뷰 오픈
			public void mouseClicked(MouseEvent me) {

				ClassDAO dao = new ClassDAO();
				int r = mainForm.table.getSelectedRow();

				if (me.getClickCount() == 1) {
					classForm.controlsetEnabled();
					classForm.bt_new.setVisible(true);

					classId = Integer.parseInt(mainForm.table.getValueAt(r, 0).toString());
					ClassVO vo = dao.searchByNo(classId);
					if (dao.limitCheck(classId)) {
						classForm.limitMember();
					} else {
						classForm.rightMember();
					}

					classForm.tf_name.setText(vo.getCname());
					classForm.tf_close.setText(vo.getCloseDate());
					classForm.tf_close.setText(vo.getCloseDate());
					classForm.tf_open.setText(vo.getOpenDate());
					classForm.tf_student.setText("" + vo.getLimit());
					classForm.ta_desc.setText(vo.getClassinfo());
					classForm.jb_category.setSelectedIndex(vo.getCateno() - 1);

				}
			}
		});

		// joinForm
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

		// pchangeForm
		pChangeForm.bt_submit.addActionListener(this);
		pChangeForm.bt_cancel.addActionListener(this);

		// myPage
		myPageForm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myPageForm.setVisible(false);
				mainForm.setVisible(true);
			}
		});
		myPageForm.bt_my.addActionListener(this);
		myPageForm.bt_class_request.addActionListener(this);
		myPageForm.bt_homepage.addActionListener(this);
		myPageForm.bt_drop_id.addActionListener(this);
		myPageForm.bt_infoUpdate.addActionListener(this);
		myPageForm.bt_pwChange.addActionListener(this);
		myPageForm.bt_menti_request_cancel.addActionListener(this);
		myPageForm.bt_classupdate.addActionListener(this);
		myPageForm.bt_classdelete.addActionListener(this);
		myPageForm.bt_info.addActionListener(this);
		myPageForm.bt_review.addActionListener(this);

		// MentorReviewForm
		review.bt_submit.addActionListener(this);
		review.bt_cancel.addActionListener(this);

		// ManagerForm
		managerForm.bt_search.addActionListener(this);
		managerForm.bt_homepage.addActionListener(this);
		managerForm.bt_all_select.addActionListener(this);
		managerForm.bt_id_search.addActionListener(this);
		managerForm.bt_id_delete.addActionListener(this);

		// ManagerForm-post
		managerForm.bt_p_all_select.addActionListener(this);
		managerForm.bt_p_id_delete.addActionListener(this);
		managerForm.bt_p_id_search.addActionListener(this);
		managerForm.bt_p_info.addActionListener(this);
		managerForm.bt_member.addActionListener(this);
		managerForm.bt_post.addActionListener(this);
		managerForm.bt_mento.addActionListener(this);
		managerForm.bt_agree.addActionListener(this);
		managerForm.bt_disagree.addActionListener(this);
		
		
		
		

		// findForm
		findForm.bt_idView.addActionListener(this);
		findForm.bt_passView.addActionListener(this);
		findForm.bt_findID.addActionListener(this);
		findForm.bt_p_findPass.addActionListener(this);
		findForm.bt_cancel.addActionListener(this);
		findForm.bt_p_cancel.addActionListener(this);

		// NewclassForm
		newclassForm.bt_new.addActionListener(this);
		newclassForm.bt_cancel.addActionListener(this);
		newclassForm.jb_category.addActionListener(this);
		newclassForm.tf_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tf = newclassForm.tf_name.getText();
				if(tf.equals("강의 이름")) {
					newclassForm.tf_name.setText("");
				}
			}
		});
		newclassForm.ta_desc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ta = newclassForm.ta_desc.getText();
				if(ta.equals("400자 이내의 강의 내용을 작성해주세요.")) {
					newclassForm.ta_desc.setText("");
				}
			}
		});

		// MentorRegForm

		// ClassForm
		classForm.bt_cancel.addActionListener(this);
		classForm.bt_new.addActionListener(this);

		// MentorRegForm
		mentorRegForm.bt_submit.addActionListener(this);
		mentorRegForm.bt_cancel.addActionListener(this);
		
		//updateclassForm
		updateclassForm.bt_cancel.addActionListener(this);
		updateclassForm.bt_new.addActionListener(this);
		

		//SearchFrom
		searchForm.cb_columnTitle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox) e.getSource();
				
		        if(!(cb.getSelectedItem().equals("목록"))) {
		        	searchForm.tf_search.setEditable(true);
		        	searchForm.tf_search.setText("");
		        }else {
		        	searchForm.tf_search.setEditable(false);
		        	searchForm.tf_search.setText("목록을 선택해주세요.");
		        }
			}
		});

	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		/*---------------------MainForm(메인페이지)--------------------*/
		if (ob == mainForm.bt_login) { // 로그인 <-> 로그아웃

			if (mainForm.bt_login.getText() == "Login") {
				loginForm.setVisible(true);
			} else {
				mainForm.la_user_id.setText("Welcome!");
				mainForm.bt_login.setText("Login");
				mainForm.bt_manager.setVisible(false);
				loginId = null;
			}

		} else if (ob == mainForm.bt_mypage) { // 마이페이지버튼. 내정보 뿌리기

			MemberDAO dao = new MemberDAO();
			if (loginId == null) {
				showBox.showMsg("로그인 해 주세요");
			} else {

				ArrayList<MemberVO> list = dao.selectMember(loginId);

				for (int i = 0; i < list.size(); i++) {
					MemberVO mVO = list.get(i);
					myPageForm.tf_id.setText(mVO.getUserId());
					myPageForm.tf_name.setText(mVO.getUname());
					myPageForm.tf_email.setText(mVO.getEmail());

					StringTokenizer st = new StringTokenizer(mVO.getPhone(), "-");
					myPageForm.tf_phone1.setText(st.nextToken());
					myPageForm.tf_phone2.setText(st.nextToken());
					myPageForm.tf_phone3.setText(st.nextToken());
				}

				mainForm.setVisible(false);
				myPageForm.setVisible(true);
			}

		} else if (ob == mainForm.bt_mento_demand) { // 멘토신청

			MemberDAO dao = new MemberDAO();
			if (loginId == null) {
				showBox.showMsg("로그인 해 주세요");
			} else if (dao.findMentor(loginId) == 0) {
			} else if (dao.findMentor(loginId) == 0 || dao.findMentor(loginId) == 1) {
				showBox.showMsg("이미 신청하셨습니다.");
			} else {
				mainForm.menuColor("mento");
				mentorRegForm.setVisible(true);
			}

			// mentorForm.bt_search

		} else if (ob == mainForm.bt_manager) {// 관리자페이지 이동버튼

			mainForm.setVisible(false);

			MemberDAO dao = new MemberDAO();
			displayMember(dao.selectAll());
			managerForm.setVisible(true);

		} else if (ob == mainForm.bt_search) { // 검색

			int category = mainForm.cb_category.getSelectedIndex() + 1;
			System.out.println(category);
			ClassDAO dao = new ClassDAO();
			ArrayList<ClassVO> list = dao.search(category);
			displayclass(list);

		} else if (ob == mainForm.bt_select) { // 전체조회

			ClassDAO dao = new ClassDAO();
			displayclass(dao.findAll());

		} else if (ob == mainForm.bt_create_class) {// 강의개설

			if (loginId == null) {
				showBox.showMsg("로그인을 해주세요.");
			} else {

				MemberDAO dao = new MemberDAO();

				if (loginId == null) {
					showBox.showMsg("로그인을 해주세요");
				} else if (dao.findMentor(loginId) != 1) {
					showBox.showMsg("멘토신청 후 승인시 개설 가능합니다.");
				} else {
					newclassForm.setVisible(true);
					newclassForm.initText();
				}
			}

		} else if (ob == mainForm.cb_category) {// 카테고리 검색
			System.out.println("검색");

		} else if (ob == mainForm.bt_main) { // 카드레이아웃_ 메인
			mainForm.card.show(mainForm.panel_lecture, "1");
			mainForm.menuColor("main");

		} else if (ob == mainForm.bt_mento_class) {// 카드레이아웃_ 멘토게시글
			ClassDAO dao = new ClassDAO();
			displayclass(dao.findAll());
			mainForm.menuColor("class");
			mainForm.card.show(mainForm.panel_lecture, "2");

//------------------------- ClassForm --------------------------------
		} else if (ob == classForm.bt_cancel) {// classForm에서 취소버튼 클릭
			classForm.setVisible(false);

		} else if (ob == classForm.bt_new) {// classForm에서 강의신청버튼 클릭
			if (loginId == null) {
				showBox.showMsg("로그인을 해주세요");
			} else {
				ClassDAO dao = new ClassDAO();
				if (dao.registerCheck(classId, loginId) > 0) {
					showBox.showMsg("이미 신청한 강의입니다.");
				} else if (dao.checkMy(classId).equals(loginId)) {
					showBox.showMsg("자신의 강의는 수강할 수 없습니다.");
				} else if (dao.registerClass(classId, loginId)) {
					showBox.showMsg("강의 신청 완료.");

					dao.updateStudent(classId);
					classForm.setVisible(false);
				}
			}

// -------------------ManagerForm(매니저페이지)----------------
		} else if (ob == managerForm.bt_homepage) { // 홈페이지로
			managerForm.setVisible(false);
			mainForm.setVisible(true);

		} else if (ob == managerForm.bt_all_select) {// 회원관리 전체조회
			MemberDAO dao = new MemberDAO();
			displayMember(dao.selectAll());

		} else if (ob == managerForm.bt_id_delete) {// 회원관리 강퇴
			MemberDAO dao = new MemberDAO();
			int row = managerForm.table.getSelectedRow();
			String id = (managerForm.table.getValueAt(row, 0)).toString();
			System.out.println(id);

			if (showBox.showConfirm("강퇴하시겠습니까?") == 0) {
				showBox.showMsg(dao.deleteMember(id));
				displayMember(dao.selectAll());
			}

		} else if (ob == managerForm.bt_search) {// 회원관리 검색

			String category = (String) managerForm.cb_category.getSelectedItem();
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> list = dao.searchMentor(category);
			displayMember(list);

		} else if (ob == managerForm.bt_id_search) {// 회원관리 상세검색

			System.out.println("클릭");
			Map<String, String> map = showBox.showOption();
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> list = dao.searchMember(map);
			displayMember(list);

		} else if (ob == managerForm.bt_p_all_select) {// 게시글관리 전체조회

			ClassDAO dao = new ClassDAO();
			displayclassManager(dao.findAll());

		} else if (ob == managerForm.bt_p_id_search) {// 게시글관리 상세검색

			Map<String, Object> map = searchForm.showOption();

			ClassDAO dao = new ClassDAO();
			// ArrayList<MembershipVO> list = dao.findByName(name);
			ArrayList<ClassVO> list = dao.searchClass(map);
			// 조회된 결과를 뷰(JTable)에 반영
			displayclassManager(list);

		} else if (ob == managerForm.bt_p_id_delete) {// 게시글관리 삭제

			int row = managerForm.p_table.getSelectedRow();
			int id = Integer.parseInt((managerForm.p_table.getValueAt(row, 0)).toString());
			System.out.println(id);
			ClassDAO dao = new ClassDAO();
			if (showBox.showConfirm("정말 삭제하시겠습니까?") == 0) {

				if (dao.delete(id)) {
					showBox.showMsg("삭제성공");
					displayclassManager(dao.findAll());
				} else {

					showBox.showMsg("삭제실패");

				}
			}

		} else if (ob == managerForm.bt_p_info) {// 게시글관리 정보조회
			ClassDAO dao = new ClassDAO();
			int row = managerForm.p_table.getSelectedRow();
			int id = Integer.parseInt(managerForm.p_table.getValueAt(row, 0).toString());
			ClassVO vo = dao.searchByNo(id);

			classForm.tf_name.setText(vo.getCname());
			classForm.tf_close.setText(vo.getCloseDate());
			classForm.tf_open.setText(vo.getOpenDate());
			classForm.tf_student.setText("" + vo.getLimit());
			classForm.ta_desc.setText(vo.getClassinfo());
			classForm.jb_category.setSelectedIndex(vo.getCateno() - 1);

			classForm.controlsetEnabled();
			classForm.bt_new.setVisible(false);

		} else if (ob == managerForm.bt_agree) {// 멘토 승인
			// id랑 confirm

			MemberDAO dao = new MemberDAO();
			int row = managerForm.m_table.getSelectedRow();
			String id = (managerForm.m_table.getValueAt(row, 0)).toString();
			System.out.println(id);
			if (dao.updateMentor("승인", id)) {
				showBox.showMsg("승인완료");
				displayMentor(dao.viewMentor());
			} else {
				showBox.showMsg("승인실패");
			}

		} else if (ob == managerForm.bt_disagree) {
			MemberDAO dao = new MemberDAO();
			int row = managerForm.m_table.getSelectedRow();
			String id = (managerForm.m_table.getValueAt(row, 0)).toString();
			System.out.println(id);
			if (dao.updateMentor("거부", id)) {
				showBox.showMsg("거부완료");
				displayMentor(dao.viewMentor());
			} else {
				showBox.showMsg("거부실패");
			}

		} else if (ob == managerForm.bt_member) {// 카드레이아웃_회원관리
			managerForm.menuColor("member");
			managerForm.card.show(managerForm.panel_lecture, "1");

		} else if (ob == managerForm.bt_post) { // 카드레이아웃_게시글관리
			managerForm.menuColor("post");
			ClassDAO dao = new ClassDAO();
			displayclassManager(dao.findAll());
			managerForm.card.show(managerForm.panel_lecture, "2");
			// bt_p_search, bt_p_all_select, bt_p_info, bt_p_id_search, bt_p_id_delete;

		} else if (ob == managerForm.bt_mento) {// 카드레이아웃_멘토대기
			managerForm.menuColor("mento");
			MemberDAO dao = new MemberDAO();
			displayMentor(dao.viewMentor());

			managerForm.card.show(managerForm.panel_lecture, "3");

			/*----------------------LoginForm(로그인창)--------------------*/
		} else if (ob == loginForm.bt_login || ob == loginForm.tf_pass) { // 로그인 버튼 클릭

			MemberDAO dao = new MemberDAO();

			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());

			if (dao.findLogin(id, pass)) {
				if (!id.equals("admin")) {
					loginId = id;
					loginForm.setVisible(false);
					loginForm.initText();
					mainForm.bt_login.setText("Logout");
					mainForm.la_user_id.setText(id);
				} else {
					loginId = id;
					loginForm.setVisible(false);
					loginForm.initText();
					mainForm.bt_manager.setVisible(true);
					mainForm.bt_login.setText("Logout");
					mainForm.la_user_id.setText(id);
				}

			} else {
				showBox.showMsg("아이디와 비밀번호를 확인해주세요.");
			}

		} else if (ob == loginForm.la_join) { // 회원가입
			joinForm.setVisible(true);

		} else if (ob == loginForm.la_idPassSearch) { // 아이디,비밀번호찾기
			findForm.setVisible(true);

		} else if (ob == loginForm.bt_cancel) {
			loginForm.setVisible(false);

			/*-------------------------JoinForm(회원가입창)--------------------*/
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
				showBox.showMsg("아이디를 영문자 5~12자로 설정해주세요. ");
				joinForm.tf_id.setText("");
				joinForm.tf_id.requestFocus();
				return;
				
				
			} else if (!pwd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).{8,12}$")) {
				showBox.showMsg("비밀번호를 영문자, 숫자, 특수문자의 조합 8~12자로 설정해주세요. ");
				joinForm.tf_pass.setText("");
				joinForm.tf_pass.requestFocus();
				return;

			} else if (!pwd.equals(new String(joinForm.tf_pass2.getPassword()))) {
				showBox.showMsg("비밀번호가 일치하지 않습니다");
				joinForm.tf_pass.setText("");
				joinForm.tf_pass2.setText("");
				joinForm.tf_pass.requestFocus();
				return;
			
			}else if (!name.matches("[ㄱ-힣a-zA-Z]+")) {
				showBox.showMsg("이름확인");
				joinForm.tf_name.setText("");
				joinForm.tf_name.requestFocus();
				return;
			} else if (((!phone1.matches("^[0-9]{2,3}$")) || (!phone2.matches("^[0-9]{2,4}$"))
					|| (!phone3.matches("^[0-9]{2,4}$")))) {
				showBox.showMsg("전화번호 확인");
				return;
			}

			MemberVO vo = new MemberVO(id, pwd, name, email, phone);

			if (dao.joinMember(vo)) {

				showBox.showMsg("가입 성공");

				joinForm.initText();

				joinForm.setVisible(false);
				loginForm.setVisible(true);

			} else {
				showBox.showMsg("다시 확인해주세요.");
			}

		} else if (ob == joinForm.bt_cancel) { // 취소
			joinForm.initText();
			joinForm.setVisible(false);
			loginForm.setVisible(true);

		} else if (ob == joinForm.bt_checkid) {// 중복확인
			checkId();

			/*-----------------------PassChangeForm(비번변경창)--------------------*/
		} else if (ob == pChangeForm.bt_submit) {// 확인버튼
			
			MemberDAO dao = new MemberDAO();
			String oldPass = pChangeForm.tf_oldPass.getText();
			String newPass = pChangeForm.tf_newPass.getText();
			String passCk = pChangeForm.tf_newPassCheck.getText();

			if(oldPass.equals(newPass)) {
				showBox.showMsg("비밀번호가 같습니다. ");
			}
			
			if (!newPass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).{8,12}$")) {
				showBox.showMsg("비밀번호 확인");
				pChangeForm.tf_newPass.setText("");
				pChangeForm.tf_newPassCheck.setText("");
				pChangeForm.tf_newPass.requestFocus();
				return;
			}
			
			if (newPass.equals(passCk)) {
				MemberVO vo = new MemberVO(loginId, oldPass, null, null, null);
				if (dao.updatePass(newPass, vo)) {
					showBox.showMsg("비밀번호 변경 성공 ");
				} else {
					showBox.showMsg("비밀번호 변경 실패 ");
				}
				pChangeForm.tf_oldPass.setText("");
				pChangeForm.tf_newPass.setText("");
				pChangeForm.tf_newPassCheck.setText("");

			} else {
				showBox.showMsg("비밀번호를 확인해주세요. ");
				pChangeForm.tf_newPass.requestFocus();
			}

		} else if (ob == pChangeForm.bt_cancel) {// 취소
			pChangeForm.setVisible(false);

//----------------------FIND FORM(아이디 비밀번호찾기창) --------------------

		} else if (ob == findForm.bt_findID) {// 아이디찾기 버튼
			String name = findForm.tf_name.getText();
			String email = findForm.tf_email.getText();

			MemberDAO dao = new MemberDAO();
			String id = dao.findId(name, email);

			if (id.equals("")) {
				showBox.showMsg("일치하는 정보가 없습니다. ");
			} else {
				showBox.showMsg("당신의 아이디는 " + id + "입니다.");
				findForm.tf_p_id.setText(id);
				findForm.tf_name.setText("");
				findForm.tf_email.setText("");
			}

		} else if (ob == findForm.bt_p_findPass) {// 비밀번호찾기 버튼
			String id = findForm.tf_p_id.getText();
			String name = findForm.tf_p_name.getText();
			String email = findForm.tf_p_email.getText();

			MemberDAO dao = new MemberDAO();
			String pass = dao.findPass(id, name, email);

			if (pass.equals("")) {
				showBox.showMsg("일치하는 정보가 없습니다.");
			} else {
				showBox.showMsg("당신의 비밀번호는 " + pass + "입니다");
				findForm.initText();
				findForm.setVisible(false);
				loginForm.setVisible(true);
			}

		} else if (ob == findForm.bt_idView) {// 카드레이아웃_아이디찾기
			findForm.card.show(findForm.panel_main, "1");
		} else if (ob == findForm.bt_passView) {// 카드레이아웃_비번찾기
			findForm.card.show(findForm.panel_main, "2");
		}

		else if (ob == findForm.bt_cancel) {// 아이디찾기에서 취소
			findForm.initText();
			findForm.setVisible(false);
			loginForm.setVisible(true);

		} else if (ob == findForm.bt_p_cancel) {// 비번찾기에서 취소
			findForm.initText();
			findForm.setVisible(false);
			loginForm.setVisible(true);

//-----------------------MYPAGE FORM(마이페이지)-----------------

		} else if (ob == myPageForm.bt_homepage) {// 홈페이지로
			myPageForm.setVisible(false);
			mainForm.setVisible(true);
		} else if (ob == myPageForm.bt_infoUpdate) {// 내정보_정보변경

			MemberDAO dao = new MemberDAO();
			// 이름, 아이디 변경 불가
			// 전화번호, 이메일만 변경 가능

			String phone = myPageForm.tf_phone1.getText() + "-" + myPageForm.tf_phone2.getText() + "-"
					+ myPageForm.tf_phone3.getText();
			String email = myPageForm.tf_email.getText();
			MemberVO vo = new MemberVO(loginId, null, null, email, phone);
			
			if (dao.updateMember(vo)) {
				showBox.showMsg("정보 변경 완료");
			} else {
				showBox.showMsg("정보 변경 실패");
			}

		} else if (ob == myPageForm.bt_pwChange) {// 내정보_비번변경
			pChangeForm.setVisible(true);

		} else if (ob == myPageForm.bt_drop_id) {// 내정보_탈퇴

			MemberDAO dao = new MemberDAO();
			if (showBox.showConfirm("정말 탈퇴하시겠습니까?") == 0) {
				showBox.showMsg(dao.deleteMember(loginId));
				loginId = null;
				pChangeForm.setVisible(false);
				myPageForm.setVisible(false);
				mainForm.la_user_id.setText("Welcome!");
				mainForm.bt_login.setText("Login");
				mainForm.setVisible(true);
			}
		} else if (ob == myPageForm.bt_review) {// 내강의_평점작성
			int row = myPageForm.table_menti.getSelectedRow();
			classId = (int) myPageForm.table_menti.getValueAt(row, 0);
			String cname = (myPageForm.table_menti.getValueAt(row, 1)).toString();

			if (row < 0) {
				showBox.showMsg("강의를 선택해 주세요. ");
			} else {
				review.tf_class.setText(cname);
				review.tf_class.setEditable(false);
				review.setVisible(true);

				review.cb_score.setSelectedIndex(0);
			}
		}else if(ob==myPageForm.bt_info) {//내강의 정보조회

			ClassDAO dao = new ClassDAO();
			int r = myPageForm.table_menti.getSelectedRow();

			classForm.controlsetEnabled();
			classForm.bt_new.setVisible(true);
			
			classId = Integer.parseInt(myPageForm.table_menti.getValueAt(r, 0).toString());
			ClassVO vo = dao.searchByNo(classId);
			if(dao.limitCheck(classId)) {
				classForm.limitMember();
			}else {
				classForm.rightMember();
			}

			classForm.tf_name.setText(vo.getCname());
			classForm.tf_close.setText(vo.getCloseDate());
			classForm.tf_close.setText(vo.getCloseDate());
			classForm.tf_open.setText(vo.getOpenDate());
			classForm.tf_student.setText("" + vo.getLimit());
			classForm.ta_desc.setText(vo.getClassinfo());
			classForm.jb_category.setSelectedIndex(vo.getCateno() - 1);

		
		}else if(ob==myPageForm.bt_classupdate) {//개설한강의 강의수정

			ClassDAO dao = new ClassDAO();
			int r = myPageForm.table_mentor.getSelectedRow();

			classId = Integer.parseInt(myPageForm.table_mentor.getValueAt(r, 0).toString());
			ClassVO vo = dao.searchByNo(classId);
			classId = vo.getClassno();

			updateclassForm.tf_name.setText(vo.getCname());
			updateclassForm.tf_close.setText(vo.getCloseDate());
			updateclassForm.tf_close.setText(vo.getCloseDate());
			updateclassForm.tf_open.setText(vo.getOpenDate());
			updateclassForm.tf_student.setText("" + vo.getLimit());
			updateclassForm.ta_desc.setText(vo.getClassinfo());
			updateclassForm.jb_category.setSelectedIndex(vo.getCateno() - 1);
			
			updateclassForm.bt_new.setText("수정");
			updateclassForm.setVisible(true);
			
			

		} else if (ob == review.bt_submit) {

			ClassDAO dao = new ClassDAO();
			int classid = classId;
			int rate = Integer.parseInt(review.cb_score.getSelectedItem().toString());

			System.out.println(loginId);
			System.out.println(classid);
			System.out.println(rate);
			if (dao.updateReview(loginId, classid, rate)) {
				showBox.showMsg("평점 작성 완료");
				review.cb_score.setSelectedIndex(0);
				review.setVisible(false);
			}

		} else if (ob == review.bt_cancel) {
			review.cb_score.setSelectedIndex(0);
			review.setVisible(false);

			
		// 신청한 강의 취소 신청
		} else if (ob == myPageForm.bt_menti_request_cancel) {
			int row = myPageForm.table_menti.getSelectedRow();
			classId = (int) myPageForm.table_menti.getValueAt(row, 0);

			MemberDAO dao = new MemberDAO();
			ClassDAO cdao = new ClassDAO();

			if (row < 0) {
				showBox.showMsg("강의를 선택해 주세요. ");
			} else {
				if (cdao.cancelClass(loginId, classId)) {
					showBox.showMsg("신청이 취소되었습니다. ");
					ArrayList<RegisterVO> list = dao.selectRclass(loginId);
					displayRclass(list);
				}

			}

		} else if (ob == myPageForm.bt_classdelete) {

			int row = myPageForm.table_mentor.getSelectedRow();
			classId = (int) myPageForm.table_mentor.getValueAt(row, 0);

			MemberDAO dao = new MemberDAO();
			ClassDAO cdao = new ClassDAO();

			if (row < 0) {
				showBox.showMsg("강의를 선택해 주세요. ");
			} else {
				if (cdao.delete(classId)) {
					showBox.showMsg("삭제되었습니다. ");
					ArrayList<ClassVO> clist = cdao.searchById(loginId);
					displayMclass(clist);
				}
			}
		} else if (ob == review.bt_cancel) {
			review.setVisible(false);

		} else if (ob == myPageForm.bt_my) {// 카드레이아웃_내정보
			myPageForm.menuColor("mydata");
			myPageForm.card.show(myPageForm.panel_my_page, "1");

			
			
			
		} else if (ob == myPageForm.bt_class_request) {// 카드레이아웃_내강의
			myPageForm.menuColor("class");
			myPageForm.card.show(myPageForm.panel_my_page, "2");

			// 신청한 강의
			MemberDAO dao = new MemberDAO();
			ArrayList<RegisterVO> list = dao.selectRclass(loginId);
			displayRclass(list);

			// 개설한 강의
			ClassDAO cdao = new ClassDAO();
			ArrayList<ClassVO> clist = cdao.searchById(loginId);
			displayMclass(clist);

			
			
			
			
		} else if (ob == myPageForm.bt_my) {// 카드레이아웃_내정보
			myPageForm.menuColor("mydata");
			myPageForm.card.show(myPageForm.panel_my_page, "my");

//------------------------NewclassForm FORM(강의개설페이지)-----------------
		} else if (ob == newclassForm.bt_new) {// 강의개설
			ClassDAO dao = new ClassDAO();

			String cname = newclassForm.tf_name.getText();
			int max = Integer.parseInt(newclassForm.tf_student.getText());
			String open = newclassForm.tf_open.getText();
			String close = newclassForm.tf_close.getText();
			String classinfo = newclassForm.ta_desc.getText();
			String category = newclassForm.jb_category.getSelectedItem().toString();

			Map<String, Integer> map = new HashMap<>();
			map.put("IT", 1);
			map.put("디자인", 2);
			map.put("뷰티", 3);
			map.put("외국어", 4);
			map.put("음악", 5);
			map.put("라이프", 6);

			ClassVO vo = new ClassVO(0, loginId, classinfo, map.get(category), cname, open, close, 0, max);

			if (dao.createClass(vo)) {
				showBox.showMsg("강의개설");
				newclassForm.initText();
				displayclass(dao.findAll());
				newclassForm.setVisible(false);
				mainForm.setVisible(true);
			} else {
				showBox.showMsg("생성실패");
			}

		} else if (ob == newclassForm.bt_cancel) {
			newclassForm.setVisible(false);

//=============mentorRegForm(멘토신청 폼)=========================
		} else if (ob == mentorRegForm.bt_submit) {// 신청

			if (showBox.showConfirm("신청하시겠습니까?") == 0) {
				MentorVO m = new MentorVO(loginId, mentorRegForm.tf_job.getText(), mentorRegForm.tf_license.getText(),
						mentorRegForm.tf_major.getText(), mentorRegForm.ta_plan.getText(), "대기");
				MemberDAO dao = new MemberDAO();
				dao.mentorRequest(m);
				showBox.showMsg("신청되셨습니다.");
				mentorRegForm.initText();
				mainForm.menuColor("mentoOut");
				mentorRegForm.setVisible(false);
			}

		} else if (ob == mentorRegForm.bt_cancel) {// 취소
			mainForm.menuColor("mentoOut");
			mentorRegForm.initText();
			mentorRegForm.setVisible(false);
//===========updateclassForm(마이페이지에서 내강의 수정)=================
		}else if(ob==updateclassForm.bt_new) {

			Map<String, Integer> map = new HashMap<>();
			map.put("IT", 1);
			map.put("디자인", 2);
			map.put("뷰티", 3);
			map.put("외국어", 4);
			map.put("음악", 5);
			map.put("라이프", 6);
			
			String category=updateclassForm.jb_category.getSelectedItem().toString();
			
			ClassVO vo = new ClassVO(classId,"",updateclassForm.ta_desc.getText(),map.get(category)
					,updateclassForm.tf_name.getText(),updateclassForm.tf_open.getText(),updateclassForm.tf_close.getText(),0,Integer.parseInt(updateclassForm.tf_student.getText()));
			ClassDAO dao = new ClassDAO();

			if(dao.updateClass(vo)) {
				showBox.showMsg("수정완료");
				updateclassForm.setVisible(false);
			}else {
				showBox.showMsg("수정실패");
			}
			
			
			
		}else if(ob==updateclassForm.bt_cancel) {
			updateclassForm.setVisible(false);
		}
		
	}// actionPerformed

	public void checkId() {
		MemberDAO dao = new MemberDAO();
		String id = joinForm.tf_id.getText();
		if (dao.findExistId(id) == 1) {
			showBox.showMsg("이미 사용중인 아이디입니다.");
		} else {
			showBox.showMsg("사용가능한 아이디입니다.");
		}
	}// checkId

	public void displayclass(ArrayList<ClassVO> list) {

		mainForm.dtm.setRowCount(0);

		Map<String, String> map = new HashMap<>();
		map.put("1", "IT");
		map.put("2", "디자인");
		map.put("3", "뷰티");
		map.put("4", "외국어");
		map.put("5", "음악");
		map.put("6", "라이프");

		for (int i = 0; i < list.size(); i++) {

			ClassVO vo = list.get(i);
			Object[] rowData = { vo.getClassno(), map.get(String.valueOf(vo.getCateno())), vo.getCname(),
					vo.getOpenDate(), vo.getCloseDate() };
			mainForm.dtm.addRow(rowData);

		}

	}// Displayclass

	public void displayMember(ArrayList<MemberVO> list) {

		managerForm.dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {
			MemberVO vo = list.get(i);
			Object[] rowData = { vo.getUserId(), vo.getUname(), vo.getEmail(), vo.getPhone() };
			managerForm.dtm.addRow(rowData);
		}

		// JScrollBar bar= scroll_table.getVerticalScrollBar();
		// bar.setValue(bar.getMaximum());

	}// displayMember

	public void displayclassManager(ArrayList<ClassVO> list) {

		managerForm.p_dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			ClassVO vo = list.get(i);
			Object[] rowData = { vo.getClassno(), vo.getCname(), vo.getClassinfo(), vo.getOpenDate(), vo.getCloseDate(),
					vo.getUserid(), vo.getStudent(), vo.getLimit() };
			managerForm.p_dtm.addRow(rowData);

		}

	}// displayTable

	public void displayMentor(ArrayList<MentorVO> list) {

		managerForm.m_dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {

			MentorVO vo = list.get(i);
			Object[] rowData = { vo.getUserid(), vo.getJob(), vo.getMajor(), vo.getLicense(), vo.getPlan(),
					vo.getConfirm() };
			managerForm.m_dtm.addRow(rowData);

		}

	}// displayTable

	public void displayRclass(ArrayList<RegisterVO> list) {
		// 신청한 강의

		myPageForm.dtm_menti.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {
			RegisterVO vo = list.get(i);
			Object[] rowData = { vo.getClassno(), vo.getCname(), vo.getMentor(), vo.getRate() };
			myPageForm.dtm_menti.addRow(rowData);

		}
	}

	public void displayMclass(ArrayList<ClassVO> clist) {
		// 신청한 강의

		myPageForm.dtm_mentor.setRowCount(0);
//		if(clist.size())
		for (int i = 0; i < clist.size(); i++) {
			ClassVO cvo = clist.get(i);
			Object[] rowData = {cvo.getClassno(), cvo.getCname()};
			myPageForm.dtm_mentor.addRow(rowData);
		}
	}

	public static void main(String[] args) {
		new Controller();
	}

}