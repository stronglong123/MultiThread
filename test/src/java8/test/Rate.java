package java8.test;

public class Rate {

	private static final int N = 5;

	public static void main(String[] args) {
		int size = 0;
		int i = 1;
		int k = 0;
		
		do {
			k += 10 * i;
			i++;
			size++;
		} while (i <= N - 1);

		System.out.println("频率:" + size);
		
		

		size = 0;
		i = 1;
		k = 0;
		
		while (i <= N - 1) {
			k += 10 * i;
			i++;
			size++;
		}

		System.out.println("频率:" + size);
		

		size = 0;
		i = 1;
		k = 0;
		while (i <= N - 1) {
			i++;
			k += 10 * i;
			size++;
		}

		System.out.println("频率:" + size);

		size = 0;
		i = 1;
		k = 0;
		int j = 0;
		for (i = 1; i <= N; i++) {
			for (j = i; j <= N; j++) {
				k++;
				size++;
			}

		}

		System.out.println("频率:" + size);

		size = 0;
		i = 1;
		j = 0;
		while (i + j <= N) {
			size++;
			if (i > j)
				j++;
			else
				i++;
		}

		System.out.println("频率:" + size);

		size = 0;
		int x = N;
		int y = 0; // n是不小于1的常数
		while (x >= (y + 1) * (y + 1)) {
			y++;
			size++;
		}

		System.out.println("频率:" + size);

		size = 0;
		x = 91;
		y = 100;
		while (y > 0) {
			size++;
			if (x > 100) {
				x -= 10;
				y--;
			} else
				x++;
		}

		System.out.println("频率:" + size);

	}

}
