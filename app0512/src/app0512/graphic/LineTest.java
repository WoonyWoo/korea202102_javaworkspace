/*
 * 자바의 모든 컴포넌트는 스스로 그림의 주체이자 즉 화가이자 , 그림의 대상 즉 도화지가 된다!!
 */

package app0512.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class LineTest extends JFrame{
	//자바의 모든 컴포넌트는 부모 GUI 객체로부터, paint메서드를 물려받아,
	//자기 자신에게 알맞은 그림을 스스로 그린거다!! 특히 그림 그리는 메서드인 paint 메서드에는
	//붓만으로는 그림을 그릴 수 없기 때문에 팔레트 역할을 수행하는 Graphics 객체가 인수로 넘어온다!!
	//특히, 시스템 즉 컴포넌트에 의한 그림이 아닌, 개발자가 주도하여 그림을 그리려면 paint 메서드를
	//재정의 즉 오버라이드 하면 된다!!
	
	@Override
	public void paint(Graphics g) {
//		System.out.println("paint 메서드 호출");
		g.drawLine(100, 50, 250, 380); //선 그리기
		g.drawOval(100, 200, 100, 100); //원 그리기
		g.drawRect(10, 250, 80, 80); //사각형 그리기
		g.fillOval(30, 300, 90, 90); //채워진 원 그리기
		
		//색상처리
		g.setColor(Color.RED);
		g.fillRect(300, 200, 50, 100); //빨간색의 직사각형
		
		//텍스트처리
		g.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 50));
		g.drawString("Apple", 20, 400);
	}
	
	public LineTest() {
		setBounds(1300, 100, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LineTest();
	}
}
