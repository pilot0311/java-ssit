package days22_t.days22;

/**
 * @author kenik
 * @date 2023. 8. 11. - 오후 12:47:12
 * @subject
 * @content
 */
public class Ex08 {

	public static void main(String[] args) {
		// 2:00 수업시작~
		// [ LinkedList 컬렉션 클래스 ]
		// 1. 배열
		//    (1) 장점 - 읽기 성능이 가장 빠르다.
		//    (2) 단점 - 배열크기X, 삽입, 삭제 무지 속도 느리다.
		//      메모리상에  동일한 자료형으로 연속적으로 놓이게 한 것.
		
		// 2. 링크드리스트
		//    (특징) 비연속적
		//    (1) ArrayList, Vector + [E]lement(요소)
		//    (2) Node(노드)
		//        각 노드들은 연결되어져 있다.
		//       [Node]      [0x100]Node]    [0x200Node]
		//       0x100        0x200           0x300
		//             
		//      단방향 환형 링크드리스트
		//      더블(양)방향 환형 링크드리스트		
		
		//      환형 링크드리스트  
		Node node1 = new Node();
		node1.value = 10; 
		Node node2 = new Node();
		node2.value = 20;
		node1.next = node2;
		
		Node node3 = new Node();
		node3.value = 30;
		node2.next = node3;
		
		Node node4 = new Node();
		node4.value = 40;
		node3.next = node4;
		
		// 노드2와 노드3 사이에  노드5를 [삽입]
		Node node5 = new Node();
		node5.value = 50;
		node2.next = node5;
		node5.next = node3;
		
		// node3 삭제
		node5.next = node4;
		
		// node4 삭제
		node5.next = null;
		
		
	
		

	} // main

} // class


class Node{
	int value; // 값
	Node next = null; // 다음 노드의 주소를 참조 필드
	// Node prev = null; // 이전 노드의 주소를 참조 필드
}



