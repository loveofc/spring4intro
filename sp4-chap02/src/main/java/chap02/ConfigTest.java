package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTest {
	
	@Bean
	public Greeter2 greeter2() {
		Greeter2 g2 = new Greeter2();
		g2.setFormat("%s, 하이");
		return g2;
	}
}
