import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static boolean flag;
	static Long max, min;
	static String ans, smax, smin;
	static String[] str;
	static int[] nums, choose;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
//        System.out.println(Arrays.toString(str));
		nums = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		choose = new int[k + 1];
		visited = new boolean[10];

		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;

		perm(0);

		System.out.println(smax);
		System.out.println(smin);

	} // main

	public static void perm(int idx) {
		if (idx == k + 1) {
//			System.out.println(Arrays.toString(choose));
			arrow();
//			System.out.println(flag);
			if (flag) {
				for (int n : choose) {
					ans += n;
				}
				if (max < Long.parseLong(ans)) {
					max = Long.parseLong(ans);
					smax = ans;
				}
				if (min > Long.parseLong(ans)) {
					min = Long.parseLong(ans);
					smin = ans;
				}
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (visited[i])
				continue;
			choose[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	} // perm

	public static void arrow() {
		flag = true;
//        System.out.println();
//        System.out.println(flag);
		ans = "";
		int s = 0;
		int c = 0;
		loop: while (s < k) {
//            System.out.println(choose[c] + " " + str[s] + " " + choose[c + 1]);
			switch (str[s]) {
			case ">":
				if (choose[c] < choose[c + 1]) {
					flag = false;
					break loop;
				}
				break;
			case "<":
				if (choose[c] > choose[c + 1]) {
					flag = false;
					break loop;
				}
				break;
			}
			s++;
			c++;
		} // while
	} // arrow

}
