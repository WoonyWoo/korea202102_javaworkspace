package bank;

//���¸� �����غ���!!
//�ڹٴ�, Ŭ������ ���� ����� �����ϹǷ� ���Ȼ� ������ ���� ������ �߻�
//�� �� �ֱ� ������ �̸� �����ϱ� ���� ���������ڴ� ����ó���� �����Ѵ�..
//�ڹ��� ���� ó���� ������ ���� �� 4�ܰ�� �����ȴ�..
/*
	(����)			��Ӱ��� or ������Ű��		������Ű����			���� ��� ����
	public	<		protected		<		default		<		 private
*/
public class Account{
	private String bankName="�������";
	private String master="��Ʈ��";
	private int balance=5000; //��� �޼��常 �� ������ ������ �� �ִ�..
	private String num="084-45678-01";

	//�����Ϳ� ���� ���������� ��������, ������ ����ڵ� ������� ���ϰ� �Ǿ����Ƿ�,
	//������ ����ڰ� ������ �� �ִ� � ��ġ�� ����������!!
	public void setBalance(int balance){
		this.balance = balance;
	}

	//���� ��ȯ�޾� �� �� �ִ� �޼��� ���� (return �� �ִ� �޼���)
	public int getBalance(){ //�������� ���� �뵵 getter
		return balance;
	}

	//�����ʹ� ��ȣ�ϰ�, �� �����͸� ����� �� �ִ� �޼��带 ��������� ������ �����ϹǷ�
	//�̷��� ����ȭ, ����ȭ�� �޼��� ���� ����� ������ setter, getter �� �Ѵ�..
	//setter, getter�� �޼��� ���� ��Ģ�� �ִ�... get����, set����
	//������ ù ö�ڴ� �빮�ڷ� �Ѵ�..
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