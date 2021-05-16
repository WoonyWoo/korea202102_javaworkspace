package animal.birds;

class UseDuck{
	public static void main(String[] args){
		//오리 한마리를 메모리에 올리고, (인스턴스 생성) canSwim 메서드를 호출해보자
		Duck d = new Duck("white");
		d.canSwim();
		
		Bird b= new Bird();
		b=d; //가능? 불가능?

		//byte short int long : 숫자형은 서로 같은 종류의 자료형이다!!!
		//즉 같은 종류의 자료형 이기에 서로 형변환이 가능하다!!
		byte b=5;
		int k=b;

	}
}