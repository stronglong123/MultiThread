package java8.test;

import java.lang.reflect.Method;

public class reflectTest {

	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("java8.test.Reflect");
			Class class2 = PaymentBill.class;

//			Method method = class1.getMethod("main",args.getClass());
//			System.out.println(method.getName());
//			method.invoke(class1.newInstance(),args);
			
			Method method1 = class1.getMethod("method01");
			method1.invoke(class1.newInstance());
			
			String str=new String("hello");
			str+='a';
			str+=100;
			System.out.println(str);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
