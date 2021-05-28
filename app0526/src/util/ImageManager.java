package util;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageManager {
	public ImageIcon getScaledIcon(String filename, int width, int height) {
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource(filename));
		//이미지의 크기를 줄이는 메서드는 Image 추상클래스에서 지원하므로, 현재 아이콘을 잠시 이미지로 변환해보자!!
		icon = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		
		return icon;
	}
}
