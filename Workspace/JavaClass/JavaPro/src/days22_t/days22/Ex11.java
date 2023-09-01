package days22_t.days22;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오후 3:29:15
 * @subject
 * @content
 */
public class Ex11 {

	public static void main(String[] args) {
		// [PriorityQueue]     FIFO구조
		// Priority 우선순위
		// 우선순위가 높은 것부터 꺼내오는 큐
		Queue  q = new PriorityQueue();
		q.offer(3);
		q.offer(5);
		q.offer(2);
		q.offer(4);
		q.offer(1);
		
		System.out.println( q );
		
		while ( !q.isEmpty()) {
			System.out.println( q.poll() );			
		} // while
		
		// 우선순위가 높은 것 부터 꺼내오는 큐
		//   작은 숫자가 우선선위가 높다.
		

	}

}
