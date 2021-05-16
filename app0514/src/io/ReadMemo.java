/*
실행중인 자바프로그램으로 메모장 파일의 내용을 읽어오자=입력
자바의 java.io 패키지에 io관련 클래스가 지원
*/
package io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class  ReadMemo{
	FileInputStream fis; //입력스트림 중 파일을 대상으로 한 입력스트림
	FileOutputStream fos; //출력스트림 중 파일을 대상으로 한 출력스트림

	public ReadMemo(){
		//자바에서 문법적으로 문제가 없다면, 이 프로그램은 무조건 완전하게 실행이 보장된다!!
		//아래의 코드는 문법적으로는 문제가 없지만, 만일 개발자가 파일명을 잘못 기재한 경우,
		//실행할 때(즉 runtime 시) 에러가 발생하여, 프로그램은 비정상 조료가 되버린다..
		//예외처리의 목적? 비정상종료의 방지!!
		try{
			fis = new FileInputStream("C:/korea202102_javaworkspace/app0514/res/memo.txt");
			System.out.println("파일에 대한 스트림 생성 성공!!!");

			fos = new FileOutputStream("C:/korea202102_javaworkspace/app0514/res/memo_copy.txt");

			//빨대 생성이 성공했으므로, 대상 자원으로부터 데이터를 1byte씩 들이마시자!!
			while(true){
				int data = fis.read(); //1byte 읽어들임			
				if(data==-1) break;		
				fos.write(data);
				System.out.print((char)data);
			}
			

		}catch(FileNotFoundException e){
			//위의 try문 내에서 예상했던 우려가 발생한 경우, 프로그램은 비정상 종료되는 것이 아니라,
			//실행부가 이 catch문으로 진입..그럼 여기서 무얼 해야하나?
			//에러의 원인을 찾아낼 수 있는 로그, 담당자에게 연락(이메일, sms, 톡), 안내메시지..
			System.out.println("해당 파일을 찾을 수 없습니다");
		}catch(IOException ioe){
			System.out.println("파일 읽기 실패");
		}
		
	}

	public static void main(String[] args) {
		new ReadMemo();
	}
}
