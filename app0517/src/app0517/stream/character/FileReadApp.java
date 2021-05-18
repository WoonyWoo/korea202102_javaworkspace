package app0517.stream.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*문자기반 스트림을 학습하면서, 동시에 보다 효율적으로 데이터를 처리하는 */
public class FileReadApp {
	FileReader reader;
	BufferedReader buffer;
	File file;
	String path = "C:\\korea202102_javaworkspace\\app0517\\res\\자바13일차.txt";
	
	public FileReadApp() {
		try {
			reader = new FileReader(file = new File(path)); //파일을 대상으로 빨대를 꽂음!!
			buffer = new BufferedReader(reader); //기존의 Filereader를 버퍼처리된 리더로 업그레이드
			
			String data = null;
			
			while (true) {
				data = buffer.readLine(); //한 줄을 읽어들임..따라서 반환형은 문자열이다!!
				if(data==null) break; //파일의 끝을 만나면 -1 반환하므로, 반복문 멈추기!!
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(buffer!=null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new FileReadApp();
	}
}
