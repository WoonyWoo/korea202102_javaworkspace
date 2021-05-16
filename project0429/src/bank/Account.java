package bank;

//계좌를 정의해본다!!
//자바는, 클래스간 서로 사용이 가능하므로 보안상 뜻하지 않은 문제가 발생
//할 수 있기 때문에 이를 보완하기 위해 접근제한자는 보안처리를 지원한다..
//자바의 보안 처리는 다음과 같이 총 4단계로 구성된다..
/*
	(공개)			상속관계 or 같은패키지		같은패키지만			나만 사용 가능
	public	<		protected		<		default		<		 private
*/
public class Account{
	private String bankName="기업은행";
	private String master="배트맨";
	private int balance=5000; //멤버 메서드만 이 변수를 접근할 수 있다..
	private String num="084-45678-01";

	//데이터에 대한 직접접근을 막았으나, 선의의 사용자도 사용하지 못하게 되었으므로,
	//선의의 사용자가 접근할 수 있는 어떤 장치를 마련해주자!!
	public void setBalance(int balance){
		this.balance = balance;
	}

	//값을 반환받아 갈 수 있는 메서드 정의 (return 이 있는 메서드)
	public int getBalance(){ //가져오기 위한 용도 getter
		return balance;
	}

	//데이터는 보호하고, 이 데이터를 사용할 수 있는 메서드를 제공해줘야 개발이 가능하므로
	//이렇게 습관화, 관례화된 메서드 정의 기법을 가리켜 setter, getter 라 한다..
	//setter, getter는 메서드 정의 규칙이 있다... get변수, set변수
	//변수의 첫 철자는 대문자로 한다..
	public void setMaster(String master){
		this.master = master;
	}
	public String getMaster(){
		return master;
	}

	//bankName
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	public String getBankName(){
		return bankName;
	}

	//num
	public void setNum(String num){
		this.num = num;
	}
	public String getNum(){
		return num;
	}
}