package days14;

public class Person {
	// 필드
	private String name;
	private int age;
	private boolean gender;
	// Alt + Shift +s
	// getter, setter 선언

	public Person() {
		//디폴트 생성자
	}
	
	public Person(boolean b) {
		gender = b;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int n) {
		if (0 <= n && n <= 130) {
			age = n;
		} else {
			// 강제로 예외(오류) 발생
			// throw - 강제로 에외 던지다
			throw new RuntimeException("Person.age 0~130 실행오류!!");
		} // else

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//gender 필드는 읽기 전용으로만 사용
	public boolean isGender() {
		return gender;
	}

//	public void setGender(boolean gender) {
//		this.gender = gender;
//	}

}
