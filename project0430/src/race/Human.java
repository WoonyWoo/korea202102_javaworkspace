package race;

//인간을 정의한다 (상위 객체일수록 보편적 특징이 와야함)
class Human{
	int IQ = 90;
	boolean hasName=true;

	public Human(int IQ){
		this.IQ=IQ;
		System.out.println("Human의 초기화");	
	}
	//생성자 오버로딩
	public Human(){
	}

	public void speak(){
		System.out.println("말할 수 있다");	
	}
	public void drive(){
		System.out.println("운전할 수 있다");	
	}
}