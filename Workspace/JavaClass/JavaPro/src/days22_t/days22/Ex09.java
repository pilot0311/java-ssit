package days22_t.days22;

import java.util.Stack;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오후 2:42:30
 * @subject
 * @content
 */
public class Ex09 {

	public static void main(String[] args) {
		// ArrayList
		// Vector
		// LinkedList
		// 스택(Stack)과 큐(Queue)
		//          0(1)
		//    	──────┐
		// →       C  B  A │
		//    	──────┘
		// LIFO구조
		// -> push()
		// <- pop()       peek()
		//    empty()
		// index search()
		//  -1
		
		// 스택 활용 : 웹브라우저 뒤로/앞으로
             
		
		// Vector <- List <- Collection
		Stack s = new Stack();
		// 3:05 수업시작~
		s.push("유희진");
		s.push("임경재");
		s.push("김호영");
		s.push("이지현");
		
		System.out.println( s );
		
		/*
		System.out.println( s.pop() );
		System.out.println( s.pop() );
		System.out.println( s.pop() );
		System.out.println( s.pop() );
		
		System.out.println( s.pop() );
		*/
		/*
		while ( !s.empty() ) {
			System.out.println( s.pop() );
		} // while
		*/
		
		/*
		System.out.println( s.peek() );
		System.out.println( s.peek() );
		System.out.println( s.peek() );
		System.out.println( s.peek() );
		*/
		
		// 3
		// pop() pop()     pop()
		System.out.println( s.search("임경재"));
		

	} // main

} // class
