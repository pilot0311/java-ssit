package days14;

public class Car {

	// 필드
	String name;
	String gearType;
	int door;
	//엔진 필요
	private Engine engine;// = new Engine();//명시적 초기화	결합력이 높은 코딩 -> 나쁜 코딩
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	// 생성자
	Car() {
		//3생성자 초기화
		//this.engine = new Engine();
	}
	public Car(Engine engine) {
		this.engine = engine;
	}
	{
		//인스턴스 초기화
		// this.engine = new Engine();
	}
	
	// 메서드
	void speedUp(int fuel) {
		this.engine.moreFuel(fuel);
	}

	void speedDown(int fuel) {
		this.engine.lessFuel(fuel);
	}

	void stop() {
		this.engine.stop();
	}
}
