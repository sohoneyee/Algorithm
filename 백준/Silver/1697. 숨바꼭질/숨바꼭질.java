import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 5 -> 17로 가는 방법
	// 5(4,6,10) -> 4(3,5,8) 6(5,7,12) -> 10(9,11,20) ...
	// bfs 이용해야 함!!

	static int n, m, ans;
	static int[] arr;
	static int[] check;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 수빈
		m = Integer.parseInt(st.nextToken()); // 동생

		q = new LinkedList<>();
		check = new int[200001];
		bfs(n);

		// cnt는 res의 개수 -> 1 3 9 27 81 ... 순으로 각 단계마다 배열이 생김
		// 따라서 ans는 몇 번째 단계에 위치하는지를 찾아야함
		if (n == m)
			System.out.println(0);
		else
			System.out.println(ans);
	} // main

	public static void bfs(int x) {
		q.add(new int[] { x, 0 });
		check[x] = 1;

		main: while (!q.isEmpty()) {
			int[] out = q.poll();
//			System.out.println("out " + Arrays.toString(out));
			int num = out[0];
			int depth = out[1];

			arr = new int[3];
			arr[0] = num - 1;
			arr[1] = num + 1;
			arr[2] = 2 * num;
//			System.out.println("arr " + Arrays.toString(arr));
//			System.out.println();

			for (int i = 0; i < 3; i++) {
//				System.out.println("arr[i]: " + arr[i]);
				if (arr[i] == m) {
					ans = depth + 1;
					break main;
				}
				if (arr[i] < 0 || arr[i] >= check.length || check[arr[i]] == 1)
					continue;
				q.add(new int[] { arr[i], depth + 1 });
				check[arr[i]] = 1;
			}
		}
	} // bfs
}