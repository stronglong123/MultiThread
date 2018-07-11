package java8.test;

public class Solution {
	public static int total = 0;

	public static void main(String[] args) {
		Object o = new Object() {
			public boolean equals(Object obj) {
				return true;
			}
		};
		System.out.println(o.equals("Fred"));

		Solution solution = new Solution();

		// for (int i = 0; i <= 10; i++) {
		// int result = solution.Fibonacci2(i);
		// int result1 = solution.Fibonacci3(i);
		// System.out.print("" + result);
		// System.out.print(":" + result1);
		// System.out.println();
		// }

		// solution.JumpFloor(11);
		// int[] array= {1,1,1,1,1,1,1,1,1,2};
		// solution.perm(array, 0, 10);
		solution.JumpFloor2(29);
	}

	public int Fibonacci(int n) {
		int result = 0;
		if (n == 1 || n == 2) {
			result = 1;
		}

		if (n >= 3) {
			result = Fibonacci(n - 1) + Fibonacci(n - 2);
		}

		return result;
	}

	public int Fibonacci2(int n) {
		int result = 0;

		int pre = 0;
		int mid = 1;
		if (n <= 1) {
			return n;
		}

		for (int i = n - 1; i > 0; i--) {
			result = pre + mid;
			pre = mid;
			mid = result;
		}

		return result;
	}

	public int Fibonacci3(int n) {

		int pre = 0;
		int mid = 1;

		while (--n >= 0) {
			mid += pre;
			pre = mid - pre;
		}

		return pre;
	}

	public int JumpFloor(int target) {
		int num = 0;
		for (int x = 0; x <= target; x++) {
			for (int y = 0; y <= target / 2; y++) {
				if (x + 2 * y == target) {
					++num;
					System.out.println("第" + num + "轮");
					System.out.println("x:" + x + " Y:" + y);
					count(x, y);
					System.out.println("总数" + total);
					total += total;

				}
			}
		}

		return 0;
	}

	public void count(int x, int y) {

		int[] array = new int[x + y];
		for (int i = 0; i < x + y; i++) {
			if (i < x) {
				array[i] = 1;
			} else {
				array[i] = 2;
			}
		}
		System.out.println("开始计算");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("-----------------");
		perm(array, 0, x + y);

	}

	public void perm(int[] array, int start, int end) {

		if (start == end) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			total++;
		} else {
			for (int i = start; i < end; i++) {
				if (isSwap(array, start, i)) {
					swap(array, start, i);
					perm(array, start + 1, end);
					swap(array, start, i);
				}
			}

		}

	}

	public Boolean isSwap(int[] array, int start, int end) {
		for (int i = start; i < end; i++) {
			if (array[i] == array[end]) {
				return false;
			}
		}
		return true;
	}

	public void swap(int[] array, int i, int j) {
		int temp = 0;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	public int JumpFloor2(int target) {
		int num = 0;
		int two;
		for (two = 0; two <= target / 2; two++) {
			num += count2(target - 2 * two, two);
		}
		return num;
	}

	public int count2(int x, int y) {
		long total = 1l;
		if (x == 0 || y == 0) {
			return 1;
		}

		for (int i = x + y; i > 0; i--) {
			total *= i;
			if (i <= x) {
				total /= i;
			}
			if (i <= y) {
				total /= i;
			}
		}
		return (int) total;
	}

}
