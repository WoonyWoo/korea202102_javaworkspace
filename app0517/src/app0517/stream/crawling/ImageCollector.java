package app0517.stream.crawling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageCollector {
   //이 객체는 안드로이드에서도 동일하게 쓰인다.
   URL url;
   URLConnection con;//웹서버에 요청을시도할 수 있는 객체
   HttpURLConnection http;
   String path = "https://lh3.googleusercontent.com/proxy/3QOkvZrYcoi-O7AW9kgiJxDIkHC6upePbQCS4dl-nL-VEUnZgApiZSmsrtmjLc1BrBWh0rPQfguoM2Q4r7Iw8i_9VjbLnvlLfjBon142ka5t2GX8zw6x";
   
   
   FileOutputStream fos; //파ㅣ일을 대상으로 한 바이트 기반의  출력스트림
   public ImageCollector() {
      InputStream is= null;
      try {
         url = new URL(path);//URL 객체 생성
         System.out.println("자원에 접근 가능");
         con = url.openConnection();
         http = (HttpURLConnection)con;//다운케스팅
         http.setRequestMethod("GET");
         
         //웹 서버에 요청 시도
         is = http.getInputStream();//웹서버와의 요청 시 생성된 입력 스트림
         fos = new FileOutputStream("C:\\korea202102_javaworkspace\\app0517\\res\\test.jpg");//복사될 파일 즉 생성될 파일의 경로
         
         long StartTime = System.currentTimeMillis();
         //이 입력스트림으로  서버의 자원을 가져올 수 있다.
         int data = -1;
         byte[] b= new byte[1024]; //배열의 크기가 바가지의 크기를 결정한다!! 1k byte씩 담기
         
         while(true) {
            data = is.read(b); //1byte 읽기
            if(data==-1)break;
            //InputStream은  입력스트림과 관련된 객체들의 최상위 객체
            System.out.println(data);
            fos.write(b);
         }
         System.out.println("인터넷 상 이미지 수집 완료. 디렉토리 확인.");
         
         long endTime = System.currentTimeMillis(); //현재 시간을 밀리 second로 반환
         
         System.out.println("다운로드 소요시간은: "+(endTime-StartTime));
         
      }catch (MalformedURLException e) {
         e.printStackTrace();
         System.out.println("주소가 올바르지 않습니다.");
      }catch(IOException e) {
         e.printStackTrace();
      }finally {
         if(fos!=null) {
            try {
               is.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         
         if(is!=null) {
         }try {
            is.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
   public static void main(String[] args) {
      new ImageCollector();
   }

}