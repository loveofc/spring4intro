package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// XML 파일로부터 설정 정보를 읽어와 빈 객체를 생성하고 관리하는 기능제공
		// GenericXmlApplicationContext 객체를 생성할 때 앞서 작성한
		// classpath:applicationContext.xml 파일 경로를 생성자 파라미터로 전달하는데,
		// 이 경우 GenericXmlApplicationContext는 classpath:applicationContext.xml에 정의한
		// <bean> 설정 정보를 읽어와 내부적으로
		// Greeter 객체를 생성하고 초기화한다.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//getBean()메서드는 GenericXmlApplicationContext가 XML 파일을 읽어와 생성한 빈 객체를 검색할 때 사용된다.
		//첫번째 파라미터는 bena 태그의 id 속성 이름을, 두 번째 파라미터는 검색할 빈 객체의 타입이다.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		//아래 코드의 내부는 String.format("%s,안녕하세요!","스프링") 코드이다
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();

	}

}
