/*자동차를 정의해본다*/
class Car{
	String name="벤츠";
	int price=9000;
	String color="silver";

	public void setPrice(int price){
		this.price=price;
	}

	public static void main(String[] args){
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = c2;

		c1.setPrice(8000); //첫번째 자동차의 가겨을 8천으로 내림
		System.out.println(c2.price); //두번째 자동차가 영향을 받았는지 여부를 체크
		//결론 : 메모리에 올라간 인스턴스들은 서로 다른 별개의 객체들이다..

		c3.setPrice(7000); //c2가 가리키고 있었던 자동차와 동일한 위치의 차를 가리키므로
		//즉 두번째 자동차의 가격을 7000으로 변경하게됨
		System.out.println(c2.price);
	}
}