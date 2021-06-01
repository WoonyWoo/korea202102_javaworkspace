package app0601.xml.data.table;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	Vector<Mountain> mtList = null;
	
	boolean isItems;
	boolean isItem;
	boolean isMntiadd;
	boolean isMntidetails;
	boolean isMntihigh;
	boolean isMntilistno;
	boolean isMntiname;
	
	Mountain mt;
	
	public void startElement(String uri, String name, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("items")) {
			isItems=true;
			mtList = new Vector<Mountain>(); //벡터 생성
			
		}else if(tag.equals("item")) {
			isItem=true;
			mt = new Mountain(); //Empty 상태의 VO 생성!!
			
		}else if(tag.equals("mntiadd")) {
			isMntiadd=true;
		}else if(tag.equals("mntidetails")) {
			isMntidetails=true;
		}else if(tag.equals("mntihigh")) {
			isMntihigh=true;
		}else if(tag.equals("mntilistno")) {
			isMntilistno=true;
		}else if(tag.equals("mntiname")) {
			isMntiname=true;
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);
		
		if(isMntiadd) { //주소를 지나가는 중이라면..
			mt.setMntiadd(data); //VO에 주소 넣기
		}else if(isMntidetails) {
			mt.setMntidetails(data); //VO에 상세내용 넣기
		}else if(isMntihigh) {
			mt.setMntihigh(data); //VO에 산의 높이 넣기
		}else if(isMntilistno) {
			mt.setMntilistno(Integer.parseInt(data)); //VO에 산의 번호 넣기
		}else if(isMntiname) {
			mt.setMntiname(data); //VO에 산의 이름 넣기
		}
	}
	
	public void endElement(String uri, String name, String tag) throws SAXException {
		if(tag.equals("mntiadd")) {
			isMntiadd=false;
		}else if(tag.equals("mntidetails")) {
			isMntidetails=false;
		}else if(tag.equals("mntihigh")) {
			isMntihigh=false;
		}else if(tag.equals("mntilistno")) {
			isMntilistno=false;
		}else if(tag.equals("mntiname")) {
			isMntiname=false;
		}else if(tag.equals("item")) {
			isItems=false;
			mtList.add(mt); //하나의 아이템 즉 VO가 모두 채워진 시점이므로, 완성된 VO를 벡터에 추가하기!!
		}else if(tag.equals("items")) {
			isItem=false;
		}
	}
	
	public void endDocument() throws SAXException {
		//검증
		for(Mountain obj : mtList) {
			System.out.println(obj.getMntiadd()+", "+obj.getMntidetails()+", "+obj.getMntihigh()+", "+obj.getMntilistno()+", "+obj.getMntiname());
		}
	}
}
