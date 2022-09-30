package aspect;

import org.springframework.context.support.GenericXmlApplicationContext;
import chap07.Calculator;

public class MainXmlPojo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
		Calculator impeCal = ctx.getBean("impeCal",Calculator.class);
		long fact1 = impeCal.factorial(5);
		System.out.println(fact1);
		
//		Calculator impeCa2 = ctx.getBean("recCal",Calculator.class);
//		long fact2 = impeCa2.factorial(5);
//		System.out.println(fact2);
	}
}
