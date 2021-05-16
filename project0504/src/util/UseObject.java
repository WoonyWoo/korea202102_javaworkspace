package util;

public class  UseObject{
	public static void main(String[] args) {
		ObjectTest ot = new ObjectTest();
		String str="monkey";

		//ot.test(); //존재하지 않는 메서드 호출
		boolean result = ot.equals(str);
		System.out.println(ot); //ot 는 객체이므로, 문자열이 아니다. 하지만 System.out.println()
		//으로 출력을 시도할때, 문자열화 되어 그 주소값등이 반환됨..
		//우리는 toString() 메소드를 호출한 적이 없다..즉 문자열화 될때 Object클래스로부터 상속받은
		//toString() 메서드가 자동으로 호출된것이다..

		//위의 코드에서 equals() 메서드는 ObjectTest
		//클래스내에 직접 정의한적이 없다!! 그럼에도 불구
		//하고 에러가 발생하지 않는 이유는? 시스템에 의해
		//이미 존재하고 있다는 증명..
		//원인: 개발자가 명시하지 않더라도 자바언어의 최상위 어버이 클래스인 Object클래스로부터
		//상속 받은 상태이기에...
	}
}
