package days16;

public class Ex08 {

	public static void main(String[] args) {

	} // main
}

//자바 ~~able 인터페이스
interface Movable {
	// 1.상수
	// 2. 추상메서드
	// 3. default, static 메서드

	void move(int x, int y); // public abstract
}

interface Attackable {
	void attack(Unit unit);
}

//인터페이스 끼리 상속이 가능 하고 다중 상속도 가능
interface Fightable extends Attackable, Movable{
	// 추상메서드
}

abstract class Unit {
	int currentHP; // 현재 유닛의 체력
	int x; // 현재 유닛의 x좌표
	int y; // 현재 유닛의 y좌표
}

//공중 유닛
class AirUnit extends Unit {

}

//지상 유닛
class GroundUnit extends Unit {

}

//군인
class Fighter implements Fightable {// move(), attack()

	@Override
	public void attack(Unit unit) {
		// 총
	}

	@Override
	public void move(int x, int y) {
		// 움직이는
	}
}
//수리가 가능한 유닛
//상수 x 추상메서드x
interface Repairable{}

class Tank extends GroundUnit implements Fightable, Repairable {

	@Override
	public void attack(Unit unit) {
		// 포 쏘는 공격
	}

	@Override
	public void move(int x, int y) {
		// 움직이는
	}
	
}

//SCV
// 수리 가능: Repairable 인터페이스 구현한 클래스 , Tank
//	수리 불가능: Fighter
class SCV extends GroundUnit implements Repairable{
	SCV(){}
	//건물 짓기 메서드
	// 수리 하는 메서드
	void repair(Repairable unit) {
		if (unit instanceof Tank) {
			//tank 수리 코딩
		} else if(unit instanceof SCV) {
			//SCV 수리 코딩
		}else if(unit instanceof DropShip) {
			//DropShip 수리 코딩
		}
	}
}

//탱크 무기 등등 수송선
class DropShip extends AirUnit implements Fightable, Repairable{

	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attack(Unit unit) {
		
	}
	
}