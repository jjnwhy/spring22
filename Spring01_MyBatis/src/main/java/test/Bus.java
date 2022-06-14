package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Controller, @Service, @Repository, @Component 등의 어노테이션을 클래스에 붙이고
// component scan을 하게되면 자동으로 객체 생성이 되고 spring bean container에서 관리가 된다.
@Component
public class Bus {
	
	/*
	 *  spring bean container 에 Monkey type의 객체가 있으면 자동으로 주입된다.
	 *  < Dependency Injection(DI) >
	 */

	// 의존객체가 자동으로 주입된다.
	@Autowired
	private Monkey m;
	
	public Bus() {
		System.out.println("Bus 생성자 호출됨");
	}
}
