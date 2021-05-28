package app0528.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ServerMsgThread extends Thread{
	
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	ChatServer chatServer; //JTextArea, Vector 등 여러가지 서버측의 자원을 접근할 것이기에.. 통째로 서버를 보유하자!! 
	
	public ServerMsgThread(Socket socket, ChatServer chatServer) {
		this.socket = socket;
		this.chatServer = chatServer;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine(); //클라이언트가 보낸 메시지 듣기!!
			send(msg); //다시 클라이언트에게 보내기!!
			chatServer.area.append(msg+"\n"); //서버의 로그에 남기기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//말하기
	public void send(String msg) {
		try {
			//버퍼처리된 스트림에서의 문자열의 끝을 표시할때는 역슬래시n (줄바꿈)
			buffw.write(msg+"\n");
			buffw.flush();
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
