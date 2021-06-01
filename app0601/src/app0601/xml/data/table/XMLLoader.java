package app0601.xml.data.table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class XMLLoader {
	HttpURLConnection conn;
	
	public InputStream loadFromStream(String keyword) throws IOException{
		String key = "rKdAxIr%2FQ5yRjW24GZZCH2Pdx665znpKyztnmasd2FzTfLjtVFzeoiRGaDNIa6ZRnc4nQFvR0dTQP4Jp6s9mog%3D%3D";

		//GET방식의 요청주소 구성(파라미터 포함)
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + key); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("searchWrd", "UTF-8") + "="
				+ URLEncoder.encode(keyword, "UTF-8")); /* 예:1) searchWrd = “북한산”일때 산명안에 “북한산”을 포함하는 “북한산”이 검색됨 */
		urlBuilder.append(
				"&" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 발급받은서비스인증키 */
		
		//GET방식 요청
		URL url = new URL(urlBuilder.toString());
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		
		return conn.getInputStream(); //생성된 태그를 반환하자
	}
	
	public void close() {
		if(conn!=null) {
			conn.disconnect();
		}
	}
}
