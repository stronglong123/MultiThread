package java8.test;

import java.util.Stack;

public class test {

	void waitForSignal() throws InterruptedException
	{
	    Object obj = new Object();
	    synchronized(Thread.currentThread())
	    {
	        obj.wait();
	        obj.notify();
	    }
	}

	public test() {
		System.out.println("test");
	}

	public test(int a) {
		System.out.println("a");

	}

	public test(int a, int b) {

		System.out.println("a");
		System.out.println(b);

	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		
	
		test test = new test();

		test.push(1);
		test.push(2);
		test.push(3);
		test.pop();
		test.pop();
		test.push(4);
		test.pop();
		test.push(5);
		test.pop();
		test.pop();

	}

	public void push(int node) {
		stack1.push(node);

	}

	public int pop() {

		if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("queus is empty");
		}

		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}

		Integer pop = stack2.pop();

		System.out.println(pop);
		return pop;

	}

}
