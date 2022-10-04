package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();

		ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigTest.class);
		Greeter2 g2 = ac.getBean("greeter2", Greeter2.class);
		String msg2 = g2.greet("스프링4");
		System.out.println(msg2);
		((ConfigurableApplicationContext) ac).close();

	}
}
