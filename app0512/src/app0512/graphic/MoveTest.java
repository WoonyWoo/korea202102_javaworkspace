package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//캔버스에 채워진 원을 하나 그리고 나서, 버튼에 의해 이 원이 x축방향으로
//이동하는 효과를 부여해보자!!
public class MoveTest extends JFrame implements ActionListener{
	JPanel p_north;
	MyButton bt;
	MyCanvas can; //커스터 마이징 된 캔버스
	int x = 100; //원의 x좌표
	
	public MoveTest() {
		//생성
		p_north = new JPanel();
		bt = new MyButton("나버튼이다!!");
		can = new MyCanvas(this);
		
		//스타일 및 레이아웃
		can.setBackground(Color.RED);
		
		//조립
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH); //북쪽에 패널 부착
		add(can); //센터에 캔버스 부착
		
		bt.addActionListener(this);
		
		//보여주기
		setBounds(1200, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//물리량 변화 즉 변화되는 값 설정
	public void tick() {
		x+=10;
		System.out.println(x);
	}
	public void render() {
		//MyCanvas를 다시 그려달라고 요청하자
		can.repaint(); //update() -> paint()
	}
	public void actionPerformed(ActionEvent e) {
		tick();
		render();
	}
	
	public static void main(String[] args) {
		new MoveTest();
	}

	
}
