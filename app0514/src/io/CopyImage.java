package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyImage{
	
	FileInputStream fis;
	FileOutputStream fos;
	
	public CopyImage() {
		try {
			fis = new FileInputStream("C:\\korea202102_javaworkspace\\app0514\\res\\iron.jpg");
			fos = new FileOutputStream("C:\\korea202102_javaworkspace\\app0514\\res\\iron_copy.jpg");
			
			//입력스트림으로는 데이터의 1바이트씩 읽어들이고, 출력스트림으로는 데이터 1바이트씩 출력해보자!!(복사)
			int data = -1;
			while (true) {
				data = fis.read(); //byte 읽기(입력)
				
//				System.out.println(data);
				
				if(data==-1) break;
				fos.write(data); //1byte 쓰기(출력)
			}
			System.out.println("복사완료!!");
			//스트림은 반드시 닫아야 한다!!
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 읽을 수 없습니다");
		}finally {
			//아래의 코드는 객체의 생성이 성공했을때만 수행하라..
			if(fis != null) {
				try {
					fis.close(); //스트림을 닫을때도 IO예외가 발생할 수 있다고 sun에서 정했다..따라주자..
				} catch (IOException e) {
					e.printStackTrace();
				}							
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}							
			}
		}
	}

	public static void main(String[] args){
		new CopyImage();
	}
}