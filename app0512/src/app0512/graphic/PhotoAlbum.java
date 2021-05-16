package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame{
   JPanel p_north;//썸네일 올릴 패널
   JPanel canvas;//그림이 그려질 패널
   Thumbnail[] list = new Thumbnail[8];
   DetailView detailView; //상세보기 패널
   
   public void createThumb() {
      for(int i=0; i<list.length;i++) {
         list[i] = new Thumbnail(this);
         p_north.add(list[i]);
      }
   }
   public PhotoAlbum() {
      //생성
      p_north = new JPanel();
      detailView = new DetailView(this);
      
      //스타일, 레이아웃
      p_north.setPreferredSize(new Dimension(900,100));
      p_north.setBackground(Color.LIGHT_GRAY);
      
      //조립
      add(p_north,BorderLayout.NORTH);
      createThumb();
      add(detailView);
      
      //보여주기
      setBounds(500,50,900,600);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public static void main(String[] args) {
      new PhotoAlbum();
   }
}