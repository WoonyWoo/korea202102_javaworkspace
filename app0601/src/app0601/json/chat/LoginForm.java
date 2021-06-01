package app0601.json.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//LoginForm 예제에서는 메인 메서드 안에 변수를 몰아놓고 , 즉 지역변수로 객체들을 처리하고
//있다..이번엔 oop언어의 is a , has a 관계를 활요하여 객체를 정의해보자
public class LoginForm extends JFrame{
									/* is a*/
	JLabel la_id;
	JLabel la_pass;
	JTextField t_id;
	JTextField t_pass;
	JButton bt_login;
	JButton bt_join;
	
	JPanel p_center;
	JPanel p_south;
	
	//db관련
	Connection con;
	String url = "jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user = "root";
	String password = "1234";
	
	//이 윈도우인 즉 로그인폼이 메모리에 생성될때, 해당 부품들도 같이 생성시키려면
	//생성자 메서드를 적극 활용해야 한다..
	public LoginForm() {
		//부모의 생성자 이용하는 방법 
		super("LoginForm style 2");
		
		//부품 생성 
		la_id = new JLabel("ID");
		la_pass = new JLabel("Pass");
		t_id = new JTextField(18); //18자 너비의 크기 갖음(18자만 넣을수있는게 아니다!)
		t_pass = new JTextField(18);
		bt_login  = new JButton("Login");
		bt_join  = new JButton("Join");	
		p_center = new JPanel();
		p_south = new JPanel();
		
		//스타일 설정 
		la_id.setPreferredSize(new Dimension(110, 35));
		t_id.setPreferredSize(new Dimension(110, 35));
		la_pass.setPreferredSize(new Dimension(110, 35));
		t_pass.setPreferredSize(new Dimension(110, 35));
		
		//조립 
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		//패널을 윈도우 센터에 부착 
		this.add(p_center);
		this.add(p_south, BorderLayout.SOUTH);
		
		//이벤트 연결
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member member = loginCheck();
				
				if(member==null) { //로그인 인증 메서드 호출 결과가 null이면 로그인 실패!!
					JOptionPane.showMessageDialog(LoginForm.this, "로그인 정보가 올바르지 않습니다");
				}else {
					//채팅창 띄우고, 회원정보 전달!!
					new ChatClient(member);
					LoginForm.this.setVisible(false); //현재 창은 안보이게..
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				release(con);
				System.exit(0);
			}
		});
		
		this.setBounds(1000, 100, 350, 155);//윈도우의 크기 설정 
		this.setVisible(true);//윈도우 보이게
		
		connect();
	}
	
	public void connect() {
		/*
		 * 1) 드라이버 로드
		 * 2) 접속
		 * 3) 쿼리실행
		 * 4) 접속해제
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로드
			con = DriverManager.getConnection(url, user, password);
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 실패");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//로그인 처리
	public Member loginCheck() {
		String sql = "select * from member where user_id=? and password=?"; //and 조건
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null; //반환할 것이므로..
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t_id.getText()); //아이디
			pstmt.setString(2, t_pass.getText()); //패스워드
			
			rs = pstmt.executeQuery(); //ResultSet 반환!!
			
			//레코드가 있다면, 즉 로그인이 인증되었다면 커서 한칸 전진이 가능하는 것임
			if(rs.next()) {
				//로그인창은 닫고, 채팅창을 띄워야 함!! 단 rs에 들어잇는 회원정보를 VO에 담기도 하자!!
				member = new Member(); //Empty 상태임
				member.setMember_id(rs.getInt("member_id"));
				member.setUser_id(rs.getString("user_id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return member;
	}
	
	public void release(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new LoginForm();
	}
}




