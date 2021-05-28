package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.minssam.shoppingapp.config.ConfigMain;
import com.minssam.shoppingapp.customer.CustomerMain;
import com.minssam.shoppingapp.member.JoinForm;
import com.minssam.shoppingapp.member.LoginForm;
import com.minssam.shoppingapp.member.MemberMain;
import com.minssam.shoppingapp.order.OrderMain;
import com.minssam.shoppingapp.product.ProductMain;

public class AppMain extends JFrame implements ActionListener {
	JPanel p_north;
	String[] menu_title = { "상품관리", "회원관리", "주문관리", "고객센터", "Login", "환경설정" };
	CustomButton[] bt_menu = new CustomButton[menu_title.length]; // 배열생성

	JPanel p_center;// 페이지를 교체하기 위한 패널(페이지들 간의 공존을 위해)

	// 페이지 선언
	Page[] pages = new Page[7];

	// 데이터베이스 관련
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/shoppingapp?characterEncoding=UTF-8";
	String user = "root";
	String password = "1234";
	private Connection con;
	private boolean session = false; // 세션이 true 일때 인증 받은 것이고, false 일때는 미인증 간주

	public AppMain() {
		connect();// DB접속

		// 생성
		p_north = new JPanel();
		for (int i = 0; i < menu_title.length; i++) {
			bt_menu[i] = new CustomButton(menu_title[i]);
			bt_menu[i].setId(i); // 반복문의 i 를 각 버튼의 식별 id 로 할당!!!
		}

		// 페이지들 생성
		p_center = new JPanel();

		pages[0] = new ProductMain(this); // 상품관리
		pages[1] = new MemberMain(this);// 회원관리
		pages[2] = new OrderMain(this);// 주문관리
		pages[3] = new CustomerMain(this);// 고객센터
		pages[4] = new LoginForm(this);// 로그인
		pages[5] = new ConfigMain(this);// 환경설정
		pages[6] = new JoinForm(this);// 회원가입폼

		// 스타일

		// 조립
		for (JButton bt : bt_menu) { // improved for loop : 주로 집합데이터 형식을 대상으로 한 loop
			p_north.add(bt);
		}
		add(p_north, BorderLayout.NORTH);

		// p_center 에 페이지들 붙이기
		for (Page p : pages) {
			p_center.add(p);
		}
		add(p_center);

		// 리스너
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect(); // DB접속해제
				System.exit(0); // kill process
			}
		});

		for (int i = 0; i < bt_menu.length; i++) {
			bt_menu[i].addActionListener(this);
		}

		// 보여주기
		//인증 여부에 따라 알맞는 페이지 보여주기
		if(session==false) { //인증을 받지 않은 상태이므로, 로그인을 디폴트로 보여주자!!
			showHide(4);//제일 먼저 보여주고 싶은 페이지
		}else {
			showHide(0);
		}
		setBounds(400, 10, 1200, 700);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼이 눌렸는지? - 이벤트가 연결된 컴포넌트를 가리켜 이벤트 소스
		Object obj = e.getSource();
		// obj는 오브젝트 자료형이기 때문에, 버튼을 가리킬수는 있지만, 버튼 보다는 보편적인 기능만을 가지고
		// 있기에, 즉 가진게 별로 없기에 버튼의 특징을 이용하기 위해서는 버튼 형으로 변환해서 사용하자!!
		CustomButton bt = (CustomButton) obj; // down casting
		// System.out.println(bt.getText());

		if(session || bt.getId()==4) {
			showHide(bt.getId());
		}else {
			JOptionPane.showMessageDialog(this, "로그인이 필요한 서비스입니다");
		}
	}

	public void connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				this.setTitle("접속성공");
			} else {
				this.setTitle("접속실패");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disConnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 쿼리문이 DML인 경우
	public void release(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 쿼리문이 Select 인경우
	public void release(PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// con getter
	public Connection getCon() {
		return con;
	}

	public void showHide(int n) { //보여주고 싶은 페이지의 변호를 넘기면 된다..
		// 내가 누른 버튼에 해당하는 페이지만 setVisible() 을 true로 놓고 나머지는 false로 놓자!!
		for (int i = 0; i < pages.length; i++) {
			if (n == i) {
				pages[i].setVisible(true); // 현재 선택한 버튼과 같은 인덱스를 갖는 페이지라면..
			} else {
				pages[i].setVisible(false);
			}
		}
	}

	
	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public static void main(String[] args) {
		new AppMain();

	}

}