package traffic;

class Car{
	//�޼������ �����ϴ�...�������� �ο��ϱ� ���� ����� ã�Ƽ� �۸��ϰ� �ȴ�
	//�׷���,, ū ���̰� ���� ���� ��Ȳ�ӿ��� , �޼������ ���Ҷ� ���� �ٸ�
	//�ܾ ����ؾ� �ұ�? java������ ���� �޼������ ����� �� �ִ�..
	//�޼������ ������, ������ ��ġ�ϰ� �����ϴ� ���� �ƴ϶�, �Ű������� �ڷ�����
	//������ Ʋ�����ϸ� �ߺ� ���Ƿ� �������� �ʰڴ�!!
	//�����ε�(overroading) - �޼��� ��ø
	public void run(){
		System.out.println("�ڵ����� �޸���..");
	}

	public void run(int vel){
		System.out.println("�ڵ����� �ɱ� �޸���..");
	}

	public void run(boolean flag){
		System.out.println(".....");
	}
}