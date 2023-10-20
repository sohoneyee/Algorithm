import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a, b;
	static long ans;
	static long[] out, arr;
	static boolean[] visited;
	static Queue<long[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		visited = new boolean[b + 1];

		bfs(a);

		if (ans == 0)
			System.out.println(-1);
		else
			System.out.println(ans);
	} // main

	public static void bfs(int x) {
		q.add(new long[] { x, 1 });
		visited[x] = true;
		;

		main: while (!q.isEmpty()) {
			out = q.poll();
//			int num = out[0];
//			int depth = out[1];

			arr = new long[2];
			arr[0] = out[0] * 2;
			arr[1] = Long.parseLong(out[0] + "1");
//			System.out.println(Arrays.toString(arr) + out[1]);

			for (int i = 0; i < 2; i++) {
				if (arr[i] == b) {
					ans = out[1] + 1;
					break main;
				}
				// 이미 방문했거나 범위를 벗어났다면 넘겨
				if (arr[i] > b) {
					continue;
				}
				if (visited[(int) arr[i]])
					continue;
				q.add(new long[] { arr[i], out[1] + 1 });
				visited[(int) arr[i]] = true;
			}
		}
	} // bfs
}