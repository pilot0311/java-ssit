package days22;

import java.util.Stack;

public class Ex09 {

	public static void main(String[] args) {
		//	ArrayList
		//	Vector
		//	LinkedList
		//	스택(stack)과 큐(Queue)
		//	LIFO구조 (Last in First Out)		스택에 마지막으로 입력된 자료가 제일 먼저 삭제 하는 방식
		//	-> push()
		//	<-	pop()읽으면서 제거		peek() 읽기만
		//		empty()
		//	index search()	없으면-1
		//		1부터 시작
		
		//부모 클래스 Vector	<-List <- Collection	동기화 처리O
		Stack s = new Stack();
		s.push("유희진");
		s.push("임경재");
		s.push("김호영");
		s.push("이지현");		
		System.out.println(s);
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		
//		//EmptyStackException 스택비어있음
//		System.out.println(s.pop());
		
//		while (!s.empty()) {
//			System.out.println(s.pop());		//집어넣은 순의 역순으로 나옴(최신것부터 나옴)
//		}
		
//		System.out.println(s.peek());
//		System.out.println(s.peek());
//		System.out.println(s.peek());
//		System.out.println(s.peek());
		
		//3
		//pop() pop() 				pop()
		System.out.println(s.search("임경재"));
		
		//스택 활용: 브라우저 뒤로가기 앞으로가기
		
	} // main
	
}
