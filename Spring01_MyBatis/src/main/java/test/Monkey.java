package test;

public class Monkey {

	// 필드
	private String location;
	private int height;
	
	
	// 생성자
	public Monkey() {
		System.out.println("Monkey 생성자 호출됨");
	}
	
	// setter 메소드
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}
