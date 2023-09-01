package days22;

import java.util.Deque;
import java.util.LinkedList;

public class Ex10 {

	public static void main(String[] args) {
		//	큐(Queue)
		//	[Deque]		//양쪽 방향으로 나가고 들어갈수 있음	
		//FIFO(먼저 입력된 값이 먼저 나옴)
		//	push				pop		==	스택
		//	offer()			poll(),peek()	==	큐

		
		
		//Collection 인터페이스를 상속받은 인터페이스
		//Queue q = new LinkedList();
		Deque q = new LinkedList();
		q.offer("유희진");
		q.offer("임경재");
		q.offer("김호영");
		q.offer("이지현");
		
		q.offerFirst("홍길동");
		//q.offerLast(q)
		
		//q.pollFirst();
		//q.pollLast();
		
		while (!q.isEmpty()) {
			System.out.println(q.poll());	//집어넣은 순서대로 나옴
			//String name = (String) q.remove();
			//System.out.println(name);
		}
		
	} // main
}
