package race;

//인류의 특징을 모두 물려받은, 흑인을 정의한다..
//따라서 이 클래스에서는 흑인이 가진 특징만을 보유하면 된다!!!
public class Black extends Human{
	/* 이 콛느느 우리가 절대 볼 수 없다!!!
	왜? 개발자가 생성자를 정의하지 않을 경우에 내부적으로
	컴파일러에 의해 처리되므로...
	public Black(){
		super();
	}
	*/
	//부모의 생성자에 매개변수가 존재하므로, 더이상
	//현재클래스의 디폴트 생성자에 의존하다가는 에러발생함
	//따라서 개발자가 적극적으로 나서서, 부모의 인수있는
	//생성자를 직접 호출해주자!!
	/*
	public Black(){
		super(135);
	}
	*/

	public Black(){
		//System.out.println("저 흑인 초기화해요");
		//부모의 초기화보다 시급한 초기화는 있을 수 없다!!
		//즉 자식의 초기화보다 부모의 초기화가 앞서야 한다
		super(135);
	}
	String color = "black";
	int IQ=110;

	public void run(){
		System.out.println("육상을 잘한다");
	}
}