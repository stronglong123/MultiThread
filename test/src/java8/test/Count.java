package java8.test;

import java.util.ArrayList;
import java.util.Stack;

public class Count {

	public static void main(String[] args) {
		// for (int i = 10; i < 1000; i++) {
		// if (50 * (Math.log(i) / Math.log(2)) <= i) {
		// System.out.println("第" + i + "轮");
		// System.out.println(Math.log(i));
		// System.out.println(Math.log(2));
		// System.out.println(" " + 50 * (Math.log(i) / Math.log(2)));
		// System.out.println(" " + i);
		// return;
		// }
		// System.out.println(i);
		// }
		int target = 7;
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 6, 10, 13 }, { 6, 8, 11, 15 } };

		Boolean flag = Find(target, array);
		System.out.println("是否找到:" + flag);

		StringBuffer str = new StringBuffer();
		str.append("We Are Happy");
		System.out.println(replaceSpace(str));

	}

	public static boolean Find(int target, int[][] array) {
		// int row = 0;
		// for (int i = 0; i < array.length; i++) {
		// row = array[0].length;
		// for (int j = 0; j < array[i].length; j++) {
		// if (array[i][j] < target && array[i][row-1] < target) {
		// break;
		// } else if (array[i][j] < target && array[i][row-1] > target) {
		// continue;
		// } else if (array[i][j] == target) {
		// return true;
		// }
		// }
		// }
		int row = 0;
		int col = array.length - 1;
		while (col >= 0 && row <= array[0].length - 1) {
			if (array[col][row] == target) {
				return true;
			} else if (target > array[col][row]) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

	public static String replaceSpace(StringBuffer str) {

		StringBuffer aBuffer = new StringBuffer();

		char[] array = str.toString().toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				aBuffer.append("%20");
			} else {
				aBuffer.append(array[i]);
			}
		}

		return aBuffer.toString();
	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		// if (listNode != null) {
		// if (listNode.next != null) {
		// printListFromTailToHead(listNode.next);
		// }
		// list.add(listNode.val);
		// }
		help(listNode, list);
		return list;
	}

	public static ArrayList<Integer> help(ListNode listNode, ArrayList<Integer> list) {
		if (listNode != null) {
			if (listNode.next != null) {
				printListFromTailToHead(listNode.next);
			}
			list.add(listNode.val);
		}

		return list;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
		TreeNode tNode = null;
		int[] right = null;
		int[] left = null;
		if (pre != null) {
			tNode.val = pre[0];
		}
		int ban = 0;
		for (int i = 0; i < in.length; i++) {
			Boolean flag = false;

			if (in[i] == pre[i]) {
				flag = true;
				ban = i + 1;
			}

			if (!flag) {
				left[i] = in[i];
			} else {
				right[i - ban] = in[i];
			}
		}

		return null;
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}

	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);

		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
				break;
			}

		return root;
	}

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree3(int[] pre, int[] in) {
		TreeNode treeNode = reConstructBinaryTree3(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return treeNode;

	}

	private TreeNode reConstructBinaryTree3(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn) {
			return null;
		}
		TreeNode treeNode = new TreeNode(pre[startPre]);
		for (int i = 0; i < in.length; i++) {
			if (pre[startPre] == in[i]) {
				treeNode.left = reConstructBinaryTree3(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				treeNode.right = reConstructBinaryTree3(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
				break;
			}
		}

		return treeNode;

	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

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

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return array[0];
	}

	public int minNumberInRotateArray2(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;

		while (array[right] < array[left]) {
			int mid = (right + left) / 2;
			if(array[mid]<array[left]) {
				right=mid;
			}

		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return array[0];
	}

}
