package app0525.thread2;

public class TestApp {
	public static void main(String[] args) {
		StarThread st1 = new StarThread();
		st1.start();
		
		//이 시점부터는 메인 실행부가 쓰레드의 run()을 직접
		//수행하지 않고, JVM의 Runnable 영역으로 밀어넣기
		//때문에, st1이 JVM에 의해 언제 실행되어질지는
		//오직 JVM만이 알고 있다..
		//또한 JVM에 의해 실행이 선택되는 순간 해당 쓰레드의
		//run() 메서드가 실행되어진다!! 이때를 가리켜
		//쓰레드 생명주기 중 running 상태라 한다!!
		
		CounterThread ct = new CounterThread();
		ct.start();
	}
}
