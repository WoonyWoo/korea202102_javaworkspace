package app0525.thread2;

//무한루프로 별을 출력하는 실행단위
public class StarThread extends Thread{
	
	public void run() {
		while(true) {
			System.out.println("☆");
		}
	}
}
