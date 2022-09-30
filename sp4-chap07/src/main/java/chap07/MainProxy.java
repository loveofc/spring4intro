package chap07;

public class MainProxy {

	public static void main(String[] args) {

		ExeTimeCalculator cla1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(cla1.factorial(20));
		
		ExeTimeCalculator cla2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(cla2.factorial(20));

	}

}
