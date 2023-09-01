package days23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Ex04 {

	public static void main(String[] args) {
		
	ArrayList<Integer> a = new ArrayList<>();
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(5);
	ArrayList<Integer> b = new ArrayList<>();
	b.add(4);
	b.add(5);
	b.add(6);
	b.add(7);
	b.add(8);
	
	//	a U b 합집합
//	ArrayList<Integer> hap = new ArrayList<>();
//	hap.addAll(a);
//	Iterator<Integer> ir = b.iterator();
//	while (ir.hasNext()) {
//		Integer i = ir.next();
//		if (!a.contains(ir)) {
//			hap.add(i);
//		} //if
//	}
	
	HashSet<Integer> hap = new LinkedHashSet<>();
	hap.addAll(a);
	hap.addAll(b);
	System.out.println(hap);
	
	//	a - b 차집합
	//cha
//	HashSet<Integer> cha = new LinkedHashSet<>(a);
//	Iterator<Integer> ir = cha.iterator();
//	while (ir.hasNext()) {
//		Integer i =  ir.next();
//		if (b.contains(i)) {
//			
//		} //if
//	}
	
	HashSet<Integer> cha = new LinkedHashSet<>();
	HashSet<Integer> kyo = new LinkedHashSet<>();
//	차집합
	cha.addAll(a);
	cha.removeAll(b);
	// 교집합
	kyo.addAll(a);
	kyo.removeAll(cha);
	
//	Iterator<Integer> ir = a.iterator();
//	while (ir.hasNext()) {
//		Integer i =  ir.next();
//		if (!b.contains(i)) cha.add(i);		//	차집합
//		else kyo.add(i);							// 교집합
//	}
	System.out.println(cha);		//123
	//	a와 b 교집합	
	System.out.println(kyo);		//4,5
	} // main
	
}
