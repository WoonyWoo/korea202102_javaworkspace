/*�������� �����Ѵ�*/

class Puppy{
	int age=5;
	boolean hasGuard; //��������� �����ڰ� �ʱ�ȭ���� ������, �� Ŭ�����κ���
								//�޸𸮿� �ö󰡴� �ν��Ͻ��� �������� ����Ʈ���� �����
								//by �����Ϸ��� ���� �ʱ�ȭ �ȴ�..
								//������ false, ���� 0
								//�� ��Ģ�� ����������� ����ȴ�..

	public void setAge(){
		age=3;
		//�Ʒ��� k�� �ڵ� �ʱ�ȭ���� �ʴ´�!!!! ��? ��������� �ƴ϶�!!
		int k;
		System.out.println(k);
	}

	public static void main(String[] args){
		//�������� ���̸� 3���� ������ ��, ���̸� ����غ���
		Puppy p1 = new Puppy();
		p1.age = 3;
		System.out.println(p1.age);
	}
}