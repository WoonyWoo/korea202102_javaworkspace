package animal.birds;

/*
�Ʒ� �ڵ��� ��� ���谡 ���� ������ �� �� �ִٴ� �ٰ�!!
1) �ڹٿ����� �⺻ �ڷ������� ������ ũ�� 3������ �з�
	����, ����, ������
	Ư�� ����(byte, short, int, long, float, double)�� char(0���� ���) �� ������
	���� ���� ������ �ڷ������� ���� ����ȯ�� �����ϴ�
2) �ڹ��� �ڷ����� �� 4�����μ�, ��ü�ڷ����� �ڷ����̴�!!!

3) ���: 2���� ���� ��ü�ڷ����� �ڷ����̶��, �⺻�ڷ����鰣�� ����Ǿ��� ��ü�� ����ȯ��
			��ü�ڷ������� ����Ǿ�� �Ѵ�!!
			��?? ��ü�ڷ����� �ڷ����̴ϱ�!!!!!!!!
4) ����?
	����ڰ� ���� �ڷ����� Ŭ���������� ���� ������ �ڷ����� ���� �� �ִ°�?
	�ִ�!!! �ٷ� ����� �̿��ϸ� �θ�, �ڽİ��� ���谡 �����ǰ�, �θ�, �ڽİ��� ���踦 �츮��
	���� ������ �ڷ������� �� �� �ִ�..
*/

public class Duck extends Bird{
	String name="�� ����";

	public Duck(String color){
		super(color);
	}

	//������ ������
	public void canSwim(){
		System.out.println("������ ���մϴ�");
	}

}