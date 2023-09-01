package days16;

//The type K_Engine cannot be a superinterface of K_Engine2; a superinterface must be an interface  클래스를 상속시 extends
public class K_Engine2 extends K_Engine {

	//int speed;
	
	@Override
	public void moreFuel(int fuel) {
		this.speed += fuel*0.12;

	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -= fuel*0.12;

	}

	@Override
	public void stop() {
		this.speed = 0;

	}

}
