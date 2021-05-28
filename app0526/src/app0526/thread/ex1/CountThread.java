package app0526.thread.ex1;

public class CountThread extends Thread{
	int count;
	//개발자는 쓰레드로 수행할 코드를 run 에 작성한다!!
	//그러면, 이  run메서드를 jvm 이 원하는 시점에 호출해준다!! 즉 개발자가 호출
	//메인 쓰레드에 의해 호출되어 버린다!!
	public void run() {
		while(true) {
//			count;
		}
	}
}
