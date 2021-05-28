package app0527.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//GUI 처리를 담당해야 할 클라이언트를 대신하여, 메시지를 주고 받을 수 있는
//쓰레드 객체를 정의한다!!
public class ClientMsgThread extends Thread{
	Socket socket;
	BufferedReader buffr=null; //서버로부터 전송되어온 메시지를 입력 받을 수 있는 용도의 스트림
	BufferedWriter buffw=null; //서버에 메시지를 전송할 수 있는 출력스트림
	JTextArea area;
	
	public ClientMsgThread(Socket socket, JTextArea area) {
		this.socket = socket;
		this.area = area;
		
		try {
			//접속 성공된 소켓으로부터, 스트림 뽑아놓기!!
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//서버에 메시지 보내기!!
	public void send(String msg){
		try {
			buffw.write(msg+"\n");
			buffw.flush();
			
			//아래의 listen() 메서드는, 클라이언트가 원하는 시점에 호출할 사항이 아니라, 항상 무한루프로
			//되어 있어야, 서버의 메시지를 실시간으로 감지할 수 있다..
			//이때 주의할점은, 메인쓰레드를 무한루프로 빠지게 해서는 안된다!! 결국 쓰레드를 생성하여 listen() 전담시키자!!
//			listen(); //듣고
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//서버의 메시지 받기
	public void listen() {
		String msg = null;
		
		try {
			msg = buffr.readLine(); //서버가 보낸 메시지 받기!!
			area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			listen();
		}
	}
}
