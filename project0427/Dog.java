/*������ �������� �����غ���*/
class Dog{
	/*�������� ���� �� �ִ� �Ӽ����� ������ ����*/
	int age=5;
	String color="white"; //js�� ���� ���ڿ��� ��ü�� ó���Ѵ�~~
	String name="Louis";

	//�Լ� �� �޼��� ����..js�� �ణ Ʋ��(��ü���� Ʋ�� ����)
	//public ����������, void�� �޼��尡 ��ȯ���� ����, �� ��ȯ���� ���� �Լ��� �ǹ�..
	public String getName(){
		return name;
	}
	public int getAge(){ //int�� ��ȯ�ϴ� �޼���
		return age;
	}

	public void run(){
		System.out.println(name+"�� �پ��");
	}
}