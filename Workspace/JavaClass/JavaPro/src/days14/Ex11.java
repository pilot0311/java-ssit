package days14;

public class Ex11 {

	public static void main(String[] args) {
		Document doc1 = new Document();
		Document doc2 = new Document();
		Document doc3 = new Document("자바문서.txt");
		Document doc4 = new Document();
		Document doc5 = new Document();
	} // main
}

//문서
class Document {
	String fileName;
	static int count = 1;
	
	{
		
		count++;
		System.out.println("인스턴스 초기화 블록 실행");
		
	}

	public Document() {
		//Cannot refer to an instance field count while explicitly invoking a constructor  생성자를 명시적으로 호출할때 참조 불가
		this( String.format("Noname%d.txt", count));
	
		//Constructor call must be the first statement in a constructor  = this()는 첫번째 라인에 와야함
		
	}

	public Document(String fileName) {
		this.fileName = fileName;
		System.out.printf("문서 \"%s\"가 생성되었습니다\n",this.fileName);
		
	}
}