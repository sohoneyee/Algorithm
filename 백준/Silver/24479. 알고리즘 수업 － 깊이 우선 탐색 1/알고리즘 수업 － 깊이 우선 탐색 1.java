import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r, score;
	static int[] order;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		order = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		} // 입력 끗

		for (int i = 0; i < n + 1; i++) {
			Collections.sort(list[i]);
		}
//		System.out.println(Arrays.toString(list));

		score = 1;
		dfs(r);
		
		for(int i=1; i<n+1; i++) {
			System.out.println(order[i]);
		}
	} // main

	public static void dfs(int x) {
		visited[x] = true;
		order[x] = score++;
		for (int c : list[x]) {
			if (visited[c])
				continue;
			dfs(c);
		}
	} // dfs

}
