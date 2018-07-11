package java8.test;

public class LambdaTest {

	static String Hello = "Hello!";

	public static void main(String[] args) {
		LambdaTest test = new LambdaTest();

		int num = 12;
		Converter add = (int i) -> i+12;
		System.out.println(add.convert(5));
		num=1;
		
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation sub = (a, b) -> a - b;
		MathOperation mul = (int a, int b) -> {
			return a * b;
		};
		MathOperation div = (int a, int b) -> a / b;
		System.out.println(addition.operation(5, 10));
		System.out.println(test.operate(10, 5, addition));
		System.out.println(test.operate(10, 5, sub));
		System.out.println(test.operate(10, 5, mul));
		System.out.println(test.operate(10, 5, div));

		GreatingService greatingService1 = message -> System.out.println("hello , " + message);
		greatingService1.sayMessage("Li");

		GreatingService greatingService2 = message -> System.out.println(Hello + message);
		greatingService2.sayMessage("Wang");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreatingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public interface Converter {
		int convert(int i);
	}

}
