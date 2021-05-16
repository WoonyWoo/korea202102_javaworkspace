package api;

class  StringTest4{
	public static void main(String[] args) {
		/*
		String 클래스를 가리켜 immutable(불변)의 속성이 있다고 한다
		*/
		String s1 = "korea";
		s1=s1+" vs usa";
		System.out.println(s1);

		//무서운 코드
		String result="";
		for(int i=0;i<100;i++){
			result+="apple "+i;
		}
		//위 문제를 해결하려면, 수정 가능한 문자열 처리 관련 api를 지원받으면 된다..
		//StringBuffer, StringBuiler 객체를 이용하면 된다!!
		StringBuffer sb = new StringBuffer(); //String 클래스 X
		sb.append("야호");
		sb.append(" 나는");
		sb.append(" 자바가");
		sb.append(" 좋아");
		System.out.println(sb.toString()); //Object 클래스
	}
}
