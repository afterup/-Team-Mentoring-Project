package com.firstjava.control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import com.firstjava.view.MyPageForm;
import com.firstjava.view.NewclassForm;
import com.firstjava.view.PassChangeForm;
import com.firstjava.view.ShowBoxForm;

public class Controller implements ActionListener
{
	ClassForm classForm;
	LoginForm loginForm;
	JoinForm joinForm;
	PassChangeForm pChangeForm;
	FindForm findForm;
	MainForm mainForm;
	MentorRegForm mentorRegForm;
	MyPageForm myPageForm;
	MentorReviewForm review;
	MentorRequest request;
	ManagerForm managerForm;
	NewclassForm newclassForm;
	ShowBoxForm showBox;

	String loginId;

	public Controller()
	{

		loginForm = new LoginForm();
		joinForm = new JoinForm();
		pChangeForm = new PassChangeForm();
		classForm = new ClassForm();//게시글창
		mainForm = new MainForm();
		findForm = new FindForm();
		mentorRegForm = new MentorRegForm();
		myPageForm = new MyPageForm();
		review = new MentorReviewForm();
		request = new MentorRequest();
		managerForm = new ManagerForm();

		newclassForm = new NewclassForm();
		showBox = new ShowBoxForm();

		eventUp();
	}// 생성자

