package java8.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflect {

	public static void main(String[] args) {
		Reflect reflect = new Reflect();

		try {
			Class class1 = Class.forName("java8.test.PaymentBill");
			System.out.println("name1:" + class1.getName());
			Class class2 = new PaymentBill().getClass();
			System.out.println("name2:" + class2.getName());
			Class class3 = PaymentBill.class;
			System.out.println("name3:" + class3.getName());

			// 获取继承类
			System.out.println("super: " + class1.getSuperclass().getName());

			// 获取实现类
			System.out.println("interface: " + class1.getInterfaces()[0].getName());

			// 获取每个构造函数所需要的参数类型信息
			reflect.getContructAllTypes(class1);

			// 获取类的所有属性
			reflect.getAllTypes(class1);

			reflect.getAllTypes(class1.getInterfaces()[0]);

			System.out.println();
			reflect.getAllMethods(class1);

			System.out.println();
			reflect.getAllMethods(Reflect.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void getAllTypes(Class class1) {

		System.out.println();
		// 获取类的所有属性
		Field[] fields = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			System.out.println(field.getName());
			// 获取修饰权限符
			int mo = field.getModifiers();
			System.out.println("mo: " + mo);
			String pri = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field.getType();
			System.out.println(pri + " " + type.getName() + " " + field.getName());

		}
	}

	private void getContructAllTypes(Class class1) {
		System.out.println();
		// 获取每个构造函数所需要的参数类型信息
		Constructor[] constructors = class1.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Constructor constructor = constructors[i];
			// getParameterTypes():获取构造函数参数类型
			Class[] types = constructor.getParameterTypes();

			for (int j = 0; j < types.length; j++) {
				System.out.print(types[j].getName() + " ");
			}

		}

	}

	private void getAllMethods(Class class1) {

		Method[] methods = class1.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			// 获取参数类型
			Class<?>[] parameterTypes = method.getParameterTypes();
			// 返回类型
			Class<?> returnType = method.getReturnType();

			int modifiers = method.getModifiers();

			System.out.print("Modifier: " + Modifier.toString(modifiers));
			System.out.print(" " + returnType);
			System.out.print(" " + method.getName());
			System.out.println("(");
			for (int j = 0; j < parameterTypes.length; j++) {
				Class<?> para = parameterTypes[j];
				System.out.print(para.getName() + " " + "arg" + j);
				if (j < parameterTypes.length - 1) {
					System.out.println(")");
				}
			}
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			if (exceptionTypes.length > 0) {
				System.out.print(") throws ");
				for (int k = 0; k < exceptionTypes.length; k++) {
					Class<?> exce = exceptionTypes[k];
					System.out.print(exce.getName() + " ");
					if (k < exceptionTypes.length - 1) {
						System.out.println(",");
					}
				}
			} else {
				System.out.print(")");
			}
			System.out.println();
		}
	}

	public void method01() {
		System.out.println("ReflectClass_01");
	}

}
