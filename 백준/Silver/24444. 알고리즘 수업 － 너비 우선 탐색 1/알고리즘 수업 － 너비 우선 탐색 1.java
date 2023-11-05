import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r;
	static int[] order;
	static List<Integer>[] list;
	static boolean[] visited;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 정점의 수
		m = Integer.parseInt(st.nextToken()); // 간선의 수
		r = Integer.parseInt(st.nextToken()); // 시작 정점
		visited = new boolean[n + 1]; // 방문처리 배열
		list = new ArrayList[n + 1];
		order = new int[n]; // 방문 순서 출력
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(list[i]);
		}

		q = new LinkedList<Integer>();
		q.add(r);
		bfs(r);
		for (int c : order)
			System.out.println(c);
	} // main

	public static void bfs(int x) {
		int k = 1;

		while (!q.isEmpty()) {
			int from = q.poll();
			visited[from] = true;
			order[from - 1] = k++;
			for (int c : list[from]) {
				if (visited[c])
					continue;
				visited[c] = true;
				q.add(c);
			}
		}
	} // bfs
}
