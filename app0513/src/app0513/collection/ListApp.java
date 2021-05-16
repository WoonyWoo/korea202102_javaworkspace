package app0513.collection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

/*
 자바의 컬렉션 프레임웍 중 List에 대해 학습한다 
 */

public class ListApp {
	public static void main(String[] args) {
		//리스트는 배열과 모습이 같다, 단지 다루려는 대상이 객체에 한정되어 있다..
		
		//제너릭(Generic) 타입으로 명시된 컬렉션 프레임웍 객체는, 해당 객체만을 받아들인다. 컴파일 타임에 잡아냄
		ArrayList<String> list = new ArrayList<String>();

		list.add("apple"); //자바에서 지원하는 모든~~자료형을 다 넣을 수 있다..
		list.add("apple");
		list.add("apple");
		
		//들어있는 데이터 출력하기
		int length = list.size();
		System.out.println("리스트에 들어간 데이터의 수는 "+length);
		list.set(1, "사과");
		System.out.println("변경된 결과는 "+list.get(1));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//jdk 5 부터 개선된(improved) for loop 지원 다른 언어에서의 for ~ each 문과 비슷
		
		for( Object item : list) { //우측항의 집합 수만큼 반복
			String s = (String)item;
			System.out.println(s);
		}
	}
}
