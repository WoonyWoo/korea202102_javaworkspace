package app0513.paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{
	boolean flag = false;
	
	public MyCanvas() {
		//캔버스와 리스너 연결
		this.addMouseListener(this); //캔버스와 리스너 연결
		this.addMouseMotionListener(this); //캔버스와 마우스 모션 리스너 연결
	}
	
	public void paint(Graphics g) {
		if(flag) {
			g.fillOval(100, 100, 2, 2); //채워진 원 즉 점을 그린다!!			
		}
	}
	
	public void mouseDragged(MouseEvent e) {
//		System.out.println("mouseDragged 호출");
		repaint(); //간접적으로 paint(), 메서드를 호출하게 된다
	}
	
	//마우스를 누르면, 이때부터 그림그리기 가능...
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed 호출");
		flag = true;
	}
	
	//마우스를 눌렀다가 뗄 때는 그림그리기 불가
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased 호출");
		flag = false;
	}

	
	
	
	public void mouseEntered(MouseEvent e) {
		//System.out.println("mouseEntered 호출");
	}
	public void mouseExited(MouseEvent e) {
		//System.out.println("mouseExited 호출");
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {	
	}
}