	private void eventUp()
	{

		// login
		loginForm.bt_login.addActionListener(this);
		loginForm.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				loginForm.setVisible(false);
				mainForm.setVisible(true);
			}
		});
		loginForm.la_join.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				joinForm.initText();
				joinForm.setVisible(true);
				loginForm.setVisible(false);
			}
		});
		loginForm.la_idPassSearch.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				findForm.setVisible(true);
				loginForm.setVisible(false);
			}
		});

		loginForm.la_join.addMouseListener(new MouseAdapter()

		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
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
		mainForm.table.addMouseListener(new MouseAdapter()
		{ // ====JTable 클릭시 게시글창뷰 오픈
			public void mouseClicked(MouseEvent me)
			{
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				
				ClassDAO dao = new ClassDAO();
				int r = mainForm.table.getSelectedRow();
				
				if (me.getClickCount() == 1) {
					classForm.controlsetEnabled();
					
					ClassVO vo = dao.searchByNo(Integer.parseInt(mainForm.table.getValueAt(r,0).toString()));
					
					classForm.tf_name.setText(vo.getCname());
					classForm.tf_close.setText(vo.getCloseDate());
					classForm.tf_open.setText(vo.getOpenDate());
					classForm.tf_student.setText("" +vo.getLimit());
					classForm.ta_desc.setText(vo.getClassinfo());
					classForm.jb_category.setSelectedIndex(vo.getCateno());					
				}
			}
		});

		// joinForm
		joinForm.bt_submit.addActionListener(this);
		joinForm.bt_cancel.addActionListener(this);
		joinForm.bt_checkid.addActionListener(this);
		joinForm.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				joinForm.setVisible(false);
				loginForm.setVisible(true);
				mainForm.setVisible(true);
			}
		});

		// pchangeForm
		pChangeForm.bt_submit.addActionListener(this);
		pChangeForm.bt_cancel.addActionListener(this);

		// myPage
		myPageForm.bt_drop_id.addActionListener(this);
		myPageForm.bt_my.addActionListener(this);
		myPageForm.bt_class_request.addActionListener(this);
		myPageForm.bt_pwChange.addActionListener(this);
		myPageForm.bt_infoUpdate.addActionListener(this);
		myPageForm.bt_homepage.addActionListener(this);
		myPageForm.bt_review.addActionListener(this);

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
		managerForm.p_table.addMouseListener(new MouseAdapter()
		{ // ====JTable 클릭시 게시글창뷰 오픈
			public void mouseClicked(MouseEvent me)
			{
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				if (me.getClickCount() == 1) {
					classForm.controlsetEnabled();
				}
			}
		});
		// ManagerForm-post
		managerForm.bt_p_all_select.addActionListener(this);
		managerForm.bt_p_id_delete.addActionListener(this);
		managerForm.bt_p_id_search.addActionListener(this);
		managerForm.bt_p_info.addActionListener(this);
		managerForm.bt_p_search.addActionListener(this);
		managerForm.bt_member.addActionListener(this);
		managerForm.bt_post.addActionListener(this);
		managerForm.bt_mento.addActionListener(this);

		// findForm
		findForm.bt_idView.addActionListener(this);
		findForm.bt_passView.addActionListener(this);
		findForm.bt_findID.addActionListener(this);
		findForm.bt_p_findPass.addActionListener(this);
		findForm.bt_cancel.addActionListener(this);
		findForm.bt_p_cancel.addActionListener(this);

		//NewclassForm
		newclassForm.bt_new.addActionListener(this);
		newclassForm.jb_category.addActionListener(this);
		newclassForm.tf_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newclassForm.tf_name.setText("");
			}
		});
		newclassForm.ta_desc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newclassForm.ta_desc.setText("");
			}
		});
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object ob = e.getSource();

		/*---------------------MainForm(메인페이지)--------------------*/
		if (ob == mainForm.bt_login) { // 로그인 <-> 로그아웃

			if (mainForm.bt_login.getText() == "Login") {
				loginForm.setVisible(true);
			} else {
				mainForm.la_user_id.setText("Welcome!");
				mainForm.bt_login.setText("Login");
				loginId = null;
			}

		} else if (ob == mainForm.bt_mypage) {

			MemberDAO dao = new MemberDAO();
			if (loginId == null) {
				showBox.showMsg("로그인해주세요.");
			} else {

				myPageForm.showInfo(dao.mypageMember(loginId));
				myPageForm.tf_id.setEnabled(false);
				myPageForm.tf_name.setEnabled(false);
			
			String id = mainForm.la_user_id.getText();
			
			if(id.equals("Welcome!")) {
				showBox.showMsg("로그인이 필요합니다!!");
			}else {
			
			myPageForm.showInfo(dao.mypageMember(loginId));
			myPageForm.tf_id.setEnabled(false);
			myPageForm.tf_name.setEnabled(false);
			
			mainForm.setVisible(false);
			myPageForm.setVisible(true);
			}
//			if(mainForm.bt_login == "")

				mainForm.setVisible(false);
				myPageForm.setVisible(true);
			}

		} else if (ob == mainForm.bt_mento_demand) { // 멘토신청

			mentorRegForm.setVisible(true);
			if(loginId == null) {
				showBox.showMsg("로그인이 필요합니다!!");
			}else {
				mentorRegForm.setVisible(true);
			}
			// mentorForm.bt_search

		} else if (ob == mainForm.bt_manager) {// 관리자페이지 이동버튼

			mainForm.setVisible(false);

			MemberDAO dao = new MemberDAO();
			managerForm.memberDisplayTable(dao.MemberTable());
			managerForm.setVisible(true);

		} else if (ob == mainForm.bt_search) { // 검색

			String category = (String) mainForm.cb_category.getSelectedItem();

			ClassDAO dao = new ClassDAO();
			ArrayList<ClassVO> list = dao.search(category);
			mainForm.classDisplayTable(list);

		} else if (ob == mainForm.bt_select) { // 전체조회

			ClassDAO dao = new ClassDAO();
			mainForm.classDisplayTable(dao.findAll());

		} else if (ob == mainForm.bt_create_class) {// 강의개설

			newclassForm.setVisible(true);
			/*
			 } else if (ob == mainForm.bt_class_delete) {// 강의삭제
				  String str = mainForm.showInput("삭제할 강의 NO는? ");
				  int no = Integer.parseInt(str);
				  ClassDAO dao = new ClassDAO();
				  if(mainForm.showConfirm("정말 삭제하시겠습니까?")==0) {
				  if (dao.delete(no)) {
				  mainForm.showMsg("삭제성공!!"); mainForm.classDisplayTable(dao.findAll());
			  } else {
			  	mainForm.showMsg("삭제실패!!");
			  } }  
			 */

		} else if (ob == mainForm.cb_category) { // 멘토신청
			System.out.println("검색");

		} else if (ob == mainForm.bt_main) { //카드레이아웃_ 메인
			mainForm.card.show(mainForm.panel_lecture, "1");

		} else if (ob == mainForm.bt_mento_class) {//카드레이아웃_ 멘토게시글
			ClassDAO dao = new ClassDAO();
			mainForm.classDisplayTable(dao.findAll());
			mainForm.card.show(mainForm.panel_lecture, "2");

// -------------------ManagerForm(매니저페이지)----------------
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
				showBox.showMsg(dao.memberDelete(name));
				managerForm.memberDisplayTable(dao.MemberTable());
			}

		} else if (ob == managerForm.bt_id_search) {

			System.out.println("클릭");
			Map<String, String> map = showBox.showOption();
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> list = dao.findSearch(map);
			managerForm.memberDisplayTable(list);
			showBox.showOption();

		} else if (ob == managerForm.bt_member) {//카드레이아웃_회원관리
			managerForm.card.show(managerForm.panel_lecture, "1");

		} else if (ob == managerForm.bt_post) { //카드레이아웃_게시글관리

			ClassDAO dao = new ClassDAO();
			managerForm.classDisplayTable(dao.findAll());
			managerForm.card.show(managerForm.panel_lecture, "2");
			//	bt_p_search, bt_p_all_select, bt_p_info, bt_p_id_search, bt_p_id_delete;
			
		} else if (ob == managerForm.bt_mento) {//카드레이아웃_멘토관리
			managerForm.card.show(managerForm.panel_lecture, "3");
		}

		else if (ob == managerForm.bt_p_search) {

			String category = (String) managerForm.cb_p_category.getSelectedItem();

			ClassDAO dao = new ClassDAO();

			ArrayList<ClassVO> list = dao.search(category);

			managerForm.classDisplayTable(list);

		} else if (ob == managerForm.bt_p_all_select) {

			ClassDAO dao = new ClassDAO();
			managerForm.classDisplayTable(dao.findAll());

			//		}else if (ob == managerForm.bt_p_info) {
			//			
			//			classForm.setVisible(true);

		} else if (ob == managerForm.bt_p_id_search) {

			System.out.println("클릭");

			Map<String, String> map = showBox.showOption();

			MemberDAO dao = new MemberDAO();
			// ArrayList<MembershipVO> list = dao.findByName(name);
			ArrayList<MemberVO> list = dao.findSearch(map);
			//조회된 결과를 뷰(JTable)에 반영
			managerForm.memberDisplayTable(list);

			showBox.showOption();

		} else if (ob == managerForm.bt_p_id_delete) {

			String str = showBox.showInput("삭제할 강의 NO는? ");

			int no = Integer.parseInt(str);

			ClassDAO dao = new ClassDAO();

			if (showBox.showConfirm("정말 삭제하시겠습니까?") == 0) {

				if (dao.delete(no)) {

					showBox.showMsg("삭제성공!!");
					managerForm.classDisplayTable(dao.findAll());

				} else {

					showBox.showMsg("삭제실패!!");

				}
			}

/*----------------------LoginForm(로그인창)--------------------*/
		} else if (ob == loginForm.bt_login) { // 로그인 버튼 클릭

			MemberDAO dao = new MemberDAO();

			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());

			if (dao.findLogin(id, pass)) {
//				if(!id.equals("admin")) { //관리자로 로그인시 관리자버튼 온. 일단 작업 편리성을 위해 꺼둡니다
//					loginId = id;
//					loginForm.setVisible(false);
//					loginForm.initText();
//					mainForm.bt_login.setText("Logout");
//					mainForm.la_user_id.setText(id);
//				}else {
				loginId = id;
				loginForm.setVisible(false);
				loginForm.initText();
				mainForm.bt_manager.setVisible(true);
				mainForm.bt_login.setText("Logout");
				mainForm.la_user_id.setText(id);
				//				}

			} else {
				showBox.showMsg("아이디와 비밀번호를 확인해주세요!!");
			}

		} else if (ob == loginForm.la_join) { // 회원가입

			joinForm.setVisible(true);

		} else if (ob == loginForm.la_idPassSearch) { // 아이디,비밀번호찾기

			findForm.setVisible(true);

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
				showBox.showMsg("아이디 확인");
				joinForm.tf_id.setText("");
				joinForm.tf_id.requestFocus();
				return;
			} else if (!pwd.matches("[\\d]+")) {
				showBox.showMsg("비밀번호 확인");
				joinForm.tf_pass.setText("");
				joinForm.tf_pass.requestFocus();
				return;

			} else if (!pwd.equals(new String(joinForm.tf_pass2.getPassword()))) {
				showBox.showMsg("비밀번호가 일치하지 않습니다");
				joinForm.tf_pass.setText("");
				joinForm.tf_pass2.setText("");
				joinForm.tf_pass.requestFocus();
				return;
			} else if (!name.matches("[ㄱ-힣a-zA-Z]+")) {
				showBox.showMsg("이름확인");
				joinForm.tf_name.setText("");
				joinForm.tf_name.requestFocus();
				return;
			} else if (((!phone1.matches("^[0-9]{2,3}$")) || (!phone2.matches("^[0-9]{2,4}$")) || (!phone3.matches("^[0-9]{2,4}$")))) {
				showBox.showMsg("전화번호 확인");
				return;
			}

			MemberVO vo = new MemberVO(id, pwd, name, email, phone);

			if (dao.memberJoin(vo)) {

				showBox.showMsg("가입 성공");

				joinForm.initText();

				joinForm.setVisible(false);
				loginForm.setVisible(true);

			} else {
				showBox.showMsg("다시 확인해주세요.");
			}

		} else if (ob == joinForm.bt_cancel) { // 취소

			joinForm.initText();

		} else if (ob == joinForm.bt_checkid) {// 중복확인
			checkId();

/*-----------------------PassChangeForm(비번변경창)--------------------*/
		} else if (ob == pChangeForm.bt_submit) {

		} else if (ob == pChangeForm.bt_cancel) {

			
//----------------------FIND FORM(아이디 비밀번호찾기창) --------------------

		} else if (ob == findForm.bt_findID) {
			String name = findForm.tf_name.getText();
			String email = findForm.tf_email.getText();
			MemberDAO dao = new MemberDAO();
			String id = dao.findId(name, email);

			if (id.equals("")) {
				showBox.showMsg("일치하는 정보가 없습니다. ");
			} else {
				showBox.showMsg("당신의 아이디는 " + id + "입니다!!");
			}

		} else if (ob == findForm.bt_p_findPass) {
			String id = findForm.tf_p_id.getText();
			String name = findForm.tf_p_name.getText();
			String email = findForm.tf_p_email.getText();

			MemberDAO dao = new MemberDAO();
			String pass = dao.findPass(id, name, email);

			if (pass.equals("")) {
				showBox.showMsg("일치하는 정보가 없습니다.");
			} else {
				showBox.showMsg("당신의 비밀번호는 " + pass + "입니다");
			}

		} else if (ob == findForm.bt_idView) {
			findForm.card.show(findForm.panel_main, "1");
		} else if (ob == findForm.bt_passView) {
			findForm.card.show(findForm.panel_main, "2");
		}

		else if (ob == findForm.bt_cancel) {

		} else if (ob == findForm.bt_p_cancel) {

//-----------------------MYPAGE FORM(마이페이지)-----------------
		} else if (ob == myPageForm.bt_my) {//카드레이아웃_내정보
			myPageForm.card.show(myPageForm.panel_my_page, "my");
			
		} else if (ob == myPageForm.bt_class_request) {//카드레이아웃_내강의
			myPageForm.card.show(myPageForm.panel_my_page, "menti");
			
		} else if (ob == myPageForm.bt_homepage) {
			myPageForm.setVisible(false);
			mainForm.setVisible(true);
		} else if (ob == myPageForm.bt_review) {
			review.setVisible(true);
		} else if (ob == myPageForm.bt_infoUpdate) {

			MemberDAO dao = new MemberDAO();
			//이름, 아이디 변경 불가
			//전화번호, 이메일만 변경 가능 

			String phone = myPageForm.tf_phone1.getText() + "-" + myPageForm.tf_phone2.getText() + "-" + myPageForm.tf_phone3.getText();
			String email = myPageForm.tf_email.getText();
			MemberVO vo = new MemberVO(loginId, null, null, email, phone);
			dao.updateMember(vo);

		} else if (ob == myPageForm.bt_pwChange) {
			pChangeForm.setVisible(true);
		}

//------------------------NewclassForm FORM(마이페이지)-----------------
		else if (ob == newclassForm.bt_new) {
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
				newclassForm.setVisible(false);
				mainForm.setVisible(true);
			}else {
				showBox.showMsg("생성실패");
			}
		}

	}//actionPerformed

	public void checkId()
	{
		System.out.println("checkId()");
		MemberDAO dao = new MemberDAO();
		String id = joinForm.tf_id.getText();
		if (dao.findExistId(id) == 1) {
			showBox.showMsg("이미 사용중인 아이디입니다!!");
		} else {
			showBox.showMsg("사용가능한 아이디입니다!!");
			if (showBox.showConfirm("이 아이디를 사용하시겠습니까?") == 0) {
				joinForm.tf_id.setText(id);
			}
		}
	}// checkId

	public static void main(String[] args)
	{
		new Controller();
	}

}