package app0512.graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Thumbnail extends JPanel implements MouseListener{
	PhotoAlbum photoAlbum;
	Toolkit kit; //이미지를 얻을 수 있는 클래스
	Image image; //추상클래스이므로, new불가
	
	public Thumbnail(PhotoAlbum photoAlbum) {
		this.photoAlbum = photoAlbum;
		
		kit = Toolkit.getDefaultToolkit(); //static 메서드, 즉 클래스 소속메서드
		image = kit.getImage("C:\\korea202102_javaworkspace\\app0512\\res\\images\\mt.jpg");
		image = image.getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		this.setPreferredSize(new Dimension(100,90));
		
		//현재 패널과 리스너와의 연결
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("나 눌렀어?");
		photoAlbum.detailView.setImage(image);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
