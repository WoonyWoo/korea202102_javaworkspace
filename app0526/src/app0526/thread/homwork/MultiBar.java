package app0526.thread.homwork;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiBar extends JFrame{
	JButton bt;
	BarThread bar1;
	BarThread bar2;
	BarThread bar3;
	
	Thread t1;
	Thread t2;
	Thread t3;
	
	int n1,n2,n3; //0
	
	public MultiBar() {
		bar1 = new BarThread();
		bar2 = new BarThread();
		bar3 = new BarThread();
		bt = new JButton("Start!!");
		
		Dimension d = new Dimension(275, 35);
		bar1.setPreferredSize(d);
		bar2.setPreferredSize(d);
		bar3.setPreferredSize(d);
		
		setLayout(new FlowLayout());
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBar();
			}
		});
		
		setVisible(true);
		setBounds(1100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void startBar() {
		MyThread m1 = new MyThread(bar1,1);
		MyThread m2 = new MyThread(bar2,5);
		MyThread m3 = new MyThread(bar3,7);
		
		m1.start();
		m2.start();
		m3.start();
	}
	
	public static void main(String[] args) {
		new MultiBar();
	}
}
